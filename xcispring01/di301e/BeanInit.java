package net.developia.spring01.di301e;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource("net/developia/spring01/di301e/system.properties")
@Configuration
public class BeanInit {
	@Bean // 메서드 이름이 요청하는 이름이 된다! (outputter)
	public Outputter outputter() {
		OutputterImpl outputter = new OutputterImpl();
		outputter.setFileOutputter(fileoutputter());
		return outputter;
	}
	
	@Bean 
	public FileOutputter fileoutputter() {
		return new FileOutputterImpl();
	}

}
