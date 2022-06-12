package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomerOrderHistoryResponse {

    @SerializedName("status")
    public  String status;

    @SerializedName("message")
    public  String message;

    @SerializedName("data")
    public ArrayList<CustomerOrderHistory> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<CustomerOrderHistory> getData() {
        return data;
    }

    public void setAddresses(ArrayList<CustomerOrderHistory> data) {
        this.data = data;
    }
}
