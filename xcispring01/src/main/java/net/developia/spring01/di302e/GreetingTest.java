package net.developia.spring01.di302e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.developia.spring01.di302e.BeanInit;

public class GreetingTest {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(BeanInit.class);
		
		System.out.println("-------------------------");
		Outputter output = (Outputter)context.getBean("outputter");
		output.greeting();
	}
}
