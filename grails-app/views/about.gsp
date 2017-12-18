<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="layout" content="design" />
        <title>about</title>
    </head>
    <body>
        <h1>About YouBarter</h1>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <p>I created this application for the webE course at FHNW. I'm particularly proud of the following:</p>
                <ul>
                    <li>Multilingual support: I used grails integrated i18n system to display text in locales defined in application.yml. You can change the language by clicking on the <strong>categories</strong> dropdown in the navbar</li>
                    <li>Nice UI with messages that inform the user if he does something wrong</li>
                    <li>Including a custom taglib to switch between languages (copied from grails tutorials) and filter articles by category</li>
                    <li>Usage of advanced plugins like spring security boot:</li>
                    <li>Filter feature to display articles according to category of article</li>
                    <li>home view where users can see their articles and offers they made on other users articles</li>
                    <li>Architecture wise: I used services for articles and offers to check if a current user is the owner. Theoretically all CRUD operations should be in services as the controller shouldn't interact direclty with the model in MVC, nevertheless, I wanted to focus on Grails and the development of features instead.</li>
                </ul>
                <p>I didn't develop a signup page, but you can use the the credentials found in BootStrap.groovy to log in.</p>
            </div>
        </div>
    </div>

    </body>
</html>