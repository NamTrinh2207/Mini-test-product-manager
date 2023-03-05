<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/5/2023
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<table>
    <tr>
        <td>ID Product: </td>
        <td>${requestScope.product.getIdProduct()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${requestScope.product.getName()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope.product.getPrice()}</td>
    </tr>
    <tr>
        <td>Producer: </td>
        <td>${requestScope.product.getProducer()}</td>
    </tr>
    <tr>
        <td>Note: </td>
        <td>${requestScope.product.getNote()}</td>
    </tr>
</table>
<p>
    <a href="<c:url value="/products"/>">Back to customer list</a>
</p>
</body>
</html>
