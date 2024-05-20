package net.developia.oop3;

public class AnimalTest {

	public static void main(String[] args) {
//		Animal a = new Animal();
//		System.out.println(a);
//		
//		if(a instanceof Bird) {
//			Bird b = (Bird)a; //Exception in thread "main" java.lang.ClassCastException
//			System.out.println(b);
//		}else {
//			System.out.println("다운캐스팅 불가");
//		}

		Bird b = new Bird();
		if(b instanceof Animal) {
			Animal a = b; // 업캐스팅
			if(b instanceof Bird) {
				Bird b2 = (Bird) a;// 다운캐스팅 O
				System.out.println(a);
				if(b instanceof Condor) {
					Condor c = (Condor) b2; // 다운캐스팅 X
					System.out.println(c);
				}else {
					System.out.println("err3");
				}
			}else {
				System.out.println("err2");
			}
		}else {
			System.out.println("err1");
		}

	}

}
