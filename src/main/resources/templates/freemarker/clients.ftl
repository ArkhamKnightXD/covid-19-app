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

  </head>

  <body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="/">Arkham-Store</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="/consoles/admin">Consoles</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/videogames/admin">Videogames</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link " href="/clients/">Clients</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/sales/">Store</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/users/">Users</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/admin">Admin</a>
          </li>

        </ul>
        <form class="form-inline my-2 my-lg-0">
          <a class="btn btn-outline-success my-2 my-sm-0" href="/clients/creation" role="button">Add a new Client</a>
        </form>
      </div>
    </nav>

    <h1 class="jumbotron text-center">List of the clients</h1>
    <main role="main" class="container">

      <div class="starter-template table-responsive">
        <table class="table-hover table table-bordered">
          <thead class="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Picture</th>
            <th scope="col">Name</th>
            <th scope="col">Last name</th>
            <th scope="col">Address</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Options</th>
          </tr>
          </thead>

          <tbody>

          <#list clients as client >

          <tr>
            <th scope="row">${client.id}</th>
            <td><img src="../../bootstrap-4.3.1/assets/img/store/clients/${client.photo}" width="110px" height="110px"></td>
            <td>${client.name}</td>
            <td>${client.lastName}</td>
            <td>${client.address}</td>
            <td>${client.phone}</td>
            <td>${client.email}</td>
            <td>
              <a href="/clients/edition/?id=${client.id}">  <i class="fa fa-edit" style="font-size:25px"></i></a>
              <a href="/clients/delete/?id=${client.id}">  <i class="fa fa-trash" style="font-size:25px;color:red"></i> </a>
            </td>

          </tr>

          </#list>
          </tbody>
        </table>

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
