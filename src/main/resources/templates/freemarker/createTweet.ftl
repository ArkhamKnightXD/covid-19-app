<!doctype html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/creation-form.css" rel="stylesheet">

</head>

<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h1>Tweet Form</h1>
    </div>

  <div class="center-container">

    <div class="row">

        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Write the information of the tweet</h4>

            <form method="post" action="/create" class="needs-validation" enctype="multipart/form-data" novalidate>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name">Text of the tweet</label>
                        <input type="text" class="form-control" id="text" name="text" placeholder="Text of the tweet"  required>

                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="lastName">Hashtag of the tweet</label>
                        <input type="text" class="form-control" id="hashtags" name="hashtags" placeholder="Hashtag of the tweet"  required>

                    </div>
                </div>


                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Save the tweet</button>
                <hr class="mb-4">
                <a class="btn btn-danger btn-lg btn-block" href="/" role="button">Cancel</a>
            </form>
        </div>
    </div>
  </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2020 Tweet-Analyzer</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>

</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/dist/js/jquery-3.2.1.slim.min.js"><\/script>')</script><script src="../../bootstrap-4.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../../bootstrap-4.3.1/dist/js/form-validation.js"></script>

</body>

</html>
