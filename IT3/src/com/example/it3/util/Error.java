package com.example.it3.util;

import android.os.Parcel;
import android.os.Parcelable;

public class Error implements Parcelable{
	private int id;
	private String errorMessage;
	private int seen;
	private int isDeleted;
	private int momentId;
	
	public Error createError(int id, String errorMessage, int seen, int isDeleted, int momentId){
		this.id = id;
		this.errorMessage = errorMessage;
		this.seen = seen;
		this.isDeleted = isDeleted;
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
		dest.writeString(errorMessage);
		dest.writeInt(seen);
		dest.writeInt(isDeleted);
		dest.writeInt(momentId);
		
	}
	
	public Error readFromParcel(Parcel in){
		this.id = in.readInt();
		this.errorMessage = in.readString();
		this.seen = in.readInt();
		this.isDeleted = in.readInt();
		this.momentId = in.readInt();
		
		return this;
	}
	
	static final Parcelable.Creator<Error> CREATOR = new Parcelable.Creator<Error>() {

		@Override
		public Error createFromParcel(Parcel in) {
			Error error = new Error();
			return error.readFromParcel(in);
		}

		@Override
		public Error[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Error[size];
		}
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getSeen() {
		return seen;
	}

	public void setSeen(int seen) {
		this.seen = seen;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getMomentId() {
		return momentId;
	}

	public void setMomentId(int momentId) {
		this.momentId = momentId;
	}
	

}
