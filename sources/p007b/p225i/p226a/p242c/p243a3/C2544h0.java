package p007b.p225i.p226a.p242c.p243a3;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2815k1;
import p007b.p225i.p226a.p242c.p243a3.C2542g0;
import p007b.p225i.p226a.p242c.p243a3.C2544h0;
import p007b.p225i.p226a.p242c.p257e3.C2703e;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2744k;
import p007b.p225i.p226a.p242c.p266w2.C2982m;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u;
import p007b.p225i.p226a.p242c.p267x2.C3121v;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.a3.h0 */
/* JADX INFO: compiled from: SampleQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2544h0 implements InterfaceC3122w {

    /* JADX INFO: renamed from: A */
    @Nullable
    public C2811j1 f5592A;

    /* JADX INFO: renamed from: B */
    @Nullable
    public C2811j1 f5593B;

    /* JADX INFO: renamed from: C */
    public boolean f5594C;

    /* JADX INFO: renamed from: D */
    public boolean f5595D;

    /* JADX INFO: renamed from: a */
    public final C2542g0 f5596a;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final InterfaceC2990u f5599d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final InterfaceC2988s.a f5600e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final Looper f5601f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public d f5602g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public C2811j1 f5603h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public DrmSession f5604i;

    /* JADX INFO: renamed from: q */
    public int f5612q;

    /* JADX INFO: renamed from: r */
    public int f5613r;

    /* JADX INFO: renamed from: s */
    public int f5614s;

    /* JADX INFO: renamed from: t */
    public int f5615t;

    /* JADX INFO: renamed from: x */
    public boolean f5619x;

    /* JADX INFO: renamed from: b */
    public final b f5597b = new b();

    /* JADX INFO: renamed from: j */
    public int f5605j = 1000;

    /* JADX INFO: renamed from: k */
    public int[] f5606k = new int[1000];

    /* JADX INFO: renamed from: l */
    public long[] f5607l = new long[1000];

    /* JADX INFO: renamed from: o */
    public long[] f5610o = new long[1000];

    /* JADX INFO: renamed from: n */
    public int[] f5609n = new int[1000];

    /* JADX INFO: renamed from: m */
    public int[] f5608m = new int[1000];

    /* JADX INFO: renamed from: p */
    public InterfaceC3122w.a[] f5611p = new InterfaceC3122w.a[1000];

    /* JADX INFO: renamed from: c */
    public final C2554m0<c> f5598c = new C2554m0<>(new InterfaceC2744k() { // from class: b.i.a.c.a3.k
        @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2744k
        public final void accept(Object obj) {
            ((C2544h0.c) obj).f5626b.release();
        }
    });

    /* JADX INFO: renamed from: u */
    public long f5616u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v */
    public long f5617v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: w */
    public long f5618w = Long.MIN_VALUE;

    /* JADX INFO: renamed from: z */
    public boolean f5621z = true;

    /* JADX INFO: renamed from: y */
    public boolean f5620y = true;

    /* JADX INFO: renamed from: b.i.a.c.a3.h0$b */
    /* JADX INFO: compiled from: SampleQueue.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public int f5622a;

        /* JADX INFO: renamed from: b */
        public long f5623b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public InterfaceC3122w.a f5624c;
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.h0$c */
    /* JADX INFO: compiled from: SampleQueue.java */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final C2811j1 f5625a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC2990u.b f5626b;

        public c(C2811j1 c2811j1, InterfaceC2990u.b bVar, a aVar) {
            this.f5625a = c2811j1;
            this.f5626b = bVar;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.h0$d */
    /* JADX INFO: compiled from: SampleQueue.java */
    public interface d {
    }

    public C2544h0(C2713o c2713o, @Nullable Looper looper, @Nullable InterfaceC2990u interfaceC2990u, @Nullable InterfaceC2988s.a aVar) {
        this.f5601f = looper;
        this.f5599d = interfaceC2990u;
        this.f5600e = aVar;
        this.f5596a = new C2542g0(c2713o);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: a */
    public final int mo2522a(InterfaceC2706h interfaceC2706h, int i, boolean z2, int i2) throws IOException {
        C2542g0 c2542g0 = this.f5596a;
        int iM2520c = c2542g0.m2520c(i);
        C2542g0.a aVar = c2542g0.f5583f;
        int i3 = interfaceC2706h.read(aVar.f5588d.f6522a, aVar.m2521a(c2542g0.f5584g), iM2520c);
        if (i3 != -1) {
            c2542g0.m2519b(i3);
            return i3;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: b */
    public /* synthetic */ int mo2523b(InterfaceC2706h interfaceC2706h, int i, boolean z2) {
        return C3121v.m3817a(this, interfaceC2706h, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo2524c(C2757x c2757x, int i) {
        C3121v.m3818b(this, c2757x, i);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: d */
    public void mo2525d(long j, int i, int i2, int i3, @Nullable InterfaceC3122w.a aVar) {
        InterfaceC2990u.b bVarMo3598b;
        int i4 = i & 1;
        boolean z2 = i4 != 0;
        if (this.f5620y) {
            if (!z2) {
                return;
            } else {
                this.f5620y = false;
            }
        }
        long j2 = j + 0;
        if (this.f5594C) {
            if (j2 < this.f5616u) {
                return;
            }
            if (i4 == 0) {
                if (!this.f5595D) {
                    String strValueOf = String.valueOf(this.f5593B);
                    C1643a.m854h0(strValueOf.length() + 50, "Overriding unexpected non-sync sample for format: ", strValueOf, "SampleQueue");
                    this.f5595D = true;
                }
                i |= 1;
            }
        }
        long j3 = (this.f5596a.f5584g - ((long) i2)) - ((long) i3);
        synchronized (this) {
            int i5 = this.f5612q;
            if (i5 > 0) {
                int iM2533l = m2533l(i5 - 1);
                C1460d.m531j(this.f5607l[iM2533l] + ((long) this.f5608m[iM2533l]) <= j3);
            }
            this.f5619x = (536870912 & i) != 0;
            this.f5618w = Math.max(this.f5618w, j2);
            int iM2533l2 = m2533l(this.f5612q);
            this.f5610o[iM2533l2] = j2;
            this.f5607l[iM2533l2] = j3;
            this.f5608m[iM2533l2] = i2;
            this.f5609n[iM2533l2] = i;
            this.f5611p[iM2533l2] = aVar;
            this.f5606k[iM2533l2] = 0;
            if ((this.f5598c.f5649b.size() == 0) || !this.f5598c.m2562c().f5625a.equals(this.f5593B)) {
                InterfaceC2990u interfaceC2990u = this.f5599d;
                if (interfaceC2990u != null) {
                    Looper looper = this.f5601f;
                    Objects.requireNonNull(looper);
                    bVarMo3598b = interfaceC2990u.mo3598b(looper, this.f5600e, this.f5593B);
                } else {
                    bVarMo3598b = C2982m.f8003b;
                }
                C2554m0<c> c2554m0 = this.f5598c;
                int iM2535n = m2535n();
                C2811j1 c2811j1 = this.f5593B;
                Objects.requireNonNull(c2811j1);
                c2554m0.m2560a(iM2535n, new c(c2811j1, bVarMo3598b, null));
            }
            int i6 = this.f5612q + 1;
            this.f5612q = i6;
            int i7 = this.f5605j;
            if (i6 == i7) {
                int i8 = i7 + 1000;
                int[] iArr = new int[i8];
                long[] jArr = new long[i8];
                long[] jArr2 = new long[i8];
                int[] iArr2 = new int[i8];
                int[] iArr3 = new int[i8];
                InterfaceC3122w.a[] aVarArr = new InterfaceC3122w.a[i8];
                int i9 = this.f5614s;
                int i10 = i7 - i9;
                System.arraycopy(this.f5607l, i9, jArr, 0, i10);
                System.arraycopy(this.f5610o, this.f5614s, jArr2, 0, i10);
                System.arraycopy(this.f5609n, this.f5614s, iArr2, 0, i10);
                System.arraycopy(this.f5608m, this.f5614s, iArr3, 0, i10);
                System.arraycopy(this.f5611p, this.f5614s, aVarArr, 0, i10);
                System.arraycopy(this.f5606k, this.f5614s, iArr, 0, i10);
                int i11 = this.f5614s;
                System.arraycopy(this.f5607l, 0, jArr, i10, i11);
                System.arraycopy(this.f5610o, 0, jArr2, i10, i11);
                System.arraycopy(this.f5609n, 0, iArr2, i10, i11);
                System.arraycopy(this.f5608m, 0, iArr3, i10, i11);
                System.arraycopy(this.f5611p, 0, aVarArr, i10, i11);
                System.arraycopy(this.f5606k, 0, iArr, i10, i11);
                this.f5607l = jArr;
                this.f5610o = jArr2;
                this.f5609n = iArr2;
                this.f5608m = iArr3;
                this.f5611p = aVarArr;
                this.f5606k = iArr;
                this.f5614s = 0;
                this.f5605j = i8;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: e */
    public final void mo2526e(C2811j1 c2811j1) {
        boolean z2;
        this.f5592A = c2811j1;
        synchronized (this) {
            z2 = false;
            this.f5621z = false;
            if (!C2738e0.m2993a(c2811j1, this.f5593B)) {
                if ((this.f5598c.f5649b.size() == 0) || !this.f5598c.m2562c().f5625a.equals(c2811j1)) {
                    this.f5593B = c2811j1;
                } else {
                    this.f5593B = this.f5598c.m2562c().f5625a;
                }
                C2811j1 c2811j2 = this.f5593B;
                this.f5594C = C2753t.m3043a(c2811j2.f7155w, c2811j2.f7152t);
                this.f5595D = false;
                z2 = true;
            }
        }
        d dVar = this.f5602g;
        if (dVar == null || !z2) {
            return;
        }
        C2538e0 c2538e0 = (C2538e0) dVar;
        c2538e0.f5500A.post(c2538e0.f5536y);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: f */
    public final void mo2527f(C2757x c2757x, int i, int i2) {
        C2542g0 c2542g0 = this.f5596a;
        Objects.requireNonNull(c2542g0);
        while (i > 0) {
            int iM2520c = c2542g0.m2520c(i);
            C2542g0.a aVar = c2542g0.f5583f;
            c2757x.m3085e(aVar.f5588d.f6522a, aVar.m2521a(c2542g0.f5584g), iM2520c);
            i -= iM2520c;
            c2542g0.m2519b(iM2520c);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @GuardedBy("this")
    /* JADX INFO: renamed from: g */
    public final long m2528g(int i) {
        this.f5617v = Math.max(this.f5617v, m2531j(i));
        this.f5612q -= i;
        int i2 = this.f5613r + i;
        this.f5613r = i2;
        int i3 = this.f5614s + i;
        this.f5614s = i3;
        int i4 = this.f5605j;
        if (i3 >= i4) {
            this.f5614s = i3 - i4;
        }
        int i5 = this.f5615t - i;
        this.f5615t = i5;
        int i6 = 0;
        if (i5 < 0) {
            this.f5615t = 0;
        }
        C2554m0<c> c2554m0 = this.f5598c;
        while (i6 < c2554m0.f5649b.size() - 1) {
            int i7 = i6 + 1;
            if (i2 < c2554m0.f5649b.keyAt(i7)) {
                break;
            }
            c2554m0.f5650c.accept((V) c2554m0.f5649b.valueAt(i6));
            c2554m0.f5649b.removeAt(i6);
            int i8 = c2554m0.f5648a;
            if (i8 > 0) {
                c2554m0.f5648a = i8 - 1;
            }
            i6 = i7;
        }
        if (this.f5612q != 0) {
            return this.f5607l[this.f5614s];
        }
        int i9 = this.f5614s;
        if (i9 == 0) {
            i9 = this.f5605j;
        }
        int i10 = i9 - 1;
        return this.f5607l[i10] + ((long) this.f5608m[i10]);
    }

    /* JADX INFO: renamed from: h */
    public final void m2529h() {
        long jM2528g;
        C2542g0 c2542g0 = this.f5596a;
        synchronized (this) {
            int i = this.f5612q;
            jM2528g = i == 0 ? -1L : m2528g(i);
        }
        c2542g0.m2518a(jM2528g);
    }

    /* JADX INFO: renamed from: i */
    public final int m2530i(int i, int i2, long j, boolean z2) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long[] jArr = this.f5610o;
            if (jArr[i] > j) {
                return i3;
            }
            if (!z2 || (this.f5609n[i] & 1) != 0) {
                if (jArr[i] == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.f5605j) {
                i = 0;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: j */
    public final long m2531j(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iM2533l = m2533l(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.f5610o[iM2533l]);
            if ((this.f5609n[iM2533l] & 1) != 0) {
                break;
            }
            iM2533l--;
            if (iM2533l == -1) {
                iM2533l = this.f5605j - 1;
            }
        }
        return jMax;
    }

    /* JADX INFO: renamed from: k */
    public final int m2532k() {
        return this.f5613r + this.f5615t;
    }

    /* JADX INFO: renamed from: l */
    public final int m2533l(int i) {
        int i2 = this.f5614s + i;
        int i3 = this.f5605j;
        return i2 < i3 ? i2 : i2 - i3;
    }

    @Nullable
    /* JADX INFO: renamed from: m */
    public final synchronized C2811j1 m2534m() {
        return this.f5621z ? null : this.f5593B;
    }

    /* JADX INFO: renamed from: n */
    public final int m2535n() {
        return this.f5613r + this.f5612q;
    }

    /* JADX INFO: renamed from: o */
    public final boolean m2536o() {
        return this.f5615t != this.f5612q;
    }

    @CallSuper
    /* JADX INFO: renamed from: p */
    public synchronized boolean m2537p(boolean z2) {
        C2811j1 c2811j1;
        boolean z3 = true;
        if (m2536o()) {
            if (this.f5598c.m2561b(m2532k()).f5625a != this.f5603h) {
                return true;
            }
            return m2538q(m2533l(this.f5615t));
        }
        if (!z2 && !this.f5619x && ((c2811j1 = this.f5593B) == null || c2811j1 == this.f5603h)) {
            z3 = false;
        }
        return z3;
    }

    /* JADX INFO: renamed from: q */
    public final boolean m2538q(int i) {
        DrmSession drmSession = this.f5604i;
        return drmSession == null || drmSession.getState() == 4 || ((this.f5609n[i] & BasicMeasure.EXACTLY) == 0 && this.f5604i.mo3609d());
    }

    /* JADX INFO: renamed from: r */
    public final void m2539r(C2811j1 c2811j1, C2815k1 c2815k1) {
        C2811j1 c2811j1M3277a;
        C2811j1 c2811j2 = this.f5603h;
        boolean z2 = c2811j2 == null;
        DrmInitData drmInitData = z2 ? null : c2811j2.f7158z;
        this.f5603h = c2811j1;
        DrmInitData drmInitData2 = c2811j1.f7158z;
        InterfaceC2990u interfaceC2990u = this.f5599d;
        if (interfaceC2990u != null) {
            int iMo3600d = interfaceC2990u.mo3600d(c2811j1);
            C2811j1.b bVarM3275a = c2811j1.m3275a();
            bVarM3275a.f7162D = iMo3600d;
            c2811j1M3277a = bVarM3275a.m3277a();
        } else {
            c2811j1M3277a = c2811j1;
        }
        c2815k1.f7196b = c2811j1M3277a;
        c2815k1.f7195a = this.f5604i;
        if (this.f5599d == null) {
            return;
        }
        if (z2 || !C2738e0.m2993a(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f5604i;
            InterfaceC2990u interfaceC2990u2 = this.f5599d;
            Looper looper = this.f5601f;
            Objects.requireNonNull(looper);
            DrmSession drmSessionMo3599c = interfaceC2990u2.mo3599c(looper, this.f5600e, c2811j1);
            this.f5604i = drmSessionMo3599c;
            c2815k1.f7195a = drmSessionMo3599c;
            if (drmSession != null) {
                drmSession.mo3607b(this.f5600e);
            }
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @CallSuper
    /* JADX INFO: renamed from: s */
    public void m2540s(boolean z2) {
        C2542g0 c2542g0 = this.f5596a;
        C2542g0.a aVar = c2542g0.f5581d;
        if (aVar.f5587c) {
            C2542g0.a aVar2 = c2542g0.f5583f;
            int i = (((int) (aVar2.f5585a - aVar.f5585a)) / c2542g0.f5579b) + aVar2.f5587c;
            C2703e[] c2703eArr = new C2703e[i];
            int i2 = 0;
            while (i2 < i) {
                c2703eArr[i2] = aVar.f5588d;
                aVar.f5588d = null;
                C2542g0.a aVar3 = aVar.f5589e;
                aVar.f5589e = null;
                i2++;
                aVar = aVar3;
            }
            c2542g0.f5578a.m2858a(c2703eArr);
        }
        C2542g0.a aVar4 = new C2542g0.a(0L, c2542g0.f5579b);
        c2542g0.f5581d = aVar4;
        c2542g0.f5582e = aVar4;
        c2542g0.f5583f = aVar4;
        c2542g0.f5584g = 0L;
        c2542g0.f5578a.m2860c();
        this.f5612q = 0;
        this.f5613r = 0;
        this.f5614s = 0;
        this.f5615t = 0;
        this.f5620y = true;
        this.f5616u = Long.MIN_VALUE;
        this.f5617v = Long.MIN_VALUE;
        this.f5618w = Long.MIN_VALUE;
        this.f5619x = false;
        C2554m0<c> c2554m0 = this.f5598c;
        for (int i3 = 0; i3 < c2554m0.f5649b.size(); i3++) {
            c2554m0.f5650c.accept((V) c2554m0.f5649b.valueAt(i3));
        }
        c2554m0.f5648a = -1;
        c2554m0.f5649b.clear();
        if (z2) {
            this.f5592A = null;
            this.f5593B = null;
            this.f5621z = true;
        }
    }

    /* JADX INFO: renamed from: t */
    public final synchronized boolean m2541t(long j, boolean z2) {
        synchronized (this) {
            this.f5615t = 0;
            C2542g0 c2542g0 = this.f5596a;
            c2542g0.f5582e = c2542g0.f5581d;
        }
        int iM2533l = m2533l(0);
        if (m2536o() && j >= this.f5610o[iM2533l] && (j <= this.f5618w || z2)) {
            int iM2530i = m2530i(iM2533l, this.f5612q - this.f5615t, j, true);
            if (iM2530i == -1) {
                return false;
            }
            this.f5616u = j;
            this.f5615t += iM2530i;
            return true;
        }
        return false;
    }
}
