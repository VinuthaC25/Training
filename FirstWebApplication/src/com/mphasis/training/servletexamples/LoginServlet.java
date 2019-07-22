package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CartAUserBo cartAUserBo;
	
    public LoginServlet() {
           cartAUserBo = new  CartAUserBoImpl();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");    //http 1.1
		response.setHeader("Pragma", "no-cache");                                      //http 1.0
		response.setHeader("Expires", "0");                                            //proxies
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("sname");
		String pass = request.getParameter("pwd");
		
		CartAUser user = cartAUserBo.login(name, pass);
		try {
		if(user.getEmail().equals(name) && user.getPassword().equals(pass))
		{
			out.print("Welcome "+name+"<br/>");
			
			if(user.getRole().equalsIgnoreCase("admin"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("menu.html");
				rd.include(request, response);
				
				HttpSession session = request.getSession();
				session.setAttribute("sname", name);	
				session.setAttribute("role", user.getRole());
			
			}
			else if(user.getRole().equalsIgnoreCase("customer"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("menuCustomer.html");
				rd.include(request, response);
				
				HttpSession session = request.getSession();
				session.setAttribute("sname", name);
				session.setAttribute("role", user.getRole());
			
			}
			//Cookie
			//Cookie ck = new Cookie("cname",name);
			//response.addCookie(ck);
			
			//Http Session	
		}
		}
		catch(Exception e)
		{
			out.print("Access Denied");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
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
