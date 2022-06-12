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

public class UploadPrescriptionActivity_ViewBinding implements Unbinder {
  private UploadPrescriptionActivity target;

  private View view7f090141;

  private View view7f0902ef;

  private View view7f090080;

  private View view7f0902c3;

  private View view7f090074;

  private View view7f09007e;

  @UiThread
  public UploadPrescriptionActivity_ViewBinding(UploadPrescriptionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UploadPrescriptionActivity_ViewBinding(final UploadPrescriptionActivity target,
      View source) {
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
    target.txtActiontitle = Utils.findRequiredViewAsType(source, R.id.txt_actiontitle, "field 'txtActiontitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
    view = Utils.findRequiredView(source, R.id.txt_prescription_valid, "field 'txtPrescriptionValid' and method 'onClick'");
    target.txtPrescriptionValid = Utils.castView(view, R.id.txt_prescription_valid, "field 'txtPrescriptionValid'", TextView.class);
    view7f0902ef = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_upload, "field 'btnUpload' and method 'onClick'");
    target.btnUpload = Utils.castView(view, R.id.btn_upload, "field 'btnUpload'", TextView.class);
    view7f090080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.lvlEmpty = Utils.findRequiredViewAsType(source, R.id.lvl_empty, "field 'lvlEmpty'", LinearLayout.class);
    target.lvlPic = Utils.findRequiredViewAsType(source, R.id.lvl_pic, "field 'lvlPic'", LinearLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.txtAtype = Utils.findRequiredViewAsType(source, R.id.txt_atype, "field 'txtAtype'", TextView.class);
    target.txtAddress = Utils.findRequiredViewAsType(source, R.id.txt_address, "field 'txtAddress'", TextView.class);
    view = Utils.findRequiredView(source, R.id.txt_changeadress, "field 'txtChangeadress' and method 'onClick'");
    target.txtChangeadress = Utils.castView(view, R.id.txt_changeadress, "field 'txtChangeadress'", TextView.class);
    view7f0902c3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_ather, "field 'btnAther' and method 'onClick'");
    target.btnAther = Utils.castView(view, R.id.btn_ather, "field 'btnAther'", TextView.class);
    view7f090074 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_submit, "field 'btnSubmit' and method 'onClick'");
    target.btnSubmit = Utils.castView(view, R.id.btn_submit, "field 'btnSubmit'", TextView.class);
    view7f09007e = view;
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
    UploadPrescriptionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.txtActiontitle = null;
    target.toolbar = null;
    target.appBarLayout = null;
    target.txtPrescriptionValid = null;
    target.btnUpload = null;
    target.lvlEmpty = null;
    target.lvlPic = null;
    target.recyclerView = null;
    target.txtAtype = null;
    target.txtAddress = null;
    target.txtChangeadress = null;
    target.btnAther = null;
    target.btnSubmit = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
    view7f0902ef.setOnClickListener(null);
    view7f0902ef = null;
    view7f090080.setOnClickListener(null);
    view7f090080 = null;
    view7f0902c3.setOnClickListener(null);
    view7f0902c3 = null;
    view7f090074.setOnClickListener(null);
    view7f090074 = null;
    view7f09007e.setOnClickListener(null);
    view7f09007e = null;
  }
}
