package b.i.b.b;

/* JADX INFO: renamed from: b.i.b.b.h0, reason: use source file name */
/* JADX INFO: compiled from: RegularImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public class RegularImmutableList<E> extends ImmutableList2<E> {
    public static final ImmutableList2<Object> l = new RegularImmutableList(new Object[0], 0);
    public final transient Object[] m;
    public final transient int n;

    public RegularImmutableList(Object[] objArr, int i) {
        this.m = objArr;
        this.n = i;
    }

    @Override // b.i.b.b.ImmutableList2, b.i.b.b.ImmutableCollection
    public int d(Object[] objArr, int i) {
        System.arraycopy(this.m, 0, objArr, i, this.n);
        return i + this.n;
    }

    @Override // b.i.b.b.ImmutableCollection
    public Object[] e() {
        return this.m;
    }

    @Override // b.i.b.b.ImmutableCollection
    public int g() {
        return this.n;
    }

    @Override // java.util.List
    public E get(int i) {
        b.i.a.f.e.o.f.x(i, this.n);
        return (E) this.m[i];
    }

    @Override // b.i.b.b.ImmutableCollection
    public int h() {
        return 0;
    }

    @Override // b.i.b.b.ImmutableCollection
    public boolean i() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.n;
    }
}
