<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>Task4home</title>
    <link rel="stylesheet" href="./css/style.css" type="text/css">
</head>

<body>
<header>
    <div id="imageLogo">
        <img id="logo" src="/Images/Logo.png" alt="Task4Home Logo">
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
        <form action="">

            <caption>
                <h2>
                    Search
                </h2>
            </caption>

            <fieldset class="form-group">
                <input type="text" value="" class="search-input" name="email" required="required" placeholder="search for a place">
                <select name="City" id="gender">
                    <option value="" disabled selected>City</option>
                    <option value="city1">city1</option>
                    <option value="city2">city2</option>
                    <option value="city3">city3</option>
                </select>

                <h3>Constraints :</h3>
                <input type="checkbox" name="noSmoke" id="noSmoke">
                <label for="noSmoke">Non smoker</label><br>
                <input type="checkbox" name="noiseCurfew" id="noiseCurfew">
                <label for="noiseCurfew">Noise curfew</label><br>
                <input type="checkbox" name="noChild" id="noChild">
                <label for="noChild">No children</label><br>
                <input type="checkbox" name="noPets" id="noPets">
                <label for="noPets">No pets</label>

                <h3>Looking for :</h3>
                <input type="checkbox" name="houseClean" id="houseClean">
                <label for="houseClean">House cleaning</label><br>
                <input type="checkbox" name="petKeep" id="petKeep">
                <label for="petKeep">Pet keeping</label><br>
                <input type="checkbox" name="plantWater" id="plantWater">
                <label for="plantWater">Plant watering</label>

                <select name="rating" id="rating">
                    <option value="" disabled selected>minimum rating</option>
                    <option value="rating1">1/5</option>
                    <option value="rating2">2/5</option>
                    <option value="rating3">3/5</option>
                    <option value="rating4">4/5</option>
                    <option value="rating5">5/5</option>
                </select>
            </fieldset>


            <button type="submit" class="btn btn-success">Search</button>
        </form>
    </div>

    <div class="colMilieu">
        <c:forEach var="housing" items="${listHousing}">
            <div class="card">
                <div class="card-img-container">
                    <img src="https://www.book-a-flat.com/magazine/wp-content/uploads/2016/12/espace-optimise-appartement-meuble-paris.jpg" class="card-img" alt="">
                </div>
                <div class="card-text">
                    <p class="card-title"><c:out value="${housing.title}" /></p>
                    <p class="card-subtitle">in :&nbsp;<span class=""><c:out value="${housing.city}" /></span></p>
                    <div class="card-constraints">
                        <c:if test="${housing.noiseCurfew == true}">
                            <p class="card-constraint">Noise curfew</p>
                        </c:if>

                        <c:if test="${housing.noSmoke == true}">
                            <p class="card-constraint">Non smoker</p>
                        </c:if>

                        <c:if test="${housing.noChild == true}">
                            <p class="card-constraint">No children</p>
                        </c:if>

                        <c:if test="${housing.noPets == true}">
                            <p class="card-constraint">No pets</p>
                        </c:if>
                    </div>
                    <p class="card-subtitle">Looking for :</p>
                    <div class="card-constraints">
                        <c:if test="${housing.houseClean == true}">
                            <p class="card-constraint">Cleaning</p>
                        </c:if>

                        <c:if test="${housing.petKeep == true}">
                            <p class="card-constraint">Pet keeping</p>
                        </c:if>

                        <c:if test="${housing.plantWater == true}">
                            <p class="card-constraint">Plant watering</p>
                        </c:if>
                    </div>
                    <p class="card-rating">Rating : <span class="rating"><c:out value="${rating}" /></span>/5</p>
                    <button class="card-button buttonType2" onclick="window.location.href='housing_page?hid=<c:out value="${housing.id_housing}" />';"> See more</button>
                </div>

            </div>
        </c:forEach>
    </div>


    <div class="colDroite">

    </div>

</div>

</body>

</html>