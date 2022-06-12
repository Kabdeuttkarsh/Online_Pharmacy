// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TramandconditionActivity_ViewBinding implements Unbinder {
  private TramandconditionActivity target;

  private View view7f090141;

  @UiThread
  public TramandconditionActivity_ViewBinding(TramandconditionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TramandconditionActivity_ViewBinding(final TramandconditionActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.txtActiontitle = Utils.findRequiredViewAsType(source, R.id.txt_actiontitle, "field 'txtActiontitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
    target.txtDscirtion = Utils.findRequiredViewAsType(source, R.id.txt_dscirtion, "field 'txtDscirtion'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TramandconditionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.txtActiontitle = null;
    target.toolbar = null;
    target.appBarLayout = null;
    target.txtDscirtion = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
  }
}
