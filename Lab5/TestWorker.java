
public class TestWorker {
	public static void main(String[] args){
		FullTimeWorker full = new FullTimeWorker(250, "Ayush", 100);
		HourlyWorker hourly = new HourlyWorker(120, "Aditya", 50);
		System.out.println(full);
		System.out.println(full.computePay());
		System.out.println(hourly);
		System.out.println(hourly.computePay());
	}
}
