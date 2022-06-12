// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CompleOrderActivity_ViewBinding implements Unbinder {
  private CompleOrderActivity target;

  private View view7f090140;

  private View view7f090077;

  @UiThread
  public CompleOrderActivity_ViewBinding(CompleOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CompleOrderActivity_ViewBinding(final CompleOrderActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.img_back, "method 'onClick'");
    view7f090140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_myorder, "method 'onClick'");
    view7f090077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f090140.setOnClickListener(null);
    view7f090140 = null;
    view7f090077.setOnClickListener(null);
    view7f090077 = null;
  }
}
