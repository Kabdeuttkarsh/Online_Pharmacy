package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.locationpick.LocationGetActivity;
import com.medicalaadharpharmacy.medicalaadharpharmacy.locationpick.MapUtility;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.OtpResult;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.ResendOTPresponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.Utility.isvarification;


public class VerifyOTPActivity extends AppCompatActivity  {
    @BindView(R.id.txt_mob)
    TextView txtMob;
    @BindView(R.id.ed_otp1)
    EditText edOtp1;
    @BindView(R.id.ed_otp2)
    EditText edOtp2;
    @BindView(R.id.ed_otp3)
    EditText edOtp3;
    @BindView(R.id.ed_otp4)
    EditText edOtp4;
    @BindView(R.id.ed_otp5)
    EditText edOtp5;
    @BindView(R.id.ed_otp6)
    EditText edOtp6;

    @BindView(R.id.btn_reenter)
    TextView btnReenter;
    @BindView(R.id.btn_timer)
    TextView btnTimer;
    private String verificationId;
    private FirebaseAuth mAuth;
    String phonenumber;
    String otp;
    SessionManager sessionManager;
    User user;
    CustPrograssbar custPrograssbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_for_forget);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(VerifyOTPActivity.this);
        if (isvarification == 2) {
            user = (User) getIntent().getSerializableExtra("user");
        } else {
            user = sessionManager.getUserDetails("");
        }
        //  mAuth = FirebaseAuth.getInstance();
        phonenumber = getIntent().getStringExtra("customer_id");
        //  Log.d("phone",phonenumber);
        //  phonecode = getIntent().getStringExtra("code");
        //   sendVerificationCode(phonenumber);
        // txtMob.setText("Enter the 6-digit code sent to you \non +91" + phonenumber);
        try {
            new CountDownTimer(60000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                    btnTimer.setText(seconds + " Second Wait");
                }

                @Override
                public void onFinish() {
                    btnReenter.setVisibility(View.VISIBLE);
                    btnTimer.setVisibility(View.GONE);
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


        edOtp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (count == 1) {
                    edOtp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edOtp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("count", "" + count);
                Log.e("count", "" + count);
                Log.e("count", "" + count);

                if (s.length() == 1) {
                    edOtp3.requestFocus();
                }else if(count==0){
                    edOtp1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edOtp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (count == 1) {
                    edOtp4.requestFocus();
                }else if(count==0){
                    edOtp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edOtp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (count == 1) {
                    edOtp5.requestFocus();
                }else if(count==0){
                    edOtp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edOtp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (count == 1) {
                    edOtp6.requestFocus();
                }else if(count==0){
                    edOtp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edOtp6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    edOtp6.requestFocus();
                }else if(count==0){
                    edOtp5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.btn_send, R.id.btn_reenter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                if (validation()) {
                    otp = edOtp1.getText().toString() + "" + edOtp2.getText().toString() + "" + edOtp3.getText().toString() + "" + edOtp4.getText().toString() + "" + edOtp5.getText().toString() + "" + edOtp6.getText().toString();
                    verifyCode(otp,phonenumber);
                }
                break;
            case R.id.btn_reenter:
                btnReenter.setVisibility(View.GONE);
                btnTimer.setVisibility(View.VISIBLE);
          //      custPrograssbar.prograssCreate(VerifyOTPActivity.this);
                Call<ResendOTPresponse> call = APIClient.getInterface().resendOTP(phonenumber);
                call.enqueue(new Callback<ResendOTPresponse>() {
                    @Override
                    public void onResponse(Call<ResendOTPresponse> call, Response<ResendOTPresponse> response) {
                  //      custPrograssbar.closePrograssBar();
                        if(response.isSuccessful()){

                            Toast.makeText(VerifyOTPActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(VerifyOTPActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResendOTPresponse> call, Throwable t) {
                        Toast.makeText(VerifyOTPActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
                try {
                    new CountDownTimer(60000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                            btnTimer.setText(seconds + " Second Wait");
                        }

                        @Override
                        public void onFinish() {
                            btnReenter.setVisibility(View.VISIBLE);
                            btnTimer.setVisibility(View.GONE);
                        }
                    }.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
             //   verifyCode( otp,phonenumber);
                break;
            default:
                break;
        }
    }

    public  void verifyCode(String otp,String number){
//    custPrograssbar.prograssCreate(VerifyPhoneActivity.this);
//    JSONObject jsonObject = new JSONObject();
//    try {
//        jsonObject.put("OTP", otp);
//        jsonObject.put("Username", number);
//    } catch (Exception e) {
//        e.printStackTrace();
//
//    }
//    RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<OtpResult> call = APIClient.getInterface().verifyOtp(number,otp);
        call.enqueue(new Callback<OtpResult>() {
            @Override
            public void onResponse(Call<OtpResult> call, Response<OtpResult> response) {
                if (response.isSuccessful()){
                    if (response.body().getStatus().equals(false)){
                        Toast.makeText(VerifyOTPActivity.this,"Invalid OTP",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(VerifyOTPActivity.this,"Success",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(VerifyOTPActivity.this, ChanegForgetPasswordActivity.class)
                                .putExtra("phone_number", phonenumber));
                    }
                }
            }

            @Override
            public void onFailure(Call<OtpResult> call, Throwable t) {
                Toast.makeText(VerifyOTPActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });

//                GetResult getResult = new GetResult();
//                getResult.setMyListener(this::callback);
//                getResult.callForLogin(call, "1");
    }


    public boolean validation() {

        if (edOtp1.getText().toString().isEmpty()) {
            edOtp1.setError("");
            return false;
        }
        if (edOtp2.getText().toString().isEmpty()) {
            edOtp2.setError("");
            return false;
        }
        if (edOtp3.getText().toString().isEmpty()) {
            edOtp3.setError("");
            return false;
        }
        if (edOtp4.getText().toString().isEmpty()) {
            edOtp4.setError("");
            return false;
        }
        if (edOtp5.getText().toString().isEmpty()) {
            edOtp5.setError("");
            return false;
        }
        if (edOtp6.getText().toString().isEmpty()) {
            edOtp6.setError("");
            return false;
        }
        return true;
    }


//    public void callback(JsonObject result, String callNo) {
//        try {
//            startActivity(new Intent(VerifyPhoneActivity.this, ChanegPasswordActivity.class));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }

}
