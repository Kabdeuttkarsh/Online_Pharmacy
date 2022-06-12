package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MostViewedResponse {

    @SerializedName("status")
    public  String status;

    @SerializedName("message")
    public  String message;

    @SerializedName("data")
    public ArrayList<MostViewed> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<MostViewed> getData() {
        return data;
    }

    public void setData(ArrayList<MostViewed> data) {
        this.data = data;
    }
}
