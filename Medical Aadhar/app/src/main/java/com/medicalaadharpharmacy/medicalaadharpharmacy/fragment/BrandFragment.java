package com.medicalaadharpharmacy.medicalaadharpharmacy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;


public class BrandFragment extends Fragment  {


    @BindView(R.id.recycler_brand)
    RecyclerView recyclerBrand;
    User user;
    SessionManager sessionManager;
    CustPrograssbar custPrograssbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_brand, container, false);
        ButterKnife.bind(this, view);
        sessionManager = new SessionManager(getActivity());
        custPrograssbar = new CustPrograssbar();
        user = sessionManager.getUserDetails("");
        recyclerBrand.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerBrand.setItemAnimator(new DefaultItemAnimator());

        getBrand();
        return view;
    }

    private void getBrand() {
        custPrograssbar.prograssCreate(getActivity());
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("uid", user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<JsonObject> call = APIClient.getInterface().getBrand(bodyRequest);
//        GetResult getResult = new GetResult();
//        getResult.setMyListener(this);
//        getResult.callForLogin(call, "1");

    }

//    @Override
//    public void callback(JsonObject result, String callNo) {
//
//        try {
//            custPrograssbar.closePrograssBar();
//            if (callNo.equalsIgnoreCase("1")) {
//                Gson gson = new Gson();
//                AllBarand allBarand = gson.fromJson(result.toString(), AllBarand.class);
//                if (allBarand.getResult().equalsIgnoreCase("true")) {
//                    FeatureBrandAdapter featureBrandAdapter = new FeatureBrandAdapter(getActivity(), allBarand.getBrandData(), this, "viewall");
//                    recyclerBrand.setAdapter(featureBrandAdapter);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void onClickFeaturItem(String titel, String bid) {
//        HomeActivity.getInstance().openFragment(new BrandProductFragment().newInstance(titel, bid));
//
//    }
}