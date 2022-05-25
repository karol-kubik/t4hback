<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
	<title>Task4Home</title>
	<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>

<body>
<header>
	<div id="imageLogo">
		<img id="logo" src="./Images/Logo.png" alt="Task4Home Logo">
		<h1>TASK4<span id="home">HOME</span></h1>
	</div>
	<div class="navigation">
		<ul>
			<li><a href="home">Home</a></li>
		</ul>
	</div>
</header>
<br>
<div class="content">
	<div class="colGauche"></div>
	<div class="colMilieu">
		<form action="send_booking">

			<caption>
				<h2>
					Book this housing
				</h2>
			</caption>

			<input type="hidden" name="id_housing" value="<c:out value='${housing.id_housing}' />">

			<input type="hidden" name="id_owner" value="<c:out value='${housing.id_owner}' />">

			<input type="hidden" name="id_guest" value="<c:out value='${gid}' />">

			<fieldset class="form-group">
				<input type="date" class="form-control" name="startDate" required="required" placeholder="startDate">
			</fieldset>
			<fieldset class="form-group">
				<input type="date" class="form-control" name="endDate" required="required" placeholder="endDate">
			</fieldset>
			<button type="submit" class="btn btn-success">Send Booking Request</button>
		</form>
	</div>
	<div class="colDroite"></div>
</div>

</body>

</html>
