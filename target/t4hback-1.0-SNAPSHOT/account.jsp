<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Connection succesful</title>
</head>
<body>
<h1>You are connected.</h1>
<a href="create_housing.jsp">Create a housing</a><br>
<a href="my_housings">Show my current housings</a><br>
<a href="user_profile?uid=<c:out value="${requestScope.uid}" />">My profile</a><br>
<a href="my_bookings">Show my current bookings</a><br>
</body>
</html>
