package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import com.google.gson.annotations.SerializedName;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.OrderProducts;

import java.util.List;

public class OrderProductsResponse {

    @SerializedName("data")
    public List<OrderProducts> mOrderProductList;
    @SerializedName("status")
    public String mResponseCode;
    @SerializedName("message")
    public String mResponseMsg;

    public List<OrderProducts> getmOrderProductList() {
        return mOrderProductList;
    }

    public void setmOrderProductList(List<OrderProducts> mOrderProductList) {
        this.mOrderProductList = mOrderProductList;
    }

    public String getmResponseCode() {
        return mResponseCode;
    }

    public void setmResponseCode(String mResponseCode) {
        this.mResponseCode = mResponseCode;
    }

    public String getmResponseMsg() {
        return mResponseMsg;
    }

    public void setmResponseMsg(String mResponseMsg) {
        this.mResponseMsg = mResponseMsg;
    }
}
