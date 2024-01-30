import java.util.Scanner; 

public class TaxOnSalary {
	private double salary;
	private boolean isPansubmitted;
	
	public TaxOnSalary(boolean isPansubmitted) {
		this.isPansubmitted = isPansubmitted;
		this.salary=1000.0;
	}
	public TaxOnSalary() {
		this.isPansubmitted = false;
		this.salary=0.0;
	}
	
	public double GetSalary(){
		System.out.println("Salary: "+salary);
		return this.salary;
	}
	public boolean GetisPanSubmitted(){
		System.out.println("isPansubmitted: "+isPansubmitted);
		return this.isPansubmitted;
	}
	
	public double calculateTax(){
		if(salary<180000&&isPansubmitted==true){
			return 0.0;
		}
		else if(salary<180000&&isPansubmitted==false){
			return 0.05*salary;
		}
		else if(salary>180000&&salary<500000==false){
			return 0.1*salary;
		}
		else if(salary<1000000&&salary>500000==false){
			return 0.2*salary;
		}
		else return 0.3*salary;
	}
	
	public void inputSalary(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Salary");
		salary = in.nextDouble();
		System.out.println("New Salary: "+salary);
	}
}
