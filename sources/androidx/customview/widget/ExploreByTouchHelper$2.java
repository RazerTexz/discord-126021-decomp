package androidx.customview.widget;

import androidx.collection.SparseArrayCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes.dex */
public class ExploreByTouchHelper$2 implements FocusStrategy$CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
    @Override // androidx.customview.widget.FocusStrategy$CollectionAdapter
    public /* bridge */ /* synthetic */ AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
        return get2(sparseArrayCompat, i);
    }

    @Override // androidx.customview.widget.FocusStrategy$CollectionAdapter
    public /* bridge */ /* synthetic */ int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
        return size2(sparseArrayCompat);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public AccessibilityNodeInfoCompat get2(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
        return sparseArrayCompat.valueAt(i);
    }

    /* JADX INFO: renamed from: size, reason: avoid collision after fix types in other method */
    public int size2(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
        return sparseArrayCompat.size();
    }
}
