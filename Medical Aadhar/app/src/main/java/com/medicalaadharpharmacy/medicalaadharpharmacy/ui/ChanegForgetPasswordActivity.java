package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CartSessionResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.ChangePasswordResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.google.gson.JsonObject;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChanegForgetPasswordActivity extends AppCompatActivity{


    @BindView(R.id.ed_password)
    EditText edPassword;

    @BindView(R.id.ed_conpassword1)
    EditText edConPassword;

    @BindView(R.id.btn_submit)
    TextView btnSubmit;
    String phoneNumber;
    CustPrograssbar custPrograssbar;
    User user;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaneg_password_forget);
        ButterKnife.bind(this);
        phoneNumber = getIntent().getStringExtra("phone");
        custPrograssbar = new CustPrograssbar();
    }

    @OnClick(R.id.btn_submit)
    public void onClick() {
        if (validation())
            setPassword();
    }

    public boolean validation() {

        if (edPassword.getText().toString().isEmpty()) {
            edPassword.setError("Enter Password");
            return false;
        }
        if (edConPassword.getText().toString().isEmpty()) {
            edConPassword.setError("Enter Confirm");
            return false;
        }
        if (!edConPassword.getText().toString().equals(edPassword.getText().toString())) {
            edConPassword.setError("Mismatch Password");
            edPassword.setError("Mismatch Password");
            return false;
        }
        return true;
    }

    private void setPassword() {
        sessionManager = new SessionManager(ChanegForgetPasswordActivity.this);
        user = sessionManager.getUserDetails("");
        String phone_number = getIntent().getStringExtra("phone_number");
        custPrograssbar.prograssCreate(ChanegForgetPasswordActivity.this);

        Call<ChangePasswordResponse> call = APIClient.getInterface().update_password_forget(phone_number,
                 edPassword.getText().toString(),
                 edConPassword.getText().toString());

        call.enqueue(new Callback<ChangePasswordResponse>() {
            @Override
            public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
                if(response.isSuccessful()){
                    custPrograssbar.closePrograssBar();
                    Toast.makeText(ChanegForgetPasswordActivity.this, response.body().getMessage()+". Please Login Once.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ChanegForgetPasswordActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }else{
                    custPrograssbar.closePrograssBar();

                    Toast.makeText(ChanegForgetPasswordActivity.this, "Old Password Incorrect", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
                custPrograssbar.closePrograssBar();
                Toast.makeText(ChanegForgetPasswordActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //   JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("mobile", phoneNumber);
//            jsonObject.put("password", edPassword.getText().toString());
//            RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
//            Call<JsonObject> call = APIClient.getInterface().forgotPassword(bodyRequest);
//            GetResult getResult = new GetResult();
//            getResult.setMyListener(this);
//            getResult.callForLogin(call, "1");


//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

//    @Override
//    public void callback(JsonObject result, String callNo) {
//        try {
//            custPrograssbar.closePrograssBar();
//            Gson gson = new Gson();
//            RestResponse response = gson.fromJson(result.toString(), RestResponse.class);
//            Toast.makeText(ChanegPasswordActivity.this, "" + response.getResponseMsg(), Toast.LENGTH_LONG).show();
//            if (response.getResult().equals("true")) {
//                Intent intent = new Intent(ChanegPasswordActivity.this, LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
