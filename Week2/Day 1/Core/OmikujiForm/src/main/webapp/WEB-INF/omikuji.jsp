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
<body>

<form class="m-5 p-3 border border-dark" action="/create" method="POST">
<h1 class="text-justify">Send an omikuji</h1>
<div class="form-group">
<label>Pick any number from 5 to 25</label>
<input class="form-control" type="number" name="number">
</div>
<div class="form-group">
<label>Enter a name of any city</label>
<input class="form-control" name="city">
</div>
<div class="form-group">
<label>Enter a name of any real person</label>
<input class="form-control" name="person">
</div>
<div>
<label>Enter a professional endeavor or hobby</label>
<input class="form-control" name="hobby">
</div>
<div class="form-group">
<label>Enter any type of living thing</label>
<input class="form-control"  name="type">
</div>
<div class="form-group">
<label>Say something nice to someone</label>
<textarea class="form-control"  name="description"></textarea>
</div>
<div class="form-group">
<label>Send and show a friend</label>
<button class="btn btn-primary m-3">submit</button>
</div>

</form>

</body>
</html>