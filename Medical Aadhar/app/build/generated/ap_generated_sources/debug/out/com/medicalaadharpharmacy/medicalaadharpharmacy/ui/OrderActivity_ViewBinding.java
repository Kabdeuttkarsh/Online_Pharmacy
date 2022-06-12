// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
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

public class OrderActivity_ViewBinding implements Unbinder {
  private OrderActivity target;

  private View view7f090141;

  private View view7f0902f4;

  private View view7f0902cb;

  @UiThread
  public OrderActivity_ViewBinding(OrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderActivity_ViewBinding(final OrderActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtActionTitle = Utils.findRequiredViewAsType(source, R.id.txt_actiontitle, "field 'txtActionTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
    view = Utils.findRequiredView(source, R.id.txt_resent, "field 'txtResent' and method 'onClick'");
    target.txtResent = Utils.castView(view, R.id.txt_resent, "field 'txtResent'", TextView.class);
    view7f0902f4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_delivered, "field 'txtDelivered' and method 'onClick'");
    target.txtDelivered = Utils.castView(view, R.id.txt_delivered, "field 'txtDelivered'", TextView.class);
    view7f0902cb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.myRecyclerView = Utils.findRequiredViewAsType(source, R.id.my_recycler_view, "field 'myRecyclerView'", RecyclerView.class);
    target.txtNotFount = Utils.findRequiredViewAsType(source, R.id.txt_notfount, "field 'txtNotFount'", TextView.class);
    target.lvlNotfound = Utils.findRequiredViewAsType(source, R.id.lvl_notfound, "field 'lvlNotfound'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.txtActionTitle = null;
    target.toolbar = null;
    target.appBarLayout = null;
    target.txtResent = null;
    target.txtDelivered = null;
    target.myRecyclerView = null;
    target.txtNotFount = null;
    target.lvlNotfound = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
    view7f0902f4.setOnClickListener(null);
    view7f0902f4 = null;
    view7f0902cb.setOnClickListener(null);
    view7f0902cb = null;
  }
}
