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
                <f:display bean="article" except="offers"></f:display>
            </div>
        </div>

        <g:if test="${isOwner}">
            <g:form resource="${this.article}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.article}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </g:if>
        <g:else>
            <g:form controller="offer" action="create" method="post">
                <g:hiddenField name="articleID" id="articleID" value="${params.id}" />
                <g:submitButton name="create" action="create" class="btn btn-primary" value="${message (code:'default.create.label', args:['Offer'])}" />
            </g:form>
        </g:else>
    </body>
</html>
