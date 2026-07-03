package p007b.p225i.p226a.p242c.p267x2.p276k0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2928l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.u */
/* JADX INFO: compiled from: LatmReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3100u implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final String f8870a;

    /* JADX INFO: renamed from: b */
    public final C2757x f8871b;

    /* JADX INFO: renamed from: c */
    public final C2756w f8872c;

    /* JADX INFO: renamed from: d */
    public InterfaceC3122w f8873d;

    /* JADX INFO: renamed from: e */
    public String f8874e;

    /* JADX INFO: renamed from: f */
    public C2811j1 f8875f;

    /* JADX INFO: renamed from: g */
    public int f8876g;

    /* JADX INFO: renamed from: h */
    public int f8877h;

    /* JADX INFO: renamed from: i */
    public int f8878i;

    /* JADX INFO: renamed from: j */
    public int f8879j;

    /* JADX INFO: renamed from: k */
    public long f8880k;

    /* JADX INFO: renamed from: l */
    public boolean f8881l;

    /* JADX INFO: renamed from: m */
    public int f8882m;

    /* JADX INFO: renamed from: n */
    public int f8883n;

    /* JADX INFO: renamed from: o */
    public int f8884o;

    /* JADX INFO: renamed from: p */
    public boolean f8885p;

    /* JADX INFO: renamed from: q */
    public long f8886q;

    /* JADX INFO: renamed from: r */
    public int f8887r;

    /* JADX INFO: renamed from: s */
    public long f8888s;

    /* JADX INFO: renamed from: t */
    public int f8889t;

    /* JADX INFO: renamed from: u */
    @Nullable
    public String f8890u;

    public C3100u(@Nullable String str) {
        this.f8870a = str;
        C2757x c2757x = new C2757x(1024);
        this.f8871b = c2757x;
        this.f8872c = new C2756w(c2757x.f6793a);
        this.f8880k = -9223372036854775807L;
    }

    /* JADX INFO: renamed from: a */
    public static long m3786a(C2756w c2756w) {
        return c2756w.m3067g((c2756w.m3067g(2) + 1) * 8);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) throws ParserException {
        int i;
        boolean zM3066f;
        C1460d.m438H(this.f8873d);
        while (c2757x.m3081a() > 0) {
            int i2 = this.f8876g;
            if (i2 != 0) {
                if (i2 == 1) {
                    int iM3100t = c2757x.m3100t();
                    if ((iM3100t & 224) == 224) {
                        this.f8879j = iM3100t;
                        this.f8876g = 2;
                    } else if (iM3100t != 86) {
                        this.f8876g = 0;
                    }
                } else if (i2 == 2) {
                    int iM3100t2 = ((this.f8879j & (-225)) << 8) | c2757x.m3100t();
                    this.f8878i = iM3100t2;
                    C2757x c2757x2 = this.f8871b;
                    byte[] bArr = c2757x2.f6793a;
                    if (iM3100t2 > bArr.length) {
                        if (bArr.length < iM3100t2) {
                            bArr = new byte[iM3100t2];
                        }
                        c2757x2.m3077C(bArr, iM3100t2);
                        C2756w c2756w = this.f8872c;
                        byte[] bArr2 = this.f8871b.f6793a;
                        Objects.requireNonNull(c2756w);
                        int length = bArr2.length;
                        c2756w.f6789a = bArr2;
                        c2756w.f6790b = 0;
                        c2756w.f6791c = 0;
                        c2756w.f6792d = length;
                    }
                    this.f8877h = 0;
                    this.f8876g = 3;
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(c2757x.m3081a(), this.f8878i - this.f8877h);
                    c2757x.m3085e(this.f8872c.f6789a, this.f8877h, iMin);
                    int i3 = this.f8877h + iMin;
                    this.f8877h = i3;
                    if (i3 == this.f8878i) {
                        this.f8872c.m3071k(0);
                        C2756w c2756w2 = this.f8872c;
                        if (c2756w2.m3066f()) {
                            if (this.f8881l) {
                            }
                            this.f8876g = 0;
                        } else {
                            this.f8881l = true;
                            int iM3067g = c2756w2.m3067g(1);
                            int iM3067g2 = iM3067g == 1 ? c2756w2.m3067g(1) : 0;
                            this.f8882m = iM3067g2;
                            if (iM3067g2 != 0) {
                                throw ParserException.m8755a(null, null);
                            }
                            if (iM3067g == 1) {
                                m3786a(c2756w2);
                            }
                            if (!c2756w2.m3066f()) {
                                throw ParserException.m8755a(null, null);
                            }
                            this.f8883n = c2756w2.m3067g(6);
                            int iM3067g3 = c2756w2.m3067g(4);
                            int iM3067g4 = c2756w2.m3067g(3);
                            if (iM3067g3 != 0 || iM3067g4 != 0) {
                                throw ParserException.m8755a(null, null);
                            }
                            if (iM3067g == 0) {
                                int iM3065e = c2756w2.m3065e();
                                int iM3787g = m3787g(c2756w2);
                                c2756w2.m3071k(iM3065e);
                                byte[] bArr3 = new byte[(iM3787g + 7) / 8];
                                c2756w2.m3068h(bArr3, 0, iM3787g);
                                C2811j1.b bVar = new C2811j1.b();
                                bVar.f7163a = this.f8874e;
                                bVar.f7173k = "audio/mp4a-latm";
                                bVar.f7170h = this.f8890u;
                                bVar.f7186x = this.f8889t;
                                bVar.f7187y = this.f8887r;
                                bVar.f7175m = Collections.singletonList(bArr3);
                                bVar.f7165c = this.f8870a;
                                C2811j1 c2811j1M3277a = bVar.m3277a();
                                if (!c2811j1M3277a.equals(this.f8875f)) {
                                    this.f8875f = c2811j1M3277a;
                                    this.f8888s = 1024000000 / ((long) c2811j1M3277a.f7137K);
                                    this.f8873d.mo2526e(c2811j1M3277a);
                                }
                            } else {
                                c2756w2.m3073m(((int) m3786a(c2756w2)) - m3787g(c2756w2));
                            }
                            int iM3067g5 = c2756w2.m3067g(3);
                            this.f8884o = iM3067g5;
                            if (iM3067g5 == 0) {
                                c2756w2.m3073m(8);
                            } else if (iM3067g5 == 1) {
                                c2756w2.m3073m(9);
                            } else if (iM3067g5 == 3 || iM3067g5 == 4 || iM3067g5 == 5) {
                                c2756w2.m3073m(6);
                            } else {
                                if (iM3067g5 != 6 && iM3067g5 != 7) {
                                    throw new IllegalStateException();
                                }
                                c2756w2.m3073m(1);
                            }
                            boolean zM3066f2 = c2756w2.m3066f();
                            this.f8885p = zM3066f2;
                            this.f8886q = 0L;
                            if (zM3066f2) {
                                if (iM3067g == 1) {
                                    this.f8886q = m3786a(c2756w2);
                                } else {
                                    do {
                                        zM3066f = c2756w2.m3066f();
                                        this.f8886q = (this.f8886q << 8) + ((long) c2756w2.m3067g(8));
                                    } while (zM3066f);
                                }
                            }
                            if (c2756w2.m3066f()) {
                                c2756w2.m3073m(8);
                            }
                        }
                        if (this.f8882m != 0) {
                            throw ParserException.m8755a(null, null);
                        }
                        if (this.f8883n != 0) {
                            throw ParserException.m8755a(null, null);
                        }
                        if (this.f8884o != 0) {
                            throw ParserException.m8755a(null, null);
                        }
                        int i4 = 0;
                        while (true) {
                            int iM3067g6 = c2756w2.m3067g(8);
                            i = i4 + iM3067g6;
                            if (iM3067g6 != 255) {
                                break;
                            } else {
                                i4 = i;
                            }
                        }
                        int iM3065e2 = c2756w2.m3065e();
                        if ((iM3065e2 & 7) == 0) {
                            this.f8871b.m3079E(iM3065e2 >> 3);
                        } else {
                            c2756w2.m3068h(this.f8871b.f6793a, 0, i * 8);
                            this.f8871b.m3079E(0);
                        }
                        this.f8873d.mo2524c(this.f8871b, i);
                        long j = this.f8880k;
                        if (j != -9223372036854775807L) {
                            this.f8873d.mo2525d(j, 1, i, 0, null);
                            this.f8880k += this.f8888s;
                        }
                        if (this.f8885p) {
                            c2756w2.m3073m((int) this.f8886q);
                        }
                        this.f8876g = 0;
                    } else {
                        continue;
                    }
                }
            } else if (c2757x.m3100t() == 86) {
                this.f8876g = 1;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8876g = 0;
        this.f8880k = -9223372036854775807L;
        this.f8881l = false;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        this.f8873d = interfaceC3058j.mo2492p(dVar.m3767c(), 1);
        this.f8874e = dVar.m3766b();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8880k = j;
        }
    }

    /* JADX INFO: renamed from: g */
    public final int m3787g(C2756w c2756w) throws ParserException {
        int iM3062b = c2756w.m3062b();
        C2928l.b bVarM3489b = C2928l.m3489b(c2756w, true);
        this.f8890u = bVarM3489b.f7768c;
        this.f8887r = bVarM3489b.f7766a;
        this.f8889t = bVarM3489b.f7767b;
        return iM3062b - c2756w.m3062b();
    }
}
