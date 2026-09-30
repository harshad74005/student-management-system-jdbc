package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		PreparedStatement pd =null;
		
		try {
		sc = new Scanner(System.in);
		System.out.println("Enter id : ");
		int id = sc.nextInt();
		System.out.println("1. Change name : ");
		System.out.println("2. Change marks");
		int choice = sc.nextInt();
		boolean found=false;
		
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbcwork1");
		
			if(choice == 1)
			{
				found=true;
				pd = con.prepareStatement("update student set name=? where id=?");
				System.out.println("Enter name");
				String name = sc.next();
				pd.setInt(1,id);
				pd.setString(2, name);
	
			
			
			
				
			}
			else if(choice == 2)
			{
				found = true;
				System.out.println("Enter marks : ");
				Double marks = sc.nextDouble();
				pd = con.prepareStatement("update student set marks=> where id=?");
				pd.setInt(1, id);
				pd.setDouble(2, marks);
			
				
			}
			else
			{
				System.out.println("Invalid choice");
				return;
			}
			int res = pd.executeUpdate();
			if(res>0)
			{
				System.out.println("Data updated successfully");
			}
			else
			{
				System.out.println("employee not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
