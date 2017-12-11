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
        <div class="alert alert-info">my info to you ${val}</div>

        <g:include controller="home" action="info"></g:include>

        <div class="nav" role="navigation">
        </div>
        <div id="list-article" class="content scaffold-list" role="main">
            <h1><g:message code="YouBarter.home.myArticles"/></h1>
            <f:table collection="${articleList}" except="user"/>

            <div class="pagination">
                <g:paginate total="${articleCount ?: 0}" />
            </div>
        </div>
        <div id="list-offer" class="content scaffold-list" role="main">
            <h1><g:message code="YouBarter.home.myOffers"/></h1>
            <f:table collection="${offerList}" except="offerer"/>
            <div class="pagination">
                <g:paginate total="${offerCount ?: 0}" />
            </div>
        </div>
    </body>
</html>