// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view7f09018b;

  private View view7f090300;

  private View view7f090301;

  private View view7f09014d;

  private View view7f090148;

  private View view7f090143;

  private View view7f090140;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    target.myRecyclerBanner = Utils.findRequiredViewAsType(source, R.id.my_recycler_view, "field 'myRecyclerBanner'", RecyclerView.class);
    target.recyclerCategory = Utils.findRequiredViewAsType(source, R.id.recycler_category, "field 'recyclerCategory'", RecyclerView.class);
    target.recyclerProduct = Utils.findRequiredViewAsType(source, R.id.recycler_product, "field 'recyclerProduct'", RecyclerView.class);
    target.recyclerBrand = Utils.findRequiredViewAsType(source, R.id.recycler_brand, "field 'recyclerBrand'", RecyclerView.class);
    target.txtPrescription = Utils.findRequiredViewAsType(source, R.id.txt_uprescription, "field 'txtPrescription'", TextView.class);
    target.imgUpload = Utils.findRequiredViewAsType(source, R.id.img_upload, "field 'imgUpload'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.lvl_upload, "field 'lvlUpload' and method 'onClick'");
    target.lvlUpload = Utils.castView(view, R.id.lvl_upload, "field 'lvlUpload'", LinearLayout.class);
    view7f09018b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_viewll_category, "field 'txtViewAllCategory' and method 'onClick'");
    target.txtViewAllCategory = Utils.castView(view, R.id.txt_viewll_category, "field 'txtViewAllCategory'", TextView.class);
    view7f090300 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.lvlv = Utils.findRequiredViewAsType(source, R.id.lvlv, "field 'lvlv'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.txt_viewll_product, "field 'txtViewllProduct' and method 'onClick'");
    target.txtViewllProduct = Utils.castView(view, R.id.txt_viewll_product, "field 'txtViewllProduct'", TextView.class);
    view7f090301 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.lvlv1 = Utils.findRequiredViewAsType(source, R.id.lvlv1, "field 'lvlv1'", LinearLayout.class);
    target.lvlUploadpre = Utils.findRequiredViewAsType(source, R.id.lvl_uploadpre, "field 'lvlUploadpre'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.img_ordermedicin, "method 'onClick'");
    view7f09014d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.img_healthcare, "method 'onClick'");
    view7f090148 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.img_bookcall, "method 'onClick'");
    view7f090143 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.img_babycare, "method 'onClick'");
    view7f090140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.myRecyclerBanner = null;
    target.recyclerCategory = null;
    target.recyclerProduct = null;
    target.recyclerBrand = null;
    target.txtPrescription = null;
    target.imgUpload = null;
    target.lvlUpload = null;
    target.txtViewAllCategory = null;
    target.lvlv = null;
    target.txtViewllProduct = null;
    target.lvlv1 = null;
    target.lvlUploadpre = null;

    view7f09018b.setOnClickListener(null);
    view7f09018b = null;
    view7f090300.setOnClickListener(null);
    view7f090300 = null;
    view7f090301.setOnClickListener(null);
    view7f090301 = null;
    view7f09014d.setOnClickListener(null);
    view7f09014d = null;
    view7f090148.setOnClickListener(null);
    view7f090148 = null;
    view7f090143.setOnClickListener(null);
    view7f090143 = null;
    view7f090140.setOnClickListener(null);
    view7f090140 = null;
  }
}
