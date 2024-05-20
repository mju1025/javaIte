package net.developia.spring01.di302e;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource("net/developia/spring01/di302e/system.properties")
@Configuration
public class BeanInit {
	@Value("${name}") String name;
	@Value("${greeting}") String greeting;
	
	@Bean // 메서드 이름이 요청하는 이름이 된다! (outputter)
	public Outputter outputter() {
		return new OutputterImpl(fileoutputter(), name, greeting);
	}
	
	@Bean 
	public FileOutputter fileoutputter() {
		return new FileOutputterImpl();
	}

}
