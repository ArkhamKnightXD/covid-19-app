<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>${title}</title>

    <link href="../../bootstrap-4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../bootstrap-4.3.1/style/creation-form.css" rel="stylesheet">

</head>
<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h1>Edit client</h1>
    </div>

    <div class="center-container">

        <div class="row">

            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Write the information of the client</h4>

                <form method="post" action="/clients/edit/?id=${client.id}" class="needs-validation" enctype="multipart/form-data" novalidate>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="name">Name</label>
                            <input type="text" value="${client.name}" class="form-control" id="name" name="name" placeholder="Name"  required>

                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="lastName">Last Name</label>
                            <input type="text" value="${client.lastName}" class="form-control" id="lastName" name="lastName" placeholder="Last Name"  required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="address">Address</label>
                        <div class="input-group">
                            <input type="text" value="${client.address}" class="form-control" id="address" name="address" placeholder="Address" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="phone">Phone</label>
                        <div class="input-group">
                            <input type="text" value="${client.phone}" class="form-control" id="phone" name="phone" placeholder="Phone" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="email">Email</label>
                        <div class="input-group">
                            <input type="text" value="${client.email}" class="form-control" id="email" name="email" placeholder="Email" required>

                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="photo">Picture of the client</label>
                        <div class="input-group">
                            <input type="file" class="form-control" id="photo" name="photo" placeholder="Picture of the client">

                        </div>
                    </div>

                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Save console</button>
                    <hr class="mb-4">
                    <a class="btn btn-danger btn-lg btn-block" href="/clients/" role="button">Cancel</a>
                </form>
            </div>
        </div>
    </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2019 Arkham-Store</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script>window.jQuery || document.write('<script src="../../bootstrap-4.3.1/dist/js/jquery-3.2.1.slim.min.js"><\/script>')</script><script src="../../bootstrap-4.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../../bootstrap-4.3.1/dist/js/form-validation.js"></script></body>
</html>
