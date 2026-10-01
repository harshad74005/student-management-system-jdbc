package ImplementDtoandDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
private static final String url="jdbc:postgresql://localhost:5433/studentsystem2";
private static final String user = "postgres";
private static final String password = "root";

public static Connection getConnection() throws SQLException
{
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return DriverManager.getConnection(url,user,password);
}
}
