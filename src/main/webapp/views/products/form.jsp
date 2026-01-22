<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário Produto</title>
</head>
<body>
    <h2>${product == null ? "Create Product" : "Edit Product" }</h2>
    <form action="${pageContext.request.contextPath}/products/${product == null ? 'create' : 'update'}" method="post">
    
    	<input type="hidden" name="id" value="${product.getId()}"><br/>
        Nome: <input type="text" name="name" value="${product.getName()}" required><br/>
        Descrição: <input type="text" name="description" value="${product.getDescription()}" required><br/>
        Preço: <input type="number" step="0.01" name="price" value="${product.getPrice()}" required><br/>
        Quantidade: <input type="number" name="quantity" value="${product.getQuantity()}" required><br/>
        
        <button type="submit">Salvar</button>
    	<button type="button" onclick="window.location.href='${pageContext.request.contextPath}/products/list'">Cancelar</button>
    </form>
</body>
</html>
