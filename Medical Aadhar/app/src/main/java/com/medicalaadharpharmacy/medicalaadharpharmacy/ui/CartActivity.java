package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.carteasy.v1.lib.Carteasy;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CartSession;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CartSessionResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.FetchCartWeb;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.FetchCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.MyAddress;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.MyAddressResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.QtyMinusCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.QtyPlusCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.RemoveCartWebResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.DatabaseHelper;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.appbar.AppBarLayout;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.medicalaadharpharmacy.medicalaadharpharmacy.ui.AddressActivity.changeAddress;
import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.coupon;

public class CartActivity extends RootActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_actiontitle)
    TextView txtActionTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;
    @BindView(R.id.img_coopncode)
    ImageView imgCoupnCode;
    @BindView(R.id.ed_customnot)
    EditText edCustom;
    @BindView(R.id.txt_address)
    TextView txtAddress;
    @BindView(R.id.txt_changeadress)
    TextView tatChangeless;
    @BindView(R.id.btn_proceed)
    TextView btnProceed;
    StaggeredGridLayoutManager gridLayoutManager;
    List<CartSession> myCartList = new ArrayList<>();
    ArrayList<String> id_list;
    DatabaseHelper databaseHelper;
    @BindView(R.id.txt_itemtotal)
    TextView txtItemTotal;
    @BindView(R.id.txt_dcharge)
    TextView txtDCharge;
    @BindView(R.id.txt_Discount)
    TextView txtDiscount;
    @BindView(R.id.txt_topay)
    TextView txtToPay;
    @BindView(R.id.txt_atype)
    TextView txtAType;
    SessionManager sessionManager;
    User user;
    ArrayList<CartSession> getCart;

    double total = 0;
    double subtotal = 0;
    @BindView(R.id.lvl_main)
    LinearLayout lvlMain;
    @BindView(R.id.lvl_notfound)
    LinearLayout lvlNotFound;
    CustPrograssbar custPrograssbar;
    String finalAdd;
    String rx_required;
    Double finalDis = 0.0;
    Double finalDel = 0.0;
    Double finelIT = 0.0;
    Double finelpay = 0.0;
    ItemAdp itemAdp;
    String customer_id;


    List<FetchCartWeb> xyz1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(CartActivity.this);
        sessionManager.setIntData(coupon, 0);
        custPrograssbar = new CustPrograssbar();
        databaseHelper = new DatabaseHelper(CartActivity.this);
        gridLayoutManager = new StaggeredGridLayoutManager(1, 1);
        myRecyclerView.setLayoutManager(gridLayoutManager);
        user = sessionManager.getUserDetails("");

        if (user != null){
            customer_id = user.getId();
        }else {
            customer_id = "0";
        }

        getAddress();
        custPrograssbar.prograssCreate(CartActivity.this);
        Call<FetchCartWebResponse> callFecthCart = APIClient.getInterface().getCartProducts(customer_id);
        callFecthCart.enqueue(new Callback<FetchCartWebResponse>() {
            @Override
            public void onResponse(Call<FetchCartWebResponse> call, Response<FetchCartWebResponse> response) {
                if (response.isSuccessful()){
                    custPrograssbar.closePrograssBar();
                    lvlNotFound.setVisibility(View.GONE);
                    lvlMain.setVisibility(View.VISIBLE);

                    FetchCartWebResponse fetchCartResp = response.body();
                    List<FetchCartWeb> abc = new ArrayList<>();
                    abc = fetchCartResp.getData();

                    if(abc!=null) {
                        for (int i = 0; i < abc.size(); i++) {
                            xyz1.add(abc.get(i));
                        }

                    itemAdp = new ItemAdp(CartActivity.this, xyz1);
                    myRecyclerView.setAdapter(itemAdp);

                    if(response.body().getRx_required().equals("Y")){
                        rx_required="Y";
                    }

                    }
                    else{
                        custPrograssbar.closePrograssBar();
                        lvlNotFound.setVisibility(View.VISIBLE);
                        lvlMain.setVisibility(View.GONE);

                    }
                }
                else{
                    custPrograssbar.closePrograssBar();
                    lvlNotFound.setVisibility(View.VISIBLE);
                    lvlMain.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<FetchCartWebResponse> call, Throwable t) {
                custPrograssbar.closePrograssBar();
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });


    }
    private void getAddress() {
        custPrograssbar.prograssCreate(CartActivity.this);
        Call<MyAddressResponse> call = APIClient.getInterface().getDefaultAddress(customer_id, sessionManager.getStringData("session_address_id"));

        call.enqueue(new Callback<MyAddressResponse>() {
            @Override
            public void onResponse(Call<MyAddressResponse> call, Response<MyAddressResponse> response) {
            custPrograssbar.closePrograssBar();
                if (response.isSuccessful()) {
                    MyAddressResponse myAddressResponse = response.body();
                    List<MyAddress> myAddresses = myAddressResponse.getBanners();
                    finalAdd = myAddresses.get(0).getAddresses() + " "
                            + myAddresses.get(0).getLand_mark() + " "
                            + myAddresses.get(0).getCity() + " "
                            + myAddresses.get(0).getState() + " "
                            + myAddresses.get(0).getCountry() + " "
                            + myAddresses.get(0).getPincode();
                    //   Log.d("Final",address.getAddress());
                    txtAddress.setText(finalAdd);
                    txtAType.setText("Delivery Address");
                } else {
                    txtAddress.setText("Please Change Address");
                }
            }


            @Override
            public void onFailure(Call<MyAddressResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public class ItemAdp extends RecyclerView.Adapter<ItemAdp.ViewHolder> {
        final int[] count = {0};
        int qnt = 1;
        double[] totalAmount = {0};
        private List<FetchCartWeb> mData;
        private LayoutInflater mInflater;
        Context mContext;
        SessionManager sessionManager;
        DatabaseHelper helper;

        public ItemAdp(Context context, List<FetchCartWeb> data) {

            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
            this.mContext = context;
            sessionManager = new SessionManager(CartActivity.this);
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.custome_mycard, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int i) {

               if(String.valueOf(mData.get(i).getSchedule()).equals("OTC")){
                   holder.rxRequiredText.setText("");
               }
               else{
                   holder.rxRequiredText.setText("Prescription Required Medicine");
               }

                holder.txtPrice.setText("₹ " +String.valueOf(Double.parseDouble(mData.get(i).getPrice())));
                holder.txtDscount.setPaintFlags(holder.txtDscount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                holder.txtDscount.setText(String.valueOf(Double.parseDouble(mData.get(i).getMrp())));
                holder.lvlOffer.setVisibility(View.VISIBLE);
                holder.txtOffer.setText(mData.get(i).getDiscounted_percentage()+ "% OFF ");
                Glide.with(mContext).load(APIClient.baseUrl + "/uploads/products/" +mData.get(i).getImg()).thumbnail(Glide.with(mContext).load(R.drawable.ezgifresize)).centerCrop().into(holder.imgIcon);
                holder.txtTitle.setText(mData.get(i).getName());
                holder.txtPtype.setText("Regular");
                if (sessionManager.getIntData(coupon) != 0) {
                        imgCoupnCode.setImageResource(R.drawable.ic_cancel_coupon);
                } else {
                   imgCoupnCode.setImageResource(R.drawable.ic_apply_coupon);
                }

            finalDel   = finalDel   + Double.parseDouble(mData.get(i).getShiping_cost());
            finalDis = finalDis + Double.parseDouble(mData.get(i).getMrp()) - (Double.parseDouble(mData.get(i).getPrice()));
            finalDis = finalDis * Double.parseDouble(mData.get(i).getQty());
            finelpay  = finelpay  + (Double.parseDouble(mData.get(i).getPrice())*Double.parseDouble(mData.get(i).getQty())) +  Double.parseDouble(mData.get(i).getShiping_cost());
            finelIT  = finelIT  + ( Double.parseDouble(mData.get(i).getMrp())* Double.parseDouble(mData.get(i).getQty())) ;
            Log.d("finelpay",String.valueOf(finelpay));
            holder.txtcount.setText(String.valueOf(mData.get(i).getQty()));

            txtDCharge.setText("₹ " + String.valueOf(new DecimalFormat("##.##").format(finalDel)));
            txtItemTotal.setText("₹ " + String.valueOf(new DecimalFormat("##.##").format(finelIT)));
            txtDiscount.setText("₹ " + String.valueOf(new DecimalFormat("##.##").format(finalDis)));
            txtToPay.setText("₹ " + String.valueOf(new DecimalFormat("##.##").format(finelpay)));



            holder.imgMins.setOnClickListener(v -> {

               qnt = Integer.parseInt(holder.txtcount.getText().toString());
               if (qnt == 1){

                   sessionManager.setIntData(coupon, 0);
                    custPrograssbar.prograssCreate(CartActivity.this);
                   AlertDialog myDelete = new AlertDialog.Builder(CartActivity.this)
                           .setTitle("Delete")
                           .setMessage("Are you sure you want to delete?")
                           .setIcon(R.drawable.ic_delete)
                           .setPositiveButton("Delete", (dialog, whichButton) -> {
                               Log.d("sdj", "" + whichButton);
                               dialog.dismiss();
//                            cs.RemoveId(myCartList.get(i).getProduct_id(), getApplicationContext());
                               Call<RemoveCartWebResponse> callremoveCart = APIClient.getInterface().removecartWeb(mData.get(i).getProduct_id(),customer_id);
                               callremoveCart.enqueue(new Callback<RemoveCartWebResponse>() {
                                   @Override
                                   public void onResponse(Call<RemoveCartWebResponse> call, Response<RemoveCartWebResponse> response) {
                                     custPrograssbar.closePrograssBar();
                                       if (response.isSuccessful()){

                                           finelIT = finelIT - Double.parseDouble(mData.get(i).getMrp());
                                           txtItemTotal.setText("₹ " + String.valueOf(new DecimalFormat("##.##").format(finelIT)));

                                           finelpay = finelpay - Double.parseDouble(mData.get(i).getPrice()) ;
                                           txtToPay.setText("₹ " + String.valueOf(new DecimalFormat("##.##").format(finelpay)));

                                           finalDis   = finalDis   -  Double.parseDouble(mData.get(i).getMrp()) - (Double.parseDouble(mData.get(i).getPrice()));
                                           txtDiscount.setText("₹ " +  String.valueOf(new DecimalFormat("##.##").format(finalDis)));

                                           if (mData != null && mData.size()>0){
                                               lvlNotFound.setVisibility(View.GONE);
                                               lvlMain.setVisibility(View.VISIBLE);
                                           }else {

                                               lvlNotFound.setVisibility(View.GONE);
                                               lvlMain.setVisibility(View.VISIBLE);
                                           }

                                           Intent intent = getIntent();
                                           finish();
                                           startActivity(intent);
                                       }
                                   }

                                   @Override
                                   public void onFailure(Call<RemoveCartWebResponse> call, Throwable t) {

                                   }
                               });


                           })
                           .setNegativeButton("cancel", (dialog, which) -> {
                               Log.d("sdj", "" + which);
                               dialog.dismiss();
                           })
                           .create();
                   myDelete.show();

               } else {
                   qnt = qnt - 1;
                   custPrograssbar.prograssCreate(CartActivity.this);
                   Call<QtyMinusCartWebResponse> callqtyMinusCart = APIClient.getInterface().QtyMinusCartProduct(mData.get(i).getProduct_id(),customer_id);
                   callqtyMinusCart.enqueue(new Callback<QtyMinusCartWebResponse>() {
                       @Override
                       public void onResponse(Call<QtyMinusCartWebResponse> call, Response<QtyMinusCartWebResponse> response) {
                           custPrograssbar.closePrograssBar();
                           if(response.isSuccessful()){
                               holder.txtcount.setVisibility(View.VISIBLE);
                               holder.txtcount.setText(String.valueOf(qnt));

                               finelIT = finelIT - Double.parseDouble(mData.get(i).getMrp());
                               txtItemTotal.setText("₹ " + String.valueOf(new DecimalFormat("##.##").format(finelIT)));

                               finelpay = finelpay - Double.parseDouble(mData.get(i).getPrice());
                               txtToPay.setText("₹ " + String.valueOf(new DecimalFormat("##.##").format(finelpay)));

                               finalDis   = finalDis   -  (Double.parseDouble(mData.get(i).getMrp()) - (Double.parseDouble(mData.get(i).getPrice())));
                               txtDiscount.setText("₹ " +  String.valueOf(new DecimalFormat("##.##").format(finalDis)));

                           }
                       }

                       @Override
                       public void onFailure(Call<QtyMinusCartWebResponse> call, Throwable t) {

                       }
                   });

//                   cs.update(myCartList.get(i).getProduct_id(), "qty", String.valueOf(qnt), getApplicationContext());


               }
            });


            holder.imgPlus.setOnClickListener(v -> {

                qnt = Integer.parseInt(holder.txtcount.getText().toString());
                holder.txtcount.setVisibility(View.VISIBLE);
                holder.imgMins.setVisibility(View.VISIBLE);
                qnt = qnt + 1;
//                cs.update(myCartList.get(i).getProduct_id(), "qty", String.valueOf(qnt), getApplicationContext());

                //notifyDataSetChanged();
                custPrograssbar.prograssCreate(CartActivity.this);
                Call<QtyPlusCartWebResponse> callqtyPlusCart = APIClient.getInterface().QtyPlusCartProduct(mData.get(i).getProduct_id(),customer_id);
                callqtyPlusCart.enqueue(new Callback<QtyPlusCartWebResponse>() {
                    @Override
                    public void onResponse(Call<QtyPlusCartWebResponse> call, Response<QtyPlusCartWebResponse> response) {
                        custPrograssbar.closePrograssBar();
                        if (response.isSuccessful()){
                            holder.txtcount.setText(String.valueOf(qnt));
//                            holder.txtcount.setText(String.valueOf(Integer.parseInt(mData.get(i).getQty())+1));

                            finelIT = finelIT + Double.parseDouble(mData.get(i).getMrp());
                            txtItemTotal.setText("₹ " +String.valueOf(new DecimalFormat("##.##").format(finelIT)));

                            finelpay = finelpay + Double.parseDouble(mData.get(i).getPrice()) ;
                            txtToPay.setText("₹ " +String.valueOf(new DecimalFormat("##.##").format(finelpay)));

                            finalDis   = finalDis   +  (Double.parseDouble(mData.get(i).getMrp()) - (Double.parseDouble(mData.get(i).getPrice())));
                            txtDiscount.setText("₹ " +String.valueOf(new DecimalFormat("##.##").format(finalDis)));

                        }
                    }

                    @Override
                    public void onFailure(Call<QtyPlusCartWebResponse> call, Throwable t) {

                    }
                });



            });

            holder.imgDelete.setOnClickListener(v -> {
                sessionManager.setIntData(coupon, 0);
                custPrograssbar.prograssCreate(CartActivity.this);
                AlertDialog myDelete = new AlertDialog.Builder(CartActivity.this)
                        .setTitle("Delete")
                        .setMessage("Are you sure you want to delete?")
                        .setIcon(R.drawable.ic_delete)
                        .setPositiveButton("Delete", (dialog, whichButton) -> {
                            Log.d("sdj", "" + whichButton);
                            dialog.dismiss();
//                            cs.RemoveId(myCartList.get(i).getProduct_id(), getApplicationContext());
                            Call<RemoveCartWebResponse> callremoveCart = APIClient.getInterface().removecartWeb(mData.get(i).getProduct_id(),customer_id);
                            callremoveCart.enqueue(new Callback<RemoveCartWebResponse>() {
                                @Override
                                public void onResponse(Call<RemoveCartWebResponse> call, Response<RemoveCartWebResponse> response) {
                                    custPrograssbar.closePrograssBar();
                                    if (response.isSuccessful()){
                                        finelIT = finelIT - Double.parseDouble(mData.get(i).getMrp());
                                        txtItemTotal.setText(String.valueOf(new DecimalFormat("##.##").format(finelIT)));

                                        finelpay = finelpay - Double.parseDouble(mData.get(i).getPrice()) ;
                                        txtToPay.setText(String.valueOf(new DecimalFormat("##.##").format(finelpay)));

                                        finalDis   = finalDis   -  Double.parseDouble(mData.get(i).getMrp()) - (Double.parseDouble(mData.get(i).getPrice()));
                                        txtDiscount.setText("₹" + String.valueOf(new DecimalFormat("##.##").format(finalDis)));

                                        if (mData != null && mData.size()>0){
                                            lvlNotFound.setVisibility(View.GONE);
                                            lvlMain.setVisibility(View.VISIBLE);
                                        }else {

                                            lvlNotFound.setVisibility(View.GONE);
                                            lvlMain.setVisibility(View.VISIBLE);
                                        }

                                        Intent intent = getIntent();
                                        finish();
                                        startActivity(intent);
                                    }
                                }

                                @Override
                                public void onFailure(Call<RemoveCartWebResponse> call, Throwable t) {

                                }
                            });


                        })
                        .setNegativeButton("cancel", (dialog, which) -> {
                            Log.d("sdj", "" + which);
                            dialog.dismiss();
                        })
                        .create();
                myDelete.show();
            });

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
            @BindView(R.id.txt_dscount)
            TextView txtDscount;
            @BindView(R.id.txt_price)
            TextView txtPrice;
            @BindView(R.id.img_delete)
            ImageView imgDelete;
            @BindView(R.id.img_mins)
            LinearLayout imgMins;
            @BindView(R.id.txtcount)
            TextView txtcount;
            @BindView(R.id.img_plus)
            LinearLayout imgPlus;
            @BindView(R.id.lvl_addremove)
            LinearLayout lvlAddremove;
            @BindView(R.id.txt_offer)
            TextView txtOffer;
            @BindView(R.id.txt_ptype)
            TextView txtPtype;
            @BindView(R.id.rx_required_text)
            TextView rxRequiredText;

            @BindView(R.id.lvl_offer)
            LinearLayout lvlOffer;

            ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }

    @OnClick({R.id.img_coopncode, R.id.txt_changeadress, R.id.btn_proceed, R.id.img_back, R.id.btn_countinue})

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_coopncode:
                if (sessionManager.getIntData(coupon) != 0) {
                    imgCoupnCode.setImageResource(R.drawable.ic_cancel_coupon);
                    sessionManager.setIntData(coupon, 0);
                  //  updateItem();
                } else {

                    int temp = (int) Math.round(total);
                    startActivity(new Intent(CartActivity.this, CoupunActivity.class).putExtra("amount", temp));
                }

                break;
            case R.id.txt_changeadress:
                startActivity(new Intent(CartActivity.this, AddressActivity.class));
                break;

            case R.id.btn_countinue:
                startActivity(new Intent(CartActivity.this, HomeActivity.class));
                break;

            case R.id.btn_proceed:
                if (customer_id.equals("0")){
                    Intent intent = new Intent(CartActivity.this, LoginActivity.class);
                    intent.putExtra("call","cart");
                    startActivity(intent);
                }
                else {

                    if (rx_required!=null && rx_required.equals("Y")) {

                       // Toast.makeText(getApplicationContext(), "Prescription Required", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CartActivity.this, CartUploadPrescriptionActivity.class);
                        startActivity(intent);
                    }

                    else{

                            String[] myprodData = new String[20];
                            Carteasy cs = new Carteasy();
                            Map<Integer, Map> data;
                            data = cs.ViewAll(getApplicationContext());


                            Call<CartSessionResponse> call = APIClient.getInterface().postProduct(user.getId(),sessionManager.getStringData("session_address_id"));

                            call.enqueue(new Callback<CartSessionResponse>() {
                                @Override
                                public void onResponse(Call<CartSessionResponse> call, Response<CartSessionResponse> response) {
                                    if (response.isSuccessful()) {

                                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(CartActivity.this, OrderActivity.class);
                                        startActivity(intent);
                                    } else {

                                        Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();

                                    }
                                }

                                @Override
                                public void onFailure(Call<CartSessionResponse> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                                }
                            });
                     }

//                    Intent intent = new Intent(CartActivity.this, PaymentOptionActivity.class);
//                    intent.putExtra("subtotal", String.valueOf(subtotal));
//                    intent.putExtra("total", String.valueOf(total));
//                    intent.putExtra("note", edCustom.getText().toString());
//                    startActivity(intent);

                }
                break;
            case R.id.img_back:
                finish();
                break;
            default:
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (sessionManager != null) {
            if (changeAddress) {
                changeAddress = false;
                getAddress();
            } else {
            }
        }
    }
}