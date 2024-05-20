package net.developia.spring01.di301;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInit {
	@Bean // 메서드 이름이 요청하는 이름이 된다! (tv)
	public TV tv() {
		return new SamsungTV();
	}
	
	@Bean
	public Speaker speaker() {
		return new HarmanSpeaker();
	}
		
}
