<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
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
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="signup" method="post">
				<caption>
					<h2>
						Create an account
					</h2>
				</caption>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Firstname</label> <input type="text"
						value="<c:out value='${user.firstname}' />" class="form-control"
						name="firstname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Lastname</label> <input type="text"
						value="<c:out value='${user.lastname}' />" class="form-control"
						name="lastname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Birthday</label> <input type="text"
						value="<c:out value='${user.birthday}' />" class="form-control"
						name="birthday" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Gender</label> <input type="checkbox"
						value="<c:out value='${user.gender}' />" class="form-control"
						name="gender">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone</label> <input type="text"
						value="<c:out value='${user.phone}' />" class="form-control"
						name="phone" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Create my account</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
