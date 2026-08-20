package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2930n;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.i */
/* JADX INFO: compiled from: Ac4Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3086i implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    public final C2756w f8661a;

    /* JADX INFO: renamed from: b */
    public final C2757x f8662b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f8663c;

    /* JADX INFO: renamed from: d */
    public String f8664d;

    /* JADX INFO: renamed from: e */
    public InterfaceC3122w f8665e;

    /* JADX INFO: renamed from: f */
    public int f8666f;

    /* JADX INFO: renamed from: g */
    public int f8667g;

    /* JADX INFO: renamed from: h */
    public boolean f8668h;

    /* JADX INFO: renamed from: i */
    public boolean f8669i;

    /* JADX INFO: renamed from: j */
    public long f8670j;

    /* JADX INFO: renamed from: k */
    public C2811j1 f8671k;

    /* JADX INFO: renamed from: l */
    public int f8672l;

    /* JADX INFO: renamed from: m */
    public long f8673m;

    public C3086i(@Nullable String str) {
        C2756w c2756w = new C2756w(new byte[16]);
        this.f8661a = c2756w;
        this.f8662b = new C2757x(c2756w.f6789a);
        this.f8666f = 0;
        this.f8667g = 0;
        this.f8668h = false;
        this.f8669i = false;
        this.f8673m = -9223372036854775807L;
        this.f8663c = str;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
        boolean z2;
        C1460d.m438H(this.f8665e);
        while (c2757x.m3081a() > 0) {
            int i = this.f8666f;
            if (i == 0) {
                while (true) {
                    if (c2757x.m3081a() <= 0) {
                        z2 = false;
                        break;
                    }
                    if (this.f8668h) {
                        int iM3100t = c2757x.m3100t();
                        this.f8668h = iM3100t == 172;
                        if (iM3100t == 64 || iM3100t == 65) {
                            this.f8669i = iM3100t == 65;
                            z2 = true;
                            break;
                        }
                    } else {
                        this.f8668h = c2757x.m3100t() == 172;
                    }
                }
                if (z2) {
                    this.f8666f = 1;
                    byte[] bArr = this.f8662b.f6793a;
                    bArr[0] = -84;
                    bArr[1] = (byte) (this.f8669i ? 65 : 64);
                    this.f8667g = 2;
                }
            } else if (i == 1) {
                byte[] bArr2 = this.f8662b.f6793a;
                int iMin = Math.min(c2757x.m3081a(), 16 - this.f8667g);
                System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr2, this.f8667g, iMin);
                c2757x.f6794b += iMin;
                int i2 = this.f8667g + iMin;
                this.f8667g = i2;
                if (i2 == 16) {
                    this.f8661a.m3071k(0);
                    C2930n.b bVarM3493b = C2930n.m3493b(this.f8661a);
                    C2811j1 c2811j1 = this.f8671k;
                    if (c2811j1 == null || 2 != c2811j1.f7136J || bVarM3493b.f7776a != c2811j1.f7137K || !"audio/ac4".equals(c2811j1.f7155w)) {
                        C2811j1.b bVar = new C2811j1.b();
                        bVar.f7163a = this.f8664d;
                        bVar.f7173k = "audio/ac4";
                        bVar.f7186x = 2;
                        bVar.f7187y = bVarM3493b.f7776a;
                        bVar.f7165c = this.f8663c;
                        C2811j1 c2811j1M3277a = bVar.m3277a();
                        this.f8671k = c2811j1M3277a;
                        this.f8665e.mo2526e(c2811j1M3277a);
                    }
                    this.f8672l = bVarM3493b.f7777b;
                    this.f8670j = (((long) bVarM3493b.f7778c) * 1000000) / ((long) this.f8671k.f7137K);
                    this.f8662b.m3079E(0);
                    this.f8665e.mo2524c(this.f8662b, 16);
                    this.f8666f = 2;
                }
            } else if (i == 2) {
                int iMin2 = Math.min(c2757x.m3081a(), this.f8672l - this.f8667g);
                this.f8665e.mo2524c(c2757x, iMin2);
                int i3 = this.f8667g + iMin2;
                this.f8667g = i3;
                int i4 = this.f8672l;
                if (i3 == i4) {
                    long j = this.f8673m;
                    if (j != -9223372036854775807L) {
                        this.f8665e.mo2525d(j, 1, i4, 0, null);
                        this.f8673m += this.f8670j;
                    }
                    this.f8666f = 0;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8666f = 0;
        this.f8667g = 0;
        this.f8668h = false;
        this.f8669i = false;
        this.f8673m = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        this.f8664d = dVar.m3766b();
        this.f8665e = interfaceC3058j.mo2492p(dVar.m3767c(), 1);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8673m = j;
        }
    }
}
