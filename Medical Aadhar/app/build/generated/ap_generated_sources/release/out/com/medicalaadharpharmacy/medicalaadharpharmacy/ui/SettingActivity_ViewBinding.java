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

  private View view7f090140;

  private View view7f09017e;

  private View view7f090181;

  private View view7f09016b;

  private View view7f09016d;

  private View view7f090166;

  private View view7f090170;

  private View view7f090184;

  private View view7f090187;

  private View view7f090179;

  private View view7f090173;

  private View view7f09017c;

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
    view7f090140 = view;
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
    view7f09017e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_order, "method 'onClick'");
    view7f090181 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_address, "method 'onClick'");
    view7f09016b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_change_password, "method 'onClick'");
    view7f09016d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_about, "method 'onClick'");
    view7f090166 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_contect, "method 'onClick'");
    view7f090170 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_privacy, "method 'onClick'");
    view7f090184 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_teams, "method 'onClick'");
    view7f090187 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_logot, "method 'onClick'");
    view7f090179 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_edit, "method 'onClick'");
    view7f090173 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lvl_mylicences, "method 'onClick'");
    view7f09017c = view;
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

    view7f090140.setOnClickListener(null);
    view7f090140 = null;
    view7f09017e.setOnClickListener(null);
    view7f09017e = null;
    view7f090181.setOnClickListener(null);
    view7f090181 = null;
    view7f09016b.setOnClickListener(null);
    view7f09016b = null;
    view7f09016d.setOnClickListener(null);
    view7f09016d = null;
    view7f090166.setOnClickListener(null);
    view7f090166 = null;
    view7f090170.setOnClickListener(null);
    view7f090170 = null;
    view7f090184.setOnClickListener(null);
    view7f090184 = null;
    view7f090187.setOnClickListener(null);
    view7f090187 = null;
    view7f090179.setOnClickListener(null);
    view7f090179 = null;
    view7f090173.setOnClickListener(null);
    view7f090173 = null;
    view7f09017c.setOnClickListener(null);
    view7f09017c = null;
  }
}
