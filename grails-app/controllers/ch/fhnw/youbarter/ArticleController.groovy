package ch.fhnw.youbarter

import com.mycompany.myapp.User
import ch.fhnw.youbarter.ArticleService
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ArticleController {

    @Autowired
    SpringSecurityService springSecurityService
    ArticleService articleService
    User user

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def getAll(){
        List<Article> articles = Article.list()
    }

    def find(int id){
        Article item = Article.get(id)
    }

    def isOwner() {
        user = springSecurityService.currentUser
        println("User: " + user + ", article: " + article)
        println("current user is owner: " + ArticleService.isOwner())
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    def filter() {
        Category cat = Category.findById(params.filter)
        def ax = Article.findAllWhere(category: cat) //get all articles within provided category
        return ax
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def index(Integer max) {
        def categories = Category.list()//get all categories
        List<Article> articles
        //find all where category = id or if empty all
        if(params.filter) {//if a category is passed filter articles
            articles = filter()
        } else {
            articles = Article.list()
        }
        params.max = Math.min(max ?: 10, 100)
        render(view:'index', model:[articleCount: articles.size(), articles: articles, categories: categories])
        //respond Article.list(params), model:[articleCount: articles.size(), articles: articles, categories: categories]
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def show(Article article) {
        user = springSecurityService.currentUser
        boolean isOwner
        isOwner = articleService.isOwner(user, article)

        render(view:'show', model: [article: article, isOwner: isOwner])
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    def create() {
        //set user attribute of article to currently logged in user
        user = springSecurityService.currentUser
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
                //redirect article
                redirect (controller:'Home')//redirect user to his home view
            }
            '*' { respond article, [status: CREATED] } //default, changed it to custom beavhiour below
            //redirect (controller:'Home', ){ respond article, [status: CREATED] }
        }
    }
    @Secured("IS_AUTHENTICATED_FULLY")
    def edit(Article article) {
        respond article
    }

    @Transactional
    @Secured("IS_AUTHENTICATED_FULLY")
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
                redirect (controller:'Home')//show home controller
            }
            '*'{ respond article, [status: OK] }
        }
    }

    @Transactional
    @Secured("IS_AUTHENTICATED_FULLY")
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
                redirect (controller:'Home')//show home controller
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
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
