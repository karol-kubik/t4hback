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
		<a href="home">
			<img id="logo" src="./Images/Logo.png" alt="Task4Home Logo" >
			<h1>TASK4<span id="home">HOME</span></h1>
		</a>
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
		<form action="end_book">

			<caption>
				<h2>
					Before closing this booking, rate it
				</h2>
			</caption>

			<input type="hidden" name="id_rent" value="<c:out value='${rent.id_rent}' />" />

			<fieldset class="form-group">
				<select name="eval" id="eval">
					<option value="" disabled selected>Rating</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</fieldset>

			<fieldset class="form-group">
				<input type="text" value="<c:out value='${rent.comment}' />" class="form-control" name="comment" required="required" placeholder="comment">
			</fieldset>

			<button type="submit" class="btn btn-success">Send rating and close booking</button>
			<br>
		</form>
	</div>
	<div class="colDroite"></div>
</div>

</body>

</html>
