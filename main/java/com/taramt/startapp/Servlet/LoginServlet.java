package com.taramt.startapp.Servlet;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}
	
	
	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.getRequestDispatcher("login.jsp").include(request, response);
		
		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		
		HttpSession session=request.getSession();
		session.setAttribute("userName",userName);
		session.setAttribute("name", name);
		response.sendRedirect("/partials/instructions.jsp");
		
	/*	PrintWriter out = response.getWriter();
		out.print("Hey you are getting values " + userName + "  " + name);*/
		
	
	}

}
