package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.uploadpref;

public class SettingActivity extends RootActivity {
    SessionManager sessionManager;
    User user;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txtfirstl)
    TextView txtfirstl;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_mob)
    TextView txtMob;
    @BindView(R.id.txt_copyr)
    TextView txtCopyr;
    @BindView(R.id.lvl_myprescription)
    LinearLayout lvlMyprescription;
    CustPrograssbar custPrograssbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        custPrograssbar = new CustPrograssbar();
        sessionManager = new SessionManager(SettingActivity.this);
        user = sessionManager.getUserDetails("");

        textView = findViewById(R.id.txt_copyr);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        if (user!=null){
            Call<CustomerResponse> call = APIClient.getInterface().getUserinfo(
                    user.getId());
            call.enqueue(new Callback<CustomerResponse>() {
                @Override
                public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                    if(response.isSuccessful()){
                        char first = response.body().getData().get(0).getFull_name().charAt(0);
                        txtfirstl.setText("" + first);

                        txtName.setText("" + response.body().getData().get(0).getFull_name());
                        txtMob.setText("" + response.body().getData().get(0).getMobile_number());
                    }
                    else{

                        txtName.setText("");
                        txtMob.setText("");
                    }
                }

                @Override
                public void onFailure(Call<CustomerResponse> call, Throwable t) {

                }
            });


        }
        else{
            LinearLayout lvl_change_password = (LinearLayout) findViewById(R.id.lvl_change_password);
            LinearLayout lvl_address = (LinearLayout) findViewById(R.id.lvl_address);
            LinearLayout lvl_order = (LinearLayout) findViewById(R.id.lvl_order);
            LinearLayout lvl_logot = (LinearLayout) findViewById(R.id.lvl_logot);

            lvl_change_password.setVisibility(View.GONE);
            lvl_address.setVisibility(View.GONE);
            lvl_order.setVisibility(View.GONE);
            lvl_logot.setVisibility(View.GONE);

            txtName.setText("Please Login");
            txtMob.setText("to see details");

        }
//        String sourceString = "Design Develop by <b>" + "SOLUTIONS TOUCH" + "</b> ";
//        txtCopyr.setText(Html.fromHtml(sourceString));
        if (sessionManager.getStringData(uploadpref).equalsIgnoreCase("1")) {
            lvlMyprescription.setVisibility(View.VISIBLE);
        } else {
            lvlMyprescription.setVisibility(View.GONE);

        }

    }

    @OnClick({R.id.img_back, R.id.lvl_order, R.id.lvl_myprescription, R.id.lvl_address,R.id.lvl_change_password, R.id.lvl_about, R.id.lvl_contect, R.id.lvl_privacy, R.id.lvl_teams, R.id.lvl_logot, R.id.lvl_edit,R.id.lvl_mylicences})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.lvl_order:
                startActivity(new Intent(SettingActivity.this, OrderActivity.class));
                break;
            case R.id.lvl_myprescription:
                startActivity(new Intent(SettingActivity.this, PrescriptionOrderActivity.class));
                break;
            case R.id.lvl_address:
                startActivity(new Intent(SettingActivity.this, AddressActivity.class));
                break;
            case R.id.lvl_change_password:
                startActivity(new Intent(SettingActivity.this, ChanegPasswordActivity.class));
                break;
            case R.id.lvl_about:
                startActivity(new Intent(SettingActivity.this, AboutActivity.class));
                break;
            case R.id.lvl_mylicences:
                Uri uri = Uri.parse("https://medicalaadhar.com/Home/drug_licences"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
               //startActivity(new Intent(SettingActivity.this, DrugLicencesActivity.class));
                break;

                case R.id.lvl_contect:
                startActivity(new Intent(SettingActivity.this, ContactActivity.class));
                break;
            case R.id.lvl_privacy:
                startActivity(new Intent(SettingActivity.this, PrivacyPolicyActivity.class));

                break;
            case R.id.lvl_teams:
                startActivity(new Intent(SettingActivity.this, TramandconditionActivity.class));
                break;
            case R.id.lvl_logot:
                sessionManager.logoutUser();
                intent = new Intent(SettingActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                break;
            case R.id.lvl_edit:
                if(user!=null){
                     startActivity(new Intent(SettingActivity.this, EditProfileActivity.class));

                }else{
                    startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                }

                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sessionManager != null) {
            user = sessionManager.getUserDetails("");
//            char first = user.getmFname().charAt(0);
          //  txtfirstl.setText("" + first);
            if (user != null) {
                txtName.setText("" + user.getmFname());
                txtMob.setText("" + user.getmMobile());
            }
        }
    }
}