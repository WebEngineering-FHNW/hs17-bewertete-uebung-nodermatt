package com.mycompany.myapp

import ch.fhnw.youbarter.Article
import ch.fhnw.youbarter.Offer
import ch.fhnw.youbarter.Category

class BootStrap {

    def init = {

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()

        def testUser = new User(username: 'me', password: 'password').save()
        def nic = new User(username: 'Nicolas', password: 'password1').save()
        def dirk = new User(username: 'Dirk', password: 'password2').save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        Category categoryClothes = new Category(name: "Clothes").save()
        Category categoryGames = new Category(name: "Games").save()
        Category categoryBooks = new Category(name: "Books").save()
        def categories = [categoryBooks, categoryClothes, categoryGames]
        Article article = new Article(name:"Playstation", description:"fun bike", user:nic, category: categoryClothes).save()
        Article article2 = new Article(name:"Hemd", description:"fun bike", user:dirk, category: categoryClothes).save()


//        assert User.count() == 1
//        assert Role.count() == 1
//        assert UserRole.count() == 1
    }
}