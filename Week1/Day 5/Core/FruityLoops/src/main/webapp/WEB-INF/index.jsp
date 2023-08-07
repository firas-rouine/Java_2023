<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="/css/style.css">

<title>Insert title here</title>
</head>
<body>
    <h1>Fruit Store</h1>
        <table class="table table-striped table-dark">
        <thead class="thead-dark">
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach var="oneFruit" items="${fruits}">
  
  <tr>
  <td>${oneFruit.name}</td>
  <td>${oneFruit.price}</td>
  </tr>
  </c:forEach>
  </tbody>
        </table>
    

</body>
</html>