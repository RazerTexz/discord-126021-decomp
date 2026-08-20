package p007b.p225i.p226a.p242c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2548j0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x;
import p007b.p225i.p226a.p242c.p245b3.C2589m;
import p007b.p225i.p226a.p242c.p255c3.AbstractC2651q;
import p007b.p225i.p226a.p242c.p255c3.C2652r;
import p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f;
import p007b.p225i.p226a.p242c.p259f3.C2732b0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p259f3.C2759z;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2748o;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s;
import p007b.p225i.p226a.p242c.p262s2.C2868g1;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4519n;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4507h;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.h1 */
/* JADX INFO: compiled from: ExoPlayerImplInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2803h1 implements Handler.Callback, InterfaceC2570x.a, C2945u1.d, C2527a1.a, C2576b2.a {

    /* JADX INFO: renamed from: A */
    public final e f7052A;

    /* JADX INFO: renamed from: B */
    public final C2847s1 f7053B;

    /* JADX INFO: renamed from: C */
    public final C2945u1 f7054C;

    /* JADX INFO: renamed from: D */
    public final InterfaceC2823m1 f7055D;

    /* JADX INFO: renamed from: E */
    public final long f7056E;

    /* JADX INFO: renamed from: F */
    public C2812j2 f7057F;

    /* JADX INFO: renamed from: G */
    public C2964w1 f7058G;

    /* JADX INFO: renamed from: H */
    public d f7059H;

    /* JADX INFO: renamed from: I */
    public boolean f7060I;

    /* JADX INFO: renamed from: J */
    public boolean f7061J;

    /* JADX INFO: renamed from: K */
    public boolean f7062K;

    /* JADX INFO: renamed from: L */
    public boolean f7063L;

    /* JADX INFO: renamed from: M */
    public boolean f7064M;

    /* JADX INFO: renamed from: N */
    public int f7065N;

    /* JADX INFO: renamed from: O */
    public boolean f7066O;

    /* JADX INFO: renamed from: P */
    public boolean f7067P;

    /* JADX INFO: renamed from: Q */
    public boolean f7068Q;

    /* JADX INFO: renamed from: R */
    public boolean f7069R;

    /* JADX INFO: renamed from: S */
    public int f7070S;

    /* JADX INFO: renamed from: T */
    @Nullable
    public g f7071T;

    /* JADX INFO: renamed from: U */
    public long f7072U;

    /* JADX INFO: renamed from: V */
    public int f7073V;

    /* JADX INFO: renamed from: W */
    public boolean f7074W;

    /* JADX INFO: renamed from: X */
    @Nullable
    public ExoPlaybackException f7075X;

    /* JADX INFO: renamed from: j */
    public final InterfaceC2728f2[] f7076j;

    /* JADX INFO: renamed from: k */
    public final Set<InterfaceC2728f2> f7077k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC2763g2[] f7078l;

    /* JADX INFO: renamed from: m */
    public final AbstractC2651q f7079m;

    /* JADX INFO: renamed from: n */
    public final C2652r f7080n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC2827n1 f7081o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC2704f f7082p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC2748o f7083q;

    /* JADX INFO: renamed from: r */
    public final HandlerThread f7084r;

    /* JADX INFO: renamed from: s */
    public final Looper f7085s;

    /* JADX INFO: renamed from: t */
    public final AbstractC2832o2.c f7086t;

    /* JADX INFO: renamed from: u */
    public final AbstractC2832o2.b f7087u;

    /* JADX INFO: renamed from: v */
    public final long f7088v;

    /* JADX INFO: renamed from: w */
    public final boolean f7089w;

    /* JADX INFO: renamed from: x */
    public final C2527a1 f7090x;

    /* JADX INFO: renamed from: y */
    public final ArrayList<c> f7091y;

    /* JADX INFO: renamed from: z */
    public final InterfaceC2740g f7092z;

    /* JADX INFO: renamed from: b.i.a.c.h1$a */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final List<C2945u1.c> f7093a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC2550k0 f7094b;

        /* JADX INFO: renamed from: c */
        public final int f7095c;

        /* JADX INFO: renamed from: d */
        public final long f7096d;

        public a(List list, InterfaceC2550k0 interfaceC2550k0, int i, long j, C2762g1 c2762g1) {
            this.f7093a = list;
            this.f7094b = interfaceC2550k0;
            this.f7095c = i;
            this.f7096d = j;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$b */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static class b {
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$c */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: j */
        public final C2576b2 f7097j;

        /* JADX INFO: renamed from: k */
        public int f7098k;

        /* JADX INFO: renamed from: l */
        public long f7099l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public Object f7100m;

        /* JADX WARN: Code duplicated, block: B:13:0x0017  */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            Object obj = this.f7100m;
            int i = 1;
            if ((obj == null) != (cVar2.f7100m == null)) {
                if (obj != null) {
                    i = -1;
                }
            } else {
                if (obj == null) {
                    return 0;
                }
                int i2 = this.f7098k - cVar2.f7098k;
                if (i2 != 0) {
                    return i2;
                }
                long j = this.f7099l;
                long j2 = cVar2.f7099l;
                int i3 = C2738e0.f6708a;
                if (j < j2) {
                    i = -1;
                } else if (j == j2) {
                    i = 0;
                }
            }
            return i;
        }

        /* JADX INFO: renamed from: f */
        public void m3270f(int i, long j, Object obj) {
            this.f7098k = i;
            this.f7099l = j;
            this.f7100m = obj;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$d */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public boolean f7101a;

        /* JADX INFO: renamed from: b */
        public C2964w1 f7102b;

        /* JADX INFO: renamed from: c */
        public int f7103c;

        /* JADX INFO: renamed from: d */
        public boolean f7104d;

        /* JADX INFO: renamed from: e */
        public int f7105e;

        /* JADX INFO: renamed from: f */
        public boolean f7106f;

        /* JADX INFO: renamed from: g */
        public int f7107g;

        public d(C2964w1 c2964w1) {
            this.f7102b = c2964w1;
        }

        /* JADX INFO: renamed from: a */
        public void m3271a(int i) {
            this.f7101a |= i > 0;
            this.f7103c += i;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$e */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public interface e {
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$f */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class f {

        /* JADX INFO: renamed from: a */
        public final InterfaceC2530a0.a f7108a;

        /* JADX INFO: renamed from: b */
        public final long f7109b;

        /* JADX INFO: renamed from: c */
        public final long f7110c;

        /* JADX INFO: renamed from: d */
        public final boolean f7111d;

        /* JADX INFO: renamed from: e */
        public final boolean f7112e;

        /* JADX INFO: renamed from: f */
        public final boolean f7113f;

        public f(InterfaceC2530a0.a aVar, long j, long j2, boolean z2, boolean z3, boolean z4) {
            this.f7108a = aVar;
            this.f7109b = j;
            this.f7110c = j2;
            this.f7111d = z2;
            this.f7112e = z3;
            this.f7113f = z4;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$g */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class g {

        /* JADX INFO: renamed from: a */
        public final AbstractC2832o2 f7114a;

        /* JADX INFO: renamed from: b */
        public final int f7115b;

        /* JADX INFO: renamed from: c */
        public final long f7116c;

        public g(AbstractC2832o2 abstractC2832o2, int i, long j) {
            this.f7114a = abstractC2832o2;
            this.f7115b = i;
            this.f7116c = j;
        }
    }

    public C2803h1(InterfaceC2728f2[] interfaceC2728f2Arr, AbstractC2651q abstractC2651q, C2652r c2652r, InterfaceC2827n1 interfaceC2827n1, InterfaceC2704f interfaceC2704f, int i, boolean z2, @Nullable C2868g1 c2868g1, C2812j2 c2812j2, InterfaceC2823m1 interfaceC2823m1, long j, boolean z3, Looper looper, InterfaceC2740g interfaceC2740g, e eVar) {
        this.f7052A = eVar;
        this.f7076j = interfaceC2728f2Arr;
        this.f7079m = abstractC2651q;
        this.f7080n = c2652r;
        this.f7081o = interfaceC2827n1;
        this.f7082p = interfaceC2704f;
        this.f7065N = i;
        this.f7066O = z2;
        this.f7057F = c2812j2;
        this.f7055D = interfaceC2823m1;
        this.f7056E = j;
        this.f7061J = z3;
        this.f7092z = interfaceC2740g;
        this.f7088v = interfaceC2827n1.mo3310b();
        this.f7089w = interfaceC2827n1.mo3309a();
        C2964w1 c2964w1M3561h = C2964w1.m3561h(c2652r);
        this.f7058G = c2964w1M3561h;
        this.f7059H = new d(c2964w1M3561h);
        this.f7078l = new InterfaceC2763g2[interfaceC2728f2Arr.length];
        for (int i2 = 0; i2 < interfaceC2728f2Arr.length; i2++) {
            interfaceC2728f2Arr[i2].mo2932f(i2);
            this.f7078l[i2] = interfaceC2728f2Arr[i2].mo2938m();
        }
        this.f7090x = new C2527a1(this, interfaceC2740g);
        this.f7091y = new ArrayList<>();
        this.f7077k = C4507h.m6240c();
        this.f7086t = new AbstractC2832o2.c();
        this.f7087u = new AbstractC2832o2.b();
        abstractC2651q.f6325a = interfaceC2704f;
        this.f7074W = true;
        Handler handler = new Handler(looper);
        this.f7053B = new C2847s1(c2868g1, handler);
        this.f7054C = new C2945u1(this, c2868g1, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f7084r = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f7085s = looper2;
        this.f7083q = interfaceC2740g.mo2950b(looper2, this);
    }

    /* JADX INFO: renamed from: K */
    public static boolean m3206K(c cVar, AbstractC2832o2 abstractC2832o2, AbstractC2832o2 abstractC2832o3, int i, boolean z2, AbstractC2832o2.c cVar2, AbstractC2832o2.b bVar) {
        Object obj = cVar.f7100m;
        if (obj == null) {
            Objects.requireNonNull(cVar.f7097j);
            Objects.requireNonNull(cVar.f7097j);
            long jM2981B = C2738e0.m2981B(-9223372036854775807L);
            C2576b2 c2576b2 = cVar.f7097j;
            Pair<Object, Long> pairM3207M = m3207M(abstractC2832o2, new g(c2576b2.f5745d, c2576b2.f5749h, jM2981B), false, i, z2, cVar2, bVar);
            if (pairM3207M == null) {
                return false;
            }
            cVar.m3270f(abstractC2832o2.mo2554b(pairM3207M.first), ((Long) pairM3207M.second).longValue(), pairM3207M.first);
            Objects.requireNonNull(cVar.f7097j);
            return true;
        }
        int iMo2554b = abstractC2832o2.mo2554b(obj);
        if (iMo2554b == -1) {
            return false;
        }
        Objects.requireNonNull(cVar.f7097j);
        cVar.f7098k = iMo2554b;
        abstractC2832o3.mo3327h(cVar.f7100m, bVar);
        if (bVar.f7343o && abstractC2832o3.m3330n(bVar.f7340l, cVar2).f7350B == abstractC2832o3.mo2554b(cVar.f7100m)) {
            Pair<Object, Long> pairM3328j = abstractC2832o2.m3328j(cVar2, bVar, abstractC2832o2.mo3327h(cVar.f7100m, bVar).f7340l, cVar.f7099l + bVar.f7342n);
            cVar.m3270f(abstractC2832o2.mo2554b(pairM3328j.first), ((Long) pairM3328j.second).longValue(), pairM3328j.first);
        }
        return true;
    }

    @Nullable
    /* JADX INFO: renamed from: M */
    public static Pair<Object, Long> m3207M(AbstractC2832o2 abstractC2832o2, g gVar, boolean z2, int i, boolean z3, AbstractC2832o2.c cVar, AbstractC2832o2.b bVar) {
        Object objM3208N;
        AbstractC2832o2 abstractC2832o3 = gVar.f7114a;
        if (abstractC2832o2.m3331q()) {
            return null;
        }
        AbstractC2832o2 abstractC2832o4 = abstractC2832o3.m3331q() ? abstractC2832o2 : abstractC2832o3;
        try {
            Pair<Object, Long> pairM3328j = abstractC2832o4.m3328j(cVar, bVar, gVar.f7115b, gVar.f7116c);
            if (abstractC2832o2.equals(abstractC2832o4)) {
                return pairM3328j;
            }
            if (abstractC2832o2.mo2554b(pairM3328j.first) != -1) {
                return (abstractC2832o4.mo3327h(pairM3328j.first, bVar).f7343o && abstractC2832o4.m3330n(bVar.f7340l, cVar).f7350B == abstractC2832o4.mo2554b(pairM3328j.first)) ? abstractC2832o2.m3328j(cVar, bVar, abstractC2832o2.mo3327h(pairM3328j.first, bVar).f7340l, gVar.f7116c) : pairM3328j;
            }
            if (z2 && (objM3208N = m3208N(cVar, bVar, i, z3, pairM3328j.first, abstractC2832o4, abstractC2832o2)) != null) {
                return abstractC2832o2.m3328j(cVar, bVar, abstractC2832o2.mo3327h(objM3208N, bVar).f7340l, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    @Nullable
    /* JADX INFO: renamed from: N */
    public static Object m3208N(AbstractC2832o2.c cVar, AbstractC2832o2.b bVar, int i, boolean z2, Object obj, AbstractC2832o2 abstractC2832o2, AbstractC2832o2 abstractC2832o3) {
        int iMo2554b = abstractC2832o2.mo2554b(obj);
        int iMo2555i = abstractC2832o2.mo2555i();
        int iM3325d = iMo2554b;
        int iMo2554b2 = -1;
        for (int i2 = 0; i2 < iMo2555i && iMo2554b2 == -1; i2++) {
            iM3325d = abstractC2832o2.m3325d(iM3325d, bVar, cVar, i, z2);
            if (iM3325d == -1) {
                break;
            }
            iMo2554b2 = abstractC2832o3.mo2554b(abstractC2832o2.mo2556m(iM3325d));
        }
        if (iMo2554b2 == -1) {
            return null;
        }
        return abstractC2832o3.mo2556m(iMo2554b2);
    }

    /* JADX INFO: renamed from: i */
    public static C2811j1[] m3209i(InterfaceC2644j interfaceC2644j) {
        int length = interfaceC2644j != null ? interfaceC2644j.length() : 0;
        C2811j1[] c2811j1Arr = new C2811j1[length];
        for (int i = 0; i < length; i++) {
            c2811j1Arr[i] = interfaceC2644j.mo2729d(i);
        }
        return c2811j1Arr;
    }

    /* JADX INFO: renamed from: w */
    public static boolean m3210w(InterfaceC2728f2 interfaceC2728f2) {
        return interfaceC2728f2.getState() != 0;
    }

    /* JADX INFO: renamed from: y */
    public static boolean m3211y(C2964w1 c2964w1, AbstractC2832o2.b bVar) {
        InterfaceC2530a0.a aVar = c2964w1.f7948c;
        AbstractC2832o2 abstractC2832o2 = c2964w1.f7947b;
        return abstractC2832o2.m3331q() || abstractC2832o2.mo3327h(aVar.f5732a, bVar).f7343o;
    }

    /* JADX INFO: renamed from: A */
    public final void m3212A() {
        d dVar = this.f7059H;
        C2964w1 c2964w1 = this.f7058G;
        boolean z2 = dVar.f7101a | (dVar.f7102b != c2964w1);
        dVar.f7101a = z2;
        dVar.f7102b = c2964w1;
        if (z2) {
            C2727f1 c2727f1 = ((C2962w) this.f7052A).f7945a;
            c2727f1.f6664g.mo2955b(new RunnableC2632c0(c2727f1, dVar));
            this.f7059H = new d(this.f7058G);
        }
    }

    /* JADX INFO: renamed from: B */
    public final void m3213B() throws Throwable {
        m3263r(this.f7054C.m3537c(), true);
    }

    /* JADX INFO: renamed from: C */
    public final void m3214C(b bVar) throws Throwable {
        this.f7059H.m3271a(1);
        C2945u1 c2945u1 = this.f7054C;
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(c2945u1);
        C1460d.m531j(c2945u1.m3539e() >= 0);
        c2945u1.f7872i = null;
        m3263r(c2945u1.m3537c(), false);
    }

    /* JADX INFO: renamed from: D */
    public final void m3215D() {
        this.f7059H.m3271a(1);
        m3219H(false, false, false, true);
        this.f7081o.mo3311c();
        m3244f0(this.f7058G.f7947b.m3331q() ? 4 : 2);
        C2945u1 c2945u1 = this.f7054C;
        InterfaceC2680a0 interfaceC2680a0Mo2844c = this.f7082p.mo2844c();
        C1460d.m426D(!c2945u1.f7873j);
        c2945u1.f7874k = interfaceC2680a0Mo2844c;
        for (int i = 0; i < c2945u1.f7864a.size(); i++) {
            C2945u1.c cVar = c2945u1.f7864a.get(i);
            c2945u1.m3541g(cVar);
            c2945u1.f7871h.add(cVar);
        }
        c2945u1.f7873j = true;
        this.f7083q.mo2959f(2);
    }

    /* JADX INFO: renamed from: E */
    public final void m3216E() {
        m3219H(true, false, true, false);
        this.f7081o.mo3313e();
        m3244f0(1);
        this.f7084r.quit();
        synchronized (this) {
            this.f7060I = true;
            notifyAll();
        }
    }

    /* JADX INFO: renamed from: F */
    public final void m3217F(int i, int i2, InterfaceC2550k0 interfaceC2550k0) throws Throwable {
        this.f7059H.m3271a(1);
        C2945u1 c2945u1 = this.f7054C;
        Objects.requireNonNull(c2945u1);
        C1460d.m531j(i >= 0 && i <= i2 && i2 <= c2945u1.m3539e());
        c2945u1.f7872i = interfaceC2550k0;
        c2945u1.m3543i(i, i2);
        m3263r(c2945u1.m3537c(), false);
    }

    /* JADX INFO: renamed from: G */
    public final void m3218G() throws ExoPlaybackException {
        boolean z2;
        float f2 = this.f7090x.mo2416c().f8027k;
        C2847s1 c2847s1 = this.f7053B;
        C2839q1 c2839q1 = c2847s1.f7493h;
        C2839q1 c2839q2 = c2847s1.f7494i;
        boolean z3 = true;
        for (C2839q1 c2839q3 = c2839q1; c2839q3 != null && c2839q3.f7445d; c2839q3 = c2839q3.f7453l) {
            C2652r c2652rM3355i = c2839q3.m3355i(f2, this.f7058G.f7947b);
            C2652r c2652r = c2839q3.f7455n;
            if (c2652r == null || c2652r.f6328c.length != c2652rM3355i.f6328c.length) {
                z2 = false;
                break;
            }
            int i = 0;
            while (true) {
                if (i >= c2652rM3355i.f6328c.length) {
                    z2 = true;
                    break;
                } else {
                    if (!c2652rM3355i.m2755a(c2652r, i)) {
                        z2 = false;
                        break;
                    }
                    i++;
                }
            }
            if (!z2) {
                if (z3) {
                    C2847s1 c2847s2 = this.f7053B;
                    C2839q1 c2839q4 = c2847s2.f7493h;
                    boolean zM3378n = c2847s2.m3378n(c2839q4);
                    boolean[] zArr = new boolean[this.f7076j.length];
                    long jM3347a = c2839q4.m3347a(c2652rM3355i, this.f7058G.f7965t, zM3378n, zArr);
                    C2964w1 c2964w1 = this.f7058G;
                    boolean z4 = (c2964w1.f7951f == 4 || jM3347a == c2964w1.f7965t) ? false : true;
                    C2964w1 c2964w2 = this.f7058G;
                    this.f7058G = m3266u(c2964w2.f7948c, jM3347a, c2964w2.f7949d, c2964w2.f7950e, z4, 5);
                    if (z4) {
                        m3221J(jM3347a);
                    }
                    boolean[] zArr2 = new boolean[this.f7076j.length];
                    int i2 = 0;
                    while (true) {
                        InterfaceC2728f2[] interfaceC2728f2Arr = this.f7076j;
                        if (i2 >= interfaceC2728f2Arr.length) {
                            break;
                        }
                        InterfaceC2728f2 interfaceC2728f2 = interfaceC2728f2Arr[i2];
                        zArr2[i2] = m3210w(interfaceC2728f2);
                        InterfaceC2546i0 interfaceC2546i0 = c2839q4.f7444c[i2];
                        if (zArr2[i2]) {
                            if (interfaceC2546i0 != interfaceC2728f2.mo2934h()) {
                                m3241e(interfaceC2728f2);
                            } else if (zArr[i2]) {
                                interfaceC2728f2.mo2943u(this.f7072U);
                            }
                        }
                        i2++;
                    }
                    m3247h(zArr2);
                } else {
                    this.f7053B.m3378n(c2839q3);
                    if (c2839q3.f7445d) {
                        c2839q3.m3347a(c2652rM3355i, Math.max(c2839q3.f7447f.f7466b, this.f7072U - c2839q3.f7456o), false, new boolean[c2839q3.f7450i.length]);
                    }
                }
                m3262q(true);
                if (this.f7058G.f7951f != 4) {
                    m3269z();
                    m3259n0();
                    this.f7083q.mo2959f(2);
                    return;
                }
                return;
            }
            if (c2839q3 == c2839q2) {
                z3 = false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b4 A[PHI: r4 r5 r7
      0x00b4: PHI (r4v4 b.i.a.c.a3.a0$a) = (r4v3 b.i.a.c.a3.a0$a), (r4v10 b.i.a.c.a3.a0$a) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r5v2 long) = (r5v1 long), (r5v7 long) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r7v3 long) = (r7v2 long), (r7v6 long) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: H */
    public final void m3219H(boolean z2, boolean z3, boolean z4, boolean z5) {
        InterfaceC2530a0.a aVar;
        long j;
        boolean z6;
        List list;
        this.f7083q.mo2961h(2);
        this.f7075X = null;
        this.f7063L = false;
        C2527a1 c2527a1 = this.f7090x;
        c2527a1.f5472o = false;
        C2759z c2759z = c2527a1.f5467j;
        if (c2759z.f6801k) {
            c2759z.m3117a(c2759z.mo2417e());
            c2759z.f6801k = false;
        }
        this.f7072U = 1000000000000L;
        for (InterfaceC2728f2 interfaceC2728f2 : this.f7076j) {
            try {
                m3241e(interfaceC2728f2);
            } catch (ExoPlaybackException | RuntimeException e2) {
                C2750q.m3039b("ExoPlayerImplInternal", "Disable failed.", e2);
            }
        }
        if (z2) {
            for (InterfaceC2728f2 interfaceC2728f3 : this.f7076j) {
                if (this.f7077k.remove(interfaceC2728f3)) {
                    try {
                        interfaceC2728f3.reset();
                    } catch (RuntimeException e3) {
                        C2750q.m3039b("ExoPlayerImplInternal", "Reset failed.", e3);
                    }
                }
            }
        }
        this.f7070S = 0;
        C2964w1 c2964w1 = this.f7058G;
        InterfaceC2530a0.a aVar2 = c2964w1.f7948c;
        long jLongValue = c2964w1.f7965t;
        long j2 = (this.f7058G.f7948c.m2593a() || m3211y(this.f7058G, this.f7087u)) ? this.f7058G.f7949d : this.f7058G.f7965t;
        if (z3) {
            this.f7071T = null;
            Pair<InterfaceC2530a0.a, Long> pairM3254l = m3254l(this.f7058G.f7947b);
            aVar2 = (InterfaceC2530a0.a) pairM3254l.first;
            jLongValue = ((Long) pairM3254l.second).longValue();
            j2 = -9223372036854775807L;
            if (aVar2.equals(this.f7058G.f7948c)) {
                aVar = aVar2;
                j = jLongValue;
                z6 = false;
            } else {
                z6 = true;
                aVar = aVar2;
                j = jLongValue;
            }
        } else {
            aVar = aVar2;
            j = jLongValue;
            z6 = false;
        }
        this.f7053B.m3366b();
        this.f7064M = false;
        C2964w1 c2964w2 = this.f7058G;
        AbstractC2832o2 abstractC2832o2 = c2964w2.f7947b;
        int i = c2964w2.f7951f;
        ExoPlaybackException exoPlaybackException = z5 ? null : c2964w2.f7952g;
        C2558o0 c2558o0 = z6 ? C2558o0.f5674j : c2964w2.f7954i;
        C2652r c2652r = z6 ? this.f7080n : c2964w2.f7955j;
        if (z6) {
            AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
            list = C4508h0.f12012l;
        } else {
            list = c2964w2.f7956k;
        }
        this.f7058G = new C2964w1(abstractC2832o2, aVar, j2, j, i, exoPlaybackException, false, c2558o0, c2652r, list, aVar, c2964w2.f7958m, c2964w2.f7959n, c2964w2.f7960o, j, 0L, j, this.f7069R, false);
        if (z4) {
            C2945u1 c2945u1 = this.f7054C;
            for (C2945u1.b bVar : c2945u1.f7870g.values()) {
                try {
                    bVar.f7879a.mo2446a(bVar.f7880b);
                } catch (RuntimeException e4) {
                    C2750q.m3039b("MediaSourceList", "Failed to release child source.", e4);
                }
                bVar.f7879a.mo2448c(bVar.f7881c);
                bVar.f7879a.mo2452g(bVar.f7881c);
            }
            c2945u1.f7870g.clear();
            c2945u1.f7871h.clear();
            c2945u1.f7873j = false;
        }
    }

    /* JADX INFO: renamed from: I */
    public final void m3220I() {
        C2839q1 c2839q1 = this.f7053B.f7493h;
        this.f7062K = c2839q1 != null && c2839q1.f7447f.f7472h && this.f7061J;
    }

    /* JADX INFO: renamed from: J */
    public final void m3221J(long j) throws ExoPlaybackException {
        C2839q1 c2839q1 = this.f7053B.f7493h;
        long j2 = j + (c2839q1 == null ? 1000000000000L : c2839q1.f7456o);
        this.f7072U = j2;
        this.f7090x.f5467j.m3117a(j2);
        for (InterfaceC2728f2 interfaceC2728f2 : this.f7076j) {
            if (m3210w(interfaceC2728f2)) {
                interfaceC2728f2.mo2943u(this.f7072U);
            }
        }
        for (C2839q1 c2839q2 = this.f7053B.f7493h; c2839q2 != null; c2839q2 = c2839q2.f7453l) {
            for (InterfaceC2644j interfaceC2644j : c2839q2.f7455n.f6328c) {
                if (interfaceC2644j != null) {
                    interfaceC2644j.mo2732j();
                }
            }
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m3222L(AbstractC2832o2 abstractC2832o2, AbstractC2832o2 abstractC2832o3) {
        if (abstractC2832o2.m3331q() && abstractC2832o3.m3331q()) {
            return;
        }
        int size = this.f7091y.size();
        while (true) {
            size--;
            if (size < 0) {
                Collections.sort(this.f7091y);
                return;
            } else if (!m3206K(this.f7091y.get(size), abstractC2832o2, abstractC2832o3, this.f7065N, this.f7066O, this.f7086t, this.f7087u)) {
                this.f7091y.get(size).f7097j.m2599c(false);
                this.f7091y.remove(size);
            }
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m3223O(long j, long j2) {
        this.f7083q.mo2961h(2);
        this.f7083q.mo2960g(2, j + j2);
    }

    /* JADX INFO: renamed from: P */
    public final void m3224P(boolean z2) throws ExoPlaybackException {
        InterfaceC2530a0.a aVar = this.f7053B.f7493h.f7447f.f7465a;
        long jM3227S = m3227S(aVar, this.f7058G.f7965t, true, false);
        if (jM3227S != this.f7058G.f7965t) {
            C2964w1 c2964w1 = this.f7058G;
            this.f7058G = m3266u(aVar, jM3227S, c2964w1.f7949d, c2964w1.f7950e, z2, 5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ab A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b1 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b7 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c0 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:51:0x010d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114  */
    /* JADX WARN: Code duplicated, block: B:55:0x0116  */
    /* JADX WARN: Code duplicated, block: B:60:0x0120  */
    /* JADX INFO: renamed from: Q */
    public final void m3225Q(g gVar) throws Throwable {
        long jLongValue;
        long j;
        boolean z2;
        InterfaceC2530a0.a aVar;
        long j2;
        long j3;
        long j4;
        long jMo2485i;
        boolean z3;
        long jM3226R;
        boolean z4;
        long j5;
        C2839q1 c2839q1;
        C2964w1 c2964w1;
        int i;
        this.f7059H.m3271a(1);
        Pair<Object, Long> pairM3207M = m3207M(this.f7058G.f7947b, gVar, true, this.f7065N, this.f7066O, this.f7086t, this.f7087u);
        try {
            if (pairM3207M != null) {
                Object obj = pairM3207M.first;
                jLongValue = ((Long) pairM3207M.second).longValue();
                long j6 = gVar.f7116c == -9223372036854775807L ? -9223372036854775807L : jLongValue;
                InterfaceC2530a0.a aVarM3379o = this.f7053B.m3379o(this.f7058G.f7947b, obj, jLongValue);
                if (aVarM3379o.m2593a()) {
                    this.f7058G.f7947b.mo3327h(aVarM3379o.f5732a, this.f7087u);
                    j2 = this.f7087u.m3335d(aVarM3379o.f5733b) == aVarM3379o.f5734c ? this.f7087u.f7344p.f5685o : 0L;
                    j3 = j6;
                    z2 = true;
                    aVar = aVarM3379o;
                } else {
                    j = j6;
                    z2 = gVar.f7116c == -9223372036854775807L;
                    aVar = aVarM3379o;
                }
                if (this.f7058G.f7947b.m3331q()) {
                    if (pairM3207M == null) {
                        if (this.f7058G.f7951f != 1) {
                            m3244f0(4);
                        }
                        m3219H(false, true, false, true);
                    } else {
                        if (aVar.equals(this.f7058G.f7948c)) {
                            c2839q1 = this.f7053B.f7493h;
                            if (c2839q1 == null && c2839q1.f7445d && j2 != 0) {
                                jMo2485i = c2839q1.f7442a.mo2485i(j2, this.f7057F);
                            } else {
                                jMo2485i = j2;
                            }
                            if (C2738e0.m2992M(jMo2485i) == C2738e0.m2992M(this.f7058G.f7965t) && ((i = (c2964w1 = this.f7058G).f7951f) == 2 || i == 3)) {
                                long j7 = c2964w1.f7965t;
                                this.f7058G = m3266u(aVar, j7, j3, j7, z2, 2);
                                return;
                            }
                        } else {
                            jMo2485i = j2;
                        }
                        if (this.f7058G.f7951f == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        jM3226R = m3226R(aVar, jMo2485i, z3);
                        z4 = (j2 != jM3226R) | z2;
                        try {
                            C2964w1 c2964w2 = this.f7058G;
                            AbstractC2832o2 abstractC2832o2 = c2964w2.f7947b;
                            m3257m0(abstractC2832o2, aVar, abstractC2832o2, c2964w2.f7948c, j3);
                            z2 = z4;
                            j5 = jM3226R;
                        } catch (Throwable th) {
                            th = th;
                            z2 = z4;
                            j4 = jM3226R;
                            this.f7058G = m3266u(aVar, j4, j3, j4, z2, 2);
                            throw th;
                        }
                    }
                    this.f7058G = m3266u(aVar, j5, j3, j5, z2, 2);
                    return;
                }
                this.f7071T = gVar;
                j5 = j2;
                this.f7058G = m3266u(aVar, j5, j3, j5, z2, 2);
                return;
            }
            Pair<InterfaceC2530a0.a, Long> pairM3254l = m3254l(this.f7058G.f7947b);
            aVar = (InterfaceC2530a0.a) pairM3254l.first;
            jLongValue = ((Long) pairM3254l.second).longValue();
            z2 = !this.f7058G.f7947b.m3331q();
            j = -9223372036854775807L;
            if (this.f7058G.f7947b.m3331q()) {
                if (pairM3207M == null) {
                    if (this.f7058G.f7951f != 1) {
                        m3244f0(4);
                    }
                    m3219H(false, true, false, true);
                } else {
                    if (aVar.equals(this.f7058G.f7948c)) {
                        c2839q1 = this.f7053B.f7493h;
                        if (c2839q1 == null) {
                            jMo2485i = j2;
                        } else {
                            jMo2485i = j2;
                        }
                        if (C2738e0.m2992M(jMo2485i) == C2738e0.m2992M(this.f7058G.f7965t)) {
                            long j8 = c2964w1.f7965t;
                            this.f7058G = m3266u(aVar, j8, j3, j8, z2, 2);
                            return;
                        }
                    } else {
                        jMo2485i = j2;
                    }
                    if (this.f7058G.f7951f == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    jM3226R = m3226R(aVar, jMo2485i, z3);
                    z4 = (j2 != jM3226R) | z2;
                    C2964w1 c2964w3 = this.f7058G;
                    AbstractC2832o2 abstractC2832o3 = c2964w3.f7947b;
                    m3257m0(abstractC2832o3, aVar, abstractC2832o3, c2964w3.f7948c, j3);
                    z2 = z4;
                    j5 = jM3226R;
                }
                this.f7058G = m3266u(aVar, j5, j3, j5, z2, 2);
                return;
            }
            this.f7071T = gVar;
            j5 = j2;
            this.f7058G = m3266u(aVar, j5, j3, j5, z2, 2);
            return;
        } catch (Throwable th2) {
            th = th2;
            j4 = j2;
        }
        j2 = jLongValue;
        j3 = j;
    }

    /* JADX INFO: renamed from: R */
    public final long m3226R(InterfaceC2530a0.a aVar, long j, boolean z2) throws ExoPlaybackException {
        C2847s1 c2847s1 = this.f7053B;
        return m3227S(aVar, j, c2847s1.f7493h != c2847s1.f7494i, z2);
    }

    /* JADX INFO: renamed from: S */
    public final long m3227S(InterfaceC2530a0.a aVar, long j, boolean z2, boolean z3) throws ExoPlaybackException {
        C2847s1 c2847s1;
        m3253k0();
        this.f7063L = false;
        if (z3 || this.f7058G.f7951f == 3) {
            m3244f0(2);
        }
        C2839q1 c2839q1 = this.f7053B.f7493h;
        C2839q1 c2839q2 = c2839q1;
        while (c2839q2 != null && !aVar.equals(c2839q2.f7447f.f7465a)) {
            c2839q2 = c2839q2.f7453l;
        }
        if (z2 || c2839q1 != c2839q2 || (c2839q2 != null && c2839q2.f7456o + j < 0)) {
            for (InterfaceC2728f2 interfaceC2728f2 : this.f7076j) {
                m3241e(interfaceC2728f2);
            }
            if (c2839q2 != null) {
                while (true) {
                    c2847s1 = this.f7053B;
                    if (c2847s1.f7493h == c2839q2) {
                        break;
                    }
                    c2847s1.m3365a();
                }
                c2847s1.m3378n(c2839q2);
                c2839q2.f7456o = 1000000000000L;
                m3245g();
            }
        }
        if (c2839q2 != null) {
            this.f7053B.m3378n(c2839q2);
            if (!c2839q2.f7445d) {
                c2839q2.f7447f = c2839q2.f7447f.m3361b(j);
            } else if (c2839q2.f7446e) {
                long jMo2482f = c2839q2.f7442a.mo2482f(j);
                c2839q2.f7442a.mo2494r(jMo2482f - this.f7088v, this.f7089w);
                j = jMo2482f;
            }
            m3221J(j);
            m3269z();
        } else {
            this.f7053B.m3366b();
            m3221J(j);
        }
        m3262q(false);
        this.f7083q.mo2959f(2);
        return j;
    }

    /* JADX INFO: renamed from: T */
    public final void m3228T(C2576b2 c2576b2) throws ExoPlaybackException {
        if (c2576b2.f5748g != this.f7085s) {
            ((C2732b0.b) this.f7083q.mo2962i(15, c2576b2)).m2965b();
            return;
        }
        m3239d(c2576b2);
        int i = this.f7058G.f7951f;
        if (i == 3 || i == 2) {
            this.f7083q.mo2959f(2);
        }
    }

    /* JADX INFO: renamed from: U */
    public final void m3229U(final C2576b2 c2576b2) {
        Looper looper = c2576b2.f5748g;
        if (looper.getThread().isAlive()) {
            this.f7092z.mo2950b(looper, null).mo2955b(new Runnable() { // from class: b.i.a.c.g0
                @Override // java.lang.Runnable
                public final void run() {
                    C2803h1 c2803h1 = this.f6806j;
                    C2576b2 c2576b3 = c2576b2;
                    Objects.requireNonNull(c2803h1);
                    try {
                        c2803h1.m3239d(c2576b3);
                    } catch (ExoPlaybackException e2) {
                        C2750q.m3039b("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
                        throw new RuntimeException(e2);
                    }
                }
            });
        } else {
            Log.w("TAG", "Trying to send message on a dead thread.");
            c2576b2.m2599c(false);
        }
    }

    /* JADX INFO: renamed from: V */
    public final void m3230V(InterfaceC2728f2 interfaceC2728f2, long j) {
        interfaceC2728f2.mo2937l();
        if (interfaceC2728f2 instanceof C2589m) {
            C2589m c2589m = (C2589m) interfaceC2728f2;
            C1460d.m426D(c2589m.f7898s);
            c2589m.f5811I = j;
        }
    }

    /* JADX INFO: renamed from: W */
    public final void m3231W(boolean z2, @Nullable AtomicBoolean atomicBoolean) {
        if (this.f7067P != z2) {
            this.f7067P = z2;
            if (!z2) {
                for (InterfaceC2728f2 interfaceC2728f2 : this.f7076j) {
                    if (!m3210w(interfaceC2728f2) && this.f7077k.remove(interfaceC2728f2)) {
                        interfaceC2728f2.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    /* JADX INFO: renamed from: X */
    public final void m3232X(a aVar) throws Throwable {
        this.f7059H.m3271a(1);
        if (aVar.f7095c != -1) {
            this.f7071T = new g(new C2634c2(aVar.f7093a, aVar.f7094b), aVar.f7095c, aVar.f7096d);
        }
        C2945u1 c2945u1 = this.f7054C;
        List<C2945u1.c> list = aVar.f7093a;
        InterfaceC2550k0 interfaceC2550k0 = aVar.f7094b;
        c2945u1.m3543i(0, c2945u1.f7864a.size());
        m3263r(c2945u1.m3535a(c2945u1.f7864a.size(), list, interfaceC2550k0), false);
    }

    /* JADX INFO: renamed from: Y */
    public final void m3233Y(boolean z2) {
        if (z2 == this.f7069R) {
            return;
        }
        this.f7069R = z2;
        C2964w1 c2964w1 = this.f7058G;
        int i = c2964w1.f7951f;
        if (z2 || i == 4 || i == 1) {
            this.f7058G = c2964w1.m3564c(z2);
        } else {
            this.f7083q.mo2959f(2);
        }
    }

    /* JADX INFO: renamed from: Z */
    public final void m3234Z(boolean z2) throws ExoPlaybackException {
        this.f7061J = z2;
        m3220I();
        if (this.f7062K) {
            C2847s1 c2847s1 = this.f7053B;
            if (c2847s1.f7494i != c2847s1.f7493h) {
                m3224P(true);
                m3262q(false);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2548j0.a
    /* JADX INFO: renamed from: a */
    public void mo2542a(InterfaceC2548j0 interfaceC2548j0) {
        ((C2732b0.b) this.f7083q.mo2962i(9, (InterfaceC2570x) interfaceC2548j0)).m2965b();
    }

    /* JADX INFO: renamed from: a0 */
    public final void m3235a0(boolean z2, int i, boolean z3, int i2) throws ExoPlaybackException {
        this.f7059H.m3271a(z3 ? 1 : 0);
        d dVar = this.f7059H;
        dVar.f7101a = true;
        dVar.f7106f = true;
        dVar.f7107g = i2;
        this.f7058G = this.f7058G.m3565d(z2, i);
        this.f7063L = false;
        for (C2839q1 c2839q1 = this.f7053B.f7493h; c2839q1 != null; c2839q1 = c2839q1.f7453l) {
            for (InterfaceC2644j interfaceC2644j : c2839q1.f7455n.f6328c) {
                if (interfaceC2644j != null) {
                    interfaceC2644j.mo2728c(z2);
                }
            }
        }
        if (!m3246g0()) {
            m3253k0();
            m3259n0();
            return;
        }
        int i3 = this.f7058G.f7951f;
        if (i3 == 3) {
            m3249i0();
            this.f7083q.mo2959f(2);
        } else if (i3 == 2) {
            this.f7083q.mo2959f(2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x.a
    /* JADX INFO: renamed from: b */
    public void mo2563b(InterfaceC2570x interfaceC2570x) {
        ((C2732b0.b) this.f7083q.mo2962i(8, interfaceC2570x)).m2965b();
    }

    /* JADX INFO: renamed from: b0 */
    public final void m3236b0(C2998x1 c2998x1) throws ExoPlaybackException {
        this.f7090x.mo2418i(c2998x1);
        C2998x1 c2998x1Mo2416c = this.f7090x.mo2416c();
        m3265t(c2998x1Mo2416c, c2998x1Mo2416c.f8027k, true, true);
    }

    /* JADX INFO: renamed from: c */
    public final void m3237c(a aVar, int i) throws Throwable {
        this.f7059H.m3271a(1);
        C2945u1 c2945u1 = this.f7054C;
        if (i == -1) {
            i = c2945u1.m3539e();
        }
        m3263r(c2945u1.m3535a(i, aVar.f7093a, aVar.f7094b), false);
    }

    /* JADX INFO: renamed from: c0 */
    public final void m3238c0(int i) throws ExoPlaybackException {
        this.f7065N = i;
        C2847s1 c2847s1 = this.f7053B;
        AbstractC2832o2 abstractC2832o2 = this.f7058G.f7947b;
        c2847s1.f7491f = i;
        if (!c2847s1.m3380q(abstractC2832o2)) {
            m3224P(true);
        }
        m3262q(false);
    }

    /* JADX INFO: renamed from: d */
    public final void m3239d(C2576b2 c2576b2) throws ExoPlaybackException {
        c2576b2.m2598b();
        try {
            c2576b2.f5742a.mo2603r(c2576b2.f5746e, c2576b2.f5747f);
        } finally {
            c2576b2.m2599c(true);
        }
    }

    /* JADX INFO: renamed from: d0 */
    public final void m3240d0(boolean z2) throws ExoPlaybackException {
        this.f7066O = z2;
        C2847s1 c2847s1 = this.f7053B;
        AbstractC2832o2 abstractC2832o2 = this.f7058G.f7947b;
        c2847s1.f7492g = z2;
        if (!c2847s1.m3380q(abstractC2832o2)) {
            m3224P(true);
        }
        m3262q(false);
    }

    /* JADX INFO: renamed from: e */
    public final void m3241e(InterfaceC2728f2 interfaceC2728f2) throws ExoPlaybackException {
        if (interfaceC2728f2.getState() != 0) {
            C2527a1 c2527a1 = this.f7090x;
            if (interfaceC2728f2 == c2527a1.f5469l) {
                c2527a1.f5470m = null;
                c2527a1.f5469l = null;
                c2527a1.f5471n = true;
            }
            if (interfaceC2728f2.getState() == 2) {
                interfaceC2728f2.stop();
            }
            interfaceC2728f2.mo2933g();
            this.f7070S--;
        }
    }

    /* JADX INFO: renamed from: e0 */
    public final void m3242e0(InterfaceC2550k0 interfaceC2550k0) throws Throwable {
        this.f7059H.m3271a(1);
        C2945u1 c2945u1 = this.f7054C;
        int iM3539e = c2945u1.m3539e();
        if (interfaceC2550k0.mo2544b() != iM3539e) {
            interfaceC2550k0 = interfaceC2550k0.mo2550h().mo2548f(0, iM3539e);
        }
        c2945u1.f7872i = interfaceC2550k0;
        m3263r(c2945u1.m3537c(), false);
    }

    /* JADX WARN: Code duplicated, block: B:297:0x0476  */
    /* JADX WARN: Code duplicated, block: B:303:0x048b  */
    /* JADX WARN: Code duplicated, block: B:313:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:315:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:317:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:319:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:325:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:419:0x04c0 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:315:0x04b1, please report this as an issue */
    /* JADX INFO: renamed from: f */
    public final void m3243f() throws ExoPlaybackException, IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        C2839q1 c2839q1;
        C3127y0 c3127y0;
        long j;
        long j2;
        int i;
        boolean zM3268x;
        int i2;
        boolean z5;
        boolean z6;
        C2839q1 c2839q2;
        C2839q1 c2839q3;
        boolean z7;
        long jMo2949a = this.f7092z.mo2949a();
        if (!this.f7058G.f7947b.m3331q() && this.f7054C.f7873j) {
            this.f7053B.m3377m(this.f7072U);
            C2847s1 c2847s1 = this.f7053B;
            C2839q1 c2839q4 = c2847s1.f7495j;
            if (c2839q4 == null || (!c2839q4.f7447f.f7473i && c2839q4.m3352f() && c2847s1.f7495j.f7447f.f7469e != -9223372036854775807L && c2847s1.f7496k < 100)) {
                C2847s1 c2847s2 = this.f7053B;
                long j3 = this.f7072U;
                C2964w1 c2964w1 = this.f7058G;
                C2839q1 c2839q5 = c2847s2.f7495j;
                C2843r1 c2843r1M3368d = c2839q5 == null ? c2847s2.m3368d(c2964w1.f7947b, c2964w1.f7948c, c2964w1.f7949d, c2964w1.f7965t) : c2847s2.m3367c(c2964w1.f7947b, c2839q5, j3);
                if (c2843r1M3368d != null) {
                    C2847s1 c2847s3 = this.f7053B;
                    InterfaceC2763g2[] interfaceC2763g2Arr = this.f7078l;
                    AbstractC2651q abstractC2651q = this.f7079m;
                    C2713o c2713oMo3316h = this.f7081o.mo3316h();
                    C2945u1 c2945u1 = this.f7054C;
                    C2652r c2652r = this.f7080n;
                    C2839q1 c2839q6 = c2847s3.f7495j;
                    C2839q1 c2839q7 = new C2839q1(interfaceC2763g2Arr, c2839q6 == null ? 1000000000000L : (c2839q6.f7456o + c2839q6.f7447f.f7469e) - c2843r1M3368d.f7466b, abstractC2651q, c2713oMo3316h, c2945u1, c2843r1M3368d, c2652r);
                    C2839q1 c2839q8 = c2847s3.f7495j;
                    if (c2839q8 == null) {
                        c2847s3.f7493h = c2839q7;
                        c2847s3.f7494i = c2839q7;
                    } else if (c2839q7 != c2839q8.f7453l) {
                        c2839q8.m3348b();
                        c2839q8.f7453l = c2839q7;
                        c2839q8.m3349c();
                    }
                    c2847s3.f7497l = null;
                    c2847s3.f7495j = c2839q7;
                    c2847s3.f7496k++;
                    c2847s3.m3376l();
                    c2839q7.f7442a.mo2488l(this, c2843r1M3368d.f7466b);
                    if (this.f7053B.f7493h == c2839q7) {
                        m3221J(c2843r1M3368d.f7466b);
                    }
                    m3262q(false);
                }
            }
            if (this.f7064M) {
                this.f7064M = m3267v();
                m3255l0();
            } else {
                m3269z();
            }
            C2839q1 c2839q9 = this.f7053B.f7494i;
            if (c2839q9 != null) {
                if (c2839q9.f7453l != null && !this.f7062K) {
                    if (!c2839q9.f7445d) {
                        z7 = false;
                        break;
                    }
                    int i3 = 0;
                    while (true) {
                        InterfaceC2728f2[] interfaceC2728f2Arr = this.f7076j;
                        if (i3 >= interfaceC2728f2Arr.length) {
                            z7 = true;
                            break;
                        }
                        InterfaceC2728f2 interfaceC2728f2 = interfaceC2728f2Arr[i3];
                        InterfaceC2546i0 interfaceC2546i0 = c2839q9.f7444c[i3];
                        if (interfaceC2728f2.mo2934h() == interfaceC2546i0) {
                            if (interfaceC2546i0 != null && !interfaceC2728f2.mo2935j()) {
                                C2839q1 c2839q10 = c2839q9.f7453l;
                                if (!(c2839q9.f7447f.f7470f && c2839q10.f7445d && ((interfaceC2728f2 instanceof C2589m) || interfaceC2728f2.mo2942t() >= c2839q10.m3351e()))) {
                                }
                            }
                            i3++;
                        }
                        z7 = false;
                        break;
                    }
                    if (z7) {
                        C2839q1 c2839q11 = c2839q9.f7453l;
                        if (c2839q11.f7445d || this.f7072U >= c2839q11.m3351e()) {
                            C2652r c2652r2 = c2839q9.f7455n;
                            C2847s1 c2847s4 = this.f7053B;
                            C2839q1 c2839q12 = c2847s4.f7494i;
                            C1460d.m426D((c2839q12 == null || c2839q12.f7453l == null) ? false : true);
                            c2847s4.f7494i = c2847s4.f7494i.f7453l;
                            c2847s4.m3376l();
                            C2839q1 c2839q13 = c2847s4.f7494i;
                            C2652r c2652r3 = c2839q13.f7455n;
                            if (!c2839q13.f7445d || c2839q13.f7442a.mo2487k() == -9223372036854775807L) {
                                for (int i4 = 0; i4 < this.f7076j.length; i4++) {
                                    boolean zM2756b = c2652r2.m2756b(i4);
                                    boolean zM2756b2 = c2652r3.m2756b(i4);
                                    if (zM2756b && !this.f7076j[i4].mo2944v()) {
                                        boolean z8 = ((AbstractC2951v0) this.f7078l[i4]).f7889j == -2;
                                        C2804h2 c2804h2 = c2652r2.f6327b[i4];
                                        C2804h2 c2804h3 = c2652r3.f6327b[i4];
                                        if (!zM2756b2 || !c2804h3.equals(c2804h2) || z8) {
                                            m3230V(this.f7076j[i4], c2839q13.m3351e());
                                        }
                                    }
                                }
                            } else {
                                long jM3351e = c2839q13.m3351e();
                                for (InterfaceC2728f2 interfaceC2728f3 : this.f7076j) {
                                    if (interfaceC2728f3.mo2934h() != null) {
                                        m3230V(interfaceC2728f3, jM3351e);
                                    }
                                }
                            }
                        }
                    }
                } else if (c2839q9.f7447f.f7473i || this.f7062K) {
                    int i5 = 0;
                    while (true) {
                        InterfaceC2728f2[] interfaceC2728f2Arr2 = this.f7076j;
                        if (i5 >= interfaceC2728f2Arr2.length) {
                            break;
                        }
                        InterfaceC2728f2 interfaceC2728f4 = interfaceC2728f2Arr2[i5];
                        InterfaceC2546i0 interfaceC2546i1 = c2839q9.f7444c[i5];
                        if (interfaceC2546i1 != null && interfaceC2728f4.mo2934h() == interfaceC2546i1 && interfaceC2728f4.mo2935j()) {
                            long j4 = c2839q9.f7447f.f7469e;
                            m3230V(interfaceC2728f4, (j4 == -9223372036854775807L || j4 == Long.MIN_VALUE) ? -9223372036854775807L : j4 + c2839q9.f7456o);
                        }
                        i5++;
                    }
                }
            }
            C2847s1 c2847s5 = this.f7053B;
            C2839q1 c2839q14 = c2847s5.f7494i;
            if (c2839q14 != null && c2847s5.f7493h != c2839q14 && !c2839q14.f7448g) {
                C2652r c2652r4 = c2839q14.f7455n;
                int i6 = 0;
                boolean z9 = false;
                while (true) {
                    InterfaceC2728f2[] interfaceC2728f2Arr3 = this.f7076j;
                    if (i6 >= interfaceC2728f2Arr3.length) {
                        break;
                    }
                    InterfaceC2728f2 interfaceC2728f5 = interfaceC2728f2Arr3[i6];
                    if (m3210w(interfaceC2728f5)) {
                        boolean z10 = interfaceC2728f5.mo2934h() != c2839q14.f7444c[i6];
                        if (!c2652r4.m2756b(i6) || z10) {
                            if (!interfaceC2728f5.mo2944v()) {
                                interfaceC2728f5.mo2936k(m3209i(c2652r4.f6328c[i6]), c2839q14.f7444c[i6], c2839q14.m3351e(), c2839q14.f7456o);
                            } else if (interfaceC2728f5.mo2631b()) {
                                m3241e(interfaceC2728f5);
                            } else {
                                z9 = true;
                            }
                        }
                    }
                    i6++;
                }
                if (!z9) {
                    m3245g();
                }
            }
            boolean z11 = false;
            while (true) {
                if (!(m3246g0() && !this.f7062K && (c2839q2 = this.f7053B.f7493h) != null && (c2839q3 = c2839q2.f7453l) != null && this.f7072U >= c2839q3.m3351e() && c2839q3.f7448g)) {
                    break;
                }
                if (z11) {
                    m3212A();
                }
                C2847s1 c2847s6 = this.f7053B;
                C2839q1 c2839q15 = c2847s6.f7493h;
                C2839q1 c2839q1M3365a = c2847s6.m3365a();
                C2843r1 c2843r1 = c2839q1M3365a.f7447f;
                InterfaceC2530a0.a aVar = c2843r1.f7465a;
                long j5 = c2843r1.f7466b;
                C2964w1 c2964w1M3266u = m3266u(aVar, j5, c2843r1.f7467c, j5, true, 0);
                this.f7058G = c2964w1M3266u;
                AbstractC2832o2 abstractC2832o2 = c2964w1M3266u.f7947b;
                m3257m0(abstractC2832o2, c2839q1M3365a.f7447f.f7465a, abstractC2832o2, c2839q15.f7447f.f7465a, -9223372036854775807L);
                m3220I();
                m3259n0();
                z11 = true;
            }
        }
        int i7 = this.f7058G.f7951f;
        if (i7 == 1 || i7 == 4) {
            this.f7083q.mo2961h(2);
            return;
        }
        C2839q1 c2839q16 = this.f7053B.f7493h;
        if (c2839q16 == null) {
            m3223O(jMo2949a, 10L);
            return;
        }
        C1460d.m515f("doSomeWork");
        m3259n0();
        if (c2839q16.f7445d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            c2839q16.f7442a.mo2494r(this.f7058G.f7965t - this.f7088v, this.f7089w);
            boolean z12 = true;
            z2 = true;
            int i8 = 0;
            while (true) {
                InterfaceC2728f2[] interfaceC2728f2Arr4 = this.f7076j;
                if (i8 >= interfaceC2728f2Arr4.length) {
                    break;
                }
                InterfaceC2728f2 interfaceC2728f6 = interfaceC2728f2Arr4[i8];
                if (m3210w(interfaceC2728f6)) {
                    interfaceC2728f6.mo2633q(this.f7072U, jElapsedRealtime);
                    boolean z13 = z12 && interfaceC2728f6.mo2631b();
                    boolean z14 = c2839q16.f7444c[i8] != interfaceC2728f6.mo2934h();
                    boolean z15 = z14 || (!z14 && interfaceC2728f6.mo2935j()) || interfaceC2728f6.mo2632d() || interfaceC2728f6.mo2631b();
                    boolean z16 = z2 && z15;
                    if (!z15) {
                        interfaceC2728f6.mo2941s();
                    }
                    z2 = z16;
                    z12 = z13;
                }
                i8++;
            }
            z3 = z12;
        } else {
            c2839q16.f7442a.mo2481e();
            z2 = true;
            z3 = true;
        }
        long j6 = c2839q16.f7447f.f7469e;
        boolean z17 = z3 && c2839q16.f7445d && (j6 == -9223372036854775807L || j6 <= this.f7058G.f7965t);
        if (z17 && this.f7062K) {
            z4 = false;
            this.f7062K = false;
            m3235a0(false, this.f7058G.f7959n, false, 5);
        } else {
            z4 = false;
        }
        if (z17 && c2839q16.f7447f.f7473i) {
            m3244f0(4);
            m3253k0();
        } else {
            C2964w1 c2964w2 = this.f7058G;
            if (c2964w2.f7951f == 2) {
                if (this.f7070S == 0) {
                    zM3268x = m3268x();
                } else if (z2) {
                    if (c2964w2.f7953h) {
                        long j7 = m3248h0(c2964w2.f7947b, this.f7053B.f7493h.f7447f.f7465a) ? ((C3127y0) this.f7055D).f9025i : -9223372036854775807L;
                        C2839q1 c2839q17 = this.f7053B.f7495j;
                        boolean z18 = c2839q17.m3352f() && c2839q17.f7447f.f7473i;
                        boolean z19 = c2839q17.f7447f.f7465a.m2593a() && !c2839q17.f7445d;
                        if (!z18 && !z19 && !this.f7081o.mo3314f(m3256m(), this.f7090x.mo2416c().f8027k, this.f7063L, j7)) {
                            zM3268x = false;
                        }
                    }
                    zM3268x = true;
                } else {
                    zM3268x = false;
                }
                if (zM3268x) {
                    m3244f0(3);
                    this.f7075X = null;
                    if (m3246g0()) {
                        m3249i0();
                    }
                } else if (this.f7058G.f7951f == 3) {
                    this.f7063L = m3246g0();
                    m3244f0(2);
                    if (this.f7063L) {
                        for (c2839q1 = this.f7053B.f7493h; c2839q1 != null; c2839q1 = c2839q1.f7453l) {
                            for (InterfaceC2644j interfaceC2644j : c2839q1.f7455n.f6328c) {
                                if (interfaceC2644j != null) {
                                    interfaceC2644j.mo2733k();
                                }
                            }
                        }
                        c3127y0 = (C3127y0) this.f7055D;
                        j = c3127y0.f9025i;
                        if (j != -9223372036854775807L) {
                            long j8 = j + c3127y0.f9018b;
                            c3127y0.f9025i = j8;
                            j2 = c3127y0.f9024h;
                            if (j2 != -9223372036854775807L) {
                                c3127y0.f9025i = j2;
                            }
                            c3127y0.f9029m = -9223372036854775807L;
                        }
                    }
                    m3253k0();
                }
            } else if (this.f7058G.f7951f == 3 && (this.f7070S != 0 ? !z2 : !m3268x())) {
                this.f7063L = m3246g0();
                m3244f0(2);
                if (this.f7063L) {
                    while (c2839q1 != null) {
                        while (i < r7) {
                            if (interfaceC2644j != null) {
                                interfaceC2644j.mo2733k();
                            }
                        }
                    }
                    c3127y0 = (C3127y0) this.f7055D;
                    j = c3127y0.f9025i;
                    if (j != -9223372036854775807L) {
                        long j9 = j + c3127y0.f9018b;
                        c3127y0.f9025i = j9;
                        j2 = c3127y0.f9024h;
                        if (j2 != -9223372036854775807L && j9 > j2) {
                            c3127y0.f9025i = j2;
                        }
                        c3127y0.f9029m = -9223372036854775807L;
                    }
                }
                m3253k0();
            }
        }
        if (this.f7058G.f7951f == 2) {
            int i9 = 0;
            while (true) {
                InterfaceC2728f2[] interfaceC2728f2Arr5 = this.f7076j;
                if (i9 >= interfaceC2728f2Arr5.length) {
                    break;
                }
                if (m3210w(interfaceC2728f2Arr5[i9]) && this.f7076j[i9].mo2934h() == c2839q16.f7444c[i9]) {
                    this.f7076j[i9].mo2941s();
                }
                i9++;
            }
            C2964w1 c2964w3 = this.f7058G;
            if (!c2964w3.f7953h && c2964w3.f7964s < 500000 && m3267v()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z20 = this.f7069R;
        C2964w1 c2964w4 = this.f7058G;
        if (z20 != c2964w4.f7961p) {
            this.f7058G = c2964w4.m3564c(z20);
        }
        if ((m3246g0() && this.f7058G.f7951f == 3) || (i2 = this.f7058G.f7951f) == 2) {
            if (this.f7069R && this.f7068Q) {
                z6 = false;
            } else {
                this.f7083q.mo2961h(2);
                this.f7083q.mo2960g(2, jMo2949a + 10);
                z6 = true;
            }
            z5 = !z6;
        } else {
            if (this.f7070S == 0 || i2 == 4) {
                this.f7083q.mo2961h(2);
            } else {
                m3223O(jMo2949a, 1000L);
            }
            z5 = false;
        }
        C2964w1 c2964w5 = this.f7058G;
        if (c2964w5.f7962q != z5) {
            this.f7058G = new C2964w1(c2964w5.f7947b, c2964w5.f7948c, c2964w5.f7949d, c2964w5.f7950e, c2964w5.f7951f, c2964w5.f7952g, c2964w5.f7953h, c2964w5.f7954i, c2964w5.f7955j, c2964w5.f7956k, c2964w5.f7957l, c2964w5.f7958m, c2964w5.f7959n, c2964w5.f7960o, c2964w5.f7963r, c2964w5.f7964s, c2964w5.f7965t, c2964w5.f7961p, z5);
        }
        this.f7068Q = z4;
        C1460d.m508d0();
    }

    /* JADX INFO: renamed from: f0 */
    public final void m3244f0(int i) {
        C2964w1 c2964w1 = this.f7058G;
        if (c2964w1.f7951f != i) {
            this.f7058G = c2964w1.m3567f(i);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m3245g() throws ExoPlaybackException {
        m3247h(new boolean[this.f7076j.length]);
    }

    /* JADX INFO: renamed from: g0 */
    public final boolean m3246g0() {
        C2964w1 c2964w1 = this.f7058G;
        return c2964w1.f7958m && c2964w1.f7959n == 0;
    }

    /* JADX INFO: renamed from: h */
    public final void m3247h(boolean[] zArr) throws ExoPlaybackException {
        InterfaceC2752s interfaceC2752s;
        C2839q1 c2839q1 = this.f7053B.f7494i;
        C2652r c2652r = c2839q1.f7455n;
        for (int i = 0; i < this.f7076j.length; i++) {
            if (!c2652r.m2756b(i) && this.f7077k.remove(this.f7076j[i])) {
                this.f7076j[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.f7076j.length; i2++) {
            if (c2652r.m2756b(i2)) {
                boolean z2 = zArr[i2];
                InterfaceC2728f2 interfaceC2728f2 = this.f7076j[i2];
                if (m3210w(interfaceC2728f2)) {
                    continue;
                } else {
                    C2847s1 c2847s1 = this.f7053B;
                    C2839q1 c2839q2 = c2847s1.f7494i;
                    boolean z3 = c2839q2 == c2847s1.f7493h;
                    C2652r c2652r2 = c2839q2.f7455n;
                    C2804h2 c2804h2 = c2652r2.f6327b[i2];
                    C2811j1[] c2811j1ArrM3209i = m3209i(c2652r2.f6328c[i2]);
                    boolean z4 = m3246g0() && this.f7058G.f7951f == 3;
                    boolean z5 = !z2 && z4;
                    this.f7070S++;
                    this.f7077k.add(interfaceC2728f2);
                    interfaceC2728f2.mo2940o(c2804h2, c2811j1ArrM3209i, c2839q2.f7444c[i2], this.f7072U, z5, z3, c2839q2.m3351e(), c2839q2.f7456o);
                    interfaceC2728f2.mo2603r(11, new C2762g1(this));
                    C2527a1 c2527a1 = this.f7090x;
                    Objects.requireNonNull(c2527a1);
                    InterfaceC2752s interfaceC2752sMo2945w = interfaceC2728f2.mo2945w();
                    if (interfaceC2752sMo2945w != null && interfaceC2752sMo2945w != (interfaceC2752s = c2527a1.f5470m)) {
                        if (interfaceC2752s != null) {
                            throw ExoPlaybackException.m8753b(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
                        }
                        c2527a1.f5470m = interfaceC2752sMo2945w;
                        c2527a1.f5469l = interfaceC2728f2;
                        interfaceC2752sMo2945w.mo2418i(c2527a1.f5467j.f6804n);
                    }
                    if (z4) {
                        interfaceC2728f2.start();
                    }
                }
            }
        }
        c2839q1.f7448g = true;
    }

    /* JADX INFO: renamed from: h0 */
    public final boolean m3248h0(AbstractC2832o2 abstractC2832o2, InterfaceC2530a0.a aVar) {
        if (aVar.m2593a() || abstractC2832o2.m3331q()) {
            return false;
        }
        abstractC2832o2.m3330n(abstractC2832o2.mo3327h(aVar.f5732a, this.f7087u).f7340l, this.f7086t);
        if (!this.f7086t.m3341c()) {
            return false;
        }
        AbstractC2832o2.c cVar = this.f7086t;
        return cVar.f7361v && cVar.f7358s != -9223372036854775807L;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        C2839q1 c2839q1;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    m3215D();
                    break;
                case 1:
                    m3235a0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    m3243f();
                    break;
                case 3:
                    m3225Q((g) message.obj);
                    break;
                case 4:
                    m3236b0((C2998x1) message.obj);
                    break;
                case 5:
                    this.f7057F = (C2812j2) message.obj;
                    break;
                case 6:
                    m3251j0(false, true);
                    break;
                case 7:
                    m3216E();
                    return true;
                case 8:
                    m3264s((InterfaceC2570x) message.obj);
                    break;
                case 9:
                    m3260o((InterfaceC2570x) message.obj);
                    break;
                case 10:
                    m3218G();
                    break;
                case 11:
                    m3238c0(message.arg1);
                    break;
                case 12:
                    m3240d0(message.arg1 != 0);
                    break;
                case 13:
                    m3231W(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    C2576b2 c2576b2 = (C2576b2) message.obj;
                    Objects.requireNonNull(c2576b2);
                    m3228T(c2576b2);
                    break;
                case 15:
                    m3229U((C2576b2) message.obj);
                    break;
                case 16:
                    C2998x1 c2998x1 = (C2998x1) message.obj;
                    m3265t(c2998x1, c2998x1.f8027k, true, false);
                    break;
                case 17:
                    m3232X((a) message.obj);
                    break;
                case 18:
                    m3237c((a) message.obj, message.arg1);
                    break;
                case 19:
                    m3214C((b) message.obj);
                    break;
                case 20:
                    m3217F(message.arg1, message.arg2, (InterfaceC2550k0) message.obj);
                    break;
                case 21:
                    m3242e0((InterfaceC2550k0) message.obj);
                    break;
                case 22:
                    m3213B();
                    break;
                case 23:
                    m3234Z(message.arg1 != 0);
                    break;
                case 24:
                    m3233Y(message.arg1 == 1);
                    break;
                case 25:
                    m3224P(true);
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (c2839q1 = this.f7053B.f7494i) != null) {
                e = e.m8754a(c2839q1.f7447f.f7465a);
            }
            if (e.isRecoverable && this.f7075X == null) {
                C2750q.m3040c("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.f7075X = e;
                InterfaceC2748o interfaceC2748o = this.f7083q;
                interfaceC2748o.mo2957d(interfaceC2748o.mo2962i(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.f7075X;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.f7075X;
                }
                C2750q.m3039b("ExoPlayerImplInternal", "Playback error", e);
                m3251j0(true, false);
                this.f7058G = this.f7058G.m3566e(e);
            }
        } catch (ParserException e3) {
            int i2 = e3.dataType;
            if (i2 == 1) {
                i = e3.contentIsMalformed ? 3001 : 3003;
            } else if (i2 == 4) {
                i = e3.contentIsMalformed ? 3002 : 3004;
            }
            m3261p(e3, i);
        } catch (DrmSession.DrmSessionException e4) {
            m3261p(e4, e4.errorCode);
        } catch (BehindLiveWindowException e5) {
            m3261p(e5, PointerIconCompat.TYPE_HAND);
        } catch (DataSourceException e6) {
            m3261p(e6, e6.reason);
        } catch (IOException e7) {
            m3261p(e7, 2000);
        } catch (RuntimeException e8) {
            ExoPlaybackException exoPlaybackExceptionM8753b = ExoPlaybackException.m8753b(e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? PointerIconCompat.TYPE_WAIT : 1000);
            C2750q.m3039b("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionM8753b);
            m3251j0(true, false);
            this.f7058G = this.f7058G.m3566e(exoPlaybackExceptionM8753b);
        }
        m3212A();
        return true;
    }

    /* JADX INFO: renamed from: i0 */
    public final void m3249i0() throws ExoPlaybackException {
        this.f7063L = false;
        C2527a1 c2527a1 = this.f7090x;
        c2527a1.f5472o = true;
        c2527a1.f5467j.m3118b();
        for (InterfaceC2728f2 interfaceC2728f2 : this.f7076j) {
            if (m3210w(interfaceC2728f2)) {
                interfaceC2728f2.start();
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final long m3250j(AbstractC2832o2 abstractC2832o2, Object obj, long j) {
        abstractC2832o2.m3330n(abstractC2832o2.mo3327h(obj, this.f7087u).f7340l, this.f7086t);
        AbstractC2832o2.c cVar = this.f7086t;
        if (cVar.f7358s != -9223372036854775807L && cVar.m3341c()) {
            AbstractC2832o2.c cVar2 = this.f7086t;
            if (cVar2.f7361v) {
                long j2 = cVar2.f7359t;
                int i = C2738e0.f6708a;
                return C2738e0.m2981B((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - this.f7086t.f7358s) - (j + this.f7087u.f7342n);
            }
        }
        return -9223372036854775807L;
    }

    /* JADX INFO: renamed from: j0 */
    public final void m3251j0(boolean z2, boolean z3) {
        m3219H(z2 || !this.f7067P, false, true, false);
        this.f7059H.m3271a(z3 ? 1 : 0);
        this.f7081o.mo3317i();
        m3244f0(1);
    }

    /* JADX INFO: renamed from: k */
    public final long m3252k() {
        C2839q1 c2839q1 = this.f7053B.f7494i;
        if (c2839q1 == null) {
            return 0L;
        }
        long jMax = c2839q1.f7456o;
        if (!c2839q1.f7445d) {
            return jMax;
        }
        int i = 0;
        while (true) {
            InterfaceC2728f2[] interfaceC2728f2Arr = this.f7076j;
            if (i >= interfaceC2728f2Arr.length) {
                return jMax;
            }
            if (m3210w(interfaceC2728f2Arr[i]) && this.f7076j[i].mo2934h() == c2839q1.f7444c[i]) {
                long jMo2942t = this.f7076j[i].mo2942t();
                if (jMo2942t == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jMax = Math.max(jMo2942t, jMax);
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: k0 */
    public final void m3253k0() throws ExoPlaybackException {
        C2527a1 c2527a1 = this.f7090x;
        c2527a1.f5472o = false;
        C2759z c2759z = c2527a1.f5467j;
        if (c2759z.f6801k) {
            c2759z.m3117a(c2759z.mo2417e());
            c2759z.f6801k = false;
        }
        for (InterfaceC2728f2 interfaceC2728f2 : this.f7076j) {
            if (m3210w(interfaceC2728f2) && interfaceC2728f2.getState() == 2) {
                interfaceC2728f2.stop();
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final Pair<InterfaceC2530a0.a, Long> m3254l(AbstractC2832o2 abstractC2832o2) {
        if (abstractC2832o2.m3331q()) {
            InterfaceC2530a0.a aVar = C2964w1.f7946a;
            return Pair.create(C2964w1.f7946a, 0L);
        }
        Pair<Object, Long> pairM3328j = abstractC2832o2.m3328j(this.f7086t, this.f7087u, abstractC2832o2.mo2582a(this.f7066O), -9223372036854775807L);
        InterfaceC2530a0.a aVarM3379o = this.f7053B.m3379o(abstractC2832o2, pairM3328j.first, 0L);
        long jLongValue = ((Long) pairM3328j.second).longValue();
        if (aVarM3379o.m2593a()) {
            abstractC2832o2.mo3327h(aVarM3379o.f5732a, this.f7087u);
            jLongValue = aVarM3379o.f5734c == this.f7087u.m3335d(aVarM3379o.f5733b) ? this.f7087u.f7344p.f5685o : 0L;
        }
        return Pair.create(aVarM3379o, Long.valueOf(jLongValue));
    }

    /* JADX INFO: renamed from: l0 */
    public final void m3255l0() {
        C2839q1 c2839q1 = this.f7053B.f7495j;
        boolean z2 = this.f7064M || (c2839q1 != null && c2839q1.f7442a.mo2484h());
        C2964w1 c2964w1 = this.f7058G;
        if (z2 != c2964w1.f7953h) {
            this.f7058G = new C2964w1(c2964w1.f7947b, c2964w1.f7948c, c2964w1.f7949d, c2964w1.f7950e, c2964w1.f7951f, c2964w1.f7952g, z2, c2964w1.f7954i, c2964w1.f7955j, c2964w1.f7956k, c2964w1.f7957l, c2964w1.f7958m, c2964w1.f7959n, c2964w1.f7960o, c2964w1.f7963r, c2964w1.f7964s, c2964w1.f7965t, c2964w1.f7961p, c2964w1.f7962q);
        }
    }

    /* JADX INFO: renamed from: m */
    public final long m3256m() {
        return m3258n(this.f7058G.f7963r);
    }

    /* JADX INFO: renamed from: m0 */
    public final void m3257m0(AbstractC2832o2 abstractC2832o2, InterfaceC2530a0.a aVar, AbstractC2832o2 abstractC2832o3, InterfaceC2530a0.a aVar2, long j) {
        if (abstractC2832o2.m3331q() || !m3248h0(abstractC2832o2, aVar)) {
            float f2 = this.f7090x.mo2416c().f8027k;
            C2998x1 c2998x1 = this.f7058G.f7960o;
            if (f2 != c2998x1.f8027k) {
                this.f7090x.mo2418i(c2998x1);
                return;
            }
            return;
        }
        abstractC2832o2.m3330n(abstractC2832o2.mo3327h(aVar.f5732a, this.f7087u).f7340l, this.f7086t);
        InterfaceC2823m1 interfaceC2823m1 = this.f7055D;
        C2831o1.g gVar = this.f7086t.f7363x;
        int i = C2738e0.f6708a;
        C3127y0 c3127y0 = (C3127y0) interfaceC2823m1;
        Objects.requireNonNull(c3127y0);
        c3127y0.f9020d = C2738e0.m2981B(gVar.f7308l);
        c3127y0.f9023g = C2738e0.m2981B(gVar.f7309m);
        c3127y0.f9024h = C2738e0.m2981B(gVar.f7310n);
        float f3 = gVar.f7311o;
        if (f3 == -3.4028235E38f) {
            f3 = 0.97f;
        }
        c3127y0.f9027k = f3;
        float f4 = gVar.f7312p;
        if (f4 == -3.4028235E38f) {
            f4 = 1.03f;
        }
        c3127y0.f9026j = f4;
        c3127y0.m3825a();
        if (j != -9223372036854775807L) {
            C3127y0 c3127y1 = (C3127y0) this.f7055D;
            c3127y1.f9021e = m3250j(abstractC2832o2, aVar.f5732a, j);
            c3127y1.m3825a();
        } else {
            if (C2738e0.m2993a(abstractC2832o3.m3331q() ? null : abstractC2832o3.m3330n(abstractC2832o3.mo3327h(aVar2.f5732a, this.f7087u).f7340l, this.f7086t).f7353n, this.f7086t.f7353n)) {
                return;
            }
            C3127y0 c3127y2 = (C3127y0) this.f7055D;
            c3127y2.f9021e = -9223372036854775807L;
            c3127y2.m3825a();
        }
    }

    /* JADX INFO: renamed from: n */
    public final long m3258n(long j) {
        C2839q1 c2839q1 = this.f7053B.f7495j;
        if (c2839q1 == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.f7072U - c2839q1.f7456o));
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c3  */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0166, code lost:
    
        r6 = null;
     */
    /* JADX INFO: renamed from: n0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3259n0() throws ExoPlaybackException {
        C2998x1 c2998x1Mo2416c;
        C2759z c2759z;
        long j;
        C2803h1 c2803h1;
        c cVar;
        C2839q1 c2839q1 = this.f7053B.f7493h;
        if (c2839q1 == null) {
            return;
        }
        long jMo2487k = c2839q1.f7445d ? c2839q1.f7442a.mo2487k() : -9223372036854775807L;
        if (jMo2487k != -9223372036854775807L) {
            m3221J(jMo2487k);
            if (jMo2487k != this.f7058G.f7965t) {
                C2964w1 c2964w1 = this.f7058G;
                this.f7058G = m3266u(c2964w1.f7948c, jMo2487k, c2964w1.f7949d, jMo2487k, true, 5);
            }
        } else {
            C2527a1 c2527a1 = this.f7090x;
            boolean z2 = c2839q1 != this.f7053B.f7494i;
            InterfaceC2728f2 interfaceC2728f2 = c2527a1.f5469l;
            if (interfaceC2728f2 == null || interfaceC2728f2.mo2631b() || (!c2527a1.f5469l.mo2632d() && (z2 || c2527a1.f5469l.mo2935j()))) {
                c2527a1.f5471n = true;
                if (c2527a1.f5472o) {
                    c2527a1.f5467j.m3118b();
                }
            } else {
                InterfaceC2752s interfaceC2752s = c2527a1.f5470m;
                Objects.requireNonNull(interfaceC2752s);
                long jMo2417e = interfaceC2752s.mo2417e();
                if (!c2527a1.f5471n) {
                    c2527a1.f5467j.m3117a(jMo2417e);
                    c2998x1Mo2416c = interfaceC2752s.mo2416c();
                    if (!c2998x1Mo2416c.equals(c2527a1.f5467j.f6804n)) {
                        c2759z = c2527a1.f5467j;
                        if (c2759z.f6801k) {
                            c2759z.m3117a(c2759z.mo2417e());
                        }
                        c2759z.f6804n = c2998x1Mo2416c;
                        ((C2732b0.b) ((C2803h1) c2527a1.f5468k).f7083q.mo2962i(16, c2998x1Mo2416c)).m2965b();
                    }
                } else if (jMo2417e < c2527a1.f5467j.mo2417e()) {
                    C2759z c2759z2 = c2527a1.f5467j;
                    if (c2759z2.f6801k) {
                        c2759z2.m3117a(c2759z2.mo2417e());
                        c2759z2.f6801k = false;
                    }
                } else {
                    c2527a1.f5471n = false;
                    if (c2527a1.f5472o) {
                        c2527a1.f5467j.m3118b();
                    }
                    c2527a1.f5467j.m3117a(jMo2417e);
                    c2998x1Mo2416c = interfaceC2752s.mo2416c();
                    if (!c2998x1Mo2416c.equals(c2527a1.f5467j.f6804n)) {
                        c2759z = c2527a1.f5467j;
                        if (c2759z.f6801k) {
                            c2759z.m3117a(c2759z.mo2417e());
                        }
                        c2759z.f6804n = c2998x1Mo2416c;
                        ((C2732b0.b) ((C2803h1) c2527a1.f5468k).f7083q.mo2962i(16, c2998x1Mo2416c)).m2965b();
                    }
                }
            }
            long jMo2417e2 = c2527a1.mo2417e();
            this.f7072U = jMo2417e2;
            long j2 = jMo2417e2 - c2839q1.f7456o;
            long j3 = this.f7058G.f7965t;
            if (!this.f7091y.isEmpty() && !this.f7058G.f7948c.m2593a()) {
                if (this.f7074W) {
                    j3--;
                    this.f7074W = false;
                }
                C2964w1 c2964w2 = this.f7058G;
                int iMo2554b = c2964w2.f7947b.mo2554b(c2964w2.f7948c.f5732a);
                int iMin = Math.min(this.f7073V, this.f7091y.size());
                if (iMin > 0) {
                    cVar = this.f7091y.get(iMin - 1);
                    j = j2;
                    c2803h1 = this;
                } else {
                    j = j2;
                    c2803h1 = this;
                    cVar = null;
                }
                while (cVar != null) {
                    int i = cVar.f7098k;
                    if (i <= iMo2554b && (i != iMo2554b || cVar.f7099l <= j3)) {
                        break;
                    }
                    iMin--;
                    if (iMin > 0) {
                        cVar = c2803h1.f7091y.get(iMin - 1);
                    } else {
                        j = j;
                        c2803h1 = c2803h1;
                        cVar = null;
                    }
                }
                if (iMin < c2803h1.f7091y.size()) {
                    c cVar2 = c2803h1.f7091y.get(iMin);
                    while (cVar2 != null && cVar2.f7100m != null) {
                        int i2 = cVar2.f7098k;
                        if (i2 >= iMo2554b && (i2 != iMo2554b || cVar2.f7099l > j3)) {
                            break;
                        }
                        iMin++;
                        cVar2 = iMin < c2803h1.f7091y.size() ? c2803h1.f7091y.get(iMin) : null;
                    }
                    while (cVar2 != null && cVar2.f7100m != null && cVar2.f7098k == iMo2554b) {
                        long j4 = cVar2.f7099l;
                        if (j4 <= j3 || j4 > j) {
                            break;
                        }
                        try {
                            c2803h1.m3228T(cVar2.f7097j);
                            Objects.requireNonNull(cVar2.f7097j);
                            c2803h1.f7091y.remove(iMin);
                            cVar2 = iMin < c2803h1.f7091y.size() ? c2803h1.f7091y.get(iMin) : null;
                        } catch (Throwable th) {
                            Objects.requireNonNull(cVar2.f7097j);
                            c2803h1.f7091y.remove(iMin);
                            throw th;
                        }
                    }
                    c2803h1.f7073V = iMin;
                }
            }
            this.f7058G.f7965t = j2;
        }
        this.f7058G.f7963r = this.f7053B.f7495j.m3350d();
        this.f7058G.f7964s = m3256m();
        C2964w1 c2964w3 = this.f7058G;
        if (c2964w3.f7958m && c2964w3.f7951f == 3 && m3248h0(c2964w3.f7947b, c2964w3.f7948c)) {
            C2964w1 c2964w4 = this.f7058G;
            float f2 = 1.0f;
            if (c2964w4.f7960o.f8027k == 1.0f) {
                InterfaceC2823m1 interfaceC2823m1 = this.f7055D;
                long jM3250j = m3250j(c2964w4.f7947b, c2964w4.f7948c.f5732a, c2964w4.f7965t);
                long jM3256m = m3256m();
                C3127y0 c3127y0 = (C3127y0) interfaceC2823m1;
                if (c3127y0.f9020d != -9223372036854775807L) {
                    long j5 = jM3250j - jM3256m;
                    long j6 = c3127y0.f9030n;
                    if (j6 == -9223372036854775807L) {
                        c3127y0.f9030n = j5;
                        c3127y0.f9031o = 0L;
                    } else {
                        float f3 = c3127y0.f9019c;
                        long jMax = Math.max(j5, (long) (((1.0f - f3) * j5) + (j6 * f3)));
                        c3127y0.f9030n = jMax;
                        long jAbs = Math.abs(j5 - jMax);
                        long j7 = c3127y0.f9031o;
                        float f4 = c3127y0.f9019c;
                        c3127y0.f9031o = (long) (((1.0f - f4) * jAbs) + (j7 * f4));
                    }
                    if (c3127y0.f9029m == -9223372036854775807L || SystemClock.elapsedRealtime() - c3127y0.f9029m >= 1000) {
                        c3127y0.f9029m = SystemClock.elapsedRealtime();
                        long j8 = (c3127y0.f9031o * 3) + c3127y0.f9030n;
                        if (c3127y0.f9025i > j8) {
                            float fM2981B = C2738e0.m2981B(1000L);
                            long[] jArr = {j8, c3127y0.f9022f, c3127y0.f9025i - (((long) ((c3127y0.f9028l - 1.0f) * fM2981B)) + ((long) ((c3127y0.f9026j - 1.0f) * fM2981B)))};
                            C3404f.m4351v(true);
                            long j9 = jArr[0];
                            for (int i3 = 1; i3 < 3; i3++) {
                                if (jArr[i3] > j9) {
                                    j9 = jArr[i3];
                                }
                            }
                            c3127y0.f9025i = j9;
                        } else {
                            long jM3001i = C2738e0.m3001i(jM3250j - ((long) (Math.max(0.0f, c3127y0.f9028l - 1.0f) / 1.0E-7f)), c3127y0.f9025i, j8);
                            c3127y0.f9025i = jM3001i;
                            long j10 = c3127y0.f9024h;
                            if (j10 != -9223372036854775807L && jM3001i > j10) {
                                c3127y0.f9025i = j10;
                            }
                        }
                        long j11 = jM3250j - c3127y0.f9025i;
                        if (Math.abs(j11) < c3127y0.f9017a) {
                            c3127y0.f9028l = 1.0f;
                        } else {
                            c3127y0.f9028l = C2738e0.m2999g((1.0E-7f * j11) + 1.0f, c3127y0.f9027k, c3127y0.f9026j);
                        }
                        f2 = c3127y0.f9028l;
                    } else {
                        f2 = c3127y0.f9028l;
                    }
                }
                if (this.f7090x.mo2416c().f8027k != f2) {
                    this.f7090x.mo2418i(new C2998x1(f2, this.f7058G.f7960o.f8028l));
                    m3265t(this.f7058G.f7960o, this.f7090x.mo2416c().f8027k, false, false);
                }
            }
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m3260o(InterfaceC2570x interfaceC2570x) {
        C2847s1 c2847s1 = this.f7053B;
        C2839q1 c2839q1 = c2847s1.f7495j;
        if (c2839q1 != null && c2839q1.f7442a == interfaceC2570x) {
            c2847s1.m3377m(this.f7072U);
            m3269z();
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m3261p(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, iOException, i);
        C2839q1 c2839q1 = this.f7053B.f7493h;
        if (c2839q1 != null) {
            exoPlaybackException = exoPlaybackException.m8754a(c2839q1.f7447f.f7465a);
        }
        C2750q.m3039b("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
        m3251j0(false, false);
        this.f7058G = this.f7058G.m3566e(exoPlaybackException);
    }

    /* JADX INFO: renamed from: q */
    public final void m3262q(boolean z2) {
        C2839q1 c2839q1 = this.f7053B.f7495j;
        InterfaceC2530a0.a aVar = c2839q1 == null ? this.f7058G.f7948c : c2839q1.f7447f.f7465a;
        boolean z3 = !this.f7058G.f7957l.equals(aVar);
        if (z3) {
            this.f7058G = this.f7058G.m3562a(aVar);
        }
        C2964w1 c2964w1 = this.f7058G;
        c2964w1.f7963r = c2839q1 == null ? c2964w1.f7965t : c2839q1.m3350d();
        this.f7058G.f7964s = m3256m();
        if ((z3 || z2) && c2839q1 != null && c2839q1.f7445d) {
            this.f7081o.mo3312d(this.f7076j, c2839q1.f7454m, c2839q1.f7455n.f6328c);
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m3263r(AbstractC2832o2 abstractC2832o2, boolean z2) throws Throwable {
        InterfaceC2530a0.a aVar;
        Object obj;
        int iMo2582a;
        Object obj2;
        long j;
        long j2;
        int i;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iMo2582a2;
        boolean z6;
        boolean z7;
        long j3;
        long j4;
        f fVar;
        long j5;
        int i3;
        long jLongValue;
        Object obj3;
        boolean z8;
        int i4;
        int iMo2582a3;
        boolean z9;
        boolean z10;
        boolean z11;
        long j6;
        g gVar;
        boolean z12;
        boolean z13;
        boolean z14;
        C2964w1 c2964w1 = this.f7058G;
        g gVar2 = this.f7071T;
        C2847s1 c2847s1 = this.f7053B;
        int i5 = this.f7065N;
        boolean z15 = this.f7066O;
        AbstractC2832o2.c cVar = this.f7086t;
        AbstractC2832o2.b bVar = this.f7087u;
        if (abstractC2832o2.m3331q()) {
            InterfaceC2530a0.a aVar2 = C2964w1.f7946a;
            fVar = new f(C2964w1.f7946a, 0L, -9223372036854775807L, false, true, false);
        } else {
            InterfaceC2530a0.a aVar3 = c2964w1.f7948c;
            Object obj4 = aVar3.f5732a;
            boolean zM3211y = m3211y(c2964w1, bVar);
            long j7 = (c2964w1.f7948c.m2593a() || zM3211y) ? c2964w1.f7949d : c2964w1.f7965t;
            if (gVar2 != null) {
                Object obj5 = obj4;
                Pair<Object, Long> pairM3207M = m3207M(abstractC2832o2, gVar2, true, i5, z15, cVar, bVar);
                if (pairM3207M == null) {
                    iMo2582a3 = abstractC2832o2.mo2582a(z15);
                    j6 = j7;
                    z11 = false;
                    z10 = false;
                    z9 = true;
                } else {
                    if (gVar2.f7116c == -9223372036854775807L) {
                        i4 = abstractC2832o2.mo3327h(pairM3207M.first, bVar).f7340l;
                        jLongValue = j7;
                        obj3 = obj5;
                        z8 = false;
                    } else {
                        Object obj6 = pairM3207M.first;
                        jLongValue = ((Long) pairM3207M.second).longValue();
                        obj3 = obj6;
                        z8 = true;
                        i4 = -1;
                    }
                    obj5 = obj3;
                    iMo2582a3 = i4;
                    z9 = false;
                    long j8 = jLongValue;
                    z10 = c2964w1.f7951f == 4;
                    z11 = z8;
                    j6 = j8;
                }
                z5 = z11;
                z3 = z10;
                j2 = j6;
                z4 = z9;
                aVar = aVar3;
                i2 = -1;
                i = iMo2582a3;
                obj2 = obj5;
            } else {
                aVar = aVar3;
                if (c2964w1.f7947b.m3331q()) {
                    iMo2582a = abstractC2832o2.mo2582a(z15);
                    obj = obj4;
                } else if (abstractC2832o2.mo2554b(obj4) == -1) {
                    obj = obj4;
                    Object objM3208N = m3208N(cVar, bVar, i5, z15, obj4, c2964w1.f7947b, abstractC2832o2);
                    if (objM3208N == null) {
                        iMo2582a2 = abstractC2832o2.mo2582a(z15);
                        z6 = true;
                    } else {
                        iMo2582a2 = abstractC2832o2.mo3327h(objM3208N, bVar).f7340l;
                        z6 = false;
                    }
                    z7 = z6;
                    aVar = aVar;
                    i = iMo2582a2;
                    z4 = z7;
                    obj2 = obj;
                    j2 = j7;
                    i2 = -1;
                    z3 = false;
                    z5 = false;
                } else {
                    obj = obj4;
                    if (j7 == -9223372036854775807L) {
                        iMo2582a = abstractC2832o2.mo3327h(obj, bVar).f7340l;
                    } else if (zM3211y) {
                        aVar = aVar;
                        c2964w1.f7947b.mo3327h(aVar.f5732a, bVar);
                        if (c2964w1.f7947b.m3330n(bVar.f7340l, cVar).f7350B == c2964w1.f7947b.mo2554b(aVar.f5732a)) {
                            Pair<Object, Long> pairM3328j = abstractC2832o2.m3328j(cVar, bVar, abstractC2832o2.mo3327h(obj, bVar).f7340l, j7 + bVar.f7342n);
                            Object obj7 = pairM3328j.first;
                            long jLongValue2 = ((Long) pairM3328j.second).longValue();
                            obj2 = obj7;
                            j = jLongValue2;
                        } else {
                            obj2 = obj;
                            j = j7;
                        }
                        j2 = j;
                        i = -1;
                        i2 = -1;
                        z3 = false;
                        z4 = false;
                        z5 = true;
                    } else {
                        iMo2582a = -1;
                        iMo2582a2 = iMo2582a;
                        z7 = false;
                        i = iMo2582a2;
                        z4 = z7;
                        obj2 = obj;
                        j2 = j7;
                        i2 = -1;
                        z3 = false;
                        z5 = false;
                    }
                }
                iMo2582a2 = iMo2582a;
                z7 = false;
                i = iMo2582a2;
                z4 = z7;
                obj2 = obj;
                j2 = j7;
                i2 = -1;
                z3 = false;
                z5 = false;
            }
            if (i != i2) {
                Pair<Object, Long> pairM3328j2 = abstractC2832o2.m3328j(cVar, bVar, i, -9223372036854775807L);
                Object obj8 = pairM3328j2.first;
                long jLongValue3 = ((Long) pairM3328j2.second).longValue();
                obj2 = obj8;
                j2 = jLongValue3;
                j3 = -9223372036854775807L;
            } else {
                j3 = j2;
            }
            InterfaceC2530a0.a aVarM3379o = c2847s1.m3379o(abstractC2832o2, obj2, j2);
            boolean z16 = aVarM3379o.f5736e == -1 || ((i3 = aVar.f5736e) != -1 && aVarM3379o.f5733b >= i3);
            boolean zEquals = aVar.f5732a.equals(obj2);
            boolean z17 = zEquals && !aVar.m2593a() && !aVarM3379o.m2593a() && z16;
            abstractC2832o2.mo3327h(obj2, bVar);
            boolean z18 = zEquals && !zM3211y && j7 == j3 && ((aVarM3379o.m2593a() && bVar.m3336e(aVarM3379o.f5733b)) || (aVar.m2593a() && bVar.m3336e(aVar.f5733b)));
            if (z17 || z18) {
                aVarM3379o = aVar;
            }
            if (aVarM3379o.m2593a()) {
                if (aVarM3379o.equals(aVar)) {
                    j5 = c2964w1.f7965t;
                } else {
                    abstractC2832o2.mo3327h(aVarM3379o.f5732a, bVar);
                    j5 = aVarM3379o.f5734c == bVar.m3335d(aVarM3379o.f5733b) ? bVar.f7344p.f5685o : 0L;
                }
                j4 = j5;
            } else {
                j4 = j2;
            }
            fVar = new f(aVarM3379o, j4, j3, z3, z4, z5);
        }
        f fVar2 = fVar;
        InterfaceC2530a0.a aVar4 = fVar2.f7108a;
        long j9 = fVar2.f7110c;
        boolean z19 = fVar2.f7111d;
        long jM3226R = fVar2.f7109b;
        boolean z20 = (this.f7058G.f7948c.equals(aVar4) && jM3226R == this.f7058G.f7965t) ? false : true;
        try {
            if (fVar2.f7112e) {
                if (this.f7058G.f7951f != 1) {
                    m3244f0(4);
                }
                m3219H(false, false, false, true);
            }
            try {
                if (z20) {
                    z13 = false;
                    z14 = true;
                    if (!abstractC2832o2.m3331q()) {
                        for (C2839q1 c2839q1 = this.f7053B.f7493h; c2839q1 != null; c2839q1 = c2839q1.f7453l) {
                            if (c2839q1.f7447f.f7465a.equals(aVar4)) {
                                c2839q1.f7447f = this.f7053B.m3372h(abstractC2832o2, c2839q1.f7447f);
                                c2839q1.m3356j();
                            }
                        }
                        jM3226R = m3226R(aVar4, jM3226R, z19);
                    }
                } else {
                    try {
                        z13 = false;
                        z14 = true;
                        if (!this.f7053B.m3381r(abstractC2832o2, this.f7072U, m3252k())) {
                            m3224P(false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z12 = true;
                        gVar = null;
                        C2964w1 c2964w2 = this.f7058G;
                        g gVar3 = gVar;
                        m3257m0(abstractC2832o2, aVar4, c2964w2.f7947b, c2964w2.f7948c, fVar2.f7113f ? jM3226R : -9223372036854775807L);
                        if (z20 || j9 != this.f7058G.f7949d) {
                            C2964w1 c2964w3 = this.f7058G;
                            Object obj9 = c2964w3.f7948c.f5732a;
                            AbstractC2832o2 abstractC2832o3 = c2964w3.f7947b;
                            if (!z20 || !z2 || abstractC2832o3.m3331q() || abstractC2832o3.mo3327h(obj9, this.f7087u).f7343o) {
                                z12 = false;
                            }
                            this.f7058G = m3266u(aVar4, jM3226R, j9, this.f7058G.f7950e, z12, abstractC2832o2.mo2554b(obj9) == -1 ? 4 : 3);
                        }
                        m3220I();
                        m3222L(abstractC2832o2, this.f7058G.f7947b);
                        this.f7058G = this.f7058G.m3568g(abstractC2832o2);
                        if (!abstractC2832o2.m3331q()) {
                            this.f7071T = gVar3;
                        }
                        m3262q(false);
                        throw th;
                    }
                }
                C2964w1 c2964w4 = this.f7058G;
                m3257m0(abstractC2832o2, aVar4, c2964w4.f7947b, c2964w4.f7948c, fVar2.f7113f ? jM3226R : -9223372036854775807L);
                if (z20 || j9 != this.f7058G.f7949d) {
                    C2964w1 c2964w5 = this.f7058G;
                    Object obj10 = c2964w5.f7948c.f5732a;
                    AbstractC2832o2 abstractC2832o4 = c2964w5.f7947b;
                    if (!z20 || !z2 || abstractC2832o4.m3331q() || abstractC2832o4.mo3327h(obj10, this.f7087u).f7343o) {
                        z14 = false;
                    }
                    this.f7058G = m3266u(aVar4, jM3226R, j9, this.f7058G.f7950e, z14, abstractC2832o2.mo2554b(obj10) == -1 ? 4 : 3);
                }
                m3220I();
                m3222L(abstractC2832o2, this.f7058G.f7947b);
                this.f7058G = this.f7058G.m3568g(abstractC2832o2);
                if (!abstractC2832o2.m3331q()) {
                    this.f7071T = null;
                }
                m3262q(z13);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            gVar = null;
            z12 = true;
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m3264s(InterfaceC2570x interfaceC2570x) throws ExoPlaybackException {
        C2839q1 c2839q1 = this.f7053B.f7495j;
        if (c2839q1 != null && c2839q1.f7442a == interfaceC2570x) {
            float f2 = this.f7090x.mo2416c().f8027k;
            AbstractC2832o2 abstractC2832o2 = this.f7058G.f7947b;
            c2839q1.f7445d = true;
            c2839q1.f7454m = c2839q1.f7442a.mo2490n();
            C2652r c2652rM3355i = c2839q1.m3355i(f2, abstractC2832o2);
            C2843r1 c2843r1 = c2839q1.f7447f;
            long jMax = c2843r1.f7466b;
            long j = c2843r1.f7469e;
            if (j != -9223372036854775807L && jMax >= j) {
                jMax = Math.max(0L, j - 1);
            }
            long jM3347a = c2839q1.m3347a(c2652rM3355i, jMax, false, new boolean[c2839q1.f7450i.length]);
            long j2 = c2839q1.f7456o;
            C2843r1 c2843r2 = c2839q1.f7447f;
            c2839q1.f7456o = (c2843r2.f7466b - jM3347a) + j2;
            c2839q1.f7447f = c2843r2.m3361b(jM3347a);
            this.f7081o.mo3312d(this.f7076j, c2839q1.f7454m, c2839q1.f7455n.f6328c);
            if (c2839q1 == this.f7053B.f7493h) {
                m3221J(c2839q1.f7447f.f7466b);
                m3245g();
                C2964w1 c2964w1 = this.f7058G;
                InterfaceC2530a0.a aVar = c2964w1.f7948c;
                long j3 = c2839q1.f7447f.f7466b;
                this.f7058G = m3266u(aVar, j3, c2964w1.f7949d, j3, false, 5);
            }
            m3269z();
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m3265t(C2998x1 c2998x1, float f2, boolean z2, boolean z3) throws ExoPlaybackException {
        int i;
        C2803h1 c2803h1 = this;
        if (z2) {
            if (z3) {
                c2803h1.f7059H.m3271a(1);
            }
            C2964w1 c2964w1 = c2803h1.f7058G;
            c2803h1 = this;
            c2803h1.f7058G = new C2964w1(c2964w1.f7947b, c2964w1.f7948c, c2964w1.f7949d, c2964w1.f7950e, c2964w1.f7951f, c2964w1.f7952g, c2964w1.f7953h, c2964w1.f7954i, c2964w1.f7955j, c2964w1.f7956k, c2964w1.f7957l, c2964w1.f7958m, c2964w1.f7959n, c2998x1, c2964w1.f7963r, c2964w1.f7964s, c2964w1.f7965t, c2964w1.f7961p, c2964w1.f7962q);
        }
        float f3 = c2998x1.f8027k;
        C2839q1 c2839q1 = c2803h1.f7053B.f7493h;
        while (true) {
            i = 0;
            if (c2839q1 == null) {
                break;
            }
            InterfaceC2644j[] interfaceC2644jArr = c2839q1.f7455n.f6328c;
            int length = interfaceC2644jArr.length;
            while (i < length) {
                InterfaceC2644j interfaceC2644j = interfaceC2644jArr[i];
                if (interfaceC2644j != null) {
                    interfaceC2644j.mo2726i(f3);
                }
                i++;
            }
            c2839q1 = c2839q1.f7453l;
        }
        InterfaceC2728f2[] interfaceC2728f2Arr = c2803h1.f7076j;
        int length2 = interfaceC2728f2Arr.length;
        while (i < length2) {
            InterfaceC2728f2 interfaceC2728f2 = interfaceC2728f2Arr[i];
            if (interfaceC2728f2 != null) {
                interfaceC2728f2.mo2939n(f2, c2998x1.f8027k);
            }
            i++;
        }
    }

    @CheckResult
    /* JADX INFO: renamed from: u */
    public final C2964w1 m3266u(InterfaceC2530a0.a aVar, long j, long j2, long j3, boolean z2, int i) {
        C2558o0 c2558o0;
        C2652r c2652r;
        List<Metadata> list;
        AbstractC4523p<Object> abstractC4523pM6262l;
        int i2 = 0;
        this.f7074W = (!this.f7074W && j == this.f7058G.f7965t && aVar.equals(this.f7058G.f7948c)) ? false : true;
        m3220I();
        C2964w1 c2964w1 = this.f7058G;
        C2558o0 c2558o1 = c2964w1.f7954i;
        C2652r c2652r2 = c2964w1.f7955j;
        List<Metadata> list2 = c2964w1.f7956k;
        if (this.f7054C.f7873j) {
            C2839q1 c2839q1 = this.f7053B.f7493h;
            C2558o0 c2558o2 = c2839q1 == null ? C2558o0.f5674j : c2839q1.f7454m;
            C2652r c2652r3 = c2839q1 == null ? this.f7080n : c2839q1.f7455n;
            InterfaceC2644j[] interfaceC2644jArr = c2652r3.f6328c;
            C3404f.m4189A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int length = interfaceC2644jArr.length;
            int i3 = 0;
            boolean z3 = false;
            int i4 = 0;
            while (i3 < length) {
                InterfaceC2644j interfaceC2644j = interfaceC2644jArr[i3];
                if (interfaceC2644j != null) {
                    Metadata metadata = interfaceC2644j.mo2729d(i2).f7153u;
                    if (metadata == null) {
                        Metadata metadata2 = new Metadata(new Metadata.Entry[i2]);
                        int i5 = i4 + 1;
                        if (objArrCopyOf.length < i5) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC4519n.b.m6260a(objArrCopyOf.length, i5));
                        }
                        objArrCopyOf[i4] = metadata2;
                        i4 = i5;
                    } else {
                        int i6 = i4 + 1;
                        if (objArrCopyOf.length < i6) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC4519n.b.m6260a(objArrCopyOf.length, i6));
                        }
                        objArrCopyOf[i4] = metadata;
                        i4 = i6;
                        z3 = true;
                    }
                }
                i3++;
                c2558o2 = c2558o2;
                i2 = 0;
            }
            C2558o0 c2558o3 = c2558o2;
            if (z3) {
                abstractC4523pM6262l = AbstractC4523p.m6262l(objArrCopyOf, i4);
            } else {
                AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
                abstractC4523pM6262l = C4508h0.f12012l;
            }
            if (c2839q1 != null) {
                C2843r1 c2843r1 = c2839q1.f7447f;
                if (c2843r1.f7467c != j2) {
                    c2839q1.f7447f = c2843r1.m3360a(j2);
                }
            }
            list = abstractC4523pM6262l;
            c2652r = c2652r3;
            c2558o0 = c2558o3;
        } else if (aVar.equals(c2964w1.f7948c)) {
            c2558o0 = c2558o1;
            c2652r = c2652r2;
            list = list2;
        } else {
            C2558o0 c2558o4 = C2558o0.f5674j;
            C2652r c2652r4 = this.f7080n;
            AbstractC4493a<Object> abstractC4493a2 = AbstractC4523p.f12045k;
            c2558o0 = c2558o4;
            c2652r = c2652r4;
            list = C4508h0.f12012l;
        }
        if (z2) {
            d dVar = this.f7059H;
            if (!dVar.f7104d || dVar.f7105e == 5) {
                dVar.f7101a = true;
                dVar.f7104d = true;
                dVar.f7105e = i;
            } else {
                C1460d.m531j(i == 5);
            }
        }
        return this.f7058G.m3563b(aVar, j, j2, j3, m3256m(), c2558o0, c2652r, list);
    }

    /* JADX INFO: renamed from: v */
    public final boolean m3267v() {
        C2839q1 c2839q1 = this.f7053B.f7495j;
        if (c2839q1 == null) {
            return false;
        }
        return (!c2839q1.f7445d ? 0L : c2839q1.f7442a.mo2479c()) != Long.MIN_VALUE;
    }

    /* JADX INFO: renamed from: x */
    public final boolean m3268x() {
        C2839q1 c2839q1 = this.f7053B.f7493h;
        long j = c2839q1.f7447f.f7469e;
        return c2839q1.f7445d && (j == -9223372036854775807L || this.f7058G.f7965t < j || !m3246g0());
    }

    /* JADX INFO: renamed from: z */
    public final void m3269z() {
        long j;
        long j2;
        boolean zMo3315g;
        if (m3267v()) {
            C2839q1 c2839q1 = this.f7053B.f7495j;
            long jM3258n = m3258n(!c2839q1.f7445d ? 0L : c2839q1.f7442a.mo2479c());
            if (c2839q1 == this.f7053B.f7493h) {
                j = this.f7072U;
                j2 = c2839q1.f7456o;
            } else {
                j = this.f7072U - c2839q1.f7456o;
                j2 = c2839q1.f7447f.f7466b;
            }
            zMo3315g = this.f7081o.mo3315g(j - j2, jM3258n, this.f7090x.mo2416c().f8027k);
        } else {
            zMo3315g = false;
        }
        this.f7064M = zMo3315g;
        if (zMo3315g) {
            C2839q1 c2839q2 = this.f7053B.f7495j;
            long j3 = this.f7072U;
            C1460d.m426D(c2839q2.m3353g());
            c2839q2.f7442a.mo2483g(j3 - c2839q2.f7456o);
        }
        m3255l0();
    }
}
