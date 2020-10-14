<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        body {
            background: url(/view/anh_ng_dep_1.png) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
    </style>

</head>
<body >
<%--<img src="/view/anh_ng_dep_1.png">--%>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/servlet?action=create">Add New User</a>
    </h2>
    <form action="/servlet">
        <button value="create" name="action">Add New User</button>
    </form>
    <h2>

        <a href="/servlet?action=permision">Transaction User</a>

    </h2>
    <h2>
        <a href="/servlet?action=test-without-tran">Thực thi SQL không sử dụng Transaction</a>
    </h2>
    <h2>
        <a href="/servlet?action=test-use-tran">Thực thi SQL  sử dụng Transaction</a>
    </h2>
    <h2 style="font-size: 1cm;color: red">
        ${message}
    </h2>
    <div>
        <form action="/servlet" >
            <input type="search" name="search" placeholder="search by name product" >
            <input type="submit" value="search" name="action">
        </form>

    </div>
    <div>
        <form action="/servlet" >

            <input type="submit" value="Sort By Name" name="action">
        </form>

    </div>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${list}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/servlet?action=edit&id=${user.id}">Edit</a>
                    <a href="/servlet?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>