package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.medicalaadharpharmacy.medicalaadharpharmacy.models.PaytmChecksumResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.PaytmSaveResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.paytm.pgsdk.Log;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;


public class PaytmChecksum  extends RootActivity {
    SessionManager sessionManager;
    String STATUS;
    String ORDERID;
    String TXNAMOUNT;
    String TXNDATE;
    String TXNID;
    String BANKNAME;
    String RESPCODE;
    String PAYMENTMODE;
    String BANKTXNID;
    String CURRENCY="INR";
    String GATEWAYNAME;
    String RESPMSG;

    String order_id;
    String sale_code;
    String mid;
    String amount;
   // String detail;
    String cust_id;
    String CHANNEL_ID = "WEB";
    String WEBSITE = "WEBSTAGING";
    String INDUSTRY_TYPE_ID = "Retail";

    CustPrograssbar custPrograssbar;

    String url = "https://medicalaadhar.com/api/Paytm_gateway/start_paytm_payment";
    String varifyurl="";
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        sessionManager = new SessionManager(PaytmChecksum.this);

        custPrograssbar = new CustPrograssbar();
        amount = getIntent().getStringExtra("amount");
        // detail = getIntent().getStringExtra("detail");
        cust_id = getIntent().getStringExtra("cust_id");
        mid = "ZzcSQP81593681637306";
        order_id = getIntent().getStringExtra("order_id");
        sale_code = getIntent().getStringExtra("sale_code");

        varifyurl = "https://securegw.paytm.in/theia/paytmCallback?ORDER_ID="+order_id;

        super.onCreate(savedInstanceState);
        LocalDateTime now = LocalDateTime.now();


