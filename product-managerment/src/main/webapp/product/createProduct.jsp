<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/5/2023
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Product</title>
</head>
<style>
    .message {
        color: blue;
    }
</style>
<body>
<h1>Create new product</h1>
<br>
<p>
    <c:if test='${requestScope.message != null}'>
        <span class="message">${requestScope.message}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID Product :</td>
                <td><label for="idProduct"></label><input type="text" name="idProduct" id="idProduct"></td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><label for="name"></label><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price :</td>
                <td><label for="price"></label><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Producer :</td>
                <td><label for="producer"></label><input type="text" name="producer" id="producer"></td>
            </tr>
            <tr>
                <td>Note :</td>
                <td><label for="note"></label><input type="text" name="note" id="note"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create new product"></td>
            </tr>
        </table>
    </fieldset>
</form>
<p>
    <a href="<c:url value="/products"/>">Back to product list</a>
</p>
</body>
</html>
