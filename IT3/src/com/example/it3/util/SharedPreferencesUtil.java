package com.example.it3.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtil {
	static String prefs = "it3";
	public static void putSharedPreferencesString(Context context, String key, String val){
        SharedPreferences preferences= context.getSharedPreferences(prefs, Context.MODE_MULTI_PROCESS);
        Editor edit=preferences.edit();
        edit.putString(key, val).commit(); // puts the preference into the SharedPreferences
    }
	
	public static String getSharedPreferencesString(Context context, String key, String _default){
		SharedPreferences preferences= context.getSharedPreferences(prefs, Context.MODE_MULTI_PROCESS);
        return preferences.getString(key, _default); // gets the preference from the SharedPreferences
    }
	
	public static void removeKey(Context context, String key){
		SharedPreferences preferences= context.getSharedPreferences(prefs, Context.MODE_MULTI_PROCESS);
        Editor edit=preferences.edit();
        edit.remove(key).commit(); // removed the preference from the SharedPreferences
	}

}
