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

public class OrderDetailsActivity_ViewBinding implements Unbinder {
  private OrderDetailsActivity target;

  private View view7f090140;

  private View view7f0902f6;

  private View view7f0902d5;

  @UiThread
  public OrderDetailsActivity_ViewBinding(OrderDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderDetailsActivity_ViewBinding(final OrderDetailsActivity target, View source) {
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
    view = Utils.findRequiredView(source, R.id.txt_summary, "field 'txtSummary' and method 'onClick'");
    target.txtSummary = Utils.castView(view, R.id.txt_summary, "field 'txtSummary'", TextView.class);
    view7f0902f6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_item, "field 'txtItem' and method 'onClick'");
    target.txtItem = Utils.castView(view, R.id.txt_item, "field 'txtItem'", TextView.class);
    view7f0902d5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtOrderId = Utils.findRequiredViewAsType(source, R.id.txt_orderid, "field 'txtOrderId'", TextView.class);
    target.txtOrderStatus = Utils.findRequiredViewAsType(source, R.id.txt_orderstatus, "field 'txtOrderStatus'", TextView.class);
    target.txtOrderDate = Utils.findRequiredViewAsType(source, R.id.txt_orderdate, "field 'txtOrderDate'", TextView.class);
    target.txtOrderDDate = Utils.findRequiredViewAsType(source, R.id.txt_orderddate, "field 'txtOrderDDate'", TextView.class);
    target.txtPaymentMethod = Utils.findRequiredViewAsType(source, R.id.txt_paymentmethod, "field 'txtPaymentMethod'", TextView.class);
    target.txtQut = Utils.findRequiredViewAsType(source, R.id.txt_qut, "field 'txtQut'", TextView.class);
    target.txtPrice = Utils.findRequiredViewAsType(source, R.id.txt_price, "field 'txtPrice'", TextView.class);
    target.txtDeliveryCharge = Utils.findRequiredViewAsType(source, R.id.txt_deliverycharge, "field 'txtDeliveryCharge'", TextView.class);
    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.txt_total, "field 'txtTotal'", TextView.class);
    target.schSummary = Utils.findRequiredViewAsType(source, R.id.scv_summry, "field 'schSummary'", ScrollView.class);
    target.scvItem = Utils.findRequiredViewAsType(source, R.id.scv_item, "field 'scvItem'", ScrollView.class);
    target.myRecyclerView = Utils.findRequiredViewAsType(source, R.id.my_recycler_view, "field 'myRecyclerView'", RecyclerView.class);
    target.txtAddress = Utils.findRequiredViewAsType(source, R.id.txt_address, "field 'txtAddress'", TextView.class);
    target.txtAdditionInfo = Utils.findRequiredViewAsType(source, R.id.txt_aditionalinfo, "field 'txtAdditionInfo'", TextView.class);
    target.lvlAditional = Utils.findRequiredViewAsType(source, R.id.lvl_aditional, "field 'lvlAditional'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.txtActionTitle = null;
    target.toolbar = null;
    target.appBarLayout = null;
    target.txtSummary = null;
    target.txtItem = null;
    target.txtOrderId = null;
    target.txtOrderStatus = null;
    target.txtOrderDate = null;
    target.txtOrderDDate = null;
    target.txtPaymentMethod = null;
    target.txtQut = null;
    target.txtPrice = null;
    target.txtDeliveryCharge = null;
    target.txtTotal = null;
    target.schSummary = null;
    target.scvItem = null;
    target.myRecyclerView = null;
    target.txtAddress = null;
    target.txtAdditionInfo = null;
    target.lvlAditional = null;

    view7f090140.setOnClickListener(null);
    view7f090140 = null;
    view7f0902f6.setOnClickListener(null);
    view7f0902f6 = null;
    view7f0902d5.setOnClickListener(null);
    view7f0902d5 = null;
  }
}
