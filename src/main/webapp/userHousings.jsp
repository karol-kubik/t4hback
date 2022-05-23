<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Task4Home</title>
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
            <li><a href="login" class="nav-link">My account</a></li>
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
            <c:forEach var="listHousing" items="${listHousing}">

                <tr>
                    <td><c:out value="${listHousing.title}" /></td>
                    <td><c:out value="${listHousing.address}" /></td>
                    <td><c:out value="${listHousing.city}" /></td>
                    <td><c:out value="${listHousing.description}" /></td>
                    <td><c:out value="${listHousing.noSmoke}" /></td>
                    <td><c:out value="${listHousing.noiseCurfew}" /></td>
                    <td><c:out value="${listHousing.noChild}" /></td>
                    <td><c:out value="${listHousing.noPets}" /></td>
                    <td><c:out value="${listHousing.petKeep}" /></td>
                    <td><c:out value="${listHousing.plantWater}" /></td>
                    <td><c:out value="${listHousing.houseClean}" /></td>
                    <td><a href="edit_housing?hid=<c:out value='${listHousing.id_housing}' />">Edit</a>
&nbsp;&nbsp;&nbsp;&nbsp;                    <a href="delete_housing?hid=<c:out value='${listHousing.id_housing}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
