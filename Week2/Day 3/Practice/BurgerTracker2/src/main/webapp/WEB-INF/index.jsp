<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Burger</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- Change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script> <!-- Change to match your file/naming structure -->
</head>
<body>
<div class="container">
    <h1 class="mt-5">Burger Tracker</h1>

    <table class="table mt-4">
        <thead>
            <tr>
                <th>Burger Name</th>
                <th>Restaurant Name</th>
                <th>Rating (out of 5)</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${burgerList}" var="oneBurger">
                <tr>
                    <td>${oneBurger.burgerName }</td>
                    <td>${oneBurger.restName }</td>
                    <td>${oneBurger.rate }</td>
                    <td><a href="/burger/${oneBurger.id}/edit">edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2 class="mt-5">Add Burger</h2>
    <form:form action="/burger" method="post" modelAttribute="burger" class="mt-4">
        <form:errors class="text-danger" path="*"/>
        <div class="form-group">
            <form:label path="burgerName">Burger Name</form:label>
            <form:input path="burgerName" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="restName">Restaurant Name</form:label>
            <form:input path="restName" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="rate">Rate</form:label>
            <form:input type="number" path="rate" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="notes">Notes</form:label>
            <form:textarea path="notes" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
</html>
