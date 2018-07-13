package com.rasberry.webhook;

import java.util.HashMap;
import java.util.Map;

public class RaspberryDeviceFactoryImpl implements WebHookFactory {

	private static final Map<String,WebHookExecuter> FactoryMap;
	
	static {
		FactoryMap = new HashMap<String,WebHookExecuter>();
		FactoryMap.put("getDevice", new GetRaspberryWebHookExecuter());
		FactoryMap.put("addDevice", new AddRaspberryDeviceWebHookExecuter());
	}
	
	@Override
	public WebHookExecuter getWebHookExecuter(String appName) {
		return FactoryMap.get(appName);
	}
}
