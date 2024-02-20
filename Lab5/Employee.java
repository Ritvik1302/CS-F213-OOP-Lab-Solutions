
public class Employee {
	String name;
	double salary;
	
	public Employee(String name, double salary){
		this.name= name;
		this.salary = salary;
	}
	double getSalary(){
		return salary;
	}
	String getName(){
		return name;
	}
	double changeSalary(double sal){
		this.salary=sal;
		return this.salary;
	}
	String getName(String name){
		this.name = name;
		return this.name;
	}
	public String toString(){
		return "Name: " + name + " Salary: " + salary;
	}
}
