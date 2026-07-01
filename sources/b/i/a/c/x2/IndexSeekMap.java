package b.i.a.c.x2;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.SeekMap;

/* JADX INFO: renamed from: b.i.a.c.x2.r, reason: use source file name */
/* JADX INFO: compiled from: IndexSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class IndexSeekMap implements SeekMap {
    public final long[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f1295b;
    public final long c;
    public final boolean d;

    public IndexSeekMap(long[] jArr, long[] jArr2, long j) {
        AnimatableValueParser.j(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z2 = length > 0;
        this.d = z2;
        if (!z2 || jArr2[0] <= 0) {
            this.a = jArr;
            this.f1295b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.a = jArr3;
            long[] jArr4 = new long[i];
            this.f1295b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.c = j;
    }

    @Override // b.i.a.c.x2.SeekMap
    public boolean c() {
        return this.d;
    }

    @Override // b.i.a.c.x2.SeekMap
    public SeekMap.a h(long j) {
        if (!this.d) {
            return new SeekMap.a(SeekPoint.a);
        }
        int iE = Util2.e(this.f1295b, j, true, true);
        long[] jArr = this.f1295b;
        long j2 = jArr[iE];
        long[] jArr2 = this.a;
        SeekPoint seekPoint = new SeekPoint(j2, jArr2[iE]);
        if (j2 == j || iE == jArr.length - 1) {
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
