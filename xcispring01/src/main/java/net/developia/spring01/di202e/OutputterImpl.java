package net.developia.spring01.di202e;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("net/developia/spring01/di202e/system.properties")
public class OutputterImpl implements Outputter{
	private String name;
	private String greeting;
	@Autowired
	private FileOutputter fileOutputter;


	
	public OutputterImpl(@Value("${name}") String name, @Value("${greeting}") String greeting, FileOutputter fileOutputter) {
		super();
		this.name = name;
		this.greeting = greeting;
		this.fileOutputter = fileOutputter;
	}



	@Override
	public void greeting() {
		System.out.println(name + "님, " + greeting);
		
		try {
			if(fileOutputter != null)
				fileOutputter.output(name + "님, "+ greeting);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
