package b.a.q.o0;

/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$a {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f281b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;

    public e$a() {
        this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16383);
    }

    public e$a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.a = j;
        this.f281b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
        this.h = j8;
        this.i = j9;
        this.j = j10;
        this.k = j11;
        this.l = j12;
        this.m = j13;
        this.n = j14;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e$a)) {
            return false;
        }
        e$a e_a = (e$a) obj;
        return this.a == e_a.a && this.f281b == e_a.f281b && this.c == e_a.c && this.d == e_a.d && this.e == e_a.e && this.f == e_a.f && this.g == e_a.g && this.h == e_a.h && this.i == e_a.i && this.j == e_a.j && this.k == e_a.k && this.l == e_a.l && this.m == e_a.m && this.n == e_a.n;
    }

    public int hashCode() {
        return a0.a.a.b.a(this.n) + ((a0.a.a.b.a(this.m) + ((a0.a.a.b.a(this.l) + ((a0.a.a.b.a(this.k) + ((a0.a.a.b.a(this.j) + ((a0.a.a.b.a(this.i) + ((a0.a.a.b.a(this.h) + ((a0.a.a.b.a(this.g) + ((a0.a.a.b.a(this.f) + ((a0.a.a.b.a(this.e) + ((a0.a.a.b.a(this.d) + ((a0.a.a.b.a(this.c) + ((a0.a.a.b.a(this.f281b) + (a0.a.a.b.a(this.a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("AggregatedProperties(framesCodec=");
        sbU.append(this.a);
        sbU.append(", framesNetwork=");
        sbU.append(this.f281b);
        sbU.append(", packets=");
        sbU.append(this.c);
        sbU.append(", packetsLost=");
        sbU.append(this.d);
        sbU.append(", framesDropped=");
        sbU.append(this.e);
        sbU.append(", bytes=");
        sbU.append(this.f);
        sbU.append(", nackCount=");
        sbU.append(this.g);
        sbU.append(", pliCount=");
        sbU.append(this.h);
        sbU.append(", qpSum=");
        sbU.append(this.i);
        sbU.append(", freezeCount=");
        sbU.append(this.j);
        sbU.append(", pauseCount=");
        sbU.append(this.k);
        sbU.append(", totalFreezesDuration=");
        sbU.append(this.l);
        sbU.append(", totalPausesDuration=");
        sbU.append(this.m);
        sbU.append(", totalFramesDuration=");
        return b.d.b.a.a.C(sbU, this.n, ")");
    }

    public /* synthetic */ e$a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) != 0 ? 0L : j4, (i & 16) != 0 ? 0L : j5, (i & 32) != 0 ? 0L : j6, (i & 64) != 0 ? 0L : j7, (i & 128) != 0 ? 0L : j8, (i & 256) != 0 ? 0L : j9, (i & 512) != 0 ? 0L : j10, (i & 1024) != 0 ? 0L : j11, (i & 2048) != 0 ? 0L : j12, (i & 4096) != 0 ? 0L : j13, (i & 8192) == 0 ? j14 : 0L);
    }
}
