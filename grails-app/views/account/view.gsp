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
    <g:link controller="account" action="create">Create</g:link>
  </div>
  <h2>List</h2>
  <div class="row">
    <g:if test="${account != null}">
      <table class="table table-bordered table-hover">
        <tr>
          <td>Name</td><td>${account.name}</td>
          <td>Display Name</td><td>${account.display_name}</td>
          <td>Email</td><td>${account.email_address}</td>
          <td>Created</td><td>${account.created_on}</td>
          <td>Updated</td><td>${account.last_updated_on}</td>
        </tr>
      </table>
    </g:if>
    <g:else>
      <strong>No such account available</strong>
    </g:else>
  </div>


</div>
</body>
</html>