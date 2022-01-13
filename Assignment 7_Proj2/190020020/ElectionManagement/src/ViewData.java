

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewData
 */
@WebServlet("/ViewData")
public class ViewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
	
		//getting input values from jsp page
		

		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/election"; //MySQL URL and followed by the database name
 		String username = "universityDB0020"; //MySQL username
 		String password = "Root@lab4"; //MySQL password
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);
 		
 		
 		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>"); 
      
 		
 		//checking if book_id is already present in the database
 		
 	
 			//Checks if execute is successful.
 			//PreparedStatement st2=con.prepareStatement("select candidate_id, candidate.name from canvote natural join candidate where voter_id=?");
 			PreparedStatement st2=con.prepareStatement("select position_id, position_name from positions");
 			
 			
 			ResultSet eligible_pos=st2.executeQuery();
 	
 			out.println("<form action=\"VoterSet\" method=\"post\">");
 			
 			out.println("<table border=1 width=50% height=50%>");  
 			while(eligible_pos.next())
 			{
 				String position_id = eligible_pos.getString("position_id");
 				PreparedStatement st3=con.prepareStatement("select candidate_id, name from candidate where position_id=?");
 	 			
 				st3.setString(1, position_id);
 				
 				ResultSet eligible_cands = st3.executeQuery();
 				
 				String position_name=eligible_pos.getString("position_name");
 				out.println("<tr><td colspan=\"2\">Postion Name: "+ position_name+"</td></tr>");
 				out.println("<tr><td>Candidate ID</td><td>Candidate Name</td></tr>"); 
 				while(eligible_cands.next())
 				{
 					String candidate_id = eligible_cands.getString("candidate_id");
 					String candidate_name = eligible_cands.getString("name");
 					out.println("<tr><td>" + candidate_id + "</td><td>" + candidate_name + "</td></tr>"); 
 				}
                  
 			}
 			out.println("</table>");
 		
 			
 			
 			
 			
 		//		RequestDispatcher rd = request.getRequestDispatcher("Vote.jsp");
 				//rd.forward(request, response);
 			
 			
 		}
 		

		
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}



	}

}
