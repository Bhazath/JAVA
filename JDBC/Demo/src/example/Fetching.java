package example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetching {
	public static void main(String[] args) {
		Connection con=null;
		// Step 2 : Loading and registering the driver
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			//registering
			DriverManager.registerDriver(driver);
			
			//Setp 3 : Establishing the connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch07","root","root");
			
			//Step 4 : Creating the statement
			Statement stmt = con.createStatement();
			
			//Step 5 : Executing the Query
			ResultSet resultset = stmt.executeQuery("select * from dept where deptno=20");
			
			//processing the result
			if(resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				String loc = resultset.getString(3);
				
				System.out.println("name = "+name+", id = "+id+", loc = "+loc);
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close the connnection
		finally {
			if(con!=null) {
				//close the connnection
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
