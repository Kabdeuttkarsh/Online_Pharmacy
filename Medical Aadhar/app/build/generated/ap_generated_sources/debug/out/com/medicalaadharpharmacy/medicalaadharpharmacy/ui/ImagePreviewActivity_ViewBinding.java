// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ImagePreviewActivity_ViewBinding implements Unbinder {
  private ImagePreviewActivity target;

  @UiThread
  public ImagePreviewActivity_ViewBinding(ImagePreviewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ImagePreviewActivity_ViewBinding(ImagePreviewActivity target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", ViewPager.class);
    target.tabview = Utils.findRequiredViewAsType(source, R.id.tabview, "field 'tabview'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ImagePreviewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.tabview = null;
  }
}
