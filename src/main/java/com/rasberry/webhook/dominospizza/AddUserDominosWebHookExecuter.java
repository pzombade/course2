package com.rasberry.webhook.dominospizza;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.course.course.dao.firebase.UsersDao;
import com.rasberry.webhook.WebHookExecuter;

@Component
public class AddUserDominosWebHookExecuter implements WebHookExecuter {
	
	@Override
	public String executeWebHook(JSONObject obj) throws JSONException {
		return "Hello from AddUserDominosWebHookExecuter number="+obj.getString("number");
	}
}
