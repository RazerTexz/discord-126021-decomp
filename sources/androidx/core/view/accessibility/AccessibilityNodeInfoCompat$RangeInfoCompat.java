package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo$RangeInfo;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat$RangeInfoCompat {
    public static final int RANGE_TYPE_FLOAT = 1;
    public static final int RANGE_TYPE_INT = 0;
    public static final int RANGE_TYPE_PERCENT = 2;
    public final Object mInfo;

    public AccessibilityNodeInfoCompat$RangeInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public static AccessibilityNodeInfoCompat$RangeInfoCompat obtain(int i, float f, float f2, float f3) {
        return new AccessibilityNodeInfoCompat$RangeInfoCompat(AccessibilityNodeInfo$RangeInfo.obtain(i, f, f2, f3));
    }

    public float getCurrent() {
        return ((AccessibilityNodeInfo$RangeInfo) this.mInfo).getCurrent();
    }

    public float getMax() {
        return ((AccessibilityNodeInfo$RangeInfo) this.mInfo).getMax();
    }

    public float getMin() {
        return ((AccessibilityNodeInfo$RangeInfo) this.mInfo).getMin();
    }

    public int getType() {
        return ((AccessibilityNodeInfo$RangeInfo) this.mInfo).getType();
    }
}
