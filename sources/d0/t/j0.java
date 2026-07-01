package d0.t;

import java.util.List;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j0<T> extends e<T> {
    public final List<T> j;

    public j0(List<T> list) {
        d0.z.d.m.checkNotNullParameter(list, "delegate");
        this.j = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        this.j.add(s.access$reversePositionIndex(this, i), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.j.get(s.access$reverseElementIndex(this, i));
    }

    @Override // d0.t.e
    public int getSize() {
        return this.j.size();
    }

    @Override // d0.t.e
    public T removeAt(int i) {
        return this.j.remove(s.access$reverseElementIndex(this, i));
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        return this.j.set(s.access$reverseElementIndex(this, i), t);
    }
}
