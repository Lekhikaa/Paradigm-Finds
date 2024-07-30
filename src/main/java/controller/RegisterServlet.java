package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.User;
import service.UserDao;
import utils.PasswordHash;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new UserDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		Date dob = null;
		try {
			dob = new java.sql.Date(
					new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		long phoneNumber = Long.parseLong(request.getParameter("phonenumber"));
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String reTypePassword = request.getParameter("confirmpassword");
		if (!password.equals(reTypePassword)) {
			request.setAttribute("error", "Password Notmatched!");
			request.getRequestDispatcher("WEB-INF/view/Register.jsp").forward(request, response);
		}
		User User = new User();
		User.setFirstName(firstName);
		User.setLastName(lastName);
		User.setUsername(username);
		User.setDob(dob);
		User.setGender(gender);
		User.setAddress(address);
		User.setEmail(email);
		User.setPhoneNumber(phoneNumber);
		
	
		User.setPassword(PasswordHash.getPasswordHash(password));
		
		if (dao.saveUser(User)) {
			
			response.sendRedirect(request.getContextPath()+"/login");
		} else {
			request.setAttribute("error1", "username or email or phonenumber exist");
			//request.getRequestDispatcher("register").forward(request, response);
			doGet(request, response);
		}
	}

}
