<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        /*background: url(/logo_furama/anhfurama.png) no-repeat center center fixed;*/
        /*-webkit-background-size: cover;*/
        /*-moz-background-size: cover;*/
        /*background-size: cover;*/
    }

    img {
        width: 100%;
    }

    tr th {
        text-align: center;
    }

    td {
        text-align: center;
    }
</style>
<link rel="stylesheet" href="/bootstrap-4.5.2-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css"/>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>


<body>

<div class="container-fluid">

    <h1 style="color: #b8daff;text-align: center ">List Customer</h1>
    <div class="row">
        <div class="col-lg-6">
            <form action="/customer">
                <button type="submit" class="btn btn-primary my-2 my-sm-0" size="50px">
                    <input type="hidden" name="action" value="create">
                    <i class="fa fa-plus" aria-hidden="true">
                        Add new customer
                    </i>
                </button>
            </form>

        </div>
        <div class="col-lg-6 ">
            <form class="form-inline my-2 my-lg-0 float-right">
                <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="search" name="action">Search
                </button>
            </form>
        </div>
    </div>
    <br>
    <p><c:out value="${notification}"/></p>
    <br>
    <div class="row">


        <div class="col-lg-12">

            <div class="table-responsive">


                <table id="mytable" class="table table-bordred table-striped ">

                    <thead>
                    <tr class="bg-light">

                        <th>ID</th>
                        <th>Type ID</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>Gender</th>
                        <th>Id Card</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="customer" items="${list}">
                        <tr>

                            <td>${customer.id}</td>
                            <td>${customer.typeId}</td>
                            <td>${customer.name}</td>
                            <td>${customer.birthday}</td>
                            <td>${customer.gender}</td>
                            <td>${customer.idCard}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.email}</td>
                            <td>${customer.address}</td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <%--                                    <a href="/customer?action=edit&id=${customer.id}">--%>
                                    <button class="btn btn-outline-primary btn-xs " data-title="Edit"
                                            data-toggle="modal"
                                            data-target="#editEmployeeModal"
                                            onclick="setIdEdit('${customer.id}',
                                                    '${customer.typeId}',
                                                    '${customer.name}',
                                                    '${customer.birthday}',
                                                    '${customer.gender}',
                                                    '${customer.idCard}',
                                                    '${customer.phone}',
                                                    '${customer.email}',
                                                    '${customer.address}')">
                                        <i class="fas fa-edit"></i>
                                    </button>
                                    </a>

                                </p>
                            </td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Delete">
                                    <button class="btn btn-danger btn-xs" data-title="Delete"
                                            onclick="setStudentId('${customer.id}')" data-toggle="modal"
                                            data-target="#deleteModal1">
                                        <i class="fas fa-trash-alt">

                                        </i>
                                    </button>
                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>

                </table>


            </div>

        </div>
    </div>
</div>
<form action="/customer" method="get" id="formDelete">
    <input type="hidden" name="action" value="delete"/>
    <input type="hidden" id="idStudentHidden" name="idStudentHidden"/>
</form>
<!-- Modal -->
<form action="/customer" method="get" class="modal fade" id="deleteModal1" tabindex="-1"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">You are want to delete
                    ???</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    Close
                </button>
                <button type="button" class="btn btn-primary"
                        onclick="submitFormDelete()">Delete
                </button>
            </div>
        </div>
    </div>
</form>
<!-- Edit Modal HTML -->


<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/customer?action=editModal">
                <input type="hidden" id="id" name="id">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Customer</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <%--                    <div class="form-group">--%>
                    <%--                        <label>Type Customer </label>--%>
                    <%--                        <select name="typeCustomerId" id="typeCustomerEdit">--%>
                    <%--                            <c:forEach var="typeOfCustomer" items="${typeOfCustomerList}">--%>
                    <%--                                <option value="${typeOfCustomer.id}">${typeOfCustomer.name}</option>--%>
                    <%--                            </c:forEach>--%>
                    <%--                        </select>--%>
                    <%--                    </div>--%>
                    <div class="form-group">
                        <label>Type ID :</label>
                        <input type="text" class="form-control" required name="typeId" id="typeId">
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required name="name" id="name">
                    </div>
                    <div class="form-group">
                        <label>Birth Day</label>
                        <input type="date" class="form-control" required name="birthDay" id="birthDay">
                    </div>
                    <div class="form-group">
                        <label>Gender</label>
                        <select name="gender" id="gender">
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
                    <div class="form-group">
                        <label>Id Card</label>
                        <input type="text" class="form-control" required name="idCard" id="idCard">
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" required name="phone" id="phone">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" required name="email" id="email">
                    </div>

                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" required name="address" id="address">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>


<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    function setStudentId(id) {
        document.getElementById("idStudentHidden").value = id;
    }

    function submitFormDelete() {
        let formDelete = document.getElementById("formDelete");
        formDelete.submit();
    }
</script>
<script>
    $(document).ready(function () {
        $('#mytable').dataTable({
            "dom": "lrtip",
            "lengthChange": false,
            "pageLength": 4
        });
    });
</script>
<script>
    function setIdEdit(id, typeId, name, birthDay, gender, idCard, phone, email, address) {
        console.log(id, typeId, name, birthDay, gender, idCard, phone, email, address);
        document.getElementById("id").value = id;
        document.getElementById("typeId").value = typeId;
        document.getElementById("name").value = name;
        document.getElementById("birthDay").value = birthDay;
        document.getElementById("gender").value = gender;
        document.getElementById("idCard").value = idCard;
        document.getElementById("phone").value = phone;
        document.getElementById("email").value = email;
        document.getElementById("address").value = address;
    }
</script>
</body>
</html>
