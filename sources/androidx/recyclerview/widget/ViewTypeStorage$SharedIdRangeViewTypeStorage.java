package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import b.d.b.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewTypeStorage$SharedIdRangeViewTypeStorage implements ViewTypeStorage {
    public SparseArray<List<NestedAdapterWrapper>> mGlobalTypeToWrapper = new SparseArray<>();

    @Override // androidx.recyclerview.widget.ViewTypeStorage
    @NonNull
    public ViewTypeStorage$ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
        return new ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup(this, nestedAdapterWrapper);
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage
    @NonNull
    public NestedAdapterWrapper getWrapperForGlobalType(int i) {
        List<NestedAdapterWrapper> list = this.mGlobalTypeToWrapper.get(i);
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(a.q("Cannot find the wrapper for global view type ", i));
        }
        return list.get(0);
    }

    public void removeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
        for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
            List<NestedAdapterWrapper> listValueAt = this.mGlobalTypeToWrapper.valueAt(size);
            if (listValueAt.remove(nestedAdapterWrapper) && listValueAt.isEmpty()) {
                this.mGlobalTypeToWrapper.removeAt(size);
            }
        }
    }
}
