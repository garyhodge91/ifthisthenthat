package com.example.it3.util;

import com.example.it3.databaseHelpers.ActionTableHelper;
import com.example.it3.databaseHelpers.DatabaseHelper;

public class ActionHelper {

	ActionTableHelper ah = new ActionTableHelper();;
	
	public long createError(Action action, DatabaseHelper db){		
		return ah.createAction(action, db);
	}
	
	public void markErrorAsSeen(Action action, DatabaseHelper db){
		ah.updateAction(action, db);
	}
	
	public void deleteError(Action action, DatabaseHelper db){
		ah.deleteAction(action.getId(), db);
	}

}
