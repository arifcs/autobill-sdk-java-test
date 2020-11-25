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
<g:if test="${flash?.message}">
    <div class="alert-container" id="alertBox">
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <strong>${flash.message}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close" onclick="document.getElementById('alertBox').remove()">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </div>
</g:if>

<div class="jumbotron text-center">
    <h1>AutoBill Mini Client</h1>
    <div class="row">
        <div class="col-sm-12">
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <g:link url="/" class="nav-link" >Home</g:link>
                </li>
                <li class="nav-item">
                    <g:link controller="account" action="list" class="nav-link" >Account</g:link>
                </li>
            </ul>
        </div>
    </div>
</div>
<g:layoutBody/>

</body>
</html>
