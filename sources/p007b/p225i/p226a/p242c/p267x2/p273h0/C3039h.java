package p007b.p225i.p226a.p242c.p267x2.p273h0;

import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p267x2.C3120u;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.h */
/* JADX INFO: compiled from: VbriSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3039h implements InterfaceC3038g {

    /* JADX INFO: renamed from: a */
    public final long[] f8336a;

    /* JADX INFO: renamed from: b */
    public final long[] f8337b;

    /* JADX INFO: renamed from: c */
    public final long f8338c;

    /* JADX INFO: renamed from: d */
    public final long f8339d;

    public C3039h(long[] jArr, long[] jArr2, long j, long j2) {
        this.f8336a = jArr;
        this.f8337b = jArr2;
        this.f8338c = j;
        this.f8339d = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g
    /* JADX INFO: renamed from: a */
    public long mo3689a() {
        return this.f8339d;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g
    /* JADX INFO: renamed from: d */
    public long mo3690d(long j) {
        return this.f8336a[C2738e0.m2997e(this.f8337b, j, true, true)];
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        int iM2997e = C2738e0.m2997e(this.f8336a, j, true, true);
        long[] jArr = this.f8336a;
        long j2 = jArr[iM2997e];
        long[] jArr2 = this.f8337b;
        C3120u c3120u = new C3120u(j2, jArr2[iM2997e]);
        if (j2 >= j || iM2997e == jArr.length - 1) {
            return new InterfaceC3119t.a(c3120u);
        }
        int i = iM2997e + 1;
        return new InterfaceC3119t.a(c3120u, new C3120u(jArr[i], jArr2[i]));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8338c;
    }
}
