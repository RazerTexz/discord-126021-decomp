package p007b.p225i.p226a.p242c;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.p244p0.C2562c;
import p007b.p225i.p226a.p242c.p262s2.C2868g1;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: renamed from: b.i.a.c.s1 */
/* JADX INFO: compiled from: MediaPeriodQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2847s1 {

    /* JADX INFO: renamed from: a */
    public final AbstractC2832o2.b f7486a = new AbstractC2832o2.b();

    /* JADX INFO: renamed from: b */
    public final AbstractC2832o2.c f7487b = new AbstractC2832o2.c();

    /* JADX INFO: renamed from: c */
    @Nullable
    public final C2868g1 f7488c;

    /* JADX INFO: renamed from: d */
    public final Handler f7489d;

    /* JADX INFO: renamed from: e */
    public long f7490e;

    /* JADX INFO: renamed from: f */
    public int f7491f;

    /* JADX INFO: renamed from: g */
    public boolean f7492g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public C2839q1 f7493h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public C2839q1 f7494i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public C2839q1 f7495j;

    /* JADX INFO: renamed from: k */
    public int f7496k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public Object f7497l;

    /* JADX INFO: renamed from: m */
    public long f7498m;

    public C2847s1(@Nullable C2868g1 c2868g1, Handler handler) {
        this.f7488c = c2868g1;
        this.f7489d = handler;
    }

    /* JADX INFO: renamed from: p */
    public static InterfaceC2530a0.a m3364p(AbstractC2832o2 abstractC2832o2, Object obj, long j, long j2, AbstractC2832o2.b bVar) {
        abstractC2832o2.mo3327h(obj, bVar);
        C2562c c2562c = bVar.f7344p;
        long j3 = bVar.f7341m;
        int i = c2562c.f5684n - 1;
        while (i >= 0) {
            boolean z2 = false;
            if (j != Long.MIN_VALUE) {
                long j4 = c2562c.m2578a(i).f5690k;
                if (j4 != Long.MIN_VALUE ? j < j4 : !(j3 != -9223372036854775807L && j >= j3)) {
                    z2 = true;
                }
            }
            if (!z2) {
                break;
            }
            i--;
        }
        if (i < 0 || !c2562c.m2578a(i).m2581b()) {
            i = -1;
        }
        if (i == -1) {
            return new InterfaceC2530a0.a(obj, j2, bVar.m3333b(j));
        }
        return new InterfaceC2530a0.a(obj, i, bVar.m3335d(i), j2);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C2839q1 m3365a() {
        C2839q1 c2839q1 = this.f7493h;
        if (c2839q1 == null) {
            return null;
        }
        if (c2839q1 == this.f7494i) {
            this.f7494i = c2839q1.f7453l;
        }
        c2839q1.m3354h();
        int i = this.f7496k - 1;
        this.f7496k = i;
        if (i == 0) {
            this.f7495j = null;
            C2839q1 c2839q2 = this.f7493h;
            this.f7497l = c2839q2.f7443b;
            this.f7498m = c2839q2.f7447f.f7465a.f5735d;
        }
        this.f7493h = this.f7493h.f7453l;
        m3376l();
        return this.f7493h;
    }

    /* JADX INFO: renamed from: b */
    public void m3366b() {
        if (this.f7496k == 0) {
            return;
        }
        C2839q1 c2839q1 = this.f7493h;
        C1460d.m438H(c2839q1);
        C2839q1 c2839q2 = c2839q1;
        this.f7497l = c2839q2.f7443b;
        this.f7498m = c2839q2.f7447f.f7465a.f5735d;
        while (c2839q2 != null) {
            c2839q2.m3354h();
            c2839q2 = c2839q2.f7453l;
        }
        this.f7493h = null;
        this.f7495j = null;
        this.f7494i = null;
        this.f7496k = 0;
        m3376l();
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public final C2843r1 m3367c(AbstractC2832o2 abstractC2832o2, C2839q1 c2839q1, long j) {
        long j2;
        C2843r1 c2843r1 = c2839q1.f7447f;
        long j3 = (c2839q1.f7456o + c2843r1.f7469e) - j;
        long j4 = 0;
        if (c2843r1.f7471g) {
            int iM3325d = abstractC2832o2.m3325d(abstractC2832o2.mo2554b(c2843r1.f7465a.f5732a), this.f7486a, this.f7487b, this.f7491f, this.f7492g);
            if (iM3325d == -1) {
                return null;
            }
            int i = abstractC2832o2.mo2513g(iM3325d, this.f7486a, true).f7340l;
            Object obj = this.f7486a.f7339k;
            long j5 = c2843r1.f7465a.f5735d;
            if (abstractC2832o2.m3330n(i, this.f7487b).f7350B == iM3325d) {
                Pair<Object, Long> pairM3329k = abstractC2832o2.m3329k(this.f7487b, this.f7486a, i, -9223372036854775807L, Math.max(0L, j3));
                if (pairM3329k == null) {
                    return null;
                }
                obj = pairM3329k.first;
                long jLongValue = ((Long) pairM3329k.second).longValue();
                C2839q1 c2839q2 = c2839q1.f7453l;
                if (c2839q2 == null || !c2839q2.f7443b.equals(obj)) {
                    j5 = this.f7490e;
                    this.f7490e = 1 + j5;
                } else {
                    j5 = c2839q2.f7447f.f7465a.f5735d;
                }
                j2 = jLongValue;
                j4 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return m3368d(abstractC2832o2, m3364p(abstractC2832o2, obj, j2, j5, this.f7486a), j4, j2);
        }
        InterfaceC2530a0.a aVar = c2843r1.f7465a;
        abstractC2832o2.mo3327h(aVar.f5732a, this.f7486a);
        if (!aVar.m2593a()) {
            int iM3335d = this.f7486a.m3335d(aVar.f5736e);
            if (iM3335d != this.f7486a.f7344p.m2578a(aVar.f5736e).f5691l) {
                return m3369e(abstractC2832o2, aVar.f5732a, aVar.f5736e, iM3335d, c2843r1.f7469e, aVar.f5735d);
            }
            return m3370f(abstractC2832o2, aVar.f5732a, m3371g(abstractC2832o2, aVar.f5732a, aVar.f5736e), c2843r1.f7469e, aVar.f5735d);
        }
        int i2 = aVar.f5733b;
        int i3 = this.f7486a.f7344p.m2578a(i2).f5691l;
        if (i3 == -1) {
            return null;
        }
        int iM2580a = this.f7486a.f7344p.m2578a(i2).m2580a(aVar.f5734c);
        if (iM2580a < i3) {
            return m3369e(abstractC2832o2, aVar.f5732a, i2, iM2580a, c2843r1.f7467c, aVar.f5735d);
        }
        long jLongValue2 = c2843r1.f7467c;
        if (jLongValue2 == -9223372036854775807L) {
            AbstractC2832o2.c cVar = this.f7487b;
            AbstractC2832o2.b bVar = this.f7486a;
            Pair<Object, Long> pairM3329k2 = abstractC2832o2.m3329k(cVar, bVar, bVar.f7340l, -9223372036854775807L, Math.max(0L, j3));
            if (pairM3329k2 == null) {
                return null;
            }
            jLongValue2 = ((Long) pairM3329k2.second).longValue();
        }
        return m3370f(abstractC2832o2, aVar.f5732a, Math.max(m3371g(abstractC2832o2, aVar.f5732a, aVar.f5733b), jLongValue2), c2843r1.f7467c, aVar.f5735d);
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public final C2843r1 m3368d(AbstractC2832o2 abstractC2832o2, InterfaceC2530a0.a aVar, long j, long j2) {
        abstractC2832o2.mo3327h(aVar.f5732a, this.f7486a);
        return aVar.m2593a() ? m3369e(abstractC2832o2, aVar.f5732a, aVar.f5733b, aVar.f5734c, j, aVar.f5735d) : m3370f(abstractC2832o2, aVar.f5732a, j2, j, aVar.f5735d);
    }

    /* JADX INFO: renamed from: e */
    public final C2843r1 m3369e(AbstractC2832o2 abstractC2832o2, Object obj, int i, int i2, long j, long j2) {
        InterfaceC2530a0.a aVar = new InterfaceC2530a0.a(obj, i, i2, j2);
        long jM3332a = abstractC2832o2.mo3327h(obj, this.f7486a).m3332a(i, i2);
        long j3 = i2 == this.f7486a.f7344p.m2578a(i).m2580a(-1) ? this.f7486a.f7344p.f5685o : 0L;
        return new C2843r1(aVar, (jM3332a == -9223372036854775807L || j3 < jM3332a) ? j3 : Math.max(0L, jM3332a - 1), j, -9223372036854775807L, jM3332a, this.f7486a.f7344p.m2578a(i).f5696q, false, false, false);
    }

    /* JADX INFO: renamed from: f */
    public final C2843r1 m3370f(AbstractC2832o2 abstractC2832o2, Object obj, long j, long j2, long j3) {
        long jMax = j;
        abstractC2832o2.mo3327h(obj, this.f7486a);
        int iM3333b = this.f7486a.m3333b(jMax);
        InterfaceC2530a0.a aVar = new InterfaceC2530a0.a(obj, j3, iM3333b);
        boolean zM3373i = m3373i(aVar);
        boolean zM3375k = m3375k(abstractC2832o2, aVar);
        boolean zM3374j = m3374j(abstractC2832o2, aVar, zM3373i);
        boolean z2 = iM3333b != -1 && this.f7486a.m3336e(iM3333b);
        long jM3334c = iM3333b != -1 ? this.f7486a.m3334c(iM3333b) : -9223372036854775807L;
        long j4 = (jM3334c == -9223372036854775807L || jM3334c == Long.MIN_VALUE) ? this.f7486a.f7341m : jM3334c;
        if (j4 != -9223372036854775807L && jMax >= j4) {
            jMax = Math.max(0L, j4 - 1);
        }
        return new C2843r1(aVar, jMax, j2, jM3334c, j4, z2, zM3373i, zM3375k, zM3374j);
    }

    /* JADX INFO: renamed from: g */
    public final long m3371g(AbstractC2832o2 abstractC2832o2, Object obj, int i) {
        abstractC2832o2.mo3327h(obj, this.f7486a);
        long j = this.f7486a.f7344p.m2578a(i).f5690k;
        return j == Long.MIN_VALUE ? this.f7486a.f7341m : j + this.f7486a.f7344p.m2578a(i).f5695p;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX INFO: renamed from: h */
    public C2843r1 m3372h(AbstractC2832o2 abstractC2832o2, C2843r1 c2843r1) {
        long jM3332a;
        long j;
        int i;
        boolean zM3336e;
        int i2;
        InterfaceC2530a0.a aVar = c2843r1.f7465a;
        boolean zM3373i = m3373i(aVar);
        boolean zM3375k = m3375k(abstractC2832o2, aVar);
        boolean zM3374j = m3374j(abstractC2832o2, aVar, zM3373i);
        abstractC2832o2.mo3327h(c2843r1.f7465a.f5732a, this.f7486a);
        long jM3334c = (aVar.m2593a() || (i2 = aVar.f5736e) == -1) ? -9223372036854775807L : this.f7486a.m3334c(i2);
        if (!aVar.m2593a()) {
            if (jM3334c == -9223372036854775807L || jM3334c == Long.MIN_VALUE) {
                jM3332a = this.f7486a.f7341m;
            } else {
                j = jM3334c;
            }
            if (aVar.m2593a()) {
                zM3336e = this.f7486a.m3336e(aVar.f5733b);
            } else {
                i = aVar.f5736e;
                if (i == -1 && this.f7486a.m3336e(i)) {
                    zM3336e = true;
                } else {
                    zM3336e = false;
                }
            }
            return new C2843r1(aVar, c2843r1.f7466b, c2843r1.f7467c, jM3334c, j, zM3336e, zM3373i, zM3375k, zM3374j);
        }
        jM3332a = this.f7486a.m3332a(aVar.f5733b, aVar.f5734c);
        j = jM3332a;
        if (aVar.m2593a()) {
            zM3336e = this.f7486a.m3336e(aVar.f5733b);
        } else {
            i = aVar.f5736e;
            if (i == -1) {
                zM3336e = false;
            } else {
                zM3336e = false;
            }
        }
        return new C2843r1(aVar, c2843r1.f7466b, c2843r1.f7467c, jM3334c, j, zM3336e, zM3373i, zM3375k, zM3374j);
    }

    /* JADX INFO: renamed from: i */
    public final boolean m3373i(InterfaceC2530a0.a aVar) {
        return !aVar.m2593a() && aVar.f5736e == -1;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m3374j(AbstractC2832o2 abstractC2832o2, InterfaceC2530a0.a aVar, boolean z2) {
        int iMo2554b = abstractC2832o2.mo2554b(aVar.f5732a);
        if (abstractC2832o2.m3330n(abstractC2832o2.m3326f(iMo2554b, this.f7486a).f7340l, this.f7487b).f7361v) {
            return false;
        }
        return (abstractC2832o2.m3325d(iMo2554b, this.f7486a, this.f7487b, this.f7491f, this.f7492g) == -1) && z2;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m3375k(AbstractC2832o2 abstractC2832o2, InterfaceC2530a0.a aVar) {
        if (m3373i(aVar)) {
            return abstractC2832o2.m3330n(abstractC2832o2.mo3327h(aVar.f5732a, this.f7486a).f7340l, this.f7487b).f7351C == abstractC2832o2.mo2554b(aVar.f5732a);
        }
        return false;
    }

    /* JADX INFO: renamed from: l */
    public final void m3376l() {
        if (this.f7488c != null) {
            AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
            final AbstractC4523p.a aVar = new AbstractC4523p.a();
            for (C2839q1 c2839q1 = this.f7493h; c2839q1 != null; c2839q1 = c2839q1.f7453l) {
                aVar.m6271b(c2839q1.f7447f.f7465a);
            }
            C2839q1 c2839q2 = this.f7494i;
            final InterfaceC2530a0.a aVar2 = c2839q2 == null ? null : c2839q2.f7447f.f7465a;
            this.f7489d.post(new Runnable() { // from class: b.i.a.c.m0
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    C2847s1 c2847s1 = this.f7243j;
                    AbstractC4523p.a aVar3 = aVar;
                    InterfaceC2530a0.a aVar4 = aVar2;
                    C2868g1 c2868g1 = c2847s1.f7488c;
                    AbstractC4523p abstractC4523pM6272c = aVar3.m6272c();
                    C2868g1.a aVar5 = c2868g1.f7550m;
                    InterfaceC3128y1 interfaceC3128y1 = c2868g1.f7553p;
                    Objects.requireNonNull(interfaceC3128y1);
                    Objects.requireNonNull(aVar5);
                    aVar5.f7557b = AbstractC4523p.m6264n(abstractC4523pM6272c);
                    if (!abstractC4523pM6272c.isEmpty()) {
                        aVar5.f7560e = (InterfaceC2530a0.a) abstractC4523pM6272c.get(0);
                        Objects.requireNonNull(aVar4);
                        aVar5.f7561f = aVar4;
                    }
                    if (aVar5.f7559d == null) {
                        aVar5.f7559d = C2868g1.a.m3388b(interfaceC3128y1, aVar5.f7557b, aVar5.f7560e, aVar5.f7556a);
                    }
                    aVar5.m3391d(interfaceC3128y1.mo2888K());
                }
            });
        }
    }

    /* JADX INFO: renamed from: m */
    public void m3377m(long j) {
        C2839q1 c2839q1 = this.f7495j;
        if (c2839q1 != null) {
            C1460d.m426D(c2839q1.m3353g());
            if (c2839q1.f7445d) {
                c2839q1.f7442a.mo2495s(j - c2839q1.f7456o);
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public boolean m3378n(C2839q1 c2839q1) {
        boolean z2 = false;
        C1460d.m426D(c2839q1 != null);
        if (c2839q1.equals(this.f7495j)) {
            return false;
        }
        this.f7495j = c2839q1;
        while (true) {
            c2839q1 = c2839q1.f7453l;
            if (c2839q1 == null) {
                break;
            }
            if (c2839q1 == this.f7494i) {
                this.f7494i = this.f7493h;
                z2 = true;
            }
            c2839q1.m3354h();
            this.f7496k--;
        }
        C2839q1 c2839q2 = this.f7495j;
        if (c2839q2.f7453l != null) {
            c2839q2.m3348b();
            c2839q2.f7453l = null;
            c2839q2.m3349c();
        }
        m3376l();
        return z2;
    }

    /* JADX INFO: renamed from: o */
    public InterfaceC2530a0.a m3379o(AbstractC2832o2 abstractC2832o2, Object obj, long j) {
        long j2;
        int iMo2554b;
        int i = abstractC2832o2.mo3327h(obj, this.f7486a).f7340l;
        Object obj2 = this.f7497l;
        if (obj2 == null || (iMo2554b = abstractC2832o2.mo2554b(obj2)) == -1 || abstractC2832o2.m3326f(iMo2554b, this.f7486a).f7340l != i) {
            for (C2839q1 c2839q1 = this.f7493h; c2839q1 != null; c2839q1 = c2839q1.f7453l) {
                if (c2839q1.f7443b.equals(obj)) {
                    j2 = c2839q1.f7447f.f7465a.f5735d;
                }
            }
            for (C2839q1 c2839q2 = this.f7493h; c2839q2 != null; c2839q2 = c2839q2.f7453l) {
                int iMo2554b2 = abstractC2832o2.mo2554b(c2839q2.f7443b);
                if (iMo2554b2 != -1 && abstractC2832o2.m3326f(iMo2554b2, this.f7486a).f7340l == i) {
                    j2 = c2839q2.f7447f.f7465a.f5735d;
                }
            }
            j2 = this.f7490e;
            this.f7490e = 1 + j2;
            if (this.f7493h == null) {
                this.f7497l = obj;
                this.f7498m = j2;
            }
        } else {
            j2 = this.f7498m;
        }
        return m3364p(abstractC2832o2, obj, j, j2, this.f7486a);
    }

    /* JADX INFO: renamed from: q */
    public final boolean m3380q(AbstractC2832o2 abstractC2832o2) {
        C2839q1 c2839q1;
        C2839q1 c2839q2 = this.f7493h;
        if (c2839q2 == null) {
            return true;
        }
        int iMo2554b = abstractC2832o2.mo2554b(c2839q2.f7443b);
        while (true) {
            iMo2554b = abstractC2832o2.m3325d(iMo2554b, this.f7486a, this.f7487b, this.f7491f, this.f7492g);
            while (true) {
                c2839q1 = c2839q2.f7453l;
                if (c2839q1 == null || c2839q2.f7447f.f7471g) {
                    break;
                }
                c2839q2 = c2839q1;
            }
            if (iMo2554b == -1 || c2839q1 == null || abstractC2832o2.mo2554b(c2839q1.f7443b) != iMo2554b) {
                break;
            }
            c2839q2 = c2839q1;
        }
        boolean zM3378n = m3378n(c2839q2);
        c2839q2.f7447f = m3372h(abstractC2832o2, c2839q2.f7447f);
        return !zM3378n;
    }

    /* JADX INFO: renamed from: r */
    public boolean m3381r(AbstractC2832o2 abstractC2832o2, long j, long j2) {
        boolean zM3378n;
        C2843r1 c2843r1M3372h;
        C2839q1 c2839q1 = this.f7493h;
        C2839q1 c2839q2 = null;
        while (c2839q1 != null) {
            C2843r1 c2843r1 = c2839q1.f7447f;
            if (c2839q2 != null) {
                C2843r1 c2843r1M3367c = m3367c(abstractC2832o2, c2839q2, j);
                if (c2843r1M3367c == null) {
                    zM3378n = m3378n(c2839q2);
                } else {
                    if (c2843r1.f7466b == c2843r1M3367c.f7466b && c2843r1.f7465a.equals(c2843r1M3367c.f7465a)) {
                        c2843r1M3372h = c2843r1M3367c;
                    } else {
                        zM3378n = m3378n(c2839q2);
                    }
                }
                return !zM3378n;
            }
            c2843r1M3372h = m3372h(abstractC2832o2, c2843r1);
            c2839q1.f7447f = c2843r1M3372h.m3360a(c2843r1.f7467c);
            long j3 = c2843r1.f7469e;
            if (!(j3 == -9223372036854775807L || j3 == c2843r1M3372h.f7469e)) {
                c2839q1.m3356j();
                long j4 = c2843r1M3372h.f7469e;
                return (m3378n(c2839q1) || (c2839q1 == this.f7494i && !c2839q1.f7447f.f7470f && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j4 > (-9223372036854775807L) ? 1 : (j4 == (-9223372036854775807L) ? 0 : -1)) == 0 ? RecyclerView.FOREVER_NS : j4 + c2839q1.f7456o) ? 1 : (j2 == ((j4 > (-9223372036854775807L) ? 1 : (j4 == (-9223372036854775807L) ? 0 : -1)) == 0 ? RecyclerView.FOREVER_NS : j4 + c2839q1.f7456o) ? 0 : -1)) >= 0))) ? false : true;
            }
            c2839q2 = c2839q1;
            c2839q1 = c2839q1.f7453l;
        }
        return true;
    }
}
