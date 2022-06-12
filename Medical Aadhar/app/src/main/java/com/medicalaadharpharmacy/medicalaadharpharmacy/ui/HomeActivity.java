package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.carteasy.v1.lib.Carteasy;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.fragment.CategoryFragment;
import com.medicalaadharpharmacy.medicalaadharpharmacy.fragment.HomeFragment;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.AddressList;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CartSession;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.FetchCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.DatabaseHelper;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.medicalaadharpharmacy.medicalaadharpharmacy.ui.AddressActivity.changeAddress;

import java.util.ArrayList;
import java.util.Map;

public class HomeActivity extends RootActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.txt_location)
    TextView txtLocation;
    public static HomeActivity homeActivity = null;
    public static TextView txtCountcard;
    User user;

    public static HomeActivity getInstance() {
        return homeActivity;
    }

    SessionManager sessionManager;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        sessionManager = new SessionManager(HomeActivity.this);
        helper = new DatabaseHelper(HomeActivity.this);
        homeActivity = HomeActivity.this;
        txtCountcard = findViewById(R.id.txt_countcard);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

       if(sessionManager.getUserDetails("")==null){
           txtLocation.setVisibility(View.GONE);
       }
//        if (sessionManager.getAddress() == null) {
//            startActivity(new Intent(HomeActivity.this, AddressActivity.class));
//        } else {
        //    setLocation(sessionManager.getAddress());
        //}
            openFragment(new HomeFragment());
            updateItem();
       // }
    }

    public void updateItem() {

        user = sessionManager.getUserDetails("");
        //user.getId();
        if(user!=null) {
            Call<FetchCartWebResponse> callFecthCart = APIClient.getInterface().getCartProducts(user.getId());
            callFecthCart.enqueue(new Callback<FetchCartWebResponse>() {
                @Override
                public void onResponse(Call<FetchCartWebResponse> call, Response<FetchCartWebResponse> response) {
                    if (response.isSuccessful()) {
                        txtCountcard.setText(response.body().getCount());
                    } else {
                        txtCountcard.setText("0");
                    }
                }

                @Override
                public void onFailure(Call<FetchCartWebResponse> call, Throwable t) {
                    txtCountcard.setText("0");
                }
            });
        }else{
            txtCountcard.setText("0");
        }

    }

    public void setLocation(AddressList location) {
        if (sessionManager.getAddress() == null) {
            txtLocation.setText("Select Address");

        } else {
            txtLocation.setText("Deliver to " + location.getAddress());

        }

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        item.setIcon(R.drawable.ic_home_black);
                        openFragment(new HomeFragment());
                        return true;
                    case R.id.navigation_medicine:
                        item.setIcon(R.drawable.ic_medicine_black);
                        openFragment(new CategoryFragment());
                        return true;
                    case R.id.navigation_prescription:
                        item.setIcon(R.drawable.ic_prescription_black);
                        startActivity(new Intent(HomeActivity.this, UploadPrescriptionActivity.class));

                        return true;
                    case R.id.navigation_notifications:
                        item.setIcon(R.drawable.ic_notification_black);
                        startActivity(new Intent(HomeActivity.this, NotificationActivity.class));


                        return true;
                    case R.id.navigation_setting:
                        item.setIcon(R.drawable.ic_setting_black);
                        startActivity(new Intent(HomeActivity.this, SettingActivity.class));
                        return true;
                    default:
                        break;
                }
                return false;
            };

    public void uploadPref(String isUpload) {
        if (!isUpload.equalsIgnoreCase("1")) {
            bottomNavigation.getMenu().removeItem(R.id.navigation_prescription);
        }
    }

    @OnClick({R.id.rlt_cart, R.id.lvl_actionsearch, R.id.txt_location})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlt_cart:
                startActivity(new Intent(HomeActivity.this, CartActivity.class));
                break;
            case R.id.lvl_actionsearch:
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                break;
            case R.id.txt_location:
                startActivity(new Intent(HomeActivity.this, AddressActivity.class));
                break;
            default:

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (changeAddress) {
            changeAddress = false;
            setLocation(sessionManager.getAddress());
            openFragment(new HomeFragment());

        }

        updateItem();
    }

    @Override
    public void onBackPressed() {

        FragmentManager fragment = getSupportFragmentManager();


        if (fragment.getBackStackEntryCount() > 1) {
            Fragment fragmentaa = getSupportFragmentManager().findFragmentById(R.id.container);
            if (fragmentaa instanceof HomeFragment && fragmentaa.isVisible()) {
                finish();
            } else {
                super.onBackPressed();
            }
        } else {
            //Nothing in the back stack, so exit
            finish();
        }
    }


}