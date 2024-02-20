abstract public class Worker {
// Private member variable
	 public String name;
	 public double salary_rate;
	// Constructor
	 public Worker (String name, double salary_rate) {
	 this.name = name;
	 this.salary_rate = salary_rate;
	 }
	 
	@Override
	public String toString() {
		return "Worker [name=" + name + ", salary_rate=" + salary_rate + "]";
	}
	
	public String getName(){
		return name;
	}
	public double getSalary_rate(){
		return salary_rate;
	}
	abstract public double computePay();
}
