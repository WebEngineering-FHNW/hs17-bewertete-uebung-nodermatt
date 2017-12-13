<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="design"/>
        <meta charset="UTF-8">
        <asset:stylesheet src="application.css"/>
        <title></title>
    </head>
    <body>
        <h1><g:message code="app.home.title"/></h1>
        <g:if test="${flash.message}">
            <div class="alert alert-success" role="status">${flash.message}</div>
        </g:if>
        <div class="nav" role="navigation">
        </div>
        <div id="list-article" class="content scaffold-list" role="main">
            <h1><g:message code="YouBarter.home.myArticles"/></h1>
            <g:if test="${articleCount == 0}">
                <div class="alert alert-info"><g:message code="YouBarter.home.alert.noArticles"/></div>
            </g:if>

            <f:table collection="${articleList}" properties="['id', 'offers', 'name', 'category', 'description']"/>
            <div class="pagination">
                <g:paginate total="${articleCount ?: 0}" />
            </div>
        </div>
        <div id="list-offer" class="content scaffold-list" role="main">
            <h1><g:message code="YouBarter.home.myOffers"/></h1>
            <g:if test="${offerCount == 0}">
                <div class="alert alert-info"><g:message code="YouBarter.home.alert.noOffers"/></div>
            </g:if>
            <f:table collection="${offerList}" except="offerer"/>
            <div class="pagination">
                <g:paginate total="${offerCount ?: 0}" />
            </div>
        </div>
    </body>
</html>