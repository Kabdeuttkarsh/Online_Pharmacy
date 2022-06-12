// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import com.merhold.extensiblepageindicator.ExtensiblePageIndicator;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntroActivity_ViewBinding implements Unbinder {
  private IntroActivity target;

  private View view7f090078;

  @UiThread
  public IntroActivity_ViewBinding(IntroActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public IntroActivity_ViewBinding(final IntroActivity target, View source) {
    this.target = target;

    View view;
    target.flexibleIndicator = Utils.findRequiredViewAsType(source, R.id.flexibleIndicator, "field 'flexibleIndicator'", ExtensiblePageIndicator.class);
    view = Utils.findRequiredView(source, R.id.btn_next, "method 'onClick'");
    view7f090078 = view;
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
    IntroActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.flexibleIndicator = null;

    view7f090078.setOnClickListener(null);
    view7f090078 = null;
  }
}
