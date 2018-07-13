package com.rasberry.webhook;

import java.util.HashMap;
import java.util.Map;

import com.rasberry.webhook.dominospizza.AddUserDominosWebHookExecuter;
import com.rasberry.webhook.dominospizza.GetUserDominosWebHookExecuter;

public class UsersWebHookFactoryImpl implements WebHookFactory {

	private static final Map<String,WebHookExecuter> FactoryMap;
	
	static {
		FactoryMap = new HashMap<String,WebHookExecuter>();
		FactoryMap.put("getUser", new GetUserDominosWebHookExecuter());
		FactoryMap.put("addUser", new AddUserDominosWebHookExecuter());
	}
	
	@Override
	public WebHookExecuter getWebHookExecuter(String appName) {
		return FactoryMap.get(appName);
	}
}
