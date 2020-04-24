<%--
  Created by IntelliJ IDEA.
  User: XuanTho
  Date: 4/10/2020
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit information product</title>
</head>
<body>
<h1>Edit product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/system">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>product information</legend>
        <table>
            <tr>
                <td>id:  </td>
                <td><input type="text" name="id" value="${requestScope["products"].getId()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${requestScope["products"].getName()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" value="${requestScope["products"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Amount: </td>
                <td><input type="text" name="amount" value="${requestScope["products"].getAmount()}"></td>
            </tr>
            <tr>
                <td>Color: </td>
                <td><input type="text" name="color" value="${requestScope["products"].getColor()}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" value="${requestScope["products"].getDescription()}"></td>
            </tr>
            <tr>
                <td>category: </td>
                <td><input type="text" name="category" value="${requestScope["products"].getCategory()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
