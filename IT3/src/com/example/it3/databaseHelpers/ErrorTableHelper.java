package com.example.it3.databaseHelpers;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.it3.util.Error;

public class ErrorTableHelper {
	private static final String TABLE_ERRORS = "errors";
	private static final String KEY_ID = "id";
	private static final String KEY_ERROR_MESSAGE = "errorMessage";
	private static final String KEY_SEEN = "seen";
	private static final String KEY_IS_DELETED = "isDeleted";
	private static final String KEY_MOMENT_ID = "momentId";
	
	/*
	 * Create a new Error
	 */
	public long createError(Error error, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_ERROR_MESSAGE, error.getErrorMessage());
		values.put(KEY_SEEN, error.getSeen());
		values.put(KEY_IS_DELETED, error.getIsDeleted());
		values.put(KEY_MOMENT_ID, error.getMomentId());
		
		long error_id = database.insert(TABLE_ERRORS, null, values);
		
		return error_id;
	}
	
	/*
	 * Get a Error
	 */
	public Error getError(long error_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM " + TABLE_ERRORS + " WHERE " + KEY_ID + " = " + error_id;
		
//		Log.e(LOG, selectQuery);
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			c.moveToFirst();
			Error error = new Error();
			error.createError(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_ERROR_MESSAGE)), c.getInt(c.getColumnIndex(KEY_SEEN)), c.getInt(c.getColumnIndex(KEY_IS_DELETED)), c.getInt(c.getColumnIndex(KEY_MOMENT_ID)));
			return error;
		}
		return null;
		
	}
	
	/*
	 * Get the errors linked to a moment
	 */
	public List<Error> getErrors(DatabaseHelper db,long moment_id){
		List<Error> errors = new ArrayList<Error>();
		SQLiteDatabase database =  db.getReadableDatabase();
		
		
		String selectQuery = "SELECT * FROM " + TABLE_ERRORS + " WHERE " + KEY_MOMENT_ID + " = " + moment_id; 
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			for(int i = 0; i < c.getCount(); i++){
				c.move(i);
				Error error = new Error();
				error.createError(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_ERROR_MESSAGE)), c.getInt(c.getColumnIndex(KEY_SEEN)), c.getInt(c.getColumnIndex(KEY_IS_DELETED)), c.getInt(c.getColumnIndex(KEY_MOMENT_ID)));
				errors.add(error);
				
			}
		}
		return errors;
	}
	/*
	 * Update a Error
	 */
	public int updateError(Error error, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_ERROR_MESSAGE, error.getErrorMessage());
		values.put(KEY_SEEN, error.getSeen());
		values.put(KEY_IS_DELETED, error.getIsDeleted());
		values.put(KEY_MOMENT_ID, error.getMomentId());
		
		return database.update(TABLE_ERRORS, values, KEY_ID + "= ?", new String[] {String.valueOf(error.getId())});
	}
	/*
	 * Delete a Error
	 */
	public void deleteError(long error_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		database.delete(TABLE_ERRORS, KEY_ID + " = ?", new String[] {String.valueOf(error_id)});
		
	}

}
