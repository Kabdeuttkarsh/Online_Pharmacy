package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.AddressList;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.PaymentItem;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerOrderDetailsResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.PaytmChecksumResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.DatabaseHelper;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
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

import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.coupon;
import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.couponid;
import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.dcharge;
import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.Utility.paymentID;
import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.Utility.paymentsucsses;
import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.Utility.tragectionID;

public class PaymentOptionActivity extends RootActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.lvl_paymentlist)
    LinearLayout lvlPaymentList;
    DatabaseHelper databaseHelper;
    String oid;
    String grand_total;
    String subtotal;
    String note;
    String total;

    User user;
    AddressList address1;

    SessionManager sessionManager;
    CustPrograssbar custPrograssbar;

    List<PaymentItem> paymentList = new ArrayList<>();
    PaymentItem paytm = new PaymentItem();
    PaymentItem cod = new PaymentItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        ButterKnife.bind(this);
        oid = getIntent().getStringExtra("oid");
        grand_total=getIntent().getStringExtra("grand_total");
        sessionManager = new SessionManager(PaymentOptionActivity.this);
        custPrograssbar = new CustPrograssbar();
        address1 = sessionManager.getAddress();
        user = sessionManager.getUserDetails("");


        subtotal = getIntent().getStringExtra("subtotal");
        total = getIntent().getStringExtra("total");
        note = getIntent().getStringExtra("note");
        databaseHelper = new DatabaseHelper(PaymentOptionActivity.this);

//
//        cod.setmId("1");
//        cod.setmImg("/uploads/cod.png");
//        cod.setmAttributes("  ");
//        cod.setmStatus("Available");
//        cod.setmTitle("Cash On Delivery");
//        cod.setSubtitle("Pay at the time of Delivery");
//        paymentList.add(cod);

        paytm.setmId("2");
        paytm.setmImg("/uploads/Paytm.png");
        paytm.setmAttributes("  ");
        paytm.setmStatus("Available");
        paytm.setmTitle("Pay Online");
        paytm.setSubtitle("Quicker and more Convenient");
        paymentList.add(paytm);
        setJoinPlayrList(lvlPaymentList,paymentList);
    }


    private void setJoinPlayrList(LinearLayout lnrView, List<PaymentItem> paymentList) {
        lnrView.removeAllViews();

        for (int i = 0; i < paymentList.size(); i++) {
            LayoutInflater inflater = LayoutInflater.from(PaymentOptionActivity.this);
            PaymentItem paymentItem = paymentList.get(i);
            View view = inflater.inflate(R.layout.custome_payment_item, null);
            ImageView imageView = view.findViewById(R.id.img_icon);
            TextView txtTitle = view.findViewById(R.id.txt_title);
            TextView txtSubtitel = view.findViewById(R.id.txt_subtitel);
            txtTitle.setText("" + paymentList.get(i).getmTitle());
            txtSubtitel.setText("" + paymentList.get(i).getSubtitle());
            Glide.with(PaymentOptionActivity.this).load(APIClient.baseUrl + paymentList.get(i).getmImg()).thumbnail(Glide.with(PaymentOptionActivity.this).load(R.drawable.ezgifresize)).into(imageView);
            int finalI = i;
            view.setOnClickListener(v -> {
                paymentID = paymentList.get(finalI).getmId();
                try {
                    switch (paymentList.get(finalI).getmTitle()) {
                        case "Pay Online":
                            Long tsLong = System.currentTimeMillis()/1000;
                            String order_no = tsLong.toString();
                            String temtoal = grand_total;
                            String mid = "ZzcSQP81593681637306";
                            String  varifyurl = "https://securegw.paytm.in/theia/paytmCallback?ORDER_ID="+String.valueOf(order_no);
                            String CHANNEL_ID = "WEB";
                            String WEBSITE = "WEBSTAGING";
                            String INDUSTRY_TYPE_ID = "Retail";
                            String amount=temtoal;
                            String CURRENCY="INR";

//                          startActivity(new Intent(PaymentOptionActivity.this, RazerpayActivity.class).putExtra("amount", temtoal).putExtra("detail", paymentItem));
                            custPrograssbar.prograssCreate(PaymentOptionActivity.this);
                            Call<PaytmChecksumResponse> call = APIClient.getInterface().getPaytmChecksum(mid, String.valueOf(order_no),
                                    String.valueOf(user.getId()),
                                    CHANNEL_ID,
                                    amount,
                                    WEBSITE,
                                    INDUSTRY_TYPE_ID,
                                    CURRENCY,
                                    varifyurl
                            );

                            call.enqueue(new Callback<PaytmChecksumResponse>() {

                                @Override
                                public void onResponse(Call<PaytmChecksumResponse> call, Response<PaytmChecksumResponse> response) {
                                    // sessionManager.clearPaytmChecksum();
                                    if (response.isSuccessful()){
                                        custPrograssbar.closePrograssBar();
                                         sessionManager.setPaytmChecksum(response.body().getData());
                                         startActivity(new Intent(PaymentOptionActivity.this, PaytmChecksum.class).putExtra("amount", temtoal)
                                                                                                                               .putExtra("order_id",String.valueOf(order_no))
                                                                                                                               .putExtra("cust_id",String.valueOf(user.getId()))
                                                                                                                               .putExtra("checksumval",response.body().getData())
                                                                                                                               .putExtra("sale_code",String.valueOf(oid)));

                                    }
                                    else{
                                        custPrograssbar.closePrograssBar();
                                        Toast.makeText(PaymentOptionActivity.this, "Checksum Error, Please Try Again", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(PaymentOptionActivity.this, PaymentOptionActivity.class));

                                    }
                                }

                                @Override
                                public void onFailure(Call<PaytmChecksumResponse> call, Throwable t) {
                                    custPrograssbar.closePrograssBar();
                                    Toast.makeText(PaymentOptionActivity.this,   "Error..Please Try Again", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(PaymentOptionActivity.this, PaymentOptionActivity.class));

                                }
                            });

                            break;
                        case "Cash On Delivery":
                           // new AsyncTaskRunner().execute("");
                            break;
                        default:
                            break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            lnrView.addView(view);
        }
    }


    @OnClick(R.id.img_back)
    public void onClick() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (paymentsucsses == 1) {
            paymentsucsses = 0;
        //    new AsyncTaskRunner().execute("0");

        }
    }
}