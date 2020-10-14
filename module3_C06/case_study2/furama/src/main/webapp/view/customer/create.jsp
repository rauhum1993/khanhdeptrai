<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<link rel="stylesheet" href="/bootstrap-4.5.2-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css"/>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<body>

<center>
    <form method="post">
        <fieldset class="scheduler-border">
            <legend class="scheduler-border">Create New Customer</legend>
            <br>
            <div class="control-group">
                <div class="form-group form-inline">
                    <label class="col-1"></label>
                    <label for="id" class="col-2 d-flex justify-content-start">Id : </label>
                    <input type="text" class="col-6 form-control" id="id" name="id">

                </div>
                <p class="msg-invalid " style="color: red">${messageID}</p>

            </div>

            <div class="form-group form-inline">
                <label class="col-1"></label>
                <label for="typeId" class="col-2 d-flex justify-content-start">Type ID : </label>
                <input type="text" class="col-6 form-control" id="typeId" name="typeId">
            </div>
            <p class="msg-invalid" style="color: red">${messageTypeID}</p>

            <div class="form-group form-inline">
                <label class="col-1"></label>
                <label for="name" class="col-2 d-flex justify-content-start">Name :</label>
                <input type="text" class="col-6 form-control" id="name" name="name">
            </div>

            <div class="form-group form-inline">
                <label class="col-1"></label>
                <label for="birthday" class="col-2 d-flex justify-content-start">Birthday :</label>
                <input type="date" class="col-6 form-control" id="birthday" name="birthday">
            </div>
            <p class="msg-invalid" style="color: red">${messageBirthday}</p>

            <div class="form-group form-inline">
                <label class="col-1"></label>
                <label for="gender" class="col-2 d-flex justify-content-start">Gender :</label>
                <select name="gender" id="gender" class="col-6 form-control">
                    <c:forEach var="gender" items="${genderCustomerList}">
                        <option value="${gender.name}">${gender.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group form-inline">
                <label class="col-1"></label>
                <label for="idCard" class="col-2 d-flex justify-content-start">ID Card :</label>
                <input type="text" class="col-6 form-control" id="idCard" name="idCard">
            </div>
            <p class="msg-invalid" style="color: red">${messageIDCard}</p>

            <div class="form-group form-inline">
                <label class="col-1"></label>
                <label for="phone" class="col-2 d-flex justify-content-start">Phone :</label>
                <input type="text" class="col-6 form-control" id="phone" name="phone">
            </div>
            <p class="msg-invalid" style="color: red">${messagePhone}</p>

            <div class="form-group form-inline">
                <label class="col-1"></label>
                <label for="email" class="col-2 d-flex justify-content-start">Email :</label>
                <input type="text" class="col-6 form-control" id="email" name="email">
            </div>
            <p class="msg-invalid" style="color: red">${messageEmail}</p>

            <div class="form-group form-inline">
                <label class="col-1"></label>
                <label for="address" class="col-2 d-flex justify-content-start">Address : </label>
                <input type="text" class="col-6 form-control" id="address" name="address">
            </div>
            <div class="form-group form-inline">

                <div class="col-2"></div>
                <div class="col-7 pl-0">
                    <input type="hidden" name="action" value="create">
                    <input type="submit" value="Create" class="btn btn-outline-dark mr-2">
                    <a class="btn btn-outline-dark" href="/customer">Back</a>
                </div>
            </div>

            </div>
        </fieldset>
    </form>

</center>
<%--<div align="center">--%>
<%--    <form method="post">--%>
<%--        <table border="1" cellpadding="5">--%>
<%--            <caption>--%>
<%--                <h2>Add New User</h2>--%>
<%--            </caption>--%>

<%--            <th>User ID:</th>--%>
<%--            <td>--%>
<%--                <input type="text" name="id" id="id" size="45"/>--%>
<%--            </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>User Name:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="name" id="name" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>User Email:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="email" id="email" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Country:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="country" id="country" size="15"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2" align="center">--%>
<%--                    <input type="submit" value="Save"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>
</div>

<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>