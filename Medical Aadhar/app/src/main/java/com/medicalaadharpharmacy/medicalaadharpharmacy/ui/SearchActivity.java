package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.adepter.ProductAdapter;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.AddressList;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProduct;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProductResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class SearchActivity extends RootActivity{

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_notfound)
    ImageView imgNotfound;
    @BindView(R.id.ed_search)
    EditText edSearch;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.lvl_actionsearch)
    LinearLayout lvlActionsearch;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.recycler_product)
    RecyclerView recyclerProduct;

    @BindView(R.id.lvl_notfound)
    LinearLayout lvlNotfound;
    SessionManager sessionManager;
    CustPrograssbar custPrograssbar;
    AddressList address;
    ArrayList<SearchProduct> searchProductList = new ArrayList<>();
    private ProductAdapter.RecyclerTouchListener searchlistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        custPrograssbar = new CustPrograssbar();
        sessionManager = new SessionManager(SearchActivity.this);
        address=sessionManager.getAddress();
        recyclerProduct.setLayoutManager(new GridLayoutManager(SearchActivity.this, 2));
        recyclerProduct.setItemAnimator(new DefaultItemAnimator());

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                getSearch(edSearch.getText().toString());

            }
        });
    }

    private void getSearch(String keyword) {
        custPrograssbar.prograssCreate(SearchActivity.this);

        try {
            Call<SearchProductResponse> call = APIClient.getInterface().getSearch(keyword,"100","0");
            call.enqueue(new Callback<SearchProductResponse>() {
                @Override
                public void onResponse(Call<SearchProductResponse> call, Response<SearchProductResponse> response) {
                    if (response.isSuccessful()){

                       custPrograssbar.closePrograssBar();

                        SearchProductResponse searchProductResponse = response.body();
                        searchProductList = searchProductResponse.getData();
                        lvlNotfound.setVisibility(View.GONE);
                        recyclerProduct.setVisibility(View.VISIBLE);

                        ProductAdapter productAdapter = new ProductAdapter(SearchActivity.this, searchProductList, searchlistener);

                        recyclerProduct.setAdapter(productAdapter);
                    }else{
                        custPrograssbar.closePrograssBar();
                        recyclerProduct.setVisibility(View.GONE);
                        lvlNotfound.setVisibility(View.VISIBLE);
                        imgNotfound.setImageDrawable(getResources().getDrawable(R.drawable.ic_not_found));
                        Toast.makeText(SearchActivity.this, "Not Found", Toast.LENGTH_LONG).show();

                    }
                }
                @Override
                public void onFailure(Call<SearchProductResponse> call, Throwable t) {
                    custPrograssbar.closePrograssBar();
                    Log.d("Search Error",t.toString());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @OnClick({R.id.img_back, R.id.img_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_search:
                if (!edSearch.getText().toString().isEmpty()) {
                    getSearch(edSearch.getText().toString());
                }
                break;
            default:
                break;
        }
    }


//    @Override
//    public void callback(JsonObject result, String callNo) {
//        try {
//            custPrograssbar.closePrograssBar();
//            if (callNo.equalsIgnoreCase("1")) {
//                Gson gson = new Gson();
//                Search search = gson.fromJson(result.toString(), Search.class);
//                if (search.getResult().equalsIgnoreCase("true")) {
//                    if (search.getSearchData().size() != 0) {
//                        lvlNotfound.setVisibility(View.GONE);
//                        recyclerProduct.setVisibility(View.VISIBLE);
//                        ProductAdapter productAdapter = new ProductAdapter(SearchActivity.this, search.getSearchData(), this);
//                        recyclerProduct.setAdapter(productAdapter);
//                    } else {
//                        lvlNotfound.setVisibility(View.VISIBLE);
//                        Toast.makeText(SearchActivity.this, search.getResponseMsg(), Toast.LENGTH_LONG).show();
//                        imgNotfound.setImageDrawable(getResources().getDrawable(R.drawable.ic_not_found));
//                    }
//
//                } else {
//                    recyclerProduct.setVisibility(View.GONE);
//                    lvlNotfound.setVisibility(View.VISIBLE);
//                    imgNotfound.setImageDrawable(getResources().getDrawable(R.drawable.ic_not_found));
//                    Toast.makeText(SearchActivity.this, search.getResponseMsg(), Toast.LENGTH_LONG).show();
//
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

//    @Override
//    public void onClickProductItem(String titel, Medicine medicine) {
//        startActivity(new Intent(SearchActivity.this, ProductDetailsActivity.class).putExtra("MyClass", medicine).putParcelableArrayListExtra("PriceList", medicine.getProductInfo()).putStringArrayListExtra("ImageList", medicine.getProductImage()));
//    }
}