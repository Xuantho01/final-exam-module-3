<%--
  Created by IntelliJ IDEA.
  User: XuanTho
  Date: 4/9/2020
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer</h1>
<p><a href="/system?action=create">Create new product</a></p>

<form method="post">
    <input type="text" name="nameSearch">
    <button>
        <a href="/system?action=search">search </a>
    </button>

</form>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Amount</td>
        <td>Color</td>
        <td>Description</td>
        <td>Category</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="products">
        <tr>
            <td>${products.getId()}</td>
            <td>${products.getName()}</td>
            <td>${products.getPrice()}</td>
            <td>${products.getAmount()}</td>
            <td>${products.getColor()}</td>
            <td>${products.getDescription()}</td>
            <td>${products.getCategory()}</td>
            <td><a href="/system?action=update&id=${products.getId()}">edit</a></td>
            <td><a href="/system?action=delete&id=${products.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
