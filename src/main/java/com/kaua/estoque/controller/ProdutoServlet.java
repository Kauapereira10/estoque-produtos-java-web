package com.kaua.estoque.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaua.estoque.dao.ProdutoDao;
import com.kaua.estoque.model.Produto;

/**
 * Servlet responsável por controlar as requisições relacionadas a produtos.
 * Mapeado para a URL "/produtos".
 */
@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {
	
	private ProdutoDao dao = new ProdutoDao();
	
	/**
	 * Método chamado para processar requisições HTTP do tipo GET.
	 * É o método principal para exibir dados e formulários.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) action = "list";
		
		switch (action) {
		
		case "form": 
			
			int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
			
			if(id > 0) {
				
				Produto p = dao.findById(id);
				
				request.setAttribute("produto", p);
			}
			
			request.getRequestDispatcher("/produtos/form.jsp").forward(request, response);
		
			break;
			
		case "delete": 
			
			id = Integer.parseInt(request.getParameter("id"));
			
			dao.desativar(id);
			
			response.sendRedirect("produtos");
			
			break;
		
		default:
			
			List<Produto> lista = dao.findAll();
			
			request.setAttribute("produtos", lista);
			
			request.getRequestDispatcher("/produtos/list.jsp").forward(request, response);
		
		}

	}

	/**
	 * Método chamado para processar requisições HTTP do tipo POST.
	 * Geralmente usado para salvar dados de formulários.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			String idStr  = request.getParameter("id");
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			double preco = Double.parseDouble(request.getParameter("preco"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));
			
			Produto produto = new Produto(nome, descricao, preco, quantidade);
			
			if(idStr != null && !idStr.isEmpty()) {
				
				produto.setId(Integer.parseInt(idStr));
				dao.update(produto);
			} else {
				dao.save(produto);
			}
			
			response.sendRedirect("produtos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
