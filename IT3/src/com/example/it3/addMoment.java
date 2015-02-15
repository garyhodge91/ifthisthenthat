package com.example.it3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class addMoment extends Activity implements OnClickListener{
	
	Button addTrigger;
	Button addAction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.add_moment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        addTrigger = (Button)findViewById(R.id.addTrigger);
        addTrigger.setOnClickListener(this);
        
        addAction = (Button)findViewById(R.id.addAction);
        addAction.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.addTrigger:
			Intent iAddTrigger = new Intent(addMoment.this, addTrigger.class);
			startActivityForResult(iAddTrigger, 0);
			break;
		case R.id.addAction:
			Intent iAddAction = new Intent(addMoment.this, addAction.class);
			startActivityForResult(iAddAction, 0);
		
		}
		
	}

}
