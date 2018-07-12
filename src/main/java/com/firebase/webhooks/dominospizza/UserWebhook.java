package com.firebase.webhooks.dominospizza;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("webhook")
public class UserWebhook {
	
	@RequestMapping(method=RequestMethod.POST)
	public String insterNewStudent(HttpEntity<String> httpEntity) {
	    String json = httpEntity.getBody();
		System.out.println("request json object = "+json);
		
		String speech="Hello from spring";
		return "{'speech': '"+speech+"', 'displayText':'"+speech+"'}";
	    
	}
}
