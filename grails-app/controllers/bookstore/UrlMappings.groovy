package bookstore

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        //custom mapping of root to Article index page
        "/"(controller:"Article")
        "/admin"(view:"/index")
        '/logout'(controller: "LogOut")
//        "/"(view:'/index')
//        "/home"(view:'/home/index')
        "500"(view:'/error')
        "404"(view:'/notFound')
        //"405"(view:'/error')
    }
}
