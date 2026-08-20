package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2736d0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.y */
/* JADX INFO: compiled from: PesReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3104y implements InterfaceC3087i0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC3094o f8911a;

    /* JADX INFO: renamed from: b */
    public final C2756w f8912b = new C2756w(new byte[10]);

    /* JADX INFO: renamed from: c */
    public int f8913c = 0;

    /* JADX INFO: renamed from: d */
    public int f8914d;

    /* JADX INFO: renamed from: e */
    public C2736d0 f8915e;

    /* JADX INFO: renamed from: f */
    public boolean f8916f;

    /* JADX INFO: renamed from: g */
    public boolean f8917g;

    /* JADX INFO: renamed from: h */
    public boolean f8918h;

    /* JADX INFO: renamed from: i */
    public int f8919i;

    /* JADX INFO: renamed from: j */
    public int f8920j;

    /* JADX INFO: renamed from: k */
    public boolean f8921k;

    /* JADX INFO: renamed from: l */
    public long f8922l;

    public C3104y(InterfaceC3094o interfaceC3094o) {
        this.f8911a = interfaceC3094o;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0
    /* JADX INFO: renamed from: a */
    public void mo3754a(C2736d0 c2736d0, InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        this.f8915e = c2736d0;
        this.f8911a.mo3761e(interfaceC3058j, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0
    /* JADX INFO: renamed from: b */
    public final void mo3755b(C2757x c2757x, int i) throws ParserException {
        boolean z2;
        C1460d.m438H(this.f8915e);
        int i2 = -1;
        int i3 = 3;
        if ((i & 1) != 0) {
            int i4 = this.f8913c;
            if (i4 != 0 && i4 != 1) {
                if (i4 == 2) {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i4 != 3) {
                        throw new IllegalStateException();
                    }
                    int i5 = this.f8920j;
                    if (i5 != -1) {
                        StringBuilder sb = new StringBuilder(59);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i5);
                        sb.append(" more bytes");
                        Log.w("PesReader", sb.toString());
                    }
                    this.f8911a.mo3760d();
                }
            }
            m3793e(1);
        }
        while (c2757x.m3081a() > 0) {
            int i6 = this.f8913c;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        if (m3792d(c2757x, this.f8912b.f6789a, Math.min(10, this.f8919i)) && m3792d(c2757x, null, this.f8919i)) {
                            this.f8912b.m3071k(0);
                            this.f8922l = -9223372036854775807L;
                            if (this.f8916f) {
                                this.f8912b.m3073m(4);
                                long jM3067g = ((long) this.f8912b.m3067g(i3)) << 30;
                                this.f8912b.m3073m(1);
                                long jM3067g2 = jM3067g | ((long) (this.f8912b.m3067g(15) << 15));
                                this.f8912b.m3073m(1);
                                long jM3067g3 = jM3067g2 | ((long) this.f8912b.m3067g(15));
                                this.f8912b.m3073m(1);
                                if (!this.f8918h && this.f8917g) {
                                    this.f8912b.m3073m(4);
                                    long jM3067g4 = ((long) this.f8912b.m3067g(i3)) << 30;
                                    this.f8912b.m3073m(1);
                                    long jM3067g5 = jM3067g4 | ((long) (this.f8912b.m3067g(15) << 15));
                                    this.f8912b.m3073m(1);
                                    long jM3067g6 = jM3067g5 | ((long) this.f8912b.m3067g(15));
                                    this.f8912b.m3073m(1);
                                    this.f8915e.m2973b(jM3067g6);
                                    this.f8918h = true;
                                }
                                this.f8922l = this.f8915e.m2973b(jM3067g3);
                            }
                            i |= this.f8921k ? 4 : 0;
                            this.f8911a.mo3762f(this.f8922l, i);
                            m3793e(3);
                        }
                    } else {
                        if (i6 != i3) {
                            throw new IllegalStateException();
                        }
                        int iM3081a = c2757x.m3081a();
                        int i7 = this.f8920j;
                        int i8 = i7 != i2 ? iM3081a - i7 : 0;
                        if (i8 > 0) {
                            iM3081a -= i8;
                            c2757x.m3078D(c2757x.f6794b + iM3081a);
                        }
                        this.f8911a.mo3758b(c2757x);
                        int i9 = this.f8920j;
                        if (i9 != i2) {
                            int i10 = i9 - iM3081a;
                            this.f8920j = i10;
                            if (i10 == 0) {
                                this.f8911a.mo3760d();
                                m3793e(1);
                            }
                        }
                    }
                } else if (m3792d(c2757x, this.f8912b.f6789a, 9)) {
                    this.f8912b.m3071k(0);
                    int iM3067g = this.f8912b.m3067g(24);
                    if (iM3067g != 1) {
                        C1643a.m852g0(41, "Unexpected start code prefix: ", iM3067g, "PesReader");
                        this.f8920j = -1;
                        z2 = false;
                    } else {
                        this.f8912b.m3073m(8);
                        int iM3067g2 = this.f8912b.m3067g(16);
                        this.f8912b.m3073m(5);
                        this.f8921k = this.f8912b.m3066f();
                        this.f8912b.m3073m(2);
                        this.f8916f = this.f8912b.m3066f();
                        this.f8917g = this.f8912b.m3066f();
                        this.f8912b.m3073m(6);
                        int iM3067g3 = this.f8912b.m3067g(8);
                        this.f8919i = iM3067g3;
                        if (iM3067g2 == 0) {
                            this.f8920j = -1;
                        } else {
                            int i11 = ((iM3067g2 + 6) - 9) - iM3067g3;
                            this.f8920j = i11;
                            if (i11 < 0) {
                                C1643a.m852g0(47, "Found negative packet payload size: ", i11, "PesReader");
                                this.f8920j = -1;
                            }
                        }
                        z2 = true;
                    }
                    m3793e(z2 ? 2 : 0);
                }
            } else {
                c2757x.m3080F(c2757x.m3081a());
            }
            i2 = -1;
            i3 = 3;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0
    /* JADX INFO: renamed from: c */
    public final void mo3756c() {
        this.f8913c = 0;
        this.f8914d = 0;
        this.f8918h = false;
        this.f8911a.mo3759c();
    }

    /* JADX INFO: renamed from: d */
    public final boolean m3792d(C2757x c2757x, @Nullable byte[] bArr, int i) {
        int iMin = Math.min(c2757x.m3081a(), i - this.f8914d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            c2757x.m3080F(iMin);
        } else {
            System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, this.f8914d, iMin);
            c2757x.f6794b += iMin;
        }
        int i2 = this.f8914d + iMin;
        this.f8914d = i2;
        return i2 == i;
    }

    /* JADX INFO: renamed from: e */
    public final void m3793e(int i) {
        this.f8913c = i;
        this.f8914d = 0;
    }
}
