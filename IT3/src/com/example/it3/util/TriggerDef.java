package com.example.it3.util;

import android.os.Parcel;
import android.os.Parcelable;


/*private static final String CREATE_TABLE_TRIGGER_DEF = "CREATE TABLE " + 
 * TABLE_TRIGGER_DEF + "(" 
 * + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
 * + KEY_CATEGORY + " TEXT, "
 * + KEY_DESCRIPTION + " TEXT, " 
 * + KEY_TYPE +  " TEXT
 * )"; 
 */
public class TriggerDef implements Parcelable{
	
	private int id;
	private String category;
	private String description;
	private String type;
	
	public static TriggerDef createTriggerDef(String category, String description, String type){
		TriggerDef newTriggerDef = new TriggerDef();
		newTriggerDef.category = category;
		newTriggerDef.description = description;
		newTriggerDef.type = type;
		
		return newTriggerDef;
	}
	
	public TriggerDef loadTriggerDef(int id, String category, String description, String type){
		this.id = id;
		this.category = category;
		this.description = description;
		this.type = type;
		
		return this;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(id);
		dest.writeString(category);
		dest.writeString(description);
		dest.writeString(type);
		
	}
	
	public TriggerDef readFromParcel(Parcel in){
		this.id = in.readInt();
		this.category = in.readString();
		this.description = in.readString();
		this.type = in.readString();
		
		return this;
	}
	
	public static final Parcelable.Creator<TriggerDef> CREATOR = new Parcelable.Creator<TriggerDef>() {

		@Override
		public TriggerDef createFromParcel(Parcel in) {
			TriggerDef triggerDef = new TriggerDef();
			return triggerDef.readFromParcel(in);
		}

		@Override
		public TriggerDef[] newArray(int size) {
			// TODO Auto-generated method stub
			return new TriggerDef[size];
		}
	};
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
