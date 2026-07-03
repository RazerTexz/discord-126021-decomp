package p007b.p225i.p226a.p242c.p267x2.p273h0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p267x2.C3120u;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.i */
/* JADX INFO: compiled from: XingSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3040i implements InterfaceC3038g {

    /* JADX INFO: renamed from: a */
    public final long f8340a;

    /* JADX INFO: renamed from: b */
    public final int f8341b;

    /* JADX INFO: renamed from: c */
    public final long f8342c;

    /* JADX INFO: renamed from: d */
    public final long f8343d;

    /* JADX INFO: renamed from: e */
    public final long f8344e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final long[] f8345f;

    public C3040i(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.f8340a = j;
        this.f8341b = i;
        this.f8342c = j2;
        this.f8345f = jArr;
        this.f8343d = j3;
        this.f8344e = j3 != -1 ? j + j3 : -1L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g
    /* JADX INFO: renamed from: a */
    public long mo3689a() {
        return this.f8344e;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return this.f8345f != null;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g
    /* JADX INFO: renamed from: d */
    public long mo3690d(long j) {
        long j2 = j - this.f8340a;
        if (!mo3619c() || j2 <= this.f8341b) {
            return 0L;
        }
        long[] jArr = this.f8345f;
        C1460d.m438H(jArr);
        double d = (j2 * 256.0d) / this.f8343d;
        int iM2997e = C2738e0.m2997e(jArr, (long) d, true, true);
        long j3 = this.f8342c;
        long j4 = (((long) iM2997e) * j3) / 100;
        long j5 = jArr[iM2997e];
        int i = iM2997e + 1;
        long j6 = (j3 * ((long) i)) / 100;
        long j7 = iM2997e == 99 ? 256L : jArr[i];
        return Math.round((j5 == j7 ? 0.0d : (d - j5) / (j7 - j5)) * (j6 - j4)) + j4;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        if (!mo3619c()) {
            return new InterfaceC3119t.a(new C3120u(0L, this.f8340a + ((long) this.f8341b)));
        }
        long jM3001i = C2738e0.m3001i(j, 0L, this.f8342c);
        double d = (jM3001i * 100.0d) / this.f8342c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = this.f8345f;
                C1460d.m438H(jArr);
                long[] jArr2 = jArr;
                double d3 = jArr2[i];
                d2 = d3 + (((i == 99 ? 256.0d : jArr2[i + 1]) - d3) * (d - ((double) i)));
            }
        }
        return new InterfaceC3119t.a(new C3120u(jM3001i, this.f8340a + C2738e0.m3001i(Math.round((d2 / 256.0d) * this.f8343d), this.f8341b, this.f8343d - 1)));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8342c;
    }
}
