package com.amin.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Log4jDemos
 */
@WebServlet("/Log4jDemos")
public class Log4jDemos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log4jDemos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		logger = LogManager.getLogger(Log4jDemos.class);
		logger.info("Log Info: Entered the doGet method for processing the request");
		
		response.setContentType("text/html");	
		logger.info("Content Type has been set to text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Log4j Demo </title>");
		out.println("</head>");
		out.println("<body>");

		logger.info("Log Info: Started the Document Creation");
		out.println("<p> Logger Name : " + logger.getName() + "</p>");
		String param = request.getParameter("param");
		if( param == "" || param.isEmpty()) {
			out.println("<p>Error: Please Provide the Value for the Parameter </p>");
			logger.error("Error: Please Provide the Value for the Parameter");
		}else {
			out.println("<p>Page is requested by : "+ param +"</p>");		
			logger.warn("Log Message : Page is requested by " + param);	
		}
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
