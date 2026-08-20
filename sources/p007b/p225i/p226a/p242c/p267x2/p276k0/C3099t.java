package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.t */
/* JADX INFO: compiled from: Id3Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3099t implements InterfaceC3094o {

    /* JADX INFO: renamed from: b */
    public InterfaceC3122w f8865b;

    /* JADX INFO: renamed from: c */
    public boolean f8866c;

    /* JADX INFO: renamed from: e */
    public int f8868e;

    /* JADX INFO: renamed from: f */
    public int f8869f;

    /* JADX INFO: renamed from: a */
    public final C2757x f8864a = new C2757x(10);

    /* JADX INFO: renamed from: d */
    public long f8867d = -9223372036854775807L;

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
        C1460d.m438H(this.f8865b);
        if (this.f8866c) {
            int iM3081a = c2757x.m3081a();
            int i = this.f8869f;
            if (i < 10) {
                int iMin = Math.min(iM3081a, 10 - i);
                System.arraycopy(c2757x.f6793a, c2757x.f6794b, this.f8864a.f6793a, this.f8869f, iMin);
                if (this.f8869f + iMin == 10) {
                    this.f8864a.m3079E(0);
                    if (73 != this.f8864a.m3100t() || 68 != this.f8864a.m3100t() || 51 != this.f8864a.m3100t()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f8866c = false;
                        return;
                    } else {
                        this.f8864a.m3080F(3);
                        this.f8868e = this.f8864a.m3099s() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iM3081a, this.f8868e - this.f8869f);
            this.f8865b.mo2524c(c2757x, iMin2);
            this.f8869f += iMin2;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8866c = false;
        this.f8867d = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
        int i;
        C1460d.m438H(this.f8865b);
        if (this.f8866c && (i = this.f8868e) != 0 && this.f8869f == i) {
            long j = this.f8867d;
            if (j != -9223372036854775807L) {
                this.f8865b.mo2525d(j, 1, i, 0, null);
            }
            this.f8866c = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 5);
        this.f8865b = interfaceC3122wMo2492p;
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7163a = dVar.m3766b();
        bVar.f7173k = "application/id3";
        interfaceC3122wMo2492p.mo2526e(bVar.m3277a());
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f8866c = true;
        if (j != -9223372036854775807L) {
            this.f8867d = j;
        }
        this.f8868e = 0;
        this.f8869f = 0;
    }
}
