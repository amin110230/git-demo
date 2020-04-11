package com.amin.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Step2Cookies
 */
@WebServlet("/Step2Cookies")
public class Step2Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Step2Cookies() {
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
		String guestName = request.getParameter("guestName");
		Cookie guestData = new Cookie("guestName", guestName);
//		guestData.setMaxAge(1800);
		response.addCookie(guestData);
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Greeting </title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h3>Welcome " + guestName + " </h3>");		
		out.println("<form name='frm' method='POST' action='PreviewCookies'>");
		out.println("<input type='hidden' name='guestName' value='" + guestName + "' />");
		out.println("<p>Enter Email Id :  </p>");
		out.println("<p> <input type='email' name='email' /> </p>");
		out.println("<p> <input type='submit' value='Preview' name='btnPreview' /> </p>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

}
