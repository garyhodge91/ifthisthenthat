package com.example.it3.util;

import android.os.Parcel;
import android.os.Parcelable;

public class Trigger implements Parcelable{
	private int id;
	private int triggerNumber;
	private int triggered;
	private String param1;
	private String param2;
	private String param3;
	private int momentId;
	
	public static final String KEY = "trigger";
	
	public static Trigger createTrigger(int triggerNumber){
		Trigger newTrigger = new Trigger();
		newTrigger.triggerNumber = triggerNumber;
		
		return newTrigger;
	}
	
	public Trigger loadTrigger(int id, int triggerNumber, String param1, String param2, String param3, int momentId){
		this.id = id;
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
		dest.writeInt(triggerNumber);
		dest.writeString(param1);
		dest.writeString(param2);
		dest.writeString(param3);
		dest.writeInt(momentId);
		
	}
	
	public Trigger readFromParcel(Parcel in){
		this.id = in.readInt();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTriggerNumber(int triggerNumber) {
		this.triggerNumber = triggerNumber;
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

	public int getTriggered() {
		return triggered;
	}

	public void setTriggered(int triggered) {
		this.triggered = triggered;
	}

}
