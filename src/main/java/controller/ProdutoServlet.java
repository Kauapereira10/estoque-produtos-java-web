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
@WebServlet(name = "produtos", urlPatterns = { "/produtos", "/produtos/listarProdutos", "/views/produtos/listarProdutos",
		"/views/produtos/cadastro", "/produtos/cadastro", "/produtos/novoProduto", "/produtos/desativar", "/produtos/editar",
		"/produtos/update" })
public class ProdutoServlet extends HttpServlet {

	private ProdutoDao produtoDao = null;

	public ProdutoServlet() {
		produtoDao = new ProdutoDao();
	}

	/**
	 * Método chamado para processar requisições HTTP do tipo GET. É o método
	 * principal para exibir dados e formulários.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/produtos/listarProdutos":
			listarProdutos(request, response);

			break;
		case "/produtos/cadastro":
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos/cadastro.jsp");
			dispatcher.forward(request, response);

			break;
		case "/produtos/desativar":
			desativar(request, response);

			break;
		case "/produtos/editar":
			editarForm(request, response);

			break;
		default:
			listarProdutos(request, response);

			break;

		}

	}

	/**
	 * Método chamado para processar requisições HTTP do tipo POST. Geralmente usado
	 * para salvar dados de formulários.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		boolean sucesso = false;
		
		switch (action) {
        case "/produtos/novoProduto":
        	sucesso = novoProduto(request);
            break;

        case "/produtos/update":
        	sucesso = update(request);
            break;

        default:
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
    }
		if(sucesso) {
			response.sendRedirect("listarProdutos");
		}else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao processar a operação!");
		}

	}

	private boolean novoProduto(HttpServletRequest request) throws ServletException, IOException {
		try {
			Produto novoProduto = new Produto();
			String nomeProduto = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			double preco = Double.parseDouble(request.getParameter("preco"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));

			if (nomeProduto != null && preco > 0 && quantidade > 0) {
				novoProduto = new Produto(nomeProduto, descricao, preco, quantidade);
				return produtoDao.inserir(novoProduto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Produto> listaProdutos = produtoDao.listarProdutos();
		request.setAttribute("listarProdutos", listaProdutos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos/listar.jsp");
		dispatcher.forward(request, response);

	}

	private void editarForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Produto produtoAlterar = produtoDao.findById(id);

		request.setAttribute("produto", produtoAlterar);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos/cadastro.jsp");
		dispatcher.forward(request, response);

	}

	private boolean update(HttpServletRequest request) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			String nomeProduto = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			double preco = Double.parseDouble(request.getParameter("preco"));
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));
			
			Produto updateProduto = new Produto();
			updateProduto.setId(id);
			updateProduto.setNome(nomeProduto);
			updateProduto.setDescricao(descricao);
			updateProduto.setPreco(preco);
			updateProduto.setQuantidade(quantidade);
			
	        return produtoDao.update(updateProduto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		

	}

	private void desativar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		produtoDao.desativar(id);
		response.sendRedirect("listarProdutos");

	}

}
