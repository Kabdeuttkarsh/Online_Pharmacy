package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.imagepicker.ImageCompressionListener;
import com.medicalaadharpharmacy.medicalaadharpharmacy.imagepicker.ImagePicker;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.AddressList;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerAddress;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.CustomerAddressResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.MyAddress;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.MyAddressResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.UploadResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.FileUtils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.medicalaadharpharmacy.medicalaadharpharmacy.ui.AddressActivity.changeAddress;
import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.FileUtils.isLocal;

public class UploadPrescriptionActivity extends RootActivity  {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_actiontitle)
    TextView txtActiontitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.txt_prescription_valid)
    TextView txtPrescriptionValid;
    @BindView(R.id.btn_upload)
    TextView btnUpload;
    @BindView(R.id.lvl_empty)
    LinearLayout lvlEmpty;
    @BindView(R.id.lvl_pic)
    LinearLayout lvlPic;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.txt_atype)
    TextView txtAtype;
    @BindView(R.id.txt_address)
    TextView txtAddress;
    @BindView(R.id.txt_changeadress)
    TextView txtChangeadress;
    @BindView(R.id.btn_ather)
    TextView btnAther;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;
    private ImagePicker imagePicker;
    ArrayList<String> arrayListImage = new ArrayList<>();
    CustPrograssbar custPrograssbar;
    User user;
    SessionManager sessionManager;
    AddressList selectaddress;
    String customer_id;
    ArrayList<CustomerAddress> customerAddresses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_prescription);
        ButterKnife.bind(this);
        custPrograssbar = new CustPrograssbar();
        sessionManager = new SessionManager(UploadPrescriptionActivity.this);
        user = sessionManager.getUserDetails("");
        if (user != null){
            customer_id = user.getId();
        }else {
            customer_id = "0";
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(this);
        mLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        imagePicker = new ImagePicker();
        if (checkPermission()) {
            //start image picker

        } else {
            //ask permission
            requestStoragePermission();
        }
        getAddress();

    }

    private void uploadMultiFile(ArrayList<String> filePaths) {
        custPrograssbar.prograssCreate(UploadPrescriptionActivity.this);
        List<MultipartBody.Part> parts = new ArrayList<>();

        if (filePaths != null) {
            // create part for file (photo, video, ...)
            for (int i = 0; i < filePaths.size(); i++) {
                parts.add(prepareFilePart("image" + i, filePaths.get(i)));
            }
        }

        RequestBody uid = createPartFromString(customer_id);
        RequestBody addres = createPartFromString(sessionManager.getStringData("session_address_id"));
        RequestBody dCharge = createPartFromString("100");
        RequestBody size = createPartFromString("" + parts.size());

        Call<UploadResponse> call = APIClient.getInterface().uploadMultiFile(uid, addres, dCharge, size, parts);

        call.enqueue(new Callback<UploadResponse>() {
            @Override
            public void onResponse(@NonNull Call<UploadResponse> call, @NonNull Response<UploadResponse> response) {
                custPrograssbar.closePrograssBar();
                Gson gson = new Gson();
              //  RestResponse restResponse = gson.fromJson(response.body(), RestResponse.class);
                Toast.makeText(UploadPrescriptionActivity.this,"Success", Toast.LENGTH_SHORT).show();
           //     if (restResponse.getResult().equalsIgnoreCase("true")) {
                    lvlEmpty.setVisibility(VISIBLE);
                    lvlPic.setVisibility(GONE);
                    arrayListImage.clear();
                    Intent intent = new Intent(UploadPrescriptionActivity.this, OrderActivity.class);
//                intent.putExtra("call","upload");
                    startActivity(intent);
              //  }

            }

            @Override
            public void onFailure(@NonNull Call<UploadResponse> call, @NonNull Throwable t) {
                custPrograssbar.closePrograssBar();
                Log.d("error up",t.toString());
                Toast.makeText(UploadPrescriptionActivity.this,t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(MediaType.parse(FileUtils.MIME_TYPE_TEXT), descriptionString);
    }

    @NonNull
    private MultipartBody.Part prepareFilePart(String partName, String fileUri) {
        // use the FileUtils to get the actual file by uri
        File file = getFile(UploadPrescriptionActivity.this, fileUri);

        // create RequestBody instance from file
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

    public static File getFile(Context context, String path) {
        if (path == null) {
            return null;
        }

        if (isLocal(path)) {
            return new File(path);
        }
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImagePicker.SELECT_IMAGE && resultCode == RESULT_OK) {

            imagePicker.addOnCompressListener(new ImageCompressionListener() {
                @Override
                public void onStart() {
                }

                @Override
                public void onCompressed(String filePath) {
                    if (filePath != null) {
                        //return filepath
                        arrayListImage.add(filePath);
                        postImage(arrayListImage);
                    }
                }
            });
            String filePath = imagePicker.getImageFilePath(data);
            if (filePath != null) {
                //return filepath
                arrayListImage.add(filePath);
                postImage(arrayListImage);
            }
        }
    }

    public void postImage(ArrayList<String> urilist) {
        if (urilist.size() != 0) {
            lvlEmpty.setVisibility(GONE);
        }
        ImageAdp imageAdp = new ImageAdp(UploadPrescriptionActivity.this, urilist);
        recyclerView.setAdapter(imageAdp);

    }

    @OnClick({R.id.img_back, R.id.txt_prescription_valid, R.id.btn_upload, R.id.btn_ather, R.id.btn_submit, R.id.txt_changeadress})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_ather:
                bottonChoseoption();
                break;
            case R.id.btn_submit:
                if (customer_id.equals("0")){
                    Intent intent = new Intent(UploadPrescriptionActivity.this, LoginActivity.class);
                    intent.putExtra("call","upload");
                    startActivity(intent);
                }else{
                    if (arrayListImage.size() != 0) {
                    uploadMultiFile(arrayListImage);
                }
                }

                break;
            case R.id.txt_changeadress:
                startActivity(new Intent(UploadPrescriptionActivity.this, AddressActivity.class));

                break;
            case R.id.txt_prescription_valid:
                bottonVelidation();

                break;
            case R.id.btn_upload:
                bottonChoseoption();
                break;
            default:
                break;
        }
    }

   // @Override
//    public void callback(JsonObject result, String callNo) {
//        Gson gson = new Gson();
//        CustomerAddress address = gson.fromJson(result.toString(), Address.class);
//        if (address.getResult().equalsIgnoreCase("true")) {
//            if (address.getAddressList().size() != 0) {
//                sessionManager.setAddress(address.getAddressList().get(sessionManager.getIntData("position")));
//                selectaddress = sessionManager.getAddress();
//                txtAtype.setText("" + selectaddress.getType());
//                txtAddress.setText(selectaddress.getHno() + "," + selectaddress.getLandmark() + "," + selectaddress.getAddress());
//
//
//            } else {
//                Toast.makeText(UploadPrescriptionActivity.this, address.getResponseMsg(), Toast.LENGTH_SHORT).show();
//            }
//
//        } else {
//            finish();
//        }
//    }


    public class ImageAdp extends RecyclerView.Adapter<ImageAdp.MyViewHolder> {
        private ArrayList<String> arrayList;


        public class MyViewHolder extends RecyclerView.ViewHolder {

            public ImageView remove;
            public ImageView thumbnail;

            public MyViewHolder(View view) {
                super(view);

                thumbnail = view.findViewById(R.id.image_pic);
                remove = view.findViewById(R.id.image_remove);
            }
        }

        public ImageAdp(Context mContext, ArrayList<String> arrayList) {
            this.arrayList = arrayList;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.imageview_layout, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {


            Glide.with(UploadPrescriptionActivity.this)
                    .load(arrayList.get(position))
                    .into(holder.thumbnail);
            holder.remove.setOnClickListener(v -> {
                arrayList.remove(position);
                if (arrayList.size() != 0) {
                    notifyDataSetChanged();
                } else {
                    lvlEmpty.setVisibility(VISIBLE);
                    lvlPic.setVisibility(GONE);
                }

            });
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private boolean checkPermission() {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        return currentAPIVersion < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1234);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1234) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Log.e("OOOn", "Done");
            } else {
                setResult(RESULT_CANCELED);
                finish();
            }
        }
    }

    public void bottonChoseoption() {
        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);

        View sheetView = getLayoutInflater().inflate(R.layout.activity_image_select, null);
        mBottomSheetDialog.setContentView(sheetView);

        TextView textViewCamera = sheetView.findViewById(R.id.textViewCamera);
        TextView textViewGallery = sheetView.findViewById(R.id.textViewGallery);
        TextView textViewCancel = sheetView.findViewById(R.id.textViewCancel);


        mBottomSheetDialog.show();

        textViewCamera.setOnClickListener(v -> {

            mBottomSheetDialog.cancel();
            imagePicker.withActivity(UploadPrescriptionActivity.this).chooseFromGallery(false).chooseFromCamera(true).withCompression(true).start();


        });
        textViewGallery.setOnClickListener(v -> {
            mBottomSheetDialog.cancel();
            imagePicker.withActivity(UploadPrescriptionActivity.this).chooseFromGallery(true).chooseFromCamera(false).withCompression(true).start();

        });
        textViewCancel.setOnClickListener(v -> mBottomSheetDialog.cancel());
    }

    public void bottonVelidation() {
        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);

        View sheetView = getLayoutInflater().inflate(R.layout.custome_vallid_layout, null);
        mBottomSheetDialog.setContentView(sheetView);


        mBottomSheetDialog.show();


    }

    private void getAddress() {
        if (user != null) {
//            Call<CustomerAddressResponse> call = APIClient.getInterface().getAddress(user.getId());
            Call<MyAddressResponse> call = APIClient.getInterface().getDefaultAddress(customer_id,sessionManager.getStringData("session_address_id"));

            call.enqueue(new Callback<MyAddressResponse>() {
                @Override
                public void onResponse(Call<MyAddressResponse> call, Response<MyAddressResponse> response) {
                    if (response.isSuccessful()) {
                        MyAddressResponse caResponse = response.body();
                        List<MyAddress> customerAddresses = caResponse.getBanners();
//                        customerAddresses = caResponse();
//                        Gson gson = new Gson();

//                        CustomerAddressResponse caddress = gson.fromJson(String.valueOf(customerAddresses), (Type) CustomerAddress.class);

//                        sessionManager.setAddress();
                        selectaddress = sessionManager.getAddress();
                        if (customerAddresses.get(0).getIs_default().equals("Y")) {
                            txtAtype.setText("Permanent");
                        } else {
                            txtAtype.setText("Local Address");
                        }
                        txtAddress.setText(customerAddresses.get(0).getLand_mark() + " "
                                + customerAddresses.get(0).getCity() + " " +
                                customerAddresses.get(0).getState() + " " +
                                customerAddresses.get(0).getCountry() + " " +
                                customerAddresses.get(0).getPincode());

                    } else {
                    }
                }

                @Override
                public void onFailure(Call<MyAddressResponse> call, Throwable t) {

                }


            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sessionManager == null) {
            return;
        }
        if (changeAddress) {
            changeAddress = false;
            getAddress();
        }
    }
}