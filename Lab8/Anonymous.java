public class Anonymous {
	public Circle getCircle(int radius) {
		// Write one line statement that returns object of Circle
		// by writing Anonymous inner class.
		return new Circle(5);
	}

	public static void main(String[] args) {
		Anonymous p = new Anonymous();
		Circle w = p.getCircle(10);
		// The output here should give correct value of area
		// of the circle.
		System.out.println(w.area());
	}
}

class Circle {
	public final static double PI = 3.14169;
	private int rad;

	public Circle(int radius) {
		rad = radius;
	}

	public double area() {
		return PI * rad * rad;
	}
}