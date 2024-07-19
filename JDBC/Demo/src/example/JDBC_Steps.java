package example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 7  Steps in order to intract using JDBC:
/*	1. importing the packages
 *  2. Loading and registering the driver
 *  3. Establishing the connectino
 *  4. Creating the Statement
 *  5. Executing the staatement
 *  6. Processing the result
 *  7. Closing the connection */ 

public class JDBC_Steps {
	
	public static void main(String[] args) {
			// Step 2 : 
		try {
				// Loading and registering the driver
				Driver driver = new com.mysql.cj.jdbc.Driver();
				//Registering
				DriverManager.registerDriver(driver);
				
			//Step 3 :	
				// Establishing the connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch07","root","root");    // Url/databasesname,"user","passwd"
				
			//Step 4 : 	
				// Creating the Statement (i.e., vehicle)
				Statement stmt = con.createStatement();
				
			//Step 5:	
				// Executing the query
				int result = stmt.executeUpdate("insert into batch07.dept values(3,'Noman','dehli')");			// batch07 is the database name // dept is he table
				
			//Step 6:
				if(result>0) {
					System.err.println(result+" person data got inserted!!");
				}else {
					System.out.println("no data got inserted!!");
				}
			
			//Step 7 
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}
}