package b.i.e.q.r;

import b.i.e.ResultPoint;

/* JADX INFO: renamed from: b.i.e.q.r.c, reason: use source file name */
/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FinderPattern {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1864b;
    public final ResultPoint[] c;

    public FinderPattern(int i, int[] iArr, int i2, int i3, int i4) {
        this.a = i;
        this.f1864b = iArr;
        float f = i4;
        this.c = new ResultPoint[]{new ResultPoint(i2, f), new ResultPoint(i3, f)};
    }

    public boolean equals(Object obj) {
        return (obj instanceof FinderPattern) && this.a == ((FinderPattern) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
