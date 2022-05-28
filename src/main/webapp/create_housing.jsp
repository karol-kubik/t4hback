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
                <select name="noSmoke" id="noSmoke">
                    <option value="" disabled selected>No Smoking ?</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
                </select>
                <select name="noiseCurfew" id="noiseCurfew">
                    <option value="" disabled selected>Noise Curfew ?</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
                </select>
                <select name="noChild" id="noChild">
                    <option value="" disabled selected>No Children ?</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
                </select>
                <select name="noPets" id="noPets">
                    <option value="" disabled selected>No Pets ?</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
                </select>

                <h3>Looking for :</h3>
                <select name="petKeep" id="petKeep">
                    <option value="" disabled selected>Pet Keeping ?</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
                </select>
                <select name="plantWater" id="plantWater">
                    <option value="" disabled selected>Plant Watering ?</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
                </select>
                <select name="houseClean" id="houseClean">
                    <option value="" disabled selected>House Cleaning ?</option>
                    <option value="1">Yes</option>
                    <option value="0">No</option>
                </select>

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
