<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title>
            <g:layoutTitle default="YouBarter"/>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <asset:stylesheet src="application.css"/>
        <asset:stylesheet src="design.css"/>
        <g:layoutHead/>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynav">
                        <span class="icon-bar">MyBarter</span>
                        <span class="icon-bar">Browse</span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">YouBarter</a>
                </div>
                <div class="collapse navbar-collapse" id="mynav">
                    <ul>
                        <li><a href="/home" class="btn">MyBarter</a></li>
                        <li><a href="/" class="btn">Browse</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <sec:ifLoggedIn>
                            <li><a href="/logout">Logout</a></li>
                        </sec:ifLoggedIn>
                        <sec:ifNotLoggedIn>
                            <li><a href="/login/auth">Login</a></li>
                        </sec:ifNotLoggedIn>


                    </ul>
                </div>
            </div>
        </nav>
        <g:layoutBody/>
            <div id="footer">
                <div class="container">
                    <div class="row">
                        <h3 class="footertext">About Us:</h3>
                        <br>
                        <div class="col-md-4">
                            <center>
                                <img src="http://oi60.tinypic.com/w8lycl.jpg" class="img-circle" alt="the-brains">
                                <br>
                                <h4 class="footertext">Programmer</h4>
                                <p class="footertext">You can thank all the crazy programming here to this guy.<br>
                            </center>
                        </div>
                        <div class="col-md-4">
                            <center>
                                <img src="http://oi60.tinypic.com/2z7enpc.jpg" class="img-circle" alt="...">
                                <br>
                                <h4 class="footertext">Artist</h4>
                                <p class="footertext">All the images here are hand drawn by this man.<br>
                            </center>
                        </div>
                        <div class="col-md-4">
                            <center>
                                <img src="http://oi61.tinypic.com/307n6ux.jpg" class="img-circle" alt="...">
                                <br>
                                <h4 class="footertext">Designer</h4>
                                <p class="footertext">This pretty site and the copy it holds are all thanks to this guy.<br>
                            </center>
                        </div>
                    </div>
                    <div class="row">
                        <p><center><a href="#">Contact Stuff Here</a> <p class="footertext">Copyright 2014</p></center></p>
                    </div>
                </div>
            </div>
    </body>
</html>

