package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ViewTypeStorage$IsolatedViewTypeStorage implements ViewTypeStorage {
    public SparseArray<NestedAdapterWrapper> mGlobalTypeToWrapper = new SparseArray<>();
    public int mNextViewType = 0;

    @Override // androidx.recyclerview.widget.ViewTypeStorage
    @NonNull
    public ViewTypeStorage$ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
        return new ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup(this, nestedAdapterWrapper);
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage
    @NonNull
    public NestedAdapterWrapper getWrapperForGlobalType(int i) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mGlobalTypeToWrapper.get(i);
        if (nestedAdapterWrapper != null) {
            return nestedAdapterWrapper;
        }
        throw new IllegalArgumentException(a.q("Cannot find the wrapper for global view type ", i));
    }

    public int obtainViewType(NestedAdapterWrapper nestedAdapterWrapper) {
        int i = this.mNextViewType;
        this.mNextViewType = i + 1;
        this.mGlobalTypeToWrapper.put(i, nestedAdapterWrapper);
        return i;
    }

    public void removeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
        for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
            if (this.mGlobalTypeToWrapper.valueAt(size) == nestedAdapterWrapper) {
                this.mGlobalTypeToWrapper.removeAt(size);
            }
        }
    }
}
