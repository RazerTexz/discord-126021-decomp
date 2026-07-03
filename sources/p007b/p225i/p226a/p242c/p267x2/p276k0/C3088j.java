package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3006d;
import p007b.p225i.p226a.p242c.p267x2.C3069k;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.j */
/* JADX INFO: compiled from: AdtsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3088j implements InterfaceC3031h {

    /* JADX INFO: renamed from: a */
    public final int f8685a;

    /* JADX INFO: renamed from: b */
    public final C3090k f8686b;

    /* JADX INFO: renamed from: c */
    public final C2757x f8687c;

    /* JADX INFO: renamed from: d */
    public final C2757x f8688d;

    /* JADX INFO: renamed from: e */
    public final C2756w f8689e;

    /* JADX INFO: renamed from: f */
    public InterfaceC3058j f8690f;

    /* JADX INFO: renamed from: g */
    public long f8691g;

    /* JADX INFO: renamed from: h */
    public long f8692h;

    /* JADX INFO: renamed from: i */
    public int f8693i;

    /* JADX INFO: renamed from: j */
    public boolean f8694j;

    /* JADX INFO: renamed from: k */
    public boolean f8695k;

    /* JADX INFO: renamed from: l */
    public boolean f8696l;

    static {
        C3074c c3074c = new InterfaceC3106l() { // from class: b.i.a.c.x2.k0.c
            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: a */
            public final InterfaceC3031h[] mo3630a() {
                return new InterfaceC3031h[]{new C3088j(0)};
            }

            @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l
            /* JADX INFO: renamed from: b */
            public /* synthetic */ InterfaceC3031h[] mo3631b(Uri uri, Map map) {
                return C3069k.m3748a(this, uri, map);
            }
        };
    }

    public C3088j(int i) {
        this.f8685a = (i & 2) != 0 ? i | 1 : i;
        this.f8686b = new C3090k(true, null);
        this.f8687c = new C2757x(2048);
        this.f8693i = -1;
        this.f8692h = -1L;
        C2757x c2757x = new C2757x(10);
        this.f8688d = c2757x;
        this.f8689e = new C2756w(c2757x.f6793a);
    }

    /* JADX INFO: renamed from: a */
    public final int m3768a(InterfaceC3041i interfaceC3041i) throws IOException {
        int i = 0;
        while (true) {
            interfaceC3041i.mo3652o(this.f8688d.f6793a, 0, 10);
            this.f8688d.m3079E(0);
            if (this.f8688d.m3102v() != 4801587) {
                break;
            }
            this.f8688d.m3080F(3);
            int iM3099s = this.f8688d.m3099s();
            i += iM3099s + 10;
            interfaceC3041i.mo3646g(iM3099s);
        }
        interfaceC3041i.mo3649k();
        interfaceC3041i.mo3646g(i);
        if (this.f8692h == -1) {
            this.f8692h = i;
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(InterfaceC3041i interfaceC3041i) throws IOException {
        int iM3768a = m3768a(interfaceC3041i);
        int i = iM3768a;
        int i2 = 0;
        int i3 = 0;
        do {
            interfaceC3041i.mo3652o(this.f8688d.f6793a, 0, 2);
            this.f8688d.m3079E(0);
            if (C3090k.m3771g(this.f8688d.m3105y())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                interfaceC3041i.mo3652o(this.f8688d.f6793a, 0, 4);
                this.f8689e.m3071k(14);
                int iM3067g = this.f8689e.m3067g(13);
                if (iM3067g <= 6) {
                    i++;
                    interfaceC3041i.mo3649k();
                    interfaceC3041i.mo3646g(i);
                } else {
                    interfaceC3041i.mo3646g(iM3067g - 6);
                    i3 += iM3067g;
                }
            } else {
                i++;
                interfaceC3041i.mo3649k();
                interfaceC3041i.mo3646g(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - iM3768a < 8192);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0108  */
    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: e */
    public int mo3635e(InterfaceC3041i interfaceC3041i, C3118s c3118s) throws IOException {
        int iM3067g;
        C1460d.m438H(this.f8690f);
        long jMo3642b = interfaceC3041i.mo3642b();
        int i = this.f8685a;
        if ((((i & 2) == 0 && ((i & 1) == 0 || jMo3642b == -1)) ? false : true) && !this.f8694j) {
            this.f8693i = -1;
            interfaceC3041i.mo3649k();
            if (interfaceC3041i.getPosition() == 0) {
                m3768a(interfaceC3041i);
            }
            long j = 0;
            int i2 = 0;
            do {
                try {
                    if (!interfaceC3041i.mo3644e(this.f8688d.f6793a, 0, 2, true)) {
                        break;
                    }
                    this.f8688d.m3079E(0);
                    if (!C3090k.m3771g(this.f8688d.m3105y())) {
                        i2 = 0;
                        break;
                    }
                    if (!interfaceC3041i.mo3644e(this.f8688d.f6793a, 0, 4, true)) {
                        break;
                    }
                    this.f8689e.m3071k(14);
                    iM3067g = this.f8689e.m3067g(13);
                    if (iM3067g <= 6) {
                        this.f8694j = true;
                        throw ParserException.m8755a("Malformed ADTS stream", null);
                    }
                    j += (long) iM3067g;
                    i2++;
                    if (i2 == 1000) {
                        break;
                    }
                } catch (EOFException unused) {
                }
            } while (interfaceC3041i.mo3651m(iM3067g - 6, true));
            interfaceC3041i.mo3649k();
            if (i2 > 0) {
                this.f8693i = (int) (j / ((long) i2));
            } else {
                this.f8693i = -1;
            }
            this.f8694j = true;
        }
        int i3 = interfaceC3041i.read(this.f8687c.f6793a, 0, 2048);
        boolean z2 = i3 == -1;
        if (!this.f8696l) {
            int i4 = this.f8685a;
            boolean z3 = (i4 & 1) != 0 && this.f8693i > 0;
            if (!z3 || this.f8686b.f8716r != -9223372036854775807L || z2) {
                if (z3) {
                    long j2 = this.f8686b.f8716r;
                    if (j2 != -9223372036854775807L) {
                        InterfaceC3058j interfaceC3058j = this.f8690f;
                        boolean z4 = (2 & i4) != 0;
                        int i5 = this.f8693i;
                        interfaceC3058j.mo2477a(new C3006d(jMo3642b, this.f8692h, (int) ((((long) (i5 * 8)) * 1000000) / j2), i5, z4));
                    } else {
                        this.f8690f.mo2477a(new InterfaceC3119t.b(-9223372036854775807L, 0L));
                    }
                } else {
                    this.f8690f.mo2477a(new InterfaceC3119t.b(-9223372036854775807L, 0L));
                }
                this.f8696l = true;
            }
        }
        if (z2) {
            return -1;
        }
        this.f8687c.m3079E(0);
        this.f8687c.m3078D(i3);
        if (!this.f8695k) {
            this.f8686b.mo3762f(this.f8691g, 4);
            this.f8695k = true;
        }
        this.f8686b.mo3758b(this.f8687c);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: f */
    public void mo3636f(InterfaceC3058j interfaceC3058j) {
        this.f8690f = interfaceC3058j;
        this.f8686b.mo3761e(interfaceC3058j, new InterfaceC3087i0.d(Integer.MIN_VALUE, 0, 1));
        interfaceC3058j.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        this.f8695k = false;
        this.f8686b.mo3759c();
        this.f8691g = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h
    public void release() {
    }
}
