package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SuggestedResponse {

    @SerializedName("status")
    public  String status;

    @SerializedName("message")
    public  String message;

    @SerializedName("suggested")
    public ArrayList<Suggested> suggestedArrayList=new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Suggested> getSuggestedArrayList() {
        return suggestedArrayList;
    }

    public void setSuggestedArrayList(ArrayList<Suggested> suggestedArrayList) {
        this.suggestedArrayList = suggestedArrayList;
    }
}
