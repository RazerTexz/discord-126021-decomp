package p007b.p225i.p226a.p242c.p267x2.p277l0;

import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p267x2.C3120u;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.l0.e */
/* JADX INFO: compiled from: WavSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3111e implements InterfaceC3119t {

    /* JADX INFO: renamed from: a */
    public final C3109c f8962a;

    /* JADX INFO: renamed from: b */
    public final int f8963b;

    /* JADX INFO: renamed from: c */
    public final long f8964c;

    /* JADX INFO: renamed from: d */
    public final long f8965d;

    /* JADX INFO: renamed from: e */
    public final long f8966e;

    public C3111e(C3109c c3109c, int i, long j, long j2) {
        this.f8962a = c3109c;
        this.f8963b = i;
        this.f8964c = j;
        long j3 = (j2 - j) / ((long) c3109c.f8957d);
        this.f8965d = j3;
        this.f8966e = m3801b(j3);
    }

    /* JADX INFO: renamed from: b */
    public final long m3801b(long j) {
        return C2738e0.m2985F(j * ((long) this.f8963b), 1000000L, this.f8962a.f8956c);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        long jM3001i = C2738e0.m3001i((((long) this.f8962a.f8956c) * j) / (((long) this.f8963b) * 1000000), 0L, this.f8965d - 1);
        long j2 = (((long) this.f8962a.f8957d) * jM3001i) + this.f8964c;
        long jM3801b = m3801b(jM3001i);
        C3120u c3120u = new C3120u(jM3801b, j2);
        if (jM3801b >= j || jM3001i == this.f8965d - 1) {
            return new InterfaceC3119t.a(c3120u);
        }
        long j3 = jM3001i + 1;
        return new InterfaceC3119t.a(c3120u, new C3120u(m3801b(j3), (((long) this.f8962a.f8957d) * j3) + this.f8964c));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8966e;
    }
}
