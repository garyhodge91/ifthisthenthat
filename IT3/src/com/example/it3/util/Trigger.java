package com.example.it3.util;

import android.os.Parcel;
import android.os.Parcelable;

public class Trigger implements Parcelable{
	private int id;
	private String appName;
	private String category;
	private String triggerDescription;
	private int triggerNumber;
	private String param1;
	private String param2;
	private String param3;
	private int momentId;
	
	public static final String KEY = "trigger";
	
	public static Trigger createTrigger(String category, String appName, String actionDescription, int actionNumber){
		Trigger newTrigger = new Trigger();
		newTrigger.category = category;
		newTrigger.appName = appName;
		newTrigger.triggerDescription = actionDescription;
		newTrigger.triggerNumber = actionNumber;
		
		return newTrigger;
	}
	
	public Trigger loadTrigger(int id, String appName, String category,  String triggerDescription, int triggerNumber, String param1, String param2, String param3, int momentId){
		this.id = id;
		this.appName = appName;
		this.category = category;
		this.triggerDescription = triggerDescription;
		this.triggerNumber = triggerNumber;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.momentId = momentId;
		
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
		dest.writeString(appName);
		dest.writeString(category);
		dest.writeString(triggerDescription);
		dest.writeInt(triggerNumber);
		dest.writeString(param1);
		dest.writeString(param2);
		dest.writeString(param3);
		dest.writeInt(momentId);
		
	}
	
	public Trigger readFromParcel(Parcel in){
		this.id = in.readInt();
		this.appName = in.readString();
		this.category = in.readString();
		this.triggerDescription = in.readString();
		this.triggerNumber = in.readInt();
		this.param1 = in.readString();
		this.param2 = in.readString();
		this.param3 = in.readString();
		this.momentId = in.readInt();
		
		return this;
	}
	
	public static final Parcelable.Creator<Trigger> CREATOR = new Parcelable.Creator<Trigger>() {

		@Override
		public Trigger createFromParcel(Parcel in) {
			Trigger trigger = new Trigger();
			return trigger.readFromParcel(in);
		}

		@Override
		public Trigger[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Trigger[size];
		}
	};
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setTriggerDescription(String triggerDescription) {
		this.triggerDescription = triggerDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTriggerNumber(int triggerNumber) {
		this.triggerNumber = triggerNumber;
	}

	public String getAppName() {
		return appName;
	}
	public String getTriggerDescription() {
		return triggerDescription;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public int getMomentId() {
		return momentId;
	}

	public void setMomentId(int momentId) {
		this.momentId = momentId;
	}

	public int getTriggerNumber() {
		return triggerNumber;
	}

}
