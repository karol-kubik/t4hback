<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit a housing</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Task4Home </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/housing/list_housing"
                   class="nav-link">Housings</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="updateHousing" method="post">

                    <caption>
                        <h2>
                            Edit a housing
                        </h2>
                    </caption>

                    <input type="hidden" name="id_housing" value="<c:out value='${housing.id_housing}' />" />

                    <input type="hidden" name="id_owner" value="<c:out value='${housing.id_owner}' />" />

                    <fieldset class="form-group">
                        <label>Title</label> <input type="text"
                                                         value="<c:out value='${housing.title}' />" class="form-control"
                                                         name="title">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Address</label> <input type="text"
                                                           value="<c:out value='${housing.address}' />" class="form-control"
                                                           name="address">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>City</label> <input type="text"
                                                           value="<c:out value='${housing.city}' />" class="form-control"
                                                           name="city">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Description of the housing</label> <input type="text"
                                                           value="<c:out value='${housing.description}' />" class="form-control"
                                                           name="description">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Condition 1 : No smoking allowed ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.noSmoke}' />" class="form-control"
                                                           name="noSmoke">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Condition 2 : Noise Curfew ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.noiseCurfew}' />" class="form-control"
                                                           name="noiseCurfew">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Condition 3 : No child allowed ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.noChild}' />" class="form-control"
                                                           name="noChild">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Condition 4 : No pets allowed ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.noPets}' />" class="form-control"
                                                           name="noPets">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task 1 : Pet keeping ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.petKeep}' />" class="form-control"
                                                           name="petKeep">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task 2 : Plan Watering ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.plantWater}' />" class="form-control"
                                                           name="plantWater">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task 3 : House Cleaning ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.houseClean}' />" class="form-control"
                                                           name="houseClean">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Edit housing</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
