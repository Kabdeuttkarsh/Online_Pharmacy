package com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit;


import android.os.Bundle;

import com.medicalaadharpharmacy.medicalaadharpharmacy.model.OrderHistory;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.OtpResult;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.BannerResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CartSession;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CartSessionResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.AddCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.ChangePasswordResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerAddressResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderDetailsResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderHistoryResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerProfileUpdateResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerSignupResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.FetchCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.MostViewedResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.MyAddressResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.OrderProductsResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.PaytmChecksumResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.PaytmSaveResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.PrevPrescriptionResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.QtyMinusCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.QtyPlusCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.RecommndResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.RemoveCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.ResendOTPresponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProductResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SuggestedResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.UploadResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.GeneralSettingsResponse;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface UserService {

    @GET(APIClient.APPEND_URL + "Customer/")
    Call<CustomerResponse> getUserinfo(@Query("customer_id") String customer_id);

    @GET(APIClient.APPEND_URL + "General_setting/")
    Call<GeneralSettingsResponse> getGeneralSettings();

    @GET(APIClient.APPEND_URL + "Home/most_view")
    Call<MostViewedResponse> getMostViewed();

    @GET(APIClient.APPEND_URL + "Customer/most_view")
    Call<MyAddressResponse> getAddress();

    @GET(APIClient.APPEND_URL + "Home/recommendation")
    Call<RecommndResponse> getRecmnd();

    @GET(APIClient.APPEND_URL + "Product/fetch_suggested_products")
    Call<SuggestedResponse> getSuggested(@Query("product_id") String product_id);

    @POST(APIClient.APPEND_URL + "p_country_code.php")
    Call<JsonObject> getCountry(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_reg_user.php")
    Call<JsonObject> getRegister(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_profile.php")
    Call<JsonObject> getUpdate(@Body RequestBody requestBody);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/forget_pass_request")
    Call<OtpResult> getCheckMobile(@Field("Username") String Username);

//    @FormUrlEncoded
//    @POST(APIClient.APPEND_URL + "Cart/add_cart_mobile")
//    Call<CartResponse> addToCart(@Field("customer_id") String customer_id,
//                                 @Field("product_id") String product_id);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/verify_otp_for_forget_pass")
    Call<OtpResult> verifyOtp(@Field("Username") String Username,
                              @Field("OTP") String OTP) ;

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/verify_otp")
    Call<OtpResult> verifyOtpforSignup(@Field("customer_id") String customer_id,
                              @Field("OTP") String OTP) ;

    @POST(APIClient.APPEND_URL + "p_address_user.php")
    Call<JsonObject> setAddress(@Body RequestBody requestBody);

//    @POST(APIClient.APPEND_URL + "Customer/login_customer")
//    Call<JsonObject> login(@Body RequestBody requestBody);

    @GET(APIClient.APPEND_URL + "Home/banner")
    Call<BannerResponse> getBanner();

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/login_customer")
    Call<CustomerResponse> login(@Field("Username") String Username,
                                 @Field("Password") String Password);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/Register")
    Call<CustomerSignupResponse> signup(@Field("full_name") String full_name,
                                        @Field("email") String email,
                                        @Field("phone") String phone,
                                        @Field("password") String password,
                                        @Field("pincode") String pincode,
                                        @Field("city") String city,
                                        @Field("state") String state,
                                        @Field("country") String country,
                                        @Field("address_lines") String address_lines,
                                        @Field("land_mark") String land_mark,
                                        @Field("referral_code") String referral_code);


    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/update_info")
    Call<CustomerProfileUpdateResponse> update_info(@Field("full_name") String full_name,
                                                    @Field("email") String email,
                                                    @Field("mobile_number") String mobile_number,
                                                    @Field("customer_id") String customer_id
                                                  );

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL+"Customer/add_customer_address_mob")
    Call<MyAddressResponse> addAddress(@Field("user_id") String user_id,
                                       @Field("house_no") String house_no,
                                       @Field("land_mark") String land_mark,
                                       @Field("pincode") String pincode,
                                       @Field("city") String city,
                                       @Field("addresses") String addresses,
                                       @Field("lat") String lat,
                                       @Field("lag") String lag,
                                       @Field("type") String type,
                                       @Field("state") String state,
                                       @Field("country") String country);
    @FormUrlEncoded
    @POST(APIClient.APPEND_URL+"Customer/update_customer_address_mob")
    Call<MyAddressResponse> updateAddress(@Field("user_id") String user_id,
                                       @Field("house_no") String house_no,
                                       @Field("land_mark") String land_mark,
                                       @Field("pincode") String pincode,
                                       @Field("city") String city,
                                       @Field("addresses") String addresses,
                                       @Field("lat") String lat,
                                       @Field("lag") String lag,
                                       @Field("type") String type,
                                       @Field("state") String state,
                                       @Field("country") String country,
                                       @Field("aid") String aid);

    @POST(APIClient.APPEND_URL + "p_home_data.php")
    Call<JsonObject> getHome(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_brand_product.php")
    Call<JsonObject> getBrandProduct(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_rand_product.php")
    Call<JsonObject> getRandomProduct(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_cat_product.php")
    Call<JsonObject> getCatProduct(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_cat_list.php")
    Call<JsonObject> getCatList(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_brand_list.php")
    Call<JsonObject> getBrand(@Body RequestBody requestBody);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Order_details/place_order_mob")
    Call<CartSessionResponse> postProduct(@Field("customer_id") String customer_id,
                                          @Field("session_address_id") String session_address_id);

    @GET(APIClient.APPEND_URL + "Customer/all_customer_address")
    Call<CustomerAddressResponse> getAddress(@Query("customer_id") String customer_id);

    @GET(APIClient.APPEND_URL + "Customer/default_customer_address")
    Call<MyAddressResponse> getDefaultAddress(@Query("customer_id") String customer_id,
                                              @Query("session_address_id") String session_address_id);

    @POST(APIClient.APPEND_URL + "p_product_cart_validate.php")
    Call<JsonObject> getProductCartAddress(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_check_coupon.php")
    Call<JsonObject> checkCoupon(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_couponlist.php")
    Call<JsonObject> getCouponList(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_paymentgateway.php")
    Call<JsonObject> getPaymentList(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_order_now.php")
    Call<JsonObject> getOrderNow(@Body RequestBody requestBody);

    //@POST(APIClient.APPEND_URL + "Customer/prescription_mob_submit")
    @POST(APIClient.APPEND_URL + "Prescription/rx_quick_submit")
    @Multipart
    Call<UploadResponse> uploadMultiFile(@Part("uid") RequestBody uid,
                                         @Part("Full_Address") RequestBody address,
                                         @Part("d_charge") RequestBody d_charge,
                                         @Part("size") RequestBody size,
                                         @Part List<MultipartBody.Part> parts
                                        );

    @POST(APIClient.APPEND_URL + "Prescription/rx_with_cart_submit")
    @Multipart
    Call<UploadResponse> uploadMultiFileCart(@Part("customer_id") RequestBody uid,
                                             @Part("Full_Address") RequestBody address,
                                             @Part("d_charge") RequestBody d_charge,
                                             @Part("size") RequestBody size,
                                             @Part List<MultipartBody.Part> image
    );

//    @POST(APIClient.APPEND_URL + "Customer/pre_android")
//    @Multipart
//    Call<UploadResponse> uploadMultiFile(@Part List<MultipartBody.Part> filedata);

//    @POST(APIClient.APPEND_URL + "p_order_history.php")
//    Call<JsonObject> getOrder(@Body RequestBody requestBody);

   // Call<JsonObject> getOrder(@Body RequestBody requestBody);
   @GET(APIClient.APPEND_URL + "Order_details/customer_fetch_all_orders")
   Call<CustomerOrderHistoryResponse> getOrder(@Query("customer_id") String customer_id);

    @POST(APIClient.APPEND_URL + "p_prescription_history.php")
    Call<JsonObject> getPredationOrder(@Body RequestBody requestBody);

//    @POST(APIClient.APPEND_URL + "p_order_product_list.php")
//    Call<JsonObject> getOrderHistory(@Body RequestBody requestBody);

    @GET(APIClient.APPEND_URL + "Order_details/fetch_customer_order_info")
    Call<CustomerOrderDetailsResponse> getOrderHistory(@Query("order_code") String order_code);

    @GET(APIClient.APPEND_URL + "Order_details/fetch_order_product")
    Call<OrderProductsResponse> getOrderProducts(@Query("order_code") String order_code);


//    @POST(APIClient.APPEND_URL + "Order_details/order_cancel")
//    Call<JsonObject> getOrderCancel(@Body RequestBody requestBody);


    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Paytm_gateway/start_paytm_payment")
    Call<PaytmChecksumResponse> getPaytmChecksum(@Field("MID") String MID,
                                                 @Field("ORDER_ID") String ORDER_ID,
                                                 @Field("CUST_ID") String CUST_ID,
                                                 @Field("CHANNEL_ID") String CHANNEL_ID,
                                                 @Field("TXN_AMOUNT") String  TXN_AMOUNT,
                                                 @Field("WEBSITE") String WEBSITE,
                                                 @Field("INDUSTRY_TYPE_ID") String INDUSTRY_TYPE_ID,
                                                 @Field("CURRENCY") String CURRENCY,
                                                 @Field("CALLBACK_URL") String CALLBACK_URL
                                                 );


    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Order_details/order_cancel")
    Call<CustomerOrderHistoryResponse> getOrderCancel(@Field("order_no") String order_no);


    @POST(APIClient.APPEND_URL + "p_prescription_cancle.php")
    Call<JsonObject> getPresOrderCancel(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_prescription_order_product_list.php")
    Call<JsonObject> getPrescriptionOrderHistry(@Body RequestBody requestBody);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Product/search")
    Call<SearchProductResponse> getSearch(@Field("search_key") String search_key,
                                          @Field("limit") String limit,
                                          @Field("start") String start);

    @POST(APIClient.APPEND_URL + "p_notification_list.php")
    Call<JsonObject> getNote(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_forget_password.php")
    Call<JsonObject> forgotPassword(@Body RequestBody requestBody);

    @POST(APIClient.APPEND_URL + "p_pre_data.php")
    Call<JsonObject> sendPreData(@Body RequestBody requestBody);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL+"Cart/add_cart")
    Call<AddCartWebResponse> addcartWeb(@Field("customer_id") String customer_id,
                                        @Field("product_id") String product_id);

    @GET(APIClient.APPEND_URL + "Cart/fetch_cart")
    Call<FetchCartWebResponse> getCartProducts(@Query("customer_id") String customer_id);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL+"Cart/minus_qty")
    Call<QtyMinusCartWebResponse> QtyMinusCartProduct(@Field("product_id") String product_id,
                                                      @Field("customer_id") String customer_id);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL+"Cart/plus_qty")
    Call<QtyPlusCartWebResponse> QtyPlusCartProduct(@Field("product_id") String product_id,
                                                    @Field("customer_id") String customer_id);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL+"Cart/remove_product_from_cart")
    Call<RemoveCartWebResponse> removecartWeb(@Field("product_id") String product_id,
                                              @Field("customer_id") String customer_id);

    @GET(APIClient.APPEND_URL + "Prescription/order_rx")
    Call<PrevPrescriptionResponse> getPreviousPrescription(@Query("customer_id") String customer_id);

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/update_password")
    Call<ChangePasswordResponse> update_password(@Field("customer_id") String customer_id,
                                                @Field("old_password") String old_password,
                                                 @Field("new_password") String new_password,
                                                 @Field("confirm_password") String confirm_password
                                                );

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/update_password_forget")
    Call<ChangePasswordResponse> update_password_forget(@Field("phone_number") String phone_number,
                                                        @Field("new_password") String new_password,
                                                        @Field("confirm_password") String confirm_password
    );

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Order_details/save_Paytm_Response")
    Call<PaytmSaveResponse> savePaytmResponse(@Field("paytm_MID") String paytm_MID,
                                              @Field("paytm_ORDERID")  String paytm_ORDERID,
                                              @Field("paytm_STATUS") String paytm_STATUS,
                                              @Field("paytm_CHECKSUMHASH")  String paytm_CHECKSUMHASH,
                                              @Field("paytm_TXNAMOUNT") String paytm_TXNAMOUNT,
                                              @Field("paytm_TXNDATE")  String paytm_TXNDATE,
                                              @Field("paytm_TXNID") String paytm_TXNID,
                                              @Field("paytm_RESPCODE")  String paytm_RESPCODE,
                                              @Field("paytm_PAYMENTMODE") String paytm_PAYMENTMODE,
                                              @Field("paytm_BANKTXNID")  String paytm_BANKTXNID,
                                              @Field("paytm_RESPMSG") String paytm_RESPMSG,
                                              @Field("sale_code") String sale_code
                                                  );

    @FormUrlEncoded
    @POST(APIClient.APPEND_URL + "Customer/resend_otp")
    Call<ResendOTPresponse> resendOTP(@Field("customer_id") String customer_id);
}
