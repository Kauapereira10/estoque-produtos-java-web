<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema de Gestão de Estoque | Computadores</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header>
        <h1>Sistema de Gestão de Estoque</h1>
    </header>
    
	<%@ include file="../includes/navbar.jsp"%>	
	
    <main>
        <h2>Bem-vindo ao sistema de controle de estoque de computadores</h2>
        <iframe src="apresentacao.html" name="produtosFrame" scrolling="no"></iframe>
    </main>
    
    <%@ include file="../includes/footer.jsp"%>
</body>
</html>