// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationActivity_ViewBinding implements Unbinder {
  private NotificationActivity target;

  private View view7f090140;

  @UiThread
  public NotificationActivity_ViewBinding(NotificationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NotificationActivity_ViewBinding(final NotificationActivity target, View source) {
    this.target = target;

    View view;
    target.lvlMyOrder = Utils.findRequiredViewAsType(source, R.id.lvl_myorder, "field 'lvlMyOrder'", LinearLayout.class);
    target.txtNotFound = Utils.findRequiredViewAsType(source, R.id.txt_notfound, "field 'txtNotFound'", TextView.class);
    target.lvlNotFound = Utils.findRequiredViewAsType(source, R.id.lvl_notfound, "field 'lvlNotFound'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.img_back, "method 'onClick'");
    view7f090140 = view;
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
    NotificationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lvlMyOrder = null;
    target.txtNotFound = null;
    target.lvlNotFound = null;

    view7f090140.setOnClickListener(null);
    view7f090140 = null;
  }
}
