
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container ">
		<div class="d-flex justify-content-between mt-5">
			<h2 class="text-success">Edit expense</h2>
			<a href="/expenses">Go back</a>
		</div>

		<form:form action="/expenses/edit/${travel.id }" method="post"
			modelAttribute="travel" class="mt-4">
			<input type="hidden" name="_method" value="put">
			     <form:errors class="text-danger" path="*"/>
        <div class="form-group">
            <form:label path="name">Expense Name</form:label>
            <form:input path="name" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="vendor">Vendor</form:label>
            <form:input path="vendor" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="amount">Amount</form:label>
            <form:input type="number" path="amount" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="description">Description</form:label>
            <form:textarea path="description" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary m-3">Submit</button>
		</form:form>
	</div>
</body>
</html>