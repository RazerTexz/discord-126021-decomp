package p007b.p225i.p226a.p242c.p267x2;

import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.x2.n */
/* JADX INFO: compiled from: FlacSeekTableSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3113n implements InterfaceC3119t {

    /* JADX INFO: renamed from: a */
    public final C3114o f8968a;

    /* JADX INFO: renamed from: b */
    public final long f8969b;

    public C3113n(C3114o c3114o, long j) {
        this.f8968a = c3114o;
        this.f8969b = j;
    }

    /* JADX INFO: renamed from: b */
    public final C3120u m3805b(long j, long j2) {
        return new C3120u((j * 1000000) / ((long) this.f8968a.f8974e), this.f8969b + j2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        C1460d.m438H(this.f8968a.f8980k);
        C3114o c3114o = this.f8968a;
        C3114o.a aVar = c3114o.f8980k;
        long[] jArr = aVar.f8982a;
        long[] jArr2 = aVar.f8983b;
        int iM2997e = C2738e0.m2997e(jArr, c3114o.m3813g(j), true, false);
        C3120u c3120uM3805b = m3805b(iM2997e == -1 ? 0L : jArr[iM2997e], iM2997e != -1 ? jArr2[iM2997e] : 0L);
        if (c3120uM3805b.f8998b == j || iM2997e == jArr.length - 1) {
            return new InterfaceC3119t.a(c3120uM3805b);
        }
        int i = iM2997e + 1;
        return new InterfaceC3119t.a(c3120uM3805b, m3805b(jArr[i], jArr2[i]));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8968a.m3810d();
    }
}
