package com.medicalaadharpharmacy.medicalaadharpharmacy.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.adepter.CategoryAdapter;
import com.medicalaadharpharmacy.medicalaadharpharmacy.adepter.ProductAdapter;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.AddressList;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProduct;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProductResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.ui.HomeActivity;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.gson.JsonObject;


import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryFragment extends Fragment{
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    int start=0;
    int limit=10;
    @BindView(R.id.recycler_category)
    RecyclerView recyclerCategory;
    ProductAdapter productAdapter;
    User user;
    SessionManager sessionManager;
    CustPrograssbar custPrograssbar;
    AddressList address;
    ArrayList<SearchProduct> productList = new ArrayList<>();
    ProductAdapter.RecyclerTouchListener prtl;
    private int recyclerVisiblePosition;
    boolean isFirstTimeCall = true;
    String search_key="";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        sessionManager = new SessionManager(getActivity());
        custPrograssbar = new CustPrograssbar();
        user = sessionManager.getUserDetails("");
        address=sessionManager.getAddress();
        GridLayoutManager mLayoutManager;
        mLayoutManager=new GridLayoutManager(getActivity(), 2);
        recyclerCategory.setLayoutManager(mLayoutManager);
        recyclerCategory.setItemAnimator(new DefaultItemAnimator());

        Bundle data= getArguments();
        if(data!=null){
            search_key=data.getString("search_key");
        }
        getCategory(start,search_key);

//      start=10;
//      prevstart=10;


        recyclerCategory.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (isFirstTimeCall) {
                        isFirstTimeCall = false;

                            visibleItemCount = mLayoutManager.getChildCount();
                            totalItemCount = mLayoutManager.getItemCount();
                            pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();
                            Log.d("category_called","category_called");


                                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                                    loading = false;
                                    Log.v("...", "Last Item Wow !");

                                    start=start+limit;

                                    getCategory(start,search_key);
                                    loading = true;

                                }

                    }
                }

                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    isFirstTimeCall = true;
                }
            }

             @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy == 0 && dx==0) {
                    recyclerVisiblePosition = mLayoutManager.findLastVisibleItemPosition();
                }
            }

        });
       return view;

    }



    private void getCategory(int start,String search_key) {
        custPrograssbar.prograssCreate(getActivity());
        try {
            String demo=String.valueOf(start);
            Call<SearchProductResponse> call = APIClient.getInterface().getSearch(search_key,"10",demo);
            call.enqueue(new Callback<SearchProductResponse>() {
                @Override
                public void onResponse(Call<SearchProductResponse> call, Response<SearchProductResponse> response) {
                    if (response.isSuccessful()){
                        custPrograssbar.closePrograssBar();
                        SearchProductResponse searchProductResponse = response.body();
//                        productList = searchProductResponse.getData();
                        productList.addAll(searchProductResponse.getData());
                        productAdapter = new ProductAdapter(getActivity(), productList, prtl);
                        recyclerCategory.setAdapter(productAdapter);

                        recyclerCategory.scrollToPosition(start-limit+4);

                    }
                    else {
                        custPrograssbar.closePrograssBar();
                    }
                }
                @Override
                public void onFailure(Call<SearchProductResponse> call, Throwable t) {
                    custPrograssbar.closePrograssBar();
                    Log.d("All products",t.toString());
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
