<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="design" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>YouBarter</title>
  </head>
  <body>
      <h1>Create new offer</h1>
      <p>Lorem ipsum...</p>
      <div class="container">

          <g:form action="save">
              my params ${params}
              my article: ${article?.name}
              <fieldset class="form">
                  <f:all bean="offer" except="posted"/>
                  <g:submitButton name="create" class="save btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
              </fieldset>
              <fieldset class="buttons">
                  <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
              </fieldset>
          </g:form>
      </div> 
      </div> 
    </body>
</html>

