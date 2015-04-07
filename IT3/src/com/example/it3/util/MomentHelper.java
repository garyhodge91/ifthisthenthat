package com.example.it3.util;

import com.example.it3.databaseHelpers.DatabaseHelper;
import com.example.it3.databaseHelpers.MomentTableHelper;

public class MomentHelper {

	MomentTableHelper mh = new MomentTableHelper();;
	
	public long createError(Moment moment, DatabaseHelper db){
		return mh.createMoment(moment, db);
	}
	
	public void updateMoment(Moment moment, DatabaseHelper db){
		mh.updateMoment(moment, db);
	}
	
	public void softDeleteError(Moment moment, DatabaseHelper db){
		moment.setIsDeleted(1);
		mh.updateMoment(moment, db);
	}
	
	public void deleteError(Moment moment, DatabaseHelper db){
		mh.deleteMoment(moment.getId(), db);
	}

}
