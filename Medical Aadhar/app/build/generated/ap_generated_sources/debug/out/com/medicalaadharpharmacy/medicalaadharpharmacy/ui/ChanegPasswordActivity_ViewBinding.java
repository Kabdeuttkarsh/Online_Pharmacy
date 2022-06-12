// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChanegPasswordActivity_ViewBinding implements Unbinder {
  private ChanegPasswordActivity target;

  private View view7f090141;

  private View view7f09007e;

  @UiThread
  public ChanegPasswordActivity_ViewBinding(ChanegPasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChanegPasswordActivity_ViewBinding(final ChanegPasswordActivity target, View source) {
    this.target = target;

    View view;
    target.edOldPassword = Utils.findRequiredViewAsType(source, R.id.ed_old_password, "field 'edOldPassword'", EditText.class);
    target.edPassword = Utils.findRequiredViewAsType(source, R.id.ed_password, "field 'edPassword'", EditText.class);
    target.edConPassword = Utils.findRequiredViewAsType(source, R.id.ed_conpassword1, "field 'edConPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090141 = view;
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
    ChanegPasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edOldPassword = null;
    target.edPassword = null;
    target.edConPassword = null;
    target.imgBack = null;
    target.btnSubmit = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
    view7f09007e.setOnClickListener(null);
    view7f09007e = null;
  }
}
