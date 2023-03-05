<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/5/2023
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<h1>Edit product</h1>
<p>
  <c:if test='${requestScope.message != null}'>
    <span class="message">${requestScope.message}</span>
  </c:if>
</p>
<p>
  <a href="<c:url value="/products"/>">Back to product list</a>
  <br>
</p>
<form method="post">
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>ID Product: </td>
        <td><label for="idProduct"></label><input type="text" name="idProduct" id="idProduct" value="${requestScope.product.getIdProduct()}"></td>
      </tr>
      <tr>
        <td>name: </td>
        <td><label for="name"></label><input type="text" name="name" id="name" value="${requestScope.product.getName()}"></td>
      </tr>
      <tr>
        <td>ID Product: </td>
        <td><label for="price"></label><input type="text" name="price" id="price" value="${requestScope.product.getPrice()}"></td>
      </tr>
      <tr>
        <td>ID Product: </td>
        <td><label for="producer"></label><input type="text" name="producer" id="producer" value="${requestScope.product.getProducer()}"></td>
      </tr>
      <tr>
        <td>ID Product: </td>
        <td><label for="note"></label><input type="text" name="note" id="note" value="${requestScope.product.getNote()}"></td>
      </tr>
      <tr>
        <td><input type="submit"  value="Update product"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
