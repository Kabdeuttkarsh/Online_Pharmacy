// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PresCartActivity$ItemAdp$ViewHolder_ViewBinding implements Unbinder {
  private PresCartActivity.ItemAdp.ViewHolder target;

  @UiThread
  public PresCartActivity$ItemAdp$ViewHolder_ViewBinding(PresCartActivity.ItemAdp.ViewHolder target,
      View source) {
    this.target = target;

    target.imgIcon = Utils.findRequiredViewAsType(source, R.id.img_icon, "field 'imgIcon'", ImageView.class);
    target.txtTitle = Utils.findRequiredViewAsType(source, R.id.txt_title, "field 'txtTitle'", TextView.class);
    target.txtDscount = Utils.findRequiredViewAsType(source, R.id.txt_dscount, "field 'txtDscount'", TextView.class);
    target.txtPrice = Utils.findRequiredViewAsType(source, R.id.txt_price, "field 'txtPrice'", TextView.class);
    target.txtPtype = Utils.findRequiredViewAsType(source, R.id.txt_ptype, "field 'txtPtype'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PresCartActivity.ItemAdp.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgIcon = null;
    target.txtTitle = null;
    target.txtDscount = null;
    target.txtPrice = null;
    target.txtPtype = null;
  }
}
