package d0.e0.p.d.n0;

/* JADX INFO: renamed from: d0.e0.p.d.n0.c, reason: use source file name */
/* JADX INFO: compiled from: IntTree.java */
/* JADX INFO: loaded from: classes3.dex */
public final class IntTree<V> {
    public static final IntTree<Object> a = new IntTree<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3566b;
    public final V c;
    public final IntTree<V> d;
    public final IntTree<V> e;
    public final int f;

    public IntTree() {
        this.f = 0;
        this.f3566b = 0L;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public V a(long j) {
        if (this.f == 0) {
            return null;
        }
        long j2 = this.f3566b;
        if (j < j2) {
            return this.d.a(j - j2);
        }
        return j > j2 ? this.e.a(j - j2) : this.c;
    }

    public IntTree<V> b(long j, V v) {
        if (this.f == 0) {
            return new IntTree<>(j, v, this, this);
        }
        long j2 = this.f3566b;
        if (j < j2) {
            return c(this.d.b(j - j2, v), this.e);
        }
        if (j > j2) {
            return c(this.d, this.e.b(j - j2, v));
        }
        return v == this.c ? this : new IntTree<>(j, v, this.d, this.e);
    }

    public final IntTree<V> c(IntTree<V> intTree, IntTree<V> intTree2) {
        if (intTree == this.d && intTree2 == this.e) {
            return this;
        }
        long j = this.f3566b;
        V v = this.c;
        int i = intTree.f;
        int i2 = intTree2.f;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                IntTree<V> intTree3 = intTree.d;
                IntTree<V> intTree4 = intTree.e;
                if (intTree4.f < intTree3.f * 2) {
                    long j2 = intTree.f3566b;
                    return new IntTree<>(j2 + j, intTree.c, intTree3, new IntTree(-j2, v, intTree4.d(intTree4.f3566b + j2), intTree2));
                }
                IntTree<V> intTree5 = intTree4.d;
                IntTree<V> intTree6 = intTree4.e;
                long j3 = intTree4.f3566b;
                long j4 = intTree.f3566b + j3 + j;
                V v2 = intTree4.c;
                IntTree intTree7 = new IntTree(-j3, intTree.c, intTree3, intTree5.d(intTree5.f3566b + j3));
                long j5 = intTree.f3566b;
                long j6 = intTree4.f3566b;
                return new IntTree<>(j4, v2, intTree7, new IntTree((-j5) - j6, v, intTree6.d(intTree6.f3566b + j6 + j5), intTree2));
            }
            if (i2 >= i * 5) {
                IntTree<V> intTree8 = intTree2.d;
                IntTree<V> intTree9 = intTree2.e;
                if (intTree8.f < intTree9.f * 2) {
                    long j7 = intTree2.f3566b;
                    return new IntTree<>(j7 + j, intTree2.c, new IntTree(-j7, v, intTree, intTree8.d(intTree8.f3566b + j7)), intTree9);
                }
                IntTree<V> intTree10 = intTree8.d;
                IntTree<V> intTree11 = intTree8.e;
                long j8 = intTree8.f3566b;
                long j9 = intTree2.f3566b;
                long j10 = j8 + j9 + j;
                V v3 = intTree8.c;
                IntTree intTree12 = new IntTree((-j9) - j8, v, intTree, intTree10.d(intTree10.f3566b + j8 + j9));
                long j11 = intTree8.f3566b;
                return new IntTree<>(j10, v3, intTree12, new IntTree(-j11, intTree2.c, intTree11.d(intTree11.f3566b + j11), intTree9));
            }
        }
        return new IntTree<>(j, v, intTree, intTree2);
    }

    public final IntTree<V> d(long j) {
        return (this.f == 0 || j == this.f3566b) ? this : new IntTree<>(j, this.c, this.d, this.e);
    }

    public IntTree(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        this.f3566b = j;
        this.c = v;
        this.d = intTree;
        this.e = intTree2;
        this.f = intTree.f + 1 + intTree2.f;
    }
}
