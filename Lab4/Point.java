public class Point{
	private double x; // Instance field x-coordinate
	private double y; // Instance field y-coordinate
	
	Point(double x, double y){ this.x=x;this.y=y; }
	
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	
	public void setX(double x) { this.x = x; }
	public void setY(double y) { this.y = y; }
	
	public String toString() { return "X="+x+" Y ="+y; }
	
	public static void changeState(Point other){
	other.setX(-20); // Here you can write other.z = 20 also
	 // because this code is inside the class
	other.setY(-20); // Here you can write other.z = 20 also
	 // because this code is inside the class
	// Note that changeState Method changing the state of the Passed
	 // object by using the same reference
	// So this change in state will be reflected in caller method
	 // also
	}
	public static void changeReference(Point other){
	Point other2 = new Point(-20,-20); // Will this change be
	 // reflected in caller method
	// Note that this Method has changed the reference from
	 // incoming Point object to some other Point object
	// So this change will not be reflected in caller method.
	}
}