package com.rasberry.webhook.dominospizza;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.course.dao.firebase.UserService;
import com.course.course.dao.firebase.UsersDao;
import com.firebase.webhooks.dominospizza.Users;
import com.rasberry.webhook.WebHookExecuter;

@Component
public class AddUserDominosWebHookExecuter implements WebHookExecuter {
	
	@Autowired
	public UserService service;
	
	@Override
	public String executeWebHook(JSONObject obj) throws JSONException {
		String firstName = obj.getString("firstName");
		String lastName = obj.getString("lastName");
		String mobileNumber = obj.getString("mobileNumber");
		
		Users u = new Users(mobileNumber,firstName, lastName);
		return "Added a new user "+service.addUser(u);
	}
}
