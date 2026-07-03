package p007b.p225i.p226a.p242c.p260g3;

import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.g3.p */
/* JADX INFO: compiled from: FixedFrameRateEstimator.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2779p {

    /* JADX INFO: renamed from: c */
    public boolean f6852c;

    /* JADX INFO: renamed from: e */
    public int f6854e;

    /* JADX INFO: renamed from: a */
    public a f6850a = new a();

    /* JADX INFO: renamed from: b */
    public a f6851b = new a();

    /* JADX INFO: renamed from: d */
    public long f6853d = -9223372036854775807L;

    /* JADX INFO: renamed from: b.i.a.c.g3.p$a */
    /* JADX INFO: compiled from: FixedFrameRateEstimator.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public long f6855a;

        /* JADX INFO: renamed from: b */
        public long f6856b;

        /* JADX INFO: renamed from: c */
        public long f6857c;

        /* JADX INFO: renamed from: d */
        public long f6858d;

        /* JADX INFO: renamed from: e */
        public long f6859e;

        /* JADX INFO: renamed from: f */
        public long f6860f;

        /* JADX INFO: renamed from: g */
        public final boolean[] f6861g = new boolean[15];

        /* JADX INFO: renamed from: h */
        public int f6862h;

        /* JADX INFO: renamed from: a */
        public boolean m3128a() {
            return this.f6858d > 15 && this.f6862h == 0;
        }

        /* JADX INFO: renamed from: b */
        public void m3129b(long j) {
            long j2 = this.f6858d;
            if (j2 == 0) {
                this.f6855a = j;
            } else if (j2 == 1) {
                long j3 = j - this.f6855a;
                this.f6856b = j3;
                this.f6860f = j3;
                this.f6859e = 1L;
            } else {
                long j4 = j - this.f6857c;
                int i = (int) (j2 % 15);
                if (Math.abs(j4 - this.f6856b) <= 1000000) {
                    this.f6859e++;
                    this.f6860f += j4;
                    boolean[] zArr = this.f6861g;
                    if (zArr[i]) {
                        zArr[i] = false;
                        this.f6862h--;
                    }
                } else {
                    boolean[] zArr2 = this.f6861g;
                    if (!zArr2[i]) {
                        zArr2[i] = true;
                        this.f6862h++;
                    }
                }
            }
            this.f6858d++;
            this.f6857c = j;
        }

        /* JADX INFO: renamed from: c */
        public void m3130c() {
            this.f6858d = 0L;
            this.f6859e = 0L;
            this.f6860f = 0L;
            this.f6862h = 0;
            Arrays.fill(this.f6861g, false);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m3127a() {
        return this.f6850a.m3128a();
    }
}
