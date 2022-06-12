package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecommndResponse {

    @SerializedName("status")
    public  String status;

    @SerializedName("message")
    public  String message;

    @SerializedName("data")
    public ArrayList<Recommnd> data;

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

    public ArrayList<Recommnd> getData() {
        return data;
    }

    public void setData(ArrayList<Recommnd> data) {
        this.data = data;
    }
}
