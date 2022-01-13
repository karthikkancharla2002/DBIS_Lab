

import java.io.IOException;
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
 * Servlet implementation class AddVotingRights
 */
@WebServlet("/AddVotingRights")
public class AddVotingRights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVotingRights() {
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
		int position_id = Integer.parseInt(request.getParameter("position_id"));  
		int voter_id = Integer.parseInt(request.getParameter("voter_id"));
		
		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/election"; //MySQL URL and followed by the database name
 		String username = "universityDB0020"; //MySQL username
 		String password = "Root@lab4"; //MySQL password
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);
 		
 		//checking if book_id is already present in the database
 		
 			//if book with given id is not present, add it
 			PreparedStatement st2=con.prepareStatement("insert into canvote (position_id, voter_id) values(?, ?)");
 			st2.setInt(1,position_id);
 			st2.setInt(2, voter_id);
 		
 			
 			int result=st2.executeUpdate();
 			//Checks if insert is successful.If yes,then redirects to AddResult.jsp page 
 			if(result>0)
 			{
 				
 				RequestDispatcher rd = request.getRequestDispatcher("AddSuccess.jsp");
 				rd.forward(request, response);
 			}else {
 				RequestDispatcher rd = request.getRequestDispatcher("AddFail.jsp");
 				rd.forward(request, response);
 			}
 			
 		

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 			RequestDispatcher rd = request.getRequestDispatcher("AddFail.jsp");
				rd.forward(request, response);
 		}
	}

}
