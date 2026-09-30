package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Fetch {

	public static void main(String[] args) {
		Scanner sc= null;
		Connection con = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Enter id : ");
			int id = sc.nextInt();
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbcwork1","postgres","root");
			PreparedStatement pd = con.prepareStatement("select * from student where id=?");
			boolean found = false;
			pd.setInt(1, id);
			ResultSet rs = pd.executeQuery();
			
			while(rs.next())
			{
				found=true;
				System.out.println(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
				System.out.println("row completed");
			}
			if(!found)
			{
				System.out.println("The id is not in table plese inset present id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
