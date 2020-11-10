<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validation</title>
</head>
<body>

<h1>Sandwich Condiments</h1>


<form action="/list">
    <input type="checkbox" id="lettuce" name="sandwich" value="Lettuce">
    <label for="lettuce"> Lettuce</label>
    <input type="checkbox" id="tomato" name="sandwich" value="Tomato">
    <label for="tomato"> Tomato</label>
    <input type="checkbox" id="mustard" name="sandwich" value="Mustard">
    <label for="mustard"> Mustard</label>
    <input type="checkbox" id="sprouts" name="sandwich" value="Sprouts">
    <label for="sprouts"> Sprouts</label>
    <br>
    <hr>
    <br>
    <input type="submit" value="Save">
</form>

</body>
</html>