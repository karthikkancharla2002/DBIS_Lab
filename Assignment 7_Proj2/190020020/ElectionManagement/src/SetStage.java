

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetStage
 */
@WebServlet("/SetStage")
public class SetStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetStage() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
		
		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/election"; //MySQL URL and followed by the database name
 		String username = "universityDB0020"; //MySQL username
 		String password = "Root@lab4"; //MySQL password
		
		
			Class.forName("com.mysql.jdbc.Driver");
		
		
			con = DriverManager.getConnection(url, username, password);
		
 		System.out.println("Printing connection object "+con);
 		
 		
 		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>"); 
        
        int val = Integer.parseInt(request.getParameter("stage"));  
        
        PreparedStatement st3=con.prepareStatement("update stage set current_stage=?");
			
			st3.setInt(1, val);
			
			
			int result=st3.executeUpdate();
 			//Checks if insert is successful.If yes,then redirects to AddResult.jsp page 
 			if(result>0)
 			{
 				
 				out.println("Update Successful");
 			}else {
 				out.println("Update Not Successful");
 			}
        
		}catch(Exception e){
			e.printStackTrace();
			PrintWriter out = response.getWriter();  
	        response.setContentType("text/html");  
	        out.println("<html><body>"); 
	        out.println("Update Not Successful");
		}
        
        
	}

}
