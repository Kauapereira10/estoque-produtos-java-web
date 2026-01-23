<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Inventory System</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
    <header>
        <h1>Inventory System</h1>
    </header>
    
	<%@ include file="../includes/navbar.jsp"%>	
	
    <main>
        <h2>Welcome to the Inventory System</h2>
        <iframe src="presentation.html" name="produtosFrame"></iframe>
    </main>
    
    <%@ include file="../includes/footer.jsp"%>
</body>
</html>