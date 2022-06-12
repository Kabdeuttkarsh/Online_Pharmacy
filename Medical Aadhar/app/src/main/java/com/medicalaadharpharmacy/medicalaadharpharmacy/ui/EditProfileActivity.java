package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.Customer;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerAddress;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerAddressResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerProfileUpdateResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends RootActivity {

    @BindView(R.id.ed_firstname)
    EditText edFirstName;
    @BindView(R.id.ed_lastname)
    EditText edLastName;
    @BindView(R.id.ed_email)
    TextView edEmail;
    @BindView(R.id.ed_password)
    EditText edPassword;
    @BindView(R.id.btn_countinue)
    TextView btuContinues;
    @BindView(R.id.ed_refferalCode)
    TextView edRefferalCode;

    SessionManager sessionManager;
    User user;
    @BindView(R.id.ed_mobile)
    TextView edMobile;
    @BindView(R.id.img_back)
    ImageView imgBack;
    CustPrograssbar custPrograssbar;
    ArrayList<Customer> customerInfo = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        ButterKnife.bind(this);
        custPrograssbar = new CustPrograssbar();
        sessionManager = new SessionManager(EditProfileActivity.this);
        user = sessionManager.getUserDetails("");

        custPrograssbar.prograssCreate(EditProfileActivity.this);
        Call<CustomerResponse> call = APIClient.getInterface().getUserinfo(
                user.getId());
        call.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                if(response.isSuccessful()){
                    custPrograssbar.closePrograssBar();
                    CustomerResponse caResponse =  response.body();
                    customerInfo= caResponse.getData();
                    edFirstName.setText(customerInfo.get(0).getFull_name());
                    edLastName.setText(customerInfo.get(0).getFull_name());
                    edMobile.setText(customerInfo.get(0).getMobile_number());
                    edEmail.setText(customerInfo.get(0).getEmail());
                    edPassword.setText(customerInfo.get(0).getPassword());
                    edRefferalCode.setText(customerInfo.get(0).getMy_referral());
                }else{
                    Toast.makeText(EditProfileActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                    custPrograssbar.closePrograssBar();
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                Toast.makeText(EditProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                custPrograssbar.closePrograssBar();
            }
        });


    }


    public boolean validation() {
        if (edFirstName.getText().toString().isEmpty()) {
            edFirstName.setError("Enter First Name");
            return false;
        }
        if (edMobile.getText().toString().isEmpty()) {
            edMobile.setError("Enter Mobile Number");
            return false;
        }
        if (edEmail.getText().toString().isEmpty()) {
            edEmail.setError("Enter Email");
            return false;
        }
        return true;
    }

    private void updateUser() {
        custPrograssbar.prograssCreate(EditProfileActivity.this);

        Call<CustomerProfileUpdateResponse> call = APIClient.getInterface().update_info(edFirstName.getText().toString(),
                                                                                        edEmail.getText().toString(),
                                                                                        edMobile.getText().toString(),
                                                                                        user.getId());

        call.enqueue(new Callback<CustomerProfileUpdateResponse>() {
            @Override
            public void onResponse(Call<CustomerProfileUpdateResponse> call, Response<CustomerProfileUpdateResponse> response) {
                if(response.isSuccessful()){
                    custPrograssbar.closePrograssBar();
                    Toast.makeText(EditProfileActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }else{
                    custPrograssbar.closePrograssBar();
                    Toast.makeText(EditProfileActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<CustomerProfileUpdateResponse> call, Throwable t) {
                custPrograssbar.closePrograssBar();
                Toast.makeText(EditProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

//    @Override
//    public void callback(JsonObject result, String callNo) {
//        try {
//            custPrograssbar.closePrograssBar();
//            if (callNo.equalsIgnoreCase("1")) {
//                Gson gson = new Gson();
//                ProfileUpdate profileUpdate = gson.fromJson(result.toString(), ProfileUpdate.class);
//                Toast.makeText(EditProfileActivity.this, profileUpdate.getResponseMsg(), Toast.LENGTH_SHORT).show();
//                if (profileUpdate.getResult().equalsIgnoreCase("true")) {
//                    sessionManager.setUserDetails("", profileUpdate.getUser());
//                    finish();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @OnClick({R.id.img_back, R.id.btn_countinue})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_countinue:
                if (validation()) {
                    updateUser();
                }
                break;
            default:
                break;
        }
    }
}