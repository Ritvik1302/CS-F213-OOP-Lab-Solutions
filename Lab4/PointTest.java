public class PointTest{
	public static void main(String args[]){
		// Pass By Reference
		Point p1 = new Point(10,20);
		System.out.println(p1); // See the o/p for this line
		Point.changeState(p1);
		System.out.println(p1); // See the o/p for this line
		// Pass By value
		Point p2 = new Point(100,200);
		System.out.println(p2); // See the o/p for this line
		Point.changeReference(p2);
		System.out.println(p2); // See the o/p for this line
		} // End of Method main()
} 