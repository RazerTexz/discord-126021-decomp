package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.Collections;
import java.util.List;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.n */
/* JADX INFO: compiled from: DvbSubtitleReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3093n implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    public final List<InterfaceC3087i0.a> f8734a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC3122w[] f8735b;

    /* JADX INFO: renamed from: c */
    public boolean f8736c;

    /* JADX INFO: renamed from: d */
    public int f8737d;

    /* JADX INFO: renamed from: e */
    public int f8738e;

    /* JADX INFO: renamed from: f */
    public long f8739f = -9223372036854775807L;

    public C3093n(List<InterfaceC3087i0.a> list) {
        this.f8734a = list;
        this.f8735b = new InterfaceC3122w[list.size()];
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3778a(C2757x c2757x, int i) {
        if (c2757x.m3081a() == 0) {
            return false;
        }
        if (c2757x.m3100t() != i) {
            this.f8736c = false;
        }
        this.f8737d--;
        return this.f8736c;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
        if (this.f8736c) {
            if (this.f8737d != 2 || m3778a(c2757x, 32)) {
                if (this.f8737d != 1 || m3778a(c2757x, 0)) {
                    int i = c2757x.f6794b;
                    int iM3081a = c2757x.m3081a();
                    for (InterfaceC3122w interfaceC3122w : this.f8735b) {
                        c2757x.m3079E(i);
                        interfaceC3122w.mo2524c(c2757x, iM3081a);
                    }
                    this.f8738e += iM3081a;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8736c = false;
        this.f8739f = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
        if (this.f8736c) {
            if (this.f8739f != -9223372036854775807L) {
                for (InterfaceC3122w interfaceC3122w : this.f8735b) {
                    interfaceC3122w.mo2525d(this.f8739f, 1, this.f8738e, 0, null);
                }
            }
            this.f8736c = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        for (int i = 0; i < this.f8735b.length; i++) {
            InterfaceC3087i0.a aVar = this.f8734a.get(i);
            dVar.m3765a();
            InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 3);
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7163a = dVar.m3766b();
            bVar.f7173k = "application/dvbsubs";
            bVar.f7175m = Collections.singletonList(aVar.f8675b);
            bVar.f7165c = aVar.f8674a;
            interfaceC3122wMo2492p.mo2526e(bVar.m3277a());
            this.f8735b[i] = interfaceC3122wMo2492p;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f8736c = true;
        if (j != -9223372036854775807L) {
            this.f8739f = j;
        }
        this.f8738e = 0;
        this.f8737d = 2;
    }
}
