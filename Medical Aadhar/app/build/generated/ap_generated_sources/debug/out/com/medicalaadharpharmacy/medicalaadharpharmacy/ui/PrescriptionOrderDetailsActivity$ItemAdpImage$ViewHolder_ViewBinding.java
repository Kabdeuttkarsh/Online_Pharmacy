// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PrescriptionOrderDetailsActivity$ItemAdpImage$ViewHolder_ViewBinding implements Unbinder {
  private PrescriptionOrderDetailsActivity.ItemAdpImage.ViewHolder target;

  @UiThread
  public PrescriptionOrderDetailsActivity$ItemAdpImage$ViewHolder_ViewBinding(
      PrescriptionOrderDetailsActivity.ItemAdpImage.ViewHolder target, View source) {
    this.target = target;

    target.imgIcon = Utils.findRequiredViewAsType(source, R.id.img_icon, "field 'imgIcon'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PrescriptionOrderDetailsActivity.ItemAdpImage.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgIcon = null;
  }
}
