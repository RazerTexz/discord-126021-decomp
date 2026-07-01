package b.i.a.c;

/* JADX INFO: renamed from: b.i.a.c.y0, reason: use source file name */
/* JADX INFO: compiled from: DefaultLivePlaybackSpeedControl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1302b;
    public final float c;
    public float j;
    public float k;
    public long d = -9223372036854775807L;
    public long e = -9223372036854775807L;
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public float l = 1.0f;
    public long m = -9223372036854775807L;
    public long f = -9223372036854775807L;
    public long i = -9223372036854775807L;
    public long n = -9223372036854775807L;
    public long o = -9223372036854775807L;

    public DefaultLivePlaybackSpeedControl(float f, float f2, long j, float f3, long j2, long j3, float f4, a aVar) {
        this.a = j2;
        this.f1302b = j3;
        this.c = f4;
        this.k = f;
        this.j = f2;
    }

    public final void a() {
        long j = this.d;
        if (j != -9223372036854775807L) {
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                j = j2;
            }
            long j3 = this.g;
            if (j3 != -9223372036854775807L && j < j3) {
                j = j3;
            }
            long j4 = this.h;
            if (j4 != -9223372036854775807L && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.f == j) {
            return;
        }
        this.f = j;
        this.i = j;
        this.n = -9223372036854775807L;
        this.o = -9223372036854775807L;
        this.m = -9223372036854775807L;
    }
}
