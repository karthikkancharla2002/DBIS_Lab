

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Results
 */
@WebServlet("/Results")
public class Results extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Results() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Checks if execute is successful.
			//PreparedStatement st2=con.prepareStatement("select candidate_id, candidate.name from canvote natural join candidate where voter_id=?");
			try {
		
		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/election"; //MySQL URL and followed by the database name
 		String username = "universityDB0020"; //MySQL username
 		String password = "Root@lab4"; //MySQL password
		
		
			Class.forName("com.mysql.jdbc.Driver");
		
		
			con = DriverManager.getConnection(url, username, password);
		
			PrintWriter out = response.getWriter();  
	        response.setContentType("text/html");  
	        out.println("<html><body>"); 
		
	        
	        PreparedStatement st11=con.prepareStatement("Select * from stage;");
			ResultSet stage = st11.executeQuery();
			
			stage.next();
			int stage_val = stage.getInt("current_stage");     
	        
			if(stage_val != 3) {
				out.println("Results not declared");
				return;
			}
		
		PreparedStatement st2=con.prepareStatement("select position_id, position_name from positions");
			
			
			ResultSet eligible_pos=st2.executeQuery();
	
			out.println("<form action=\"VoterSet\" method=\"post\">");
			
			out.println("<table border=1 width=50% height=50%>");  
			
		
			
 			
			
			while(eligible_pos.next())
			{
				String position_id = eligible_pos.getString("position_id");
				PreparedStatement st3=con.prepareStatement("SELECT name, COUNT(*) as count from ((canvote NATURAL JOIN votes) NATURAL JOIN candidate) where position_id=? GROUP BY candidate_id");
	 			
				st3.setString(1, position_id);
				
				ResultSet eligible_cands = st3.executeQuery();
				
				String position_name=eligible_pos.getString("position_name");
				out.println("<tr><td colspan=\"2\">Postion Name: "+ position_name+"</td></tr>");
				out.println("<tr><td>Candidate Name</td><td>No of Votes</td></tr>"); 
				while(eligible_cands.next())
				{
					String name = eligible_cands.getString("name");
					int count = eligible_cands.getInt("count");
					out.println("<tr><td>" + name+ "</td><td>" + Integer.toString(count) + "</td></tr>"); 
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
