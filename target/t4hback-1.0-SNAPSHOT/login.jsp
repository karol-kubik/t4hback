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
		<ul class="navbar-nav">
			<li><a href="home" class="nav-link">Home</a></li>
		</ul>
	</div>
</header>
<br>
<div class="content">
	<div class="colGauche"></div>
	<div class="colMilieu">
		<form action="user">

			<caption>
				<h2>
					Log in
				</h2>
			</caption>

			<c:if test="${error != null}">
				<p class="error"><c:out value='${error}' /></p>
			</c:if>

			<fieldset class="form-group">
				<input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email" required="required" placeholder="e-mail">
				<input type="password" value="<c:out value='${user.password}' />" class="form-control" name="password" required="required" placeholder="password">
			</fieldset>

			<button type="submit" class="btn btn-success">Log in</button>
			<br>
			<label>First time user ?</label>
			<button id="register" type="submit" class="buttonType2" onclick="window.location.href='signup.jsp';">Register</button>
		</form>
	</div>
	<div class="colDroite"></div>
</div>

</body>

</html>
