<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<p>You have visited http://localhost:8080/ ${count} times.</p>
<a href="/">Test another visit ?</a>
<br>
<a href="/increment">Increment by 2 ?</a>
<br>
<a class="btn btn-secondary" href="/reset">Reset</a>


</body>
</html>