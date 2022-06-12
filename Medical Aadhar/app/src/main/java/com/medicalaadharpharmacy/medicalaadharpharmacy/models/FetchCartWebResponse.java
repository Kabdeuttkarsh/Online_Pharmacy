package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FetchCartWebResponse {

        @SerializedName("status")
        public  String status;

        @SerializedName("message")
        public  String message;

        @SerializedName("count")
        public String count;

        @SerializedName("data")
        public ArrayList<FetchCartWeb> data;

        @SerializedName("rx_required")
        public String rx_required;

        public String getRx_required() {
            return rx_required;
        }

        public void setRx_required(String rx_required) {
            this.rx_required = rx_required;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ArrayList<FetchCartWeb> getData() {
            return data;
        }

        public void setData(ArrayList<FetchCartWeb> data) {
            this.data = data;
        }

    }
