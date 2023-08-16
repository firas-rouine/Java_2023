
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
   <div class="d-flex justify-content-between">
   <h1>${oneBook.title } </h1>
   <a href="/books">back</a></div>
 <c:if test="${user_id == oneBook.poster.id}">
    <p>you read <span style="color: purple;">${oneBook.title}</span> by <span style="color: green;">${oneBook.author}</span></p>
    <p> Here are your thoughts </p>
</c:if>
 <c:if test="${user_id != oneBook.poster.id}">
    <p><span style="color: red;">${oneBook.poster.userName}</span> read <span style="color: purple;">${oneBook.title}</span> by <span style="color: green;">${oneBook.author}</span></p>
    <p> Here are ${oneBook.poster.userName}'s thoughts </p>
</c:if>
<hr>
<p>${oneBook.thoughts}</p>
<hr>
<c:if test="${user_id == oneBook.poster.id }">
   <div class="d-flex ">
   	<a href="/books/${oneBook.id }/edit" class="btn btn-secondary m-3">Edit</a>
   	<form action="/books/${oneBook.id }" method="post" >
   	<input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete" class="btn btn-secondary m-3">
   	</form>
  </div>
   </c:if>
   

   
   

   </div>
</body>
</html>