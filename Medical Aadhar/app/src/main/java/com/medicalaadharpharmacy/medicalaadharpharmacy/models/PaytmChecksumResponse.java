package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PaytmChecksumResponse {

    @SerializedName("data")
    public String data;

    public String getData() {
        return data;
    }

    public void setData(String checksums) {
        this.data = checksums;
    }
}
