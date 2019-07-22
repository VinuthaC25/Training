package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/Change")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	CartAUserBo cartAUserBo;
    public ChangePasswordServlet() {
        cartAUserBo = new CartAUserBoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		String email = request.getParameter("email");
		String oldpas = request.getParameter("oldpass");
		String newpas = request.getParameter("newpass");
		
		
		try {
			
			int i=0;
			i=cartAUserBo.changePassword(email,oldpas,newpas);
			if(i>0)
			{
				 RequestDispatcher rd = request.getRequestDispatcher("menu.html");
				  rd.include(request, response);
			
			}
			else {
				out.print("invalid");
			}
		}
		catch(Exception e)
		{
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
