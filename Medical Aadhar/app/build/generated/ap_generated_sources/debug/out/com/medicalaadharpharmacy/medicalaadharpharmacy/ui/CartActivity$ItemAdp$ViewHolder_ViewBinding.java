// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CartActivity$ItemAdp$ViewHolder_ViewBinding implements Unbinder {
  private CartActivity.ItemAdp.ViewHolder target;

  @UiThread
  public CartActivity$ItemAdp$ViewHolder_ViewBinding(CartActivity.ItemAdp.ViewHolder target,
      View source) {
    this.target = target;

    target.imgIcon = Utils.findRequiredViewAsType(source, R.id.img_icon, "field 'imgIcon'", ImageView.class);
    target.txtTitle = Utils.findRequiredViewAsType(source, R.id.txt_title, "field 'txtTitle'", TextView.class);
    target.txtDscount = Utils.findRequiredViewAsType(source, R.id.txt_dscount, "field 'txtDscount'", TextView.class);
    target.txtPrice = Utils.findRequiredViewAsType(source, R.id.txt_price, "field 'txtPrice'", TextView.class);
    target.imgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'imgDelete'", ImageView.class);
    target.imgMins = Utils.findRequiredViewAsType(source, R.id.img_mins, "field 'imgMins'", LinearLayout.class);
    target.txtcount = Utils.findRequiredViewAsType(source, R.id.txtcount, "field 'txtcount'", TextView.class);
    target.imgPlus = Utils.findRequiredViewAsType(source, R.id.img_plus, "field 'imgPlus'", LinearLayout.class);
    target.lvlAddremove = Utils.findRequiredViewAsType(source, R.id.lvl_addremove, "field 'lvlAddremove'", LinearLayout.class);
    target.txtOffer = Utils.findRequiredViewAsType(source, R.id.txt_offer, "field 'txtOffer'", TextView.class);
    target.txtPtype = Utils.findRequiredViewAsType(source, R.id.txt_ptype, "field 'txtPtype'", TextView.class);
    target.rxRequiredText = Utils.findRequiredViewAsType(source, R.id.rx_required_text, "field 'rxRequiredText'", TextView.class);
    target.lvlOffer = Utils.findRequiredViewAsType(source, R.id.lvl_offer, "field 'lvlOffer'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CartActivity.ItemAdp.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgIcon = null;
    target.txtTitle = null;
    target.txtDscount = null;
    target.txtPrice = null;
    target.imgDelete = null;
    target.imgMins = null;
    target.txtcount = null;
    target.imgPlus = null;
    target.lvlAddremove = null;
    target.txtOffer = null;
    target.txtPtype = null;
    target.rxRequiredText = null;
    target.lvlOffer = null;
  }
}
