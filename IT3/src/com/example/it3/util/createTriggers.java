package com.example.it3.util;

import java.util.ArrayList;

import com.example.it3.databaseHelpers.*;

public class createTriggers {
	
	public static void newTriggerDefs(DatabaseHelper db){
		
		TriggerDefTableHelper tdh = new TriggerDefTableHelper();
		TriggerDef triggerDef;
		
		triggerDef = TriggerDef.createTriggerDef("Receive Message", "Send Facebook Direct Message", "facebook");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Test 1", "location", "facebook");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Test 2", "location", "facebook");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Test 3", "location", "facebook");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Test 4", "location", "facebook");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Receive Message", "twitter", "Send Twitter Direct Message");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Test 1", "twitter", "Display Notification");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Test 2", "twitter", "location");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Test 3", "twitter", "location");
		tdh.createTriggerDef(triggerDef, db);
		
		triggerDef = TriggerDef.createTriggerDef("Test 4", "twitter", "location");
		tdh.createTriggerDef(triggerDef, db);
		
		}

}
