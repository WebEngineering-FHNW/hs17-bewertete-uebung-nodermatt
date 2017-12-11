<!doctype html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title>
            <g:layoutTitle default="Grails"/>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <asset:stylesheet src="bootstrap.css"/>
        <g:layoutHead/>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand active" href="#">YouBarter</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="/login/auth">login</a></li>
                    <li><a href="/signUp/">sign up</a></li>
                    <li><g:form controller="logout">
                        <g:submitButton class="btn" name="logout" value="Logout" />
                    </g:form></li>
                </ul>
            </div>
        </nav>
        <g:layoutBody/>
        <div class="footer" role="contentinfo"></div>
        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>
        <asset:javascript src="application.js"/>
    </body>
</html>