        sendUserDetailTOServerdd dl = new sendUserDetailTOServerdd();
        dl.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }


    public class sendUserDetailTOServerdd extends AsyncTask<ArrayList<String>, Void, String> {
        String chcksm = "";

        private ProgressDialog dialog = new ProgressDialog(PaytmChecksum.this);

        @Override
        protected void onPreExecute() {

            this.dialog.setMessage("Please wait");
            this.dialog.show();

        }

        @Override
        protected String doInBackground(ArrayList<String>... arrayLists) {
        String checksumval = getIntent().getStringExtra("checksumval");
        chcksm=checksumval;
//      chcksm=sessionManager.getPaytmChecksum("CHECKSUMHASH");

         return chcksm;

        }

        @Override
        protected void onPostExecute(String result) {

            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            PaytmPGService Service =PaytmPGService.getProductionService();
            HashMap<String, String> paramMap = new HashMap<String, String>();

            //MID provided by paytm
            paramMap.put("MID",mid);
            paramMap.put("ORDER_ID",order_id);
            paramMap.put("CUST_ID",cust_id);
            paramMap.put("CHANNEL_ID",CHANNEL_ID);
            paramMap.put("TXN_AMOUNT",amount);
            paramMap.put("WEBSITE",WEBSITE);
            paramMap.put("CALLBACK_URL",varifyurl);
            //  paramMap.put( "EMAIL" , "abc@gmail.com");   // no need
            //  paramMap.put( "MOBILE_NO" , "9144040888");  // no need
            paramMap.put("CHECKSUMHASH",chcksm);
            //  paramMap.put("PAYMENT_TYPE_ID" ,"CC");    // no need
            paramMap.put("INDUSTRY_TYPE_ID","Retail");

            PaytmOrder Order = new PaytmOrder(paramMap);
            Service.initialize(Order,null);
            // start payment service call here
            Service.startPaymentTransaction(PaytmChecksum.this, true, true, new PaytmPaymentTransactionCallback() {

                @Override
                public void onTransactionResponse(Bundle inResponse) {
//                    Intent intent=new Intent(PaytmChecksum.this,PaymentOptionActivity.class);
//                    startActivity(intent);
              //    startActivity(new Intent(PaytmChecksum.this, PaymentOptionActivity.class));
                    if (Objects.equals(inResponse.getString("STATUS"), "TXN_SUCCESS")) {
                        //    Payment Success
                        // Toast.makeText(PaytmChecksum.this,   "Payment Successfull", Toast.LENGTH_SHORT).show();
                        String paytm_STATUS=inResponse.getString("STATUS");
                        String paytm_CHECKSUMHASH=inResponse.getString("CHECKSUMHASH");
                        String paytm_ORDERID=inResponse.getString("ORDERID");
                        String paytm_TXNAMOUNT=inResponse.getString("TXNAMOUNT");
                        String paytm_TXNDATE=inResponse.getString("TXNDATE");
                        String paytm_MID=inResponse.getString("MID");
                        String paytm_TXNID=inResponse.getString("TXNID");
                        String paytm_RESPCODE=inResponse.getString("RESPCODE");
                        String paytm_PAYMENTMODE=inResponse.getString("PAYMENTMODE");
                        String paytm_BANKTXNID=inResponse.getString("BANKTXNID");
                        String paytm_RESPMSG=inResponse.getString("RESPMSG");

                        Call<PaytmSaveResponse> call = APIClient.getInterface().savePaytmResponse(String.valueOf(paytm_MID),
                                String.valueOf(paytm_ORDERID), String.valueOf(paytm_STATUS),String.valueOf(paytm_CHECKSUMHASH),
                                String.valueOf(paytm_TXNAMOUNT), String.valueOf(paytm_TXNDATE),String.valueOf(paytm_TXNID),
                                String.valueOf(paytm_RESPCODE), String.valueOf(paytm_PAYMENTMODE),String.valueOf(paytm_BANKTXNID),
                                String.valueOf(paytm_RESPMSG),String.valueOf(sale_code));
//                      startActivity(new Intent(PaytmChecksum.this, OrderActivity.class));

                        call.enqueue(new Callback<PaytmSaveResponse>() {
                            @Override
                            public void onResponse(Call<PaytmSaveResponse> call, Response<PaytmSaveResponse> response) {
                                if(response.isSuccessful()){
                                    if(response.body().getStatus().toString()=="true"){
                                        Toast.makeText(PaytmChecksum.this,   "Payment Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(PaytmChecksum.this, OrderActivity.class));

                                    }
                                }

                                else{
                                    Toast.makeText(PaytmChecksum.this,   "Payment Done.(Response success false)", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(PaytmChecksum.this, OrderActivity.class));

                                }


                            }

                            @Override
                            public void onFailure(Call<PaytmSaveResponse> call, Throwable t) {
                                Toast.makeText(PaytmChecksum.this,   "Something Went Wrong..(Response success failure)", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(PaytmChecksum.this, OrderActivity.class));

                            }
                        });
                    }
                    else if (!inResponse.getBoolean("STATUS")) {
                        //    Payment Failed
                        Toast.makeText(PaytmChecksum.this,   "Payment Cancelled..Returning Back", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(PaytmChecksum.this, OrderActivity.class));

                    }
                    else{
                        Toast.makeText(PaytmChecksum.this,   "Error..Please Try Again", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(PaytmChecksum.this, PaymentOptionActivity.class));
                    }
                }

                @Override
                public void networkNotAvailable() {
                    Toast.makeText(PaytmChecksum.this, "Network Error.. Please Try Again.", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(PaytmChecksum.this,PaymentOptionActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void clientAuthenticationFailed(String inErrorMessage) {
                    Toast.makeText(PaytmChecksum.this, "Authentication Failed..Please Try Again.", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(PaytmChecksum.this,PaymentOptionActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void someUIErrorOccurred(String inErrorMessage) {
                    Toast.makeText(PaytmChecksum.this, "Error.. Please Try Again", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(PaytmChecksum.this,PaymentOptionActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {
                    Toast.makeText(PaytmChecksum.this, "Error.. Please Try Again", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(PaytmChecksum.this,PaymentOptionActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void onBackPressedCancelTransaction() {
                    Toast.makeText(PaytmChecksum.this, "Back Pressed", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(PaytmChecksum.this,PaymentOptionActivity.class);
//                    startActivity(intent);
                }

                @Override
                public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
                    Toast.makeText(PaytmChecksum.this, "Cancelled", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(PaytmChecksum.this,PaymentOptionActivity.class);
//                    startActivity(intent);
                }

            });
        }


    }
}

