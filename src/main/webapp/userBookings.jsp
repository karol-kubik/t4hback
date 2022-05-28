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
            <h2>My bookings</h2>
        </div>
        <c:forEach var="listGuestRentsFull" items="${listGuestRentsFull}">
            <div class="card">
                <div class="card-img-container">
                    <img src="https://www.book-a-flat.com/magazine/wp-content/uploads/2016/12/espace-optimise-appartement-meuble-paris.jpg" class="card-img" alt="">
                </div>
                <div class="card-text">
                    <p class="card-title"><c:out value="${listGuestRentsFull.housingTitle}" /></p>
                    <p class="card-subtitle">in :&nbsp;<span class=""><c:out value="${listGuestRentsFull.housingAddress}" /></span></p>
                    <div class="card-constraints">
                    </div>
                    <c:if test="${listGuestRentsFull.state == 'accepted'}">
                        <p class="card-subtitle">Address :&nbsp<span><c:out value="${listGuestRentsFull.housingCity}" /></span></p>
                    </c:if>
                    <c:if test="${listGuestRentsFull.state == 'closed'}">
                        <p class="card-subtitle">Address :&nbsp<span><c:out value="${listGuestRentsFull.housingCity}" /></span></p>
                    </c:if>
                    <p class="card-subtitle">Owner :&nbsp<span><c:out value="${listGuestRentsFull.ownerFirstname}" /></span>&nbsp<span><c:out value="${listGuestRentsFull.ownerLastname}" /></span></p>
                    <p class="card-subtitle">Start date :&nbsp<span><c:out value="${listGuestRentsFull.startDate}" /></span></p>
                    <p class="card-subtitle">End date :&nbsp<span><c:out value="${listGuestRentsFull.endDate}" /></span></p>
                    <p class="card-subtitle">Current state :&nbsp<span><c:out value="${listGuestRentsFull.state}" /></span></p>
                    <p class="card-rating">Rating : <span class="rating"><c:out value="${listGuestRentsFull.eval}" /></span>/5</p>
                    <p class="card-subtitle" style="display: block;">Comment : <span><c:out value="${listGuestRentsFull.comment}" /></span></p>

                    <div style="display: flex; flex-wrap:wrap;">
                        <button class="card-button buttonType2" onclick="window.location.href='housing_page?hid=<c:out value="${listGuestRentsFull.id_housing}" />';"> See more</button>
                        <c:if test="${listGuestRentsFull.state == 'accepted'}">
                            <button class="card-button buttonType2" onclick="window.location.href='end_booking?rid=<c:out value='${listGuestRentsFull.id_rent}' />';"> Close booking</button>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>

        <div class="card-section-title">
            <h2>My clients bookings</h2>
        </div>
        <c:forEach var="listOwnerRentsFull" items="${listOwnerRentsFull}">
            <div class="card">
                <div class="card-img-container">
                    <img src="https://www.book-a-flat.com/magazine/wp-content/uploads/2016/12/espace-optimise-appartement-meuble-paris.jpg" class="card-img" alt="">
                </div>
                <div class="card-text">
                    <p class="card-title"><c:out value="${listOwnerRentsFull.housingTitle}" /></p>
                    <div class="card-constraints">
                    </div>
                    <p class="card-subtitle">Guest :&nbsp<span><c:out value="${listOwnerRentsFull.guestFirstname}" /></span>&nbsp<span><c:out value="${listOwnerRentsFull.guestLastname}" /></span></p>
                    <p class="card-subtitle">Phone :&nbsp<span><c:out value="${listOwnerRentsFull.guestPhone}" /></span></p>
                    <p class="card-subtitle">Start date :&nbsp<span><c:out value="${listOwnerRentsFull.startDate}" /></span></p>
                    <p class="card-subtitle">End date :&nbsp<span><c:out value="${listOwnerRentsFull.endDate}" /></span></p>
                    <p class="card-subtitle">Current state :&nbsp<span><c:out value="${listOwnerRentsFull.state}" /></span></p>
                    <p class="card-rating">Rating : <span class="rating"><c:out value="${listOwnerRentsFull.eval}" /></span>/5</p>
                    <p class="card-subtitle" style="display: block;">Comment : <span><c:out value="${listOwnerRentsFull.comment}" /></span></p>

                    <div style="display: flex; flex-wrap:wrap;">
                        <c:if test="${listOwnerRentsFull.state == 'requested'}">
                            <button class="card-button buttonType2" onclick="window.location.href='accept_booking?rid=<c:out value='${listOwnerRentsFull.id_rent}' />';"> Accept proposal</button>
                            <button class="card-button buttonType2" onclick="window.location.href='reject_booking?rid=<c:out value='${listOwnerRentsFull.id_rent}' />';"> Reject proposal</button>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="colDroite"></div>
</div>

</body>

</html>