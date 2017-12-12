package com.mycompany.myapp

import ch.fhnw.youbarter.Article
import ch.fhnw.youbarter.Offer
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

@Secured("IS_AUTHENTICATED_FULLY")
@Slf4j
class HomeController {

    @Autowired
    SpringSecurityService springSecurityService

    @Secured("IS_AUTHENTICATED_FULLY")
    def index(){
        List<Article> articleList = Article.findAllWhere(user: springSecurityService.getCurrentUser())
        println("user: " + springSecurityService.getCurrentUser())
        println("list: " + articleList.toString())
        List<Offer> offerList = Offer.findAllWhere(offerer: springSecurityService.getCurrentUser())
        return [articleList: articleList, articleCount: articleList.size(), offerList: offerList, offerCount: offerList.size()]

    }
}
