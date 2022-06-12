package com.medicalaadharpharmacy.medicalaadharpharmacy.adepter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
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
import com.medicalaadharpharmacy.medicalaadharpharmacy.model.Medicine;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProduct;
import com.medicalaadharpharmacy.medicalaadharpharmacy.models.SearchProductResponse;
import com.medicalaadharpharmacy.medicalaadharpharmacy.retrofit.APIClient;
import com.medicalaadharpharmacy.medicalaadharpharmacy.ui.ProductDetailsActivity;
import com.medicalaadharpharmacy.medicalaadharpharmacy.ui.SearchActivity;
import com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.medicalaadharpharmacy.medicalaadharpharmacy.utiles.SessionManager.currency;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context mContext;
    private List<SearchProduct> medicineList;
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

    public ProductAdapter(Context mContext, List<SearchProduct> medicineList, final RecyclerTouchListener listener) {
        this.mContext = mContext;
        this.medicineList = medicineList;
        this.listener = listener;
        sessionManager = new SessionManager(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
      //  Medicine medicine = medicineList.get(position);
       // if (medicine.getProductInfo().get(0).getProductDiscount() == 0) {


            holder.lvlOffer.setVisibility(View.GONE);
            holder.priceoofer.setVisibility(View.GONE);
            holder.price.setText("₹"+medicineList.get(position).getMrp());
      //  } else {
         //   DecimalFormat format = new DecimalFormat("0.#");
            holder.txtOffer.setText(medicineList.get(position).getDiscounted_percentage()+ "% OFF");
           // double res = (Double.parseDouble(medicine.getProductInfo().get(0).getProductPrice()) / 100.0f) * medicine.getProductInfo().get(0).getProductDiscount();
          //  res = Double.parseDouble(medicine.getProductInfo().get(0).getProductPrice()) - res;
         //   holder.price.setText(sessionManager.getStringData(currency) + new DecimalFormat("##.##").format(res));
            holder.priceoofer.setPaintFlags(holder.priceoofer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.priceoofer.setText( "₹"+medicineList.get(position).getDiscounted_price());

     //   }
        holder.txtTitle.setText(medicineList.get(position).getProduct_name());

        Glide.with(mContext).load(APIClient.baseUrl+"/uploads/products/"+medicineList.get(position).getImg().get(0)).thumbnail(Glide.with(mContext).load(R.drawable.ezgifresize)).centerCrop().into(holder.imgIcon);
    //  holder.lvlClick.setOnClickListener(v -> listener.onClickProductItem("category.getCatname()", medicineList));
    holder.lvlClick.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            v.getContext().startActivity(new Intent(mContext, ProductDetailsActivity.class)
                    .putExtra("manufacturer",medicineList.get(position).getManufacturer())
                    .putExtra("composition",medicineList.get(position).getComposition())
                    .putExtra("packing_type",medicineList.get(position).getPacking_type())
                    .putExtra("packaging",medicineList.get(position).getPackaging())
                    .putExtra("schedule",medicineList.get(position).getSchedule())
                    .putExtra("product_name",medicineList.get(position).getProduct_name())
                    .putExtra("mrp",medicineList.get(position).getMrp())
                    .putExtra("discounted_price",medicineList.get(position).getDiscounted_price())
                    .putExtra("product_id",medicineList.get(position).getProduct_id())
                    .putExtra("discounted_percentage",medicineList.get(position).getDiscounted_percentage())
                    .putExtra("shipping_price",medicineList.get(position).getShipping_price())
                    .putExtra("ImageList",medicineList.get(position).getImg()));

        }

    });
    }


    @Override
    public int getItemCount() {
        return medicineList.size();
    }
}