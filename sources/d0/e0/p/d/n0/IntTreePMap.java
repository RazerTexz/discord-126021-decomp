package d0.e0.p.d.n0;

/* JADX INFO: renamed from: d0.e0.p.d.n0.d, reason: use source file name */
/* JADX INFO: compiled from: IntTreePMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class IntTreePMap<V> {
    public static final IntTreePMap<Object> a = new IntTreePMap<>(IntTree.a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntTree<V> f3567b;

    public IntTreePMap(IntTree<V> intTree) {
        this.f3567b = intTree;
    }

    public static <V> IntTreePMap<V> empty() {
        return (IntTreePMap<V>) a;
    }

    public V get(int i) {
        return this.f3567b.a(i);
    }

    public IntTreePMap<V> plus(int i, V v) {
        IntTree<V> intTreeB = this.f3567b.b(i, v);
        return intTreeB == this.f3567b ? this : new IntTreePMap<>(intTreeB);
    }
}
