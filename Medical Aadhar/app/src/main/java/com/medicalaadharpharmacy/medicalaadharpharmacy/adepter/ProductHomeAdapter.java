package com.medicalaadharpharmacy.medicalaadharpharmacy.adepter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.Medicine;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.Recommnd;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.ui.ProductDetailsActivity;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.currency;

public class ProductHomeAdapter extends RecyclerView.Adapter<ProductHomeAdapter.MyViewHolder> {

    private Context mContext;
    private List<Recommnd> mMedicine;
    private RecyclerTouchListener listener;
    SessionManager sessionManager;

    public interface RecyclerTouchListener {
        public void onClickProductItem(String titel, Medicine medicine);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.priceoofer)
        TextView priceoofer;
        @BindView(R.id.lvl_click)
        LinearLayout lvlClick;
        @BindView(R.id.txt_offer)
        TextView txtOffer;
        @BindView(R.id.lvl_offer)
        LinearLayout lvlOffer;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    public ProductHomeAdapter(Context mContext, List<Recommnd> mMedicine, final RecyclerTouchListener listener) {
        this.mContext = mContext;
        this.mMedicine = mMedicine;
        this.listener = listener;
        sessionManager = new SessionManager(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_home_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

      //  Medicine medicine = mMedicine.get(position);

   //     if (Integer.parseInt(mMedicine.get(position).getDiscounted_price()) == 0) {
            holder.lvlOffer.setVisibility(View.GONE);
            holder.priceoofer.setVisibility(View.GONE);
            holder.price.setText("₹"+ mMedicine.get(position).getMrp());
    //    } else {
           // DecimalFormat format = new DecimalFormat("0.#");
           // holder.txtOffer.setText(format.format(Integer.parseInt(mMedicine.get(position).getDiscounted_percentage())) + "% OFF");
        holder.txtOffer.setText(mMedicine.get(position).getDiscounted_percentage() + "% OFF");

        //   double res = (Double.parseDouble(medicine.getProductInfo().get(0).getProductPrice()) / 100.0f) * medicine.getProductInfo().get(0).getProductDiscount();
         //   res = Double.parseDouble(medicine.getProductInfo().get(0).getProductPrice()) - res;
       //     holder.price.setText(sessionManager.getStringData(currency) + new DecimalFormat("##.##").format(res));
            holder.priceoofer.setPaintFlags(holder.priceoofer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.priceoofer.setText("₹"+ mMedicine.get(position).getDiscounted_price());

      //  }
        holder.txtTitle.setText(mMedicine.get(position).getProduct_name());
        Glide.with(mContext).load(APIClient.baseUrl + "/uploads/products/" + mMedicine.get(position).getProduct_file_name().get(0)).thumbnail(Glide.with(mContext).load(R.drawable.ezgifresize)).centerCrop().into(holder.imgIcon);
       // holder.lvlClick.setOnClickListener(v -> listener.onClickProductItem("category.getCatname()", medicine));
        holder.lvlClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(mContext, ProductDetailsActivity.class)
                        .putExtra("manufacturer",mMedicine.get(position).getManufacturer())
                        .putExtra("composition",mMedicine.get(position).getComposition())
                        .putExtra("packing_type",mMedicine.get(position).getPacking_type())
                        .putExtra("packaging",mMedicine.get(position).getPackaging())
                        .putExtra("schedule",mMedicine.get(position).getSchedule())
                        .putExtra("product_name",mMedicine.get(position).getProduct_name())
                        .putExtra("mrp",mMedicine.get(position).getMrp())
                        .putExtra("discounted_price",mMedicine.get(position).getDiscounted_price())
                        .putExtra("product_id",mMedicine.get(position).getProduct_id())
                        .putExtra("discounted_percentage",mMedicine.get(position).getDiscounted_percentage())
                        .putExtra("shipping_price",mMedicine.get(position).getShipping_price())
                        .putExtra("ImageList",mMedicine.get(position).getProduct_file_name()));


            }
        });
    }

    @Override
    public int getItemCount() {
        return mMedicine.size();
    }

}
