package b.i.b.b;

/* JADX INFO: compiled from: RegularImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0<E> extends p<E> {
    public static final p<Object> l = new h0(new Object[0], 0);
    public final transient Object[] m;
    public final transient int n;

    public h0(Object[] objArr, int i) {
        this.m = objArr;
        this.n = i;
    }

    @Override // b.i.b.b.p, b.i.b.b.n
    public int d(Object[] objArr, int i) {
        System.arraycopy(this.m, 0, objArr, i, this.n);
        return i + this.n;
    }

    @Override // b.i.b.b.n
    public Object[] e() {
        return this.m;
    }

    @Override // b.i.b.b.n
    public int g() {
        return this.n;
    }

    @Override // java.util.List
    public E get(int i) {
        b.i.a.f.e.o.f.x(i, this.n);
        return (E) this.m[i];
    }

    @Override // b.i.b.b.n
    public int h() {
        return 0;
    }

    @Override // b.i.b.b.n
    public boolean i() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.n;
    }
}
