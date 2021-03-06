package com.rasberry.webhook.dominospizza;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.course.dao.firebase.UserService;
import com.rasberry.webhook.WebHookExecuter;

@Component
public class GetUserDominosWebHookExecuter implements WebHookExecuter {

	
	public GetUserDominosWebHookExecuter() {}
			
	@Autowired
	public UserService service;
	
	@Override
	public String executeWebHook(JSONObject obj) throws JSONException {
		return "Found user number="+service.getUser(obj.getString("number"));
	}
}
