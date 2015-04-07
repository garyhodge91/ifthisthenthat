package com.example.it3.util;

import com.example.it3.databaseHelpers.DatabaseHelper;
import com.example.it3.databaseHelpers.TriggerTableHelper;

public class TriggerHelper {
	
TriggerTableHelper th = new TriggerTableHelper();;
	
	public long createError(Trigger trigger, DatabaseHelper db){		
		return th.createTrigger(trigger, db);
	}
	
	public void markErrorAsSeen(Trigger trigger, DatabaseHelper db){
		th.updateTrigger(trigger, db);
	}
	
	public void deleteError(Trigger trigger, DatabaseHelper db){
		th.deleteTrigger(trigger.getId(), db);
	}

}
