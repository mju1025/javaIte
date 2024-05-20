package net.delvelopia.oop1;

public class PointTest {
	public static void main(String[] args) {
		Point3D pt = new Point3D(); // 인스턴스(Object), pt: 인스턴스 참조명
		
		pt.setX(100);
		pt.setY(200);
		pt.setZ(300);

		pt.print();
	}
}
