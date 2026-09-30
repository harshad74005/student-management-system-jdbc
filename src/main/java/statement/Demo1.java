package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		load and register drive
		Class.forName("org.postgresql.Driver");
	
//		create connection 
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbcwork1","postgres","root");
		
		Statement st = con.createStatement();
		st.execute("insert into student values(102,'Aniket',90000)");
		con.close();
	}
}
