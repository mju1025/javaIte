package net.developia.spring01.di101;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVTest {
	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext(TVTest.class, "beaninit.xml");
		//특징 1. singleton
		// 2. 
		
		System.out.println("--------------------");
		TV tv1 = (TV)context.getBean("tv");
		tv1.powerOn();
		tv1.channelUp();
		tv1.channelUp();
		tv1.soundUp();
		tv1.soundUp();
		tv1.powerOff();
		
		TV tv2 = (TV)context.getBean("tv");
		tv2.powerOn();
		tv2.channelUp();
		tv2.channelUp();
		tv2.soundUp();
		tv2.soundUp();
		tv2.powerOff();
		
		// 같은 인스턴스 => 싱글톤이다
		System.out.println(tv1.hashCode() + ", "+ tv2.hashCode());

	}
}
