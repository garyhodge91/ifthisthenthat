package com.example.it3.databaseHelpers;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.it3.util.Trigger;

public class TriggerTableHelper {
	private static final String TABLE_TRIGGERS = "triggers";
	private static final String KEY_ID = "id";
	private static final String KEY_APP_NAME = "appName";
	private static final String KEY_CATEGORY = "category";
	private static final String KEY_TRIGGER_DESCRIPTION = "triggerDescription";
	private static final String KEY_TRIGGER_NUMBER = "triggerNumber";
	private static final String KEY_PARAM_1 = "param1";
	private static final String KEY_PARAM_2 = "param2";
	private static final String KEY_PARAM_3 = "param3";
	private static final String KEY_MOMENT_ID = "momentId";
	
	/*
	 * Create a new Trigger
	 */
	public long createTrigger(Trigger trigger, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_APP_NAME, trigger.getAppName());
		values.put(KEY_CATEGORY, trigger.getCategory());
		values.put(KEY_TRIGGER_DESCRIPTION, trigger.getTriggerDescription());
		values.put(KEY_TRIGGER_NUMBER, trigger.getTriggerNumber());
		values.put(KEY_PARAM_1, trigger.getParam1());
		values.put(KEY_PARAM_2, trigger.getParam2());
		values.put(KEY_PARAM_3, trigger.getParam3());
		values.put(KEY_MOMENT_ID, trigger.getMomentId());
		
		long trigger_id = database.insert(TABLE_TRIGGERS, null, values);
		
		return trigger_id;
	}
	
	/*
	 * Get a Trigger
	 */
	public Trigger getTrigger(long trigger_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM " + TABLE_TRIGGERS + " WHERE " + KEY_ID + " = " + trigger_id;
		
//		Log.e(LOG, selectQuery);
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			c.moveToFirst();
			Trigger trigger = new Trigger();
			trigger.loadTrigger(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_APP_NAME)), c.getString(c.getColumnIndex(KEY_CATEGORY)), c.getString(c.getColumnIndex(KEY_TRIGGER_DESCRIPTION)), c.getInt(c.getColumnIndex(KEY_TRIGGER_NUMBER)), c.getString(c.getColumnIndex(KEY_PARAM_1)), c.getString(c.getColumnIndex(KEY_PARAM_2)), c.getString(c.getColumnIndex(KEY_PARAM_3)), c.getInt(c.getColumnIndex(KEY_MOMENT_ID)));
			return trigger;
		}
		return null;
		
	}
	
	/*
	 * Get the triggers linked to a moment
	 */
	public List<Trigger> getTriggers(DatabaseHelper db,long moment_id){
		List<Trigger> triggers = new ArrayList<Trigger>();
		SQLiteDatabase database =  db.getReadableDatabase();
		
		
		String selectQuery = "SELECT * FROM " + TABLE_TRIGGERS + " WHERE " + KEY_MOMENT_ID + " = " + moment_id; 
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			for(int i = 0; i < c.getCount(); i++){
				c.move(i);
				Trigger trigger = new Trigger();
				trigger.loadTrigger(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_APP_NAME)), c.getString(c.getColumnIndex(KEY_CATEGORY)), c.getString(c.getColumnIndex(KEY_TRIGGER_DESCRIPTION)), c.getInt(c.getColumnIndex(KEY_TRIGGER_NUMBER)), c.getString(c.getColumnIndex(KEY_PARAM_1)), c.getString(c.getColumnIndex(KEY_PARAM_2)), c.getString(c.getColumnIndex(KEY_PARAM_3)), c.getInt(c.getColumnIndex(KEY_MOMENT_ID)));
				triggers.add(trigger);
				
			}
		}
		return triggers;
	}
	/*
	 * Update a Trigger
	 */
	public int updateTrigger(Trigger trigger, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_APP_NAME, trigger.getAppName());
		values.put(KEY_CATEGORY, trigger.getCategory());
		values.put(KEY_TRIGGER_DESCRIPTION, trigger.getTriggerDescription());
		values.put(KEY_TRIGGER_NUMBER, trigger.getTriggerNumber());
		values.put(KEY_PARAM_1, trigger.getParam1());
		values.put(KEY_PARAM_2, trigger.getParam2());
		values.put(KEY_PARAM_3, trigger.getParam3());
		values.put(KEY_MOMENT_ID, trigger.getMomentId());
		
		return database.update(TABLE_TRIGGERS, values, KEY_ID + "= ?", new String[] {String.valueOf(trigger.getId())});
	}
	/*
	 * Delete a Trigger
	 */
	public void deleteTrigger(long trigger_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		database.delete(TABLE_TRIGGERS, KEY_ID + " = ?", new String[] {String.valueOf(trigger_id)});
		
	}

}
