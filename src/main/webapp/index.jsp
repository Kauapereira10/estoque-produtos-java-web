<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<header>
		<h1>Sistema de Estoque</h1>
	</header>

	<nav>
		<a href="produtos" target="produtosFrame">Lista de Produtos</a> 
		<a href="produtos?action=form" target="produtosFrame">Adicionar Produtos</a>
	</nav>
	<main>
		<h1>Bem-vindo ao Sistema de Estoque</h1>
		<iframe src="apresentacao.html" name="produtosFrame"></iframe>
	</main>
</body>
</html>