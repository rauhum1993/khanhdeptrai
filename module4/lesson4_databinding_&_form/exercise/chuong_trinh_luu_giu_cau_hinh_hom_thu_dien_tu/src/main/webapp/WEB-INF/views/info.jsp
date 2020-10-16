<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/10/2020
  Time: 2:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Info mail</title>
</head>
<body>

<%--    &lt;%&ndash;@elvariable id="mail" type=""&ndash;%&gt;--%>
<%--    <form:form action="/update" method="post" modelAttribute="mail">--%>
<%--        <p>language:</p>--%>
<%--        <form:label path="language">Language: </form:label>--%>
<%--        <p>size:</p>--%>
<%--        <form:label  path="size" />--%>
<%--        <p>spamFilter:</p>--%>
<%--        <form:label  path="spamFilter"/>--%>
<%--        <p>signature:</p>--%>
<%--        <form:label  path="signature"/>--%>
<%--        <br>--%>
<%--        <input type="submit" value="edit" />--%>
<%--    </form:form>--%>
<a href="/update">Update Mail</a>
<p style="color: green">${message}</p>
<table border="1">
    <tr>
        <th>Language</th>
        <th>Size</th>
        <th>Spam Filter</th>
        <th>Signature</th>


    </tr>

        <tr>
            <td>${mail.language}</td>
            <td>${mail.size}</td>
            <td>${mail.spamFilter}</td>
            <td>${mail.signature}</td>
        </tr>

</table>

</body>
</html>
