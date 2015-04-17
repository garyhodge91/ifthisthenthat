package com.example.it3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.it3.util.Action;
import com.example.it3.util.createActions;

public class addAction extends Activity implements OnClickListener, OnItemSelectedListener{
	
	Spinner spinner;
	ArrayList actions, apps, actionDescriptions;
	
	LinearLayout actionsAppsList, actionDescriptionsList;
	
	String category;
	
	Action action;
	
	Button done;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.add_action);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        spinner = (Spinner)findViewById(R.id.actionCategorySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.action_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        
        actionsAppsList = (LinearLayout)findViewById(R.id.actionsAppsList);
        
        actionDescriptionsList = (LinearLayout)findViewById(R.id.actionDescriptions);
        
        actions = createActions.newActions();
        
        done = (Button)findViewById(R.id.actionsDone);
        done.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.actionsDone:
			Intent newAction = new Intent();
			Bundle backpack = new Bundle();
			backpack.putParcelable(Action.KEY, action);
			newAction.putExtras(backpack);
			setResult(RESULT_OK, newAction);
			finish();
			break;
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		category = (String) parent.getItemAtPosition(position);
		Integer size = actions.size();
		String text = "";
		apps = new ArrayList<String>();
		actionsAppsList.removeAllViews();
		actionDescriptionsList.removeAllViews();

		
		
		for(int i = 0; i < size; i++){
			Action action = (Action) actions.get(i);
			if(action.getCategory().equals(category)){
				actionsAppsList.addView(addAppImage(action.getAppName(), apps.size()));
				
			}
			}
		
//		Toast.makeText(this, text, Toast.LENGTH_LONG).show();


		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	View addAppImage(String appName, final int index){
		apps.add(appName);
		LinearLayout layout = new LinearLayout(getApplicationContext());
		layout.setLayoutParams(new LayoutParams(200, 200));
		layout.setGravity(Gravity.CENTER);
		
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setLayoutParams(new LayoutParams(180, 180));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setImageResource(R.drawable.facebook);
		imageView.setOnClickListener(new OnClickListener(){
			@Override
			   public void onClick(View v) {
				int size = actions.size();
				String appName = (String) apps.get(index);
				actionDescriptions = new ArrayList<String>();
				actionDescriptionsList.removeAllViews();
			    for(int i =0; i <size;i++){
			    	Action action = (Action) actions.get(i);
			    	if(action.getCategory().equals(category) && action.getAppName().equals(appName)){
			    		actionDescriptionsList.addView(addActionDescription(action.getActionDescription(), actionDescriptions.size()));
			    	}
			    }
			    
			    
			   }
			}
		);
		
		return imageView;
	}
	
	View addActionDescription(String actionDescription, final int index){
		actionDescriptions.add(actionDescription);
		LinearLayout layout = new LinearLayout(getApplicationContext());
		layout.setLayoutParams(new LayoutParams(200, 200));
		layout.setGravity(Gravity.CENTER);
		
		TextView textView = new TextView(getApplicationContext());
		textView.setLayoutParams(new LayoutParams(180, 180));
		textView.setText(actionDescription);
		textView.setOnClickListener(new OnClickListener(){
			@Override
			   public void onClick(View v) {
			    System.out.println("Clicked - " + actionDescriptions.get(index));
			    action = (Action) actions.get(index);
			    
			    
			   }
			}
		);
		
		return textView;
		
	}
}


