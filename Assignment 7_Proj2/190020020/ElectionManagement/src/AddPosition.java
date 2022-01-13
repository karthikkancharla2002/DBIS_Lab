

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
 * Servlet implementation class AddPosition
 */
@WebServlet("/AddPosition")
public class AddPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPosition() {
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
		String name = request.getParameter("name");
		
		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/election"; //MySQL URL and followed by the database name
 		String username = "universityDB0020"; //MySQL username
 		String password = "Root@lab4"; //MySQL password
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);
 		
 		//checking if book_id is already present in the database
 		PreparedStatement st=con.prepareStatement("select * from positions where position_id=?");
 		st.setInt(1, position_id);
 		ResultSet pos_count=st.executeQuery();
 		int count_pos=0;
 		while(pos_count.next()) {
			count_pos+=1;
		}
 		if(count_pos==0) {
 			//if book with given id is not present, add it
 			PreparedStatement st2=con.prepareStatement("insert into positions values(?, ?)");
 			st2.setString(1,Integer.toString(position_id));
 			st2.setString(2, name);
 		
 			
 			int result=st2.executeUpdate();
 			//Checks if insert is successful.If yes,then redirects to AddResult.jsp page 
 			if(result>0)
 			{
 				
 				RequestDispatcher rd = request.getRequestDispatcher("AddSuccess.jsp");
 				rd.forward(request, response);
 			}
 			
 		}
 		else {
 			//don't add a book
 			RequestDispatcher rd = request.getRequestDispatcher("AddFail.jsp");
				rd.forward(request, response);
 			System.out.println("Position already present");
 		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

		
	}

}
