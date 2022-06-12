package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomerResponse {


    @SerializedName("status")
    public  String status;

    @SerializedName("message")
    public  String message;

    @SerializedName("redirect_page")
    public  String redirect_page;

    @SerializedName("data")
    public ArrayList<Customer> data;

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

    public String getRedirect_page() {
        return redirect_page;
    }

    public void setRedirect_page(String redirect_page) {
        this.redirect_page = redirect_page;
    }

    public ArrayList<Customer> getData() {
        return data;
    }

    public void setData(ArrayList<Customer> data) {
        this.data = data;
    }
}
