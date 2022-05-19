<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1><c:out value="${resultHousing.title}"/></h1><br>
<h5>City : <c:out value="${resultHousing.city}" /></h5><br>
<h4>Description : <c:out value="${resultHousing.description}" /></h4><br>
<h2>Conditions : </h2><br>
<h4>No Smoking : <c:out value="${resultHousing.noSmoke}" /></h4><br>
<h4>Noise Curfew : <c:out value="${resultHousing.noiseCurfew}" /></h4><br>
<h4>No child : <c:out value="${resultHousing.noChild}" /></h4><br>
<h4>No pets : <c:out value="${resultHousing.noPets}" /></h4><br>
<h2>Tasks : </h2><br>
<h4>Pet Keeping : <c:out value="${resultHousing.petKeep}" /></h4><br>
<h4>Plant watering : <c:out value="${resultHousing.plantWater}" /></h4><br>
<h4>House Cleaning : <c:out value="${resultHousing.houseClean}" /></h4><br>
<h2>Owner : </h2><br>
<h4>Firstname : <c:out value="${resultHousingOwner.firstname}" /></h4><br>
<h4>Lastname : <c:out value="${resultHousingOwner.lastname}" /></h4><br>
<h4>Phone : <c:out value="${resultHousingOwner.phone}" /></h4><br>
<a href="user_profile?uid=<c:out value="${resultHousing.id_owner}" />">Owner profile</a>
</body>
</html>
