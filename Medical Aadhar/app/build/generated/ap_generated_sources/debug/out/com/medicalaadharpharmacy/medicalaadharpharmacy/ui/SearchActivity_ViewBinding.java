// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding implements Unbinder {
  private SearchActivity target;

  private View view7f090141;

  private View view7f090150;

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchActivity_ViewBinding(final SearchActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.img_back, "field 'imgBack' and method 'onClick'");
    target.imgBack = Utils.castView(view, R.id.img_back, "field 'imgBack'", ImageView.class);
    view7f090141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.imgNotfound = Utils.findRequiredViewAsType(source, R.id.img_notfound, "field 'imgNotfound'", ImageView.class);
    target.edSearch = Utils.findRequiredViewAsType(source, R.id.ed_search, "field 'edSearch'", EditText.class);
    view = Utils.findRequiredView(source, R.id.img_search, "field 'imgSearch' and method 'onClick'");
    target.imgSearch = Utils.castView(view, R.id.img_search, "field 'imgSearch'", ImageView.class);
    view7f090150 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.lvlActionsearch = Utils.findRequiredViewAsType(source, R.id.lvl_actionsearch, "field 'lvlActionsearch'", LinearLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appBarLayout, "field 'appBarLayout'", AppBarLayout.class);
    target.recyclerProduct = Utils.findRequiredViewAsType(source, R.id.recycler_product, "field 'recyclerProduct'", RecyclerView.class);
    target.lvlNotfound = Utils.findRequiredViewAsType(source, R.id.lvl_notfound, "field 'lvlNotfound'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBack = null;
    target.imgNotfound = null;
    target.edSearch = null;
    target.imgSearch = null;
    target.lvlActionsearch = null;
    target.toolbar = null;
    target.appBarLayout = null;
    target.recyclerProduct = null;
    target.lvlNotfound = null;

    view7f090141.setOnClickListener(null);
    view7f090141 = null;
    view7f090150.setOnClickListener(null);
    view7f090150 = null;
  }
}
