package ch.fhnw.youbarter

import com.mycompany.myapp.User

class Article {
    String name
    String description
    User user
    Category category
    byte[] screenshot
    static hasMany = [offers: Offer, categories: Category]
    static belongsTo = [Category]
    static mappedBy = [categories: "articles"]

    static constraints = {
        screenshot(maxSize:1073741824) // max 4GB file
    }

    String toString() {
        return name
    }

    List<Category> getCategories() {
        return categories
    }
}
