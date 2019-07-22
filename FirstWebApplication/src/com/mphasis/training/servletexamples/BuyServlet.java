package com.mphasis.training.servletexamples;

import java.io.IOException;
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
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        productDao = new ProductDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("pid");
		int pid = Integer.parseInt(s);
		
		HttpSession session1 = request.getSession(false);
		String name = session1.getAttribute("sname").toString();
		String qty = request.getParameter("quantity");
		int q = Integer.parseInt(qty);
		
		Product p = productDao.getById(pid);
		
		if(p.getQuantity()-q > 0)
		{
			int j = productDao.addToCart(pid,name);
			session1.setAttribute("product", p);
			response.sendRedirect("showlist.jsp");
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
