package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductDao;

/**
 * Servlet implementation class HomePage
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Home" })
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			ProductDao dao=new ProductDao();
			List<Product> listOfProducts;
			listOfProducts=dao.getAllProduct();
			for(Product prod: listOfProducts)
			{
				String base64ImageData=Base64.getEncoder().encodeToString(prod.getImage_data());
				prod.setBase64ImageData(base64ImageData);
			}
			request.setAttribute("listOfProducts", listOfProducts);
			request.getRequestDispatcher("/WEB-INF/view/homePage.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
