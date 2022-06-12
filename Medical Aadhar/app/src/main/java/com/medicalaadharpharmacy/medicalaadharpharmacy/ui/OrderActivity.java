package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.OrderHistory;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderHistory;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderHistoryResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.JsonObject;

import org.json.JSONObject;

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

import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.currency;

public class OrderActivity extends RootActivity{

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_actiontitle)
    TextView txtActionTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.txt_resent)
    TextView txtResent;
    @BindView(R.id.txt_delivered)
    TextView txtDelivered;
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;
    StaggeredGridLayoutManager gridLayoutManager;
    SessionManager sessionManager;
    User user;
    CustPrograssbar custPrograssbar;
    @BindView(R.id.txt_notfount)
    TextView txtNotFount;
    @BindView(R.id.lvl_notfound)
    LinearLayout lvlNotfound;
    ItemAdp itemAdp;
    List<OrderHistory> orderHistories = new ArrayList<>();
    List<OrderHistory> resent = new ArrayList<>();
    List<OrderHistory> delivery = new ArrayList<>();


    List<CustomerOrderHistory> delivery1 = new ArrayList<>();
    List<CustomerOrderHistory> xyz1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        custPrograssbar = new CustPrograssbar();

        sessionManager = new SessionManager(OrderActivity.this);
        user = sessionManager.getUserDetails("");
        gridLayoutManager = new StaggeredGridLayoutManager(1, 1);
        myRecyclerView.setLayoutManager(gridLayoutManager);

        Call<CustomerOrderHistoryResponse> call = APIClient.getInterface().getOrder(user.getId().toString());
        call.enqueue(new Callback<CustomerOrderHistoryResponse>() {
            @Override
            public void onResponse(Call<CustomerOrderHistoryResponse> call, Response<CustomerOrderHistoryResponse> response) {
                if (response.isSuccessful()){
                    custPrograssbar.closePrograssBar();
                    CustomerOrderHistoryResponse cusResponse = response.body();
                    lvlNotfound.setVisibility(View.GONE);
                 //   Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    List<CustomerOrderHistory> abc = new ArrayList<>();
                    abc = cusResponse.getData();
                    for (int i=0; i<abc.size(); i++){
                        if (abc.get(i).getIs_delivered().equals("0")){
                            xyz1.add(abc.get(i));
                        }else{
                            delivery1.add(abc.get(i));
                        }
                    }

                    dataset(xyz1);
                    lvlNotfound.setVisibility(View.GONE);
                    myRecyclerView.setVisibility(View.VISIBLE);
                    gridLayoutManager = new StaggeredGridLayoutManager(1, 1);
                    myRecyclerView.setLayoutManager(gridLayoutManager);
                    itemAdp = new ItemAdp(OrderActivity.this, xyz1);
                    myRecyclerView.setAdapter(itemAdp);
                }else {
                    custPrograssbar.closePrograssBar();
                    myRecyclerView.setVisibility(View.GONE);
                    lvlNotfound.setVisibility(View.VISIBLE);
                    txtNotFount.setText("Your orders will be displayed hear.");

                    Toast.makeText(getApplicationContext(),"No Orders Found",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerOrderHistoryResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
        getOrder();
    }

    @OnClick({R.id.img_back, R.id.txt_resent, R.id.txt_delivered})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.txt_resent:
                dataset(xyz1);
                txtResent.setTextColor(getResources().getColor(R.color.white));
                txtDelivered.setTextColor(getResources().getColor(R.color.black));
                txtResent.setBackground(getResources().getDrawable(R.drawable.orderbox));
                txtDelivered.setBackground(getResources().getDrawable(R.drawable.orderbox_white));
                break;
            case R.id.txt_delivered:
                dataset(delivery1);
                txtResent.setTextColor(getResources().getColor(R.color.black));
                txtDelivered.setTextColor(getResources().getColor(R.color.white));
                txtResent.setBackground(getResources().getDrawable(R.drawable.orderbox_white));
                txtDelivered.setBackground(getResources().getDrawable(R.drawable.orderbox));

                break;
            default:
                break;
        }
    }

    private void getOrder() {
        custPrograssbar.prograssCreate(OrderActivity.this);
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("uid", user.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
       // RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<CustomerOrderHistoryResponse> call = APIClient.getInterface().getOrder(user.getId().toString());
        call.enqueue(new Callback<CustomerOrderHistoryResponse>() {
            @Override
            public void onResponse(Call<CustomerOrderHistoryResponse> call, Response<CustomerOrderHistoryResponse> response) {
                if (response.isSuccessful()){
                    custPrograssbar.closePrograssBar();
                    CustomerOrderHistoryResponse cusResponse = response.body();
                    lvlNotfound.setVisibility(View.GONE);
               //     Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    List<CustomerOrderHistory> abc = new ArrayList<>();
                    abc = cusResponse.getData();
                    List<CustomerOrderHistory> xyz = new ArrayList<>();
                    List<CustomerOrderHistory> delivery = new ArrayList<>();
                    for (int i=0; i<abc.size(); i++){
                        if (abc.get(i).getIs_delivered().equals("0")){
                            xyz.add(abc.get(i));
                        }else{
                            delivery.add(abc.get(i));
                        }
                    }

//                    dataset(abc);
//                    lvlNotfound.setVisibility(View.GONE);
//                        myRecyclerView.setVisibility(View.VISIBLE);
//                        gridLayoutManager = new StaggeredGridLayoutManager(1, 1);
//                        myRecyclerView.setLayoutManager(gridLayoutManager);
//                        itemAdp = new ItemAdp(OrderActivity.this, xyz);
//                        myRecyclerView.setAdapter(itemAdp);





                }else {
                    myRecyclerView.setVisibility(View.GONE);
                    lvlNotfound.setVisibility(View.VISIBLE);
                    txtNotFount.setText("Your orders will be displayed hear.");
                    custPrograssbar.closePrograssBar();
                    Toast.makeText(getApplicationContext(),"Orders not found",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerOrderHistoryResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
//        GetResult getResult = new GetResult();
//        getResult.setMyListener(this);
//        getResult.callForLogin(call, "1");

    }

    public void getCancel(String oid) {
        custPrograssbar.prograssCreate(OrderActivity.this);
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("uid", user.getId());
//            jsonObject.put("order_id", oid);
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }

//        RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<CustomerOrderHistoryResponse> call = APIClient.getInterface().getOrderCancel(oid);
        call.enqueue(new Callback<CustomerOrderHistoryResponse>() {
            @Override
            public void onResponse(Call<CustomerOrderHistoryResponse> call, Response<CustomerOrderHistoryResponse> response) {
                if (response.isSuccessful()){
                    custPrograssbar.closePrograssBar();
                    CustomerOrderHistoryResponse cusResponse = response.body();
                    Toast.makeText(getApplicationContext(),"Order Cancelled",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Retry...Failed",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerOrderHistoryResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });
//        GetResult getResult = new GetResult();
//        getResult.setMyListener(this);
//        getResult.callForLogin(call, "2");

    }

//    @Override
//    public void callback(JsonObject result, String callNo) {
//        try {
//            custPrograssbar.closePrograssBar();
//            if (callNo.equalsIgnoreCase("1")) {
//                Gson gson = new Gson();
//                OrderH orderH = gson.fromJson(result.toString(), OrderH.class);
//                if (orderH.getResult().equalsIgnoreCase("true")) {
//                    orderHistories = orderH.getOrderHistory();
//                    resent = new ArrayList<>();
//                    delivery = new ArrayList<>();
//                    for (int i = 0; i < orderHistories.size(); i++) {
//                        if (orderHistories.get(i).getStatus().equalsIgnoreCase("Completed")) {
//                            delivery.add(orderHistories.get(i));
//                        } else {
//                            resent.add(orderHistories.get(i));
//                        }
//                    }
//                    dataset(resent);
//                } else {
//                    myRecyclerView.setVisibility(View.GONE);
//                    lvlNotfound.setVisibility(View.VISIBLE);
//                    txtNotFount.setText("Your orders will be displayed hear.");
//                }
//            } else if (callNo.equalsIgnoreCase("2")) {
//                Gson gson = new Gson();
//                RestResponse response = gson.fromJson(result.toString(), RestResponse.class);
//                if (response.getResult().equalsIgnoreCase("true")) {
//                    itemAdp.notifyDataSetChanged();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }

    public void dataset(List<CustomerOrderHistory> s) {

        if (s.size() != 0) {
            lvlNotfound.setVisibility(View.GONE);

            myRecyclerView.setVisibility(View.VISIBLE);
            gridLayoutManager = new StaggeredGridLayoutManager(1, 1);
            myRecyclerView.setLayoutManager(gridLayoutManager);
            itemAdp = new ItemAdp(OrderActivity.this, s);
            myRecyclerView.setAdapter(itemAdp);
        } else {
            myRecyclerView.setVisibility(View.GONE);
            lvlNotfound.setVisibility(View.VISIBLE);
            txtNotFount.setText("Your orders will be displayed hear.");
        }
    }

    public class ItemAdp extends RecyclerView.Adapter<ItemAdp.ViewHolder> {


        private LayoutInflater mInflater;
        Context mContext;
        List<CustomerOrderHistory> lists;

        public ItemAdp(Context context, List<CustomerOrderHistory> s) {
            this.mInflater = LayoutInflater.from(context);
            this.lists = s;
            this.mContext = context;
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.custome_orderitem, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int i) {

            CustomerOrderHistory history = lists.get(i);
          //  Toast.makeText(OrderActivity.this, history.getIs_verified().toString(), Toast.LENGTH_SHORT).show();
            if(history.getIs_verified().equals("1")){
             //   Toast.makeText(OrderActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                holder.txtCancel.setVisibility(View.GONE);
                holder.txtPay.setVisibility(View.VISIBLE);
            }

            if(history.getPayment_status().equals("PAID")){
                holder.txtPay.setVisibility(View.GONE);
            }


            if(history.getIs_verified().equals("0") && history.getIs_delivered().equals("0")){
               // Toast.makeText(OrderActivity.this, "Bye", Toast.LENGTH_SHORT).show();
                holder.txtPay.setVisibility(View.GONE);
                holder.txtCancel.setVisibility(View.VISIBLE);

            }

            if(history.getIs_delivered().equals("1")){
                //   Toast.makeText(OrderActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                holder.txtCancel.setVisibility(View.GONE);

            }
            holder.txtOrder.setText("" + history.getOrder_code());
            holder.txtOrderdate.setText("" + history.getOrder_date());
            holder.txtOrderstatus.setText("" + history.getPayment_status());
            holder.txtTotal.setText("₹ " + history.getGrand_total());
//            if (history.getStatus().equalsIgnoreCase("Pending")) {
//                holder.txtCancel.setVisibility(View.VISIBLE);
//            } else {
//                holder.txtCancel.setVisibility(View.INVISIBLE);
//
//            }
            holder.txtInfo.setOnClickListener(v ->
                    startActivity(new Intent(OrderActivity.this, OrderDetailsActivity.class).putExtra("oid", history.getOrder_code()).putExtra("grand_total",history.getGrand_total())));

            holder.txtPay.setOnClickListener(v ->
                    startActivity(new Intent(OrderActivity.this, PaymentOptionActivity.class).putExtra("oid", history.getOrder_code()).putExtra("grand_total",history.getGrand_total())));

            holder.txtCancel.setOnClickListener(v -> {
                AlertDialog myDelete = new AlertDialog.Builder(OrderActivity.this)
                        .setTitle("Order Cancel")
                        .setMessage("Are you sure you want to Order Cancel?")
                        .setPositiveButton("Yes", (dialog, whichButton) -> {
                            Log.d("sdj", "" + whichButton);
                            dialog.dismiss();
                            //history.setStatus("Cancelled");
                            lists.set(i, history);
                            getCancel(history.getOrder_code());
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            Log.d("sdj", "" + which);
                            dialog.dismiss();
                        })
                        .create();
                myDelete.show();

            });


        }

        @Override
        public int getItemCount() {
            return lists.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.txt_order)
            TextView txtOrder;
            @BindView(R.id.txt_total)
            TextView txtTotal;
            @BindView(R.id.txt_orderstatus)
            TextView txtOrderstatus;
            @BindView(R.id.txt_orderdate)
            TextView txtOrderdate;
            @BindView(R.id.txt_info)
            TextView txtInfo;
            @BindView(R.id.txt_cancel)
            TextView txtCancel;
            @BindView(R.id.txt_pay)
            TextView txtPay;

            ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

        }


    }
}