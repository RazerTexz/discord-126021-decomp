package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat$CollectionItemInfoCompat {
    public final Object mInfo;

    public AccessibilityNodeInfoCompat$CollectionItemInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public static AccessibilityNodeInfoCompat$CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z2, boolean z3) {
        return new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(AccessibilityNodeInfo$CollectionItemInfo.obtain(i, i2, i3, i4, z2, z3));
    }

    public int getColumnIndex() {
        return ((AccessibilityNodeInfo$CollectionItemInfo) this.mInfo).getColumnIndex();
    }

    public int getColumnSpan() {
        return ((AccessibilityNodeInfo$CollectionItemInfo) this.mInfo).getColumnSpan();
    }

    public int getRowIndex() {
        return ((AccessibilityNodeInfo$CollectionItemInfo) this.mInfo).getRowIndex();
    }

    public int getRowSpan() {
        return ((AccessibilityNodeInfo$CollectionItemInfo) this.mInfo).getRowSpan();
    }

    @Deprecated
    public boolean isHeading() {
        return ((AccessibilityNodeInfo$CollectionItemInfo) this.mInfo).isHeading();
    }

    public boolean isSelected() {
        return ((AccessibilityNodeInfo$CollectionItemInfo) this.mInfo).isSelected();
    }

    public static AccessibilityNodeInfoCompat$CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z2) {
        return new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(AccessibilityNodeInfo$CollectionItemInfo.obtain(i, i2, i3, i4, z2));
    }
}
