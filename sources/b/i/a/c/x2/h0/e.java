package b.i.a.c.x2.h0;

import android.util.Pair;
import b.i.a.c.f3.e0;
import b.i.a.c.x2.t$a;
import b.i.a.c.x2.u;

/* JADX INFO: compiled from: MlltSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements g {
    public final long[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f1204b;
    public final long c;

    public e(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.f1204b = jArr2;
        this.c = j == -9223372036854775807L ? e0.B(jArr2[jArr2.length - 1]) : j;
    }

    public static Pair<Long, Long> b(long j, long[] jArr, long[] jArr2) {
        int iE = e0.e(jArr, j, true, true);
        long j2 = jArr[iE];
        long j3 = jArr2[iE];
        int i = iE + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? 0.0d : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // b.i.a.c.x2.h0.g
    public long a() {
        return -1L;
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.h0.g
    public long d(long j) {
        return e0.B(((Long) b(j, this.a, this.f1204b).second).longValue());
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        Pair<Long, Long> pairB = b(e0.M(e0.i(j, 0L, this.c)), this.f1204b, this.a);
        return new t$a(new u(e0.B(((Long) pairB.first).longValue()), ((Long) pairB.second).longValue()));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.c;
    }
}
