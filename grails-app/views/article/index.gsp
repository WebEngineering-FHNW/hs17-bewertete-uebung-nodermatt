<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="design" />
        <g:set var="entityName" value="${message(code: 'article.label', default: 'Article')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <h1>YouBarter marketplace</h1>
        <g:form controller="Article" action="create">
            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
        </g:form>
        circle in results
        <select></select>
        <h2>all offers</h2>
        All articles: ${articleCount}

        <div class="container-fluid">
            <div class="row">
                <g:each var="article" in="${articleList}">
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