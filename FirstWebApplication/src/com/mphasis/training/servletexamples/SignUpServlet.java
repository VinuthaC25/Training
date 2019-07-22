package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;
import com.mphasis.cart.exceptions.BusinessException;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 CartAUserBo cartAUserBo;
    public SignUpServlet() {
    	super();
    	 cartAUserBo = new  CartAUserBoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");    //http 1.1
		response.setHeader("Pragma", "no-cache");                                      //http 1.0
		response.setHeader("Expires", "0");                                            //proxies
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		CartAUser c = new CartAUser();
		int uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pwd");
		long credit = Long.parseLong(request.getParameter("credit"));
		String gender = request.getParameter("gen");
		String role = request.getParameter("role");
		
		c.setUserid(uid);
		c.setUsername(uname);
		c.setEmail(email);
		c.setPassword(pass);	
		c.setCredit(credit);
		c.setGender(gender);
		c.setRole(role);
		
		try {
			cartAUserBo.register(c);
		
			//out.print("Welcome "+uname+"<br/>");
			//out.println("Languages selected <br/> ");
		/*for(String st : lans)
			{
				out.print(st);
			}*/
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			
		}RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
