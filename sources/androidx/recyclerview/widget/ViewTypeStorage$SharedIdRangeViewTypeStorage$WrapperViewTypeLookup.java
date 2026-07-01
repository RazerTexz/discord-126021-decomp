package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup implements ViewTypeStorage$ViewTypeLookup {
    public final NestedAdapterWrapper mWrapper;
    public final /* synthetic */ ViewTypeStorage$SharedIdRangeViewTypeStorage this$0;

    public ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup(ViewTypeStorage$SharedIdRangeViewTypeStorage viewTypeStorage$SharedIdRangeViewTypeStorage, NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = viewTypeStorage$SharedIdRangeViewTypeStorage;
        this.mWrapper = nestedAdapterWrapper;
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public void dispose() {
        this.this$0.removeWrapper(this.mWrapper);
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public int globalToLocal(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
    public int localToGlobal(int i) {
        List<NestedAdapterWrapper> arrayList = this.this$0.mGlobalTypeToWrapper.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.this$0.mGlobalTypeToWrapper.put(i, arrayList);
        }
        if (!arrayList.contains(this.mWrapper)) {
            arrayList.add(this.mWrapper);
        }
        return i;
    }
}
