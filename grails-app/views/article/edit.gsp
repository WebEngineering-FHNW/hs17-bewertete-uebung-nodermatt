<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="design" />
        <g:set var="entityName" value="${message(code: 'article.label', default: 'Article')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-article" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <p>isOwner: ${isOwner}</p>
        <div id="edit-article" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.article}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.article}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.article}" method="PUT" exclude="name">
                <g:hiddenField name="version" value="${this.article?.version}" />
                <fieldset class="form" exclude="name">
                    <f:all bean="article" exclude="name" />
                    <!-- exlcude category , offer user and use passed variable from controller, which is the currenlty logged in
                        also, use
                    -->
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
