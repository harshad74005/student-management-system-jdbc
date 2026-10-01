package ImplementDtoandDao;

import java.util.List;

public interface Studentdao {
void InsertStudent(StudentDto s);
List<StudentDto> getAllStudent();
StudentDto getById(int id);
void UpdateName(int id,String name);
void UpdateMarks(int id,double marks);
void deleteStudent(int id);

}
