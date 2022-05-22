<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create/Update a housing</title>
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
            <li><a href="home" class="nav-link">Home</a></li>
        </ul>

    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${housing != null}">
            <form action="housing/update" method="post">
                </c:if>
                <c:if test="${housing == null}">
                <form action="housing/insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${housing != null}">
                                Edit Housing
                            </c:if>
                            <c:if test="${housing == null}">
                                Add New Housing
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${housing != null}">
                        <input type="hidden" name="id" value="<c:out value='${housing.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>ID of the owner</label> <input type="text"
                                                        value="<c:out value='${housing.id_owner}' />" class="form-control"
                                                        name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Title</label> <input type="text"
                                                         value="<c:out value='${housing.title}' />" class="form-control"
                                                         name="email">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Address</label> <input type="text"
                                                           value="<c:out value='${housing.address}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>City</label> <input type="text"
                                                           value="<c:out value='${housing.city}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Description of the housing</label> <input type="text"
                                                           value="<c:out value='${housing.description}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Condition 1 : No smoking allowed ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.noSmoke}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Condition 2 : Noise Curfew ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.noiseCurfew}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Condition 3 : No child allowed ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.noChild}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Condition 4 : No pets allowed ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.noPets}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task 1 : Pet keeping ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.petKeep}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task 2 : Plan Watering ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.plantWater}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task 3 : House Cleaning ?</label> <input type="checkbox"
                                                           value="<c:out value='${housing.houseClean}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>