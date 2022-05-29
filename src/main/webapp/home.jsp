<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>Task4home</title>
    <link rel="stylesheet" href="./css/style.css" type="text/css">
</head>

<body>
<header>
    <div id="imageLogo" >
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
        <form class="search-card" action="search_housing">

            <caption>
                <h2>
                    Search
                </h2>
            </caption>

            <fieldset class="form-group">
                <input type="text" value="" class="search-input" name="keyword" placeholder="Keywords">

            </fieldset>
            <button type="submit" class="btn btn-success">Search</button>
        </form>

        <form class="search-card" action="search_housing">

            <fieldset class="form-group">
                <input type="text" value="" class="search-input" name="city" placeholder="City">
            </fieldset>
            <button type="submit" class="btn btn-success">Search</button>
        </form>

        <form class="search-card" action="search_housing_constraints">

                <h3>Constraints :</h3>
                <select class="search-select" name="noSmoke" id="noSmoke">
                    <option value="" disabled selected>No Smoking ?</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                <select class="search-select" name="noiseCurfew" id="noiseCurfew">
                    <option value="" disabled selected>Noise Curfew ?</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                <select class="search-select" name="noChild" id="noChild">
                    <option value="" disabled selected>No Children ?</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                <select class="search-select" name="noPets" id="noPets">
                    <option value="" disabled selected>No Pets ?</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>

            </fieldset>
            <button type="submit" class="btn btn-success">Search</button>
        </form>

        <form class="search-card" action="search_housing_tasks">

                <h3>Looking for :</h3>
                <select class="search-select" name="petKeep" id="petKeep">
                    <option value="" disabled selected>Pet Keeping ?</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                <select class="search-select" name="plantWater" id="plantWater">
                    <option value="" disabled selected>Plant Watering ?</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
                <select class="search-select" name="houseClean" id="houseClean">
                    <option value="" disabled selected>House Cleaning ?</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
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
                    <p class="card-subtitle">Constraints:</p>
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