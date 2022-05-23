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
					class="nav-link">End Booking</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="end_book" method="post">

				<caption>
					<h2>
						Before closing this booking, rate it
					</h2>
				</caption>

				<input type="hidden" name="id_rent" value="<c:out value='${rent.id_rent}' />" />

				<fieldset class="form-group">
					<label>Rating (from 1 to 5)</label> <input type="text"
						value="<c:out value='${rent.eval}' />" class="form-control"
						name="eval" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Comment</label> <input type="text"
						value="<c:out value='${rent.comment}' />" class="form-control"
						name="comment" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Send rating and close booking</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
