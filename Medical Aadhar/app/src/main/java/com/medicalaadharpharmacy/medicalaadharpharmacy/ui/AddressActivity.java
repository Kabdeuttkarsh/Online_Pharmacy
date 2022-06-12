package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.lats;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.locationpick.LocationGetActivity;
import com.medicalaadharpharmacy.medicalaadharpharmacy.locationpick.MapUtility;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerAddress;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerAddressResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.Utility;
import com.google.android.material.appbar.AppBarLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressActivity extends RootActivity{


    @BindView(R.id.lvl_myaddress)
    LinearLayout lvlMyAddress;

    SessionManager sessionManager;
    User user;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_actiontitle)
    TextView txtActionTitle;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    LinearLayoutManager layoutManager;
    public static boolean changeAddress = false;
    ArrayList<CustomerAddress> customerAddresses = new ArrayList<>();

    CustPrograssbar custPrograssbar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        custPrograssbar = new CustPrograssbar();
        sessionManager = new SessionManager(AddressActivity.this);
        user = sessionManager.getUserDetails("");
        layoutManager = new LinearLayoutManager(AddressActivity.this, LinearLayoutManager.VERTICAL, false);
        myRecyclerView.setLayoutManager(layoutManager);
        requestPermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        final LocationManager manager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER) && Utility.hasGPSDevice(AddressActivity.this)) {
            Toast.makeText(AddressActivity.this, "Gps not enabled", Toast.LENGTH_SHORT).show();
            Utility.enableLoc(AddressActivity.this);
        }
        getAddress();
    }

    private void getAddress() {
        custPrograssbar.prograssCreate(AddressActivity.this);
        JSONObject jsonObject = new JSONObject();
        try {
            Log.d("uid",user.getId());
            Call<CustomerAddressResponse> call = APIClient.getInterface().getAddress(user.getId());
            call.enqueue(new Callback<CustomerAddressResponse>() {
                @Override
                public void onResponse(Call<CustomerAddressResponse> call, Response<CustomerAddressResponse> response) {
                    if (response.isSuccessful()){
                     //   Toast.makeText(getApplicationContext(),"Success in Loading Address",Toast.LENGTH_LONG).show();

                        custPrograssbar.closePrograssBar();
                        CustomerAddressResponse  caResponse = response.body();
                        customerAddresses = caResponse.getAddresses();
                        lvlMyAddress.setVisibility(View.VISIBLE);
                        AdepterAddress adepterAddress = new AdepterAddress(AddressActivity.this, customerAddresses);
                        myRecyclerView.setAdapter(adepterAddress);
                    }else{
                       lvlMyAddress.setVisibility(View.GONE);
                        custPrograssbar.closePrograssBar();
                        Toast.makeText(getApplicationContext(),"Address Not available",Toast.LENGTH_LONG).show();

                    }
                }

                @Override
                public void onFailure(Call<CustomerAddressResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

                    lvlMyAddress.setVisibility(View.GONE);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @OnClick({R.id.lvl_clocation, R.id.lvl_myaddress, R.id.img_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lvl_clocation:

                startActivity(new Intent(AddressActivity.this, LocationGetActivity.class)
                        .putExtra(MapUtility.latitude, 0.0)
                        .putExtra(MapUtility.longitude, 0.0)
                        .putExtra("landmark","")
                        .putExtra("hno", "")
                        .putExtra("atype", "permanent")
                        .putExtra("newuser", "curruntlat")
                        .putExtra("userid", "0")
                        .putExtra("aid", "0"));
                break;
            case R.id.lvl_myaddress:
                break;
            case R.id.img_back:
                if (!sessionManager.getStringData(lats).equalsIgnoreCase("")) {
                    finish();

                }
                break;
            default:
                break;
        }
    }


    public class AdepterAddress extends RecyclerView.Adapter<AdepterAddress.BannerHolder> {
        private Context context;
        private List<CustomerAddress> addressLists;

        public AdepterAddress(Context context, List<CustomerAddress> mBanner) {
            this.context = context;
            this.addressLists = mBanner;
        }

        @NonNull
        @Override
        public BannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_addresss_item, parent, false);
            return new BannerHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BannerHolder holder, int position) {

            if (addressLists.get(position).getIs_default().equals("Y")){
                holder.txtType.setText("Permanent");
            }else{
                holder.txtType.setText("Local Address");
            }
            holder.txtHomeaddress.setText(addressLists.get(position).getLand_mark()+" "
            +addressLists.get(position).getCity()+" "+
             addressLists.get(position).getState()+" "+
            addressLists.get(position).getCountry()+" "+
            addressLists.get(position).getPincode());
            Glide.with(context).load(APIClient.baseUrl +"/uploads/address.png").thumbnail(Glide.with(context).load(R.drawable.ezgifresize)).centerCrop().into(holder.imgBanner);
            holder.lvlHome.setOnClickListener(v -> {

            });
            holder.imgMenu.setOnClickListener(v -> {
                PopupMenu popup = new PopupMenu(context, holder.imgMenu);
                popup.inflate(R.menu.address_menu);
                popup.setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.menu_select:
                            changeAddress = true;
                            sessionManager.setIntData("position", position);
                            sessionManager.setAddress(addressLists.get(position));
                            sessionManager.setStringData("session_address_id",addressLists.get(position).getC_addresses_id());
                            finish();
                            break;
                        case R.id.menu_edit:

                            startActivity(new Intent(AddressActivity.this, LocationGetActivity.class)
                                    .putExtra(MapUtility.latitude, addressLists.get(position).getLat())
                                    .putExtra(MapUtility.longitude, addressLists.get(position).getLag())
                                    .putExtra("atype", "Local")
                                    .putExtra("landmark", addressLists.get(position).getLand_mark())
                                    .putExtra("hno", addressLists.get(position).getHno())
                                    .putExtra("newuser", "update")
                                    .putExtra("userid", user.getId())
                                    .putExtra("aid", addressLists.get(position).getC_addresses_id())
                                    .putExtra("pincode", addressLists.get(position).getPincode())
                                    .putExtra("city", addressLists.get(position).getCity())
                                    .putExtra("state", addressLists.get(position).getState())
                                    .putExtra("country", addressLists.get(position).getCountry())
                                    .putExtra("pincode", addressLists.get(position).getPincode())
                                    .putExtra("address", addressLists.get(position).getAddresses())
                            );

                            break;
                        default:
                            break;
                    }
                    return false;
                });
                popup.show();
            });

        }

        @Override
        public int getItemCount() {
            return addressLists.size();
        }

        public class BannerHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.img_banner)
            ImageView imgBanner;
            @BindView(R.id.img_menu)
            ImageView imgMenu;
            @BindView(R.id.txt_homeaddress)
            TextView txtHomeaddress;
            @BindView(R.id.txt_tital)
            TextView txtType;
            @BindView(R.id.lvl_home)
            LinearLayout lvlHome;

            public BannerHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (sessionManager != null) {
            getAddress();
        }
    }

    @Override
    public void onBackPressed() {
        if (!sessionManager.getStringData(lats).equalsIgnoreCase("")) {
            super.onBackPressed();
        }
    }
}
