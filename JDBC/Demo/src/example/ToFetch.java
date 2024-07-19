package example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ToFetch {
	public static void main(String[] args) {
		try {
			// loading and registering the driver
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			//establishing the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch07","root","root");
			
			//Creating the statement
			Statement stmt = con.createStatement();	
			
			//Executing the query
			 ResultSet resultset = stmt.executeQuery("select * from dept");
			 System.out.println(resultset);
			 
			 // procssing the result
			 while(resultset.next()) {
				 int id = resultset.getInt(1);
				String name = resultset.getString(2);
				String age = resultset.getString(3);
				
				System.out.println("id = "+id+" name = "+name+"con = "+age);
			 }
			 con.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
