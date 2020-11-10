<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        AutoBill SDK Java - Test
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="bootstrap-grid.css"/>
    <asset:stylesheet src="bootstrap-reboot.css"/>
    <asset:stylesheet src="style.css"/>
    <asset:javascript src="bootstrap.js"/>
    <asset:javascript src="application.js"/>

    <g:layoutHead/>
</head>

<body>
<div class="alert-container" id="alertBox">
    <div class="alert alert-primary alert-dismissible fade show" role="alert">
        <strong>MSG</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close" onclick="document.getElementById('alertBox').remove()">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>

<div class="jumbotron text-center">
    <h1>AutoBill Mini Client</h1>
    <div class="row">
        <div class="col-sm-12">
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <a class="nav-link" href="index.php">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="account.php">Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="README.md">README.md</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<g:layoutBody/>

</body>
</html>
