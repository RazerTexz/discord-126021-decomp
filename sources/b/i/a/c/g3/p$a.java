package b.i.a.c.g3;

import java.util.Arrays;

/* JADX INFO: compiled from: FixedFrameRateEstimator.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f988b;
    public long c;
    public long d;
    public long e;
    public long f;
    public final boolean[] g = new boolean[15];
    public int h;

    public boolean a() {
        return this.d > 15 && this.h == 0;
    }

    public void b(long j) {
        long j2 = this.d;
        if (j2 == 0) {
            this.a = j;
        } else if (j2 == 1) {
            long j3 = j - this.a;
            this.f988b = j3;
            this.f = j3;
            this.e = 1L;
        } else {
            long j4 = j - this.c;
            int i = (int) (j2 % 15);
            if (Math.abs(j4 - this.f988b) <= 1000000) {
                this.e++;
                this.f += j4;
                boolean[] zArr = this.g;
                if (zArr[i]) {
                    zArr[i] = false;
                    this.h--;
                }
            } else {
                boolean[] zArr2 = this.g;
                if (!zArr2[i]) {
                    zArr2[i] = true;
                    this.h++;
                }
            }
        }
        this.d++;
        this.c = j;
    }

    public void c() {
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.h = 0;
        Arrays.fill(this.g, false);
    }
}
