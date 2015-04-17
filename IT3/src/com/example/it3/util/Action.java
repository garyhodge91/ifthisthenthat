package com.example.it3.util;

import android.os.Parcel;
import android.os.Parcelable;

public class Action implements Parcelable{
	private int id;
	private String category;
	private String appName;
	private String actionDescription;
	private int actionNumber;
	private String param1;
	private String param2;
	private String param3;
	private int momentId;
	
	public static final String KEY = "action";
	
	public static Action createAction(String category, String appName, String actionDescription, int actionNumber){
		Action newAction = new Action();
		newAction.category = category;
		newAction.appName = appName;
		newAction.actionDescription = actionDescription;
		newAction.actionNumber = actionNumber;
		
		return newAction;
	}
	
	public static Action loadAction(int id, String appName, String category,  String actionDescription, int actionNumber, String param1, String param2, String param3, int momentId){
		Action action = new Action();
		
		action.id = id;
		action.appName = appName;
		action.category = category;
		action.actionDescription = actionDescription;
		action.actionNumber = actionNumber;
		action.param1 = param1;
		action.param2 = param2;
		action.param3 = param3;
		action.momentId = momentId;
		
		return action;
		
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
		dest.writeString(actionDescription);
		dest.writeInt(actionNumber);
		dest.writeString(param1);
		dest.writeString(param2);
		dest.writeString(param3);
		dest.writeInt(momentId);
		
	}
	
	public Action readFromParcel(Parcel in){
		this.id = in.readInt();
		this.appName = in.readString();
		this.category = in.readString();
		this.actionDescription = in.readString();
		this.actionNumber = in.readInt();
		this.param1 = in.readString();
		this.param2 = in.readString();
		this.param3 = in.readString();
		this.momentId = in.readInt();
		
		return this;
	}
	
	public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() {

		@Override
		public Action createFromParcel(Parcel in) {
			Action action = new Action();
			return action.readFromParcel(in);
		}

		@Override
		public Action[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Action[size];
		}
	};
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

	public void setActionNumber(int actionNumber) {
		this.actionNumber = actionNumber;
	}

	public String getCategory() {
		return category;
	}
	public String getAppName() {
		return appName;
	}
	public String getActionDescription() {
		return actionDescription;
	}
	public int getActionNumber(){
		return actionNumber;
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
}
