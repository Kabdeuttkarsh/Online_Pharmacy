package com.medicalaadharpharmacy.medicalaadharpharmacy.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("customer_id")
    private String id;
//    @SerializedName("ccode")
//    private String mCcode;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("full_name")
    private String mFname;
//    @SerializedName("id")
//    private String mId;
//    @SerializedName("lname")
//    private String mLname;
    @SerializedName("mobile_number")
    private String mMobile;
    @SerializedName("credential")
    private String mPassword;

    @SerializedName("my_referral")
    private String mmy_referral;

    public String getMreferral_code() {
        return mmy_referral;
    }

    public void setMreferral_code(String mreferral_code) {
        this.mmy_referral = mreferral_code;
    }


//    @SerializedName("rdate")
//    private String mRdate;
//    @SerializedName("status")
//    private String mStatus;

//    public String getCcode() {
//        return mCcode;
//    }
//
//    public void setCcode(String ccode) {
//        mCcode = ccode;
//    }
//
//    public String getEmail() {
//        return mEmail;
//    }
//
//    public void setEmail(String email) {
//        mEmail = email;
//    }
//
//    public String getFname() {
//        return mFname;
//    }
//
//    public void setFname(String fname) {
//        mFname = fname;
//    }
//
//    public String getId() {
//        return mId;
//    }
//
//    public void setId(String id) {
//        mId = id;
//    }
//
//    public String getLname() {
//        return mLname;
//    }
//
//    public void setLname(String lname) {
//        mLname = lname;
//    }
//
//    public String getMobile() {
//        return mMobile;
//    }
//
//    public void setMobile(String mobile) {
//        mMobile = mobile;
//    }
//
//    public String getPassword() {
//        return mPassword;
//    }
//
//    public void setPassword(String password) {
//        mPassword = password;
//    }
//
//    public String getRdate() {
//        return mRdate;
//    }
//
//    public void setRdate(String rdate) {
//        mRdate = rdate;
//    }
//
//    public String getStatus() {
//        return mStatus;
//    }
//
//    public void setStatus(String status) {
//        mStatus = status;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmFname() {
        return mFname;
    }

    public void setmFname(String mFname) {
        this.mFname = mFname;
    }

    public String getmMobile() {
        return mMobile;
    }

    public void setmMobile(String mMobile) {
        this.mMobile = mMobile;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}

