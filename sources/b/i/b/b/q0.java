package b.i.b.b;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: SingletonImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q0<E> extends r<E> {
    public final transient E m;

    @LazyInit
    public transient int n;

    public q0(E e) {
        Objects.requireNonNull(e);
        this.m = e;
    }

    @Override // b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.m.equals(obj);
    }

    @Override // b.i.b.b.n
    public int d(Object[] objArr, int i) {
        objArr[i] = this.m;
        return i + 1;
    }

    @Override // b.i.b.b.r, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.n;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.m.hashCode();
        this.n = iHashCode;
        return iHashCode;
    }

    @Override // b.i.b.b.n
    public boolean i() {
        return false;
    }

    @Override // b.i.b.b.r, b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return j();
    }

    @Override // b.i.b.b.n
    public s0<E> j() {
        return new s(this.m);
    }

    @Override // b.i.b.b.r
    public p<E> o() {
        return p.u(this.m);
    }

    @Override // b.i.b.b.r
    public boolean p() {
        return this.n != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sbQ = b.d.b.a.a.Q('[');
        sbQ.append(this.m.toString());
        sbQ.append(']');
        return sbQ.toString();
    }

    public q0(E e, int i) {
        this.m = e;
        this.n = i;
    }
}
