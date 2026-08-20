package p007b.p225i.p226a.p242c.p267x2;

/* JADX INFO: renamed from: b.i.a.c.x2.d */
/* JADX INFO: compiled from: ConstantBitrateSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class C3006d implements InterfaceC3119t {

    /* JADX INFO: renamed from: a */
    public final long f8088a;

    /* JADX INFO: renamed from: b */
    public final long f8089b;

    /* JADX INFO: renamed from: c */
    public final int f8090c;

    /* JADX INFO: renamed from: d */
    public final long f8091d;

    /* JADX INFO: renamed from: e */
    public final int f8092e;

    /* JADX INFO: renamed from: f */
    public final long f8093f;

    /* JADX INFO: renamed from: g */
    public final boolean f8094g;

    public C3006d(long j, long j2, int i, int i2, boolean z2) {
        this.f8088a = j;
        this.f8089b = j2;
        this.f8090c = i2 == -1 ? 1 : i2;
        this.f8092e = i;
        this.f8094g = z2;
        if (j == -1) {
            this.f8091d = -1L;
            this.f8093f = -9223372036854775807L;
        } else {
            this.f8091d = j - j2;
            this.f8093f = m3638e(j, j2, i);
        }
    }

    /* JADX INFO: renamed from: e */
    public static long m3638e(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * 1000000) / ((long) i);
    }

    /* JADX INFO: renamed from: b */
    public long m3639b(long j) {
        return m3638e(j, this.f8089b, this.f8092e);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return this.f8091d != -1 || this.f8094g;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        long j2 = this.f8091d;
        if (j2 == -1 && !this.f8094g) {
            return new InterfaceC3119t.a(new C3120u(0L, this.f8089b));
        }
        long j3 = (((long) this.f8092e) * j) / 8000000;
        long j4 = this.f8090c;
        long jMin = (j3 / j4) * j4;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - j4);
        }
        long jMax = this.f8089b + Math.max(jMin, 0L);
        long jM3639b = m3639b(jMax);
        C3120u c3120u = new C3120u(jM3639b, jMax);
        if (this.f8091d != -1 && jM3639b < j) {
            int i = this.f8090c;
            if (((long) i) + jMax < this.f8088a) {
                long j5 = jMax + ((long) i);
                return new InterfaceC3119t.a(c3120u, new C3120u(m3639b(j5), j5));
            }
        }
        return new InterfaceC3119t.a(c3120u);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8093f;
    }
}
