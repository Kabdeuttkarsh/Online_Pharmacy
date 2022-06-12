// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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

public class PrescriptionOrderDetailsActivity_ViewBinding implements Unbinder {
  private PrescriptionOrderDetailsActivity target;

  private View view7f090141;

  private View view7f0902f8;

  private View view7f0902d7;

  private View view7f09018d;

  @UiThread
  public PrescriptionOrderDetailsActivity_ViewBinding(PrescriptionOrderDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PrescriptionOrderDetailsActivity_ViewBinding(final PrescriptionOrderDetailsActivity target,
      View source) {
    this.target = target;

    View view;
    target.txtAddress = Utils.findRequiredViewAsType(source, R.id.txt_address, "field 'txtAddress'", TextView.class);
    target.txtAditionalinfo = Utils.findRequiredViewAsType(source, R.id.txt_aditionalinfo, "field 'txtAditionalinfo'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtActiontitle = Utils.findRequiredViewAsType(source, R.id.txt_actiontitle, "field 'txtActiontitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
    view = Utils.findRequiredView(source, R.id.txt_summary, "field 'txtSummary' and method 'onClick'");
    target.txtSummary = Utils.castView(view, R.id.txt_summary, "field 'txtSummary'", TextView.class);
    view7f0902f8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_item, "field 'txtItem' and method 'onClick'");
    target.txtItem = Utils.castView(view, R.id.txt_item, "field 'txtItem'", TextView.class);
    view7f0902d7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtOrderid = Utils.findRequiredViewAsType(source, R.id.txt_orderid, "field 'txtOrderid'", TextView.class);
    target.txtOrderstatus = Utils.findRequiredViewAsType(source, R.id.txt_orderstatus, "field 'txtOrderstatus'", TextView.class);
    target.txtOrderdate = Utils.findRequiredViewAsType(source, R.id.txt_orderdate, "field 'txtOrderdate'", TextView.class);
    target.txtOrderddate = Utils.findRequiredViewAsType(source, R.id.txt_orderddate, "field 'txtOrderddate'", TextView.class);
    target.scvSummry = Utils.findRequiredViewAsType(source, R.id.scv_summry, "field 'scvSummry'", ScrollView.class);
    target.myRecyclerView = Utils.findRequiredViewAsType(source, R.id.my_recycler_view, "field 'myRecyclerView'", RecyclerView.class);
    target.myRecyclerItem = Utils.findRequiredViewAsType(source, R.id.my_recycler_item, "field 'myRecyclerItem'", RecyclerView.class);
    target.scvItem = Utils.findRequiredViewAsType(source, R.id.scv_item, "field 'scvItem'", ScrollView.class);
    target.lvlAdditional = Utils.findRequiredViewAsType(source, R.id.lvl_additional, "field 'lvlAdditional'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.lvl_viewcart, "field 'lvlViewcart' and method 'onClick'");
    target.lvlViewcart = Utils.castView(view, R.id.lvl_viewcart, "field 'lvlViewcart'", LinearLayout.class);
    view7f09018d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.lvlSubtotle = Utils.findRequiredViewAsType(source, R.id.lvl_subtotle, "field 'lvlSubtotle'", LinearLayout.class);
    target.txtSubtotal = Utils.findRequiredViewAsType(source, R.id.txt_subtotal, "field 'txtSubtotal'", TextView.class);
    target.lvlDiscount = Utils.findRequiredViewAsType(source, R.id.lvl_discount, "field 'lvlDiscount'", LinearLayout.class);
    target.lvlDcharge = Utils.findRequiredViewAsType(source, R.id.lvl_dcharge, "field 'lvlDcharge'", LinearLayout.class);
    target.txtDcharge = Utils.findRequiredViewAsType(source, R.id.txt_dcharge, "field 'txtDcharge'", TextView.class);
    target.txtDiscount = Utils.findRequiredViewAsType(source, R.id.txt_discount, "field 'txtDiscount'", TextView.class);
    target.lvlTotal = Utils.findRequiredViewAsType(source, R.id.lvl_total, "field 'lvlTotal'", LinearLayout.class);
    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.txt_total, "field 'txtTotal'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PrescriptionOrderDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtAddress = null;
    target.txtAditionalinfo = null;
    target.imgBack = null;
    target.txtActiontitle = null;
    target.toolbar = null;
    target.appBarLayout = null;
    target.txtSummary = null;
    target.txtItem = null;
    target.txtOrderid = null;
    target.txtOrderstatus = null;
    target.txtOrderdate = null;
    target.txtOrderddate = null;
    target.scvSummry = null;
    target.myRecyclerView = null;
    target.myRecyclerItem = null;
    target.scvItem = null;
    target.lvlAdditional = null;
    target.lvlViewcart = null;
    target.lvlSubtotle = null;
    target.txtSubtotal = null;
    target.lvlDiscount = null;
    target.lvlDcharge = null;
    target.txtDcharge = null;
    target.txtDiscount = null;
    target.lvlTotal = null;
    target.txtTotal = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
    view7f0902f8.setOnClickListener(null);
    view7f0902f8 = null;
    view7f0902d7.setOnClickListener(null);
    view7f0902d7 = null;
    view7f09018d.setOnClickListener(null);
    view7f09018d = null;
  }
}
