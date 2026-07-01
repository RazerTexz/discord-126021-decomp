package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView$Adapter;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceRecyclerViewAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    public final /* synthetic */ PreferenceRecyclerViewAccessibilityDelegate this$0;

    public PreferenceRecyclerViewAccessibilityDelegate$1(PreferenceRecyclerViewAccessibilityDelegate preferenceRecyclerViewAccessibilityDelegate) {
        this.this$0 = preferenceRecyclerViewAccessibilityDelegate;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Preference item;
        this.this$0.mDefaultItemDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        int childAdapterPosition = this.this$0.mRecyclerView.getChildAdapterPosition(view);
        RecyclerView$Adapter adapter = this.this$0.mRecyclerView.getAdapter();
        if ((adapter instanceof PreferenceGroupAdapter) && (item = ((PreferenceGroupAdapter) adapter).getItem(childAdapterPosition)) != null) {
            item.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.this$0.mDefaultItemDelegate.performAccessibilityAction(view, i, bundle);
    }
}
