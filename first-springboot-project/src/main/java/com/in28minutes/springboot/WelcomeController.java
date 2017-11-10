package com.in28minutes.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.configuration.BasicConfiguration;


@RestController
public class WelcomeController {
 
	@Autowired
 	private WelcomeService service;
 
	@Autowired
	private BasicConfiguration basicConfiguration;
	
 	@RequestMapping("/welcome")
 	public String welcome()
	{
		//return "This is welcome msg";
 		return service.welcomeRetreivalFromService();
	}
	
 	@RequestMapping("/dynamic-config")
 	public Map dynamicConfiguragtion()
	{
		//return "This is welcome msg";
 		
 		Map map = new HashMap();
 		map.put("Boolean", basicConfiguration.isValue());
 		map.put("Number",basicConfiguration.getNumber());
 		map.put("String Val",basicConfiguration.getStr());
 		
 		return map;
	}
}

