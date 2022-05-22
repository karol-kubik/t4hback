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
        <img id="logo" src="/Images/Logo.png" alt="Task4Home Logo">
        <h1>TASK4<span id="home">HOME</span></h1>
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
        <c:if test="${housing != null}">
        <form action="updateHousing" method="post">
            </c:if>
            <c:if test="${housing == null}">
            <form action="newHousing" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${housing != null}">
                            Edit my housing
                        </c:if>
                        <c:if test="${housing == null}">
                            Submit a housing
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${housing != null}">
                    <input type="hidden" name="id_housing" value="<c:out value='${housing.id_housing}' />" />
                    <input type="hidden" name="id_owner" value="<c:out value='${housing.id_owner}' />" />
                </c:if>

            <fieldset class="form-group">
                <input type="text" value="<c:out value='${housing.title}' />" class="form-control" name="title" required="required" placeholder="Title">
                <input type="text" value="<c:out value='${housing.address}' />" class="form-control" name="address" required="required" placeholder="Address">
                <input type="text" value="<c:out value='${housing.city}' />" class="form-control" name="city" required="required" placeholder="City">
                <textarea name="description" value="<c:out value='${housing.description}' />" placeholder="Description"></textarea>

                <h3>Constraints :</h3>
                <input type="checkbox" name="noSmoke" id="noSmoke" value="<c:out value='${housing.noSmoke}' />">
                <label for="noSmoke">Non smoker</label>
                <input type="checkbox" name="noiseCurfew" id="noiseCurfew" value="<c:out value='${housing.noiseCurfew}' />">
                <label for="noiseCurfew">Noise curfew</label>
                <input type="checkbox" name="noChild" id="noChildren" value="<c:out value='${housing.noChild}' />">
                <label for="noChildren">No children</label>
                <input type="checkbox" name="noPets" id="noPets" value="<c:out value='${housing.noPets}' />">
                <label for="noPets">No pets</label>

                <h3>Looking for :</h3>
                <input type="checkbox" name="houseClean" id="houseClean" value="<c:out value='${housing.houseClean}' />">
                <label for="houseClean">House cleaning</label>
                <input type="checkbox" name="petKeep" id="petKeep" value="<c:out value='${housing.petKeep}' />">
                <label for="petKeep">Pet keeping</label>
                <input type="checkbox" name="plantWater" id="plantWater" value="<c:out value='${housing.plantWater}' />">
                <label for="plantWater">Plant watering</label>

            </fieldset>
            <c:if test="${housing != null}">
                <button type="submit" class="btn btn-success">Edit Housing</button>
            </c:if>
            <c:if test="${housing == null}">
                <button type="submit" class="btn btn-success">Create Housing</button>
            </c:if>
        </form>
    </div>
    <div class="colDroite"></div>
</div>

</body>

</html>
