<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Housings</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Task4Home </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/housing/list_housing"
                   class="nav-link">Housings</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of my housings</h3>
        <hr>
        <div class="container text-left">

        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Title</th>
                <th>Address</th>
                <th>City</th>
                <th>Description</th>
                <th>No Smoking</th>
                <th>Noise Curfew</th>
                <th>No Child</th>
                <th>No Pets</th>
                <th>Pet Keeping</th>
                <th>Plant Watering</th>
                <th>House Cleaning</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="housing" items="${listHousing}">

                <tr>
                    <td><c:out value="${housing.title}" /></td>
                    <td><c:out value="${housing.address}" /></td>
                    <td><c:out value="${housing.city}" /></td>
                    <td><c:out value="${housing.description}" /></td>
                    <td><c:out value="${housing.noSmoke}" /></td>
                    <td><c:out value="${housing.noiseCurfew}" /></td>
                    <td><c:out value="${housing.noChild}" /></td>
                    <td><c:out value="${housing.noPets}" /></td>
                    <td><c:out value="${housing.petKeep}" /></td>
                    <td><c:out value="${housing.plantWater}" /></td>
                    <td><c:out value="${housing.houseClean}" /></td>
                    <td><a href="/edit_housing?id=<c:out value='${housing.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="/delete_housing?id=<c:out value='${housing.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
