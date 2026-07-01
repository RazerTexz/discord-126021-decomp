package com.google.android.material.button;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButtonToggleGroup$b extends AccessibilityDelegateCompat {
    public final /* synthetic */ MaterialButtonToggleGroup a;

    public MaterialButtonToggleGroup$b(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this.a = materialButtonToggleGroup;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.access$200(this.a, view), 1, false, ((MaterialButton) view).isChecked()));
    }
}
