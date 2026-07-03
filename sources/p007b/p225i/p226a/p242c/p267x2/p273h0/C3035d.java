package p007b.p225i.p226a.p242c.p267x2.p273h0;

import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2751r;
import p007b.p225i.p226a.p242c.p267x2.C3120u;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.d */
/* JADX INFO: compiled from: IndexSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3035d implements InterfaceC3038g {

    /* JADX INFO: renamed from: a */
    public final long f8308a;

    /* JADX INFO: renamed from: b */
    public final C2751r f8309b;

    /* JADX INFO: renamed from: c */
    public final C2751r f8310c;

    /* JADX INFO: renamed from: d */
    public long f8311d;

    public C3035d(long j, long j2, long j3) {
        this.f8311d = j;
        this.f8308a = j3;
        C2751r c2751r = new C2751r();
        this.f8309b = c2751r;
        C2751r c2751r2 = new C2751r();
        this.f8310c = c2751r2;
        c2751r.m3041a(0L);
        c2751r2.m3041a(j2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g
    /* JADX INFO: renamed from: a */
    public long mo3689a() {
        return this.f8308a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m3691b(long j) {
        C2751r c2751r = this.f8309b;
        return j - c2751r.m3042b(c2751r.f6747a - 1) < 100000;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.InterfaceC3038g
    /* JADX INFO: renamed from: d */
    public long mo3690d(long j) {
        return this.f8309b.m3042b(C2738e0.m2995c(this.f8310c, j, true, true));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        int iM2995c = C2738e0.m2995c(this.f8309b, j, true, true);
        long jM3042b = this.f8309b.m3042b(iM2995c);
        C3120u c3120u = new C3120u(jM3042b, this.f8310c.m3042b(iM2995c));
        if (jM3042b != j) {
            C2751r c2751r = this.f8309b;
            if (iM2995c != c2751r.f6747a - 1) {
                int i = iM2995c + 1;
                return new InterfaceC3119t.a(c3120u, new C3120u(c2751r.m3042b(i), this.f8310c.m3042b(i)));
            }
        }
        return new InterfaceC3119t.a(c3120u);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8311d;
    }
}
