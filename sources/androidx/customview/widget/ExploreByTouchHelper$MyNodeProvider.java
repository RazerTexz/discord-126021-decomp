package androidx.customview.widget;

import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;

/* JADX INFO: loaded from: classes.dex */
public class ExploreByTouchHelper$MyNodeProvider extends AccessibilityNodeProviderCompat {
    public final /* synthetic */ ExploreByTouchHelper this$0;

    public ExploreByTouchHelper$MyNodeProvider(ExploreByTouchHelper exploreByTouchHelper) {
        this.this$0 = exploreByTouchHelper;
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(i));
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public AccessibilityNodeInfoCompat findFocus(int i) {
        int i2 = i == 2 ? this.this$0.mAccessibilityFocusedVirtualViewId : this.this$0.mKeyboardFocusedVirtualViewId;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return createAccessibilityNodeInfo(i2);
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.this$0.performAction(i, i2, bundle);
    }
}
