package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import b.d.b.a.outline;
import b.k.a.a.ColorPickerDialogListener;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPreferenceCompat extends Preference implements ColorPickerDialogListener {
    public int j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f3157s;
    public int t;

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = ViewCompat.MEASURED_STATE_MASK;
        setPersistent(true);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.f.ColorPreference);
        this.k = typedArrayObtainStyledAttributes.getBoolean(R.f.ColorPreference_cpv_showDialog, true);
        this.l = typedArrayObtainStyledAttributes.getInt(R.f.ColorPreference_cpv_dialogType, 1);
        this.m = typedArrayObtainStyledAttributes.getInt(R.f.ColorPreference_cpv_colorShape, 1);
        this.n = typedArrayObtainStyledAttributes.getBoolean(R.f.ColorPreference_cpv_allowPresets, true);
        this.o = typedArrayObtainStyledAttributes.getBoolean(R.f.ColorPreference_cpv_allowCustom, true);
        this.p = typedArrayObtainStyledAttributes.getBoolean(R.f.ColorPreference_cpv_showAlphaSlider, false);
        this.q = typedArrayObtainStyledAttributes.getBoolean(R.f.ColorPreference_cpv_showColorShades, true);
        this.r = typedArrayObtainStyledAttributes.getInt(R.f.ColorPreference_cpv_previewSize, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.f.ColorPreference_cpv_colorPresets, 0);
        this.t = typedArrayObtainStyledAttributes.getResourceId(R.f.ColorPreference_cpv_dialogTitle, R.e.cpv_default_title);
        if (resourceId != 0) {
            this.f3157s = getContext().getResources().getIntArray(resourceId);
        } else {
            this.f3157s = ColorPickerDialog.j;
        }
        if (this.m == 1) {
            setWidgetLayoutResource(this.r == 1 ? R.d.cpv_preference_circle_large : R.d.cpv_preference_circle);
        } else {
            setWidgetLayoutResource(this.r == 1 ? R.d.cpv_preference_square_large : R.d.cpv_preference_square);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public FragmentActivity f() {
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            return (FragmentActivity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof FragmentActivity) {
                return (FragmentActivity) baseContext;
            }
        }
        throw new IllegalStateException("Error getting activity from context");
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        if (this.k) {
            FragmentManager supportFragmentManager = f().getSupportFragmentManager();
            StringBuilder sbU = outline.U("color_");
            sbU.append(getKey());
            ColorPickerDialog colorPickerDialog = (ColorPickerDialog) supportFragmentManager.findFragmentByTag(sbU.toString());
            if (colorPickerDialog != null) {
                colorPickerDialog.k = this;
            }
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        ColorPanelView colorPanelView = (ColorPanelView) preferenceViewHolder.itemView.findViewById(R.c.cpv_preference_preview_color_panel);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.j);
        }
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        super.onClick();
        if (this.k) {
            int[] iArr = ColorPickerDialog.j;
            ColorPickerDialog.k kVar = new ColorPickerDialog.k();
            kVar.f = this.l;
            kVar.a = this.t;
            kVar.n = this.m;
            kVar.g = this.f3157s;
            kVar.j = this.n;
            kVar.k = this.o;
            kVar.i = this.p;
            kVar.m = this.q;
            kVar.h = this.j;
            ColorPickerDialog colorPickerDialogA = kVar.a();
            colorPickerDialogA.k = this;
            FragmentTransaction fragmentTransactionBeginTransaction = f().getSupportFragmentManager().beginTransaction();
            StringBuilder sbU = outline.U("color_");
            sbU.append(getKey());
            fragmentTransactionBeginTransaction.add(colorPickerDialogA, sbU.toString()).commitAllowingStateLoss();
        }
    }

    @Override // b.k.a.a.ColorPickerDialogListener
    public void onColorReset(int i) {
    }

    @Override // b.k.a.a.ColorPickerDialogListener
    public void onColorSelected(int i, @ColorInt int i2) {
        this.j = i2;
        persistInt(i2);
        notifyChanged();
        callChangeListener(Integer.valueOf(i2));
    }

    @Override // b.k.a.a.ColorPickerDialogListener
    public void onDialogDismissed(int i) {
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInteger(i, ViewCompat.MEASURED_STATE_MASK));
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        super.onSetInitialValue(obj);
        if (!(obj instanceof Integer)) {
            this.j = getPersistedInt(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        this.j = iIntValue;
        persistInt(iIntValue);
    }
}
