package p007b.p225i.p226a.p242c.p267x2.p276k0;

import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.x */
/* JADX INFO: compiled from: PassthroughSectionPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3103x implements InterfaceC3075c0 {

    /* JADX INFO: renamed from: a */
    public C2811j1 f8908a;

    /* JADX INFO: renamed from: b */
    public C2736d0 f8909b;

    /* JADX INFO: renamed from: c */
    public InterfaceC3122w f8910c;

    public C3103x(String str) {
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7173k = str;
        this.f8908a = bVar.m3277a();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3075c0
    /* JADX INFO: renamed from: a */
    public void mo3752a(C2736d0 c2736d0, InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        this.f8909b = c2736d0;
        dVar.m3765a();
        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 5);
        this.f8910c = interfaceC3122wMo2492p;
        interfaceC3122wMo2492p.mo2526e(this.f8908a);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3075c0
    /* JADX INFO: renamed from: b */
    public void mo3753b(C2757x c2757x) {
        long jM2974c;
        C1460d.m438H(this.f8909b);
        int i = C2738e0.f6708a;
        C2736d0 c2736d0 = this.f8909b;
        synchronized (c2736d0) {
            long j = c2736d0.f6702c;
            jM2974c = j != -9223372036854775807L ? j + c2736d0.f6701b : c2736d0.m2974c();
        }
        long jM2975d = this.f8909b.m2975d();
        if (jM2974c == -9223372036854775807L || jM2975d == -9223372036854775807L) {
            return;
        }
        C2811j1 c2811j1 = this.f8908a;
        if (jM2975d != c2811j1.f7127A) {
            C2811j1.b bVarM3275a = c2811j1.m3275a();
            bVarM3275a.f7177o = jM2975d;
            C2811j1 c2811j1M3277a = bVarM3275a.m3277a();
            this.f8908a = c2811j1M3277a;
            this.f8910c.mo2526e(c2811j1M3277a);
        }
        int iM3081a = c2757x.m3081a();
        this.f8910c.mo2524c(c2757x, iM3081a);
        this.f8910c.mo2525d(jM2974c, 1, iM3081a, 0, null);
    }
}
