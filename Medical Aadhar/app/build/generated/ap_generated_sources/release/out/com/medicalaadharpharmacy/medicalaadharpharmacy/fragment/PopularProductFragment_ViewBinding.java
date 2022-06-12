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

public class PopularProductFragment_ViewBinding implements Unbinder {
  private PopularProductFragment target;

  @UiThread
  public PopularProductFragment_ViewBinding(PopularProductFragment target, View source) {
    this.target = target;

    target.recyclerProduct = Utils.findRequiredViewAsType(source, R.id.recycler_product, "field 'recyclerProduct'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PopularProductFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerProduct = null;
  }
}
