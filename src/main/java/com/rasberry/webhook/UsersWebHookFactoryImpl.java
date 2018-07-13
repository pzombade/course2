package com.rasberry.webhook;

import java.util.HashMap;
import java.util.Map;

import com.course.course.MyOwnApplication;
import com.rasberry.webhook.dominospizza.AddUserDominosWebHookExecuter;
import com.rasberry.webhook.dominospizza.GetAllUsersExecuter;
import com.rasberry.webhook.dominospizza.GetUserDominosWebHookExecuter;

public class UsersWebHookFactoryImpl implements WebHookFactory {

	private static final Map<String,WebHookExecuter> FactoryMap;
	
	static {
		FactoryMap = new HashMap<String,WebHookExecuter>();
		//FactoryMap.put("getUser", new GetUserDominosWebHookExecuter());
		//FactoryMap.put("addUser", new AddUserDominosWebHookExecuter());
		FactoryMap.put("getUser", MyOwnApplication.getBean(GetUserDominosWebHookExecuter.class));
		FactoryMap.put("addUser", MyOwnApplication.getBean(AddUserDominosWebHookExecuter.class));
		FactoryMap.put("getAllUsers", MyOwnApplication.getBean(GetAllUsersExecuter.class));
	}
	
	@Override
	public WebHookExecuter getWebHookExecuter(String appName) {
		return FactoryMap.get(appName);
	}
}
