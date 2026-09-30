package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		load and register driver
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbcwork1","postgres","root");
		Statement st = con.createStatement();
		
		ResultSet r =	st.executeQuery("select * from student");
		while(r.next())
		{
			System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getDouble(3));
			System.out.println("row completed");
		}
		con.close();
	}
}
