package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomerAddressResponse {

    @SerializedName("status")
    public  String status;

    @SerializedName("message")
    public  String message;

    @SerializedName("data")
    public ArrayList<CustomerAddress> addresses;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<CustomerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<CustomerAddress> addresses) {
        this.addresses = addresses;
    }
}
