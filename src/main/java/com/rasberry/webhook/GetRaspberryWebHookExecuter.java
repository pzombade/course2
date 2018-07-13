package com.rasberry.webhook;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class GetRaspberryWebHookExecuter implements WebHookExecuter {

	@Override
	public String executeWebHook(JSONObject obj) throws JSONException {
		// TODO Auto-generated method stub
		return "Hello from AddRaspberryDeviceWebHookExecuter deviceName="+obj.getString("deviceName");
	}
}
