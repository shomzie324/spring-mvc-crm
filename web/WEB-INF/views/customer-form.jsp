<%--
  Created by IntelliJ IDEA.
  User: shomarimalcolm
  Date: 2019-04-28
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>


<div class="container">
    <h2>CRM - Customer Relationship Manager</h2>
    <br>
    <h3>Add Customer</h3>
    <br>

    <form:form action="saveCustomer" modelAttribute="customer" method="POST">

        <%-- need to associate form data with a given customer with hidden field --%>
        <%-- calls setter for customer so right record gets updated --%>
        <form:hidden path="id" />

        <table>
            <tbody>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save Customer" class="btn btn-success"></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><a href="${pageContext.request.contextPath}/customer/list" class="btn btn-danger">Go Back</a></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</div>



</body>
</html>
