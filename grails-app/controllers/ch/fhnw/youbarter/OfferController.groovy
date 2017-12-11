package ch.fhnw.youbarter

import com.mycompany.myapp.User
import grails.plugin.springsecurity.annotation.Secured

import java.time.LocalDate

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import ch.fhnw.youbarter.Article

@Transactional(readOnly = true)
class OfferController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    @Secured('ROLE_ADMIN')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Offer.list(params), model:[offerCount: Offer.count()]
    }
    @Secured("IS_AUTHENTICATED_FULLY")
    def show(Offer offer) {
        respond offer
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    def create() {

        LocalDate date = LocalDate.now()

        Article article = Article.findById(params.articleID)
        User offerer = User.findById(session.getAttribute("user"))
        params.put("article.id", article.id)
        params.put("offerer.id", offerer.id)
        params.put("posted_year", date.getYear())
        params.put("posted_month", date.getMonthValue())
        params.put("posted_day", date.getDayOfMonth())
        respond new Offer(params), model:[article: article]
    }

    @Transactional
    @Secured("IS_AUTHENTICATED_FULLY")
    def save(Offer offer) {
        log.info("invoked save")
        print("invoked save")
        print(params)
        if (offer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (offer.hasErrors()) {
            print("has errors")
            transactionStatus.setRollbackOnly()
            respond offer.errors, view:'create'
            return
        }

        offer.save flush:true


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'offer.label', default: 'Offer'), offer.id])
                redirect offer
            }
            '*' { respond offer, [status: CREATED] }
        }
    }

    def edit(Offer offer) {
        respond offer
    }

    @Transactional
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
    }

    @Transactional
    def delete(Offer offer) {

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
