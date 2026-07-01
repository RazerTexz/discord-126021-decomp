package b.i.a.f.h.n;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l<E> extends k<E> {
    public static final k<Object> l = new l(new Object[0]);
    public final transient Object[] m;

    public l(Object[] objArr) {
        this.m = objArr;
    }

    @Override // b.i.a.f.h.n.k, b.i.a.f.h.n.h
    public final int c(Object[] objArr, int i) {
        System.arraycopy(this.m, 0, objArr, 0, 0);
        return 0;
    }

    @Override // b.i.a.f.h.n.h
    public final int d() {
        return 0;
    }

    @Override // b.i.a.f.h.n.h
    public final int e() {
        return 0;
    }

    @Override // b.i.a.f.h.n.h
    public final Object[] g() {
        return this.m;
    }

    @Override // java.util.List
    public final E get(int i) {
        b.i.a.f.e.o.f.F1(i, 0, "index");
        return (E) this.m[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 0;
    }
}
