package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.e0 */
/* JADX INFO: compiled from: SeiReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3079e0 {

    /* JADX INFO: renamed from: a */
    public final List<C2811j1> f8602a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC3122w[] f8603b;

    public C3079e0(List<C2811j1> list) {
        this.f8602a = list;
        this.f8603b = new InterfaceC3122w[list.size()];
    }

    /* JADX INFO: renamed from: a */
    public void m3757a(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        for (int i = 0; i < this.f8603b.length; i++) {
            dVar.m3765a();
            InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 3);
            C2811j1 c2811j1 = this.f8602a.get(i);
            String str = c2811j1.f7155w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            C1460d.m543m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            String strM3766b = c2811j1.f7144l;
            if (strM3766b == null) {
                strM3766b = dVar.m3766b();
            }
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7163a = strM3766b;
            bVar.f7173k = str;
            bVar.f7166d = c2811j1.f7147o;
            bVar.f7165c = c2811j1.f7146n;
            bVar.f7161C = c2811j1.f7141O;
            bVar.f7175m = c2811j1.f7157y;
            interfaceC3122wMo2492p.mo2526e(bVar.m3277a());
            this.f8603b[i] = interfaceC3122wMo2492p;
        }
    }
}
