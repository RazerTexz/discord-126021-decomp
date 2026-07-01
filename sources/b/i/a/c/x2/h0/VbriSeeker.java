package b.i.a.c.x2.h0;

import b.i.a.c.f3.Util2;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.SeekPoint;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.h, reason: use source file name */
/* JADX INFO: compiled from: VbriSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class VbriSeeker implements Seeker {
    public final long[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f1207b;
    public final long c;
    public final long d;

    public VbriSeeker(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.f1207b = jArr2;
        this.c = j;
        this.d = j2;
    }

    @Override // b.i.a.c.x2.h0.Seeker
    public long a() {
        return this.d;
    }

    @Override // b.i.a.c.x2.SeekMap
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.h0.Seeker
    public long d(long j) {
        return this.a[Util2.e(this.f1207b, j, true, true)];
    }

    @Override // b.i.a.c.x2.SeekMap
    public SeekMap.a h(long j) {
        int iE = Util2.e(this.a, j, true, true);
        long[] jArr = this.a;
        long j2 = jArr[iE];
        long[] jArr2 = this.f1207b;
        SeekPoint seekPoint = new SeekPoint(j2, jArr2[iE]);
        if (j2 >= j || iE == jArr.length - 1) {
            return new SeekMap.a(seekPoint);
        }
        int i = iE + 1;
        return new SeekMap.a(seekPoint, new SeekPoint(jArr[i], jArr2[i]));
    }

    @Override // b.i.a.c.x2.SeekMap
    public long i() {
        return this.c;
    }
}
