package com.frankmoley.lil.fid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.frankmoley.lil.fid.service.GreetingService;
import com.frankmoley.lil.fid.service.OutputService;
import com.frankmoley.lil.fid.service.TimeService;


@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	
	@Value("${app.greeting}")
	private String greeting;
	
	@Value("${app.name}")
	private String name;
	
	
	@Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")
	private boolean is24;
	
	@Autowired
	private GreetingService greetingService;
	
	@Autowired
	private TimeService timeService;
	
	@Bean       // \n @Profile("!dev")
	public TimeService timeservice() {
		
		return new TimeService (true);
	};

	/*
	@Bean
	@Profile("dev")
	public TimeService timeservice12() {
		
		return new TimeService (false);
	};
*/
	
	
	@Bean
	public OutputService outputservice() {
		
		return new OutputService(greetingService, timeService,name);
	}
	
	
	@Bean
	public GreetingService greetingService() {
		
		return new GreetingService(greeting);
	}
	
}















