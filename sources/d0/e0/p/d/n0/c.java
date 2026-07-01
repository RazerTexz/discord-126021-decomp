package d0.e0.p.d.n0;

/* JADX INFO: compiled from: IntTree.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<V> {
    public static final c<Object> a = new c<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3566b;
    public final V c;
    public final c<V> d;
    public final c<V> e;
    public final int f;

    public c() {
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

    public c<V> b(long j, V v) {
        if (this.f == 0) {
            return new c<>(j, v, this, this);
        }
        long j2 = this.f3566b;
        if (j < j2) {
            return c(this.d.b(j - j2, v), this.e);
        }
        if (j > j2) {
            return c(this.d, this.e.b(j - j2, v));
        }
        return v == this.c ? this : new c<>(j, v, this.d, this.e);
    }

    public final c<V> c(c<V> cVar, c<V> cVar2) {
        if (cVar == this.d && cVar2 == this.e) {
            return this;
        }
        long j = this.f3566b;
        V v = this.c;
        int i = cVar.f;
        int i2 = cVar2.f;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                c<V> cVar3 = cVar.d;
                c<V> cVar4 = cVar.e;
                if (cVar4.f < cVar3.f * 2) {
                    long j2 = cVar.f3566b;
                    return new c<>(j2 + j, cVar.c, cVar3, new c(-j2, v, cVar4.d(cVar4.f3566b + j2), cVar2));
                }
                c<V> cVar5 = cVar4.d;
                c<V> cVar6 = cVar4.e;
                long j3 = cVar4.f3566b;
                long j4 = cVar.f3566b + j3 + j;
                V v2 = cVar4.c;
                c cVar7 = new c(-j3, cVar.c, cVar3, cVar5.d(cVar5.f3566b + j3));
                long j5 = cVar.f3566b;
                long j6 = cVar4.f3566b;
                return new c<>(j4, v2, cVar7, new c((-j5) - j6, v, cVar6.d(cVar6.f3566b + j6 + j5), cVar2));
            }
            if (i2 >= i * 5) {
                c<V> cVar8 = cVar2.d;
                c<V> cVar9 = cVar2.e;
                if (cVar8.f < cVar9.f * 2) {
                    long j7 = cVar2.f3566b;
                    return new c<>(j7 + j, cVar2.c, new c(-j7, v, cVar, cVar8.d(cVar8.f3566b + j7)), cVar9);
                }
                c<V> cVar10 = cVar8.d;
                c<V> cVar11 = cVar8.e;
                long j8 = cVar8.f3566b;
                long j9 = cVar2.f3566b;
                long j10 = j8 + j9 + j;
                V v3 = cVar8.c;
                c cVar12 = new c((-j9) - j8, v, cVar, cVar10.d(cVar10.f3566b + j8 + j9));
                long j11 = cVar8.f3566b;
                return new c<>(j10, v3, cVar12, new c(-j11, cVar2.c, cVar11.d(cVar11.f3566b + j11), cVar9));
            }
        }
        return new c<>(j, v, cVar, cVar2);
    }

    public final c<V> d(long j) {
        return (this.f == 0 || j == this.f3566b) ? this : new c<>(j, this.c, this.d, this.e);
    }

    public c(long j, V v, c<V> cVar, c<V> cVar2) {
        this.f3566b = j;
        this.c = v;
        this.d = cVar;
        this.e = cVar2;
        this.f = cVar.f + 1 + cVar2.f;
    }
}
