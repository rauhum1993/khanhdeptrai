<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting Mail</title>
</head>
<body>

<h1>Setting</h1>


<%--<form:form action="/update" modelAttribute="mail">--%>
<%--    <label  for="languages">Languages: </label>--%>
<%--    <select id="languages">--%>
<%--        <option value="english">English</option>--%>
<%--        <option value="vietnamese">Vietnamese</option>--%>
<%--    </select>--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    <label  for="size">Page Size: </label>--%>
<%--    <label>Show </label>--%>
<%--    <select id="size" style="width: 50px">--%>
<%--        <option value="5">5</option>--%>
<%--        <option value="10">10</option>--%>
<%--        <option value="15">15</option>--%>
<%--        <option value="25">25</option>--%>
<%--        <option value="50">50</option>--%>
<%--        <option value="100">100</option>--%>
<%--    </select>--%>
<%--    <label>emails per page</label>--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    <label for="spamFilter">Spams filter: </label>--%>
<%--    <input type="checkbox" id="spamFilter" name="spamFilter" value="true">--%>
<%--    <label for="spamFilter"> Enable spams filter</label>--%>
<%--    <br>--%>
<%--    <br>--%>
<%--    <p>Spams filter: </p>--%>
<%--    <textarea id="signature" name="signature" rows="5" cols="50">--%>
<%--    </textarea>--%>
<%--    <br>--%>
<%--    <input type="submit" value="update">--%>
<%--&lt;%&ndash;    <input type="submit" /> value="cancel">&ndash;%&gt;--%>


<%--</form:form>--%>

<%--@elvariable id="mail" type=""--%>
<form:form action="/update" method="post" modelAttribute="mail">
    <p>language:</p>
    <form:select path="language">
        <form:option value="English">English</form:option>
        <form:option value="Vietnamese">Vietnamese</form:option>
    </form:select>
    <p>size:</p>
    <form:select path="size">

        <form:option value="5">5</form:option>
        <form:option value="10">10</form:option>
        <form:option value="15">15</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
    </form:select>
    <p>spamFilter:</p>
    <form:checkbox path="spamFilter" value="true"/>
    <p>signature:</p>
    <form:textarea path="signature" rows="5" cols="50"/>
    <br>
    <input type="submit" value="edit"/>
</form:form>

</body>
</html>