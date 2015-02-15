package com.example.it3.util;

import java.util.ArrayList;

public class createTriggers {
	
	public static ArrayList<Trigger> newTriggers(){
		ArrayList<Trigger> triggers = new ArrayList<Trigger>();
			
		Trigger facebookDM = Trigger.createTrigger("Receive Message", "Facebook", "Send Facebook Direct Message");
		triggers.add(facebookDM);
		
		Trigger twitterDM = Trigger.createTrigger("Receive Message", "Twitter", "Send Twitter Direct Message");
		triggers.add(twitterDM);
		
		Trigger notification = Trigger.createTrigger("Physical", "System", "Display Notification");
		triggers.add(notification);
		
		return triggers;
		}

}
