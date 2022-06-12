// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.adepter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CouponAdp$MyViewHolder_ViewBinding implements Unbinder {
  private CouponAdp.MyViewHolder target;

  @UiThread
  public CouponAdp$MyViewHolder_ViewBinding(CouponAdp.MyViewHolder target, View source) {
    this.target = target;

    target.txtCoupon = Utils.findRequiredViewAsType(source, R.id.txt_coupon, "field 'txtCoupon'", TextView.class);
    target.txtApply = Utils.findRequiredViewAsType(source, R.id.txt_apply, "field 'txtApply'", TextView.class);
    target.txtTitel = Utils.findRequiredViewAsType(source, R.id.txt_titel, "field 'txtTitel'", TextView.class);
    target.txtAmount = Utils.findRequiredViewAsType(source, R.id.txt_amount, "field 'txtAmount'", TextView.class);
    target.txtDesc = Utils.findRequiredViewAsType(source, R.id.txt_desc, "field 'txtDesc'", TextView.class);
    target.imgCode = Utils.findRequiredViewAsType(source, R.id.img_code, "field 'imgCode'", CircleImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CouponAdp.MyViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtCoupon = null;
    target.txtApply = null;
    target.txtTitel = null;
    target.txtAmount = null;
    target.txtDesc = null;
    target.imgCode = null;
  }
}
