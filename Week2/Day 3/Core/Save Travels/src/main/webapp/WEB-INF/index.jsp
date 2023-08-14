<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- Change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- Change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1 class="mt-5 text-primary">Save Travel</h1>

		<table class="table mt-4">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${travelList}" var="oneTravel">
					<tr>
						<td><a href="/expenses/${oneTravel.id}">${oneTravel.name }</a></td>
						<td>${oneTravel.vendor }</td>
						<td>$${oneTravel.amount }</td>
						<td><a href="/expenses/edit/${oneTravel.id}" class="mr-2">edit</a>
							<form action="/expenses/${oneTravel.id}" method="post"
								class="d-inline">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete" class="btn btn-danger">
							</form></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2 class="mt-5 text-primary">Add an expense</h2>
		<form:form action="/expenses" method="post" modelAttribute="travel"
			class="mt-4">
			<form:errors class="text-danger" path="*" />
			<div class="form-group">
				<form:label path="name">Expense Name</form:label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="vendor">Vendor</form:label>
				<form:input path="vendor" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="amount">Amount</form:label>
				<form:input type="number" path="amount" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:textarea path="description" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary m-3">Submit</button>
		</form:form>
	</div>
</body>
</html>
