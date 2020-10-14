<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<link rel="stylesheet" href="/bootstrap-4.5.2-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css"/>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<body>
<center>

    <form method="post" style="text-align: center ;">
        <caption>
            <h2>
                Edit Customer
            </h2>
            <br>
        </caption>
        <input type="hidden" name="id" value="${customer.id}"/>
        <div class="form-group row">
            <label class="col-1"></label>
            <label for="typeId" class="col-2 d-flex justify-content-start">Type ID : </label>
            <input type="text" class="col-6 form-control" id="typeId" name="typeId" value="${customer.typeId}">
        </div>
        <p class="msg-invalid" style="color: red">${messageTypeID}</p>
        <div class="form-group row">

            <label class="col-1"></label>
            <label for="name" class="col-2 d-flex justify-content-start">Name : </label>
            <input type="text" class="col-6 form-control" id="name" name="name" value="${customer.name}">

        </div>
        <%--        -----------------------%>
        <div class="form-group row">
            <label class="col-1"></label>
            <label for="birthday" class="col-2 d-flex justify-content-start">Birthday : </label>
            <input type="text" class="col-6 form-control" id="birthday" name="birthday" value="${customer.birthday}">

        </div>
        <p class="msg-invalid" style="color: red">${messageBirthday}</p>
        <%--        -------------------------%>
        <div class="form-group row">
            <label class="col-1"></label>
            <label for="gender" class="col-2 d-flex justify-content-start">Gender :</label>


            <select name="gender" id="gender" class="col-6 form-control">
                <c:forEach var="gender" items="${genderCustomerList}">
                    <c:choose>
                        <c:when test="${customer.gender == gender.name}">
                            <option value="${gender.name}" selected>${gender.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${gender.name}">${gender.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>

        </div>
        <%--        -------------------------------%>
        <div class="form-group row">
            <label class="col-1"></label>
            <label for="idCard" class="col-2 d-flex justify-content-start">Id Card : </label>
            <input type="text" class="col-6 form-control" id="idCard" name="idCard" value="${customer.idCard}">

        </div>
        <p class="msg-invalid" style="color: red">${messageIDCard}</p>
        <%--        ----------------------------------%>
        <div class="form-group row">
            <label class="col-1"></label>
            <label for="phone" class="col-2 d-flex justify-content-start">Phone : </label>
            <input type="text" class="col-6 form-control" id="phone" name="phone" value="${customer.phone}">

        </div>
        <p class="msg-invalid" style="color: red">${messagePhone}</p>
        <%--        ------------------------------------------------%>
        <div class="form-group row">
            <label class="col-1"></label>
            <label for="email" class="col-2 d-flex justify-content-start">Email : </label>
            <input type="text" class="col-6 form-control" id="email" name="email" value="${customer.email}">

        </div>
        <p class="msg-invalid" style="color: red">${messageEmail}</p>
        <%--        ----------------------------------------------------%>
        <div class="form-group row">

            <label class="col-1"></label>
            <label for="address" class="col-2 d-flex justify-content-start">Address : </label>
            <input type="text" class="col-6 form-control" id="address" name="address" value="${customer.address}">
        </div>

        <div>
            <input class="btn btn-outline-warning" type="submit" value="Save">
            <a class="btn btn-outline-primary" href="/customer">
                Back
            </a>

        </div>
    </form>

</center>


<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>