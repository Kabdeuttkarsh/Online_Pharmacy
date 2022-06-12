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
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends RootActivity {

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.ed_mobile)
    EditText edMobile;
    @BindView(R.id.ed_email)
    EditText edEmail;
    @BindView(R.id.ed_password)
    EditText edPassword;
    @BindView(R.id.txt_olduser)
    TextView txtSingUp;
    @BindView(R.id.btn_proceed)
    TextView btnProceed;
//    @BindView(R.id.lvl_singup)
//    LinearLayout lvlSingup;
    @Nullable
    @BindView(R.id.txt_newuser)
    TextView txtLogin;

    @BindView(R.id.txt_newuser1)
    TextView txtLogin1;
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
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        FirebaseApp.initializeApp(this);
       Intent intent = getIntent();
        if (intent.hasExtra("call")){
            callfrom = getIntent().getExtras().getString("call");
        }else{
            callfrom = "null";
        }
        custPrograssbar=new CustPrograssbar();
        sessionManager = new SessionManager(LoginActivity.this);
        String sourceString = "Have a <b>" + "Email/Password" + "</b> " + "Account?";
        String sourceCreate = "<b>Sign Up?</b>";

//        txtSingUp.setText(Html.fromHtml(sourceString));
//        txtLogin.setText(Html.fromHtml(sourceCreate));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                codeSelect = cCodes.get(position).getCcode();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getContryCode();
    }

    private void getContryCode() {
      //  custPrograssbar.prograssCreate(LoginActivity.this);
        JSONObject jsonObject = new JSONObject();
        RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<JsonObject> call = APIClient.getInterface().getCountry(bodyRequest);
//        GetResult getResult = new GetResult();
//        getResult.setMyListener(this);
//        getResult.callForLogin(call, "1");

    }

    private void chackUser() {
//        custPrograssbar.prograssCreate(LoginActivity.this);
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("mobile", edMobile.getText().toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
     //   RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
    //    Call<JsonObject> call = APIClient.getInterface().getCheckMobile(bodyRequest);
//        GetResult getResult = new GetResult();
//        getResult.setMyListener(this);
//        getResult.callForLogin(call, "2");

    }

    private void loginUser() {
        custPrograssbar.prograssCreate(LoginActivity.this);
        Call<CustomerResponse> call = APIClient.getInterface().login(edEmail.getText().toString(), edPassword.getText().toString());
        call.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                if (response.isSuccessful()) {
                    custPrograssbar.closePrograssBar();
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    CustomerResponse customerResponse = response.body();
                    if (customerResponse != null) {
                        // OneSignal.sendTag("userid", login.getUserLogin().getId());
                        // OneSignal.sendTag("userid", login.getResult());
                        sessionManager.setStringData(SessionManager.lats, "0");
                        sessionManager.setStringData(SessionManager.SELCTADDRESS, "0");
                        sessionManager.setUserDetails("", response.body().getData().get(0));
                        sessionManager.setBooleanData(SessionManager.login, true);
                        if (callfrom.equals("cart")){
                            startActivity(new Intent(LoginActivity.this, CartActivity.class));
                            finish();
                        }else if (callfrom.equals("upload")){
                            startActivity(new Intent(LoginActivity.this, UploadPrescriptionActivity.class));
                            finish();
                        }else
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            finish();
                        }
                }
                else {
                        custPrograssbar.closePrograssBar();
                        Toast.makeText(LoginActivity.this, "Email/Mobile No. or Password doesnot match.", Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @OnClick({R.id.txt_olduser, R.id.btn_proceed, R.id.txt_newuser1, R.id.txt_forgotclick})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_olduser:
                txtSingUp.setVisibility(View.GONE);
              //  lvlSingup.setVisibility(View.GONE);
                lvlLogin.setVisibility(View.VISIBLE);
                isNewuser = false;
                break;
            case R.id.btn_proceed:

//                if (isNewuser) {
//                    if (!TextUtils.isEmpty(edMobile.getText().toString())) {
//                        chackUser();
//                    } else {
//                        edMobile.setError("Enter Mobile Number");
//                    }
//                } else {
                    if (TextUtils.isEmpty(edEmail.getText().toString())) {
                        edEmail.setError("Enter Mobile / Email");
                    } else if (TextUtils.isEmpty(edPassword.getText().toString())) {
                        edPassword.setError("Enter Password");
                    } else {
                        loginUser();
                    }
//                }
                break;
            case R.id.txt_newuser1:

//                isNewuser = true;
//                txtSingUp.setVisibility(View.VISIBLE);
//                lvlSingup.setVisibility(View.VISIBLE);
//                lvlLogin.setVisibility(View.GONE);

                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
                break;
            case R.id.txt_forgotclick:
                startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
                break;
            default:
                break;
        }
    }

//    @Override
//    public void callback(JsonObject result, String callNo) {
//
//       try {


////            } else if (callNo.equalsIgnoreCase("2")) {
////                Gson gson = new Gson();
////                Register register = gson.fromJson(result.toString(), Register.class);
////                if (register.getResult().equalsIgnoreCase("true")) {
////                    Utility.isvarification = 1;
////                    startActivity(new Intent(LoginActivity.this, VerifyPhoneActivity.class).putExtra("code", codeSelect).putExtra("phone", edMobile.getText().toString()));
////
////
////                } else {
////                    Toast.makeText(LoginActivity.this, register.getResponseMsg(), Toast.LENGTH_SHORT).show();
////                    edEmail.setText("" + edMobile.getText().toString());
////                    isNewuser = false;
////                    txtSingUp.setVisibility(View.GONE);
////                    lvlSingup.setVisibility(View.GONE);
////                    lvlLogin.setVisibility(View.VISIBLE);
////                }
////
////
////            } else
//         //   if (callNo.equalsIgnoreCase("3")) {
//                Gson gson = new Gson();
//                Login login = gson.fromJson(result.toString(), Login.class);
//                if (login.getmResult() != null) {
////                    OneSignal.sendTag("userid", login.getUserLogin().getId());
////                    OneSignal.sendTag("userid", login.getResult());
//                    sessionManager.setStringData(SessionManager.lats, "0");
//                   sessionManager.setStringData(SessionManager.SELCTADDRESS, "0");
//                    sessionManager.setUserDetails("", login.getmResult().get(0));
//                    sessionManager.setBooleanData(SessionManager.login, true);
//                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                    finish();
//                }
//      //      }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//   }

    public void bottonVelidation() {
                BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
                View sheetView = getLayoutInflater().inflate(R.layout.custome_demo_layout, null);
                mBottomSheetDialog.setContentView(sheetView);
                mBottomSheetDialog.show();

            }
}