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

public class VerifyOTPActivity_ViewBinding implements Unbinder {
  private VerifyOTPActivity target;

  private View view7f09007a;

  private View view7f09007c;

  @UiThread
  public VerifyOTPActivity_ViewBinding(VerifyOTPActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VerifyOTPActivity_ViewBinding(final VerifyOTPActivity target, View source) {
    this.target = target;

    View view;
    target.txtMob = Utils.findRequiredViewAsType(source, R.id.txt_mob, "field 'txtMob'", TextView.class);
    target.edOtp1 = Utils.findRequiredViewAsType(source, R.id.ed_otp1, "field 'edOtp1'", EditText.class);
    target.edOtp2 = Utils.findRequiredViewAsType(source, R.id.ed_otp2, "field 'edOtp2'", EditText.class);
    target.edOtp3 = Utils.findRequiredViewAsType(source, R.id.ed_otp3, "field 'edOtp3'", EditText.class);
    target.edOtp4 = Utils.findRequiredViewAsType(source, R.id.ed_otp4, "field 'edOtp4'", EditText.class);
    target.edOtp5 = Utils.findRequiredViewAsType(source, R.id.ed_otp5, "field 'edOtp5'", EditText.class);
    target.edOtp6 = Utils.findRequiredViewAsType(source, R.id.ed_otp6, "field 'edOtp6'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_reenter, "field 'btnReenter' and method 'onClick'");
    target.btnReenter = Utils.castView(view, R.id.btn_reenter, "field 'btnReenter'", TextView.class);
    view7f09007a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.btnTimer = Utils.findRequiredViewAsType(source, R.id.btn_timer, "field 'btnTimer'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_send, "method 'onClick'");
    view7f09007c = view;
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
    VerifyOTPActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtMob = null;
    target.edOtp1 = null;
    target.edOtp2 = null;
    target.edOtp3 = null;
    target.edOtp4 = null;
    target.edOtp5 = null;
    target.edOtp6 = null;
    target.btnReenter = null;
    target.btnTimer = null;

    view7f09007a.setOnClickListener(null);
    view7f09007a = null;
    view7f09007c.setOnClickListener(null);
    view7f09007c = null;
  }
}
