package b.i.b.b;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.j0, reason: use source file name */
/* JADX INFO: compiled from: RegularImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RegularImmutableSet<E> extends ImmutableSet2<E> {
    public static final RegularImmutableSet<Object> m = new RegularImmutableSet<>(new Object[0], 0, null, 0, 0);
    public final transient Object[] n;
    public final transient Object[] o;
    public final transient int p;
    public final transient int q;
    public final transient int r;

    public RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.n = objArr;
        this.o = objArr2;
        this.p = i2;
        this.q = i;
        this.r = i3;
    }

    @Override // b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.o;
        if (obj == null || objArr == null) {
            return false;
        }
        int iC1 = b.i.a.f.e.o.f.c1(obj.hashCode());
        while (true) {
            int i = iC1 & this.p;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iC1 = i + 1;
        }
    }

    @Override // b.i.b.b.ImmutableCollection
    public int d(Object[] objArr, int i) {
        System.arraycopy(this.n, 0, objArr, i, this.r);
        return i + this.r;
    }

    @Override // b.i.b.b.ImmutableCollection
    public Object[] e() {
        return this.n;
    }

    @Override // b.i.b.b.ImmutableCollection
    public int g() {
        return this.r;
    }

    @Override // b.i.b.b.ImmutableCollection
    public int h() {
        return 0;
    }

    @Override // b.i.b.b.ImmutableSet2, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.q;
    }

    @Override // b.i.b.b.ImmutableCollection
    public boolean i() {
        return false;
    }

    @Override // b.i.b.b.ImmutableSet2, b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public UnmodifiableIterator<E> iterator() {
        return c().listIterator();
    }

    @Override // b.i.b.b.ImmutableSet2
    public ImmutableList2<E> o() {
        return ImmutableList2.l(this.n, this.r);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.r;
    }
}
