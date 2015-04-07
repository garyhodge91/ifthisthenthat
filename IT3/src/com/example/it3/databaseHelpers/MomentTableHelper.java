package com.example.it3.databaseHelpers;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.it3.util.Moment;

public class MomentTableHelper {
	
	private static final String TABLE_NAME = "moments";
	private static final String KEY_NAME = "name";
	private static final String KEY_CREATE_DATE = "createdDate";
	private static final String KEY_ACTIVE = "active";
	private static final String KEY_LAST_RAN = "lastRan";
	private static final String KEY_LAST_MODIFIED = "lastModified";
	private static final String KEY_ID = "id";
	private static final String KEY_IS_DELETED = "isDeleted";
	
	public long createMoment(Moment moment, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, moment.getName());
		values.put(KEY_CREATE_DATE, moment.getCreateDate());
		values.put(KEY_IS_DELETED, moment.getIsDeleted());
		values.put(KEY_LAST_MODIFIED, moment.getLastModified());
		values.put(KEY_LAST_RAN, moment.getLastRan());
		values.put(KEY_ACTIVE, moment.getIsActive());
		
		long moment_id = database.insert(TABLE_NAME, null, values);
		
		return moment_id;
	}
	
	public Moment getMoment(long moment_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + " = " + moment_id;
		
//		Log.e(LOG, selectQuery);
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			c.moveToFirst();
			Moment moment = new Moment();
			moment.createMoment(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_NAME)), c.getInt(c.getColumnIndex(KEY_ACTIVE)), c.getInt(c.getColumnIndex(KEY_IS_DELETED)), c.getString(c.getColumnIndex(KEY_CREATE_DATE)), c.getString(c.getColumnIndex(KEY_LAST_RAN)), c.getString(c.getColumnIndex(KEY_LAST_MODIFIED)));
			return moment;
		}
		return null;
		
	}
	
	public List<Moment> getMoments(DatabaseHelper db, String isActive, String isDeleted, String orderBy){
		List<Moment> moments = new ArrayList<Moment>();
		SQLiteDatabase database =  db.getReadableDatabase();
		String whereClause = "";
		
		if(isActive != null || isDeleted != null){
			whereClause = "WHERE ";
			if(isActive != null){
				whereClause += KEY_ACTIVE + " = " + isActive; 
			} else {
				whereClause += KEY_IS_DELETED + " = " + isDeleted;
			}
			
		}
		
		String selectQuery = "SELECT * FROM " + TABLE_NAME + " " + whereClause; 
		
		if(orderBy != null){
			selectQuery += " " + orderBy;
		}
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			for(int i = 0; i < c.getCount(); i++){
				c.move(i);
				Moment moment = new Moment();
				moment.createMoment(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_NAME)), c.getInt(c.getColumnIndex(KEY_ACTIVE)), c.getInt(c.getColumnIndex(KEY_IS_DELETED)), c.getString(c.getColumnIndex(KEY_CREATE_DATE)), c.getString(c.getColumnIndex(KEY_LAST_RAN)), c.getString(c.getColumnIndex(KEY_LAST_MODIFIED)));
				
				moments.add(moment);
				
			}
		}
		return moments;
	}
	
	public int updateMoment(Moment moment, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, moment.getName());
		values.put(KEY_CREATE_DATE, moment.getCreateDate());
		values.put(KEY_IS_DELETED, moment.getIsDeleted());
		values.put(KEY_LAST_MODIFIED, moment.getLastModified());
		values.put(KEY_LAST_RAN, moment.getLastRan());
		values.put(KEY_ACTIVE, moment.getIsActive());
		
		return database.update(TABLE_NAME, values, KEY_ID + "= ?", new String[] {String.valueOf(moment.getId())});
	}
	
	public void deleteMoment(long moment_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		database.delete(TABLE_NAME, KEY_ID + " = ?", new String[] {String.valueOf(moment_id)});
		
	}

}
