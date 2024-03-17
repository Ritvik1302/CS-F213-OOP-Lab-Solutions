interface Comparator{
	int compare(Object O1, Object O2);
}

public class MovableCircle implements Movable {
	// instance variables
	private MovablePoint center; // can use center.x, center.y directly
	// because they are package accessible
	private int radius;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		// Call the MovablePoint's constructor to allocate the center instance.
		center = new MovablePoint(x, y, xSpeed, ySpeed);
	}

	public MovableCircle(int x, int y, int xSpeed, int ySpeed) {
		// Call the MovablePoint's constructor to allocate the center instance.
		center = new MovablePoint(x, y, xSpeed, ySpeed);
	}

	public MovableCircle(MovablePoint center, int radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public MovablePoint getCenter() {
		return center;
	}

	public void setCenter(MovablePoint center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	// Implement abstract methods declared in the interface Movable
	@Override
	public void moveUp() {
		center.y -= center.ySpeed;
	}

	public void moveRight() {
		center.moveRight();
	}

	public void moveLeft() {
		center.moveLeft();
	}

	public void moveDown() {
		center.moveDown();
	}
	public int compareTo(MovableCircle c2) {
		if( getRadius() > c2.getRadius() ) return 1;
		if( getRadius() < c2.getRadius()) return -1;
		return 0;
	}
}

class CircleByRadius implements Comparator {
	public int compare(Object o1, Object o2) {
		MovableCircle c1 = (MovableCircle) o1;
		MovableCircle c2 = (MovableCircle) o2;
		return c1.compareTo(c2);
	}
}
class CircleByCenter implements Comparator {
	public int compare(Object o1, Object o2) {
		MovableCircle c1 = (MovableCircle) o1;
		MovableCircle c2 = (MovableCircle) o2;
		return c1.getCenter().compareTo(c2.getCenter());
	}
}
class CircleByRadiusandCentre implements Comparator {
	public int compare(Object o1, Object o2) {
		MovableCircle c1 = (MovableCircle) o1;
		MovableCircle c2 = (MovableCircle) o2;
		return c1.getCenter().compareTo(c2.getCenter()) & c1.compareTo(c2);
	}
}