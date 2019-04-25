<%--
  Created by IntelliJ IDEA.
  User: shomarimalcolm
  Date: 2019-04-25
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container">

    <br>

    <div class="mx-auto">
        <h2>CRM - Customer Relationship Management App</h2>
    </div>

    <br><br>

    <div>
        <table class="table table-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
            </tr>
            <%-- loop over customers --%>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <th scope="row">${customer.id}</th>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


</body>
</html>
