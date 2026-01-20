<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema de Estoque</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
    <header>
        <h1>Sistema de Estoque</h1>
    </header>

    <nav>
        <a href="produtos/listarProdutos" target="produtosFrame">Lista de Produtos</a>
        <a href="produtos/cadastro" target="produtosFrame">Cadastro de Produto</a>
    </nav>

    <main>
        <h2>Bem-vindo ao Sistema de Estoque</h2>
        <iframe src="apresentacao.html" name="produtosFrame"></iframe>
    </main>
</body>
</html>