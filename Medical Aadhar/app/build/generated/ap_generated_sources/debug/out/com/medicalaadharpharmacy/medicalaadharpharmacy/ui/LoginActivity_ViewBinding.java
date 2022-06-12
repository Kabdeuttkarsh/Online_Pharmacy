// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view7f0902e4;

  private View view7f090079;

  private View view7f0902df;

  private View view7f0902d3;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinner'", Spinner.class);
    target.edMobile = Utils.findRequiredViewAsType(source, R.id.ed_mobile, "field 'edMobile'", EditText.class);
    target.edEmail = Utils.findRequiredViewAsType(source, R.id.ed_email, "field 'edEmail'", EditText.class);
    target.edPassword = Utils.findRequiredViewAsType(source, R.id.ed_password, "field 'edPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.txt_olduser, "field 'txtSingUp' and method 'onClick'");
    target.txtSingUp = Utils.castView(view, R.id.txt_olduser, "field 'txtSingUp'", TextView.class);
    view7f0902e4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_proceed, "field 'btnProceed' and method 'onClick'");
    target.btnProceed = Utils.castView(view, R.id.btn_proceed, "field 'btnProceed'", TextView.class);
    view7f090079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtLogin = Utils.findOptionalViewAsType(source, R.id.txt_newuser, "field 'txtLogin'", TextView.class);
    view = Utils.findRequiredView(source, R.id.txt_newuser1, "field 'txtLogin1' and method 'onClick'");
    target.txtLogin1 = Utils.castView(view, R.id.txt_newuser1, "field 'txtLogin1'", TextView.class);
    view7f0902df = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.lvlLogin = Utils.findRequiredViewAsType(source, R.id.lvl_login, "field 'lvlLogin'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.txt_forgotclick, "method 'onClick'");
    view7f0902d3 = view;
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
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spinner = null;
    target.edMobile = null;
    target.edEmail = null;
    target.edPassword = null;
    target.txtSingUp = null;
    target.btnProceed = null;
    target.txtLogin = null;
    target.txtLogin1 = null;
    target.lvlLogin = null;

    view7f0902e4.setOnClickListener(null);
    view7f0902e4 = null;
    view7f090079.setOnClickListener(null);
    view7f090079 = null;
    view7f0902df.setOnClickListener(null);
    view7f0902df = null;
    view7f0902d3.setOnClickListener(null);
    view7f0902d3 = null;
  }
}
