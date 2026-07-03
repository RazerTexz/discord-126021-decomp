package p007b.p225i.p226a.p242c.p267x2.p273h0;

import android.util.Pair;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p267x2.C3120u;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.e */
/* JADX INFO: compiled from: MlltSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3036e implements InterfaceC3038g {

    /* JADX INFO: renamed from: a */
    public final long[] f8312a;

    /* JADX INFO: renamed from: b */
    public final long[] f8313b;

    /* JADX INFO: renamed from: c */
    public final long f8314c;

    public C3036e(long[] jArr, long[] jArr2, long j) {
        this.f8312a = jArr;
        this.f8313b = jArr2;
        this.f8314c = j == -9223372036854775807L ? C2738e0.m2981B(jArr2[jArr2.length - 1]) : j;
    }

    /* JADX INFO: renamed from: b */
    public static Pair<Long, Long> m3692b(long j, long[] jArr, long[] jArr2) {
        int iM2997e = C2738e0.m2997e(jArr, j, true, true);
        long j2 = jArr[iM2997e];
        long j3 = jArr2[iM2997e];
        int i = iM2997e + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? 0.0d : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g
    /* JADX INFO: renamed from: a */
    public long mo3689a() {
        return -1L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g
    /* JADX INFO: renamed from: d */
    public long mo3690d(long j) {
        return C2738e0.m2981B(((Long) m3692b(j, this.f8312a, this.f8313b).second).longValue());
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        Pair<Long, Long> pairM3692b = m3692b(C2738e0.m2992M(C2738e0.m3001i(j, 0L, this.f8314c)), this.f8313b, this.f8312a);
        return new InterfaceC3119t.a(new C3120u(C2738e0.m2981B(((Long) pairM3692b.first).longValue()), ((Long) pairM3692b.second).longValue()));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8314c;
    }
}
