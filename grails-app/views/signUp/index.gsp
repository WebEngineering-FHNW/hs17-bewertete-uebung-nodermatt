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
        SIGN UP page
        <div class="floating" style="padding-left: 20px;">
            <g:form controller="flight" action="search" method="post">

            <g:form method="POST" controller="user" action="signup">
                <label for="title"></label>
                <br />
                <input type="text" name="title" />
                <br />
                <label for="url"></label>
                <input type="text" name="url" />
                <br />
                <!-- <input class="btn btn-primary" type="submit" value="Create"> -->
                <fieldset class="buttons">
                    <g:submitButton name="create" class="btn save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>


    </body>
</html>