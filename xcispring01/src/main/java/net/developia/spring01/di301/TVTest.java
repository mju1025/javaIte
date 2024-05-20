package net.developia.spring01.di301;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVTest {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BeanInit.class);

		System.out.println("--------------------");
		TV tv1 = (TV)context.getBean("tv");
		tv1.powerOn();
		tv1.channelUp();
		tv1.channelUp();
		tv1.soundUp();
		tv1.soundUp();
		tv1.powerOff();

	}
}
