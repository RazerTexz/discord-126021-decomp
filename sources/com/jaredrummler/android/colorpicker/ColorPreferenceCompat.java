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
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p440k.p441a.p442a.InterfaceC5079f;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPreferenceCompat extends Preference implements InterfaceC5079f {

    /* JADX INFO: renamed from: j */
    public int f21808j;

    /* JADX INFO: renamed from: k */
    public boolean f21809k;

    /* JADX INFO: renamed from: l */
    public int f21810l;

    /* JADX INFO: renamed from: m */
    public int f21811m;

    /* JADX INFO: renamed from: n */
    public boolean f21812n;

    /* JADX INFO: renamed from: o */
    public boolean f21813o;

    /* JADX INFO: renamed from: p */
    public boolean f21814p;

    /* JADX INFO: renamed from: q */
    public boolean f21815q;

    /* JADX INFO: renamed from: r */
    public int f21816r;

    /* JADX INFO: renamed from: s */
    public int[] f21817s;

    /* JADX INFO: renamed from: t */
    public int f21818t;

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21808j = ViewCompat.MEASURED_STATE_MASK;
        setPersistent(true);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11167R.f.ColorPreference);
        this.f21809k = typedArrayObtainStyledAttributes.getBoolean(C11167R.f.ColorPreference_cpv_showDialog, true);
        this.f21810l = typedArrayObtainStyledAttributes.getInt(C11167R.f.ColorPreference_cpv_dialogType, 1);
        this.f21811m = typedArrayObtainStyledAttributes.getInt(C11167R.f.ColorPreference_cpv_colorShape, 1);
        this.f21812n = typedArrayObtainStyledAttributes.getBoolean(C11167R.f.ColorPreference_cpv_allowPresets, true);
        this.f21813o = typedArrayObtainStyledAttributes.getBoolean(C11167R.f.ColorPreference_cpv_allowCustom, true);
        this.f21814p = typedArrayObtainStyledAttributes.getBoolean(C11167R.f.ColorPreference_cpv_showAlphaSlider, false);
        this.f21815q = typedArrayObtainStyledAttributes.getBoolean(C11167R.f.ColorPreference_cpv_showColorShades, true);
        this.f21816r = typedArrayObtainStyledAttributes.getInt(C11167R.f.ColorPreference_cpv_previewSize, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(C11167R.f.ColorPreference_cpv_colorPresets, 0);
        this.f21818t = typedArrayObtainStyledAttributes.getResourceId(C11167R.f.ColorPreference_cpv_dialogTitle, C11167R.e.cpv_default_title);
        if (resourceId != 0) {
            this.f21817s = getContext().getResources().getIntArray(resourceId);
        } else {
            this.f21817s = ColorPickerDialog.f21707j;
        }
        if (this.f21811m == 1) {
            setWidgetLayoutResource(this.f21816r == 1 ? C11167R.d.cpv_preference_circle_large : C11167R.d.cpv_preference_circle);
        } else {
            setWidgetLayoutResource(this.f21816r == 1 ? C11167R.d.cpv_preference_square_large : C11167R.d.cpv_preference_square);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: f */
    public FragmentActivity m9278f() {
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
        if (this.f21809k) {
            FragmentManager supportFragmentManager = m9278f().getSupportFragmentManager();
            StringBuilder sbM833U = C1643a.m833U("color_");
            sbM833U.append(getKey());
            ColorPickerDialog colorPickerDialog = (ColorPickerDialog) supportFragmentManager.findFragmentByTag(sbM833U.toString());
            if (colorPickerDialog != null) {
                colorPickerDialog.f21719k = this;
            }
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        ColorPanelView colorPanelView = (ColorPanelView) preferenceViewHolder.itemView.findViewById(C11167R.c.cpv_preference_preview_color_panel);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.f21808j);
        }
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        super.onClick();
        if (this.f21809k) {
            int[] iArr = ColorPickerDialog.f21707j;
            ColorPickerDialog.C11163k c11163k = new ColorPickerDialog.C11163k();
            c11163k.f21752f = this.f21810l;
            c11163k.f21747a = this.f21818t;
            c11163k.f21760n = this.f21811m;
            c11163k.f21753g = this.f21817s;
            c11163k.f21756j = this.f21812n;
            c11163k.f21757k = this.f21813o;
            c11163k.f21755i = this.f21814p;
            c11163k.f21759m = this.f21815q;
            c11163k.f21754h = this.f21808j;
            ColorPickerDialog colorPickerDialogM9275a = c11163k.m9275a();
            colorPickerDialogM9275a.f21719k = this;
            FragmentTransaction fragmentTransactionBeginTransaction = m9278f().getSupportFragmentManager().beginTransaction();
            StringBuilder sbM833U = C1643a.m833U("color_");
            sbM833U.append(getKey());
            fragmentTransactionBeginTransaction.add(colorPickerDialogM9275a, sbM833U.toString()).commitAllowingStateLoss();
        }
    }

    @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
    public void onColorReset(int i) {
    }

    @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
    public void onColorSelected(int i, @ColorInt int i2) {
        this.f21808j = i2;
        persistInt(i2);
        notifyChanged();
        callChangeListener(Integer.valueOf(i2));
    }

    @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
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
            this.f21808j = getPersistedInt(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        this.f21808j = iIntValue;
        persistInt(iIntValue);
    }
}
