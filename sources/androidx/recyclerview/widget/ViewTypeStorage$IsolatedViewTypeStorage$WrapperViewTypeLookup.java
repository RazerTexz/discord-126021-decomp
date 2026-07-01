package androidx.recyclerview.widget;

import android.util.SparseIntArray;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup implements ViewTypeStorage$ViewTypeLookup {
    public final NestedAdapterWrapper mWrapper;
    public final /* synthetic */ ViewTypeStorage$IsolatedViewTypeStorage this$0;
    private SparseIntArray mLocalToGlobalMapping = new SparseIntArray(1);
    private SparseIntArray mGlobalToLocalMapping = new SparseIntArray(1);

    public ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup(ViewTypeStorage$IsolatedViewTypeStorage viewTypeStorage$IsolatedViewTypeStorage, NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = viewTypeStorage$IsolatedViewTypeStorage;
        this.mWrapper = nestedAdapterWrapper;
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public void dispose() {
        this.this$0.removeWrapper(this.mWrapper);
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public int globalToLocal(int i) {
        int iIndexOfKey = this.mGlobalToLocalMapping.indexOfKey(i);
        if (iIndexOfKey >= 0) {
            return this.mGlobalToLocalMapping.valueAt(iIndexOfKey);
        }
        StringBuilder sbV = a.V("requested global type ", i, " does not belong to the adapter:");
        sbV.append(this.mWrapper.adapter);
        throw new IllegalStateException(sbV.toString());
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public int localToGlobal(int i) {
        int iIndexOfKey = this.mLocalToGlobalMapping.indexOfKey(i);
        if (iIndexOfKey > -1) {
            return this.mLocalToGlobalMapping.valueAt(iIndexOfKey);
        }
        int iObtainViewType = this.this$0.obtainViewType(this.mWrapper);
        this.mLocalToGlobalMapping.put(i, iObtainViewType);
        this.mGlobalToLocalMapping.put(iObtainViewType, i);
        return iObtainViewType;
    }
}
