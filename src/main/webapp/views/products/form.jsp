<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
    <h2>${product == null ? "Create Product" : "Edit Product" }</h2>
    <form action="${pageContext.request.contextPath}/products/${product == null ? 'create' : 'update'}" method="post">
    
    	<input type="hidden" name="id" value="${product.getId()}"><br/>
        Nome: <input type="text" name="name" value="${product.getName()}" required><br/>
        Descrição: <input type="text" name="description" value="${product.getDescription()}" required><br/>
        Preço: <input type="number" step="0.01" name="price" value="${product.getPrice()}" required><br/>
        Quantidade: <input type="number" name="quantity" value="${product.getQuantity()}" required><br/>
        <div class="form-buttons">
        <button type="submit">Save</button>
    	<button type="button" onclick="window.location.href='${pageContext.request.contextPath}/products/list'">Cancel</button>
        </div>
            </form>
</body>
</html>
