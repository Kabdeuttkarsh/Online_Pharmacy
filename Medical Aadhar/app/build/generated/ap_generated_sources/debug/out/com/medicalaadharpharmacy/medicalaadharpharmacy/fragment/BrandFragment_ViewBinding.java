// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BrandFragment_ViewBinding implements Unbinder {
  private BrandFragment target;

  @UiThread
  public BrandFragment_ViewBinding(BrandFragment target, View source) {
    this.target = target;

    target.recyclerBrand = Utils.findRequiredViewAsType(source, R.id.recycler_brand, "field 'recyclerBrand'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BrandFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerBrand = null;
  }
}
