package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$BasicAccessibilityProvider extends ViewPager2$AccessibilityProvider {
    public final /* synthetic */ ViewPager2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2$BasicAccessibilityProvider(ViewPager2 viewPager2) {
        super(viewPager2, null);
        this.this$0 = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public boolean handlesLmPerformAccessibilityAction(int i) {
        return (i == 8192 || i == 4096) && !this.this$0.isUserInputEnabled();
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public boolean handlesRvGetAccessibilityClassName() {
        return true;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.this$0.isUserInputEnabled()) {
            return;
        }
        accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
        accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
        accessibilityNodeInfoCompat.setScrollable(false);
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public boolean onLmPerformAccessibilityAction(int i) {
        if (handlesLmPerformAccessibilityAction(i)) {
            return false;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.viewpager2.widget.ViewPager2$AccessibilityProvider
    public CharSequence onRvGetAccessibilityClassName() {
        if (handlesRvGetAccessibilityClassName()) {
            return "androidx.viewpager.widget.ViewPager";
        }
        throw new IllegalStateException();
    }
}
