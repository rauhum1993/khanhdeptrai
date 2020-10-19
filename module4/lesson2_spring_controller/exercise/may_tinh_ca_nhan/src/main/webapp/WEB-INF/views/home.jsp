<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/10/2020
  Time: 4:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/home" method="post">
    <input type="text" name="number1">
    <input type="text" name="number2">
    <input type="submit" name="result" value="addition">
    <input type="submit" name="result" value="subtraction">
    <input type="submit" name="result" value="multiplication">
    <input type="submit" name="result" value="division">

    <p>Result Division: ${result}</p>

</form>
</body>
</html>
