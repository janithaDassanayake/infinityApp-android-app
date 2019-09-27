package com.example.infinityapp;

public class Movie {
    private String mId;
    private String mName;
    private String mProduction;
    private String mRunningTime;
   // private String mCategory;
    private String mType;
    private String mLanguage;
    private String mImageName;
    private String mImageUrl;


    public Movie() {
    }

    public Movie(String mId, String mName, String mProduction, String mRunningTime, String mType, String mLanguage, String mImageName, String mImageUrl) {
        this.mId = mId;
        this.mName = mName;
        this.mProduction = mProduction;
        this.mRunningTime = mRunningTime;
        this.mType = mType;
        this.mLanguage = mLanguage;
        this.mImageName = mImageName;
        this.mImageUrl = mImageUrl;
    }

    public Movie(String mId, String mName, String mProduction, String mRunningTime, String mType, String mLanguage) {
        this.mId = mId;
        this.mName = mName;
        this.mProduction = mProduction;
        this.mRunningTime = mRunningTime;
        this.mType = mType;
        this.mLanguage = mLanguage;
    }


    public String getmImageName() {
        return mImageName;
    }

    public void setmImageName(String mImageName) {
        this.mImageName = mImageName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmProduction() {
        return mProduction;
    }

    public void setmProduction(String mProduction) {
        this.mProduction = mProduction;
    }

    public String getmRunningTime() {
        return mRunningTime;
    }

    public void setmRunningTime(String mRunningTime) {
        this.mRunningTime = mRunningTime;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmLanguage() {
        return mLanguage;
    }

    public void setmLanguage(String mLanguage) {
        this.mLanguage = mLanguage;
    }
}
