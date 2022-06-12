
package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OrderProducts implements Parcelable {

    @SerializedName("discount")
    public String mProductDiscount;
    @SerializedName("product_image")
    public String mProductImage;
    @SerializedName("product_name")
    public String mProductName;
    @SerializedName("mrp")
    public String mProductPrice;
    @SerializedName("quantity")
    public String mProductQuantity;
    @SerializedName("totals")
    public String mProductTotal;
    @SerializedName("Product_variation")
    public String mProductVariation;

    protected OrderProducts(Parcel in) {
        mProductDiscount = in.readString();
        mProductImage = in.readString();
        mProductName = in.readString();
        mProductPrice = in.readString();
        mProductQuantity = in.readString();
        mProductTotal = in.readString();
        mProductVariation = in.readString();
    }

    public static final Creator<OrderProducts> CREATOR = new Creator<OrderProducts>() {
        @Override
        public OrderProducts createFromParcel(Parcel in) {
            return new OrderProducts(in);
        }

        @Override
        public OrderProducts[] newArray(int size) {
            return new OrderProducts[size];
        }
    };

    public String getProductDiscount() {
        return mProductDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        mProductDiscount = productDiscount;
    }

    public String getProductImage() {
        return mProductImage;
    }

    public void setProductImage(String productImage) {
        mProductImage = productImage;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public String getProductPrice() {
        return mProductPrice;
    }

    public void setProductPrice(String productPrice) {
        mProductPrice = productPrice;
    }

    public String getProductQuantity() {
        return mProductQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        mProductQuantity = productQuantity;
    }

    public String getProductTotal() {
        return mProductTotal;
    }

    public void setProductTotal(String productTotal) {
        mProductTotal = productTotal;
    }

    public String getProductVariation() {
        return mProductVariation;
    }

    public void setProductVariation(String productVariation) {
        mProductVariation = productVariation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mProductDiscount);
        parcel.writeString(mProductImage);
        parcel.writeString(mProductName);
        parcel.writeString(mProductPrice);
        parcel.writeString(mProductQuantity);
        parcel.writeString(mProductTotal);
        parcel.writeString(mProductVariation);
    }
}
