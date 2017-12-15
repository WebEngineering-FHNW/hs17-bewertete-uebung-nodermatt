package ch.fhnw.youbarter

import grails.config.Config
import org.springframework.context.MessageSource
import org.springframework.web.servlet.support.RequestContextUtils

import ch.fhnw.youbarter.Category

class CategoryNavBarTagLib {
    static namespace = 'categoryNavBar'

    static defaultEncodeAs = [taglib: 'none']

    Category categoryClothes = new Category(name: "Clothes")
    Category categoryGames = new Category(name: "Games")
    Category categoryBooks = new Category(name: "Books")

    List<Category> categories = [categoryBooks, categoryClothes, categoryGames]


    def categoryDropdownListItems = { args ->
        String uri = args.uri
        println("uri: " + uri)
        //localhost:8080/article/index?filter=1
        for (Category cat : categories) {
            String name = cat.name
            out << "<a class='dropdown-item' href='${uri}?filter=${cat.id}'>$name</a>"
            println(out)
        }

    }
}
