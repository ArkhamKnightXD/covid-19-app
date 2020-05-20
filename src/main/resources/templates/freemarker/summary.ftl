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
      <a class="navbar-brand" href="/dashboard/">Covid-19-Dashboard</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Summary</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/dashboard/deaths">New Deaths Cases</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/dashboard/recovered">Total Recovered Cases</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/dashboard/worldwide">Total cases report</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="/dashboard/new">New cases report</a>
          </li>
        </ul>
      </div>
      <form action="/dashboard/summary" class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="text" name="country" placeholder="Search" aria-label="Search">
        <button class="btn btn-dark my-2 my-sm-0" type="submit">Search</button>
      </form>
    </nav>

    <h1 class="jumbotron text-center">Countries Summary</h1>
    <main role="main" class="container">

      <div class="starter-template table-responsive">
        <table class="table-hover table table-bordered">
          <thead class="thead-dark">
          <tr>
            <th>Country</th>
            <th>Total Confirmed</th>
            <th>New Confirmed</th>
            <th>New Deaths</th>
            <th>Total Deaths</th>
            <th>New Recovered</th>
            <th>Total Recovered</th>

          </tr>
          </thead>
          <#list datas as data>
            <tbody>
            <tr>
              <td>${data.country}</td>
              <td>${data.totalConfirmed}</td>
              <td>${data.newConfirmed}</td>
              <td>${data.newDeaths}</td>
              <td>${data.totalDeaths}</td>
              <td>${data.newRecovered}</td>
              <td>${data.totalRecovered}</td>
            </tr>

            </tbody>
          </#list>
        </table>

      </div>

    </main>

    <footer class="footer-container-1">
      <p class="float-right"><a href="#">Back to top</a></p>
      <p class="logo">&copy; Arkham-Covid 2020</p>
    </footer>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../bootstrap-4.3.1/assets/js/vendor/popper.min.js"></script>
    <script src="../../bootstrap-4.3.1/dist/js/bootstrap.min.js"></script>

  </body>

</html>
