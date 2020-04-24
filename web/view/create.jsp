<%--
  Created by IntelliJ IDEA.
  User: XuanTho
  Date: 4/9/2020
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create new customer</title>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${requestScope["mesage"]}</span>
    </c:if>
</p>
<p>
    <a href="/system"></a>
</p>
<form method="post">
    <fieldset>
        <legend>product information</legend>
        <table>
            <tr>
                <td>id:  </td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>Amount: </td>
                <td><input type="text" name="amount"></td>
            </tr>
            <tr>
                <td>Color: </td>
                <td><input type="text" name="color"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>category: </td>
                <td><input type="text" name="category"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="create"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
