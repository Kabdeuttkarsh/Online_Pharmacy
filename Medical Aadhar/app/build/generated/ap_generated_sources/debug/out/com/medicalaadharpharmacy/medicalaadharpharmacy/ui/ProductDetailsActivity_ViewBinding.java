// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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

public class ProductDetailsActivity_ViewBinding implements Unbinder {
  private ProductDetailsActivity target;

  private View view7f090073;

  private View view7f090141;

  private View view7f090221;

  @UiThread
  public ProductDetailsActivity_ViewBinding(ProductDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProductDetailsActivity_ViewBinding(final ProductDetailsActivity target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.my_recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.recyclerSuggested = Utils.findRequiredViewAsType(source, R.id.recycler_suggested, "field 'recyclerSuggested'", RecyclerView.class);
    target.txtTitle = Utils.findRequiredViewAsType(source, R.id.txt_title, "field 'txtTitle'", TextView.class);
    target.txtPrice = Utils.findRequiredViewAsType(source, R.id.txt_price, "field 'txtPrice'", TextView.class);
    target.txtItemOffer = Utils.findRequiredViewAsType(source, R.id.txt_item_offer, "field 'txtItemOffer'", TextView.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinner'", Spinner.class);
    target.txtCountcard = Utils.findRequiredViewAsType(source, R.id.txt_countcard, "field 'txtCountcard'", TextView.class);
    target.txtOffer = Utils.findRequiredViewAsType(source, R.id.txt_offer, "field 'txtOffer'", TextView.class);
    target.lvlOffer = Utils.findRequiredViewAsType(source, R.id.lvl_offer, "field 'lvlOffer'", LinearLayout.class);
    target.lvlAddcart = Utils.findRequiredViewAsType(source, R.id.lvl_addcart, "field 'lvlAddcart'", LinearLayout.class);
    target.txtDesc = Utils.findRequiredViewAsType(source, R.id.txt_desc, "field 'txtDesc'", TextView.class);
    target.txtBrandname = Utils.findRequiredViewAsType(source, R.id.txt_brandname, "field 'txtBrandname'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_addtocart, "field 'btnAddtocart' and method 'onClick'");
    target.btnAddtocart = Utils.castView(view, R.id.btn_addtocart, "field 'btnAddtocart'", TextView.class);
    view7f090073 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtPriceone = Utils.findRequiredViewAsType(source, R.id.txt_priceone, "field 'txtPriceone'", TextView.class);
    target.lvlSpineer = Utils.findRequiredViewAsType(source, R.id.lvl_spineer, "field 'lvlSpineer'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtSchedule = Utils.findRequiredViewAsType(source, R.id.txt_schedule, "field 'txtSchedule'", TextView.class);
    target.txtManufacturer = Utils.findRequiredViewAsType(source, R.id.txt_manufacturer, "field 'txtManufacturer'", TextView.class);
    target.txtComposition = Utils.findRequiredViewAsType(source, R.id.txt_composition, "field 'txtComposition'", TextView.class);
    target.txtPackingType = Utils.findRequiredViewAsType(source, R.id.txt_packing_type, "field 'txtPackingType'", TextView.class);
    target.txtPackaging = Utils.findRequiredViewAsType(source, R.id.txt_packaging, "field 'txtPackaging'", TextView.class);
    target.txtAddCart = Utils.findRequiredViewAsType(source, R.id.txt_add_cart, "field 'txtAddCart'", TextView.class);
    target.rxRequiredText = Utils.findRequiredViewAsType(source, R.id.rx_required_text, "field 'rxRequiredText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rlt_cart, "method 'onClick'");
    view7f090221 = view;
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
    ProductDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.recyclerSuggested = null;
    target.txtTitle = null;
    target.txtPrice = null;
    target.txtItemOffer = null;
    target.spinner = null;
    target.txtCountcard = null;
    target.txtOffer = null;
    target.lvlOffer = null;
    target.lvlAddcart = null;
    target.txtDesc = null;
    target.txtBrandname = null;
    target.btnAddtocart = null;
    target.txtPriceone = null;
    target.lvlSpineer = null;
    target.imgBack = null;
    target.txtSchedule = null;
    target.txtManufacturer = null;
    target.txtComposition = null;
    target.txtPackingType = null;
    target.txtPackaging = null;
    target.txtAddCart = null;
    target.rxRequiredText = null;

    view7f090073.setOnClickListener(null);
    view7f090073 = null;
    view7f090141.setOnClickListener(null);
    view7f090141 = null;
    view7f090221.setOnClickListener(null);
    view7f090221 = null;
  }
}
