// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForgotActivity_ViewBinding implements Unbinder {
  private ForgotActivity target;

  private View view7f090141;

  private View view7f09007e;

  @UiThread
  public ForgotActivity_ViewBinding(ForgotActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ForgotActivity_ViewBinding(final ForgotActivity target, View source) {
    this.target = target;

    View view;
    target.edMobile = Utils.findRequiredViewAsType(source, R.id.ed_mobile, "field 'edMobile'", EditText.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinner'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.img_back, "method 'onClick'");
    view7f090141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_submit, "method 'onClick'");
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
    ForgotActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edMobile = null;
    target.spinner = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
    view7f09007e.setOnClickListener(null);
    view7f09007e = null;
  }
}
