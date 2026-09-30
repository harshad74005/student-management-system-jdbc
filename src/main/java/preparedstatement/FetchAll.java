package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchAll {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbcwork1","postgres","root");
			String query = "select * from student";
			PreparedStatement pd = con.prepareStatement(query);
			ResultSet r = pd.executeQuery();
			boolean found = false;
			System.out.println("------------------------------------");
			System.out.println("Id \t Name \t\t Marks");
			System.out.println("------------------------------------");
			
			while(r.next())
			{
				found=true;
				int id =r.getInt(1);
				String name = r.getString(2);
				Double marks = r.getDouble(3);
				
				System.out.println(id+"\t "+name+"\t\t "+marks);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
