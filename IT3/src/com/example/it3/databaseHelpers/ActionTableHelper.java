package com.example.it3.databaseHelpers;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.it3.util.Action;

public class ActionTableHelper {
	private static final String TABLE_ACTIONS = "actions";
	private static final String KEY_ID = "id";
	private static final String KEY_APP_NAME = "appName";
	private static final String KEY_CATEGORY = "category";
	private static final String KEY_ACTION_DESCRIPTION = "actionDescription";
	private static final String KEY_ACTION_NUMBER = "actionNumber";
	private static final String KEY_PARAM_1 = "param1";
	private static final String KEY_PARAM_2 = "param2";
	private static final String KEY_PARAM_3 = "param3";
	private static final String KEY_MOMENT_ID = "momentId";
	
	/*
	 * Create a new Action
	 */
	public long createAction(Action action, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_APP_NAME, action.getAppName());
		values.put(KEY_CATEGORY, action.getCategory());
		values.put(KEY_ACTION_DESCRIPTION, action.getActionDescription());
		values.put(KEY_ACTION_NUMBER, action.getActionNumber());
		values.put(KEY_PARAM_1, action.getParam1());
		values.put(KEY_PARAM_2, action.getParam2());
		values.put(KEY_PARAM_3, action.getParam3());
		values.put(KEY_MOMENT_ID, action.getMomentId());
		
		long action_id = database.insert(TABLE_ACTIONS, null, values);
		
		return action_id;
	}
	
	/*
	 * Get a Action
	 */
	public Action getAction(long action_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM " + TABLE_ACTIONS + " WHERE " + KEY_ID + " = " + action_id;
		
//		Log.e(LOG, selectQuery);
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			c.moveToFirst();
			Action action = new Action();
			action.createAction(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_APP_NAME)), c.getString(c.getColumnIndex(KEY_CATEGORY)), c.getString(c.getColumnIndex(KEY_ACTION_DESCRIPTION)), c.getInt(c.getColumnIndex(KEY_ACTION_NUMBER)), c.getString(c.getColumnIndex(KEY_PARAM_1)), c.getString(c.getColumnIndex(KEY_PARAM_2)), c.getString(c.getColumnIndex(KEY_PARAM_3)), c.getInt(c.getColumnIndex(KEY_MOMENT_ID)));
			return action;
		}
		return null;
		
	}
	
	/*
	 * Get the actions linked to a moment
	 */
	public List<Action> getActions(DatabaseHelper db,long moment_id){
		List<Action> actions = new ArrayList<Action>();
		SQLiteDatabase database =  db.getReadableDatabase();
		
		
		String selectQuery = "SELECT * FROM " + TABLE_ACTIONS + " WHERE " + KEY_MOMENT_ID + " = " + moment_id; 
		
		Cursor c = database.rawQuery(selectQuery, null);
		
		if(c != null){
			for(int i = 0; i < c.getCount(); i++){
				c.move(i);
				Action action = new Action();
				action.createAction(c.getInt(c.getColumnIndex(KEY_ID)), c.getString(c.getColumnIndex(KEY_APP_NAME)), c.getString(c.getColumnIndex(KEY_CATEGORY)), c.getString(c.getColumnIndex(KEY_ACTION_DESCRIPTION)), c.getInt(c.getColumnIndex(KEY_ACTION_NUMBER)), c.getString(c.getColumnIndex(KEY_PARAM_1)), c.getString(c.getColumnIndex(KEY_PARAM_2)), c.getString(c.getColumnIndex(KEY_PARAM_3)), c.getInt(c.getColumnIndex(KEY_MOMENT_ID)));
				actions.add(action);
				
			}
		}
		return actions;
	}
	/*
	 * Update a Action
	 */
	public int updateAction(Action action, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_APP_NAME, action.getAppName());
		values.put(KEY_CATEGORY, action.getCategory());
		values.put(KEY_ACTION_DESCRIPTION, action.getActionDescription());
		values.put(KEY_ACTION_NUMBER, action.getActionNumber());
		values.put(KEY_PARAM_1, action.getParam1());
		values.put(KEY_PARAM_2, action.getParam2());
		values.put(KEY_PARAM_3, action.getParam3());
		values.put(KEY_MOMENT_ID, action.getMomentId());
		
		return database.update(TABLE_ACTIONS, values, KEY_ID + "= ?", new String[] {String.valueOf(action.getId())});
	}
	/*
	 * Delete a Action
	 */
	public void deleteAction(long action_id, DatabaseHelper db){
		SQLiteDatabase database =  db.getReadableDatabase();
		
		database.delete(TABLE_ACTIONS, KEY_ID + " = ?", new String[] {String.valueOf(action_id)});
		
	}

}
