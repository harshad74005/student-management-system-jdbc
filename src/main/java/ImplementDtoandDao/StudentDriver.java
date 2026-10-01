package ImplementDtoandDao;

import java.util.List;
import java.util.Scanner;

public class StudentDriver {
public static void main(String[] args) {
	Studentdao student = new StudentDaoImp();
	Scanner sc = new Scanner(System.in);
	int choice;
	do
	{
		System.out.println("===================================================");
		System.out.println("Choose 1-7 Operation");
		System.out.println("1 Add Student");
		System.out.println("2 Fetch all student");
		System.out.println("3 Fetch by id");
		System.out.println("4 update name");
		System.out.println("5 update marks");
		System.out.println("6 Delete Student");
		System.out.println("7 Exist");
		System.out.println("=====================================================");
		choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the id : ");
			int id = sc.nextInt();
			System.out.println("Enter the name : ");
			String name = sc.next();
			System.out.println("Enter the marks");
			double marks = sc.nextDouble();
			StudentDto newStudent = new StudentDto(id,name,marks);
			student.InsertStudent(newStudent);
			break;
		
		case 2 :
			List<StudentDto> list = student.getAllStudent();
			if(list.isEmpty())
			{
				System.out.println("Data not found ");
				
			}
			else
			{
				System.out.println("Id \t Name \t\t Marks");
				for(StudentDto s : list)
				{
					System.out.println(s.getId()+"\t"+s.getName()+"\t\t"+s.getMarks());
				}
			}
			break;
		case 3:
			System.out.println("Enter id for search data : ");
			int sid = sc.nextInt();
			StudentDto t = student.getById(sid);
			if(t!=null)
			{
				System.out.println("Data found");
				System.out.println(t.getId()+" "+t.getName()+" "+t.getMarks());
			}
			else
			{
				System.out.println("id not found");
			}
			break;
		case 4 :
			System.out.println("Enter id");
			int uid = sc.nextInt();
			System.out.println("enter name : ");
			String uname = sc.next();
			student.UpdateName(uid, uname);
			break;
		case 5:
			System.out.println("Enter id");
			int mid = sc.nextInt();
			System.out.println("enter marks : ");
			double mmarks = sc.nextDouble();
			student.UpdateMarks(mid, mmarks);
			break;
		case 6 :
			System.out.println("Enter id ");
			int did = sc.nextInt();
			student.deleteStudent(did);
			break;
		case 7 :
			System.out.println("System exist thank you for using this");
			break;
		default :
			System.out.println("invalid option ");
		}
		
		
			
	}while(choice != 7);
	
	
	
}
}
