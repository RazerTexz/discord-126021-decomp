package p007b.p225i.p226a.p242c;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p243a3.C2555n;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p243a3.C2563q;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x;
import p007b.p225i.p226a.p242c.p255c3.AbstractC2651q;
import p007b.p225i.p226a.p242c.p255c3.C2652r;
import p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p259f3.C2750q;

/* JADX INFO: renamed from: b.i.a.c.q1 */
/* JADX INFO: compiled from: MediaPeriodHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2839q1 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2570x f7442a;

    /* JADX INFO: renamed from: b */
    public final Object f7443b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2546i0[] f7444c;

    /* JADX INFO: renamed from: d */
    public boolean f7445d;

    /* JADX INFO: renamed from: e */
    public boolean f7446e;

    /* JADX INFO: renamed from: f */
    public C2843r1 f7447f;

    /* JADX INFO: renamed from: g */
    public boolean f7448g;

    /* JADX INFO: renamed from: h */
    public final boolean[] f7449h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC2763g2[] f7450i;

    /* JADX INFO: renamed from: j */
    public final AbstractC2651q f7451j;

    /* JADX INFO: renamed from: k */
    public final C2945u1 f7452k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public C2839q1 f7453l;

    /* JADX INFO: renamed from: m */
    public C2558o0 f7454m;

    /* JADX INFO: renamed from: n */
    public C2652r f7455n;

    /* JADX INFO: renamed from: o */
    public long f7456o;

    public C2839q1(InterfaceC2763g2[] interfaceC2763g2Arr, long j, AbstractC2651q abstractC2651q, C2713o c2713o, C2945u1 c2945u1, C2843r1 c2843r1, C2652r c2652r) {
        this.f7450i = interfaceC2763g2Arr;
        this.f7456o = j;
        this.f7451j = abstractC2651q;
        this.f7452k = c2945u1;
        InterfaceC2530a0.a aVar = c2843r1.f7465a;
        this.f7443b = aVar.f5732a;
        this.f7447f = c2843r1;
        this.f7454m = C2558o0.f5674j;
        this.f7455n = c2652r;
        this.f7444c = new InterfaceC2546i0[interfaceC2763g2Arr.length];
        this.f7449h = new boolean[interfaceC2763g2Arr.length];
        long j2 = c2843r1.f7466b;
        long j3 = c2843r1.f7468d;
        Objects.requireNonNull(c2945u1);
        Pair pair = (Pair) aVar.f5732a;
        Object obj = pair.first;
        InterfaceC2530a0.a aVarM2460b = aVar.m2460b(pair.second);
        C2945u1.c cVar = c2945u1.f7866c.get(obj);
        Objects.requireNonNull(cVar);
        c2945u1.f7871h.add(cVar);
        C2945u1.b bVar = c2945u1.f7870g.get(cVar);
        if (bVar != null) {
            bVar.f7879a.mo2458m(bVar.f7880b);
        }
        cVar.f7884c.add(aVarM2460b);
        InterfaceC2570x interfaceC2570xM2591u = cVar.f7882a.mo2459n(aVarM2460b, c2713o, j2);
        c2945u1.f7865b.put(interfaceC2570xM2591u, cVar);
        c2945u1.m3538d();
        this.f7442a = j3 != -9223372036854775807L ? new C2555n(interfaceC2570xM2591u, true, 0L, j3) : interfaceC2570xM2591u;
    }

    /* JADX INFO: renamed from: a */
    public long m3347a(C2652r c2652r, long j, boolean z2, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z3 = true;
            if (i >= c2652r.f6326a) {
                break;
            }
            boolean[] zArr2 = this.f7449h;
            if (z2 || !c2652r.m2755a(this.f7455n, i)) {
                z3 = false;
            }
            zArr2[i] = z3;
            i++;
        }
        InterfaceC2546i0[] interfaceC2546i0Arr = this.f7444c;
        int i2 = 0;
        while (true) {
            InterfaceC2763g2[] interfaceC2763g2Arr = this.f7450i;
            if (i2 >= interfaceC2763g2Arr.length) {
                break;
            }
            if (((AbstractC2951v0) interfaceC2763g2Arr[i2]).f7889j == -2) {
                interfaceC2546i0Arr[i2] = null;
            }
            i2++;
        }
        m3348b();
        this.f7455n = c2652r;
        m3349c();
        long jMo2489m = this.f7442a.mo2489m(c2652r.f6328c, this.f7449h, this.f7444c, zArr, j);
        InterfaceC2546i0[] interfaceC2546i0Arr2 = this.f7444c;
        int i3 = 0;
        while (true) {
            InterfaceC2763g2[] interfaceC2763g2Arr2 = this.f7450i;
            if (i3 >= interfaceC2763g2Arr2.length) {
                break;
            }
            if (((AbstractC2951v0) interfaceC2763g2Arr2[i3]).f7889j == -2 && this.f7455n.m2756b(i3)) {
                interfaceC2546i0Arr2[i3] = new C2563q();
            }
            i3++;
        }
        this.f7446e = false;
        int i4 = 0;
        while (true) {
            InterfaceC2546i0[] interfaceC2546i0Arr3 = this.f7444c;
            if (i4 >= interfaceC2546i0Arr3.length) {
                return jMo2489m;
            }
            if (interfaceC2546i0Arr3[i4] != null) {
                C1460d.m426D(c2652r.m2756b(i4));
                if (((AbstractC2951v0) this.f7450i[i4]).f7889j != -2) {
                    this.f7446e = true;
                }
            } else {
                C1460d.m426D(c2652r.f6328c[i4] == null);
            }
            i4++;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3348b() {
        if (!m3353g()) {
            return;
        }
        int i = 0;
        while (true) {
            C2652r c2652r = this.f7455n;
            if (i >= c2652r.f6326a) {
                return;
            }
            boolean zM2756b = c2652r.m2756b(i);
            InterfaceC2644j interfaceC2644j = this.f7455n.f6328c[i];
            if (zM2756b && interfaceC2644j != null) {
                interfaceC2644j.mo2725g();
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m3349c() {
        if (!m3353g()) {
            return;
        }
        int i = 0;
        while (true) {
            C2652r c2652r = this.f7455n;
            if (i >= c2652r.f6326a) {
                return;
            }
            boolean zM2756b = c2652r.m2756b(i);
            InterfaceC2644j interfaceC2644j = this.f7455n.f6328c[i];
            if (zM2756b && interfaceC2644j != null) {
                interfaceC2644j.mo2724e();
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: d */
    public long m3350d() {
        if (!this.f7445d) {
            return this.f7447f.f7466b;
        }
        long jMo2493q = this.f7446e ? this.f7442a.mo2493q() : Long.MIN_VALUE;
        return jMo2493q == Long.MIN_VALUE ? this.f7447f.f7469e : jMo2493q;
    }

    /* JADX INFO: renamed from: e */
    public long m3351e() {
        return this.f7447f.f7466b + this.f7456o;
    }

    /* JADX INFO: renamed from: f */
    public boolean m3352f() {
        return this.f7445d && (!this.f7446e || this.f7442a.mo2493q() == Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: g */
    public final boolean m3353g() {
        return this.f7453l == null;
    }

    /* JADX INFO: renamed from: h */
    public void m3354h() {
        m3348b();
        C2945u1 c2945u1 = this.f7452k;
        InterfaceC2570x interfaceC2570x = this.f7442a;
        try {
            if (interfaceC2570x instanceof C2555n) {
                c2945u1.m3542h(((C2555n) interfaceC2570x).f5651j);
            } else {
                c2945u1.m3542h(interfaceC2570x);
            }
        } catch (RuntimeException e) {
            C2750q.m3039b("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    /* JADX INFO: renamed from: i */
    public C2652r m3355i(float f, AbstractC2832o2 abstractC2832o2) throws ExoPlaybackException {
        C2652r c2652rMo2753b = this.f7451j.mo2753b(this.f7450i, this.f7454m, this.f7447f.f7465a, abstractC2832o2);
        for (InterfaceC2644j interfaceC2644j : c2652rMo2753b.f6328c) {
            if (interfaceC2644j != null) {
                interfaceC2644j.mo2726i(f);
            }
        }
        return c2652rMo2753b;
    }

    /* JADX INFO: renamed from: j */
    public void m3356j() {
        InterfaceC2570x interfaceC2570x = this.f7442a;
        if (interfaceC2570x instanceof C2555n) {
            long j = this.f7447f.f7468d;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            C2555n c2555n = (C2555n) interfaceC2570x;
            c2555n.f5655n = 0L;
            c2555n.f5656o = j;
        }
    }
}
