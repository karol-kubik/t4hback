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
        <h3 class="text-center">List of my bookings</h3>
        <hr>
        <div class="container text-left">

        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Guest Id</th>
                <th>Owner Id</th>
                <th>Housing Id</th>
                <th>Start date</th>
                <th>End date</th>
                <th>Current state</th>
                <th>Rating</th>
                <th>Comment</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="listGuestRents" items="${listGuestRents}">

                <tr>
                    <td><c:out value="${listGuestRents.id_guest}" /></td>
                    <td><c:out value="${listGuestRents.id_owner}" /></td>
                    <td><c:out value="${listGuestRents.id_housing}" /></td>
                    <td><c:out value="${listGuestRents.startDate}" /></td>
                    <td><c:out value="${listGuestRents.endDate}" /></td>
                    <td><c:out value="${listGuestRents.state}" /></td>
                    <td><c:out value="${listGuestRents.eval}" /></td>
                    <td><c:out value="${listGuestRents.comment}" /></td>
                    <td>
                &nbsp;&nbsp;&nbsp;&nbsp;    <c:if test="${listGuestRents.state == 'requested'}">
                        </c:if>
                        <c:if test="${listGuestRents.state == 'rejected'}">
                        </c:if>
                        <c:if test="${listGuestRents.state == 'accepted'}">
                            <a href="end_booking?rid=<c:out value='${listGuestRents.id_rent}' />">Close booking</a>
                        </c:if>
                        <c:if test="${listGuestRents.state == 'closed'}">

                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>
        </table>
    </div>

    <div class="container">
        <h3 class="text-center">List of clients bookings</h3>
        <hr>
        <div class="container text-left">

        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Guest Id</th>
                <th>Owner Id</th>
                <th>Housing Id</th>
                <th>Start date</th>
                <th>End date</th>
                <th>Current state</th>
                <th>Rating</th>
                <th>Comment</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="listOwnerRents" items="${listOwnerRents}">

                <tr>
                    <td><c:out value="${listOwnerRents.id_guest}" /></td>
                    <td><c:out value="${listOwnerRents.id_owner}" /></td>
                    <td><c:out value="${listOwnerRents.id_housing}" /></td>
                    <td><c:out value="${listOwnerRents.startDate}" /></td>
                    <td><c:out value="${listOwnerRents.endDate}" /></td>
                    <td><c:out value="${listOwnerRents.state}" /></td>
                    <td><c:out value="${listOwnerRents.eval}" /></td>
                    <td><c:out value="${listOwnerRents.comment}" /></td>
                    <td>
                        &nbsp;&nbsp;&nbsp;&nbsp;    <c:if test="${listOwnerRents.state == 'requested'}">
                        <a href="reject_booking?rid=<c:out value='${listOwnerRents.id_rent}' />">Reject booking</a>
                        <a href="accept_booking?rid=<c:out value='${listOwnerRents.id_rent}' />">Accept booking</a>
                    </c:if>
                        <c:if test="${listOwnerRents.state == 'rejected'}">
                        </c:if>
                        <c:if test="${listOwnerRents.state == 'accepted'}">
                        </c:if>
                        <c:if test="${listOwnerRents.state == 'closed'}">

                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
