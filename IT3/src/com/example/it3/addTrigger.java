package com.example.it3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.it3.util.*;

public class addTrigger extends Activity implements OnClickListener, OnItemSelectedListener{
	
	Spinner spinner;
	ArrayList triggers;
	
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
        
        triggers = createTriggers.newTriggers();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		String category = (String) parent.getItemAtPosition(position);
		Integer size = triggers.size();
		String text = "";
		
		for(int i = 0; i < size; i++){
			Trigger trigger = (Trigger) triggers.get(i);
			if(trigger.getCategory().equals(category)){
				text = text + " " + trigger.getAppName();
			}	
		}
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
