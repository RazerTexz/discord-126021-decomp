package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2928l;
import p007b.p225i.p226a.p242c.p267x2.C3023g;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.k */
/* JADX INFO: compiled from: AdtsReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3090k implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    public static final byte[] f8699a = {73, 68, 51};

    /* JADX INFO: renamed from: b */
    public final boolean f8700b;

    /* JADX INFO: renamed from: c */
    public final C2756w f8701c = new C2756w(new byte[7]);

    /* JADX INFO: renamed from: d */
    public final C2757x f8702d = new C2757x(Arrays.copyOf(f8699a, 10));

    /* JADX INFO: renamed from: e */
    @Nullable
    public final String f8703e;

    /* JADX INFO: renamed from: f */
    public String f8704f;

    /* JADX INFO: renamed from: g */
    public InterfaceC3122w f8705g;

    /* JADX INFO: renamed from: h */
    public InterfaceC3122w f8706h;

    /* JADX INFO: renamed from: i */
    public int f8707i;

    /* JADX INFO: renamed from: j */
    public int f8708j;

    /* JADX INFO: renamed from: k */
    public int f8709k;

    /* JADX INFO: renamed from: l */
    public boolean f8710l;

    /* JADX INFO: renamed from: m */
    public boolean f8711m;

    /* JADX INFO: renamed from: n */
    public int f8712n;

    /* JADX INFO: renamed from: o */
    public int f8713o;

    /* JADX INFO: renamed from: p */
    public int f8714p;

    /* JADX INFO: renamed from: q */
    public boolean f8715q;

    /* JADX INFO: renamed from: r */
    public long f8716r;

    /* JADX INFO: renamed from: s */
    public int f8717s;

    /* JADX INFO: renamed from: t */
    public long f8718t;

    /* JADX INFO: renamed from: u */
    public InterfaceC3122w f8719u;

    /* JADX INFO: renamed from: v */
    public long f8720v;

    public C3090k(boolean z2, @Nullable String str) {
        m3773h();
        this.f8712n = -1;
        this.f8713o = -1;
        this.f8716r = -9223372036854775807L;
        this.f8718t = -9223372036854775807L;
        this.f8700b = z2;
        this.f8703e = str;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m3771g(int i) {
        return (i & 65526) == 65520;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3772a(C2757x c2757x, byte[] bArr, int i) {
        int iMin = Math.min(c2757x.m3081a(), i - this.f8708j);
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, this.f8708j, iMin);
        c2757x.f6794b += iMin;
        int i2 = this.f8708j + iMin;
        this.f8708j = i2;
        return i2 == i;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0272  */
    /* JADX WARN: Code duplicated, block: B:120:0x0297  */
    /* JADX WARN: Code duplicated, block: B:122:0x029f  */
    /* JADX WARN: Code duplicated, block: B:124:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:126:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:128:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:130:0x02af  */
    /* JADX WARN: Code duplicated, block: B:131:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:133:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:134:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:135:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:158:0x02ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x021d  */
    /* JADX WARN: Code duplicated, block: B:81:0x022d  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) throws ParserException {
        int i;
        int i2;
        boolean z2;
        int iM3067g;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Objects.requireNonNull(this.f8705g);
        int i8 = C2738e0.f6708a;
        while (c2757x.m3081a() > 0) {
            int i9 = this.f8707i;
            int i10 = 13;
            int i11 = 2;
            if (i9 == 0) {
                byte[] bArr = c2757x.f6793a;
                int i12 = c2757x.f6794b;
                int i13 = c2757x.f6795c;
                while (true) {
                    if (i12 < i13) {
                        int i14 = i12 + 1;
                        int i15 = bArr[i12] & 255;
                        if (this.f8709k == 512 && m3771g((((byte) i15) & 255) | 65280)) {
                            if (!this.f8711m) {
                                int i16 = i14 - 2;
                                c2757x.m3079E(i16 + 1);
                                if (m3774i(c2757x, this.f8701c.f6789a, 1)) {
                                    this.f8701c.m3071k(4);
                                    int iM3067g2 = this.f8701c.m3067g(1);
                                    int i17 = this.f8712n;
                                    if (i17 != -1 && iM3067g2 != i17) {
                                        z2 = false;
                                    } else if (this.f8713o == -1) {
                                        if (m3774i(c2757x, this.f8701c.f6789a, 4)) {
                                            this.f8701c.m3071k(14);
                                            iM3067g = this.f8701c.m3067g(i10);
                                            if (iM3067g >= 7) {
                                                byte[] bArr2 = c2757x.f6793a;
                                                i3 = c2757x.f6795c;
                                                i4 = i16 + iM3067g;
                                                if (i4 < i3 && (bArr2[i4] != -1 ? !(bArr2[i4] == 73 && ((i5 = i4 + 1) == i3 || (bArr2[i5] == 68 && ((i6 = i4 + 2) == i3 || bArr2[i6] == 51)))) : !((i7 = i4 + 1) == i3 || (m3771g((bArr2[i7] & 255) | 65280) && ((bArr2[i7] & 8) >> 3) == iM3067g2)))) {
                                                }
                                            }
                                            z2 = false;
                                        }
                                        z2 = true;
                                    } else if (m3774i(c2757x, this.f8701c.f6789a, 1)) {
                                        this.f8701c.m3071k(i11);
                                        if (this.f8701c.m3067g(4) != this.f8713o) {
                                            z2 = false;
                                        } else {
                                            c2757x.m3079E(i16 + 2);
                                            if (m3774i(c2757x, this.f8701c.f6789a, 4)) {
                                                this.f8701c.m3071k(14);
                                                iM3067g = this.f8701c.m3067g(i10);
                                                if (iM3067g >= 7) {
                                                    byte[] bArr3 = c2757x.f6793a;
                                                    i3 = c2757x.f6795c;
                                                    i4 = i16 + iM3067g;
                                                    if (i4 < i3) {
                                                    }
                                                }
                                                z2 = false;
                                            }
                                            z2 = true;
                                        }
                                    } else {
                                        z2 = true;
                                    }
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    i = this.f8709k;
                                    i2 = i15 | i;
                                    if (i2 != 329) {
                                        this.f8709k = 768;
                                    } else if (i2 != 511) {
                                        this.f8709k = 512;
                                    } else if (i2 != 836) {
                                        this.f8709k = 1024;
                                    } else if (i2 != 1075) {
                                        if (i != 256) {
                                            this.f8709k = 256;
                                            i12 = i14 - 1;
                                        }
                                        i10 = 13;
                                        i11 = 2;
                                    } else {
                                        this.f8707i = 2;
                                        this.f8708j = f8699a.length;
                                        this.f8717s = 0;
                                        this.f8702d.m3079E(0);
                                        c2757x.m3079E(i14);
                                    }
                                    i12 = i14;
                                    i10 = 13;
                                    i11 = 2;
                                }
                            }
                            this.f8714p = (i15 & 8) >> 3;
                            this.f8710l = (i15 & 1) == 0;
                            if (this.f8711m) {
                                this.f8707i = 3;
                                this.f8708j = 0;
                            } else {
                                this.f8707i = 1;
                                this.f8708j = 0;
                            }
                            c2757x.m3079E(i14);
                        } else {
                            i = this.f8709k;
                            i2 = i15 | i;
                            if (i2 != 329) {
                                this.f8709k = 768;
                            } else if (i2 != 511) {
                                this.f8709k = 512;
                            } else if (i2 != 836) {
                                this.f8709k = 1024;
                            } else if (i2 != 1075) {
                                if (i != 256) {
                                    this.f8709k = 256;
                                    i12 = i14 - 1;
                                }
                                i10 = 13;
                                i11 = 2;
                            } else {
                                this.f8707i = 2;
                                this.f8708j = f8699a.length;
                                this.f8717s = 0;
                                this.f8702d.m3079E(0);
                                c2757x.m3079E(i14);
                            }
                            i12 = i14;
                            i10 = 13;
                            i11 = 2;
                        }
                    } else {
                        c2757x.m3079E(i12);
                    }
                }
            } else if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 == 3) {
                        if (m3772a(c2757x, this.f8701c.f6789a, this.f8710l ? 7 : 5)) {
                            this.f8701c.m3071k(0);
                            if (this.f8715q) {
                                this.f8701c.m3073m(10);
                            } else {
                                int iM3067g3 = this.f8701c.m3067g(2) + 1;
                                if (iM3067g3 != 2) {
                                    StringBuilder sb = new StringBuilder(61);
                                    sb.append("Detected audio object type: ");
                                    sb.append(iM3067g3);
                                    sb.append(", but assuming AAC LC.");
                                    Log.w("AdtsReader", sb.toString());
                                    iM3067g3 = 2;
                                }
                                this.f8701c.m3073m(5);
                                int iM3067g4 = this.f8701c.m3067g(3);
                                int i18 = this.f8713o;
                                byte[] bArr4 = {(byte) (((iM3067g3 << 3) & 248) | ((i18 >> 1) & 7)), (byte) (((i18 << 7) & 128) | ((iM3067g4 << 3) & 120))};
                                C2928l.b bVarM3489b = C2928l.m3489b(new C2756w(bArr4), false);
                                C2811j1.b bVar = new C2811j1.b();
                                bVar.f7163a = this.f8704f;
                                bVar.f7173k = "audio/mp4a-latm";
                                bVar.f7170h = bVarM3489b.f7768c;
                                bVar.f7186x = bVarM3489b.f7767b;
                                bVar.f7187y = bVarM3489b.f7766a;
                                bVar.f7175m = Collections.singletonList(bArr4);
                                bVar.f7165c = this.f8703e;
                                C2811j1 c2811j1M3277a = bVar.m3277a();
                                this.f8716r = 1024000000 / ((long) c2811j1M3277a.f7137K);
                                this.f8705g.mo2526e(c2811j1M3277a);
                                this.f8715q = true;
                            }
                            this.f8701c.m3073m(4);
                            int iM3067g5 = (this.f8701c.m3067g(13) - 2) - 5;
                            if (this.f8710l) {
                                iM3067g5 -= 2;
                            }
                            InterfaceC3122w interfaceC3122w = this.f8705g;
                            long j = this.f8716r;
                            this.f8707i = 4;
                            this.f8708j = 0;
                            this.f8719u = interfaceC3122w;
                            this.f8720v = j;
                            this.f8717s = iM3067g5;
                        }
                    } else {
                        if (i9 != 4) {
                            throw new IllegalStateException();
                        }
                        int iMin = Math.min(c2757x.m3081a(), this.f8717s - this.f8708j);
                        this.f8719u.mo2524c(c2757x, iMin);
                        int i19 = this.f8708j + iMin;
                        this.f8708j = i19;
                        int i20 = this.f8717s;
                        if (i19 == i20) {
                            long j2 = this.f8718t;
                            if (j2 != -9223372036854775807L) {
                                this.f8719u.mo2525d(j2, 1, i20, 0, null);
                                this.f8718t += this.f8720v;
                            }
                            m3773h();
                        }
                    }
                } else if (m3772a(c2757x, this.f8702d.f6793a, 10)) {
                    this.f8706h.mo2524c(this.f8702d, 10);
                    this.f8702d.m3079E(6);
                    InterfaceC3122w interfaceC3122w2 = this.f8706h;
                    int iM3099s = this.f8702d.m3099s() + 10;
                    this.f8707i = 4;
                    this.f8708j = 10;
                    this.f8719u = interfaceC3122w2;
                    this.f8720v = 0L;
                    this.f8717s = iM3099s;
                }
            } else if (c2757x.m3081a() != 0) {
                C2756w c2756w = this.f8701c;
                c2756w.f6789a[0] = c2757x.f6793a[c2757x.f6794b];
                c2756w.m3071k(2);
                int iM3067g6 = this.f8701c.m3067g(4);
                int i21 = this.f8713o;
                if (i21 == -1 || iM3067g6 == i21) {
                    if (!this.f8711m) {
                        this.f8711m = true;
                        this.f8712n = this.f8714p;
                        this.f8713o = iM3067g6;
                    }
                    this.f8707i = 3;
                    this.f8708j = 0;
                } else {
                    this.f8711m = false;
                    m3773h();
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        this.f8718t = -9223372036854775807L;
        this.f8711m = false;
        m3773h();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        this.f8704f = dVar.m3766b();
        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 1);
        this.f8705g = interfaceC3122wMo2492p;
        this.f8719u = interfaceC3122wMo2492p;
        if (!this.f8700b) {
            this.f8706h = new C3023g();
            return;
        }
        dVar.m3765a();
        InterfaceC3122w interfaceC3122wMo2492p2 = interfaceC3058j.mo2492p(dVar.m3767c(), 5);
        this.f8706h = interfaceC3122wMo2492p2;
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7163a = dVar.m3766b();
        bVar.f7173k = "application/id3";
        interfaceC3122wMo2492p2.mo2526e(bVar.m3277a());
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8718t = j;
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m3773h() {
        this.f8707i = 0;
        this.f8708j = 0;
        this.f8709k = 256;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m3774i(C2757x c2757x, byte[] bArr, int i) {
        if (c2757x.m3081a() < i) {
            return false;
        }
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, i);
        c2757x.f6794b += i;
        return true;
    }
}
