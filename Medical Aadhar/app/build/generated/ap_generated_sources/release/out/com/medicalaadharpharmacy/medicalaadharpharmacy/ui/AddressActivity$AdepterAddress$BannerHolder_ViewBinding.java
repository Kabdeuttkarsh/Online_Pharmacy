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

public class AddressActivity$AdepterAddress$BannerHolder_ViewBinding implements Unbinder {
  private AddressActivity.AdepterAddress.BannerHolder target;

  @UiThread
  public AddressActivity$AdepterAddress$BannerHolder_ViewBinding(
      AddressActivity.AdepterAddress.BannerHolder target, View source) {
    this.target = target;

    target.imgBanner = Utils.findRequiredViewAsType(source, R.id.img_banner, "field 'imgBanner'", ImageView.class);
    target.imgMenu = Utils.findRequiredViewAsType(source, R.id.img_menu, "field 'imgMenu'", ImageView.class);
    target.txtHomeaddress = Utils.findRequiredViewAsType(source, R.id.txt_homeaddress, "field 'txtHomeaddress'", TextView.class);
    target.txtType = Utils.findRequiredViewAsType(source, R.id.txt_tital, "field 'txtType'", TextView.class);
    target.lvlHome = Utils.findRequiredViewAsType(source, R.id.lvl_home, "field 'lvlHome'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddressActivity.AdepterAddress.BannerHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBanner = null;
    target.imgMenu = null;
    target.txtHomeaddress = null;
    target.txtType = null;
    target.lvlHome = null;
  }
}
