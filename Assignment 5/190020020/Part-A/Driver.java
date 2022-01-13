package jdbc_demo;

import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		try {
			//Get connection
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","universityDB0020","Root@lab4");
			Statement myS=myConn.createStatement();
			PreparedStatement ps = myConn.prepareStatement("select classroom.room_number from classroom  where classroom.building= ? and classroom.capacity >30 and not exists(select * from section where section.room_number=classroom.room_number and section.year='2009' and section.semester='Summer');");
			//Query
			ResultSet resultSet = myS.executeQuery("SELECT * FROM student");			//Display
			while(resultSet.next()) {
				System.out.println(resultSet.getString("ID")+"  "+resultSet.getString("name"));
			}
			System.out.println("Part A Q2");
			listDepartments(myS);
			System.out.println("Part A Q3");
			listDepartments(ps);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void listDepartments(Statement stmt)
	{
		// Write the code for Q2
		try {
			ResultSet resultSet2 = stmt.executeQuery("SELECT dept_name,st_count,inst_count from (select dept_name,count(ID) as st_count from student group by dept_name) as st2 natural join (select dept_name,count(ID) as inst_count from instructor group by dept_name) as inst2 order by dept_name asc;");
			while(resultSet2.next()) {
				System.out.println(resultSet2.getString("dept_name")+ " "+ resultSet2.getString("st_count")+" " +resultSet2.getString("inst_count")+" ");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public static void listDepartments(PreparedStatement stmt)
	{
		// Write the code for Q3
		
		
		try {
			stmt.setString(1, "Watson"); //this doesn't give null set, so I used this value
			ResultSet resultSet3 = stmt.executeQuery();
			while(resultSet3.next()) {
				System.out.println(resultSet3.getString("classroom.room_number"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

	}

}
