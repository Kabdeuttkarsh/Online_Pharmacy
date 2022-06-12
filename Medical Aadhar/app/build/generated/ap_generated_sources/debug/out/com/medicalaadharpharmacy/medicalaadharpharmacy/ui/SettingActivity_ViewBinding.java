// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  private View view7f090141;

  private View view7f090180;

  private View view7f090183;

  private View view7f09016d;

  private View view7f09016f;

  private View view7f090168;

  private View view7f090172;

  private View view7f090186;

  private View view7f090189;

  private View view7f09017b;

  private View view7f090175;

  private View view7f09017e;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(final SettingActivity target, View source) {
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
    target.txtfirstl = Utils.findRequiredViewAsType(source, R.id.txtfirstl, "field 'txtfirstl'", TextView.class);
    target.txtName = Utils.findRequiredViewAsType(source, R.id.txt_name, "field 'txtName'", TextView.class);
    target.txtMob = Utils.findRequiredViewAsType(source, R.id.txt_mob, "field 'txtMob'", TextView.class);
    target.txtCopyr = Utils.findRequiredViewAsType(source, R.id.txt_copyr, "field 'txtCopyr'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lvl_myprescription, "field 'lvlMyprescription' and method 'onClick'");
    target.lvlMyprescription = Utils.castView(view, R.id.lvl_myprescription, "field 'lvlMyprescription'", LinearLayout.class);
    view7f090180 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_order, "method 'onClick'");
    view7f090183 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_address, "method 'onClick'");
    view7f09016d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_change_password, "method 'onClick'");
    view7f09016f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_about, "method 'onClick'");
    view7f090168 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_contect, "method 'onClick'");
    view7f090172 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_privacy, "method 'onClick'");
    view7f090186 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_teams, "method 'onClick'");
    view7f090189 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_logot, "method 'onClick'");
    view7f09017b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_edit, "method 'onClick'");
    view7f090175 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_mylicences, "method 'onClick'");
    view7f09017e = view;
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
    SettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.txtfirstl = null;
    target.txtName = null;
    target.txtMob = null;
    target.txtCopyr = null;
    target.lvlMyprescription = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
    view7f090180.setOnClickListener(null);
    view7f090180 = null;
    view7f090183.setOnClickListener(null);
    view7f090183 = null;
    view7f09016d.setOnClickListener(null);
    view7f09016d = null;
    view7f09016f.setOnClickListener(null);
    view7f09016f = null;
    view7f090168.setOnClickListener(null);
    view7f090168 = null;
    view7f090172.setOnClickListener(null);
    view7f090172 = null;
    view7f090186.setOnClickListener(null);
    view7f090186 = null;
    view7f090189.setOnClickListener(null);
    view7f090189 = null;
    view7f09017b.setOnClickListener(null);
    view7f09017b = null;
    view7f090175.setOnClickListener(null);
    view7f090175 = null;
    view7f09017e.setOnClickListener(null);
    view7f09017e = null;
  }
}
