package b.i.a.c.x2;

import b.i.a.c.f3.e0;

/* JADX INFO: compiled from: BinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$c {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1161b;
    public final long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    public a$c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.a = j;
        this.f1161b = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.c = j7;
        this.h = a(j2, j3, j4, j5, j6, j7);
    }

    public static long a(long j, long j2, long j3, long j4, long j5, long j6) {
        if (j4 + 1 >= j5 || j2 + 1 >= j3) {
            return j4;
        }
        long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
        return e0.i(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
    }
}
