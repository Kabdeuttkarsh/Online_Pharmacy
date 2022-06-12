package com.medicalaadharpharmacy.medicalaadharpharmacy;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class JsonParser {


        static InputStream is = null;
        static JSONObject jObj = null;
        static String json = "";

        HttpURLConnection urlConnection = null;
        // variable to hold context
        private Context context;
        // constructor
        public void JSONParser(Context context){
            this.context=context;
        }


        public JSONObject makeHttpRequest(String url,String method,String params) {

            // boolean isReachable =Config.isURLReachable(context);
            // Making HTTP request
            try {
                String retSrc="";
                char current = '0';

                URL url1 = new URL(url);
                // check for request method
                HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();
                if (method == "POST") {
                    // request method is POST
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setFixedLengthStreamingMode(params.getBytes().length);
                    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
                    out.print(params);
                    out.close();
                }
                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                byte[] bytes = new byte[10000];
                StringBuilder x = new StringBuilder();
                int numRead = 0;
                while ((numRead = in.read(bytes)) >= 0) {
                    x.append(new String(bytes, 0, numRead));
                }
                retSrc=x.toString();



                jObj = new JSONObject(retSrc);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return jObj;
        }

}
