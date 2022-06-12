package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.GeneralSettings;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.GeneralSettingsResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.MostViewedResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProduct;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProductResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.about;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_actiontitle)
    TextView tatActionTiter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.txt_dscirtion)
    TextView tatDeception;
    SessionManager sessionManager;
    ArrayList<GeneralSettings> generalData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(AboutActivity.this);

        Call<GeneralSettingsResponse> gsCall = APIClient.getInterface().getGeneralSettings();
        gsCall.enqueue(new Callback<GeneralSettingsResponse>() {
            @Override

            public void onResponse(Call<GeneralSettingsResponse> call, Response<GeneralSettingsResponse> response) {
                if (response.isSuccessful()){
                    GeneralSettingsResponse gsResponse = response.body();
                    generalData = gsResponse.getData();
                      tatDeception.setText(Html.fromHtml(generalData.get(15).getValue()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            tatDeception.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
                        }

                }else{
                    Toast.makeText(AboutActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GeneralSettingsResponse> call, Throwable t) {
                Toast.makeText(AboutActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    @OnClick(R.id.img_back)
    public void onClick() {
        finish();
    }
}
