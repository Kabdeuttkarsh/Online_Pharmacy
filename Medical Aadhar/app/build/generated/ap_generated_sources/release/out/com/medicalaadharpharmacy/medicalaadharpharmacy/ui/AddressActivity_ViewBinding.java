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

public class AddressActivity_ViewBinding implements Unbinder {
  private AddressActivity target;

  private View view7f09017b;

  private View view7f090140;

  private View view7f09016f;

  @UiThread
  public AddressActivity_ViewBinding(AddressActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddressActivity_ViewBinding(final AddressActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lvl_myaddress, "field 'lvlMyAddress' and method 'onClick'");
    target.lvlMyAddress = Utils.castView(view, R.id.lvl_myaddress, "field 'lvlMyAddress'", LinearLayout.class);
    view7f09017b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
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
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.myRecyclerView = Utils.findRequiredViewAsType(source, R.id.my_recycler_view, "field 'myRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.lvl_clocation, "method 'onClick'");
    view7f09016f = view;
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
    AddressActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lvlMyAddress = null;
    target.imgBack = null;
    target.txtActionTitle = null;
    target.appBarLayout = null;
    target.toolbar = null;
    target.myRecyclerView = null;

    view7f09017b.setOnClickListener(null);
    view7f09017b = null;
    view7f090140.setOnClickListener(null);
    view7f090140 = null;
    view7f09016f.setOnClickListener(null);
    view7f09016f = null;
  }
}
