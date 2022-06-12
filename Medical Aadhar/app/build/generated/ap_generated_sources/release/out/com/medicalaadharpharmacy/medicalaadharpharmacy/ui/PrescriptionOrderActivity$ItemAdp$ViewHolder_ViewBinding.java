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

public class PrescriptionOrderActivity$ItemAdp$ViewHolder_ViewBinding implements Unbinder {
  private PrescriptionOrderActivity.ItemAdp.ViewHolder target;

  @UiThread
  public PrescriptionOrderActivity$ItemAdp$ViewHolder_ViewBinding(
      PrescriptionOrderActivity.ItemAdp.ViewHolder target, View source) {
    this.target = target;

    target.txtOrder = Utils.findRequiredViewAsType(source, R.id.txt_order, "field 'txtOrder'", TextView.class);
    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.txt_total, "field 'txtTotal'", TextView.class);
    target.txtOrderstatus = Utils.findRequiredViewAsType(source, R.id.txt_orderstatus, "field 'txtOrderstatus'", TextView.class);
    target.txtOrderdate = Utils.findRequiredViewAsType(source, R.id.txt_orderdate, "field 'txtOrderdate'", TextView.class);
    target.txtInfo = Utils.findRequiredViewAsType(source, R.id.txt_info, "field 'txtInfo'", TextView.class);
    target.txtCancel = Utils.findRequiredViewAsType(source, R.id.txt_cancel, "field 'txtCancel'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PrescriptionOrderActivity.ItemAdp.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtOrder = null;
    target.txtTotal = null;
    target.txtOrderstatus = null;
    target.txtOrderdate = null;
    target.txtInfo = null;
    target.txtCancel = null;
  }
}
