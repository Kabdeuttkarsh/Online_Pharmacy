package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomerSignupResponse {



        @SerializedName("status")
        public  String status;

        @SerializedName("message")
        public  String message;

        @SerializedName("redirect_page")
        public  String redirect_page;

        @SerializedName("customer_id")
        public String customer_id;

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
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

        public String getRedirect_page() {
            return redirect_page;
        }

        public void setRedirect_page(String redirect_page) {
            this.redirect_page = redirect_page;
        }

        public String getData() {
            return customer_id;
        }

        public void setData(String data) {
            this.customer_id = data;
        }
    }


