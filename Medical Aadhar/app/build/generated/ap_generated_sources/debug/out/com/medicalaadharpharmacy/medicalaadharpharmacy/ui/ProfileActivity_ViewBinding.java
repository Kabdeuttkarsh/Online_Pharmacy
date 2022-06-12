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

public class ProfileActivity_ViewBinding implements Unbinder {
  private ProfileActivity target;

  private View view7f090076;

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileActivity_ViewBinding(final ProfileActivity target, View source) {
    this.target = target;

    View view;
    target.edFirstname = Utils.findRequiredViewAsType(source, R.id.ed_firstname, "field 'edFirstname'", EditText.class);
    target.edLastname = Utils.findRequiredViewAsType(source, R.id.ed_lastname, "field 'edLastname'", EditText.class);
    target.edEmail = Utils.findRequiredViewAsType(source, R.id.ed_email, "field 'edEmail'", EditText.class);
    target.edPassword = Utils.findRequiredViewAsType(source, R.id.ed_password, "field 'edPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_countinue, "field 'btnCountinue' and method 'onClick'");
    target.btnCountinue = Utils.castView(view, R.id.btn_countinue, "field 'btnCountinue'", TextView.class);
    view7f090076 = view;
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
    ProfileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edFirstname = null;
    target.edLastname = null;
    target.edEmail = null;
    target.edPassword = null;
    target.btnCountinue = null;

    view7f090076.setOnClickListener(null);
    view7f090076 = null;
  }
}
