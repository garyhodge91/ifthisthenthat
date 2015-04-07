package com.example.it3.databaseHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	
	private  static final String DATABASE_NAME = "it3";
	
	// Moments table
	private static final String TABLE_MOMENTS = "moments";
	private static final String KEY_NAME = "name";
	private static final String KEY_CREATE_DATE = "createdDate";
	private static final String KEY_ACTIVE = "active";
	private static final String KEY_LAST_RAN = "lastRan";
	private static final String KEY_LAST_MODIFIED = "lastModified";
	
	
	
	// Triggers table
	private static final String TABLE_TRIGGERS = "triggers";

	private static final String KEY_TRIGGER_DESCRIPTION = "triggerDescription";
	private static final String KEY_TRIGGER_NUMBER = "triggerNumber";
	
	
	
	
	// Actions table
	private static final String TABLE_ACTIONS = "actions";
	private static final String KEY_ACTION_DESCRIPTION = "actionDescription";
	private static final String KEY_ACTION_NUMBER = "actionNumber";
	
	
	// Errors table
	private static final String TABLE_ERRORS = "errors";
	private static final String KEY_ERROR_MESSAGE = "errorMessage";
	private static final String KEY_SEEN = "seen";
	
	
	// Common column names
	private static final String KEY_ID = "id";
	private static final String KEY_IS_DELETED = "isDeleted";
	private static final String KEY_MOMENT_ID = "momentId";
	private static final String KEY_APP_NAME = "appName";
	private static final String KEY_CATEGORY = "category";
	private static final String KEY_PARAM_1 = "param1";
	private static final String KEY_PARAM_2 = "param2";
	private static final String KEY_PARAM_3 = "param3";
	
	private static final String TAG = "DatabaseHelper";
	
	/*
	 * Moments Table
	 */
	private static final String CREATE_TABLE_MOMENTS = "CREATE TABLE " + TABLE_MOMENTS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_NAME +" TEXT, " + KEY_CREATE_DATE + " DATETIME, " + KEY_ACTIVE + " INTEGER, " + KEY_LAST_RAN + " DATETIME, " + KEY_LAST_MODIFIED + " DATETIME, " + KEY_IS_DELETED + " INTEGER)"; 
	
	/*
	 * Triggers Table
	 */
	private static final String CREATE_TABLE_TRIGGERS = "CREATE TABLE " + TABLE_TRIGGERS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_APP_NAME + " TEXT, " + KEY_CATEGORY + " TEXT, " 
			+ KEY_TRIGGER_DESCRIPTION + " TEXT, " + KEY_TRIGGER_NUMBER + " INTEGER, " + KEY_PARAM_1 + " TEXT, " + KEY_PARAM_2 + " TEXT, " + KEY_PARAM_3 + " TEXT, " + KEY_MOMENT_ID + " INTEGER, FOREIGN KEY(" + KEY_MOMENT_ID
			+ ") REFERENCES " + TABLE_MOMENTS+ "(" + KEY_ID + "))"; 
	
	/*
	 * Actions Table
	 */
	private static final String CREATE_TABLE_ACTIONS = "CREATE TABLE " + TABLE_ACTIONS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_APP_NAME + " TEXT, " + KEY_CATEGORY + " TEXT, " 
			+ KEY_ACTION_DESCRIPTION + " TEXT, " + KEY_ACTION_NUMBER + " INTEGER, " + KEY_PARAM_1 + " TEXT, " + KEY_PARAM_2 + " TEXT, " + KEY_PARAM_3 + " TEXT, " + KEY_MOMENT_ID + " INTEGER, FOREIGN KEY(" + KEY_MOMENT_ID
			+ ") REFERENCES " + TABLE_MOMENTS+ "(" + KEY_ID + "))"; 
	
	/*
	 * Errors Table
	 */
	private static final String CREATE_TABLE_ERRORS = "CREATE TABLE " + TABLE_ERRORS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_ERROR_MESSAGE + " TEXT, " + KEY_SEEN + " INTEGER," 
			+ KEY_IS_DELETED + " INTEGER, " + KEY_MOMENT_ID + " INTEGER, FOREIGN KEY(" + KEY_MOMENT_ID	+ ") REFERENCES " + TABLE_MOMENTS+ "(" + KEY_ID + "))";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(CREATE_TABLE_MOMENTS);
		Log.w(TAG, "Table created");
		db.execSQL(CREATE_TABLE_ACTIONS);
		db.execSQL(CREATE_TABLE_ERRORS);
		db.execSQL(CREATE_TABLE_TRIGGERS);
	}



	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_MOMENTS);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ACTIONS);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ERRORS);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_TRIGGERS);
		
		onCreate(db);
	}

}
