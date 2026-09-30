package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Scanner sc = null;
	Connection con = null;
	
	sc = new Scanner(System.in);
	System.out.println("Enter Student id : ");
	int id = sc.nextInt();
	System.out.println("Enter student name : ");
	String name = sc.next();
	System.out.println("Enter Student marks : ");
	Double marks = sc.nextDouble();
	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbcwork1","postgres","root");
	PreparedStatement pd = con.prepareStatement("insert into student values(?,?,?)");
	pd.setInt(1, id);
	pd.setString(2, name);
	pd.setDouble(3, marks);
	
	int res = pd.executeUpdate();
	System.out.println("Data insert"+res);
	
}
}
