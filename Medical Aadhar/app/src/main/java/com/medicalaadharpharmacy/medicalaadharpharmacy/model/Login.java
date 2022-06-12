
package com.medicalaadharpharmacy.medicalaadharpharmacy.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Login {

//    @SerializedName("AddressExist")
//    private Boolean mAddressExist;
    @SerializedName("status")
    private String mResponseCode;
    @SerializedName("message")
    private String mResponseMsg;
    @SerializedName("data")
    private ArrayList<User> mResult;
    @SerializedName("redirect_page")
    private String mredirect_page;

//    @SerializedName("UserLogin")
//    private User mUserLogin;

//    public Boolean getAddressExist() {
//        return mAddressExist;
//    }
//
//    public void setAddressExist(Boolean addressExist) {
//        mAddressExist = addressExist;
//    }

    public String getResponseCode() {
        return mResponseCode;
    }

    public void setResponseCode(String responseCode) {
        mResponseCode = responseCode;
    }

    public String getResponseMsg() {
        return mResponseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        mResponseMsg = responseMsg;
    }

//
//    public User getUserLogin() {
//        return mUserLogin;
//    }
//
//    public void setUserLogin(User userLogin) {
//        mUserLogin = userLogin;
//    }


    public String getmResponseCode() {
        return mResponseCode;
    }

    public void setmResponseCode(String mResponseCode) {
        this.mResponseCode = mResponseCode;
    }

    public String getmResponseMsg() {
        return mResponseMsg;
    }

    public void setmResponseMsg(String mResponseMsg) {
        this.mResponseMsg = mResponseMsg;
    }



    public String getMredirect_page() {
        return mredirect_page;
    }

    public void setMredirect_page(String mredirect_page) {
        this.mredirect_page = mredirect_page;
    }

    public ArrayList<User> getmResult() {
        return mResult;
    }

    public void setmResult(ArrayList<User> mResult) {
        this.mResult = mResult;
    }
}
