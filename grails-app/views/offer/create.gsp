<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="design" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>YouBarter</title>
  </head>
  <body>
      <h1>Create new offer for ${article?.name}</h1>
      <p>Lorem ipsum...</p>
      <div class="container">
          <g:if test="${flash.message}">
              <div class="message alert alert-info" role="status">${flash.message}</div>
          </g:if>
          <g:hasErrors bean="${this.offer}">
              <ul class="errors alert alert-danger" role="alert">
                  <g:eachError bean="${this.offer}" var="error">
                      <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                  </g:eachError>
              </ul>
          </g:hasErrors>
          <g:form action="save">
              <fieldset class="form">
                  <f:all bean="offer" except="posted, offerer, article, offeredArticle, category"/>
                  <div class="fieldcontain required">
                      <label for="offeredArticle.id">Suggestions</label>
                      <g:select name="offeredArticle.id" from="${params.get("offeredArticle.id")}" value="1" optionKey="id" optionValue="name" />
                  </div>
                  <g:textField name="offerer.id" id="offerer" hidden="true" value="${params.get("offerer.id")}"></g:textField>
                  <g:textField name="article.id" id="article" hidden="true" value="${params.get("article.id")}"></g:textField>
                  <g:submitButton name="create" class="save btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
              </fieldset>
          </g:form>
          my params ${params}

          <br>my article: ${params.get("article.id")}
          <br>my categories: ${params.get("offeredArticle.id")}
          <br>my offerer: ${params.get("offerer.id")}
          <br>my date: ${params.get("posted_day") + "." + params.get("posted_month") + "." + params.get("posted_year")}
      </div> 
      </div> 
    </body>
</html>

