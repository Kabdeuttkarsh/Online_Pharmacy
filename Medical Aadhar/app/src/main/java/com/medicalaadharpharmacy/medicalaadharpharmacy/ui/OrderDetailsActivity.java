package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.OrderProductDatum;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderDetails;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderDetailsResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderHistory;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderHistoryResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.OrderProducts;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.OrderProductsResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.text.DecimalFormat;
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

public class OrderDetailsActivity extends RootActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_actiontitle)
    TextView txtActionTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.txt_summary)
    TextView txtSummary;
    @BindView(R.id.txt_item)
    TextView txtItem;
    @BindView(R.id.txt_orderid)
    TextView txtOrderId;
    @BindView(R.id.txt_orderstatus)
    TextView txtOrderStatus;
    @BindView(R.id.txt_orderdate)
    TextView txtOrderDate;
    @BindView(R.id.txt_orderddate)
    TextView txtOrderDDate;
    @BindView(R.id.txt_paymentmethod)
    TextView txtPaymentMethod;
    @BindView(R.id.txt_qut)
    TextView txtQut;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.txt_deliverycharge)
    TextView txtDeliveryCharge;
    @BindView(R.id.txt_total)
    TextView txtTotal;
    @BindView(R.id.scv_summry)
    ScrollView schSummary;
    @BindView(R.id.scv_item)
    ScrollView scvItem;
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;
    StaggeredGridLayoutManager gridLayoutManager;
    CustPrograssbar custPrograssbar;
    SessionManager sessionManager;
    User user;
    String oid;
    @BindView(R.id.txt_address)
    TextView txtAddress;
    @BindView(R.id.txt_aditionalinfo)
    TextView txtAdditionInfo;
    @BindView(R.id.lvl_aditional)
    LinearLayout lvlAditional;

    List<CustomerOrderDetails> items = new ArrayList<>();
    List<CustomerOrderDetails> summery = new ArrayList<>();
    ItemAdp itemAdp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        oid = getIntent().getStringExtra("oid");
        custPrograssbar = new CustPrograssbar();
        sessionManager = new SessionManager(OrderDetailsActivity.this);
        user = sessionManager.getUserDetails("");
        gridLayoutManager = new StaggeredGridLayoutManager(1, 1);
        myRecyclerView.setLayoutManager(gridLayoutManager);
        getOrderHistiry();
    }

    private void getOrderHistiry() {
        custPrograssbar.prograssCreate(OrderDetailsActivity.this);

        Call<CustomerOrderDetailsResponse> call = APIClient.getInterface().getOrderHistory(oid.toString());
        call.enqueue(new Callback<CustomerOrderDetailsResponse>() {
            @Override
            public void onResponse(Call<CustomerOrderDetailsResponse> call, Response<CustomerOrderDetailsResponse> response) {
                if (response.isSuccessful()){
                    custPrograssbar.closePrograssBar();
                    CustomerOrderDetailsResponse cusResponse = response.body();
                    List<CustomerOrderDetails> abc = new ArrayList<>();
                    abc = cusResponse.getData();

                    txtOrderId.setText("" + oid);
                    txtOrderStatus.setText("" + abc.get(0).getDelivery_status());
                    txtOrderDate.setText("" + abc.get(0).getOrder_date());
                    txtPaymentMethod.setText("" + abc.get(0).getPayment_type());
//                    txtQut.setText(""+orderP.getOrderProductList().get(0).getOrderProductData().size());
                    txtPrice.setText("₹ "+abc.get(0).getGrand_total());
                    txtDeliveryCharge.setText("₹ "+abc.get(0).getShipping_charges());
//                   txtTotal.setText(sessionManager.getStringData(SessionManager.currency)  + orderP.getOrderProductList().get(0).getOrderTotal());
//
                    txtAddress.setText("" +abc.get(0).getShipping_customer_fill_name()+", "
                                          +abc.get(0).getShipping_address()+", "
                                          +abc.get(0).getShipping_address_2()+", "
                                          +abc.get(0).getShipping_city()+", "
                                          +abc.get(0).getShipping_state()+", "
                                          +abc.get(0).getShipping_country()+", "
                                          +abc.get(0).getShipping_pincode()+", "
                                          +abc.get(0).getShipping_phone()+", "
                                          +abc.get(0).getShipping_email()+", "
                                       );

                    Call<OrderProductsResponse> productscall = APIClient.getInterface().getOrderProducts(oid.toString());

                    productscall.enqueue(new Callback<OrderProductsResponse>() {
                        @Override
                        public void onResponse(Call<OrderProductsResponse> call, Response<OrderProductsResponse> response) {
                            if (response.isSuccessful()){
                                OrderProductsResponse proResponse = response.body();
                                List<OrderProducts> proList = new ArrayList<>();
                                proList = proResponse.getmOrderProductList();

                                myRecyclerView.setVisibility(View.VISIBLE);
                                gridLayoutManager = new StaggeredGridLayoutManager(1, 1);
                                myRecyclerView.setLayoutManager(gridLayoutManager);
                                itemAdp = new OrderDetailsActivity.ItemAdp(OrderDetailsActivity.this, proList);
                                myRecyclerView.setAdapter(itemAdp);

                            }else {
                                myRecyclerView.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(),"Failed Loading Order Products",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<OrderProductsResponse> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                        }
                    });



                }else {
                    myRecyclerView.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Failed Loading Order Details",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerOrderDetailsResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });


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
//                OrderP orderP = gson.fromJson(result.toString(), OrderP.class);
//                if (orderP.getResult().equalsIgnoreCase("true")) {
//                    txtOrderId.setText("" + oid);
//                    txtOrderStatus.setText("" + orderP.getOrderProductList().get(0).getOrderStatus());
//                    txtOrderDate.setText("" + orderP.getOrderProductList().get(0).getOrderDate());
//                    txtPaymentMethod.setText("" + orderP.getOrderProductList().get(0).getPMethodName());
//                    txtQut.setText(""+orderP.getOrderProductList().get(0).getOrderProductData().size());
//                    txtPrice.setText(sessionManager.getStringData(SessionManager.currency) + orderP.getOrderProductList().get(0).getOrderSubTotal());
//                    txtDeliveryCharge.setText(sessionManager.getStringData(SessionManager.currency)  + orderP.getOrderProductList().get(0).getDeliveryCharge());
//                    txtTotal.setText(sessionManager.getStringData(SessionManager.currency)  + orderP.getOrderProductList().get(0).getOrderTotal());
//
//                    txtAddress.setText("" + orderP.getOrderProductList().get(0).getCustomerAddress());
//                    if (orderP.getOrderProductList().get(0).getAdditionalNote().equalsIgnoreCase("")) {
//                        lvlAditional.setVisibility(View.GONE);
//                    }else {
//                        lvlAditional.setVisibility(View.VISIBLE);
//                    }
//                    txtAdditionInfo.setText("" + orderP.getOrderProductList().get(0).getAdditionalNote());
//
//                    ItemAdp itemAdp = new ItemAdp(OrderDetailsActivity.this, orderP.getOrderProductList().get(0).getOrderProductData());
//                    myRecyclerView.setAdapter(itemAdp);
//                }
//            }
//        } catch (Exception e) {
//            Log.e("Error", "-->" + e.toString());
//        }
//
//    }

    @OnClick({R.id.img_back, R.id.txt_summary, R.id.txt_item})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.txt_summary:
                txtSummary.setTextColor(getResources().getColor(R.color.white));
                txtItem.setTextColor(getResources().getColor(R.color.black));
                txtSummary.setBackground(getResources().getDrawable(R.drawable.orderbox));
                txtItem.setBackground(getResources().getDrawable(R.drawable.orderbox_white));
                schSummary.setVisibility(View.VISIBLE);
                scvItem.setVisibility(View.GONE);
                break;
            case R.id.txt_item:
                txtSummary.setTextColor(getResources().getColor(R.color.black));
                txtItem.setTextColor(getResources().getColor(R.color.white));
                txtSummary.setBackground(getResources().getDrawable(R.drawable.orderbox_white));
                txtItem.setBackground(getResources().getDrawable(R.drawable.orderbox));
                schSummary.setVisibility(View.GONE);
                scvItem.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }


    public class ItemAdp extends RecyclerView.Adapter<ItemAdp.ViewHolder> {


        private List<OrderProducts> mData;
        private LayoutInflater mInflater;
        Context mContext;


        public ItemAdp(Context context, List<OrderProducts> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
            this.mContext = context;
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.custome_myitem, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int i) {
            OrderProducts productDatum = mData.get(i);
            if(productDatum.getProductImage().isEmpty()){
                Glide.with(mContext).load(APIClient.baseUrl + "/uploads/products/default.jpg").thumbnail(Glide.with(mContext).load(R.drawable.ezgifresize)).into(holder.imgIcon);
            }else{
                Glide.with(mContext).load(APIClient.baseUrl + "/uploads/products/" + productDatum.getProductImage()).thumbnail(Glide.with(mContext).load(R.drawable.ezgifresize)).into(holder.imgIcon);
            }
            if (productDatum.getProductDiscount().equalsIgnoreCase("0")) {
                holder.lvlOffer.setVisibility(View.GONE);
                holder.txtDscount.setVisibility(View.GONE);
                holder.txtcount.setText("Qty " + productDatum.getProductQuantity() + "  ");
                holder.txtPrice.setText("₹ " + productDatum.getProductPrice());
//
                holder.txtTitle.setText("" + productDatum.getProductName());
            }
            else {
                holder.lvlOffer.setVisibility(View.VISIBLE);
                holder.txtDscount.setVisibility(View.VISIBLE);
                double res = (Double.parseDouble(productDatum.getProductPrice()) * Double.parseDouble(productDatum.getProductDiscount())) / 100;
                res = Double.parseDouble(productDatum.getProductPrice()) - res;
                holder.txtDscount.setPaintFlags(holder.txtDscount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                holder.txtDscount.setText("₹ "+ productDatum.getProductPrice() + "  ");

                holder.txtOffer.setText(productDatum.getProductDiscount() + "% OFF");
                holder.txtcount.setText("Qty " + productDatum.getProductQuantity() + "  ");
                holder.txtPrice.setText("₹ "+ new DecimalFormat("##.##").format(res));
                holder.txtTitle.setText("" + productDatum.getProductName());
//
            }


        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.img_icon)
            ImageView imgIcon;
            @BindView(R.id.txt_title)
            TextView txtTitle;
            @BindView(R.id.txt_ptype)
            TextView txtPtype;
            @BindView(R.id.txt_dscount)
            TextView txtDscount;
            @BindView(R.id.txtcount)
            TextView txtcount;
            @BindView(R.id.txt_price)
            TextView txtPrice;
            @BindView(R.id.txt_offer)
            TextView txtOffer;
            @BindView(R.id.lvl_offer)
            LinearLayout lvlOffer;

            ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

        }


    }

}