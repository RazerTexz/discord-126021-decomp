package p507d0.p580t;

import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.j0 */
/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12140j0<T> extends AbstractC12129e<T> {

    /* JADX INFO: renamed from: j */
    public final List<T> f25187j;

    public C12140j0(List<T> list) {
        C12238m.checkNotNullParameter(list, "delegate");
        this.f25187j = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        this.f25187j.add(C12161s.access$reversePositionIndex(this, i), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f25187j.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f25187j.get(C12161s.access$reverseElementIndex(this, i));
    }

    @Override // p507d0.p580t.AbstractC12129e
    public int getSize() {
        return this.f25187j.size();
    }

    @Override // p507d0.p580t.AbstractC12129e
    public T removeAt(int i) {
        return this.f25187j.remove(C12161s.access$reverseElementIndex(this, i));
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        return this.f25187j.set(C12161s.access$reverseElementIndex(this, i), t);
    }
}
