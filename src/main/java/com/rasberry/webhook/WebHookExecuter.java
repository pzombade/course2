package com.rasberry.webhook;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public interface WebHookExecuter {
	public String executeWebHook(JSONObject obj) throws JSONException;
}
