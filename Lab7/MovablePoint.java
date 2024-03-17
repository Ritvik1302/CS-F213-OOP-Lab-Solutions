
public class MovablePoint implements Movable, Comparable<MovablePoint>{
	int x, y, xSpeed, ySpeed; // package access
//Constructor

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public MovablePoint(int x, int y, int xSpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
	}

	@Override
	public void moveUp() {
		y -= ySpeed;
	}
	
	@Override
	public void moveDown() {
		y++;
	}
	
	@Override
	public void moveLeft() {
		x--;
	}
	
	@Override
	public void moveRight() {
		x++;
	}
	
	public int compareTo(MovablePoint m2) {
		return m2.x-x+m2.y-y;
	}

}
