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
        <c:forEach var="listGuestRents" items="${listGuestRents}">
            <div class="card">
                <div class="card-img-container">
                    <img src="https://www.book-a-flat.com/magazine/wp-content/uploads/2016/12/espace-optimise-appartement-meuble-paris.jpg" class="card-img" alt="">
                </div>
                <div class="card-text">
                    <p class="card-title"><c:out value="${listGuestRents.id_housing}" /></p>
                    <p class="card-subtitle">in :&nbsp;<span class="">city</span></p>
                    <div class="card-constraints">
                    </div>
                    <p class="card-subtitle">Adress :&nbsp<span>address</span></p>
                    <p class="card-subtitle">Owner :&nbsp<span><c:out value="${listGuestRents.id_owner}" /></span>&nbsp<span>TBD</span></p>
                    <p class="card-subtitle">Start date :&nbsp<span><c:out value="${listGuestRents.startDate}" /></span></p>
                    <p class="card-subtitle">End date :&nbsp<span><c:out value="${listGuestRents.endDate}" /></span></p>
                    <p class="card-subtitle">Current state :&nbsp<span><c:out value="${listGuestRents.state}" /></span></p>
                    <p class="card-rating">Rating : <span class="rating"><c:out value="${listGuestRents.eval}" /></span>/5</p>
                    <p class="card-subtitle" style="display: block;">Comment : <span><c:out value="${listGuestRents.comment}" /></span></p>

                    <div style="display: flex; flex-wrap:wrap;">
                        <button class="card-button buttonType2" onclick="window.location.href='housing_page?hid=<c:out value="${listGuestRents.id_housing}" />';"> See more</button>
                        <c:if test="${listGuestRents.state == 'accepted'}">
                            <button class="card-button buttonType2" onclick="window.location.href='end_booking?rid=<c:out value='${listGuestRents.id_rent}' />';"> Close booking</button>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>

        <div class="card-section-title">
            <h2>My clients' bookings</h2>
        </div>
        <c:forEach var="listOwnerRents" items="${listOwnerRents}">
            <div class="card">
                <div class="card-img-container">
                    <img src="https://www.book-a-flat.com/magazine/wp-content/uploads/2016/12/espace-optimise-appartement-meuble-paris.jpg" class="card-img" alt="">
                </div>
                <div class="card-text">
                    <p class="card-title"><c:out value="${listOwnerRents.id_housing}" /></p>
                    <p class="card-subtitle">in :&nbsp;<span class="">city</span></p>
                    <div class="card-constraints">
                    </div>
                    <p class="card-subtitle">Guest :&nbsp<span><c:out value="${listOwnerRents.id_owner}" /></span>&nbsp<span>TBD</span></p>
                    <p class="card-subtitle">Phone :&nbsp<span>phone</span></p>
                    <p class="card-subtitle">Start date :&nbsp<span><c:out value="${listOwnerRents.startDate}" /></span></p>
                    <p class="card-subtitle">End date :&nbsp<span><c:out value="${listOwnerRents.endDate}" /></span></p>
                    <p class="card-subtitle">Current state :&nbsp<span><c:out value="${listOwnerRents.state}" /></span></p>
                    <p class="card-rating">Rating : <span class="rating"><c:out value="${listOwnerRents.eval}" /></span>/5</p>
                    <p class="card-subtitle" style="display: block;">Comment : <span><c:out value="${listOwnerRents.comment}" /></span></p>

                    <div style="display: flex; flex-wrap:wrap;">
                        <c:if test="${listOwnerRents.state == 'requested'}">
                            <button class="card-button buttonType2" onclick="window.location.href='accept_booking?rid=<c:out value='${listOwnerRents.id_rent}' />';"> Accept proposal</button>
                            <button class="card-button buttonType2" onclick="window.location.href='reject_booking?rid=<c:out value='${listOwnerRents.id_rent}' />';"> Reject proposal</button>
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