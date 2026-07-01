package androidx.customview.widget;

import android.graphics.Rect;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes.dex */
public class ExploreByTouchHelper$1 implements FocusStrategy$BoundsAdapter<AccessibilityNodeInfoCompat> {
    @Override // androidx.customview.widget.FocusStrategy$BoundsAdapter
    public /* bridge */ /* synthetic */ void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
        obtainBounds2(accessibilityNodeInfoCompat, rect);
    }

    /* JADX INFO: renamed from: obtainBounds, reason: avoid collision after fix types in other method */
    public void obtainBounds2(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
        accessibilityNodeInfoCompat.getBoundsInParent(rect);
    }
}
