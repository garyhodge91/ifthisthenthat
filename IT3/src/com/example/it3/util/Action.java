package com.example.it3.util;

public class Action {
	private String category;
	private String appName;
	private String actionDescription;
	
	public static Action createAction(String category, String appName, String actionDescription){
		Action newAction = new Action();
		newAction.category = category;
		newAction.appName = appName;
		newAction.actionDescription = actionDescription;
		
		return newAction;
	}
	
	public String getCategory() {
		return category;
	}
	public String getAppName() {
		return appName;
	}
	public String getActionDescription() {
		return actionDescription;
	}
}
