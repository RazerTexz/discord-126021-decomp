package b.i.a.c.x2.i0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.p, reason: use source file name */
/* JADX INFO: compiled from: TrackSampleTable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSampleTable {
    public final Track a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1233b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public TrackSampleTable(Track track, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        AnimatableValueParser.j(iArr.length == jArr2.length);
        AnimatableValueParser.j(jArr.length == jArr2.length);
        AnimatableValueParser.j(iArr2.length == jArr2.length);
        this.a = track;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.f1233b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j) {
        for (int iE = Util2.e(this.f, j, true, false); iE >= 0; iE--) {
            if ((this.g[iE] & 1) != 0) {
                return iE;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int iB = Util2.b(this.f, j, true, false); iB < this.f.length; iB++) {
            if ((this.g[iB] & 1) != 0) {
                return iB;
            }
        }
        return -1;
    }
}
