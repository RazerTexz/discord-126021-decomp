package p007b.p225i.p226a.p242c.p262s2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.C2528a2;
import p007b.p225i.p226a.p242c.C2633c1;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.C2836p2;
import p007b.p225i.p226a.p242c.C2998x1;
import p007b.p225i.p226a.p242c.C3154z1;
import p007b.p225i.p226a.p242c.InterfaceC3128y1;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p243a3.C2566t;
import p007b.p225i.p226a.p242c.p243a3.C2569w;
import p007b.p225i.p226a.p242c.p243a3.C2571y;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0;
import p007b.p225i.p226a.p242c.p255c3.C2648n;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2747n;
import p007b.p225i.p226a.p242c.p259f3.C2749p;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2748o;
import p007b.p225i.p226a.p242c.p260g3.C2786w;
import p007b.p225i.p226a.p242c.p260g3.C2788y;
import p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x;
import p007b.p225i.p226a.p242c.p262s2.InterfaceC2871h1;
import p007b.p225i.p226a.p242c.p263t2.C2933q;
import p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r;
import p007b.p225i.p226a.p242c.p265v2.C2957e;
import p007b.p225i.p226a.p242c.p265v2.C2959g;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.AbstractC4525q;
import p007b.p225i.p355b.p357b.C4508h0;
import p007b.p225i.p355b.p357b.C4510i0;

