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

  </div>
  <div class="row">
  <h2>List</h2>
    <g:if test="${accountList.accounts.size() > 0}">
      <table>
        <thead>
        <tr>
          <td>ID</td><td>Name</td><td>Email</td>
        </tr>
        </thead>
        <tbody>
        <g:each in="${accountList.accounts}" var="account">
          <tr>
            <td>${account.id}</td><td>${account.name}</td><td>${account.email_address}</td>
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