package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.h */
/* JADX INFO: compiled from: Ac4Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3084h implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public final C3086i f8632a = new C3086i(null);

    /* JADX INFO: renamed from: b */
    public final C2757x f8633b = new C2757x(16384);

    /* JADX INFO: renamed from: c */
    public boolean f8634c;

    static {
        C3072b c3072b = new InterfaceC3106l() { // from class: b.i.a.c.x2.k0.b
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3084h()};
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
        int i;
        C2757x c2757x = new C2757x(10);
        int i2 = 0;
        while (true) {
            interfaceC3041i.mo3652o(c2757x.f6793a, 0, 10);
            c2757x.m3079E(0);
            if (c2757x.m3102v() != 4801587) {
                break;
            }
            c2757x.m3080F(3);
            int iM3099s = c2757x.m3099s();
            i2 += iM3099s + 10;
            interfaceC3041i.mo3646g(iM3099s);
        }
        interfaceC3041i.mo3649k();
        interfaceC3041i.mo3646g(i2);
        int i3 = i2;
        while (true) {
            int i4 = 0;
            while (true) {
                int i5 = 7;
                interfaceC3041i.mo3652o(c2757x.f6793a, 0, 7);
                c2757x.m3079E(0);
                int iM3105y = c2757x.m3105y();
                if (iM3105y == 44096 || iM3105y == 44097) {
                    i4++;
                    if (i4 >= 4) {
                        return true;
                    }
                    byte[] bArr = c2757x.f6793a;
                    if (bArr.length < 7) {
                        i = -1;
                    } else {
                        int i6 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                        if (i6 == 65535) {
                            i6 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                        } else {
                            i5 = 4;
                        }
                        if (iM3105y == 44097) {
                            i5 += 2;
                        }
                        i = i6 + i5;
                    }
                    if (i == -1) {
                        return false;
                    }
                    interfaceC3041i.mo3646g(i - 7);
                }
            }
            interfaceC3041i.mo3649k();
            i3++;
            if (i3 - i2 >= 8192) {
                return false;
            }
            interfaceC3041i.mo3646g(i3);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        int i = interfaceC3041i.read(this.f8633b.f6793a, 0, 16384);
        if (i == -1) {
            return -1;
        }
        this.f8633b.m3079E(0);
        this.f8633b.m3078D(i);
        if (!this.f8634c) {
            this.f8632a.mo3762f(0L, 4);
            this.f8634c = true;
        }
        this.f8632a.mo3758b(this.f8633b);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8632a.mo3761e(interfaceC3058j, new InterfaceC3087i0.d(Integer.MIN_VALUE, 0, 1));
        interfaceC3058j.mo2486j();
        interfaceC3058j.mo2477a(new InterfaceC3119t.b(-9223372036854775807L, 0L));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8634c = false;
        this.f8632a.mo3759c();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
