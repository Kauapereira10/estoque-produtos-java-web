<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
    <h2>Lista de Produtos</h2>
    
    <table border="1" cellpadding="5">
       <thead>
       <tr>
       		<th>ID</th>
       		<th>Nome do Produto</th>
       		<th>Descriçao</th>
       		<th>Preço</th>
       		<th>Quantidade</th>
       		<th>Status</th>
       </tr>
       </thead>
       <tbody>
       <c:forEach var="produto" items="${listar}">
       <tr>
       		<td>${produto.id}</td>
       		<td>${produto.nome}</td>
       		<td>${produto.descricao}</td>
       		<td>${produto.preco}</td>
       		<td>${produto.quantidade}</td>
       		<td>${produto.dataCadastro}</td>
       		<td>${produto.ativo}</td>
       		<td>
       			<a href="editar?id=${produto.id}">Editar</a>
       			<a href="desativar?id=${produto.id}" onclick="return confirm('Deseja desativar este produto?');">Desativar</a>

       		</td>
       </tr>
       </c:forEach>
       
       </tbody>
       
       <br/>
       
       <a href="cadastrar">Novo Produto</a>
    </table>
</body>
</html>
