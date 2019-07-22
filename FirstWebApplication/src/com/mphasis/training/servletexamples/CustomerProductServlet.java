package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductDaoImpl;

/**
 * Servlet implementation class CustomerProductServlet
 */
@WebServlet("/CustomerProductServlet")
public class CustomerProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductDao productDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerProductServlet() {
        super();
        productDao = new ProductDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = productDao.getAll();
		HttpSession session1 = request.getSession();
		
		session1.setAttribute("pro", products);
		response.sendRedirect("customerProduct.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
