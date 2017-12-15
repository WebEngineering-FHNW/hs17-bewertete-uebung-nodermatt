<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="design" />
        <g:set var="entityName" value="${message(code: 'article.label', default: 'Article')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <h1>YouBarter marketplace</h1>
        <sec:ifNotLoggedIn>
            <div class="alert alert-danger">You are not logged in. Log in to create new articles or offers></div>
        </sec:ifNotLoggedIn>

        <g:form controller="Article" action="create">
            <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
        </g:form>
        <div class="container-fluid">
            <div class="row">
                <g:if test="${articleCount == 0}">
                    <div class="alert alert-danger"><g:message code="YouBarter.home.error.noResults"/></div>
                </g:if>
                <g:each var="article" in="${articles}">
                    <div class="col-xs-4 col-md-3">
                        <div class="panel panel-default" style="width:120px">
                            <img width="100" src="img_avatar3.png" alt="Card image">
                            <div class="panel-body">
                                <h4 class="panel-title">${article.name}</h4>
                                <p class="panel-text">${article.description}</p>
                                <a href="/article/show/${article.id}" class="btn btn-primary"><g:message code="YouBarter.home.panel.link"/></a>
                            </div>
                        </div>
                    </div>
                </g:each>
            </div>
        </div>
    </body>
</html>