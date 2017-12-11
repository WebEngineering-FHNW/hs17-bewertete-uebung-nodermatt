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
    <div class="alert alert-info">my info to you</div>

    <g:include controller="home" action="info"></g:include>

</body>
</html>