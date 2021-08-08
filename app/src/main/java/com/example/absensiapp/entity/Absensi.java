package com.example.absensiapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Absensi implements Parcelable {

    @SerializedName("absensiId")
    private long absensiId;
    @SerializedName("photo")
    private String photo;
    @SerializedName("date")
    private String date;
    @SerializedName("checkIn")
    private String checkIn;
    @SerializedName("checkOut")
    private String checkOut;
    @SerializedName("gpsLocation")
    private String gpsLocation;
    @SerializedName("username")
    private String username;

    public Absensi(long absensiId, String photo, String date, String checkIn, String checkOut, String gpsLocation, String username) {
        this.absensiId = absensiId;
        this.photo = photo;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.gpsLocation = gpsLocation;
        this.username = username;
    }

    public Absensi() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getAbsensiId() {
        return absensiId;
    }

    public void setAbsensiId(long absensiId) {
        this.absensiId = absensiId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.absensiId);
        dest.writeString(this.photo);
        dest.writeString(this.checkIn);
        dest.writeString(this.checkOut);
        dest.writeString(this.gpsLocation);
    }

    public void readFromParcel(Parcel source) {
        this.absensiId = source.readLong();
        this.photo = source.readString();
        this.checkIn = source.readString();
        this.checkOut = source.readString();
        this.gpsLocation = source.readString();
    }

    protected Absensi(Parcel in) {
        this.absensiId = in.readLong();
        this.photo = in.readString();
        this.checkIn = in.readString();
        this.checkOut = in.readString();
        this.gpsLocation = in.readString();
    }

    public static final Parcelable.Creator<Absensi> CREATOR = new Parcelable.Creator<Absensi>() {
        @Override
        public Absensi createFromParcel(Parcel source) {
            return new Absensi(source);
        }

        @Override
        public Absensi[] newArray(int size) {
            return new Absensi[size];
        }
    };
}
