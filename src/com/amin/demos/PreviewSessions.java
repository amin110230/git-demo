package com.amin.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PreviewSessions
 */
@WebServlet("/PreviewSessions")
public class PreviewSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviewSessions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String email = request.getParameter("email");
		HttpSession session = request.getSession();
		String guestName = (String) session.getAttribute("guestName");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview </title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h3>Please confirm your information </h3>");		
		out.println("<p>Guest Name : " + guestName + "</p>");		
		out.println("<p>Email Id : " + email + "</p>");

		session.setAttribute("email", email);
		
		out.println("<form name='frm' method='POST' action='SaveDataSessions'>");
		out.println("<p><input type='submit' name='btnSave' value='Save Data' /> </p>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

}
