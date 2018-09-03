package com.example.android.quakereport;

public class eartquakes {

    private Double mMagnitude;
    private String mLocation;
    private String mTime;
    private String mDate;
    private String mUrl;

    public eartquakes(Double magnitude, String location, String date, String time, String Url) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mTime = time;
        mUrl = Url;
    }

    public Double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }

    public String getUrl() {
        return mUrl;
    }

}

