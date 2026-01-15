<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário Produto</title>
</head>
<body>
	<h2>Produtos</h2>
	<form action="produtos" method="post">
	<input type="hidden" name="id" value="${produtos.id})">
	Nome: <input type="text" name="nome" value="${produos.nome}" required"><br/>
	Descrição: <input type="text" name="descricao" value="${produos.descricao}" required"><br/>
	Preço: <input type="number" name="preco" value="${produos.preco}" required"><br/>
	Quantidade: <input type="number" name="quantidade" value="${produos.quantidade}" required"><br/>
	<button type="submit"></button>
	</form>
</body>
</html>