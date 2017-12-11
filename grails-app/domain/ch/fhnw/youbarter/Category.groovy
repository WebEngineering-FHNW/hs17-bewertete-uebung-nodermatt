package ch.fhnw.youbarter

class Category {
    String name
    static hasMany = [articles: Article]


    static constraints = {
        name size:5..45
    }

    String toString() {
        return name
    }
}
