package com.rasberry.webhook;

import java.util.HashMap;
import java.util.Map;

import com.rasberry.webhook.dominospizza.AddUserDominosWebHookExecuter;
import com.rasberry.webhook.dominospizza.GetUserDominosWebHookExecuter;

public class RaspberryDeviceWebHookFactoryImpl implements WebHookFactory {

	private static final Map<String,WebHookExecuter> FactoryMap;
	
	static {
		FactoryMap = new HashMap<String,WebHookExecuter>();
		FactoryMap.put("getDevice", new AddRaspberryDeviceWebHookExecuter());
		FactoryMap.put("addDevice", new GetRaspberryWebHookExecuter());
	}
	
	@Override
	public WebHookExecuter getWebHookExecuter(String appName) {
		return FactoryMap.get(appName);
	}
}
