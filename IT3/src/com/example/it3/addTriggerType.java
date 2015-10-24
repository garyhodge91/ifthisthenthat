package com.example.it3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.example.it3.util.ImageAdapter;

public class addTriggerType extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_trigger_type);
		
		GridView gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new ImageAdapter(this));
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(addTriggerType.this, "" + position, Toast.LENGTH_SHORT).show();
	            Intent iAddTrigger = new Intent(addTriggerType.this, addTriggerDetail.class);
	            Bundle backpack = new Bundle();
	            backpack.putString("type", (String)v.getContentDescription());
	            iAddTrigger.putExtras(backpack);
				startActivityForResult(iAddTrigger, 0);
	        }
	    });
		
	}

}