/* JADX INFO: renamed from: b.i.a.c.s2.g1 */
/* JADX INFO: compiled from: AnalyticsCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2868g1 implements InterfaceC3128y1.e, InterfaceC2934r, InterfaceC2787x, InterfaceC2532b0, InterfaceC2704f.a, InterfaceC2988s {

    /* JADX INFO: renamed from: j */
    public final InterfaceC2740g f7547j;

    /* JADX INFO: renamed from: k */
    public final AbstractC2832o2.b f7548k;

    /* JADX INFO: renamed from: l */
    public final AbstractC2832o2.c f7549l;

    /* JADX INFO: renamed from: m */
    public final a f7550m;

    /* JADX INFO: renamed from: n */
    public final SparseArray<InterfaceC2871h1.a> f7551n;

    /* JADX INFO: renamed from: o */
    public C2749p<InterfaceC2871h1> f7552o;

    /* JADX INFO: renamed from: p */
    public InterfaceC3128y1 f7553p;

    /* JADX INFO: renamed from: q */
    public InterfaceC2748o f7554q;

    /* JADX INFO: renamed from: r */
    public boolean f7555r;

    /* JADX INFO: renamed from: b.i.a.c.s2.g1$a */
    /* JADX INFO: compiled from: AnalyticsCollector.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final AbstractC2832o2.b f7556a;

        /* JADX INFO: renamed from: b */
        public AbstractC4523p<InterfaceC2530a0.a> f7557b;

        /* JADX INFO: renamed from: c */
        public AbstractC4525q<InterfaceC2530a0.a, AbstractC2832o2> f7558c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public InterfaceC2530a0.a f7559d;

        /* JADX INFO: renamed from: e */
        public InterfaceC2530a0.a f7560e;

        /* JADX INFO: renamed from: f */
        public InterfaceC2530a0.a f7561f;

        public a(AbstractC2832o2.b bVar) {
            this.f7556a = bVar;
            AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
            this.f7557b = C4508h0.f12012l;
            this.f7558c = C4510i0.f12015m;
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        public static InterfaceC2530a0.a m3388b(InterfaceC3128y1 interfaceC3128y1, AbstractC4523p<InterfaceC2530a0.a> abstractC4523p, @Nullable InterfaceC2530a0.a aVar, AbstractC2832o2.b bVar) {
            AbstractC2832o2 abstractC2832o2Mo2888K = interfaceC3128y1.mo2888K();
            int iMo2912m = interfaceC3128y1.mo2912m();
            Object objMo2556m = abstractC2832o2Mo2888K.m3331q() ? null : abstractC2832o2Mo2888K.mo2556m(iMo2912m);
            int iM3333b = (interfaceC3128y1.mo2900f() || abstractC2832o2Mo2888K.m3331q()) ? -1 : abstractC2832o2Mo2888K.m3326f(iMo2912m, bVar).m3333b(C2738e0.m2981B(interfaceC3128y1.mo2894T()) - bVar.f7342n);
            for (int i = 0; i < abstractC4523p.size(); i++) {
                InterfaceC2530a0.a aVar2 = abstractC4523p.get(i);
                if (m3389c(aVar2, objMo2556m, interfaceC3128y1.mo2900f(), interfaceC3128y1.mo2880B(), interfaceC3128y1.mo2920q(), iM3333b)) {
                    return aVar2;
                }
            }
            if (abstractC4523p.isEmpty() && aVar != null) {
                if (m3389c(aVar, objMo2556m, interfaceC3128y1.mo2900f(), interfaceC3128y1.mo2880B(), interfaceC3128y1.mo2920q(), iM3333b)) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: c */
        public static boolean m3389c(InterfaceC2530a0.a aVar, @Nullable Object obj, boolean z2, int i, int i2, int i3) {
            if (aVar.f5732a.equals(obj)) {
                return (z2 && aVar.f5733b == i && aVar.f5734c == i2) || (!z2 && aVar.f5733b == -1 && aVar.f5736e == i3);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public final void m3390a(AbstractC4525q.a<InterfaceC2530a0.a, AbstractC2832o2> aVar, @Nullable InterfaceC2530a0.a aVar2, AbstractC2832o2 abstractC2832o2) {
            if (aVar2 == null) {
                return;
            }
            if (abstractC2832o2.mo2554b(aVar2.f5732a) != -1) {
                aVar.m6277c(aVar2, abstractC2832o2);
                return;
            }
            AbstractC2832o2 abstractC2832o3 = this.f7558c.get(aVar2);
            if (abstractC2832o3 != null) {
                aVar.m6277c(aVar2, abstractC2832o3);
            }
        }

        /* JADX INFO: renamed from: d */
        public final void m3391d(AbstractC2832o2 abstractC2832o2) {
            AbstractC4525q.a<InterfaceC2530a0.a, AbstractC2832o2> aVar = new AbstractC4525q.a<>(4);
            if (this.f7557b.isEmpty()) {
                m3390a(aVar, this.f7560e, abstractC2832o2);
                if (!C3404f.m4252V(this.f7561f, this.f7560e)) {
                    m3390a(aVar, this.f7561f, abstractC2832o2);
                }
                if (!C3404f.m4252V(this.f7559d, this.f7560e) && !C3404f.m4252V(this.f7559d, this.f7561f)) {
                    m3390a(aVar, this.f7559d, abstractC2832o2);
                }
            } else {
                for (int i = 0; i < this.f7557b.size(); i++) {
                    m3390a(aVar, this.f7557b.get(i), abstractC2832o2);
                }
                if (!this.f7557b.contains(this.f7559d)) {
                    m3390a(aVar, this.f7559d, abstractC2832o2);
                }
            }
            this.f7558c = aVar.m6275a();
        }
    }

    public C2868g1(InterfaceC2740g interfaceC2740g) {
        this.f7547j = interfaceC2740g;
        this.f7552o = new C2749p<>(new CopyOnWriteArraySet(), C2738e0.m3007o(), interfaceC2740g, new C2749p.b() { // from class: b.i.a.c.s2.o0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.b
            /* JADX INFO: renamed from: a */
            public final void mo3037a(Object obj, C2747n c2747n) {
            }
        });
        AbstractC2832o2.b bVar = new AbstractC2832o2.b();
        this.f7548k = bVar;
        this.f7549l = new AbstractC2832o2.c();
        this.f7550m = new a(bVar);
        this.f7551n = new SparseArray<>();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: A */
    public void mo235A(final C2835p1 c2835p1) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.r0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3447o0();
            }
        };
        this.f7551n.put(14, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(14, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: B */
    public final void mo3291B(final String str) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.t
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3414W();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_ALL_SCROLL, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_ALL_SCROLL, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: C */
    public final void mo3292C(final String str, final long j, final long j2) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.l0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3439k0();
                interfaceC2871h1.m3412U();
                interfaceC2871h1.m3411T();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_VERTICAL_TEXT, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_VERTICAL_TEXT, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: D */
    public final void mo236D(final boolean z2) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.g0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3446o();
            }
        };
        this.f7551n.put(9, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(9, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: E */
    public /* synthetic */ void mo237E(InterfaceC3128y1 interfaceC3128y1, InterfaceC3128y1.d dVar) {
        C2528a2.m2423e(this, interfaceC3128y1, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: F */
    public final void mo3185F(final int i, final long j) {
        final InterfaceC2871h1.a aVarM3386o0 = m3386o0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.z
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3428f();
            }
        };
        this.f7551n.put(AudioAttributesCompat.FLAG_ALL, aVarM3386o0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(AudioAttributesCompat.FLAG_ALL, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: G */
    public /* synthetic */ void mo238G(int i, boolean z2) {
        C2528a2.m2422d(this, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: H */
    public final void mo239H(final boolean z2, final int i) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.j0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3398G();
            }
        };
        this.f7551n.put(-1, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(-1, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: I */
    public final void mo3293I(final C2811j1 c2811j1, @Nullable final C2959g c2959g) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.i0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3425d0();
                interfaceC2871h1.m3455v();
                interfaceC2871h1.m3457x();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_ALIAS, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_ALIAS, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
    /* JADX INFO: renamed from: J */
    public final void mo2567J(int i, @Nullable InterfaceC2530a0.a aVar) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.t0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3416Y();
            }
        };
        this.f7551n.put(1034, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1034, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: K */
    public final void mo3186K(final Object obj, final long j) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.f1
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj2) {
                ((InterfaceC2871h1) obj2).m3422c();
            }
        };
        this.f7551n.put(1027, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1027, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: L */
    public final void mo240L(final int i) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.b0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3420b();
            }
        };
        this.f7551n.put(8, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(8, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: M */
    public final void mo241M(@Nullable final C2831o1 c2831o1, final int i) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.q
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3453t();
            }
        };
        this.f7551n.put(1, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: N */
    public final void mo3294N(final Exception exc) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.e0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3456w();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_ZOOM_IN, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_ZOOM_IN, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: O */
    public /* synthetic */ void mo3187O(C2811j1 c2811j1) {
        C2786w.m3184a(this, c2811j1);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: P */
    public final void mo3188P(final C2957e c2957e) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.d0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3417Z();
                interfaceC2871h1.m3397F();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_GRAB, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_GRAB, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: Q */
    public final void mo3189Q(final C2811j1 c2811j1, @Nullable final C2959g c2959g) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.y0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3433h0();
                interfaceC2871h1.m3393B();
                interfaceC2871h1.m3457x();
            }
        };
        this.f7551n.put(1022, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1022, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: R */
    public final void mo3295R(final long j) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.n0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3436j();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_COPY, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_COPY, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
    /* JADX INFO: renamed from: S */
    public final void mo2568S(int i, @Nullable InterfaceC2530a0.a aVar) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.e1
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3392A();
            }
        };
        this.f7551n.put(1031, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1031, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: T */
    public final void mo3296T(final Exception exc) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.k
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3413V();
            }
        };
        this.f7551n.put(1037, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1037, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: U */
    public /* synthetic */ void mo3297U(C2811j1 c2811j1) {
        C2933q.m3497a(this, c2811j1);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: V */
    public final void mo3190V(final Exception exc) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.q0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3406O();
            }
        };
        this.f7551n.put(1038, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1038, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: W */
    public final void mo242W(final boolean z2, final int i) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.d1
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3426e();
            }
        };
        this.f7551n.put(5, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(5, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
    /* JADX INFO: renamed from: X */
    public final void mo2461X(int i, @Nullable InterfaceC2530a0.a aVar, final C2566t c2566t, final C2569w c2569w) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.y
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3448p();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_CONTEXT_MENU, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_CONTEXT_MENU, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: Y */
    public final void mo243Y(final C2558o0 c2558o0, final C2648n c2648n) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.i
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3443m0();
            }
        };
        this.f7551n.put(2, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(2, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: Z */
    public final void mo3191Z(final C2957e c2957e) {
        final InterfaceC2871h1.a aVarM3386o0 = m3386o0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.j
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3442m();
                interfaceC2871h1.m3430g();
            }
        };
        this.f7551n.put(InputDeviceCompat.SOURCE_GAMEPAD, aVarM3386o0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(InputDeviceCompat.SOURCE_GAMEPAD, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: a */
    public final void mo244a() {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.u
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3418a();
            }
        };
        this.f7551n.put(-1, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(-1, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: a0 */
    public void mo245a0(final int i, final int i2) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.n
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3440l();
            }
        };
        this.f7551n.put(1029, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1029, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: b */
    public final void mo246b(final Metadata metadata) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.v
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3429f0();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_CROSSHAIR, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_CROSSHAIR, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: b0 */
    public final void mo247b0(final C2998x1 c2998x1) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.m
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3400I();
            }
        };
        this.f7551n.put(12, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(12, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo248c() {
        C2528a2.m2436r(this);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
    /* JADX INFO: renamed from: c0 */
    public final void mo2571c0(int i, @Nullable InterfaceC2530a0.a aVar, final int i2) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.p0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3449p0();
                interfaceC2871h1.m3415X();
            }
        };
        this.f7551n.put(1030, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1030, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: d */
    public final void mo249d(final boolean z2) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.u0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3450q();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
    /* JADX INFO: renamed from: d0 */
    public final void mo2572d0(int i, @Nullable InterfaceC2530a0.a aVar) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.b
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3431g0();
            }
        };
        this.f7551n.put(1035, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1035, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: e */
    public /* synthetic */ void mo250e(List list) {
        C2528a2.m2420b(this, list);
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: e0 */
    public final void mo3300e0(final int i, final long j, final long j2) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.c0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3394C();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_NO_DROP, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_NO_DROP, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: f */
    public final void mo251f(final C2788y c2788y) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.m0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                C2788y c2788y2 = c2788y;
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3445n0();
                int i = c2788y2.f6955k;
                interfaceC2871h1.m3451r();
            }
        };
        this.f7551n.put(1028, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1028, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: f0 */
    public /* synthetic */ void mo252f0(PlaybackException playbackException) {
        C2528a2.m2434p(this, playbackException);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: g */
    public final void mo253g(final InterfaceC3128y1.f fVar, final InterfaceC3128y1.f fVar2, final int i) {
        if (i == 1) {
            this.f7555r = false;
        }
        a aVar = this.f7550m;
        InterfaceC3128y1 interfaceC3128y1 = this.f7553p;
        Objects.requireNonNull(interfaceC3128y1);
        aVar.f7559d = a.m3388b(interfaceC3128y1, aVar.f7557b, aVar.f7560e, aVar.f7556a);
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.r
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3410S();
                interfaceC2871h1.m3458y();
            }
        };
        this.f7551n.put(11, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(11, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
    /* JADX INFO: renamed from: g0 */
    public final void mo2462g0(int i, @Nullable InterfaceC2530a0.a aVar, final C2566t c2566t, final C2569w c2569w, final IOException iOException, final boolean z2) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.f0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3454u();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_HELP, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_HELP, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: h */
    public final void mo254h(final int i) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.b1
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3427e0();
            }
        };
        this.f7551n.put(6, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(6, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: h0 */
    public final void mo3193h0(final long j, final int i) {
        final InterfaceC2871h1.a aVarM3386o0 = m3386o0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.c1
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3419a0();
            }
        };
        this.f7551n.put(1026, aVarM3386o0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1026, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: i */
    public /* synthetic */ void mo255i(boolean z2) {
        C3154z1.m3876d(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
    /* JADX INFO: renamed from: i0 */
    public final void mo2573i0(int i, @Nullable InterfaceC2530a0.a aVar) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.v0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3452s();
            }
        };
        this.f7551n.put(1033, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1033, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: j */
    public /* synthetic */ void mo256j(int i) {
        C3154z1.m3884l(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: j0 */
    public void mo257j0(final boolean z2) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.z0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3395D();
            }
        };
        this.f7551n.put(7, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(7, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: k */
    public final void mo3301k(final C2957e c2957e) {
        final InterfaceC2871h1.a aVarM3386o0 = m3386o0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.w0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3424d();
                interfaceC2871h1.m3430g();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, aVarM3386o0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, aVar);
        c2749p.m3034a();
    }

    /* JADX INFO: renamed from: k0 */
    public final InterfaceC2871h1.a m3382k0() {
        return m3384m0(this.f7550m.f7559d);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: l */
    public final void mo3194l(final String str) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.f
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3405N();
            }
        };
        this.f7551n.put(1024, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1024, aVar);
        c2749p.m3034a();
    }

    @RequiresNonNull({"player"})
    /* JADX INFO: renamed from: l0 */
    public final InterfaceC2871h1.a m3383l0(AbstractC2832o2 abstractC2832o2, int i, @Nullable InterfaceC2530a0.a aVar) {
        long jMo2928w;
        InterfaceC2530a0.a aVar2 = abstractC2832o2.m3331q() ? null : aVar;
        long jMo2952d = this.f7547j.mo2952d();
        boolean z2 = false;
        boolean z3 = abstractC2832o2.equals(this.f7553p.mo2888K()) && i == this.f7553p.mo2881C();
        long jM3339a = 0;
        if (aVar2 == null || !aVar2.m2593a()) {
            if (z3) {
                jMo2928w = this.f7553p.mo2928w();
            } else if (!abstractC2832o2.m3331q()) {
                jM3339a = abstractC2832o2.mo2514o(i, this.f7549l, 0L).m3339a();
            }
            return new InterfaceC2871h1.a(jMo2952d, abstractC2832o2, i, aVar2, jMo2928w, this.f7553p.mo2888K(), this.f7553p.mo2881C(), this.f7550m.f7559d, this.f7553p.mo2894T(), this.f7553p.mo2902g());
        }
        if (z3 && this.f7553p.mo2880B() == aVar2.f5733b && this.f7553p.mo2920q() == aVar2.f5734c) {
            z2 = true;
        }
        if (z2) {
            jM3339a = this.f7553p.mo2894T();
        }
        jMo2928w = jM3339a;
        return new InterfaceC2871h1.a(jMo2952d, abstractC2832o2, i, aVar2, jMo2928w, this.f7553p.mo2888K(), this.f7553p.mo2881C(), this.f7550m.f7559d, this.f7553p.mo2894T(), this.f7553p.mo2902g());
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
    /* JADX INFO: renamed from: m */
    public final void mo3302m(final C2957e c2957e) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.l
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3432h();
                interfaceC2871h1.m3397F();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_TEXT, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_TEXT, aVar);
        c2749p.m3034a();
    }

    /* JADX INFO: renamed from: m0 */
    public final InterfaceC2871h1.a m3384m0(@Nullable InterfaceC2530a0.a aVar) {
        Objects.requireNonNull(this.f7553p);
        AbstractC2832o2 abstractC2832o2 = aVar == null ? null : this.f7550m.f7558c.get(aVar);
        if (aVar != null && abstractC2832o2 != null) {
            return m3383l0(abstractC2832o2, abstractC2832o2.mo3327h(aVar.f5732a, this.f7548k).f7340l, aVar);
        }
        int iMo2881C = this.f7553p.mo2881C();
        AbstractC2832o2 abstractC2832o2Mo2888K = this.f7553p.mo2888K();
        if (!(iMo2881C < abstractC2832o2Mo2888K.mo2557p())) {
            abstractC2832o2Mo2888K = AbstractC2832o2.f7337j;
        }
        return m3383l0(abstractC2832o2Mo2888K, iMo2881C, null);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
    /* JADX INFO: renamed from: n */
    public final void mo3195n(final String str, final long j, final long j2) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.d
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3435i0();
                interfaceC2871h1.m3404M();
                interfaceC2871h1.m3411T();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_GRABBING, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_GRABBING, aVar);
        c2749p.m3034a();
    }

    /* JADX INFO: renamed from: n0 */
    public final InterfaceC2871h1.a m3385n0(int i, @Nullable InterfaceC2530a0.a aVar) {
        Objects.requireNonNull(this.f7553p);
        if (aVar != null) {
            return this.f7550m.f7558c.get(aVar) != null ? m3384m0(aVar) : m3383l0(AbstractC2832o2.f7337j, i, aVar);
        }
        AbstractC2832o2 abstractC2832o2Mo2888K = this.f7553p.mo2888K();
        if (!(i < abstractC2832o2Mo2888K.mo2557p())) {
            abstractC2832o2Mo2888K = AbstractC2832o2.f7337j;
        }
        return m3383l0(abstractC2832o2Mo2888K, i, null);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
    /* JADX INFO: renamed from: o */
    public final void mo2463o(int i, @Nullable InterfaceC2530a0.a aVar, final C2569w c2569w) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.g
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3399H();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_WAIT, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_WAIT, aVar2);
        c2749p.m3034a();
    }

    /* JADX INFO: renamed from: o0 */
    public final InterfaceC2871h1.a m3386o0() {
        return m3384m0(this.f7550m.f7560e);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: p */
    public void mo258p(final C2836p2 c2836p2) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.w
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3434i();
            }
        };
        this.f7551n.put(2, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(2, aVar);
        c2749p.m3034a();
    }

    /* JADX INFO: renamed from: p0 */
    public final InterfaceC2871h1.a m3387p0() {
        return m3384m0(this.f7550m.f7561f);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
    /* JADX INFO: renamed from: q */
    public final void mo2464q(int i, @Nullable InterfaceC2530a0.a aVar, final C2566t c2566t, final C2569w c2569w) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.h0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3438k();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_HAND, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_HAND, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: r */
    public final void mo259r(final boolean z2) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.e
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                interfaceC2871h1.m3403L();
                interfaceC2871h1.m3408Q();
            }
        };
        this.f7551n.put(3, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(3, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: s */
    public final void mo260s(final PlaybackException playbackException) {
        C2571y c2571y;
        final InterfaceC2871h1.a aVarM3384m0 = (!(playbackException instanceof ExoPlaybackException) || (c2571y = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? null : m3384m0(new InterfaceC2530a0.a(c2571y));
        if (aVarM3384m0 == null) {
            aVarM3384m0 = m3382k0();
        }
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.a
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3401J();
            }
        };
        this.f7551n.put(10, aVarM3384m0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(10, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: t */
    public void mo261t(final InterfaceC3128y1.b bVar) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.a0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3407P();
            }
        };
        this.f7551n.put(13, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(13, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
    /* JADX INFO: renamed from: u */
    public final void mo2574u(int i, @Nullable InterfaceC2530a0.a aVar, final Exception exc) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.c
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3444n();
            }
        };
        this.f7551n.put(1032, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1032, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: v */
    public final void mo262v(AbstractC2832o2 abstractC2832o2, final int i) {
        a aVar = this.f7550m;
        InterfaceC3128y1 interfaceC3128y1 = this.f7553p;
        Objects.requireNonNull(interfaceC3128y1);
        aVar.f7559d = a.m3388b(interfaceC3128y1, aVar.f7557b, aVar.f7560e, aVar.f7556a);
        aVar.m3391d(interfaceC3128y1.mo2888K());
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.x
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3459z();
            }
        };
        this.f7551n.put(0, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(0, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: w */
    public final void mo263w(final float f) {
        final InterfaceC2871h1.a aVarM3387p0 = m3387p0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.s
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3421b0();
            }
        };
        this.f7551n.put(PointerIconCompat.TYPE_ZOOM_OUT, aVarM3387p0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(PointerIconCompat.TYPE_ZOOM_OUT, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
    /* JADX INFO: renamed from: x */
    public final void mo2465x(int i, @Nullable InterfaceC2530a0.a aVar, final C2566t c2566t, final C2569w c2569w) {
        final InterfaceC2871h1.a aVarM3385n0 = m3385n0(i, aVar);
        C2749p.a<InterfaceC2871h1> aVar2 = new C2749p.a() { // from class: b.i.a.c.s2.k0
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3409R();
            }
        };
        this.f7551n.put(1000, aVarM3385n0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(1000, aVar2);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: y */
    public final void mo264y(final int i) {
        final InterfaceC2871h1.a aVarM3382k0 = m3382k0();
        C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.a1
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC2871h1) obj).m3423c0();
            }
        };
        this.f7551n.put(4, aVarM3382k0);
        C2749p<InterfaceC2871h1> c2749p = this.f7552o;
        c2749p.m3035b(4, aVar);
        c2749p.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: z */
    public /* synthetic */ void mo265z(C2633c1 c2633c1) {
        C2528a2.m2421c(this, c2633c1);
    }
}
