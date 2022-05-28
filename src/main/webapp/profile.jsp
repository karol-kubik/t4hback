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
            <li><a href="login" class="nav-link">My account</a></li>
        </ul>
    </div>
</header>
<br>
<div class="content">
    <div class="colGauche"></div>
    <div class="colMilieu">
        <div class="content-tile">
            <h2>Profile</h2>
            <div class="profile-infos">
                <div class="first-name">
                    <p class="profile-info-title">First Name : </p>
                    <p class="profile-info"><c:out value="${resultUser.firstname}" /></p>
                </div>
                <div class="last-name">
                    <p class="profile-info-title">Last Name :</p>
                    <p class="profile-info"><c:out value="${resultUser.lastname}" /></p>
                </div>
                <div class="gender">
                    <p class="profile-info-title">Gender :</p>
                    <p class="profile-info"><c:out value="${resultUser.gender}" /></p>
                </div>
                <div class="email">
                    <p class="profile-info-title">E-mail :</p>
                    <p class="profile-info"><c:out value="${resultUser.email}" /></p>
                </div>
                <div class="phone">
                    <p class="profile-info-title">Phone :</p>
                    <p class="profile-info"><c:out value="${resultUser.phone}" /></p>
                </div>
            </div>
            <div class="edit-profile-button">
                <button class="buttonType2" onlick="account.jsp">Contact user</button>
            </div>

        </div>
    </div>
    <div class="colDroite"></div>
</div>

</body>

</html>

