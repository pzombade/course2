package com.rasberry.webhook;

import java.util.HashMap;
import java.util.Map;

public class WebHookFactoryManager {
	private final static Map<String, WebHookFactory> factory;
	
	static {
		factory = new HashMap<String, WebHookFactory>();
		factory.put("users", new UsersWebHookFactoryImpl());
		factory.put("raspberry", new RaspberryDeviceFactoryImpl());
	}
	
	public static WebHookFactory getFactory(String f) {
		return factory.get(f);
	}
}
