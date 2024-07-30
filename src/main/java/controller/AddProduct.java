package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;
import service.ProductDao;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/add" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10,      // 10MB
maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productName=request.getParameter("productName");
		String productCategory=request.getParameter("productCategory");
		int productPrice=Integer.parseInt(request.getParameter("productPrice"));
 		
		Part filePart = request.getPart("image");
		String image_name=filePart.getSubmittedFileName();
		InputStream imageStream=filePart.getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int bytesRead;
		int sizeInBytes = 2 * 1024 * 1024; 
		byte[] data = new byte[sizeInBytes];
		while ((bytesRead = imageStream.read(data, 0, data.length)) != -1) {
		    buffer.write(data, 0, bytesRead);
		}
		byte[] imageData = buffer.toByteArray();
		
		String productDescription=request.getParameter("productDescription");
		
		Product product=new Product();
		product.setProductName(productName);
		product.setProductCategory(productCategory);
		product.setProductPrice(productPrice);
		product.setImage_data(imageData);
		product.setImage_name(image_name);
		product.setProductDescription(productDescription);
		ProductDao dao=new ProductDao();
		int row;
		try {
			row = dao.insertProductData(product);
			if(row>0)
			{
				response.sendRedirect(request.getContextPath()+"/Home");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
