package com.example.it3.databaseHelpers;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.it3.util.Trigger;
import com.example.it3.util.TriggerDef;


/*private static final String CREATE_TABLE_TRIGGER_DEF = "CREATE TABLE " + 
 * TABLE_TRIGGER_DEF + "(" 
 * + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
 * + KEY_CATEGORY + " TEXT, "
 * + KEY_DESCRIPTION + " TEXT, " 
 * + KEY_TYPE +  " TEXT
 * )"; 
 */
public class TriggerDefTableHelper {
	private static final String TABLE_TRIGGER_DEF = "triggerDef";
	private static final String KEY_ID = "id";
	private static final String KEY_CATEGORY = "category";
	private static final String KEY_DESCRIPTION = "description";
	private static final String KEY_TYPE = "type";
	
	/*
	 * Create a new Trigger
	 */
	public long createTriggerDef(TriggerDef triggerDef, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_CATEGORY, triggerDef.getCategory());
		values.put(KEY_DESCRIPTION, triggerDef.getDescription());
		values.put(KEY_TYPE, triggerDef.getType());
		
		long trigger_id = database.insert(TABLE_TRIGGER_DEF, null, values);
		
		return trigger_id;
	}
	
	/*
	 * Get a Trigger
	 */
	public TriggerDef getTriggerDef(long trigger_def_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM " + TABLE_TRIGGER_DEF + " WHERE " + KEY_ID + " = " + trigger_def_id;
		
//		Log.e(LOG, selectQuery);
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			c.moveToFirst();
			TriggerDef triggerDef = new TriggerDef();
			triggerDef.loadTriggerDef(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_CATEGORY)), c.getString(c.getColumnIndex(KEY_DESCRIPTION)), c.getString(c.getColumnIndex(KEY_TYPE)));
			return triggerDef;
		}
		return null;
		
	}
	
	/*
	 * Get the triggers linked to a moment
	 */
	public ArrayList<TriggerDef> getByType(DatabaseHelper db,String type){
		ArrayList<TriggerDef> triggerDefs = new ArrayList<TriggerDef>();
		SQLiteDatabase database =  db.getReadableDatabase();
		
		
		String selectQuery = "SELECT * FROM " + TABLE_TRIGGER_DEF + " WHERE " + KEY_TYPE + " = '" + type + "'" ; 
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			for(int i = 0; i < c.getCount(); i++){
				c.moveToPosition(i);
				TriggerDef triggerDef = new TriggerDef();
				triggerDef.loadTriggerDef(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_CATEGORY)), c.getString(c.getColumnIndex(KEY_DESCRIPTION)), c.getString(c.getColumnIndex(KEY_TYPE)));
				triggerDefs.add(triggerDef);
				
			}
		}
		return triggerDefs;
	}
	/*
	 * Update a Trigger
	 */
	public int updateTrigger(TriggerDef triggerDef, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_CATEGORY, triggerDef.getCategory());
		values.put(KEY_DESCRIPTION, triggerDef.getDescription());
		values.put(KEY_TYPE, triggerDef.getType());
		
		return database.update(TABLE_TRIGGER_DEF, values, KEY_ID + "= ?", new String[] {String.valueOf(triggerDef.getId())});
	}
	/*
	 * Delete a Trigger
	 */
	public void deleteTrigger(long trigger_def_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		database.delete(TABLE_TRIGGER_DEF, KEY_ID + " = ?", new String[] {String.valueOf(trigger_def_id)});
		
	}

}
