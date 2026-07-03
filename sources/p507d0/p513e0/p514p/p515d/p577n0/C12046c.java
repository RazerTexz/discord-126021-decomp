package p507d0.p513e0.p514p.p515d.p577n0;

/* JADX INFO: renamed from: d0.e0.p.d.n0.c */
/* JADX INFO: compiled from: IntTree.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12046c<V> {

    /* JADX INFO: renamed from: a */
    public static final C12046c<Object> f25026a = new C12046c<>();

    /* JADX INFO: renamed from: b */
    public final long f25027b;

    /* JADX INFO: renamed from: c */
    public final V f25028c;

    /* JADX INFO: renamed from: d */
    public final C12046c<V> f25029d;

    /* JADX INFO: renamed from: e */
    public final C12046c<V> f25030e;

    /* JADX INFO: renamed from: f */
    public final int f25031f;

    public C12046c() {
        this.f25031f = 0;
        this.f25027b = 0L;
        this.f25028c = null;
        this.f25029d = null;
        this.f25030e = null;
    }

    /* JADX INFO: renamed from: a */
    public V m10051a(long j) {
        if (this.f25031f == 0) {
            return null;
        }
        long j2 = this.f25027b;
        if (j < j2) {
            return this.f25029d.m10051a(j - j2);
        }
        return j > j2 ? this.f25030e.m10051a(j - j2) : this.f25028c;
    }

    /* JADX INFO: renamed from: b */
    public C12046c<V> m10052b(long j, V v) {
        if (this.f25031f == 0) {
            return new C12046c<>(j, v, this, this);
        }
        long j2 = this.f25027b;
        if (j < j2) {
            return m10053c(this.f25029d.m10052b(j - j2, v), this.f25030e);
        }
        if (j > j2) {
            return m10053c(this.f25029d, this.f25030e.m10052b(j - j2, v));
        }
        return v == this.f25028c ? this : new C12046c<>(j, v, this.f25029d, this.f25030e);
    }

    /* JADX INFO: renamed from: c */
    public final C12046c<V> m10053c(C12046c<V> c12046c, C12046c<V> c12046c2) {
        if (c12046c == this.f25029d && c12046c2 == this.f25030e) {
            return this;
        }
        long j = this.f25027b;
        V v = this.f25028c;
        int i = c12046c.f25031f;
        int i2 = c12046c2.f25031f;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                C12046c<V> c12046c3 = c12046c.f25029d;
                C12046c<V> c12046c4 = c12046c.f25030e;
                if (c12046c4.f25031f < c12046c3.f25031f * 2) {
                    long j2 = c12046c.f25027b;
                    return new C12046c<>(j2 + j, c12046c.f25028c, c12046c3, new C12046c(-j2, v, c12046c4.m10054d(c12046c4.f25027b + j2), c12046c2));
                }
                C12046c<V> c12046c5 = c12046c4.f25029d;
                C12046c<V> c12046c6 = c12046c4.f25030e;
                long j3 = c12046c4.f25027b;
                long j4 = c12046c.f25027b + j3 + j;
                V v2 = c12046c4.f25028c;
                C12046c c12046c7 = new C12046c(-j3, c12046c.f25028c, c12046c3, c12046c5.m10054d(c12046c5.f25027b + j3));
                long j5 = c12046c.f25027b;
                long j6 = c12046c4.f25027b;
                return new C12046c<>(j4, v2, c12046c7, new C12046c((-j5) - j6, v, c12046c6.m10054d(c12046c6.f25027b + j6 + j5), c12046c2));
            }
            if (i2 >= i * 5) {
                C12046c<V> c12046c8 = c12046c2.f25029d;
                C12046c<V> c12046c9 = c12046c2.f25030e;
                if (c12046c8.f25031f < c12046c9.f25031f * 2) {
                    long j7 = c12046c2.f25027b;
                    return new C12046c<>(j7 + j, c12046c2.f25028c, new C12046c(-j7, v, c12046c, c12046c8.m10054d(c12046c8.f25027b + j7)), c12046c9);
                }
                C12046c<V> c12046c10 = c12046c8.f25029d;
                C12046c<V> c12046c11 = c12046c8.f25030e;
                long j8 = c12046c8.f25027b;
                long j9 = c12046c2.f25027b;
                long j10 = j8 + j9 + j;
                V v3 = c12046c8.f25028c;
                C12046c c12046c12 = new C12046c((-j9) - j8, v, c12046c, c12046c10.m10054d(c12046c10.f25027b + j8 + j9));
                long j11 = c12046c8.f25027b;
                return new C12046c<>(j10, v3, c12046c12, new C12046c(-j11, c12046c2.f25028c, c12046c11.m10054d(c12046c11.f25027b + j11), c12046c9));
            }
        }
        return new C12046c<>(j, v, c12046c, c12046c2);
    }

    /* JADX INFO: renamed from: d */
    public final C12046c<V> m10054d(long j) {
        return (this.f25031f == 0 || j == this.f25027b) ? this : new C12046c<>(j, this.f25028c, this.f25029d, this.f25030e);
    }

    public C12046c(long j, V v, C12046c<V> c12046c, C12046c<V> c12046c2) {
        this.f25027b = j;
        this.f25028c = v;
        this.f25029d = c12046c;
        this.f25030e = c12046c2;
        this.f25031f = c12046c.f25031f + 1 + c12046c2.f25031f;
    }
}
