package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ProdutoDao;
import model.Produto;

/**
 * Servlet responsável por controlar as requisições relacionadas a produtos.
 * Mapeado para a URL "/produtos".
 */
@WebServlet(name="produtos", urlPatterns = {"/produtos", "/produtos/listar", "/produtos/cadastro", "/produtos/novo", "/produtos/desativar"})
public class ProdutoServlet extends HttpServlet {
	
	private ProdutoDao dao = null;
	
	public ProdutoServlet() {
		dao = new ProdutoDao();
	}
	
	/**
	 * Método chamado para processar requisições HTTP do tipo GET.
	 * É o método principal para exibir dados e formulários.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		
		case "/produtos/novo": 
			novo(request, response);
			
			break;
		case "/produtos/listar": 
			listar(request, response);
			
			break;
		case "/produtos/cadastro": 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos/cadastro.jsp"); 
			dispatcher.forward(request, response);
			
			break;
		case "/produtos/desativar": 
			desativar(request, response);
			
			break;
		default:
			listar(request, response);
			
			break;
		
		}

	}

	/**
	 * Método chamado para processar requisições HTTP do tipo POST.
	 * Geralmente usado para salvar dados de formulários.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
	}
	
	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto novoProduto = new Produto();
		String nomeProduto = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		double preco = Double.parseDouble(request.getParameter("preco"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		
		
		if(nomeProduto != null&&preco>0&&quantidade>0) {
			novoProduto = new Produto(nomeProduto, descricao, preco, quantidade);
			dao.inserir(novoProduto);
		}
		
		try {
			listar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Produto> listaProdutos = dao.listar();
		request.setAttribute("listar", listaProdutos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos/listar.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	private void desativar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		dao.desativar(id);
		response.sendRedirect("listar");
		
		
	}

}
