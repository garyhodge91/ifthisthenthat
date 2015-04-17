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
import android.widget.Toast;

import com.example.it3.util.Trigger;
import com.example.it3.util.createTriggers;

public class addTrigger extends Activity implements OnClickListener, OnItemSelectedListener{
	
	// For multiple triggers add a customisable time delay max say 10 seconds.
	
	Spinner spinner;
	ArrayList triggers, apps, triggerDescriptions;
	
	LinearLayout triggerAppsList, triggerDescriptionList;
	
	Trigger trigger;
	
	Button done;
	
	String category;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.add_trigger);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        spinner = (Spinner)findViewById(R.id.triggerCategorySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.trigger_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        
        triggerAppsList = (LinearLayout) findViewById(R.id.triggerAppsList);
        
        triggerDescriptionList = (LinearLayout)findViewById(R.id.triggerDescriptions);
        
        triggers = createTriggers.newTriggers();
        
        done = (Button)findViewById(R.id.triggersDone);
        done.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.triggersDone:
			Intent newTrigger = new Intent();
			Bundle backpack = new Bundle();
			backpack.putParcelable(Trigger.KEY, trigger);
			newTrigger.putExtras(backpack);
			setResult(RESULT_OK, newTrigger);
			finish();
			break;
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		category = (String) parent.getItemAtPosition(position);
		Integer size = triggers.size();
		String text = "";
		
		apps = new ArrayList<String>();
		triggerAppsList.removeAllViews();
		triggerDescriptionList.removeAllViews();
		
		for(int i = 0; i < size; i++){
			Trigger trigger = (Trigger) triggers.get(i);
			if(trigger.getCategory().equals(category)){
				triggerAppsList.addView(addAppImage(trigger.getAppName(), apps.size()));
			}	
		}
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	View addAppImage(String appName, final int index){
		apps.add(appName);
		LinearLayout layout = new LinearLayout(getApplicationContext());
		layout.setLayoutParams(new LayoutParams(200,200));
		layout.setGravity(Gravity.CENTER);
		
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setLayoutParams(new LayoutParams(180,180));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		int resId = getResources().getIdentifier(appName.toLowerCase(), "drawable", getPackageName());
		System.out.println("appName: " + appName + " resId: " + resId);
		imageView.setImageResource(resId);
		imageView.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				int size = triggers.size();
				String appName = (String) apps.get(index);
				triggerDescriptions  = new ArrayList<String>();
				triggerDescriptionList.removeAllViews();
				for(int i = 0; i < size; i++){
					Trigger trigger = (Trigger) triggers.get(i);
					if(trigger.getCategory().equals(category) && trigger.getAppName().equals(appName))
						triggerDescriptionList.addView(addTriggerDescription(trigger.getTriggerDescription(), triggerDescriptions.size()));
				}
				
			}
		});
		
		return imageView;
	}
	
	View addTriggerDescription(String triggerDescription, final int index){
		triggerDescriptions.add(triggerDescription);
		LinearLayout layout = new LinearLayout(getApplicationContext());
		layout.setLayoutParams(new LayoutParams(200, 200));
		layout.setGravity(Gravity.CENTER);
		
		TextView textView = new TextView(getApplicationContext());
		textView.setLayoutParams(new LayoutParams(180, 180));
		textView.setText(triggerDescription);
		textView.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				System.out.println("Clicked - " + triggerDescriptions.get(index));
				trigger = (Trigger) triggers.get(index);				
			}
		});
		return textView;
	}

}
