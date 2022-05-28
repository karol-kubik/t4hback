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
        <ul>
            <li><a href="home" class="nav-link">Home</a></li>
        </ul>
    </div>
</header>
<br>
<div class="content">
    <div class="colGauche"></div>
    <div class="colMilieu">
        <div class="account-page-grid">
            <div class="user-profile">
                <img src="https://st3.depositphotos.com/6672868/13801/v/600/depositphotos_138013506-stock-illustration-user-profile-group.jpg" class="profile-img" alt="">
                <h2 class="user-name"><c:out value="${email}" /></h2>
                <button onclick="window.location.href='user_profile?uid=<c:out value="${requestScope.uid}" />';" class="myProfile">My profile</button>
                <button onclick="window.location.href='edit_user?uid=<c:out value="${requestScope.uid}" />';" class="myProfile">Change my info</button>
                <button onclick="window.location.href='signout';" class="buttonType2">Sign out</button>
            </div>
            <a href="create_housing.jsp">
                <div class="tile tile1">
                    <h3>Add</h3>
                    <p>Add a new housing</p>
                </div>
            </a>

            <a href="my_housings">
                <div class="tile tile2">
                    <h3>My housings</h3>
                    <p>Manage your housings</p>
                </div>
            </a>

            <a href="my_bookings">
                <div class="tile tile3">
                    <h3>My bookings</h3>
                    <p>Manage your bookings</p>
                </div>
            </a>
        </div>
    </div>
    <div class="colDroite"></div>
</div>

</body>

</html>