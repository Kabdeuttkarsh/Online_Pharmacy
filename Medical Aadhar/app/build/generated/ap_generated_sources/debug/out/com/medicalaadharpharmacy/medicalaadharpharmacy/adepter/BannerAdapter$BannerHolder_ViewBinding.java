// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.adepter;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BannerAdapter$BannerHolder_ViewBinding implements Unbinder {
  private BannerAdapter.BannerHolder target;

  @UiThread
  public BannerAdapter$BannerHolder_ViewBinding(BannerAdapter.BannerHolder target, View source) {
    this.target = target;

    target.imgBanner = Utils.findRequiredViewAsType(source, R.id.img_banner, "field 'imgBanner'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BannerAdapter.BannerHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBanner = null;
  }
}
