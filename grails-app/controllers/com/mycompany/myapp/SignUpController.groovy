package com.mycompany.myapp
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class SignUpController {

    def index() { }
}
