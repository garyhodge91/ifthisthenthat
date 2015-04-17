package com.example.it3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.it3.databaseHelpers.*;
import com.example.it3.util.*;

public class addMoment extends Activity implements OnClickListener{
	
	Button addTrigger, addAction, confirm, cancel;
	
	DatabaseHelper db;
	MomentTableHelper mh;
	TriggerTableHelper th;
	ActionTableHelper ah;
	
	Moment moment;
	
	ArrayList actions, triggers;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.add_moment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        addTrigger = (Button)findViewById(R.id.addTrigger);
        addTrigger.setOnClickListener(this);
        
        addAction = (Button)findViewById(R.id.addAction);
        addAction.setOnClickListener(this);
        
        confirm = (Button)findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
        confirm.setEnabled(false);
        
        db = new DatabaseHelper(this);
        db.getWritableDatabase();
        
        mh = new MomentTableHelper();
        th = new TriggerTableHelper();
        ah = new ActionTableHelper();
        
        moment = new Moment();
        
        actions = new ArrayList<Action>();
        triggers = new ArrayList<Trigger>();
        
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.addTrigger:
			Intent iAddTrigger = new Intent(addMoment.this, addTrigger.class);
			startActivityForResult(iAddTrigger, 0);
			break;
		case R.id.addAction:
			Intent iAddAction = new Intent(addMoment.this, addAction.class);
			startActivityForResult(iAddAction, 1);
			break;
		case R.id.confirm:
			/*
			 * We are going to do the following
			 * 1. Save the moment to the database
			 * 2. Go through the list of triggers saving each one to the database
			 * 3. Go through the list of actions saving each one to the database
			 * 4. Finish the activity and go back to the home screen
			 */
			
			Moment newMoment = new Moment();
			newMoment.createMoment("test", 1, 0, "", "", "");
			long momentId = mh.createMoment(newMoment, db);
			System.out.println("Moment saved to database: " + momentId);
			
			for(int i = 0; i < triggers.size(); i++){
				Trigger newTrigger = (Trigger) triggers.get(i);
				newTrigger.setMomentId((int) momentId);
				long triggerId = th.createTrigger(newTrigger, db);
				System.out.println("Trigger saved to database: " + triggerId);
			}
			
			for(int i = 0; i < actions.size(); i++){
				Action newAction = (Action) actions.get(i);
				newAction.setMomentId((int) momentId);
				long actionId = ah.createAction(newAction, db);
				System.out.println("Action saved to database: " + actionId);
			}
			finish();
			
			
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle basket = data.getExtras();
			/*
			 * requestCode 0 will be used for Triggers
			 * 
			 * requestCode 1 will be used for Actions
			 */
			if(requestCode == 0){
				triggers.add(basket.getParcelable(Trigger.KEY));
				Toast.makeText(this, "Trigger added", Toast.LENGTH_SHORT).show();
				
			} else if(requestCode == 1){
				actions.add(basket.getParcelable(Action.KEY));
				Toast.makeText(this, "Action added " + ((Action) actions.get(0)).getAppName(), Toast.LENGTH_SHORT).show();
			}
			if(triggers.size() > 0 && actions.size() > 0){
				confirm.setEnabled(true);
			}
		}
	}

}
