

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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		int admin_id = Integer.parseInt(request.getParameter("admin_id"));  
		String admin_password = request.getParameter("password");


		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/election"; //MySQL URL and followed by the database name
 		String username = "universityDB0020"; //MySQL username
 		String password = "Root@lab4"; //MySQL password
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
 		System.out.println("Printing connection object "+con);
 		
 		//checking if book_id is already present in the database
 		PreparedStatement st=con.prepareStatement("select * from admin where admin_id=? and password=?");
 		st.setInt(1, admin_id);
 		st.setString(2, admin_password);
 		ResultSet admin_count=st.executeQuery();
 		int count_admin=0;
 		while(admin_count.next()) {
			count_admin+=1;
		}
 		if(count_admin!=0) {
 
 			//Checks if insert is successful.If yes,then redirects to AdminHome.jsp page 
 		
 				RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
 				rd.forward(request, response);
 			
 			
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

	}

}
