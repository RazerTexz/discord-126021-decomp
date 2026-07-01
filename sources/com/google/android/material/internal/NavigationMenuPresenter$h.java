package com.google.android.material.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationMenuPresenter$h extends RecyclerViewAccessibilityDelegate {
    public final /* synthetic */ NavigationMenuPresenter a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationMenuPresenter$h(@NonNull NavigationMenuPresenter navigationMenuPresenter, RecyclerView recyclerView) {
        super(recyclerView);
        this.a = navigationMenuPresenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        NavigationMenuPresenter$c navigationMenuPresenter$c = this.a.adapter;
        int i = navigationMenuPresenter$c.d.headerLayout.getChildCount() == 0 ? 0 : 1;
        for (int i2 = 0; i2 < navigationMenuPresenter$c.d.adapter.getPageSize(); i2++) {
            if (navigationMenuPresenter$c.d.adapter.getItemViewType(i2) == 0) {
                i++;
            }
        }
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(i, 0, false));
    }
}
