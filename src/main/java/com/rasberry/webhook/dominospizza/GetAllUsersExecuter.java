package com.rasberry.webhook.dominospizza;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.course.dao.firebase.UserService;
import com.rasberry.webhook.WebHookExecuter;

@Component
public class GetAllUsersExecuter implements WebHookExecuter {

	
	public GetAllUsersExecuter() {}
			
	@Autowired
	public UserService service;
	
	@Override
	public String executeWebHook(JSONObject obj) throws JSONException {
		return "List users = "+service.getAllUsers();
	}
}
