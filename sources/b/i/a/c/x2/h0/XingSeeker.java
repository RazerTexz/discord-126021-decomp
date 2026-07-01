package b.i.a.c.x2.h0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.SeekPoint;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.i, reason: use source file name */
/* JADX INFO: compiled from: XingSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class XingSeeker implements Seeker {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1208b;
    public final long c;
    public final long d;
    public final long e;

    @Nullable
    public final long[] f;

    public XingSeeker(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.a = j;
        this.f1208b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }

    @Override // b.i.a.c.x2.h0.Seeker
    public long a() {
        return this.e;
    }

    @Override // b.i.a.c.x2.SeekMap
    public boolean c() {
        return this.f != null;
    }

    @Override // b.i.a.c.x2.h0.Seeker
    public long d(long j) {
        long j2 = j - this.a;
        if (!c() || j2 <= this.f1208b) {
            return 0L;
        }
        long[] jArr = this.f;
        AnimatableValueParser.H(jArr);
        double d = (j2 * 256.0d) / this.d;
        int iE = Util2.e(jArr, (long) d, true, true);
        long j3 = this.c;
        long j4 = (((long) iE) * j3) / 100;
        long j5 = jArr[iE];
        int i = iE + 1;
        long j6 = (j3 * ((long) i)) / 100;
        long j7 = iE == 99 ? 256L : jArr[i];
        return Math.round((j5 == j7 ? 0.0d : (d - j5) / (j7 - j5)) * (j6 - j4)) + j4;
    }

    @Override // b.i.a.c.x2.SeekMap
    public SeekMap.a h(long j) {
        if (!c()) {
            return new SeekMap.a(new SeekPoint(0L, this.a + ((long) this.f1208b)));
        }
        long jI = Util2.i(j, 0L, this.c);
        double d = (jI * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = this.f;
                AnimatableValueParser.H(jArr);
                long[] jArr2 = jArr;
                double d3 = jArr2[i];
                d2 = d3 + (((i == 99 ? 256.0d : jArr2[i + 1]) - d3) * (d - ((double) i)));
            }
        }
        return new SeekMap.a(new SeekPoint(jI, this.a + Util2.i(Math.round((d2 / 256.0d) * this.d), this.f1208b, this.d - 1)));
    }

    @Override // b.i.a.c.x2.SeekMap
    public long i() {
        return this.c;
    }
}
