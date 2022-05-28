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
            <li><a href="login" class="nav-link">My account</a></li>
        </ul>
    </div>
</header>
<br>
<div class="content">
    <div class="colGauche">
    </div>

    <div class="colMilieu">
        <div class="card-section-title">
            <h2>My housings</h2>
        </div>
        <c:forEach var="listHousing" items="${listHousing}">
            <div class="card">
                <div class="card-img-container">
                    <img src="https://www.book-a-flat.com/magazine/wp-content/uploads/2016/12/espace-optimise-appartement-meuble-paris.jpg" class="card-img" alt="">
                </div>
                <div class="card-text">
                    <p class="card-title"><c:out value="${listHousing.title}" /></p>
                    <p class="card-subtitle">in :&nbsp;<span class=""><c:out value="${listHousing.city}" /></span></p>
                    <div class="card-constraints">
                        <c:if test="${listHousing.noiseCurfew == true}">
                            <p class="card-constraint">Noise curfew</p>
                        </c:if>

                        <c:if test="${listHousing.noSmoke == true}">
                            <p class="card-constraint">Non smoker</p>
                        </c:if>

                        <c:if test="${listHousing.noChild == true}">
                            <p class="card-constraint">No children</p>
                        </c:if>

                        <c:if test="${listHousing.noPets == true}">
                            <p class="card-constraint">No pets</p>
                        </c:if>
                    </div>
                    <p class="card-subtitle">Looking for :</p>
                    <div class="card-constraints">
                        <c:if test="${listHousing.houseClean == true}">
                            <p class="card-constraint">Cleaning</p>
                        </c:if>

                        <c:if test="${listHousing.petKeep == true}">
                            <p class="card-constraint">Pet keeping</p>
                        </c:if>

                        <c:if test="${listHousing.plantWater == true}">
                            <p class="card-constraint">Plant watering</p>
                        </c:if>
                    </div>
                    <div style="display: flex; flex-wrap:wrap;">
                        <button class="card-button buttonType2" onclick="window.location.href='housing_page?hid=<c:out value="${listHousing.id_housing}" />';"> See more</button>
                        <button class="card-button buttonType2" onclick="window.location.href='edit_housing?hid=<c:out value='${listHousing.id_housing}' />';"/> Edit</button>
                        <button class="card-button buttonType2" onclick="window.location.href='delete_housing?hid=<c:out value='${listHousing.id_housing}' />';"> Delete</button>
                    </div>

                </div>

            </div>
        </c:forEach>
    </div>
    <div class="colDroite"></div>
</div>

</body>

</html>
