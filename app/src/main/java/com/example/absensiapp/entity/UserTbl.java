package com.example.absensiapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserTbl implements Parcelable {

    @SerializedName("id")
    private long id;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public UserTbl(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.username);
        dest.writeString(this.password);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readLong();
        this.username = source.readString();
        this.password = source.readString();
    }

    protected UserTbl(Parcel in) {
        this.id = in.readLong();
        this.username = in.readString();
        this.password = in.readString();
    }

    public static final Parcelable.Creator<UserTbl> CREATOR = new Parcelable.Creator<UserTbl>() {
        @Override
        public UserTbl createFromParcel(Parcel source) {
            return new UserTbl(source);
        }

        @Override
        public UserTbl[] newArray(int size) {
            return new UserTbl[size];
        }
    };
}
