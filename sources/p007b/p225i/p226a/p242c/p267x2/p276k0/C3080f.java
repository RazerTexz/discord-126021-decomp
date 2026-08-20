package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2929m;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.f */
/* JADX INFO: compiled from: Ac3Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3080f implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public final C3082g f8604a = new C3082g(null);

    /* JADX INFO: renamed from: b */
    public final C2757x f8605b = new C2757x(2786);

    /* JADX INFO: renamed from: c */
    public boolean f8606c;

    static {
        C3070a c3070a = new InterfaceC3106l() { // from class: b.i.a.c.x2.k0.a
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3080f()};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        int iM3491a;
        C2757x c2757x = new C2757x(10);
        int i = 0;
        while (true) {
            interfaceC3041i.mo3652o(c2757x.f6793a, 0, 10);
            c2757x.m3079E(0);
            if (c2757x.m3102v() != 4801587) {
                break;
            }
            c2757x.m3080F(3);
            int iM3099s = c2757x.m3099s();
            i += iM3099s + 10;
            interfaceC3041i.mo3646g(iM3099s);
        }
        interfaceC3041i.mo3649k();
        interfaceC3041i.mo3646g(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                interfaceC3041i.mo3652o(c2757x.f6793a, 0, 6);
                c2757x.m3079E(0);
                if (c2757x.m3105y() != 2935) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = c2757x.f6793a;
                if (bArr.length < 6) {
                    iM3491a = -1;
                } else {
                    iM3491a = ((bArr[5] & 248) >> 3) > 10 ? ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2 : C2929m.m3491a((bArr[4] & 192) >> 6, bArr[4] & 63);
                }
                if (iM3491a == -1) {
                    return false;
                }
                interfaceC3041i.mo3646g(iM3491a - 6);
            }
            interfaceC3041i.mo3649k();
            i2++;
            if (i2 - i >= 8192) {
                return false;
            }
            interfaceC3041i.mo3646g(i2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        int i = interfaceC3041i.read(this.f8605b.f6793a, 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.f8605b.m3079E(0);
        this.f8605b.m3078D(i);
        if (!this.f8606c) {
            this.f8604a.mo3762f(0L, 4);
            this.f8606c = true;
        }
        this.f8604a.mo3758b(this.f8605b);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8604a.mo3761e(interfaceC3058j, new InterfaceC3087i0.d(Integer.MIN_VALUE, 0, 1));
        interfaceC3058j.mo2486j();
        interfaceC3058j.mo2477a(new InterfaceC3119t.b(-9223372036854775807L, 0L));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8606c = false;
        this.f8604a.mo3759c();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
