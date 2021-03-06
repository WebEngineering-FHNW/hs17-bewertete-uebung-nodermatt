package ch.fhnw.youbarter

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDate

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OfferController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Autowired
    SpringSecurityService springSecurityService
    OfferService offerService
    User user

    @Secured('ROLE_ADMIN')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Offer.list(params), model:[offerCount: Offer.count()]
    }
    @Secured("IS_AUTHENTICATED_FULLY")
    def show(Offer offer) {
        user = springSecurityService.currentUser
        boolean isOwner
        isOwner = offerService.isOwner(user, offer)
        render(view:'show', model: [offer: offer, isOwner: isOwner])
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    def create() {
        LocalDate date = LocalDate.now()
        println(params)
        Article article = Article.findById(params.articleID)
        println("fining article for id: " + params.articleID)
        //User offerer = User.findById(session.getAttribute("user"))
        User offerer = springSecurityService.getCurrentUser()
        println("finding articles of offerer" + offerer)
        List<Article> suggestions = Article.findAllWhere(user:offerer)
        println("found these: " + suggestions.toString())
        params.put("article.id", article.id)
        params.put("offerer.id", offerer.id)
        params.put("offeredArticle.id", suggestions)
        params.put("posted_year", date.getYear())
        params.put("posted_month", date.getMonthValue())
        params.put("posted_day", date.getDayOfMonth())
        respond new Offer(params)
    }

    @Transactional
    @Secured("IS_AUTHENTICATED_FULLY")
    def save(Offer offer) {
        if (offer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (offer.hasErrors()) {
            println("has errors")
            transactionStatus.setRollbackOnly()
            respond offer.errors, view:'create'
            return
        }

        offer.save flush:true


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'offer.label', default: 'Offer'), offer.id])
                //redirect offer
                redirect (controller:'Home')//show users home view after successful creation
            }
            '*' { respond offer, [status: CREATED] }
        }
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    def edit(Offer offer) {
        flash.message = message(code: 'YouBarter.offer.edit.error')
        redirect (controller:'Home')
    }

    /*
    @Transactional
    @Secured("IS_AUTHENTICATED_FULLY")
    def update(Offer offer) {
        if (offer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (offer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond offer.errors, view:'edit'
            return
        }

        offer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'offer.label', default: 'Offer'), offer.id])
                redirect offer
            }
            '*'{ respond offer, [status: OK] }
        }
    }*/

    @Transactional
    @Secured("IS_AUTHENTICATED_FULLY")
    def delete(Offer offer) {
        if(offerService.isOwner(user, offer)) {
            if (offer == null) {
                transactionStatus.setRollbackOnly()
                notFound()
                return
            }

            offer.delete flush:true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.deleted.message', args: [message(code: 'offer.label', default: 'Offer'), offer.id])
                    redirect action:"index", method:"GET"
                }
                '*'{ render status: NO_CONTENT }
            }
        } else redirect(view:'show', article: article)

    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'offer.label', default: 'Offer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
