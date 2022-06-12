// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.adepter;

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

public class ProductHomeAdapter$MyViewHolder_ViewBinding implements Unbinder {
  private ProductHomeAdapter.MyViewHolder target;

  @UiThread
  public ProductHomeAdapter$MyViewHolder_ViewBinding(ProductHomeAdapter.MyViewHolder target,
      View source) {
    this.target = target;

    target.imgIcon = Utils.findRequiredViewAsType(source, R.id.img_icon, "field 'imgIcon'", ImageView.class);
    target.txtTitle = Utils.findRequiredViewAsType(source, R.id.txtTitle, "field 'txtTitle'", TextView.class);
    target.price = Utils.findRequiredViewAsType(source, R.id.price, "field 'price'", TextView.class);
    target.priceoofer = Utils.findRequiredViewAsType(source, R.id.priceoofer, "field 'priceoofer'", TextView.class);
    target.lvlClick = Utils.findRequiredViewAsType(source, R.id.lvl_click, "field 'lvlClick'", LinearLayout.class);
    target.txtOffer = Utils.findRequiredViewAsType(source, R.id.txt_offer, "field 'txtOffer'", TextView.class);
    target.lvlOffer = Utils.findRequiredViewAsType(source, R.id.lvl_offer, "field 'lvlOffer'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductHomeAdapter.MyViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgIcon = null;
    target.txtTitle = null;
    target.price = null;
    target.priceoofer = null;
    target.lvlClick = null;
    target.txtOffer = null;
    target.lvlOffer = null;
  }
}
