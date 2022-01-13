

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
 * Servlet implementation class VoterLogin
 */
@WebServlet("/VoterLogin")
public class VoterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterLogin() {
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
		try
		{
			
		
	
		//getting input values from jsp page
		int voter_id = Integer.parseInt(request.getParameter("voter_id"));  
		String voter_password = request.getParameter("password");


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
        
        PreparedStatement st11=con.prepareStatement("Select * from stage;");
		ResultSet stage = st11.executeQuery();
		
		stage.next();
		int stage_val = stage.getInt("current_stage");     
        
		if(stage_val == 1) {
			out.println("Voting not yet started");
			return;
		}
      
 		
 		//checking if book_id is already present in the database
 		PreparedStatement st=con.prepareStatement("select * from voter where voter_id=? and password=?");
 		st.setInt(1, voter_id);
 		st.setString(2, voter_password);
 		ResultSet voter_count=st.executeQuery();
 		int count_voter=0;
 		while(voter_count.next()) {
			count_voter+=1;
		}
 		if(count_voter!=0) {
 
 			//Checks if execute is successful.
 			//PreparedStatement st2=con.prepareStatement("select candidate_id, candidate.name from canvote natural join candidate where voter_id=?");
 			PreparedStatement st2=con.prepareStatement("select position_id from canvote where voter_id=?");
 			
 			st2.setInt(1, voter_id);
 			ResultSet eligible_pos=st2.executeQuery();
 	
 			out.println("<form action=\"VoterSet\" method=\"post\">");
 			out.println("Voter ID: <input type=\"text\" name=\"voter_id\" value=\""+voter_id+"\" readonly/>");
 			out.println("<table border=1 width=50% height=50%>");  
 			while(eligible_pos.next())
 			{
 				String position_id = eligible_pos.getString("position_id");
 				PreparedStatement st3=con.prepareStatement("select candidate_id, name from candidate where position_id=?");
 	 			
 				st3.setString(1, position_id);
 				
 				ResultSet eligible_cands = st3.executeQuery();
 				PreparedStatement st4=con.prepareStatement("select position_name from positions where position_id=?");
 				st4.setString(1, position_id);
 				ResultSet positions = st4.executeQuery();
 				positions.next();
 				String position_name=positions.getString("position_name");
 				out.println("<tr><td colspan=\"3\">Postion Name: "+ position_name+"</td></tr>");
 				while(eligible_cands.next())
 				{
 					String candidate_id = eligible_cands.getString("candidate_id");
 					String candidate_name = eligible_cands.getString("name");
 					out.println("<tr><td><input type=\"radio\" name=\"" + position_id+ "\" value=\""+candidate_id +"\"></input></td><td>" + candidate_id + "</td><td>" + candidate_name + "</td></tr>"); 
 				}
                  
 			}
 			out.println("</table>");
 			out.println("<input type=\"submit\" value=\"Poll your vote\" /></form>");
 			
 			
 			
 			
 		//		RequestDispatcher rd = request.getRequestDispatcher("Vote.jsp");
 				//rd.forward(request, response);
 			
 			
 		}
 		else {
 			//don't add a book
 			System.out.println("Wrong Admin ID or password entered");
 			RequestDispatcher rd = request.getRequestDispatcher("LoginFail.jsp");
				rd.forward(request, response);
 		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}


		//doGet(request, response);
	}

}
