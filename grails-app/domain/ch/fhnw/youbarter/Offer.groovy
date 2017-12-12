package ch.fhnw.youbarter

import com.mycompany.myapp.User

class Offer {
    static belongsTo = [offerer: User, article: Article]
    Date posted = new Date()
    String message
    Article offeredArticle

    static constraints = {
        message nullable: true
    }

    Offer(User offerer, Article article) {
        this.offerer = offerer
        this.article = article

        this.posted = new Date()
    }
}
