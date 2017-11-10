package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
	
	@Value("${welcome.message}")
	private String welcomeMsg;
	public String welcomeRetreivalFromService()
	{
		//return "From Service Welcome 1234";
		return welcomeMsg;
	}
}