package com.example.it3.util;

public class Trigger {
	private String category;
	private String appName;
	private String triggerDescription;
	
	public static Trigger createTrigger(String category, String appName, String triggerDescription){
		Trigger newTrigger = new Trigger();
		newTrigger.category = category;
		newTrigger.appName = appName;
		newTrigger.triggerDescription = triggerDescription;
		
		return newTrigger;
	}
	
	public String getCategory() {
		return category;
	}
	public String getAppName() {
		return appName;
	}
	public String getTriggerDescription() {
		return triggerDescription;
	}

}
