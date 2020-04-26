<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/style.css" rel="stylesheet">

    <style>
        body {
            background-image: url("../../bootstrap-4.3.1/assets/img/bg3.jpg");
            background-repeat: no-repeat;
            background-attachment: scroll;

        }
    </style>

</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="#">Arkham-Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/consoles/admin">Consoles</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link " href="/videogames/admin">Videogames</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/admin">Admin</a>
            </li>
        </ul>
    </div>
</nav>

<h1 class="jumbotron text-center">${videogame.name}</h1>

<main role="main" class="container">

    <div class="cover-videogame">

        <figure class="figure">
            <img src="../../bootstrap-4.3.1/assets/img/${videogame.image}" class="figure-img img-fluid rounded" alt="cover" width="500px" height="350px" >
        </figure>

    </div>

    <div class="card-videogame-developer bg-dark text-white" style="width: 350px; height: 505px;" >
        <img src="../../bootstrap-4.3.1/assets/img/${videogame.developer}.jpg" class="card-img-top" alt="developer" width="300px" height="250px">
        <div class="card-body">
            <h3 class="card-title">${videogame.developer}</h3>
            <p class="card-text">${videogame.developer} launched ${videogame.name} in ${videogame.releasedDate?date}, the genre of this game is ${videogame.genre}, also has a rating of ${videogame.rating} according to the metacritics page.</p>
            <a href="https://en.wikipedia.org/wiki/Bandai_Namco_Entertainment" class="btn btn-primary">Learn more</a>
        </div>
    </div>


</main>
<footer class="footer-container-1">
    <p class="float-right"><a href="#">Back to top</a></p>
    <p class="logo">&copy; Arkham-Store 2019</p>
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../bootstrap-4.3.1/assets/js/vendor/popper.min.js"></script>
<script src="../../bootstrap-4.3.1/dist/js/bootstrap.min.js"></script>
</body>
</html>
