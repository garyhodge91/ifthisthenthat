package com.example.it3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.it3.databaseHelpers.DatabaseHelper;
import com.example.it3.databaseHelpers.TriggerDefTableHelper;
import com.example.it3.util.TriggerDef;

public class addTriggerDetail extends Activity{
ArrayList<TriggerDef> triggerDefs;
	
	DatabaseHelper db;
	TriggerDefTableHelper tdh;
	
	LinearLayout triggerDescriptionList, dropzone;
	
	String type;
	
	TextView drag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.add_trigger_detail);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		Intent intent = getIntent();
		
		type = intent.getStringExtra("type");
		
		db = new DatabaseHelper(this);
		db.getWritableDatabase();
		
		tdh = new TriggerDefTableHelper();
		
		triggerDefs = tdh.getByType(db, type);
		
		triggerDescriptionList = (LinearLayout)findViewById(R.id.toplinear);
		triggerDescriptionList.setOnDragListener(new MyDragListener());
		dropzone = (LinearLayout)findViewById(R.id.bottomlinear);
		dropzone.setOnDragListener(new MyDragListener());
		
		
//		triggerDescriptionList.removeAllViews();
		for(int i = 0; i < triggerDefs.size(); i++){
			triggerDescriptionList.addView(addTriggerDescription(triggerDefs.get(i).getDescription(), i));
		}
	}
	
	View addTriggerDescription(String triggerDefDescription, final int index){
		LinearLayout layout = new LinearLayout(getApplicationContext());
		layout.setLayoutParams(new LayoutParams(200, 200));
		layout.setGravity(Gravity.CENTER);
		
		TextView textView = new TextView(getApplicationContext());
		textView.setLayoutParams(new LayoutParams(180, 180));
		textView.setText(triggerDefDescription);
		textView.setTextColor(Color.BLACK);
		textView.setOnLongClickListener(new MyClickListener());
		return textView;
	}
	
	private final class MyClickListener implements OnLongClickListener {
		// called when the item is long-clicked
		@Override
		public boolean onLongClick(View view) {
			ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadow = new View.DragShadowBuilder(view);
            view.startDrag(data, shadow, view, 0);
//            dropzone.setBackgroundDrawable(R.drawable.dashed);
            return false;

		}
	}




	class MyDragListener implements OnDragListener {
		@Override
		public boolean onDrag(View v, DragEvent event) {



		    // Handles each of the expected events

		    switch (event.getAction()) {

		     

		    //signal for the start of a drag and drop operation.

		    case DragEvent.ACTION_DRAG_STARTED:

		        // do nothing

		        break;

		         

		    //the drag point has entered the bounding box of the View

		    case DragEvent.ACTION_DRAG_ENTERED:

		        break;

		         

		    //the user has moved the drag shadow outside the bounding box of the View

		    case DragEvent.ACTION_DRAG_EXITED:

		        break;

		         

		    //drag shadow has been released,the drag point is within the bounding box of the View

		    case DragEvent.ACTION_DROP:

		        // if the view is the bottomlinear, we accept the drag item

		          if(v == findViewById(R.id.bottomlinear)) {
		        	  
		        	  View view = (View) event.getLocalState();

		              ViewGroup viewgroup = (ViewGroup) view.getParent();

		              viewgroup.removeView(view);

		         

		              //change the text

		            

		              LinearLayout containView = (LinearLayout) v;

		              containView.addView(view);

		              view.setVisibility(View.VISIBLE);

		          } else {

		              View view = (View) event.getLocalState();

		              view.setVisibility(View.VISIBLE);

		              Context context = getApplicationContext();

		              Toast.makeText(context, "You can't drop the image here",

		                                         Toast.LENGTH_LONG).show();

		              break;

		           }

		          break;

		           

		    //the drag and drop operation has concluded.

		    case DragEvent.ACTION_DRAG_ENDED:

		    default:

		        break;

		    }

		    return true;

		}
	}
}
