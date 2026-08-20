package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.j0 */
/* JADX INFO: compiled from: UserDataReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3089j0 {

    /* JADX INFO: renamed from: a */
    public final List<C2811j1> f8697a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC3122w[] f8698b;

    public C3089j0(List<C2811j1> list) {
        this.f8697a = list;
        this.f8698b = new InterfaceC3122w[list.size()];
    }

    /* JADX INFO: renamed from: a */
    public void m3769a(long j, C2757x c2757x) {
        if (c2757x.m3081a() < 9) {
            return;
        }
        int iM3086f = c2757x.m3086f();
        int iM3086f2 = c2757x.m3086f();
        int iM3100t = c2757x.m3100t();
        if (iM3086f == 434 && iM3086f2 == 1195456820 && iM3100t == 3) {
            C1460d.m447K(j, c2757x, this.f8698b);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3770b(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        for (int i = 0; i < this.f8698b.length; i++) {
            dVar.m3765a();
            InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 3);
            C2811j1 c2811j1 = this.f8697a.get(i);
            String str = c2811j1.f7155w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            C1460d.m543m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7163a = dVar.m3766b();
            bVar.f7173k = str;
            bVar.f7166d = c2811j1.f7147o;
            bVar.f7165c = c2811j1.f7146n;
            bVar.f7161C = c2811j1.f7141O;
            bVar.f7175m = c2811j1.f7157y;
            interfaceC3122wMo2492p.mo2526e(bVar.m3277a());
            this.f8698b[i] = interfaceC3122wMo2492p;
        }
    }
}
