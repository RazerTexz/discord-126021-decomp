package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2812j2;
import p007b.p225i.p226a.p242c.C2815k1;
import p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2753t;

/* JADX INFO: renamed from: b.i.a.c.a3.n */
/* JADX INFO: compiled from: ClippingMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2555n implements InterfaceC2570x, InterfaceC2570x.a {

    /* JADX INFO: renamed from: j */
    public final InterfaceC2570x f5651j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public InterfaceC2570x.a f5652k;

    /* JADX INFO: renamed from: l */
    public a[] f5653l = new a[0];

    /* JADX INFO: renamed from: m */
    public long f5654m;

    /* JADX INFO: renamed from: n */
    public long f5655n;

    /* JADX INFO: renamed from: o */
    public long f5656o;

    /* JADX INFO: renamed from: b.i.a.c.a3.n$a */
    /* JADX INFO: compiled from: ClippingMediaPeriod.java */
    public final class a implements InterfaceC2546i0 {

        /* JADX INFO: renamed from: a */
        public final InterfaceC2546i0 f5657a;

        /* JADX INFO: renamed from: b */
        public boolean f5658b;

        public a(InterfaceC2546i0 interfaceC2546i0) {
            this.f5657a = interfaceC2546i0;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0
        /* JADX INFO: renamed from: a */
        public int mo2505a(C2815k1 c2815k1, DecoderInputBuffer decoderInputBuffer, int i) {
            if (C2555n.this.m2564d()) {
                return -3;
            }
            if (this.f5658b) {
                decoderInputBuffer.f7901j = 4;
                return -4;
            }
            int iMo2505a = this.f5657a.mo2505a(c2815k1, decoderInputBuffer, i);
            if (iMo2505a != -5) {
                C2555n c2555n = C2555n.this;
                long j = c2555n.f5656o;
                if (j == Long.MIN_VALUE || ((iMo2505a != -4 || decoderInputBuffer.f19780n < j) && !(iMo2505a == -3 && c2555n.mo2493q() == Long.MIN_VALUE && !decoderInputBuffer.f19779m))) {
                    return iMo2505a;
                }
                decoderInputBuffer.mo3856p();
                decoderInputBuffer.f7901j = 4;
                this.f5658b = true;
                return -4;
            }
            C2811j1 c2811j1 = c2815k1.f7196b;
            Objects.requireNonNull(c2811j1);
            int i2 = c2811j1.f7139M;
            if (i2 != 0 || c2811j1.f7140N != 0) {
                C2555n c2555n2 = C2555n.this;
                if (c2555n2.f5655n != 0) {
                    i2 = 0;
                }
                int i3 = c2555n2.f5656o == Long.MIN_VALUE ? c2811j1.f7140N : 0;
                C2811j1.b bVarM3275a = c2811j1.m3275a();
                bVarM3275a.f7159A = i2;
                bVarM3275a.f7160B = i3;
                c2815k1.f7196b = bVarM3275a.m3277a();
            }
            return -5;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0
        /* JADX INFO: renamed from: b */
        public void mo2506b() throws IOException {
            this.f5657a.mo2506b();
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0
        /* JADX INFO: renamed from: c */
        public int mo2507c(long j) {
            if (C2555n.this.m2564d()) {
                return -3;
            }
            return this.f5657a.mo2507c(j);
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0
        /* JADX INFO: renamed from: d */
        public boolean mo2508d() {
            return !C2555n.this.m2564d() && this.f5657a.mo2508d();
        }
    }

    public C2555n(InterfaceC2570x interfaceC2570x, boolean z2, long j, long j2) {
        this.f5651j = interfaceC2570x;
        this.f5654m = z2 ? j : -9223372036854775807L;
        this.f5655n = j;
        this.f5656o = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2548j0.a
    /* JADX INFO: renamed from: a */
    public void mo2542a(InterfaceC2548j0 interfaceC2548j0) {
        InterfaceC2570x.a aVar = this.f5652k;
        Objects.requireNonNull(aVar);
        aVar.mo2542a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x.a
    /* JADX INFO: renamed from: b */
    public void mo2563b(InterfaceC2570x interfaceC2570x) {
        InterfaceC2570x.a aVar = this.f5652k;
        Objects.requireNonNull(aVar);
        aVar.mo2563b(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: c */
    public long mo2479c() {
        long jMo2479c = this.f5651j.mo2479c();
        if (jMo2479c != Long.MIN_VALUE) {
            long j = this.f5656o;
            if (j == Long.MIN_VALUE || jMo2479c < j) {
                return jMo2479c;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2564d() {
        return this.f5654m != -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: e */
    public void mo2481e() throws IOException {
        this.f5651j.mo2481e();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: f */
    public long mo2482f(long j) {
        this.f5654m = -9223372036854775807L;
        boolean z2 = false;
        for (a aVar : this.f5653l) {
            if (aVar != null) {
                aVar.f5658b = false;
            }
        }
        long jMo2482f = this.f5651j.mo2482f(j);
        if (jMo2482f == j) {
            z2 = true;
        } else if (jMo2482f >= this.f5655n) {
            long j2 = this.f5656o;
            if (j2 == Long.MIN_VALUE || jMo2482f <= j2) {
                z2 = true;
            }
        }
        C1460d.m426D(z2);
        return jMo2482f;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: g */
    public boolean mo2483g(long j) {
        return this.f5651j.mo2483g(j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: h */
    public boolean mo2484h() {
        return this.f5651j.mo2484h();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: i */
    public long mo2485i(long j, C2812j2 c2812j2) {
        long j2 = this.f5655n;
        if (j == j2) {
            return j2;
        }
        long jM3001i = C2738e0.m3001i(c2812j2.f7191c, 0L, j - j2);
        long j3 = c2812j2.f7192d;
        long j4 = this.f5656o;
        long jM3001i2 = C2738e0.m3001i(j3, 0L, j4 == Long.MIN_VALUE ? RecyclerView.FOREVER_NS : j4 - j);
        if (jM3001i != c2812j2.f7191c || jM3001i2 != c2812j2.f7192d) {
            c2812j2 = new C2812j2(jM3001i, jM3001i2);
        }
        return this.f5651j.mo2485i(j, c2812j2);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: k */
    public long mo2487k() {
        if (m2564d()) {
            long j = this.f5654m;
            this.f5654m = -9223372036854775807L;
            long jMo2487k = mo2487k();
            return jMo2487k != -9223372036854775807L ? jMo2487k : j;
        }
        long jMo2487k2 = this.f5651j.mo2487k();
        if (jMo2487k2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2 = true;
        C1460d.m426D(jMo2487k2 >= this.f5655n);
        long j2 = this.f5656o;
        if (j2 != Long.MIN_VALUE && jMo2487k2 > j2) {
            z2 = false;
        }
        C1460d.m426D(z2);
        return jMo2487k2;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: l */
    public void mo2488l(InterfaceC2570x.a aVar, long j) {
        this.f5652k = aVar;
        this.f5651j.mo2488l(this, j);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0088  */
    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: m */
    public long mo2489m(InterfaceC2644j[] interfaceC2644jArr, boolean[] zArr, InterfaceC2546i0[] interfaceC2546i0Arr, boolean[] zArr2, long j) {
        long j2;
        boolean z2;
        this.f5653l = new a[interfaceC2546i0Arr.length];
        InterfaceC2546i0[] interfaceC2546i0Arr2 = new InterfaceC2546i0[interfaceC2546i0Arr.length];
        int i = 0;
        while (true) {
            InterfaceC2546i0 interfaceC2546i0 = null;
            if (i >= interfaceC2546i0Arr.length) {
                break;
            }
            a[] aVarArr = this.f5653l;
            aVarArr[i] = (a) interfaceC2546i0Arr[i];
            if (aVarArr[i] != null) {
                interfaceC2546i0 = aVarArr[i].f5657a;
            }
            interfaceC2546i0Arr2[i] = interfaceC2546i0;
            i++;
        }
        long jMo2489m = this.f5651j.mo2489m(interfaceC2644jArr, zArr, interfaceC2546i0Arr2, zArr2, j);
        boolean z3 = true;
        if (m2564d()) {
            long j3 = this.f5655n;
            if (j != j3) {
                j2 = -9223372036854775807L;
            } else {
                if (j3 == 0) {
                    z2 = false;
                    break;
                }
                int length = interfaceC2644jArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    }
                    InterfaceC2644j interfaceC2644j = interfaceC2644jArr[i2];
                    if (interfaceC2644j != null) {
                        C2811j1 c2811j1Mo2731h = interfaceC2644j.mo2731h();
                        if (!C2753t.m3043a(c2811j1Mo2731h.f7155w, c2811j1Mo2731h.f7152t)) {
                            z2 = true;
                            break;
                        }
                    }
                    i2++;
                }
                if (z2) {
                    j2 = jMo2489m;
                } else {
                    j2 = -9223372036854775807L;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        this.f5654m = j2;
        if (jMo2489m != j) {
            if (jMo2489m >= this.f5655n) {
                long j4 = this.f5656o;
                if (j4 != Long.MIN_VALUE && jMo2489m > j4) {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
        }
        C1460d.m426D(z3);
        for (int i3 = 0; i3 < interfaceC2546i0Arr.length; i3++) {
            if (interfaceC2546i0Arr2[i3] == null) {
                this.f5653l[i3] = null;
            } else {
                a[] aVarArr2 = this.f5653l;
                if (aVarArr2[i3] == null || aVarArr2[i3].f5657a != interfaceC2546i0Arr2[i3]) {
                    aVarArr2[i3] = new a(interfaceC2546i0Arr2[i3]);
                }
            }
            interfaceC2546i0Arr[i3] = this.f5653l[i3];
        }
        return jMo2489m;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: n */
    public C2558o0 mo2490n() {
        return this.f5651j.mo2490n();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: q */
    public long mo2493q() {
        long jMo2493q = this.f5651j.mo2493q();
        if (jMo2493q != Long.MIN_VALUE) {
            long j = this.f5656o;
            if (j == Long.MIN_VALUE || jMo2493q < j) {
                return jMo2493q;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: r */
    public void mo2494r(long j, boolean z2) {
        this.f5651j.mo2494r(j, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: s */
    public void mo2495s(long j) {
        this.f5651j.mo2495s(j);
    }
}
