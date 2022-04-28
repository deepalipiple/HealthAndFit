package com.deepali.healthandfit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.x.AsyncMessageSender;

/**
 * Servlet implementation class HealthAndFit
 */
@WebServlet("/HealthAndFit")
public class HealthAndFit extends HttpServlet {
	private static final long serialVersionUID = 1L;

//        public HealthAndFit() {
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String interest[] = request.getParameterValues("interest");
		String reference = request.getParameter("reference");
		String questions = request.getParameter("questions");

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/sys?" +
                            "user=root&password=Deepali");
			  
			PreparedStatement ps=con.prepareStatement(  
			"insert into CustomerInformation values(?,?,?,?,?,?,?)");  
			
			
			ps.setString(1,fName);  
			ps.setString(2,lName);  
			ps.setString(3,email);  
			ps.setString(4,phone);  
			ps.setString(5,Arrays.deepToString(interest));
			ps.setString(6,reference);
			ps.setString(7,questions);
			          
			int i=ps.executeUpdate();  
			if(i>0)  
		/*	out.print("<h1>Thanks for contacting Us,Will get back to you shortly......</h1>"
					+ "<a href="
					+ "/HealthAndFit/Fitness-Website-main/index.html"
					
					+ ">Go back</a>"
					
					+ "<a href="
					+ "/HealthAndFit/Fitness-Website-main/index.html"
					
					+ ">Go back</a>"); */
			      
				/*out.print("<!Doctype Html>  \r\n"
						+ "<Html>     \r\n"
						+ "<Head>      \r\n"
						
						+ "</Head>  \r\n"
						+ "<Body background=\"images/thankyou.jpg\">  \r\n"
						+ "<h1>Thanks for contacting Us,Will get back to you shortly......</h1>"
								+ "<a href="
								+ "/HealthAndFit/Fitness-Website-main/index.html"
								
								+ ">Go back</a>"
								
								
						+ "</Body>  \r\n"
						+ "</Html> ");*/
				
				response.sendRedirect("/HealthAndFit/Fitness-Website-main/thankyou.html");
			          
			}catch (Exception e2) {System.out.println(e2);}  
			          
			out.close();  
			}  

		
	}


