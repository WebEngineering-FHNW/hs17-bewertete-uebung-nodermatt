package com.mycompany.myapp

import ch.fhnw.youbarter.Article
import ch.fhnw.youbarter.Category
import ch.fhnw.youbarter.Role
import ch.fhnw.youbarter.User
import ch.fhnw.youbarter.UserRole

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
        Article article = new Article(name:"Playstation", description:"fun bike", user:nic, category: categoryGames).save()
        Article article2 = new Article(name:"Hemd", description:"fun bike", user:dirk, category: categoryClothes).save()
        Article article3 = new Article(name:"Kravatte", description:"fun bike", user:nic, category: categoryClothes).save()
        Article article4 = new Article(name:"Hose", description:"fun bike", user:dirk, category: categoryClothes).save()
        Article article5 = new Article(name:"Hdr", description:"fun bike", user:nic, category: categoryBooks).save()
        Article article6 = new Article(name:"Animal Farm", description:"fun bike", user:dirk, category: categoryBooks).save()
        Article article7 = new Article(name:"Gameboy", description:"fun bike", user:nic, category: categoryGames).save()
        Article article8 = new Article(name:"Nintendo", description:"fun bike", user:dirk, category: categoryGames).save()


        assert User.count() == 3
        assert Role.count() == 2

    }
}