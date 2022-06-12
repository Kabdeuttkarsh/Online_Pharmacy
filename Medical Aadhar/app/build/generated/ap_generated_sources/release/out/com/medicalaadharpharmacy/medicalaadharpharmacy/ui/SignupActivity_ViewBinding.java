// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.EditText;
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

public class SignupActivity_ViewBinding implements Unbinder {
  private SignupActivity target;

  private View view7f09007d;

  private View view7f0902dc;

  private View view7f0902e2;

  private View view7f0902d1;

  @UiThread
  public SignupActivity_ViewBinding(SignupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SignupActivity_ViewBinding(final SignupActivity target, View source) {
    this.target = target;

    View view;
    target.edMobile = Utils.findRequiredViewAsType(source, R.id.ed_mobile, "field 'edMobile'", EditText.class);
    target.edEmail = Utils.findRequiredViewAsType(source, R.id.ed_email, "field 'edEmail'", EditText.class);
    target.edPassword = Utils.findRequiredViewAsType(source, R.id.ed_password, "field 'edPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_signUp, "field 'btnSignUp' and method 'onClick'");
    target.btnSignUp = Utils.castView(view, R.id.btn_signUp, "field 'btnSignUp'", TextView.class);
    view7f09007d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.edFullname = Utils.findRequiredViewAsType(source, R.id.ed_fullname, "field 'edFullname'", EditText.class);
    target.edPincode = Utils.findRequiredViewAsType(source, R.id.ed_pincode, "field 'edPincode'", EditText.class);
    target.edCity = Utils.findRequiredViewAsType(source, R.id.ed_city, "field 'edCity'", EditText.class);
    target.edState = Utils.findRequiredViewAsType(source, R.id.ed_state, "field 'edState'", EditText.class);
    target.edCountry = Utils.findRequiredViewAsType(source, R.id.ed_country, "field 'edCountry'", EditText.class);
    target.edStreetAddress = Utils.findRequiredViewAsType(source, R.id.ed_streetAddress, "field 'edStreetAddress'", EditText.class);
    target.edAddress = Utils.findRequiredViewAsType(source, R.id.ed_address, "field 'edAddress'", EditText.class);
    target.edRefferalCode = Utils.findRequiredViewAsType(source, R.id.ed_refferalCode, "field 'edRefferalCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.txt_newuser, "method 'onClick'");
    target.txtLogin = Utils.castView(view, R.id.txt_newuser, "field 'txtLogin'", TextView.class);
    view7f0902dc = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.lvlLogin = Utils.findRequiredViewAsType(source, R.id.lvl_login, "field 'lvlLogin'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.txt_olduser, "method 'onClick'");
    view7f0902e2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_forgotclick, "method 'onClick'");
    view7f0902d1 = view;
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
    SignupActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edMobile = null;
    target.edEmail = null;
    target.edPassword = null;
    target.btnSignUp = null;
    target.edFullname = null;
    target.edPincode = null;
    target.edCity = null;
    target.edState = null;
    target.edCountry = null;
    target.edStreetAddress = null;
    target.edAddress = null;
    target.edRefferalCode = null;
    target.txtLogin = null;
    target.lvlLogin = null;

    view7f09007d.setOnClickListener(null);
    view7f09007d = null;
    view7f0902dc.setOnClickListener(null);
    view7f0902dc = null;
    view7f0902e2.setOnClickListener(null);
    view7f0902e2 = null;
    view7f0902d1.setOnClickListener(null);
    view7f0902d1 = null;
  }
}
