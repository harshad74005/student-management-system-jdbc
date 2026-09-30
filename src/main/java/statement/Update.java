package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbcwork1","postgres","root");
		Statement st = con.createStatement();
		int result = st.executeUpdate("delete from student where salary = 102");
		System.out.println(+result+" Updated");
		con.close();
	}
}
