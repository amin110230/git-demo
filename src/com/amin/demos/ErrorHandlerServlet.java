package com.amin.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandlerServlet
 */
@WebServlet("/ErrorHandlerServlet")
public class ErrorHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String errorMessage =  (String) request.getAttribute("javax.servlet.error.message");
		String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name"); 
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Error Handling </title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h3><font color=red>Error Page : </font> </h3>");
		out.println("<p> Status Code : " + statusCode);
		out.println("<p> Error Message : " + errorMessage);
		out.println("<p> Request URI : " + requestURI);
		out.println("<p> Servlet Name : " + servletName);
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
