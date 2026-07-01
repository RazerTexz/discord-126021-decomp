package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat$CollectionInfoCompat {
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_SINGLE = 1;
    public final Object mInfo;

    public AccessibilityNodeInfoCompat$CollectionInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public static AccessibilityNodeInfoCompat$CollectionInfoCompat obtain(int i, int i2, boolean z2, int i3) {
        return new AccessibilityNodeInfoCompat$CollectionInfoCompat(AccessibilityNodeInfo$CollectionInfo.obtain(i, i2, z2, i3));
    }

    public int getColumnCount() {
        return ((AccessibilityNodeInfo$CollectionInfo) this.mInfo).getColumnCount();
    }

    public int getRowCount() {
        return ((AccessibilityNodeInfo$CollectionInfo) this.mInfo).getRowCount();
    }

    public int getSelectionMode() {
        return ((AccessibilityNodeInfo$CollectionInfo) this.mInfo).getSelectionMode();
    }

    public boolean isHierarchical() {
        return ((AccessibilityNodeInfo$CollectionInfo) this.mInfo).isHierarchical();
    }

    public static AccessibilityNodeInfoCompat$CollectionInfoCompat obtain(int i, int i2, boolean z2) {
        return new AccessibilityNodeInfoCompat$CollectionInfoCompat(AccessibilityNodeInfo$CollectionInfo.obtain(i, i2, z2));
    }
}
