<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title>
            <g:layoutTitle default="YouBarter"/>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <asset:stylesheet src="application.css"/>
        <asset:stylesheet src="design.css"/>
        <asset:javascript src="jquery-2.2.0.min.js"/>
        <asset:javascript src="bootstrap.js"/>

        <g:layoutHead/>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynav">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">YouBarter</a>
                </div>
                <div class="collapse navbar-collapse" id="mynav">
                    <ul class="nav navbar-nav">


                        <li><a href="/home" class="btn">MyBarter</a></li>
                        <li><a href="/" class="btn">Browse</a></li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><g:message code="YouBarter.design.categoryDropDown" default="Categories"/> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <a class='dropdown-item' href='/?filter=1'>Clothes</a>
                                <a class='dropdown-item' href='/?filter=2'>Games</a>
                                <a class='dropdown-item' href='/?filter=3'>Books</a>
                            </ul>
                        </li>

                        <!-- tag::navBarLocaleDropDown[] -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><g:message code="YouBarter.design.languageDropDown" default="Languages"/> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <localeNavBar:localeDropdownListItems uri="${request.forwardURI}"/>
                            </ul>
                        </li>
                        <!-- end::navBarLocaleDropDown[] -->
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <sec:ifLoggedIn>
                            <li><a href="/logout">Logout</a></li>
                        </sec:ifLoggedIn>
                        <sec:ifNotLoggedIn>
                            <li><a href="/home">Login</a></li>
                        </sec:ifNotLoggedIn>
                    </ul>
                </div>
            </div>
        </nav>
        <g:layoutBody/>
            <div id="footer">
                <div class="container">
                    <div class="row">
                        <h3 class="footertext">YouBarter was created by Nicolas Odermatt</h3>

                    </div>
                    <div class="row">
                        <p class="footertext">Copyright 2014</p>
                    </div>
                </div>
            </div>
    </body>
</html>

