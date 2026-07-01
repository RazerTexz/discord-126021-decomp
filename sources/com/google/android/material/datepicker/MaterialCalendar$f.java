package com.google.android.material.datepicker;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$string;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendar$f extends AccessibilityDelegateCompat {
    public final /* synthetic */ MaterialCalendar a;

    public MaterialCalendar$f(MaterialCalendar materialCalendar) {
        this.a = materialCalendar;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setHintText(MaterialCalendar.access$500(this.a).getVisibility() == 0 ? this.a.getString(R$string.mtrl_picker_toggle_to_year_selection) : this.a.getString(R$string.mtrl_picker_toggle_to_day_selection));
    }
}
