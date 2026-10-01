package ImplementDtoandDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImp implements Studentdao {

	Scanner sc = null;
	@Override
	public void InsertStudent(StudentDto s) {
		String query = "insert into student values(?,?,?)";
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,s.getId());
			ps.setString(2, s.getName());
			ps.setDouble(3, s.getMarks());
			int res = ps.executeUpdate();
			if(res>0)
			{
				System.out.println("Data inserted Successfully");
			}
			else
			{
				System.out.println("Data not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<StudentDto> studentlist = new ArrayList<StudentDto>();
		String query = "select * from student";
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet r = ps.executeQuery();
			while(r.next())
			{
				int id = r.getInt(1);
				String name = r.getString(2);
				double marks = r.getDouble(3);
				
				StudentDto studentdto = new StudentDto(id,name,marks);
				studentlist.add(studentdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentlist;
	}

	@Override
	public StudentDto getById(int id) {
		// TODO Auto-generated method stub
	String query = "select * from student where id=?";
	StudentDto student = null;
	try {
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet r = ps.executeQuery();
		while(r.next())
		{
			int sid = r.getInt(1);
			String sname = r.getString(2);
			double smarks = r.getDouble(3);
			
			student = new StudentDto(sid,sname,smarks);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return student;
	}

	@Override
	public void UpdateName(int id, String name) {
		String query = "update student set name=? where id=?";
	
		try {
			Connection con =  DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			if(res > 0)
			{
				System.out.println("Updated name successfully");
			}
			else
			{
				System.out.println("Id not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void UpdateMarks(int id, double marks) {
		// TODO Auto-generated method stub
		String query = "update student set marks=? where id=?";
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDouble(1, marks);
			ps.setInt(2, id);
			int res = ps.executeUpdate();
			if(res > 0)
			{
				System.out.println("Marks updated successfully");
			}
			else
			{
				System.out.println("Id not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		String query = "delete from student where id=?";
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);			
			int res = ps.executeUpdate();
			if(res > 0)
			{
				System.out.println("Data deleted succesfully");
			}
			else
			{
				System.out.println("Id not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
