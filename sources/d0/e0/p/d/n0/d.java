package d0.e0.p.d.n0;

/* JADX INFO: compiled from: IntTreePMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d<V> {
    public static final d<Object> a = new d<>(c.a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<V> f3567b;

    public d(c<V> cVar) {
        this.f3567b = cVar;
    }

    public static <V> d<V> empty() {
        return (d<V>) a;
    }

    public V get(int i) {
        return this.f3567b.a(i);
    }

    public d<V> plus(int i, V v) {
        c<V> cVarB = this.f3567b.b(i, v);
        return cVarB == this.f3567b ? this : new d<>(cVarB);
    }
}
