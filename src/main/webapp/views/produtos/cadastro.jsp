<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário Produto</title>
</head>
<body>
    <h2>Cadastro de Produto</h2>
    <form action="${produto == null ? 'novo' : 'update'}" method="post">
    
    	<input type="hidden" name="id" value="${produto.getId()}"><br/>
        Nome: <input type="text" name="nome" value="${produto.getNome()}" required><br/>
        Descrição: <input type="text" name="descricao" value="${produto.getDescricao()}" required><br/>
        Preço: <input type="number" step="0.01" name="preco" value="${produto.getPreco()}" required><br/>
        Quantidade: <input type="number" name="quantidade" value="${produto.getQuantidade()}" required><br/>
        
        <button type="submit">Salvar</button>
    	<button type="button" onclick="window.location.href='listar';">Cancelar</button>
    </form>
</body>
</html>
