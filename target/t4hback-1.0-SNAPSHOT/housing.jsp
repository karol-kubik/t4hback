<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title><c:out value="${resultHousing.title}"/> - Task4Home</title>
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
        <div class="content-tile-housing">
            <h2><c:out value="${resultHousing.title}"/></h2>
            <div class="housing-infos">
                <div style="display:flex; flex-wrap:wrap; align-items:center; font-size: 20px; margin-left: 30px;">
                    <p class="housing-city">in :&nbsp;<span><c:out value="${resultHousing.city}" /></span></p>
                    <c:if test="${rating == 0}">
                        <p class="housing-rating">Rated :&nbsp;<span>No ratings</span></p>
                    </c:if>
                    <c:if test="${rating != 0}">
                        <p class="housing-rating">Rated :&nbsp;<span><c:out value="${rating}" /></span>/5</p>
                    </c:if>
                </div>

                <div class="gallery">
                    <a href="http://www.abo-peoples.org/wp-content/uploads/2020/08/placeholder-600x400-1-300x200.png">
                        <img src="http://www.abo-peoples.org/wp-content/uploads/2020/08/placeholder-600x400-1-300x200.png" width="250" alt="">
                    </a>
                    <a href="http://www.abo-peoples.org/wp-content/uploads/2020/08/placeholder-600x400-1-300x200.png">
                        <img src="http://www.abo-peoples.org/wp-content/uploads/2020/08/placeholder-600x400-1-300x200.png" width="250" alt="">
                    </a>
                    <a href="http://www.abo-peoples.org/wp-content/uploads/2020/08/placeholder-600x400-1-300x200.png">
                        <img src="http://www.abo-peoples.org/wp-content/uploads/2020/08/placeholder-600x400-1-300x200.png" width="250" alt="">
                    </a>
                </div>
                <p class="description"><c:out value="${resultHousing.description}" /></p>
                <p class="conditions-tasks">Conditions :</p>
                <div class="housing-conditions-tasks">

                    <c:if test="${resultHousing.noiseCurfew == true}">
                        <p class="condition">Noise curfew</p>
                    </c:if>

                    <c:if test="${resultHousing.noSmoke == true}">
                        <p class="condition">Non smoker</p>
                    </c:if>

                    <c:if test="${resultHousing.noChild == true}">
                        <p class="condition">No children</p>
                    </c:if>

                    <c:if test="${resultHousing.noPets == true}">
                        <p class="condition">No pets</p>
                    </c:if>

                </div>
                <p class="conditions-tasks">Looking for :</p>
                <div class="housing-conditions-tasks">

                    <c:if test="${resultHousing.houseClean == true}">
                        <p class="condition">Cleaning</p>
                    </c:if>

                    <c:if test="${resultHousing.petKeep == true}">
                        <p class="condition">Pet keeping</p>
                    </c:if>

                    <c:if test="${resultHousing.plantWater == true}">
                        <p class="condition">Plant watering</p>
                    </c:if>

                </div>
            </div>
            <div class="edit-profile-button">
                <button onclick="window.location.href='book_housing?hid=<c:out value="${resultHousing.id_housing}" />';">Book this housing</button>
            </div>

        </div>

        <div class="owner-tile-housing">
            <h2>Meet the owner</h2>
            <div class="owner-infos">
                <p class="owner-info">First Name :&nbsp<span><c:out value="${resultHousingOwner.firstname}" /></span></p>
                <p class="owner-info">Last name :&nbsp<span><c:out value="${resultHousingOwner.lastname}" /></span></p>
                <p class="owner-info">Phone :&nbsp<span><c:out value="${resultHousingOwner.phone}" /></span></p>
                <div class="owner-profile-button">
                    <button onclick="window.location.href='user_profile?uid=<c:out value="${resultHousing.id_owner}" />';">Owner profile</button>
                </div>
            </div>
        </div>

        <c:if test="${admin != null}">
            <c:if test="${admin == true}">
                <button onclick="window.location.href='delete_housing?hid=<c:out value='${resultHousing.id_housing}' />';">Admin : Delete this housing</button>
            </c:if>
        </c:if>

    </div>
    <div class="colDroite"></div>
</div>

</body>

</html>
