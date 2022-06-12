// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  private View view7f0902da;

  private View view7f090221;

  private View view7f090169;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(final HomeActivity target, View source) {
    this.target = target;

    View view;
    target.bottomNavigation = Utils.findRequiredViewAsType(source, R.id.bottom_navigation, "field 'bottomNavigation'", BottomNavigationView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.txt_location, "field 'txtLocation' and method 'onClick'");
    target.txtLocation = Utils.castView(view, R.id.txt_location, "field 'txtLocation'", TextView.class);
    view7f0902da = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rlt_cart, "method 'onClick'");
    view7f090221 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_actionsearch, "method 'onClick'");
    view7f090169 = view;
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
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.bottomNavigation = null;
    target.container = null;
    target.txtLocation = null;

    view7f0902da.setOnClickListener(null);
    view7f0902da = null;
    view7f090221.setOnClickListener(null);
    view7f090221 = null;
    view7f090169.setOnClickListener(null);
    view7f090169 = null;
  }
}
