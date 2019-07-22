package com.mphasis.training.servletexamples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductDaoImpl;

/**
 * Servlet implementation class add1
 */
@WebServlet("/add1")
public class add1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao pdao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add1() {
        super();
        pdao = new ProductDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("pname");
		int cost = Integer.parseInt(request.getParameter("cost"));
		int qty = Integer.parseInt(request.getParameter("quantity"));
		
		Product p = new Product();
		
		p.setPid(pid);
		p.setPname(name);
		p.setCost(cost);
		p.setQuantity(qty);
		
		int i = pdao.addProduct(p);
		if(i>0)
		{
			response.sendRedirect("menu.html");
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
