package com.rasberry.webhook;

import org.json.JSONException;
import org.json.JSONObject;

public class AddRaspberryDeviceWebHookExecuter implements WebHookExecuter {


	@Override
	public String executeWebHook(JSONObject obj) throws JSONException {
		return "Hello from GetRaspberryWebHookExecuter deviceName="+obj.getString("deviceName");
	}
}
