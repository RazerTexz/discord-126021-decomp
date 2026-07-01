package androidx.viewpager2.widget;

import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewPager2$AccessibilityProvider {
    public final /* synthetic */ ViewPager2 this$0;

    private ViewPager2$AccessibilityProvider(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public boolean handlesGetAccessibilityClassName() {
        return false;
    }

    public boolean handlesLmPerformAccessibilityAction(int i) {
        return false;
    }

    public boolean handlesPerformAccessibilityAction(int i, Bundle bundle) {
        return false;
    }

    public boolean handlesRvGetAccessibilityClassName() {
        return false;
    }

    public void onAttachAdapter(@Nullable RecyclerView$Adapter<?> recyclerView$Adapter) {
    }

    public void onDetachAdapter(@Nullable RecyclerView$Adapter<?> recyclerView$Adapter) {
    }

    public String onGetAccessibilityClassName() {
        throw new IllegalStateException("Not implemented.");
    }

    public void onInitialize(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public boolean onLmPerformAccessibilityAction(int i) {
        throw new IllegalStateException("Not implemented.");
    }

    public boolean onPerformAccessibilityAction(int i, Bundle bundle) {
        throw new IllegalStateException("Not implemented.");
    }

    public void onRestorePendingState() {
    }

    public CharSequence onRvGetAccessibilityClassName() {
        throw new IllegalStateException("Not implemented.");
    }

    public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void onSetLayoutDirection() {
    }

    public void onSetNewCurrentItem() {
    }

    public void onSetOrientation() {
    }

    public void onSetUserInputEnabled() {
    }

    public /* synthetic */ ViewPager2$AccessibilityProvider(ViewPager2 viewPager2, ViewPager2$1 viewPager2$1) {
        this(viewPager2);
    }
}
