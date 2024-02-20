
public class MangerDriver {
	public static void main(String[] args){
		Employee e1 = new Employee("Ritvik", 50000);
		Employee e2 = new Employee("Ayush", 10000);
		Manager m1 = new Manager("John", 100000, "Tech");
		Manager m2 = new Manager("Doe", 50000, "Core");
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(m1);
		System.out.println(m2);
	}
}
