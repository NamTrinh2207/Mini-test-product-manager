<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/5/2023
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
        text-align: center;
    }
    a{
        text-decoration: none;
    }
</style>
<body>
<table>
    <h1>Product</h1>
    <tr>
        <th>ID</th>
        <th>ID Product</th>
        <th>Name</th>
        <th>Price</th>
        <th>producer</th>
        <th>Note</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="products">
        <tr>
            <td>${products.getId()}</td>
            <td>${products.getIdProduct()}</td>
            <td><a href="<c:url value="/products?action=view&id=${products.getId()-1}"/>">${products.getName()}</a></td>
            <td>${products.getPrice()}</td>
            <td>${products.getProducer()}</td>
            <td>${products.getNote()}</td>
            <td> <a href="<c:url value="/products?action=update&id=${products.getId()-1}"/>">Edit</a></td>
            <td> <a href="<c:url value="/products?action=delete&id=${products.getId()-1}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="<c:url value="/products?action=create"/>">Create new product</a>
    <br>
</p>
</body>
</html>
