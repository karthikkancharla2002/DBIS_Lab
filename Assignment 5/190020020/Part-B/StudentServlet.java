
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html;charset=UTF-8");
		
		String student_id = request.getParameter("id");//getting student id as input from index.html page
		
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement  stmt = null;
		String advisor_id=null;
		String dept_name=null;
		try {
			out.println("<!DOCTYPE html>");//print in the form of HTML code
			out.println("<html>");
			out.println("<head><title>Advisor Query Servlet</title></head>");
			out.println("<body>");
			Class.forName("com.mysql.jdbc.Driver"); //loading postgres driver
			String query="select distinct i_id,dept_name from advisor,instructor where advisor.i_id=instructor.ID and advisor.i_id=?	"; //query to get the student details with id 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "universityDB0020", "Root@lab4");//postgres connection with username and password
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, student_id);
			ResultSet rset = ps.executeQuery();
			int count=0;
			while(rset.next()) {
				advisor_id=rset.getString("i_id");//getting student name and storing in a variable
				dept_name = rset.getString("dept_name");
				++count;
			}
			out.println("Advisor id is " +advisor_id+" Department name is "+dept_name);//printing student id and name
			out.println("<p>==== " + count + " rows found =====</p>");
			out.println("</body></html>");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();  // closing connection and statement variables
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}

