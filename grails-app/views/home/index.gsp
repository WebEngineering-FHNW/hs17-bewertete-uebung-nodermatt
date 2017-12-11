<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="layout" content="main"/>
        <meta charset="UTF-8">
        <asset:stylesheet src="application.css"/>
        <title></title>
    </head>
    <body>
        <h1><g:message code="app.home.title"/></h1>
        <div class="alert alert-info">my info to you ${val}</div>

        <g:include controller="home" action="info"></g:include>
        <a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
        </div>

        <h2>Meine Artikel</h2>
        <div id="list-article" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <f:table collection="${articleList}" except="user"/>

            <div class="pagination">
                <g:paginate total="${articleCount ?: 0}" />
            </div>
        </div>
        <h2>Meine Angebote</h2>
        <div id="list-offer" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <f:table collection="${offerList}" except="offerer"/>
            <div class="pagination">
                <g:paginate total="${offerCount ?: 0}" />
            </div>
        </div>
    </body>
</html>