package net.developia.oop2;

public class Point2D {
	int x;
	int y;
	
	
	public Point2D() {
		this(1,2); // 생성자에서 생성자를 호출할때는 제일 먼저 써줘야한다!!
		System.out.println("Point2D() 수행");
		//this(1,2);
	}
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Point2D(x, y) 수행");
	}

	@Override
	public String toString() {
		return "x = " + x + ", " + "y = " + y;
	}
	
}
