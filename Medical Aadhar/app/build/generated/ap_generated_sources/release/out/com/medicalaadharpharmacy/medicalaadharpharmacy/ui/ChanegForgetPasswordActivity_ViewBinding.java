// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChanegForgetPasswordActivity_ViewBinding implements Unbinder {
  private ChanegForgetPasswordActivity target;

  private View view7f09007e;

  @UiThread
  public ChanegForgetPasswordActivity_ViewBinding(ChanegForgetPasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChanegForgetPasswordActivity_ViewBinding(final ChanegForgetPasswordActivity target,
      View source) {
    this.target = target;

    View view;
    target.edPassword = Utils.findRequiredViewAsType(source, R.id.ed_password, "field 'edPassword'", EditText.class);
    target.edConPassword = Utils.findRequiredViewAsType(source, R.id.ed_conpassword1, "field 'edConPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_submit, "field 'btnSubmit' and method 'onClick'");
    target.btnSubmit = Utils.castView(view, R.id.btn_submit, "field 'btnSubmit'", TextView.class);
    view7f09007e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ChanegForgetPasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edPassword = null;
    target.edConPassword = null;
    target.btnSubmit = null;

    view7f09007e.setOnClickListener(null);
    view7f09007e = null;
  }
}
