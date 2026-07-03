package p507d0.p513e0.p514p.p515d.p577n0;

/* JADX INFO: renamed from: d0.e0.p.d.n0.d */
/* JADX INFO: compiled from: IntTreePMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12047d<V> {

    /* JADX INFO: renamed from: a */
    public static final C12047d<Object> f25032a = new C12047d<>(C12046c.f25026a);

    /* JADX INFO: renamed from: b */
    public final C12046c<V> f25033b;

    public C12047d(C12046c<V> c12046c) {
        this.f25033b = c12046c;
    }

    public static <V> C12047d<V> empty() {
        return (C12047d<V>) f25032a;
    }

    public V get(int i) {
        return this.f25033b.m10051a(i);
    }

    public C12047d<V> plus(int i, V v) {
        C12046c<V> c12046cM10052b = this.f25033b.m10052b(i, v);
        return c12046cM10052b == this.f25033b ? this : new C12047d<>(c12046cM10052b);
    }
}
