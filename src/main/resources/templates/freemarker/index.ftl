<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/carousel.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/style.css" rel="stylesheet">

</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="/">Arkham-Store</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/consoles/">Consoles</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/videogames/">Videogames</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/admin">Admin</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sort by</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="/videogames/showVideogame">Best selling games</a>
                        <a class="dropdown-item" href="/consoles/showHandheldConsole">Best selling handheld consoles</a>
                        <a class="dropdown-item" href="/consoles/showHomeConsole">Best selling home consoles</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>

<main role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="first-slide" src="../../bootstrap-4.3.1/assets/img/slideshow/ps4.jpg" alt="First slide">
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1>Sony PS4</h1>
                        <p>Here is a list with the top rated PS4 games according metacritics</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="second-slide" src="../../bootstrap-4.3.1/assets/img/slideshow/xbox one.jpg" alt="Second slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Microsoft Xbox One</h1>
                        <p>Here is a list with the top rated Xbox One games according metacritics</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="third-slide" src="../../bootstrap-4.3.1/assets/img/slideshow/nintendo switch.jpg" alt="Third slide">
                <div class="container">
                    <div class="carousel-caption text-right">
                        <h1>Nintendo Switch</h1>
                        <p>Here is a list with the top rated Nintendo Switch games according metacritics</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div class="container marketing">

        <div class="row">
            <div class="col-lg-4">
                <a href="/consoles/showHomeConsole"><img class="rounded-circle" src="../../bootstrap-4.3.1/assets/img/icons/home console.jpg" alt="Generic placeholder image" width="140" height="140"></a>
                <h2>Home consoles</h2>
                <p>A home video game console, or simply home console, is a video game device that is primarily used for home gamers, as opposed to in arcades or some other commercial establishment. Home consoles are one type of video game consoles, in contrast to the handheld game consoles which are smaller and portable, allowing people to carry them and play them at any time or place.</p>
                <p><a class="btn btn-secondary" href="https://en.wikipedia.org/wiki/Home_video_game_console" role="button">Learn more &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <a href="/consoles/showHandheldConsole"><img class="rounded-circle" src="../../bootstrap-4.3.1/assets/img/icons/handheld icon.jpg" alt="Generic placeholder image" width="140" height="140"></a>
                <h2>Handheld consoles</h2>
                <p>A handheld game console, or simply handheld console, is a small, portable self-contained video game console with a built-in screen, game controls, and speakers.[1] Handheld game consoles are smaller than home video game consoles and contain the console, screen, speakers, and controls in one unit, allowing people to carry them and play them at any time or place.</p>
                <p><a class="btn btn-secondary" href="https://en.wikipedia.org/wiki/Handheld_game_console" role="button">Learn more &raquo;</a></p>
            </div>
            <div class="col-lg-4">
               <a href="/videogames/showVideogame"><img class="rounded-circle" src="../../bootstrap-4.3.1/assets/img/icons/videogame icon.jpg" alt="Generic placeholder image" width="140" height="140"></a>
                <h2>Videogames</h2>
                <p>A video game is an electronic game that involves interaction with a user interface to generate visual feedback on a two- or three-dimensional video display device such as a TV screen, virtual reality headset or computer monitor. Since the 1980s, video games have become an increasingly important part of the entertainment industry, and whether they are also a form of art is a matter of dispute.</p>
                <p><a class="btn btn-secondary" href="https://en.wikipedia.org/wiki/Video_game" role="button">Learn more &raquo;</a></p>
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">My favorite home console: <span class="text-muted">PlayStation 2</span></h2>
                <p class="lead">The PlayStation 2 (officially abbreviated as PS2) is a home video game console developed and marketed by Sony Computer Entertainment. It was first released in Japan on March 4, 2000, in North America on October 26, 2000, and in Europe and Australia in November 2000, and is the successor to the PlayStation, as well as the second video game console in the PlayStation brand. As a sixth-generation console, the PS2 competed with Sega's Dreamcast, Nintendo's GameCube, and Microsoft's Xbox. </p>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-fluid mx-auto" src="../../bootstrap-4.3.1/assets/img/icons/ps2.jpg" alt="Generic placeholder image">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7 order-md-2">
                <h2 class="featurette-heading">My favorite Handheld console: <span class="text-muted">PlayStation Portable</span></h2>
                <p class="lead">The PlayStation Portable[a] (PSP) is a handheld game console that was developed by Sony Computer Entertainment as part of the seventh generation of video-game consoles. Development of the handheld console was announced during E3 2003 and it was unveiled on May 11, 2004, at a Sony press conference before the next E3. The system was released in Japan on December 12, 2004; in North America on March 24, 2005; and in the PAL region on September 1, 2005. It competed with the Nintendo DS. </p>
            </div>
            <div class="col-md-5 order-md-1">
                <img class="featurette-image img-fluid mx-auto" src="../../bootstrap-4.3.1/assets/img/icons/psp go.jpg" alt="Generic placeholder image">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">My favorite videogame: <span class="text-muted">Kingdom Hearts Birth by Sleep</span></h2>
                <p class="lead">Kingdom Hearts Birth by Sleep (Japanese: キングダム ハーツ バース バイ スリープ Hepburn: Kingudamu Hātsu Bāsu bai Surīpu) is an action role-playing video game developed and published by Square Enix for the PlayStation Portable, serving as the sixth installment in the Kingdom Hearts series. The game was released on UMD in Japan on January 9, 2010, in North America on September 7, 2010 and in the PAL regions on September 10, 2010. An international version of the game titled Kingdom Hearts Birth by Sleep Final Mix was released in Japan in January 2011 featuring the changes made in the non-Japanese versions. </p>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-fluid mx-auto" src="../../bootstrap-4.3.1/assets/img/icons/kingdom hearts icon.png" alt="Generic placeholder image">
            </div>
        </div>

        <hr class="featurette-divider">


    </div>


</main>

<footer class="footer-container">
    <p class="float-right"><a href="#">Back to top</a></p>
    <p class="logo">&copy; Arkham-Store 2019</p>
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/dist/js/jquery-3.2.1.slim.min.js"><\/script>')</script>
<script src="../../bootstrap-4.3.1/assets/js/vendor/popper.min.js"></script>
<script src="../../bootstrap-4.3.1/dist/js/bootstrap.min.js"></script>
<script src="../../bootstrap-4.3.1/assets/js/vendor/holder.min.js"></script>

</body>
</html>
