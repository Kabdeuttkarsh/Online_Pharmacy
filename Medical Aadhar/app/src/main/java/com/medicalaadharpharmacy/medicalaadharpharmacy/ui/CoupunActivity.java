package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;


public class CoupunActivity extends RootActivity  {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    User user;
    SessionManager sessionManager;
    int amount = 0;
    CustPrograssbar custPrograssbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupun);
        ButterKnife.bind(this);
        amount = getIntent().getIntExtra("amount", 0);
        custPrograssbar = new CustPrograssbar();
        sessionManager = new SessionManager(CoupunActivity.this);
        user = sessionManager.getUserDetails("");
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getCoupuns();

    }

    private void getCoupuns() {
        custPrograssbar.prograssCreate(CoupunActivity.this);
        JSONObject jsonObject = new JSONObject();
        RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<JsonObject> call = APIClient.getInterface().getCouponList(bodyRequest);
//        GetResult getResult = new GetResult();
//        getResult.setMyListener(this);
//        getResult.callForLogin(call, "1");

    }

    private void chalkCoupons(String cid) {
        try {
            custPrograssbar.prograssCreate(CoupunActivity.this);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("uid", user.getId());
            jsonObject.put("cid", cid);
            RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
            Call<JsonObject> call = APIClient.getInterface().checkCoupon(bodyRequest);
//            GetResult getResult = new GetResult();
//            getResult.setMyListener(this);
//            getResult.callForLogin(call, "2");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

//    @Override
//    public void callback(JsonObject result, String callNo) {
//        try {
//            custPrograssbar.closePrograssBar();
//            if (callNo.equalsIgnoreCase("1")) {
//                Gson gson = new Gson();
//                Coupon coupon = gson.fromJson(result.toString(), Coupon.class);
//                if (coupon.getResult().equalsIgnoreCase("true")) {
//                    CouponAdp couponAdp = new CouponAdp(this, coupon.getCouponlist(), this, amount);
//                    recyclerView.setAdapter(couponAdp);
//                }
//            } else if (callNo.equalsIgnoreCase("2")) {
//                Gson gson = new Gson();
//                RestResponse response = gson.fromJson(result.toString(), RestResponse.class);
//                Toast.makeText(CoupunActivity.this, response.getResponseMsg(), Toast.LENGTH_LONG).show();
//                if (response.getResult().equalsIgnoreCase("true")) {
//                    finish();
//                } else {
//                    sessionManager.setIntData(coupon, 0);
//
//                }
//            }
//
//        } catch (Exception e) {
//            sessionManager.setIntData(coupon, 0);
//
//        }
//
//    }

//    @Override
//    public void onClickItem(View v, Couponlist coupon) {
//        try {
//            if (coupon.getMinAmt() < amount) {
//                sessionManager.setIntData(SessionManager.coupon, Integer.parseInt(coupon.getCValue()));
//                sessionManager.setIntData(couponid, Integer.parseInt(coupon.getId()));
//                chalkCoupons(coupon.getId());
//            } else {
//                Toast.makeText(CoupunActivity.this, "Sorry this coupon code is not applied", Toast.LENGTH_LONG).show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//
//    }

    @OnClick(R.id.img_back)
    public void onClick() {
        finish();
    }
}