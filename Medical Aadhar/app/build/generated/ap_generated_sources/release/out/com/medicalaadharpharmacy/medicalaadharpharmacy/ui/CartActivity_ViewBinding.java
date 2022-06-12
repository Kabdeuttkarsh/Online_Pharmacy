// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CartActivity_ViewBinding implements Unbinder {
  private CartActivity target;

  private View view7f090140;

  private View view7f090144;

  private View view7f0902c1;

  private View view7f090079;

  private View view7f090076;

  @UiThread
  public CartActivity_ViewBinding(CartActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CartActivity_ViewBinding(final CartActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtActionTitle = Utils.findRequiredViewAsType(source, R.id.txt_actiontitle, "field 'txtActionTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
    target.myRecyclerView = Utils.findRequiredViewAsType(source, R.id.my_recycler_view, "field 'myRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.img_coopncode, "field 'imgCoupnCode' and method 'onClick'");
    target.imgCoupnCode = Utils.castView(view, R.id.img_coopncode, "field 'imgCoupnCode'", ImageView.class);
    view7f090144 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.edCustom = Utils.findRequiredViewAsType(source, R.id.ed_customnot, "field 'edCustom'", EditText.class);
    target.txtAddress = Utils.findRequiredViewAsType(source, R.id.txt_address, "field 'txtAddress'", TextView.class);
    view = Utils.findRequiredView(source, R.id.txt_changeadress, "field 'tatChangeless' and method 'onClick'");
    target.tatChangeless = Utils.castView(view, R.id.txt_changeadress, "field 'tatChangeless'", TextView.class);
    view7f0902c1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_proceed, "field 'btnProceed' and method 'onClick'");
    target.btnProceed = Utils.castView(view, R.id.btn_proceed, "field 'btnProceed'", TextView.class);
    view7f090079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtItemTotal = Utils.findRequiredViewAsType(source, R.id.txt_itemtotal, "field 'txtItemTotal'", TextView.class);
    target.txtDCharge = Utils.findRequiredViewAsType(source, R.id.txt_dcharge, "field 'txtDCharge'", TextView.class);
    target.txtDiscount = Utils.findRequiredViewAsType(source, R.id.txt_Discount, "field 'txtDiscount'", TextView.class);
    target.txtToPay = Utils.findRequiredViewAsType(source, R.id.txt_topay, "field 'txtToPay'", TextView.class);
    target.txtAType = Utils.findRequiredViewAsType(source, R.id.txt_atype, "field 'txtAType'", TextView.class);
    target.lvlMain = Utils.findRequiredViewAsType(source, R.id.lvl_main, "field 'lvlMain'", LinearLayout.class);
    target.lvlNotFound = Utils.findRequiredViewAsType(source, R.id.lvl_notfound, "field 'lvlNotFound'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_countinue, "method 'onClick'");
    view7f090076 = view;
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
    CartActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.txtActionTitle = null;
    target.toolbar = null;
    target.appBarLayout = null;
    target.myRecyclerView = null;
    target.imgCoupnCode = null;
    target.edCustom = null;
    target.txtAddress = null;
    target.tatChangeless = null;
    target.btnProceed = null;
    target.txtItemTotal = null;
    target.txtDCharge = null;
    target.txtDiscount = null;
    target.txtToPay = null;
    target.txtAType = null;
    target.lvlMain = null;
    target.lvlNotFound = null;

    view7f090140.setOnClickListener(null);
    view7f090140 = null;
    view7f090144.setOnClickListener(null);
    view7f090144 = null;
    view7f0902c1.setOnClickListener(null);
    view7f0902c1 = null;
    view7f090079.setOnClickListener(null);
    view7f090079 = null;
    view7f090076.setOnClickListener(null);
    view7f090076 = null;
  }
}
