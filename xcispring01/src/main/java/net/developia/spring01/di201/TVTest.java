package net.developia.spring01.di201;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVTest {
	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext(TVTest.class, "beaninit.xml");

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
