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

    <br>

    <a class="btn btn-success" href="${pageContext.request.contextPath}/customer/showAddForm">Add
        Customer</a>

    <br>

    <div>
        <table class="table table-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Action</th>
            </tr>
            <%-- loop over customers --%>
            <c:forEach var="customer" items="${customers}">

                <%-- construct update link with customer id --%>
                <c:url var="updateLink" value="/customer/showUpdateForm">
                    <c:param name="customerId" value="${customer.id}" />
                </c:url>

                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${customer.id}" />
                </c:url>


                <tr>
                    <th scope="row">${customer.id}</th>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a class="btn btn-warning"
                           href="${updateLink}">Update
                        </a>
                         |
                        <a class="btn btn-danger"
                           onclick="event.preventDefault();if(!(confirm('Are you sure ypu want to delete this customer?'))){return false}
                                    else{window.location.href = '${deleteLink}'}">Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
