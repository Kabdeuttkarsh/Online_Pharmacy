// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PaymentOptionActivity_ViewBinding implements Unbinder {
  private PaymentOptionActivity target;

  private View view7f090141;

  @UiThread
  public PaymentOptionActivity_ViewBinding(PaymentOptionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PaymentOptionActivity_ViewBinding(final PaymentOptionActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.lvlPaymentList = Utils.findRequiredViewAsType(source, R.id.lvl_paymentlist, "field 'lvlPaymentList'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PaymentOptionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.lvlPaymentList = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
  }
}
