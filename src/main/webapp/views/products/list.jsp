<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<h2>List Products</h2>

	<table border="1" cellpadding="5">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name Product</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Date Created</th>
				<th>In Stock</th>
				<th>option</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${list}">

				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.quantity}</td>
					<td>${product.formattedDate}</td>
					<td>${product.inStock}</td>
					<td>
					<a href="${pageContext.request.contextPath}/products/edit?id=${product.id}">Edit</a>
        			<a href="${pageContext.request.contextPath}/products/delete?id=${product.id}" onclick="return confirm('Do you want to delete this product?');">Delete</a>
        			</td>
				</tr>
			</c:forEach>

		</tbody>

		<br />

	</table>
</body>
</html>
