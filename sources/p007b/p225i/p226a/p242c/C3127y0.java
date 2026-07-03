package p007b.p225i.p226a.p242c;

/* JADX INFO: renamed from: b.i.a.c.y0 */
/* JADX INFO: compiled from: DefaultLivePlaybackSpeedControl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3127y0 implements InterfaceC2823m1 {

    /* JADX INFO: renamed from: a */
    public final long f9017a;

    /* JADX INFO: renamed from: b */
    public final long f9018b;

    /* JADX INFO: renamed from: c */
    public final float f9019c;

    /* JADX INFO: renamed from: j */
    public float f9026j;

    /* JADX INFO: renamed from: k */
    public float f9027k;

    /* JADX INFO: renamed from: d */
    public long f9020d = -9223372036854775807L;

    /* JADX INFO: renamed from: e */
    public long f9021e = -9223372036854775807L;

    /* JADX INFO: renamed from: g */
    public long f9023g = -9223372036854775807L;

    /* JADX INFO: renamed from: h */
    public long f9024h = -9223372036854775807L;

    /* JADX INFO: renamed from: l */
    public float f9028l = 1.0f;

    /* JADX INFO: renamed from: m */
    public long f9029m = -9223372036854775807L;

    /* JADX INFO: renamed from: f */
    public long f9022f = -9223372036854775807L;

    /* JADX INFO: renamed from: i */
    public long f9025i = -9223372036854775807L;

    /* JADX INFO: renamed from: n */
    public long f9030n = -9223372036854775807L;

    /* JADX INFO: renamed from: o */
    public long f9031o = -9223372036854775807L;

    public C3127y0(float f, float f2, long j, float f3, long j2, long j3, float f4, a aVar) {
        this.f9017a = j2;
        this.f9018b = j3;
        this.f9019c = f4;
        this.f9027k = f;
        this.f9026j = f2;
    }

    /* JADX INFO: renamed from: a */
    public final void m3825a() {
        long j = this.f9020d;
        if (j != -9223372036854775807L) {
            long j2 = this.f9021e;
            if (j2 != -9223372036854775807L) {
                j = j2;
            }
            long j3 = this.f9023g;
            if (j3 != -9223372036854775807L && j < j3) {
                j = j3;
            }
            long j4 = this.f9024h;
            if (j4 != -9223372036854775807L && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.f9022f == j) {
            return;
        }
        this.f9022f = j;
        this.f9025i = j;
        this.f9030n = -9223372036854775807L;
        this.f9031o = -9223372036854775807L;
        this.f9029m = -9223372036854775807L;
    }
}
