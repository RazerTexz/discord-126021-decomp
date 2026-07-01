package d0.t;

import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.t.j0, reason: use source file name */
/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReversedViews<T> extends AbstractMutableList<T> {
    public final List<T> j;

    public ReversedViews(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "delegate");
        this.j = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        this.j.add(ReversedViews3.access$reversePositionIndex(this, i), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.j.get(ReversedViews3.access$reverseElementIndex(this, i));
    }

    @Override // d0.t.AbstractMutableList
    public int getSize() {
        return this.j.size();
    }

    @Override // d0.t.AbstractMutableList
    public T removeAt(int i) {
        return this.j.remove(ReversedViews3.access$reverseElementIndex(this, i));
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        return this.j.set(ReversedViews3.access$reverseElementIndex(this, i), t);
    }
}
