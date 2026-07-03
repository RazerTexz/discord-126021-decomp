package p507d0.p588x;

/* JADX INFO: renamed from: d0.x.c */
/* JADX INFO: compiled from: progressionUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12197c {
    /* JADX INFO: renamed from: a */
    public static final int m10089a(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* JADX INFO: renamed from: b */
    public static final long m10090b(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - m10089a(m10089a(i2, i3) - m10089a(i, i3), i3);
        }
        if (i3 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if (i <= i2) {
            return i2;
        }
        int i4 = -i3;
        return i2 + m10089a(m10089a(i, i4) - m10089a(i2, i4), i4);
    }

    public static final long getProgressionLastElement(long j, long j2, long j3) {
        if (j3 > 0) {
            return j >= j2 ? j2 : j2 - m10090b(m10090b(j2, j3) - m10090b(j, j3), j3);
        }
        if (j3 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if (j <= j2) {
            return j2;
        }
        long j4 = -j3;
        return j2 + m10090b(m10090b(j, j4) - m10090b(j2, j4), j4);
    }
}
