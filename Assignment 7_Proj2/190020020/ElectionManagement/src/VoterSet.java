

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
 * Servlet implementation class VoterSet
 */
@WebServlet("/VoterSet")
public class VoterSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterSet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
	
		//getting input values from jsp page
		int voter_id = Integer.parseInt(request.getParameter("voter_id"));  
		


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
 		PreparedStatement st=con.prepareStatement("select position_id from canvote where voter_id=?");
 		st.setInt(1, voter_id);
 		ResultSet position_ids=st.executeQuery();
 		int count=0;
 		while(position_ids.next())
 		{
 			String position_id = position_ids.getString("position_id");
 			 if (request.getParameterMap().containsKey(position_id)) {
 	            String candidate_id = request.getParameter(position_id);
 	           PreparedStatement st2=con.prepareStatement("select canvote_id from canvote where voter_id=? and position_id=?");
 	           st2.setInt(1, voter_id);
 	           st2.setString(2,position_id);
 	           ResultSet rs2=st2.executeQuery();
 	           rs2.next();
 	           String canvote_id = rs2.getString("canvote_id");
 	          PreparedStatement st3=con.prepareStatement("insert into votes (candidate_id,canvote_id) values(?, ?);");
 	          st3.setString(1, candidate_id);
 	          st3.setString(2, canvote_id);
 	          int result=st3.executeUpdate();
 	          if(result>0)
 	          {
 	        	  count+=1;
 	          }
 	          
 	        }
 			
 		}
 		if(count>0)
        {
      	  out.println("Voting Succesful");
        }
        else 
        {
      	  out.println("Voting not succesful");
        }
 		
 			
 			
 			
 		//		RequestDispatcher rd = request.getRequestDispatcher("Vote.jsp");
 				//rd.forward(request, response);
 			
 			
 		

		}
		 catch (Exception e) 
 		{
			 PrintWriter out = response.getWriter();  
		        response.setContentType("text/html");  
		        out.println("<html><body>");
			 out.println("Voting not succesful");
 			e.printStackTrace();
 		}


	}

}
