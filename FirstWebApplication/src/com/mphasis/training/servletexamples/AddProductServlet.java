package com.mphasis.training.servletexamples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDaoImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	ProductDaoImpl pdao = new ProductDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s = request.getParameter("pid");
		int i = Integer.parseInt(s);
		if(i > 0)
		{
				HttpSession session1 = request.getSession();
				Product p = new Product();
				p = pdao.getById(i);
				session1.setAttribute("p", p);
				response.sendRedirect("UpdateProductServlet.jsp");
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
