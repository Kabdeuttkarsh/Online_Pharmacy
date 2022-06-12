// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CoupunActivity_ViewBinding implements Unbinder {
  private CoupunActivity target;

  private View view7f090141;

  @UiThread
  public CoupunActivity_ViewBinding(CoupunActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CoupunActivity_ViewBinding(final CoupunActivity target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.img_back, "method 'onClick'");
    view7f090141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CoupunActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
  }
}
