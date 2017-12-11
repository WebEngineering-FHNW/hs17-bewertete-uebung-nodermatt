package com.mycompany.myapp
import grails.plugin.springsecurity.annotation.Secured

class SecureController {

    @Secured('ROLE_ADMIN')
    def index() {
        render "it's all safe!"
    }
}
