<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="text-justify">
<div class="border border-dark m-5 p-3">
<h1 >Here'is your omikuji</h1>
<p> In ${number} years,you will live in ${city} with ${person} as your rommate,${hobby} for a living.
The next time you will see ${type},you will have good luck.
Also,${description }. </p>
<a href="/omikuji"> Go back</a>
</div>

</body>
</html>