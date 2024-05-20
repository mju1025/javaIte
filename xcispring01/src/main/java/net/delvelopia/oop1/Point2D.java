package net.delvelopia.oop1;

public class Point2D { // 설계도
	private int x; 
	private int y;
	
	// getter & setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public void print() {
		System.out.println("x = " + getX());
		System.out.println("y = " + getY());
	}
}
