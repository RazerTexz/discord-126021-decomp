package b.i.b.b;

/* JADX INFO: compiled from: RegularImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i0$c extends p<Object> {
    public final transient Object[] l;
    public final transient int m;
    public final transient int n;

    public i0$c(Object[] objArr, int i, int i2) {
        this.l = objArr;
        this.m = i;
        this.n = i2;
    }

    @Override // java.util.List
    public Object get(int i) {
        b.i.a.f.e.o.f.x(i, this.n);
        return this.l[(i * 2) + this.m];
    }

    @Override // b.i.b.b.n
    public boolean i() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.n;
    }
}
