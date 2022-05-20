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
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Booking</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="send_booking" method="post">

				<caption>
					<h2>
						Book this home
					</h2>
				</caption>

				<input type="hidden" name="id_housing" value="<c:out value='${housing.id_housing}' />" />

				<input type="hidden" name="id_owner" value="<c:out value='${housing.id_owner}' />" />

				<input type="hidden" name="id_housing" value="<c:out value='${gid}' />" />

				<fieldset class="form-group">
					<label>Start date of the booking</label> <input type="date"
						value="<c:out value='${rent.startDate}' />" class="form-control"
						name="startDate" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>End date of the booking</label> <input type="date"
						value="<c:out value='${rent.endDate}' />" class="form-control"
						name="endDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Send booking proposition</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
