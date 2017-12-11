package ch.fhnw.youbarter

class Requirement {

    static belongsTo = [article:Article, category: Category
    ]
    static constraints = {
    }
}
