package com.mycompany.myapp
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Slf4j

@Secured('ROLE_ADMIN')
@Slf4j
class HomeController {

    def index(){}

    def info(){
        if (isLoggedIn()) {
            String name = authenticatedUser.username
            log.info(name)
            render name
        }
    }
}
