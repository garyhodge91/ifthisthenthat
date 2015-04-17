package com.example.it3.util;

import android.os.Parcel;
import android.os.Parcelable;

public class Moment implements Parcelable{
	private int id;
	private String name;
	private int isActive;
	private int isDeleted;
	private String createDate;
	private String lastRan;
	private String lastModified;
	
	public Moment createMoment (String name, int isActive, int isDeleted, String createDate, String lastRan, String lastModified){
		this.name = name;
		this.createDate = createDate;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.createDate = createDate;
		this.lastRan = lastRan;
		this.lastModified = lastModified;
		
		return this;
	}
	
	public Moment loadMoment (int id, String name, int isActive, int isDeleted, String createDate, String lastRan, String lastModified){
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.createDate = createDate;
		this.lastRan = lastRan;
		this.lastModified = lastModified;
		
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
		dest.writeString(name);
		dest.writeInt(isActive);
		dest.writeInt(isDeleted);
		dest.writeString(createDate);
		dest.writeString(lastRan);
		dest.writeString(lastModified);
		
	}
	
	public Moment readFromParcel(Parcel in){
		this.id = in.readInt();
		this.name = in.readString();
		this.isActive = in.readInt();
		this.isDeleted = in.readInt();
		this.createDate = in.readString();
		this.lastRan = in.readString();
		this.lastModified = in.readString();
		
		return this;
	}
	
	public static final Parcelable.Creator<Moment> CREATOR = new Parcelable.Creator<Moment>() {

		@Override
		public Moment createFromParcel(Parcel in) {
			Moment moment = new Moment();
			return moment.readFromParcel(in);
		}

		@Override
		public Moment[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Moment[size];
		}
	};
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastRan() {
		return lastRan;
	}

	public void setLastRan(String lastRan) {
		this.lastRan = lastRan;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}


}
