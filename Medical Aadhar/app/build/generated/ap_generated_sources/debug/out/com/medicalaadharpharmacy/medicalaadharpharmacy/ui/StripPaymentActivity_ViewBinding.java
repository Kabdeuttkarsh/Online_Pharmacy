// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StripPaymentActivity_ViewBinding implements Unbinder {
  private StripPaymentActivity target;

  @UiThread
  public StripPaymentActivity_ViewBinding(StripPaymentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StripPaymentActivity_ViewBinding(StripPaymentActivity target, View source) {
    this.target = target;

    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.txt_total, "field 'txtTotal'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StripPaymentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtTotal = null;
  }
}
