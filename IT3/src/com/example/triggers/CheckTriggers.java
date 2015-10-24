package com.example.triggers;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.example.it3.databaseHelpers.*;
import com.example.it3.util.*;

public class CheckTriggers extends BroadcastReceiver{
	
	DatabaseHelper dbHelper;
	MomentTableHelper mHelper;
	TriggerTableHelper tHelper;
	ActionTableHelper aHelper;
	
	List<Moment> moments;

	@Override
	public void onReceive(Context context, Intent intent) {
		
		dbHelper = new DatabaseHelper(context);
		mHelper = new MomentTableHelper();
		tHelper = new TriggerTableHelper();
		aHelper = new ActionTableHelper();
		
		moments = mHelper.getMoments(dbHelper, "1", "0", "");
		
		int momentsCount = moments.size();
		
		for(int i = 0; i < momentsCount; i++){
			Moment moment = moments.get(i);
			List<Trigger> triggers = tHelper.getTriggers(dbHelper, moment.getId());
			List<Action> actions = aHelper.getActions(dbHelper, moment.getId());
			int totalTriggers = triggers.size();
			
			for(int j = 0; j < totalTriggers; j++){
				Trigger trigger = triggers.get(j);
				
			}
			
		}
		// TODO Auto-generated method stub
		Toast.makeText(context, "We have " + momentsCount + " moments in the database.", Toast.LENGTH_LONG).show();
		
	}

}