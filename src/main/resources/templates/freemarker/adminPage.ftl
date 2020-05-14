<!doctype html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/dashboard.css" rel="stylesheet">

</head>

<body>
<form action="/dashboard/">
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="/dashboard/">Covid-19-Dashboard</a>
        <input class="form-control form-control-dark w-100" type="text" name="country" placeholder="Search..." aria-label="Search">
        <ul class="navbar-nav px-1">
            <li class="nav-item text-nowrap">
                <input type="submit" value="Search" class="btn btn-dark"/>
            </li>
        </ul>
    </nav>
</form>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-dark sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <span data-feather="home"></span>
                            New Confirmed Cases <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="/dashboard/summary">
                            <span data-feather="layers"></span>
                            Countries Summary
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="/dashboard/recovered">
                            <span data-feather="layers"></span>
                            Total Recovered Cases
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="/dashboard/deaths">
                            <span data-feather="file"></span>
                            Total Deaths Cases
                        </a>
                    </li>

                </ul>

                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span class="text-light">Saved reports</span>
                    <a class="d-flex align-items-center text-muted text-light" href="#">
                        <span data-feather="plus-circle"></span>
                    </a>
                </h6>
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link text-light" href="/report/pdf">
                            <span data-feather="file-text"></span>
                            Daily report
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">New Confirmed Cases by Countries</h1>

            </div>

            <canvas class="my-4" id="myChart" width="900" height="380"></canvas>

            <h2>Data of the countries</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead class="thead-dark">
                    <tr>
                        <th>Country</th>
                        <th>New Confirmed</th>
                        <th>Total Confirmed</th>

                    </tr>
                    </thead>
                    <#list datas as data>
                    <tbody>
                    <tr>
                        <td>${data.country}</td>
                        <td>${data.newConfirmed}</td>
                        <td>${data.totalConfirmed}</td>
                    </tr>

                    </tbody>
                    </#list>
                </table>

            </div>
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/dist/js/jquery-3.2.1.slim.min.js"><\/script>')</script>
<script src="../../bootstrap-4.3.1/assets/js/vendor/popper.min.js"></script>
<script src="../../bootstrap-4.3.1/dist/js/bootstrap.min.js"></script>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>

<!-- Graphs -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<script>


    let countriesNames = [];
    let newConfirmed = [];

    <#list graphics as graphic>

    countriesNames.push("${graphic.country}");

    newConfirmed.push(${graphic.newConfirmed});

    </#list>
// back ground color es para cambiar el color de lo que hay debajo de la linea y border color es para cambiar el color de la linea
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: countriesNames,
            datasets: [
                {
                data: newConfirmed,
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: 'black',
                borderWidth: 4,
                pointBackgroundColor: 'white'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        // Maximo valor en Y que tendra la grafica
                        max: 30,
                        beginAtZero: true
                    }
                }]
            },
            legend: {
                display: false,
            }
        }
    });
</script>
</body>
</html>
