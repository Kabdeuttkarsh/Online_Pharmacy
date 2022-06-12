package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomerOrderDetailsResponse {

    @SerializedName("status")
    public  String status;

    @SerializedName("message")
    public  String message;

    @SerializedName("data")
    public ArrayList<CustomerOrderDetails> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<CustomerOrderDetails> getData() {
        return data;
    }

    public void setAddresses(ArrayList<CustomerOrderDetails> data) {
        this.data = data;
    }
}
