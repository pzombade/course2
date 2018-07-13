package com.rasberry.webhook.dominospizza;

import org.json.JSONException;
import org.json.JSONObject;

import com.rasberry.webhook.WebHookExecuter;

public class GetUserDominosWebHookExecuter implements WebHookExecuter {

	@Override
	public String executeWebHook(JSONObject obj) throws JSONException {
		return "Hello from GetUserDominosWebHookExecuter number="+obj.getString("number");
	}
}
