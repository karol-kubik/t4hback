<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Task4Home</title>
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>

<header>

	<div id="imageLogo">
		<a href="home">
			<img id="logo" src="./Images/Logo.png" alt="Task4Home Logo" >
			<h1>TASK4<span id="home">HOME</span></h1>
		</a>
	</div>
</header>
<br>
<div class="content">
	<div class="colGauche"></div>
	<div class="colMilieu">
		<c:if test="${user != null}">
		<form action="update" method="post">
			</c:if>
			<c:if test="${user == null}">
			<form action="signup" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
							Edit my Account
						</c:if>
						<c:if test="${user == null}">
							Sign up
						</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<c:if test="${error != null}">
					<p class="error"><c:out value='${error}' /></p>
				</c:if>
				<fieldset>
				<input type="text" value="<c:out value='${user.email}' />"
					   class="form-control" name="email" required="required"
					   placeholder="e-mail">

				<input type="password"
					   value="<c:out value='${user.password}' />" class="form-control"
					   name="password" required="required" placeholder="password">

				<input type="text" value="<c:out value='${user.firstname}' />"
					   class="form-control" name="firstname" required="required"
					   placeholder="First Name">

				<input type="text"
					   value="<c:out value='${user.lastname}' />" class="form-control"
					   name="lastname" required="required" placeholder="Last Name">

				<input type="date" class="form-control" name="birthday" required="required" placeholder="Birthday">

				<input type="text" value="<c:out value='${user.phone}' />" class="form-control"
					   name="phone" required="required" placeholder="phone number">

				<select name="gender" id="gender">
					<option value="" disabled selected>Gender</option>
					<option value="Male">Male</option>
					<option value="Female">Female</option>
					<option value="Other">Other</option>
				</select>

				</fieldset>
				<button type="submit" class="btn btn-success">Register</button>
			</form>

	</div>
	<div class="colDroite"></div>
</div>
</body>
</html>
