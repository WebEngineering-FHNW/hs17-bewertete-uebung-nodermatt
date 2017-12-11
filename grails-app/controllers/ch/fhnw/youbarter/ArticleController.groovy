package ch.fhnw.youbarter

import com.mycompany.myapp.User
import com.mycompany.myapp.UserService
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ArticleController {

    @Autowired
    SpringSecurityService springSecurityService


    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def getAll(){
        List<Article> articles = Article.list()
    }

    def find(int id){
        Article item = Article.get(id)
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def index(Integer max) {
        List<Article> articles = Article.list()
        params.max = Math.min(max ?: 10, 100)
        respond Article.list(params), model:[articleCount: Article.count(), articles: articles]
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def show(Article article) {
        respond article
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    def create() {
        User user = springSecurityService.currentUser
        session.setAttribute("user", user.id)
        respond new Article(params)
    }

    @Transactional
    @Secured("IS_AUTHENTICATED_FULLY")
    def save(Article article) {
        if (article == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (article.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond article.errors, view:'create'
            return
        }

        article.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'article.label', default: 'Article'), article.id])
                redirect article
            }
            '*' { respond article, [status: CREATED] }
        }
    }

    def edit(Article article) {
        respond article
    }

    @Transactional
    def update(Article article) {
        if (article == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (article.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond article.errors, view:'edit'
            return
        }

        article.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'article.label', default: 'Article'), article.id])
                redirect article
            }
            '*'{ respond article, [status: OK] }
        }
    }

    @Transactional
    def delete(Article article) {

        if (article == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        article.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'article.label', default: 'Article'), article.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'article.label', default: 'Article'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
