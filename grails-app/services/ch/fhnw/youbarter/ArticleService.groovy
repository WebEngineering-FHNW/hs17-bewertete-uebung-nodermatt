package ch.fhnw.youbarter

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j

@Transactional
@Slf4j
class ArticleService {

    /**
     * Verify if provided user is owner of passed article
     * @param currentUser The currently logged in user
     * @param article The article subject to verification
     * @return boolean value indicating if user is owner of article
     */
    def isOwner(User currentUser, Article article) {
        User owner = Article.findById(article.id).getUser()
        boolean isOwner = owner.equals(currentUser)
        println("current user: "+ isOwner + " is owner of: " + article)
        return owner.equals(currentUser)
    }


}
