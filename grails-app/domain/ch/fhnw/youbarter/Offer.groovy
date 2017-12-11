package ch.fhnw.youbarter

import com.mycompany.myapp.User

class Offer {
    static belongsTo = [offerer: User, article: Article, category: Category]
    Date posted = new Date()

    static constraints = {
    }

    Offer(User offerer, Article article, Category category) {
        this.offerer = offerer
        this.article = article
        this.category = category
        this.posted = new Date()
    }
}
