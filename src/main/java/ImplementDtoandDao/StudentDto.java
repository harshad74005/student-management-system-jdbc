package ImplementDtoandDao;

public class StudentDto {
private int id;
private String name;
private double marks;
public StudentDto() {}
public StudentDto(int id,String name,double marks)
{
	this.id=id;
	this.name=name;
	this.marks=marks;
}
@Override
public String toString() {
	return "StudentDto [id=" + id + ", name=" + name + ", marks=" + marks + ", getId()=" + getId() + ", getName()="
			+ getName() + ", getMarks()=" + getMarks() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getMarks() {
	return marks;
}
public void setMarks(double marks) {
	this.marks = marks;
}

}
