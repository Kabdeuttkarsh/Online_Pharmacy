package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.CountryCode;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.Customer;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerSignupResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends RootActivity {


    @BindView(R.id.ed_mobile)
    EditText edMobile;
    @BindView(R.id.ed_email)
    EditText edEmail;
    @BindView(R.id.ed_password)
    EditText edPassword;

    @BindView(R.id.btn_signUp)
    TextView btnSignUp;
//    @BindView(R.id.lvl_singup)
//    LinearLayout lvlSingup;


    ///////    My Input   ////////

    @BindView(R.id.ed_fullname)
    EditText edFullname;
    @BindView(R.id.ed_pincode)
    EditText edPincode;
    @BindView(R.id.ed_city)
    EditText edCity;
    @BindView(R.id.ed_state)
    EditText edState;
    @BindView(R.id.ed_country)
    EditText edCountry;
    @BindView(R.id.ed_streetAddress)
    EditText edStreetAddress;
    @BindView(R.id.ed_address)
    EditText edAddress;
    @BindView(R.id.ed_refferalCode)
    EditText edRefferalCode;

    /////////
    @Nullable
    @BindView(R.id.txt_newuser)
    TextView txtLogin;
    @BindView(R.id.lvl_login)
    LinearLayout lvlLogin;
    List<CountryCode> cCodes = new ArrayList<>();
    String codeSelect;
    boolean isNewuser = true;
    SessionManager sessionManager;
    CustPrograssbar custPrograssbar;
    String callfrom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        FirebaseApp.initializeApp(this);
        Intent intent = getIntent();
        if (intent.hasExtra("call")){
            callfrom = getIntent().getExtras().getString("call");
        }else{
            callfrom = "null";
        }
        custPrograssbar=new CustPrograssbar();
        sessionManager = new SessionManager(SignupActivity.this);
        String sourceString = "Have a <b>" + "Email/Password" + "</b> " + "Account?";
        String sourceCreate = "<b>Sign Up?</b>";
      //  txtSingUp.setText(Html.fromHtml(sourceString));
        txtLogin.setText(Html.fromHtml(sourceCreate));


    }


    private void signupUser() {
        custPrograssbar.prograssCreate(SignupActivity.this);
        Call<CustomerSignupResponse> call = APIClient.getInterface().signup(edFullname.getText().toString(),
                                                                      edEmail.getText().toString(),
                                                                      edMobile.getText().toString(),
                                                                      edPassword.getText().toString(),
                                                                      edPincode.getText().toString(),
                                                                      edCity.getText().toString(),
                                                                      edState.getText().toString(),
                                                                      edCountry.getText().toString(),
                                                                      edAddress.getText().toString(),
                                                                      edStreetAddress.getText().toString(),
                                                                      edRefferalCode.getText().toString()
        );
        call.enqueue(new Callback<CustomerSignupResponse>() {
            @Override
            public void onResponse(Call<CustomerSignupResponse> call, Response<CustomerSignupResponse> response) {
                if (response.isSuccessful()) {
                    custPrograssbar.closePrograssBar();
                    Toast.makeText(SignupActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    CustomerSignupResponse customerResponse = response.body();
                    String externalUserId = response.body().getCustomer_id();

                    OneSignal.setExternalUserId(externalUserId, new OneSignal.OSExternalUserIdUpdateCompletionHandler() {
                        @Override
                        public void onComplete(JSONObject results) {
                            try{
                                if(results.has("push") && results.getJSONObject("push").has("success")){
                                    boolean isPushSuccess = results.getJSONObject("push").getBoolean("success");
                                    OneSignal.onesignalLog(OneSignal.LOG_LEVEL.VERBOSE, "Set external user id for push status: " + isPushSuccess);
                                    Log.d("onesignalsuccess","Successful Onesignal");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    Intent intent=new Intent(SignupActivity.this,VerifyPhoneActivity.class);
                    Log.d("customer_id",customerResponse.getData().toString());
                    intent.putExtra("customer_id",customerResponse.getData().toString());

                    startActivity(intent);
                }
                else {

                    custPrograssbar.closePrograssBar();
                    Toast.makeText(SignupActivity.this,"Email and Mobile No. Already Exist", Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<CustomerSignupResponse> call, Throwable t) {
                Log.d("sfsfs","Failed Try Again.");
                Toast.makeText(SignupActivity.this,"Failed Try Again.",Toast.LENGTH_LONG).show();
            }
        });
    }


    @OnClick({R.id.txt_olduser, R.id.btn_signUp, R.id.txt_newuser, R.id.txt_forgotclick})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_olduser:
            //    txtSingUp.setVisibility(View.GONE);
//                lvlSingup.setVisibility(View.GONE);
                lvlLogin.setVisibility(View.VISIBLE);
                isNewuser = false;
                break;
            case R.id.btn_signUp:

                    if (TextUtils.isEmpty(edMobile.getText().toString())) {
                        edMobile.setError("Enter Mobile Number");
                    }
//                    else if (TextUtils.isEmpty(edEmail.getText().toString())) {
//                        edEmail.setError("Enter Email");
//                    }
                    else if (TextUtils.isEmpty(edPassword.getText().toString())) {
                        edPassword.setError("Enter Password");
                    } else if (TextUtils.isEmpty(edFullname.getText().toString())) {
                        edFullname.setError("Enter Full Name");
                    } else if (TextUtils.isEmpty(edPincode.getText().toString())) {
                        edPincode.setError("Enter Pincode");
                    }  else if (TextUtils.isEmpty(edCity.getText().toString())) {
                        edCity.setError("Enter City");
                    }  else if (TextUtils.isEmpty(edState.getText().toString())) {
                        edState.setError("Enter State");
                    }  else if (TextUtils.isEmpty(edCountry.getText().toString())) {
                        edCountry.setError("Enter Country");
                    }  else if (TextUtils.isEmpty(edStreetAddress.getText().toString())) {
                        edStreetAddress.setError("Enter Landmark");
                    }  else if (TextUtils.isEmpty(edAddress.getText().toString())) {
                        edAddress.setError("Enter Address");
                    }
                    else {
                        signupUser();
                    }

                break;
            case R.id.txt_newuser:
                isNewuser = true;
                //    txtSingUp.setVisibility(View.VISIBLE);
                //    lvlSingup.setVisibility(View.VISIBLE);
                lvlLogin.setVisibility(View.GONE);
                break;
            case R.id.txt_forgotclick:
                startActivity(new Intent(SignupActivity.this, ForgotActivity.class));
                break;
            default:
                break;
        }
    }



    public void bottonVelidation() {
        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.custome_demo_layout, null);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.show();

    }
}