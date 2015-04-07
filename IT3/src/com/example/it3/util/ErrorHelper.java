package com.example.it3.util;

import com.example.it3.databaseHelpers.*;

public class ErrorHelper {

	ErrorTableHelper eh = new ErrorTableHelper();;
	
	public long createError(Error error, DatabaseHelper db){
		return eh.createError(error, db);
	}
	
	public void markErrorAsSeen(Error error, DatabaseHelper db){
		error.setSeen(1);
		eh.updateError(error, db);
	}
	
	public void softDeleteError(Error error, DatabaseHelper db){
		error.setIsDeleted(1);
		eh.updateError(error, db);
	}
	
	public void deleteError(Error error, DatabaseHelper db){
		eh.deleteError(error.getId(), db);
	}
	
}
