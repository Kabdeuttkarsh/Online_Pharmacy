package com.medicalaadharpharmacy.medicalaadharpharmacy.adepter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.fragment.CategoryFragment;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.MostViewed;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.ui.HomeActivity;
import com.medicalaadharpharmacy.medicalaadharpharmacy.ui.ProductDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private Context mContext;
    private List<MostViewed> mCatlist = new ArrayList<>();
    private RecyclerTouchListener listener;
    private String typeview;

    public interface RecyclerTouchListener {
        public void onClickCategoryItem(String titel, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;
        public LinearLayout lvlclick;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_title);
            thumbnail = view.findViewById(R.id.imageView);
            lvlclick = view.findViewById(R.id.lvl_itemclick);

        }
    }

    public CategoryAdapter(Context mContext, List<MostViewed> mCatlist, final RecyclerTouchListener listener, String viewtype) {
        this.mContext = mContext;
        this.mCatlist = mCatlist;
        this.listener = listener;
        this.typeview = viewtype;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if (typeview.equalsIgnoreCase("viewall")) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_categoryviewall, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_categoryviewall, parent, false);
        }

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.title.setText(mCatlist.get(position).getProduct_name());

        Glide.with(mContext).load(APIClient.baseUrl + "/uploads/products/"+mCatlist.get(position).getProduct_file_name().get(0)).into(holder.thumbnail);
        holder.lvlclick.setOnClickListener(v -> {
            if (mCatlist.size() == 0) {
                Toast.makeText(mContext, "Product Not Found !!!", Toast.LENGTH_LONG).show();
            } else {
                v.getContext().startActivity(new Intent(mContext, ProductDetailsActivity.class)
                .putExtra("manufacturer",mCatlist.get(position).getManufacturer())
                .putExtra("composition",mCatlist.get(position).getComposition())
                .putExtra("packing_type",mCatlist.get(position).getPacking_type())
                .putExtra("packaging",mCatlist.get(position).getPackaging())
                .putExtra("schedule",mCatlist.get(position).getSchedule())
                .putExtra("product_name",mCatlist.get(position).getProduct_name())
                .putExtra("mrp",mCatlist.get(position).getMrp())
                .putExtra("discounted_price",mCatlist.get(position).getDiscounted_price())
                .putExtra("product_id",mCatlist.get(position).getProduct_id())
                .putExtra("discounted_percentage",mCatlist.get(position).getDiscounted_percentage())
                .putExtra("shipping_price",mCatlist.get(position).getShipping_price())
                .putExtra("ImageList",mCatlist.get(position).getProduct_file_name()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCatlist.size();
    }
}