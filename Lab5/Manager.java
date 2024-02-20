
public class Manager extends Employee {
	String department;
	public Manager(String Name, double salary, String department){
		super(Name, salary);
		this.department = department;
	}
	public String getDept(){
		return department;
	}
	public String changeDept(String dept){
		this.department= dept;
		return department;
	}
	@Override
	public String toString() {
		return "Manager [department=" + department + ", name=" + name
				+ ", salary=" + salary + "]";
	}
	
}
