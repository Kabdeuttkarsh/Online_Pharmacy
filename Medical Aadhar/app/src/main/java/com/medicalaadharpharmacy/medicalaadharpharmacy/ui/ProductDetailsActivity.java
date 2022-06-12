package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.carteasy.v1.lib.Carteasy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.adepter.ProductHomeAdapter;
import com.medicalaadharpharmacy.medicalaadharpharmacy.adepter.SuggestedAdapter;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.Medicine;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.ProductPrice;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.AddCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CartResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CartSession;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerAddressResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.FetchCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.Suggested;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SuggestedResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.DatabaseHelper;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.MyCart;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductDetailsActivity extends RootActivity {
    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.recycler_suggested)
    RecyclerView recyclerSuggested;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.txt_item_offer)
    TextView txtItemOffer;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.txt_countcard)
    TextView txtCountcard;
    @BindView(R.id.txt_offer)
    TextView txtOffer;
    @BindView(R.id.lvl_offer)
    LinearLayout lvlOffer;
    @BindView(R.id.lvl_addcart)
    LinearLayout lvlAddcart;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.txt_brandname)
    TextView txtBrandname;
    @BindView(R.id.btn_addtocart)
    TextView btnAddtocart;
    @BindView(R.id.txt_priceone)
    TextView txtPriceone;
    @BindView(R.id.lvl_spineer)
    LinearLayout lvlSpineer;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_schedule)
    TextView txtSchedule;
    @BindView(R.id.txt_manufacturer)
    TextView txtManufacturer;
    @BindView(R.id.txt_composition)
    TextView txtComposition;
    @BindView(R.id.txt_packing_type)
    TextView txtPackingType;
    @BindView(R.id.txt_packaging)
    TextView txtPackaging;
    @BindView(R.id.txt_add_cart)
    TextView txtAddCart;
    @BindView(R.id.rx_required_text)
    TextView rxRequiredText;

    SuggestedAdapter suggestedAdapter;
    private SuggestedAdapter.RecyclerTouchListener sglistener;
    ArrayList<Suggested> suggestedArrayList = new ArrayList<>();
    ArrayList<String> productImage = new ArrayList<>();
    private ArrayList<ProductPrice> productInfo = new ArrayList<>();
    SessionManager sessionManager;
    User user;
    DatabaseHelper helper;
    String manufacturer;
    String composition;
    String packing_type;
    String packaging;
    String schedule;
    String product_name;
    String mrp;
    String discounted_price;
    String product_id;
    String discounted_percentage;
    String customer_id;
    String shipping_price;
    CustPrograssbar custPrograssbar;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ButterKnife.bind(this);
        helper = new DatabaseHelper(ProductDetailsActivity.this);
        sessionManager = new SessionManager(ProductDetailsActivity.this);
        custPrograssbar = new CustPrograssbar();
        user = sessionManager.getUserDetails("");
        if (user != null){
        customer_id = user.getId();
        }else {
            customer_id = "0";
        }
        manufacturer = getIntent().getExtras().getString("manufacturer");
        composition = getIntent().getExtras().getString("composition");
        packing_type = getIntent().getExtras().getString("packing_type");
        packaging = getIntent().getExtras().getString("packaging");
        schedule = getIntent().getExtras().getString("schedule");
        product_name = getIntent().getExtras().getString("product_name");
        mrp = getIntent().getExtras().getString("mrp");
        discounted_price = getIntent().getExtras().getString("discounted_price");
        product_id = getIntent().getExtras().getString("product_id");
        discounted_percentage = getIntent().getExtras().getString("discounted_percentage");
        shipping_price = getIntent().getExtras().getString("shipping_price");

        if(schedule.equals("OTC")){
            rxRequiredText.setText("Not Required");
            rxRequiredText.setTextColor(Color.GREEN);
        }
        else{
            rxRequiredText.setText("Required");
            rxRequiredText.setTextColor(Color.RED);
        }

       productImage = getIntent().getStringArrayListExtra("ImageList");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtDesc.setText(Html.fromHtml(" ", Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtDesc.setText(Html.fromHtml(" "));
        }


        Carteasy carteasy =new Carteasy();
        Map<Integer, Map> data;
        data = carteasy.ViewAll(getApplicationContext());
        txtCountcard.setText(String.valueOf(data.size()));

        txtTitle.setText("" +product_name);
        txtBrandname.setText("" + manufacturer);
        txtSchedule.setText(""+schedule);
        txtManufacturer.setText(""+manufacturer);
        txtComposition.setText(""+composition);
        txtPackingType.setText(""+packing_type);
        txtPackaging.setText(""+packaging);
        lvlOffer.setVisibility(View.VISIBLE);
        txtItemOffer.setVisibility(View.VISIBLE);
        txtOffer.setText(discounted_percentage + "% OFF");
        txtPrice.setText("₹ "+discounted_price);
        txtItemOffer.setText("₹ "+mrp);
        txtItemOffer.setPaintFlags(txtItemOffer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(ProductDetailsActivity.this);
        mLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager1);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        BannerAdapter bannerAdapter = new BannerAdapter(ProductDetailsActivity.this, productImage);
        recyclerView.setAdapter(bannerAdapter);
        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(this);
        mLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerSuggested.setLayoutManager(mLayoutManager2);
        recyclerSuggested.setItemAnimator(new DefaultItemAnimator());
        getSuggested(product_id);
        txtAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(customer_id,product_id);
            }
        });
    }

    public void getSuggested(String product_id){
        Call<SuggestedResponse> call = APIClient.getInterface().getSuggested(product_id);
        call.enqueue(new Callback<SuggestedResponse>() {
            @Override
            public void onResponse(Call<SuggestedResponse> call, Response<SuggestedResponse> response) {
                if (response.isSuccessful()){
                    SuggestedResponse suggestedResponse = response.body();
                    suggestedArrayList = suggestedResponse.getSuggestedArrayList();
                    suggestedAdapter = new SuggestedAdapter(getApplicationContext(), suggestedArrayList, sglistener);
                    recyclerSuggested.setAdapter(suggestedAdapter);
                }else{
                }
            }

            @Override
            public void onFailure(Call<SuggestedResponse> call, Throwable t) {
                Log.d("Error in suggested",t.toString());
            }
        });
                }

                public void addToCart(String customer_id, String product_id) {
                    custPrograssbar.prograssCreate(ProductDetailsActivity.this);

                        Call<AddCartWebResponse> call = APIClient.getInterface().addcartWeb(user.getId(),product_id);

                        call.enqueue(new Callback<AddCartWebResponse>() {
                            @Override
                            public void onResponse(Call<AddCartWebResponse> call, Response<AddCartWebResponse> response) {
                             if (response.isSuccessful()){
                                 custPrograssbar.closePrograssBar();
                                 Toast.makeText(getApplicationContext(), "Added to Cart", Toast.LENGTH_LONG).show();
                                 updateItem(response.body().getCart_count());
                             }else{
                                 custPrograssbar.closePrograssBar();
                                 Toast.makeText(getApplicationContext(), "Already in Cart", Toast.LENGTH_LONG).show();

                             }

                            }

                            @Override
                            public void onFailure(Call<AddCartWebResponse> call, Throwable t) {
                                custPrograssbar.closePrograssBar();
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

                            }
                        });

                    }

    @OnClick({R.id.img_back, R.id.rlt_cart, R.id.btn_addtocart})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_addtocart:
                if(user!=null) {
                    addToCart(customer_id, product_id);
                }else{
                    Toast.makeText(getApplicationContext(), "Please Login.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ProductDetailsActivity.this, LoginActivity.class);
                    intent.putExtra("call","cart");
                    startActivity(intent);
                }
                break;
            case R.id.rlt_cart:
                if(user!=null) {
                    startActivity(new Intent(ProductDetailsActivity.this, CartActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please Login.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ProductDetailsActivity.this, LoginActivity.class);
                    intent.putExtra("call","cart");
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }


    public void updateItem(String count) {

        txtCountcard.setText(count);
    }

    public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerHolder> {
        private Context context;
        private List<String> mBanner;

        public BannerAdapter(Context context, List<String> mBanner) {
            this.context = context;
            this.mBanner = mBanner;
        }

        @NonNull
        @Override
        public BannerAdapter.BannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
            return new BannerAdapter.BannerHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BannerHolder holder, int position) {
            Glide.with(context).load(APIClient.baseUrl + "/uploads/products/" + mBanner.get(position)).thumbnail(Glide.with(context).load(R.drawable.ezgifresize)).centerCrop().into(holder.imgBanner);
            holder.imgBanner.setOnClickListener(view -> {
                Dialog dialog = new Dialog(context,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
                dialog.setContentView(R.layout.item_imageview);
                TouchImageView imageView = dialog.findViewById(R.id.imageView);
                Picasso.get().load(APIClient.baseUrl + "/uploads/products/" + mBanner.get(position)).into(imageView);
                dialog.show();
            });
        }

        @Override
        public int getItemCount() {

            return mBanner.size();

        }

        public class BannerHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.img_banner)
            ImageView imgBanner;

            public BannerHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (txtCountcard != null) {
            Call<FetchCartWebResponse> callFecthCart = APIClient.getInterface().getCartProducts(customer_id);
            callFecthCart.enqueue(new Callback<FetchCartWebResponse>() {
                @Override
                public void onResponse(Call<FetchCartWebResponse> call, Response<FetchCartWebResponse> response) {
                    if(response.isSuccessful()){
                        updateItem(response.body().getCount());
                    }else{
                        updateItem("0");
                    }
                }

                @Override
                public void onFailure(Call<FetchCartWebResponse> call, Throwable t) {
                    updateItem("0");
                }
            });


        }
    }
}
