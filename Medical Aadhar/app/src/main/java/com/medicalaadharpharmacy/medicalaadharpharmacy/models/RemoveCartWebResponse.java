package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RemoveCartWebResponse {

        @SerializedName("status")
        public  String status;

        @SerializedName("message")
        public  String message;

        @SerializedName("cart_count")
        public String cart_count;

        @SerializedName("cart_details")
        public ArrayList<RemoveCartWeb> data;

        public ArrayList<RemoveCartWeb> getData() {
            return data;
        }

        public void setData(ArrayList<RemoveCartWeb> data) {
            this.data = data;
        }

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

        public String getCart_count() {
            return cart_count;
        }

        public void setCart_count(String cart_count) {
            this.cart_count = cart_count;
        }


}
