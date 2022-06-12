// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductFragment_ViewBinding implements Unbinder {
  private ProductFragment target;

  @UiThread
  public ProductFragment_ViewBinding(ProductFragment target, View source) {
    this.target = target;

    target.recyclerProduct = Utils.findRequiredViewAsType(source, R.id.recycler_product, "field 'recyclerProduct'", RecyclerView.class);
    target.txtNotfount = Utils.findRequiredViewAsType(source, R.id.txt_notfount, "field 'txtNotfount'", TextView.class);
    target.lvlNotfound = Utils.findRequiredViewAsType(source, R.id.lvl_notfound, "field 'lvlNotfound'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerProduct = null;
    target.txtNotfount = null;
    target.lvlNotfound = null;
  }
}
