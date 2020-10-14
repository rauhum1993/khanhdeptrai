<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/28/2020
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="text-align: center">Danh Sách Khách Hàng</h3>
<table border="1px" style="width: 100%">
    <tr style="text-align: left">
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${ListCustomer}">
        <tr>
            <td><c:out value="${customer.nameCustomer}"></c:out></td>
            <td><c:out value="${customer.birthdayCutomer}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td class="avatar"><img src='<c:out value="${customer.image}"/>' alt="avatar" width="30" height="30"></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>