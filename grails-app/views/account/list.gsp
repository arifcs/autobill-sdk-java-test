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
    <g:if test="${accountList != null && accountList.size() > 0}">
      <table class="table table-bordered table-hover">
        <thead>
        <tr>
          <td>ID</td><td>Name</td><td>Email</td><td>View</td><td>Update Name</td><td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <g:each in="${accountList}" var="account">
          <tr>
            <td>${account.id}</td><td>${account.name}</td><td>${account.email_address}</td>
            <td><g:link controller="account" action="view" id="${account.id}">View</g:link></td>
            <td><g:link controller="account" action="edit" id="${account.id}">Update Name</g:link></td>
            <td><g:link controller="account" action="delete" id="${account.id}">Delete</g:link></td>
          </tr>
        </g:each>
        </tbody>
      </table>
    </g:if>
    <g:else>
      <strong>No account available</strong>
    </g:else>
  </div>


</div>
</body>
</html>