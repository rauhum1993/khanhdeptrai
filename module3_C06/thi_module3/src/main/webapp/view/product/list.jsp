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

            <button type="submit" class="btn btn-primary my-2 my-sm-0" size="50px">
                <p data-placement="top" data-toggle="tooltip" title="Delete">
                    <button class="btn btn-danger btn-xs" data-title="Delete"
                            data-toggle="modal"
                            data-target="#createModal1">
                        Add new customer
                    </button>

            </button>


        </div>
        <div class="col-lg-6 ">
            <div class="row">
                <form class="form-inline my-2 my-lg-0 float-right">
                    <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search"
                           aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="search" name="action">Search
                    </button>
                </form>
            </div>
            <div class="row">

                <form class="form-inline my-2 my-lg-0 float-right">
                    <input class="form-control mr-sm-2" type="search" name="searchByPrice" placeholder="Search"
                           aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="searchByPrice" name="action">SearchByPrice
                    </button>
                </form>
            </div>

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

                        <th>Name</th>
                        <th>Price</th>
                        <th>Numbers</th>
                        <th>Color</th>
                        <th>Status</th>
                        <th>Category</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="product" items="${list}">
                        <tr>

                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.numbers}</td>
                            <td>${product.color}</td>
                            <td>${product.status}</td>
                            <td>${product.category}</td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Edit">
                                        <%--                                    <a href="/customer?action=edit&id=${customer.id}">--%>
                                    <button class="btn btn-outline-primary btn-xs " data-title="Edit"
                                            data-toggle="modal"
                                            data-target="#editEmployeeModal"
                                            onclick="setIdEdit('${product.id}',
                                                    '${product.name}',
                                                    '${product.price}',
                                                    '${product.numbers}',
                                                    '${product.color}',
                                                    '${product.status}',
                                                    '${product.category}'
                                                    )">
                                        <i class="fas fa-edit"></i>
                                    </button>
                                        <%--                                    </a>--%>

                                </p>
                            </td>
                            <td>
                                <p data-placement="top" data-toggle="tooltip" title="Delete">
                                    <button class="btn btn-danger btn-xs" data-title="Delete"
                                            onclick="setStudentId('${product.id}')" data-toggle="modal"
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
<form action="/product" method="get" id="formDelete">
    <input type="hidden" name="action" value="delete"/>
    <input type="hidden" id="idStudentHidden" name="idStudentHidden"/>
</form>
<!-- Modal create -->
<div id="createModal1" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/product?action=create">
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" class="form-control" required name="id">
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" required name="name">
                </div>
                <div class="form-group">
                    <label>price</label>
                    <input type="text" class="form-control" required name="price">
                </div>
                <div class="form-group">
                    <label>numbers</label>
                    <input type="text" class="form-control" required name="numbers">
                </div>
                <div class="form-group">
                    <label>color</label>
                    <select name="color" class="col-6 form-control">
                            <option value="Đỏ">Đỏ</option>
                            <option value="Xanh">Xanh</option>
                            <option value="Đen">Đen</option>
                            <option value="Trắng">Trắng</option>
                            <option value="Vàng">Vàng</option>

                    </select>
                </div>
                <div class="form-group">
                    <label>status</label>
                    <input type="text" class="form-control" required name="status">
                </div>
                <div class="form-group">
                    <label>category</label>
                    <select name="category" class="col-6 form-control">
                        <c:forEach var="category" items="${categoryList}">
                            <option value="${category.name}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Create">
                </div>
            </form>
        </div>
    </div>

</div>

<!-- Modal delete -->
<form action="/product" method="get" class="modal fade" id="deleteModal1" tabindex="-1"
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
            <form method="post" action="/product?action=editModal">
                <input type="hidden" id="id" name="id">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Product</h4>
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
                        <label>Name</label>
                        <input type="text" class="form-control" required name="name" id="name">
                    </div>
                    <div class="form-group">
                        <label>Price : </label>
                        <input type="date" class="form-control" required name="price" id="price">
                    </div>

                    <div class="form-group">
                        <label>Numbers : </label>
                        <input type="text" class="form-control" required name="numbers" id="numbers">
                    </div>
                    <div class="form-group">
                        <label>Color : </label>
                        <input type="text" class="form-control" required name="color" id="color">
                    </div>
                    <div class="form-group">
                        <label>Status : </label>
                        <input type="text" class="form-control" required name="status" id="status">
                    </div>
                    <div class="form-group">
                        <label>Category : </label>
                        <select name="category" id="category">
                            <c:forEach var="category" items="${categoryList}">
                                <c:choose>
                                    <c:when test="${product.category == category.name}">
                                        <option value="${category.name}" selected>${category.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${category.name}">${category.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
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
    function setIdEdit(id, name, price, numbers, color, status, category) {
        console.log(id, name, price, numbers, color, status, category);
        document.getElementById("id").value = id;
        document.getElementById("name").value = name;
        document.getElementById("price").value = price;
        document.getElementById("numbers").value = numbers;
        document.getElementById("color").value = color;
        document.getElementById("status").value = status;
        document.getElementById("category").value = category;

    }
</script>
</body>
</html>
