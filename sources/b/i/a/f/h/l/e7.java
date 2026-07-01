package b.i.a.f.h.l;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e7 extends AbstractList<String> implements j5, RandomAccess {
    public final j5 j;

    public e7(j5 j5Var) {
        this.j = j5Var;
    }

    @Override // b.i.a.f.h.l.j5
    public final Object A(int i) {
        return this.j.A(i);
    }

    @Override // b.i.a.f.h.l.j5
    public final List<?> b() {
        return this.j.b();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.j.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new g7(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new h7(this, i);
    }

    @Override // b.i.a.f.h.l.j5
    public final j5 s() {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.j.size();
    }

    @Override // b.i.a.f.h.l.j5
    public final void t(t3 t3Var) {
        throw new UnsupportedOperationException();
    }
}
