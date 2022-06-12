package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

public class CustomerProfileUpdateResponse {


    @SerializedName("status")
    public  String status;

    @SerializedName("message")
    public  String message;

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
}
