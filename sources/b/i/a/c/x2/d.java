package b.i.a.c.x2;

/* JADX INFO: compiled from: ConstantBitrateSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements t {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1167b;
    public final int c;
    public final long d;
    public final int e;
    public final long f;
    public final boolean g;

    public d(long j, long j2, int i, int i2, boolean z2) {
        this.a = j;
        this.f1167b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        this.g = z2;
        if (j == -1) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        } else {
            this.d = j - j2;
            this.f = e(j, j2, i);
        }
    }

    public static long e(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * 1000000) / ((long) i);
    }

    public long b(long j) {
        return e(j, this.f1167b, this.e);
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return this.d != -1 || this.g;
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        long j2 = this.d;
        if (j2 == -1 && !this.g) {
            return new t$a(new u(0L, this.f1167b));
        }
        long j3 = (((long) this.e) * j) / 8000000;
        long j4 = this.c;
        long jMin = (j3 / j4) * j4;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - j4);
        }
        long jMax = this.f1167b + Math.max(jMin, 0L);
        long jB = b(jMax);
        u uVar = new u(jB, jMax);
        if (this.d != -1 && jB < j) {
            int i = this.c;
            if (((long) i) + jMax < this.a) {
                long j5 = jMax + ((long) i);
                return new t$a(uVar, new u(b(j5), j5));
            }
        }
        return new t$a(uVar);
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.f;
    }
}
