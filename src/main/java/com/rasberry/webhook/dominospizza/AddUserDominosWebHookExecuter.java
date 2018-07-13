package com.rasberry.webhook.dominospizza;

import org.json.JSONException;
import org.json.JSONObject;

import com.rasberry.webhook.WebHookExecuter;

public class AddUserDominosWebHookExecuter implements WebHookExecuter {

	@Override
	public String executeWebHook(JSONObject obj) throws JSONException {
		return "Hello from AddUserDominosWebHookExecuter number="+obj.getString("number");
	}
}
