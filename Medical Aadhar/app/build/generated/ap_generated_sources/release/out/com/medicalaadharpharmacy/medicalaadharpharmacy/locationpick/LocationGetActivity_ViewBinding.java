// Generated code from Butter Knife. Do not modify!
package com.medicalaadharpharmacy.medicalaadharpharmacy.locationpick;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.medicalaadharpharmacy.medicalaadharpharmacy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LocationGetActivity_ViewBinding implements Unbinder {
  private LocationGetActivity target;

  private View view7f090167;

  private View view7f0902d2;

  private View view7f0902e1;

  private View view7f0902bd;

  private View view7f09007b;

  @UiThread
  public LocationGetActivity_ViewBinding(LocationGetActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LocationGetActivity_ViewBinding(final LocationGetActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lvl_actionsearch, "field 'lvlActionsearch' and method 'onClick'");
    target.lvlActionsearch = Utils.castView(view, R.id.lvl_actionsearch, "field 'lvlActionsearch'", LinearLayout.class);
    view7f090167 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.rmap = Utils.findRequiredViewAsType(source, R.id.rmap, "field 'rmap'", RelativeLayout.class);
    target.edHoseno = Utils.findRequiredViewAsType(source, R.id.ed_hoseno, "field 'edHoseno'", EditText.class);
    target.edLandmark = Utils.findRequiredViewAsType(source, R.id.ed_landmark, "field 'edLandmark'", EditText.class);
    view = Utils.findRequiredView(source, R.id.txt_home, "field 'txtHome' and method 'onClick'");
    target.txtHome = Utils.castView(view, R.id.txt_home, "field 'txtHome'", TextView.class);
    view7f0902d2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_office, "field 'txtOffice' and method 'onClick'");
    target.txtOffice = Utils.castView(view, R.id.txt_office, "field 'txtOffice'", TextView.class);
    view7f0902e1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_ather, "field 'txtAther' and method 'onClick'");
    target.txtAther = Utils.castView(view, R.id.txt_ather, "field 'txtAther'", TextView.class);
    view7f0902bd = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_save, "field 'btnSave' and method 'onClick'");
    target.btnSave = Utils.castView(view, R.id.btn_save, "field 'btnSave'", TextView.class);
    view7f09007b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.txtCity = Utils.findRequiredViewAsType(source, R.id.txt_city, "field 'txtCity'", TextView.class);
    target.txtAddress = Utils.findRequiredViewAsType(source, R.id.txt_address, "field 'txtAddress'", TextView.class);
    target.edAddress = Utils.findRequiredViewAsType(source, R.id.ed_address, "field 'edAddress'", EditText.class);
    target.edCity = Utils.findRequiredViewAsType(source, R.id.ed_city, "field 'edCity'", EditText.class);
    target.edState = Utils.findRequiredViewAsType(source, R.id.ed_state, "field 'edState'", EditText.class);
    target.edCountry = Utils.findRequiredViewAsType(source, R.id.ed_country, "field 'edCountry'", EditText.class);
    target.edPincode = Utils.findRequiredViewAsType(source, R.id.ed_pincode, "field 'edPincode'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LocationGetActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lvlActionsearch = null;
    target.rmap = null;
    target.edHoseno = null;
    target.edLandmark = null;
    target.txtHome = null;
    target.txtOffice = null;
    target.txtAther = null;
    target.btnSave = null;
    target.txtCity = null;
    target.txtAddress = null;
    target.edAddress = null;
    target.edCity = null;
    target.edState = null;
    target.edCountry = null;
    target.edPincode = null;

    view7f090167.setOnClickListener(null);
    view7f090167 = null;
    view7f0902d2.setOnClickListener(null);
    view7f0902d2 = null;
    view7f0902e1.setOnClickListener(null);
    view7f0902e1 = null;
    view7f0902bd.setOnClickListener(null);
    view7f0902bd = null;
    view7f09007b.setOnClickListener(null);
    view7f09007b = null;
  }
}
