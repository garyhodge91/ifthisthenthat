package com.example.it3.util;

import java.util.ArrayList;

public class createActions {
	
	public static ArrayList<Action> newActions(){
	ArrayList<Action> actions = new ArrayList<Action>();
		
	Action facebookDM = Action.createAction("Send Message", "Facebook", "Send Facebook Direct Message");
	actions.add(facebookDM);
	
	Action twitterDM = Action.createAction("Send Message", "Twitter", "Send Twitter Direct Message");
	actions.add(twitterDM);
		
	Action notification = Action.createAction("Display Message", "System", "Display Notification");
	actions.add(notification);
	
	return actions;
	}

}
