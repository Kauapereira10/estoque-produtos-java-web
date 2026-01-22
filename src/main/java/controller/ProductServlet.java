package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ProductDao;
import model.Product;


/**
 * Servlet responsável por controlar as requisições relacionadas a produtos.
 * Mapeado para a URL "/produtos".
 */
@WebServlet(
	    name = "products",
	    urlPatterns = {
	        "/products",
	        "/products/list",
	        "/products/create",
	        "/products/delete",
	        "/products/edit",
	        "/products/update"
	    })
public class ProductServlet extends HttpServlet {

	private ProductDao productDao = null;

	public ProductServlet() {
		productDao = new ProductDao();
	}

	/**
	 * Método chamado para processar requisições HTTP do tipo GET. É o método
	 * principal para exibir dados e formulários.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/products/list":
			listProducts(request, response);

			break;
		case "/products/create":
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/products/form.jsp");
			dispatcher.forward(request, response);

			break;
		case "/products/delete":
			deleteProduct(request, response);

			break;
		case "/products/edit":
			editarForm(request, response);

			break;
		default:
			listProducts(request, response);

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
        case "/products/create":
        	sucesso = createProduct(request);
            break;

        case "/products/update":
        	sucesso = updateProduct(request);
            break;

        default:
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
    }
		if(sucesso) {
			response.sendRedirect(request.getContextPath() + "/products/list");
		}else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro ao processar a operação!");
		}

	}

	private boolean createProduct (HttpServletRequest request) throws ServletException, IOException {
		try {
			Product newProduct = new Product();
			String nameProduct = request.getParameter("name");
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			if (nameProduct != null && price > 0 && quantity > 0) {
				newProduct = new Product(nameProduct, description, price, quantity);
				return productDao.save(newProduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Product> listProducts = productDao.findAll();
		request.setAttribute("list", listProducts);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/products/list.jsp");
		dispatcher.forward(request, response);

	}

	private void editarForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Product produtoAlterar = productDao.findById(id);

		request.setAttribute("product", produtoAlterar);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/products/form.jsp");
		dispatcher.forward(request, response);

	}

	private boolean updateProduct(HttpServletRequest request) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			String nomeProduto = request.getParameter("name");
			String descricao = request.getParameter("description");
			double preco = Double.parseDouble(request.getParameter("price"));
			int quantidade = Integer.parseInt(request.getParameter("quantity"));
			
			Product updateProduto = new Product();
			updateProduto.setId(id);
			updateProduto.setName(nomeProduto);
			updateProduto.setDescription(descricao);
			updateProduto.setPrice(preco);
			updateProduto.setQuantity(quantidade);
			
	        return productDao.update(updateProduto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		

	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		productDao.delete(id);
		response.sendRedirect(request.getContextPath() + "/products/list");

	}

}
