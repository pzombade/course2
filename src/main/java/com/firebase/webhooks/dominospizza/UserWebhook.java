package com.firebase.webhooks.dominospizza;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("webhook")
public class UserWebhook {
	
	@RequestMapping(method=RequestMethod.POST)
	public String insterNewStudent(HttpEntity<String> httpEntity) {
	    String reqObject = httpEntity.getBody();
		System.out.println("request json object = "+reqObject);
		
		String number="default";
		JSONObject obj;
		try {
			obj = new JSONObject(reqObject);
			number = obj.getJSONObject("result").getJSONObject("parameters").getString("number");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//JSONObject number = obj.getJSONObject("result").getJSONObject("parameters");
		
		
		
		String speech="Hello from spring number="+number+" json="+reqObject;
		return "{'speech': '"+speech+"', 'displayText':'"+speech+"'}";
	    
	}
}
