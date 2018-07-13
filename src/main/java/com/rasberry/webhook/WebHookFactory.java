package com.rasberry.webhook;

public interface WebHookFactory {
	public WebHookExecuter getWebHookExecuter(String appName);
}
