
public class HourlyWorker extends Worker {
	private int hours_Worked;
	public HourlyWorker (int hours, String name, double salary_rate) {
		 super(name,salary_rate);
		 this.hours_Worked = hours;
	};
	public double computePay(){
		if(hours_Worked>60)
			return salary_rate*60;
		else return salary_rate*hours_Worked;
	}
	@Override
	public String toString() {
		return "FullTimeWorker [hours_Worked=" + hours_Worked + ", name="
				+ name + ", salary_rate=" + salary_rate + "]";
	}
}
