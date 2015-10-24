package com.example.it3;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.example.it3.databaseHelpers.DatabaseHelper;
import com.example.it3.databaseHelpers.MomentTableHelper;
import com.example.it3.util.Moment;
import com.example.it3.util.SystemUiHider;
import com.example.it3.util.createTriggers;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class MainActivity extends ListActivity implements OnClickListener {    
    ListView list;
    Button addMoment;
    
    DatabaseHelper db;
    MomentTableHelper mh;
    
    ArrayList<Moment> moments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        addMoment = (Button) findViewById(R.id.addMoment);
        addMoment.setOnClickListener(this);
        
        db = new DatabaseHelper(this);
        db.getWritableDatabase();
        
        mh = new MomentTableHelper();
        
        moments = (ArrayList<Moment>) mh.getMoments(db, "1", "0", "");
        
        
        
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
          // <---- run your one time code here
        	System.out.println("adding new triggers");
        	createTriggers.newTriggerDefs(db);

          // mark first time has runned.
          SharedPreferences.Editor editor = prefs.edit();
//          editor.putBoolean("firstTime", true);
          editor.commit();
        }else{
        	System.out.println("not adding new triggers");	
        }

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this, addMoment.class);
		startActivityForResult(intent, 0);
		
	}
}
