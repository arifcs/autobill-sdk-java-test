<%--
  Created by IntelliJ IDEA.
  User: Arif
  Date: 11/10/2020
  Time: 4:22 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-10 offset-sm-1 top-bar">
            <g:link class="btn btn-primary" url="${apiConfig.getAuthorizeUrl()}">Connect AutoBill</g:link>
            <g:link class="btn btn-primary" controller="token" action="invalidate">Invalidate token</g:link>
            <g:link class="btn btn-primary" controller="token" action="renew">Renew token</g:link>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-10 offset-sm-1">
            <g:form action="save">
                <div class="form-group">
                    <label for="apiURL">API URL</label>
                    <input type="text" class="form-control" name="apiUrl" id="apiURL" aria-describedby="apiURLHelp" value="${apiConfig.getApiUrl()}" />
                </div>
                <div class="form-group">
                    <label for="appURL">APP URL</label>
                    <input type="text" class="form-control" name="appUrl"  id="appURL" aria-describedby="appURLHelp" value="${apiConfig.getAppUrl()}" />
                </div>
                <div class="form-group">
                    <label for="clientID">Client ID</label>
                    <input type="text" class="form-control" name="clientId"  id="clientID" aria-describedby="clientIDHelp" value="${apiConfig.getClientId()}" />
                    <small id="clientIDHelp" class="form-text text-muted">Create an application in AutoBill and put the generated Client ID here</small>
                </div>
                <div class="form-group">
                    <label for="clientSecret">Client Secret</label>
                    <input type="text" class="form-control" name="clientSecret"  id="clientSecret" aria-describedby="clientSecretHelp" value="${apiConfig.getClientSecret()}" />
                    <small id="clientSecretHelp" class="form-text text-muted">Put the generated Client Secret here</small>
                </div>
                <div class="form-group">
                    <label for="redirectURL">Redirect URL</label>
                    <input type="text" class="form-control" name="redirectUrl"   id="redirectURL" aria-describedby="redirectURLHelp" value="${apiConfig.getRedirectUrl()}" />
                    <small id="redirectURLHelp" class="form-text text-muted">Should be same as in the application in AutoBill</small>
                </div>
                <div class="form-group">
                    <label for="redirectURL">Access Token</label>
                    <span class="text-info">${apiConfig.getAccessToken()}</span>
                    <small id="accessTokenHelp" class="form-text text-muted">Will be generated once connected to AutoBill</small>
                </div>
                <div class="form-group">
                    <label for="redirectURL">Refresh Token</label>
                    <span class="text-info">${apiConfig.getRefreshToken()}</span>
                    <small id="refreshTokenHelp" class="form-text text-muted">Will be generated once connected to AutoBill</small>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </g:form>
        </div>
    </div>

</div>
</body>
</html>