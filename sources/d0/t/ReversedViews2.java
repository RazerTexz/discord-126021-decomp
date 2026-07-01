package d0.t;

import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.t.k0, reason: use source file name */
/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ReversedViews2<T> extends AbstractList<T> {
    public final List<T> k;

    /* JADX WARN: Multi-variable type inference failed */
    public ReversedViews2(List<? extends T> list) {
        Intrinsics3.checkNotNullParameter(list, "delegate");
        this.k = list;
    }

    @Override // d0.t.AbstractList, java.util.List
    public T get(int i) {
        return this.k.get(ReversedViews3.access$reverseElementIndex(this, i));
    }

    @Override // d0.t.AbstractCollection
    public int getSize() {
        return this.k.size();
    }
}
