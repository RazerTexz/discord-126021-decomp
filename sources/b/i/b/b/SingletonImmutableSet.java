package b.i.b.b;

import b.d.b.a.outline;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.b.b.q0, reason: use source file name */
/* JADX INFO: compiled from: SingletonImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SingletonImmutableSet<E> extends ImmutableSet2<E> {
    public final transient E m;

    @LazyInit
    public transient int n;

    public SingletonImmutableSet(E e) {
        Objects.requireNonNull(e);
        this.m = e;
    }

    @Override // b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.m.equals(obj);
    }

    @Override // b.i.b.b.ImmutableCollection
    public int d(Object[] objArr, int i) {
        objArr[i] = this.m;
        return i + 1;
    }

    @Override // b.i.b.b.ImmutableSet2, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.n;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.m.hashCode();
        this.n = iHashCode;
        return iHashCode;
    }

    @Override // b.i.b.b.ImmutableCollection
    public boolean i() {
        return false;
    }

    @Override // b.i.b.b.ImmutableSet2, b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public UnmodifiableIterator<E> iterator() {
        return new Iterators(this.m);
    }

    @Override // b.i.b.b.ImmutableSet2
    public ImmutableList2<E> o() {
        return ImmutableList2.u(this.m);
    }

    @Override // b.i.b.b.ImmutableSet2
    public boolean p() {
        return this.n != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sbQ = outline.Q('[');
        sbQ.append(this.m.toString());
        sbQ.append(']');
        return sbQ.toString();
    }

    public SingletonImmutableSet(E e, int i) {
        this.m = e;
        this.n = i;
    }
}
