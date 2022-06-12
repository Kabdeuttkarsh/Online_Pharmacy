// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.fragment;

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

public class SubCategoryFragment_ViewBinding implements Unbinder {
  private SubCategoryFragment target;

  @UiThread
  public SubCategoryFragment_ViewBinding(SubCategoryFragment target, View source) {
    this.target = target;

    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
    target.vpPager = Utils.findRequiredViewAsType(source, R.id.vpPager, "field 'vpPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SubCategoryFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabLayout = null;
    target.vpPager = null;
  }
}
