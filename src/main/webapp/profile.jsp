<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h4>Firstname : <c:out value="${resultUser.firstname}"/></h4><br>
<h4>Lastname : <c:out value="${resultUser.lastname}" /></h4><br>
<h4>Gender : <c:out value="${resultUser.gender}" /></h4><br>
<h4>Email : <c:out value="${resultUser.email}" /></h4><br>
<h4>Phone : <c:out value="${resultUser.phone}" /></h4><br>
</body>
</html>
