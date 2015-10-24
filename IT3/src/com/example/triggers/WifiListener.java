package com.example.triggers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import com.example.it3.databaseHelpers.DatabaseHelper;


public class WifiListener extends BroadcastReceiver{
	
	DatabaseHelper db;
	boolean triggered;
	Intent intent;
	AlarmManager am;
	PendingIntent sender;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		WifiManager manager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
		
		db = new DatabaseHelper(context);
        db.getWritableDatabase();
		
		if(manager.isWifiEnabled()){
			//Toast.makeText(context, "Wifi is enabled", Toast.LENGTH_LONG).show();
			triggered = true;
		} else {
			//Toast.makeText(context, "Wifi is not enabled " + manager.getWifiState(), Toast.LENGTH_LONG).show();
			triggered = true;
		}
		
		if(triggered){
			intent = new Intent(context, CheckTriggers.class);
			sender = PendingIntent.getBroadcast(context, 0, intent, 0);
			
			am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
			
			am.set(AlarmManager.RTC_WAKEUP, (System.currentTimeMillis() + 1000), sender);
			
		}
        
//        if(!previousState.equals(state.toString())){
//        	manager.i
//        	if(state == State.CONNECTED){
//        		Toast.makeText(context, "WifiListener: " + "we are " + state.toString(), Toast.LENGTH_LONG).show();
//        		SharedPreferencesUtil.putSharedPreferencesString(context, previousWifiState, state.toString());
//	        }else if(state == State.DISCONNECTED){
//	        	Toast.makeText(context, "WifiListener: " + "we are  " + state.toString(), Toast.LENGTH_LONG).show();
//	        	SharedPreferencesUtil.putSharedPreferencesString(context, previousWifiState, state.toString());
//	        }
//    }
	}
}
