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

public class EditProfileActivity_ViewBinding implements Unbinder {
  private EditProfileActivity target;

  private View view7f090076;

  private View view7f090141;

  @UiThread
  public EditProfileActivity_ViewBinding(EditProfileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditProfileActivity_ViewBinding(final EditProfileActivity target, View source) {
    this.target = target;

    View view;
    target.edFirstName = Utils.findRequiredViewAsType(source, R.id.ed_firstname, "field 'edFirstName'", EditText.class);
    target.edLastName = Utils.findRequiredViewAsType(source, R.id.ed_lastname, "field 'edLastName'", EditText.class);
    target.edEmail = Utils.findRequiredViewAsType(source, R.id.ed_email, "field 'edEmail'", TextView.class);
    target.edPassword = Utils.findRequiredViewAsType(source, R.id.ed_password, "field 'edPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_countinue, "field 'btuContinues' and method 'onClick'");
    target.btuContinues = Utils.castView(view, R.id.btn_countinue, "field 'btuContinues'", TextView.class);
    view7f090076 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.edRefferalCode = Utils.findRequiredViewAsType(source, R.id.ed_refferalCode, "field 'edRefferalCode'", TextView.class);
    target.edMobile = Utils.findRequiredViewAsType(source, R.id.ed_mobile, "field 'edMobile'", TextView.class);
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090141 = view;
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
    EditProfileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edFirstName = null;
    target.edLastName = null;
    target.edEmail = null;
    target.edPassword = null;
    target.btuContinues = null;
    target.edRefferalCode = null;
    target.edMobile = null;
    target.imgBack = null;

    view7f090076.setOnClickListener(null);
    view7f090076 = null;
    view7f090141.setOnClickListener(null);
    view7f090141 = null;
  }
}
