package Student_Menu_Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_Menu_Driver_Project {
	private static final String url ="jdbc:postgresql://localhost:5433/studentsystem";
	private static final String user = "postgres";
	private static final String password = "root";
	
	public static void main(String[] args) {
		
		Connection con = null;
		Scanner sc = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url,user,password);
			sc = new Scanner(System.in);
			int choice;
			do {
				System.out.println("====================================================");
				System.out.println("Student Management System");
				System.out.println("=====================================================");
				System.out.println("1. Add the student (insert)");
				System.out.println("2 Fetch all Student Data (fetchAll)");
				System.out.println("3 Fetch by id ");
				System.out.println("4 update Student data");
				System.out.println("5 Delete student data");
				System.out.println("6 exit");
				System.out.println("======================================================");
				System.out.println("Enter your choice between 1-6");
				
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the id : ");
					int id = sc.nextInt();
					System.out.println("Enter the name : ");
					String name = sc.next();
					System.out.println("Enter the marks : ");
					Double marks = sc.nextDouble();
					
					ps = con.prepareStatement("insert into student values(?,?,?)");
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setDouble(3, marks);
					
					int res = ps.executeUpdate();
					if(res>0)
					{
						System.out.println("Data inserted succefully"+res);
					}
					else
					{
						System.out.println("Data not inserted");
					}
									
					break;

				case 2 :
					System.out.println("=================================================");
					System.out.println("Id\t Name \t\t Marks");
					System.out.println("==================================================");
					ps = con.prepareStatement("select * from student");
					ResultSet r =ps.executeQuery();
					boolean found = true;
					while(r.next())
					{
						System.out.println(r.getInt(1)+"\t"+r.getString(2)+"\t\t"+r.getDouble(3));
					}
					if(false)
					{
						System.out.println("Data is not found in tabel");
					}
					break;
					
				case 3:
					sc = new Scanner(System.in);
					System.out.println("Enter id : ");
					int sid = sc.nextInt();
					ps = con.prepareStatement("select * from student where id=?");
					ps.setInt(1, sid);
					ResultSet searchId = ps.executeQuery();
					
					if(searchId.next())
					{
						
						System.out.println("\n studend data found");
						System.out.println("=====================================");
						System.out.println("Id : "+searchId.getInt(1));
						System.out.println("Name : "+searchId.getString(2));
						System.out.println("Marks : "+searchId.getDouble(3));
						System.out.println("=====================================");
					}
					else
					{
						System.out.println("Student not found with id ");
					}
					break;
				case 4 :
					sc = new Scanner(System.in);
					
					System.out.println("Enter what you want to update 1 or 2");
					System.out.println("1 update name");
					System.out.println("2 update marks");
					int uchoice = sc.nextInt();
					
					if(uchoice==1)
					{
						
						sc = new Scanner(System.in);
						System.out.println("Enter Id ");
						int uid = sc.nextInt();
						System.out.println("Enter the name");
						String uname = sc.next();
						ps = con.prepareStatement("update student set name=? where id=?");
						ps.setString(1, uname);
						ps.setInt(2, uid);
					}
					else if(uchoice==2)
					{
						sc = new Scanner(System.in);
						System.out.println("Enter Id ");
						int uid = sc.nextInt();
						System.out.println("Enter the marks : ");
						double umarks = sc.nextDouble();
						ps = con.prepareStatement("update student set marks=? where id=?");
						ps.setDouble(1, umarks);
						ps.setInt(2, uid);
						
					}
					else
					{
						System.out.println("invalid choice");
					}
					int result = ps.executeUpdate();
					if(result > 0)
					{
						System.out.println("Data updated successfully");
					}
					else {
						System.out.println("not updated");
					}
					break;
				case 5:
					System.out.println("Enter the id");
					int did = sc.nextInt();
					ps = con.prepareStatement("delete from student where id=?");
					ps.setInt(1, did);
					int dresult = ps.executeUpdate();
					if(dresult>0)
					{
						System.out.println("record deleted successfully");
					}
					else
					{
						System.out.println("Data not found with id");
					}
					break;
				case 6:
					System.out.println("Existing..... Thank you for using student management system.");
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			}
			
			while(choice != 6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(sc!=null)sc.close();
		}
	}
}
