<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="design" />
        <g:set var="entityName" value="${message(code: 'article.label', default: 'Article')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:if test="${flash.message}">
            <div class="alert alert-success" role="status">${flash.message}</div>
        </g:if>
        <h1><g:message code="default.show.label" args="[entityName]" /></h1>
        <h1><g:message code="YouBarter.article.show.heading" args="${article}" /></h1>
        <div id="show-article" class="content scaffold-show" role="main">
            <div class="row">
                <h2>details</h2>
                ${article.description}
                <h2>owner</h2>
                ${article.user}
                <h2>category</h2>
                ${article.category}
                <h2>accepted categories</h2>
                <h2>create offer for this article</h2>
            </div>
        </div>
        <g:form controller="offer" action="create" method="post">
            <g:textField name="offer" placeholder="Enter offer" />
            <g:hiddenField name="articleID" id="articleID" value="${params.id}" />
            <g:submitButton name="create" action="create" />
        </g:form>
        <g:form resource="${this.article}" method="DELETE">
            <fieldset class="buttons">
                <g:link class="edit" action="edit" resource="${this.article}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
            </fieldset>
        </g:form>
    </body>
</html>
