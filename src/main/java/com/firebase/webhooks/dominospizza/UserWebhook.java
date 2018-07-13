package com.firebase.webhooks.dominospizza;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rasberry.webhook.WebHookExecuter;
import com.rasberry.webhook.WebHookFactory;
import com.rasberry.webhook.WebHookFactoryManager;


@RestController
@RequestMapping("raspberry")
public class UserWebhook {
	
	@RequestMapping(method=RequestMethod.POST)
	public String insterNewStudent(@RequestHeader(value="appName") String appNameStr, HttpEntity<String> httpEntity) {
		
		String reqObject = httpEntity.getBody();
		System.out.println("request json object = "+reqObject);
			
		
		String action="default";
		String response = "";
		try {
			JSONObject obj = new JSONObject(reqObject);
			action = obj.getJSONObject("result").getString("action");
			JSONObject params = obj.getJSONObject("result").getJSONObject("parameters");
			WebHookFactory wf = WebHookFactoryManager.getFactory(appNameStr);
			WebHookExecuter ex = wf.getWebHookExecuter(action);
			response = ex.executeWebHook(params);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		
		String speech="Hello from spring appNameStr="+appNameStr+" action="+action+" response="+response+" json="+reqObject;
		System.out.println("request action = "+action);
		return "{'speech': '"+action+"', 'displayText':'"+speech+"'}";
	}
}
