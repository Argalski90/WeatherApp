<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css">

        <title>Weather App</title>
    </head>
    <body>
        <h1>Weather</h1>
        <hr>

        <c:if test="${weather != null}">
            Temperature Celsius: ${weather.temperatureCelsius}<br/>
            Temperature Kelvin: ${weather.temperatureKelvin}<br/>
            Preasure: ${weather.preasure}<br/>
        </c:if>

        <c:if test="${error == true}">
            Error during web service call
        </c:if>

        <c:url var="weatherUrl" value="/weather"/>
        <form:form method="post" action="${weatherUrl}" modelAttribute="weatherForm">
            <form:input path="city"/><br/>
            <input type="submit" value="Check Weather">
        </form:form>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>