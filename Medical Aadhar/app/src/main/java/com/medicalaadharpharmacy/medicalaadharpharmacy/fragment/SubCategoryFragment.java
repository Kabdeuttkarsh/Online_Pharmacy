package com.medicalaadharpharmacy.medicalaadharpharmacy.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.AddressList;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.CategoryProduct;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.User;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.CustPrograssbar;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;


public class SubCategoryFragment extends Fragment  {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vpPager)
    ViewPager vpPager;
    User user;
    AddressList address;

    SessionManager sessionManager;
    int position = 0;
    public List<CategoryProduct> categoryProducts;
    CustPrograssbar custPrograssbar;

    public static SubCategoryFragment subCategoryFragment = null;

    public static SubCategoryFragment getInstance() {
        return subCategoryFragment;
    }
    public SubCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_category, container, false);
        ButterKnife.bind(this, view);
        subCategoryFragment=this;
        Bundle b = getArguments();
        position = b.getInt("position");
        sessionManager = new SessionManager(getActivity());
        user = sessionManager.getUserDetails("");
        address=sessionManager.getAddress();
        custPrograssbar = new CustPrograssbar();
        getProductlist();


        return view;
    }

    private void getProductlist() {
        custPrograssbar.prograssCreate(getActivity());
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("uid", user.getId());
            jsonObject.put("lats", address.getLatMap());
            jsonObject.put("longs", address.getLongMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody bodyRequest = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<JsonObject> call = APIClient.getInterface().getCatProduct(bodyRequest);
//        GetResult getResult = new GetResult();
//        getResult.setMyListener(this);
//        getResult.callForLogin(call, "1");

    }

//    @Override
//    public void callback(JsonObject result, String callNo) {
//        try {
//            custPrograssbar.closePrograssBar();
//            if (callNo.equalsIgnoreCase("1")) {
//                Gson gson = new Gson();
//                Categorywithproduct categorywithproduct = gson.fromJson(result.toString(), Categorywithproduct.class);
//                if (categorywithproduct.getResult().equalsIgnoreCase("true")) {
//                    categoryProducts = categorywithproduct.getCategoryProduct();
//                }
//                MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager(), categoryProducts);
//                vpPager.setAdapter(myPagerAdapter);
//                tabLayout.setupWithViewPager(vpPager);
//                vpPager.setCurrentItem(position);
//                for (int i = 0; i < categorywithproduct.getCategoryProduct().size(); i++) {
//                    LinearLayout customTab = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
//                    CircleImageView tabImage = customTab.findViewById(R.id.img_icon);
//                    TextView tabTitle = customTab.findViewById(R.id.txt_titel);
//                    tabTitle.setText(categorywithproduct.getCategoryProduct().get(i).getCategoryName());
//                    Picasso.get()
//                            .load(APIClient.baseUrl + "/" + categorywithproduct.getCategoryProduct().get(i).getCategoryImg())
//                            .placeholder(R.drawable.ezgifresize)
//                            .into(tabImage);
//                    tabLayout.getTabAt(i).setCustomView(customTab);
//                    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.black));
//
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        List<CategoryProduct> catlistList;

        public MyPagerAdapter(FragmentManager fragmentManager, List<CategoryProduct> catlistList) {
            super(fragmentManager);
            this.catlistList = new ArrayList<>();
            this.catlistList = catlistList;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return catlistList.size();
        }

        @Override
        public Fragment getItem(int position) {
            Log.e("ppp", " " + position);
            return ProductFragment.newInstance(position, catlistList.get(position).getCategoryName());
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return catlistList.get(position).getCategoryName();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        categoryProducts = new ArrayList<>();
    }
}
