package ch.fhnw.youbarter

import com.mycompany.myapp.User

class Article {
    String name
    String description
    User user
    Category category
    static hasMany = [offers: Offer, categories: Category]
    static belongsTo = [Category]
    static mappedBy = [categories: "articles"]

    static constraints = {
    }



    List<Category> getCategories() {
        return categories
    }
}
