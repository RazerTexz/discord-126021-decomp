package p007b.p225i.p226a.p242c;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2534c0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0;
import p007b.p225i.p226a.p242c.p255c3.AbstractC2651q;
import p007b.p225i.p226a.p242c.p255c3.C2642h;
import p007b.p225i.p226a.p242c.p255c3.C2648n;
import p007b.p225i.p226a.p242c.p255c3.C2652r;
import p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f;
import p007b.p225i.p226a.p242c.p259f3.C2732b0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2747n;
import p007b.p225i.p226a.p242c.p259f3.C2749p;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2748o;
import p007b.p225i.p226a.p242c.p260g3.C2788y;
import p007b.p225i.p226a.p242c.p262s2.C2868g1;
import p007b.p225i.p226a.p242c.p262s2.InterfaceC2871h1;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.f1 */
/* JADX INFO: compiled from: ExoPlayerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2727f1 extends AbstractC2944u0 {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ int f6651b = 0;

    /* JADX INFO: renamed from: A */
    public int f6652A;

    /* JADX INFO: renamed from: B */
    public InterfaceC2550k0 f6653B;

    /* JADX INFO: renamed from: C */
    public InterfaceC3128y1.b f6654C;

    /* JADX INFO: renamed from: D */
    public C2835p1 f6655D;

    /* JADX INFO: renamed from: E */
    public C2835p1 f6656E;

    /* JADX INFO: renamed from: F */
    public C2964w1 f6657F;

    /* JADX INFO: renamed from: G */
    public int f6658G;

    /* JADX INFO: renamed from: H */
    public long f6659H;

    /* JADX INFO: renamed from: c */
    public final C2652r f6660c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC3128y1.b f6661d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2728f2[] f6662e;

    /* JADX INFO: renamed from: f */
    public final AbstractC2651q f6663f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC2748o f6664g;

    /* JADX INFO: renamed from: h */
    public final C2803h1.e f6665h;

    /* JADX INFO: renamed from: i */
    public final C2803h1 f6666i;

    /* JADX INFO: renamed from: j */
    public final C2749p<InterfaceC3128y1.c> f6667j;

    /* JADX INFO: renamed from: k */
    public final CopyOnWriteArraySet<InterfaceC2677e1.a> f6668k;

    /* JADX INFO: renamed from: l */
    public final AbstractC2832o2.b f6669l;

    /* JADX INFO: renamed from: m */
    public final List<a> f6670m;

    /* JADX INFO: renamed from: n */
    public final boolean f6671n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC2534c0 f6672o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final C2868g1 f6673p;

    /* JADX INFO: renamed from: q */
    public final Looper f6674q;

    /* JADX INFO: renamed from: r */
    public final InterfaceC2704f f6675r;

    /* JADX INFO: renamed from: s */
    public final long f6676s;

    /* JADX INFO: renamed from: t */
    public final long f6677t;

    /* JADX INFO: renamed from: u */
    public final InterfaceC2740g f6678u;

    /* JADX INFO: renamed from: v */
    public int f6679v;

    /* JADX INFO: renamed from: w */
    public boolean f6680w;

    /* JADX INFO: renamed from: x */
    public int f6681x;

    /* JADX INFO: renamed from: y */
    public int f6682y;

    /* JADX INFO: renamed from: z */
    public boolean f6683z;

    /* JADX INFO: renamed from: b.i.a.c.f1$a */
    /* JADX INFO: compiled from: ExoPlayerImpl.java */
    public static final class a implements InterfaceC2910t1 {

        /* JADX INFO: renamed from: a */
        public final Object f6684a;

        /* JADX INFO: renamed from: b */
        public AbstractC2832o2 f6685b;

        public a(Object obj, AbstractC2832o2 abstractC2832o2) {
            this.f6684a = obj;
            this.f6685b = abstractC2832o2;
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC2910t1
        /* JADX INFO: renamed from: a */
        public AbstractC2832o2 mo2931a() {
            return this.f6685b;
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC2910t1
        public Object getUid() {
            return this.f6684a;
        }
    }

    static {
        C2807i1.m3272a("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public C2727f1(InterfaceC2728f2[] interfaceC2728f2Arr, AbstractC2651q abstractC2651q, InterfaceC2534c0 interfaceC2534c0, InterfaceC2827n1 interfaceC2827n1, InterfaceC2704f interfaceC2704f, @Nullable final C2868g1 c2868g1, boolean z2, C2812j2 c2812j2, long j, long j2, InterfaceC2823m1 interfaceC2823m1, long j3, boolean z3, InterfaceC2740g interfaceC2740g, Looper looper, @Nullable final InterfaceC3128y1 interfaceC3128y1, InterfaceC3128y1.b bVar) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = C2738e0.f6712e;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str, C1643a.m841b(hexString, 30)), "Init ", hexString, " [", "ExoPlayerLib/2.16.0");
        sbM831S.append("] [");
        sbM831S.append(str);
        sbM831S.append("]");
        Log.i("ExoPlayerImpl", sbM831S.toString());
        C1460d.m426D(interfaceC2728f2Arr.length > 0);
        this.f6662e = interfaceC2728f2Arr;
        Objects.requireNonNull(abstractC2651q);
        this.f6663f = abstractC2651q;
        this.f6672o = interfaceC2534c0;
        this.f6675r = interfaceC2704f;
        this.f6673p = c2868g1;
        this.f6671n = z2;
        this.f6676s = j;
        this.f6677t = j2;
        this.f6674q = looper;
        this.f6678u = interfaceC2740g;
        this.f6679v = 0;
        this.f6667j = new C2749p<>(new CopyOnWriteArraySet(), looper, interfaceC2740g, new C2749p.b() { // from class: b.i.a.c.u
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.b
            /* JADX INFO: renamed from: a */
            public final void mo3037a(Object obj, C2747n c2747n) {
                ((InterfaceC3128y1.c) obj).mo237E(interfaceC3128y1, new InterfaceC3128y1.d(c2747n));
            }
        });
        this.f6668k = new CopyOnWriteArraySet<>();
        this.f6670m = new ArrayList();
        this.f6653B = new InterfaceC2550k0.a(0, new Random());
        this.f6660c = new C2652r(new C2804h2[interfaceC2728f2Arr.length], new InterfaceC2644j[interfaceC2728f2Arr.length], C2836p2.f7433j, null);
        this.f6669l = new AbstractC2832o2.b();
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 20, 30};
        for (int i = 0; i < 12; i++) {
            int i2 = iArr[i];
            C1460d.m426D(!false);
            sparseBooleanArray.append(i2, true);
        }
        if (abstractC2651q instanceof C2642h) {
            C1460d.m426D(!false);
            sparseBooleanArray.append(29, true);
        }
        C2747n c2747n = bVar.f9033k;
        for (int i3 = 0; i3 < c2747n.m3031c(); i3++) {
            int iM3030b = c2747n.m3030b(i3);
            C1460d.m426D(true);
            sparseBooleanArray.append(iM3030b, true);
        }
        C1460d.m426D(true);
        C2747n c2747n2 = new C2747n(sparseBooleanArray, null);
        this.f6661d = new InterfaceC3128y1.b(c2747n2, null);
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
        for (int i4 = 0; i4 < c2747n2.m3031c(); i4++) {
            int iM3030b2 = c2747n2.m3030b(i4);
            C1460d.m426D(true);
            sparseBooleanArray2.append(iM3030b2, true);
        }
        C1460d.m426D(true);
        sparseBooleanArray2.append(4, true);
        C1460d.m426D(true);
        sparseBooleanArray2.append(10, true);
        C1460d.m426D(true);
        this.f6654C = new InterfaceC3128y1.b(new C2747n(sparseBooleanArray2, null), null);
        C2835p1 c2835p1 = C2835p1.f7368j;
        this.f6655D = c2835p1;
        this.f6656E = c2835p1;
        this.f6658G = -1;
        this.f6664g = interfaceC2740g.mo2950b(looper, null);
        C2962w c2962w = new C2962w(this);
        this.f6665h = c2962w;
        this.f6657F = C2964w1.m3561h(this.f6660c);
        if (c2868g1 != null) {
            C1460d.m426D(c2868g1.f7553p == null || c2868g1.f7550m.f7557b.isEmpty());
            c2868g1.f7553p = interfaceC3128y1;
            c2868g1.f7554q = c2868g1.f7547j.mo2950b(looper, null);
            C2749p<InterfaceC2871h1> c2749p = c2868g1.f7552o;
            c2868g1.f7552o = new C2749p<>(c2749p.f6739d, looper, c2749p.f6736a, new C2749p.b() { // from class: b.i.a.c.s2.h
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.b
                /* JADX INFO: renamed from: a */
                public final void mo3037a(Object obj, C2747n c2747n3) {
                    InterfaceC2871h1 interfaceC2871h1 = (InterfaceC2871h1) obj;
                    SparseArray<InterfaceC2871h1.a> sparseArray = c2868g1.f7551n;
                    SparseArray sparseArray2 = new SparseArray(c2747n3.m3031c());
                    for (int i5 = 0; i5 < c2747n3.m3031c(); i5++) {
                        int iM3030b3 = c2747n3.m3030b(i5);
                        InterfaceC2871h1.a aVar = sparseArray.get(iM3030b3);
                        Objects.requireNonNull(aVar);
                        sparseArray2.append(iM3030b3, aVar);
                    }
                    interfaceC2871h1.m3402K();
                }
            });
            m2898d0(c2868g1);
            interfaceC2704f.mo2846f(new Handler(looper), c2868g1);
        }
        this.f6666i = new C2803h1(interfaceC2728f2Arr, abstractC2651q, this.f6660c, interfaceC2827n1, interfaceC2704f, this.f6679v, this.f6680w, c2868g1, c2812j2, interfaceC2823m1, j3, z3, looper, interfaceC2740g, c2962w);
    }

    /* JADX INFO: renamed from: j0 */
    public static long m2877j0(C2964w1 c2964w1) {
        AbstractC2832o2.c cVar = new AbstractC2832o2.c();
        AbstractC2832o2.b bVar = new AbstractC2832o2.b();
        c2964w1.f7947b.mo3327h(c2964w1.f7948c.f5732a, bVar);
        long j = c2964w1.f7949d;
        return j == -9223372036854775807L ? c2964w1.f7947b.m3330n(bVar.f7340l, cVar).f7365z : bVar.f7342n + j;
    }

    /* JADX INFO: renamed from: k0 */
    public static boolean m2878k0(C2964w1 c2964w1) {
        return c2964w1.f7951f == 3 && c2964w1.f7958m && c2964w1.f7959n == 0;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: A */
    public List mo2879A() {
        AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
        return C4508h0.f12012l;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: B */
    public int mo2880B() {
        if (mo2900f()) {
            return this.f6657F.f7948c.f5733b;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: C */
    public int mo2881C() {
        int iM2905h0 = m2905h0();
        if (iM2905h0 == -1) {
            return 0;
        }
        return iM2905h0;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: E */
    public void mo2882E(final int i) {
        if (this.f6679v != i) {
            this.f6679v = i;
            ((C2732b0.b) this.f6666i.f7083q.mo2954a(11, i, 0)).m2965b();
            this.f6667j.m3035b(8, new C2749p.a() { // from class: b.i.a.c.k
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj) {
                    ((InterfaceC3128y1.c) obj).mo240L(i);
                }
            });
            m2923r0();
            this.f6667j.m3034a();
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: F */
    public void mo2883F(@Nullable SurfaceView surfaceView) {
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: G */
    public int mo2884G() {
        return this.f6657F.f7959n;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: H */
    public C2836p2 mo2885H() {
        return this.f6657F.f7955j.f6329d;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: I */
    public int mo2886I() {
        return this.f6679v;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: J */
    public long mo2887J() {
        if (mo2900f()) {
            C2964w1 c2964w1 = this.f6657F;
            InterfaceC2530a0.a aVar = c2964w1.f7948c;
            c2964w1.f7947b.mo3327h(aVar.f5732a, this.f6669l);
            return C2738e0.m2992M(this.f6669l.m3332a(aVar.f5733b, aVar.f5734c));
        }
        AbstractC2832o2 abstractC2832o2Mo2888K = mo2888K();
        if (abstractC2832o2Mo2888K.m3331q()) {
            return -9223372036854775807L;
        }
        return abstractC2832o2Mo2888K.m3330n(mo2881C(), this.f7863a).m3340b();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: K */
    public AbstractC2832o2 mo2888K() {
        return this.f6657F.f7947b;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: L */
    public Looper mo2889L() {
        return this.f6674q;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: M */
    public boolean mo2890M() {
        return this.f6680w;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: N */
    public long mo2891N() {
        if (this.f6657F.f7947b.m3331q()) {
            return this.f6659H;
        }
        C2964w1 c2964w1 = this.f6657F;
        if (c2964w1.f7957l.f5735d != c2964w1.f7948c.f5735d) {
            return c2964w1.f7947b.m3330n(mo2881C(), this.f7863a).m3340b();
        }
        long j = c2964w1.f7963r;
        if (this.f6657F.f7957l.m2593a()) {
            C2964w1 c2964w2 = this.f6657F;
            AbstractC2832o2.b bVarMo3327h = c2964w2.f7947b.mo3327h(c2964w2.f7957l.f5732a, this.f6669l);
            long jM3334c = bVarMo3327h.m3334c(this.f6657F.f7957l.f5733b);
            j = jM3334c == Long.MIN_VALUE ? bVarMo3327h.f7341m : jM3334c;
        }
        C2964w1 c2964w3 = this.f6657F;
        return C2738e0.m2992M(m2913m0(c2964w3.f7947b, c2964w3.f7957l, j));
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: Q */
    public void mo2892Q(@Nullable TextureView textureView) {
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: S */
    public C2835p1 mo2893S() {
        return this.f6655D;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: T */
    public long mo2894T() {
        return C2738e0.m2992M(m2903g0(this.f6657F));
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: U */
    public long mo2895U() {
        return this.f6676s;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: a */
    public void mo2896a() {
        C2964w1 c2964w1 = this.f6657F;
        if (c2964w1.f7951f != 1) {
            return;
        }
        C2964w1 c2964w1M3566e = c2964w1.m3566e(null);
        C2964w1 c2964w1M3567f = c2964w1M3566e.m3567f(c2964w1M3566e.f7947b.m3331q() ? 4 : 2);
        this.f6681x++;
        ((C2732b0.b) this.f6666i.f7083q.mo2956c(0)).m2965b();
        m2924s0(c2964w1M3567f, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: c */
    public C2998x1 mo2897c() {
        return this.f6657F.f7960o;
    }

    /* JADX INFO: renamed from: d0 */
    public void m2898d0(InterfaceC3128y1.c cVar) {
        C2749p<InterfaceC3128y1.c> c2749p = this.f6667j;
        if (c2749p.f6742g) {
            return;
        }
        Objects.requireNonNull(cVar);
        c2749p.f6739d.add(new C2749p.c<>(cVar));
    }

    /* JADX INFO: renamed from: e0 */
    public final C2835p1 m2899e0() {
        AbstractC2832o2 abstractC2832o2Mo2888K = mo2888K();
        C2831o1 c2831o1 = abstractC2832o2Mo2888K.m3331q() ? null : abstractC2832o2Mo2888K.m3330n(mo2881C(), this.f7863a).f7355p;
        if (c2831o1 == null) {
            return this.f6656E;
        }
        C2835p1.b bVarM3344a = this.f6656E.m3344a();
        C2835p1 c2835p1 = c2831o1.f7265n;
        if (c2835p1 != null) {
            CharSequence charSequence = c2835p1.f7387l;
            if (charSequence != null) {
                bVarM3344a.f7407a = charSequence;
            }
            CharSequence charSequence2 = c2835p1.f7388m;
            if (charSequence2 != null) {
                bVarM3344a.f7408b = charSequence2;
            }
            CharSequence charSequence3 = c2835p1.f7389n;
            if (charSequence3 != null) {
                bVarM3344a.f7409c = charSequence3;
            }
            CharSequence charSequence4 = c2835p1.f7390o;
            if (charSequence4 != null) {
                bVarM3344a.f7410d = charSequence4;
            }
            CharSequence charSequence5 = c2835p1.f7391p;
            if (charSequence5 != null) {
                bVarM3344a.f7411e = charSequence5;
            }
            CharSequence charSequence6 = c2835p1.f7392q;
            if (charSequence6 != null) {
                bVarM3344a.f7412f = charSequence6;
            }
            CharSequence charSequence7 = c2835p1.f7393r;
            if (charSequence7 != null) {
                bVarM3344a.f7413g = charSequence7;
            }
            Uri uri = c2835p1.f7394s;
            if (uri != null) {
                bVarM3344a.f7414h = uri;
            }
            AbstractC2656d2 abstractC2656d2 = c2835p1.f7395t;
            if (abstractC2656d2 != null) {
                bVarM3344a.f7415i = abstractC2656d2;
            }
            AbstractC2656d2 abstractC2656d3 = c2835p1.f7396u;
            if (abstractC2656d3 != null) {
                bVarM3344a.f7416j = abstractC2656d3;
            }
            byte[] bArr = c2835p1.f7397v;
            if (bArr != null) {
                Integer num = c2835p1.f7398w;
                bVarM3344a.f7417k = (byte[]) bArr.clone();
                bVarM3344a.f7418l = num;
            }
            Uri uri2 = c2835p1.f7399x;
            if (uri2 != null) {
                bVarM3344a.f7419m = uri2;
            }
            Integer num2 = c2835p1.f7400y;
            if (num2 != null) {
                bVarM3344a.f7420n = num2;
            }
            Integer num3 = c2835p1.f7401z;
            if (num3 != null) {
                bVarM3344a.f7421o = num3;
            }
            Integer num4 = c2835p1.f7370A;
            if (num4 != null) {
                bVarM3344a.f7422p = num4;
            }
            Boolean bool = c2835p1.f7371B;
            if (bool != null) {
                bVarM3344a.f7423q = bool;
            }
            Integer num5 = c2835p1.f7372C;
            if (num5 != null) {
                bVarM3344a.f7424r = num5;
            }
            Integer num6 = c2835p1.f7373D;
            if (num6 != null) {
                bVarM3344a.f7424r = num6;
            }
            Integer num7 = c2835p1.f7374E;
            if (num7 != null) {
                bVarM3344a.f7425s = num7;
            }
            Integer num8 = c2835p1.f7375F;
            if (num8 != null) {
                bVarM3344a.f7426t = num8;
            }
            Integer num9 = c2835p1.f7376G;
            if (num9 != null) {
                bVarM3344a.f7427u = num9;
            }
            Integer num10 = c2835p1.f7377H;
            if (num10 != null) {
                bVarM3344a.f7428v = num10;
            }
            Integer num11 = c2835p1.f7378I;
            if (num11 != null) {
                bVarM3344a.f7429w = num11;
            }
            CharSequence charSequence8 = c2835p1.f7379J;
            if (charSequence8 != null) {
                bVarM3344a.f7430x = charSequence8;
            }
            CharSequence charSequence9 = c2835p1.f7380K;
            if (charSequence9 != null) {
                bVarM3344a.f7431y = charSequence9;
            }
            CharSequence charSequence10 = c2835p1.f7381L;
            if (charSequence10 != null) {
                bVarM3344a.f7432z = charSequence10;
            }
            Integer num12 = c2835p1.f7382M;
            if (num12 != null) {
                bVarM3344a.f7402A = num12;
            }
            Integer num13 = c2835p1.f7383N;
            if (num13 != null) {
                bVarM3344a.f7403B = num13;
            }
            CharSequence charSequence11 = c2835p1.f7384O;
            if (charSequence11 != null) {
                bVarM3344a.f7404C = charSequence11;
            }
            CharSequence charSequence12 = c2835p1.f7385P;
            if (charSequence12 != null) {
                bVarM3344a.f7405D = charSequence12;
            }
            Bundle bundle = c2835p1.f7386Q;
            if (bundle != null) {
                bVarM3344a.f7406E = bundle;
            }
        }
        return bVarM3344a.m3345a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: f */
    public boolean mo2900f() {
        return this.f6657F.f7948c.m2593a();
    }

    /* JADX INFO: renamed from: f0 */
    public C2576b2 m2901f0(C2576b2.b bVar) {
        return new C2576b2(this.f6666i, bVar, this.f6657F.f7947b, mo2881C(), this.f6678u, this.f6666i.f7085s);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: g */
    public long mo2902g() {
        return C2738e0.m2992M(this.f6657F.f7964s);
    }

    /* JADX INFO: renamed from: g0 */
    public final long m2903g0(C2964w1 c2964w1) {
        if (c2964w1.f7947b.m3331q()) {
            return C2738e0.m2981B(this.f6659H);
        }
        return c2964w1.f7948c.m2593a() ? c2964w1.f7965t : m2913m0(c2964w1.f7947b, c2964w1.f7948c, c2964w1.f7965t);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: h */
    public void mo2904h(int i, long j) {
        AbstractC2832o2 abstractC2832o2 = this.f6657F.f7947b;
        if (i < 0 || (!abstractC2832o2.m3331q() && i >= abstractC2832o2.mo2557p())) {
            throw new IllegalSeekPositionException(abstractC2832o2, i, j);
        }
        this.f6681x++;
        if (mo2900f()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            C2803h1.d dVar = new C2803h1.d(this.f6657F);
            dVar.m3271a(1);
            C2727f1 c2727f1 = ((C2962w) this.f6665h).f7945a;
            c2727f1.f6664g.mo2955b(new RunnableC2632c0(c2727f1, dVar));
            return;
        }
        int i2 = this.f6657F.f7951f != 1 ? 2 : 1;
        int iMo2881C = mo2881C();
        C2964w1 c2964w1M2911l0 = m2911l0(this.f6657F.m3567f(i2), abstractC2832o2, m2907i0(abstractC2832o2, i, j));
        ((C2732b0.b) this.f6666i.f7083q.mo2962i(3, new C2803h1.g(abstractC2832o2, i, C2738e0.m2981B(j)))).m2965b();
        m2924s0(c2964w1M2911l0, 0, 1, true, true, 1, m2903g0(c2964w1M2911l0), iMo2881C);
    }

    /* JADX INFO: renamed from: h0 */
    public final int m2905h0() {
        if (this.f6657F.f7947b.m3331q()) {
            return this.f6658G;
        }
        C2964w1 c2964w1 = this.f6657F;
        return c2964w1.f7947b.mo3327h(c2964w1.f7948c.f5732a, this.f6669l).f7340l;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: i */
    public InterfaceC3128y1.b mo2906i() {
        return this.f6654C;
    }

    @Nullable
    /* JADX INFO: renamed from: i0 */
    public final Pair<Object, Long> m2907i0(AbstractC2832o2 abstractC2832o2, int i, long j) {
        if (abstractC2832o2.m3331q()) {
            this.f6658G = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.f6659H = j;
            return null;
        }
        if (i == -1 || i >= abstractC2832o2.mo2557p()) {
            i = abstractC2832o2.mo2582a(this.f6680w);
            j = abstractC2832o2.m3330n(i, this.f7863a).m3339a();
        }
        return abstractC2832o2.m3328j(this.f7863a, this.f6669l, i, C2738e0.m2981B(j));
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: j */
    public boolean mo2908j() {
        return this.f6657F.f7958m;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: k */
    public void mo2909k(final boolean z2) {
        if (this.f6680w != z2) {
            this.f6680w = z2;
            ((C2732b0.b) this.f6666i.f7083q.mo2954a(12, z2 ? 1 : 0, 0)).m2965b();
            this.f6667j.m3035b(9, new C2749p.a() { // from class: b.i.a.c.n
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj) {
                    ((InterfaceC3128y1.c) obj).mo236D(z2);
                }
            });
            m2923r0();
            this.f6667j.m3034a();
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: l */
    public long mo2910l() {
        return 3000L;
    }

    /* JADX INFO: renamed from: l0 */
    public final C2964w1 m2911l0(C2964w1 c2964w1, AbstractC2832o2 abstractC2832o2, @Nullable Pair<Object, Long> pair) {
        List<Metadata> list;
        C1460d.m531j(abstractC2832o2.m3331q() || pair != null);
        AbstractC2832o2 abstractC2832o3 = c2964w1.f7947b;
        C2964w1 c2964w1M3568g = c2964w1.m3568g(abstractC2832o2);
        if (abstractC2832o2.m3331q()) {
            InterfaceC2530a0.a aVar = C2964w1.f7946a;
            InterfaceC2530a0.a aVar2 = C2964w1.f7946a;
            long jM2981B = C2738e0.m2981B(this.f6659H);
            C2558o0 c2558o0 = C2558o0.f5674j;
            C2652r c2652r = this.f6660c;
            AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
            C2964w1 c2964w1M3562a = c2964w1M3568g.m3563b(aVar2, jM2981B, jM2981B, jM2981B, 0L, c2558o0, c2652r, C4508h0.f12012l).m3562a(aVar2);
            c2964w1M3562a.f7963r = c2964w1M3562a.f7965t;
            return c2964w1M3562a;
        }
        Object obj = c2964w1M3568g.f7948c.f5732a;
        int i = C2738e0.f6708a;
        boolean z2 = !obj.equals(pair.first);
        InterfaceC2530a0.a aVar3 = z2 ? new InterfaceC2530a0.a(pair.first) : c2964w1M3568g.f7948c;
        long jLongValue = ((Long) pair.second).longValue();
        long jM2981B2 = C2738e0.m2981B(mo2928w());
        if (!abstractC2832o3.m3331q()) {
            jM2981B2 -= abstractC2832o3.mo3327h(obj, this.f6669l).f7342n;
        }
        if (z2 || jLongValue < jM2981B2) {
            C1460d.m426D(!aVar3.m2593a());
            C2558o0 c2558o1 = z2 ? C2558o0.f5674j : c2964w1M3568g.f7954i;
            C2652r c2652r2 = z2 ? this.f6660c : c2964w1M3568g.f7955j;
            if (z2) {
                AbstractC4493a<Object> abstractC4493a2 = AbstractC4523p.f12045k;
                list = C4508h0.f12012l;
            } else {
                list = c2964w1M3568g.f7956k;
            }
            C2964w1 c2964w1M3562a2 = c2964w1M3568g.m3563b(r0, jLongValue, jLongValue, jLongValue, 0L, c2558o1, c2652r2, list).m3562a(aVar3);
            c2964w1M3562a2.f7963r = jLongValue;
            return c2964w1M3562a2;
        }
        if (jLongValue == jM2981B2) {
            int iMo2554b = abstractC2832o2.mo2554b(c2964w1M3568g.f7957l.f5732a);
            if (iMo2554b == -1 || abstractC2832o2.m3326f(iMo2554b, this.f6669l).f7340l != abstractC2832o2.mo3327h(aVar3.f5732a, this.f6669l).f7340l) {
                abstractC2832o2.mo3327h(aVar3.f5732a, this.f6669l);
                long jM3332a = aVar3.m2593a() ? this.f6669l.m3332a(aVar3.f5733b, aVar3.f5734c) : this.f6669l.f7341m;
                c2964w1M3568g = c2964w1M3568g.m3563b(aVar3, c2964w1M3568g.f7965t, c2964w1M3568g.f7965t, c2964w1M3568g.f7950e, jM3332a - c2964w1M3568g.f7965t, c2964w1M3568g.f7954i, c2964w1M3568g.f7955j, c2964w1M3568g.f7956k).m3562a(aVar3);
                c2964w1M3568g.f7963r = jM3332a;
            }
        } else {
            C1460d.m426D(!aVar3.m2593a());
            long jMax = Math.max(0L, c2964w1M3568g.f7964s - (jLongValue - jM2981B2));
            long j = c2964w1M3568g.f7963r;
            if (c2964w1M3568g.f7957l.equals(c2964w1M3568g.f7948c)) {
                j = jLongValue + jMax;
            }
            c2964w1M3568g = c2964w1M3568g.m3563b(aVar3, jLongValue, jLongValue, jLongValue, jMax, c2964w1M3568g.f7954i, c2964w1M3568g.f7955j, c2964w1M3568g.f7956k);
            c2964w1M3568g.f7963r = j;
        }
        return c2964w1M3568g;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: m */
    public int mo2912m() {
        if (this.f6657F.f7947b.m3331q()) {
            return 0;
        }
        C2964w1 c2964w1 = this.f6657F;
        return c2964w1.f7947b.mo2554b(c2964w1.f7948c.f5732a);
    }

    /* JADX INFO: renamed from: m0 */
    public final long m2913m0(AbstractC2832o2 abstractC2832o2, InterfaceC2530a0.a aVar, long j) {
        abstractC2832o2.mo3327h(aVar.f5732a, this.f6669l);
        return j + this.f6669l.f7342n;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: n */
    public void mo2914n(@Nullable TextureView textureView) {
    }

    /* JADX INFO: renamed from: n0 */
    public void m2915n0() {
        String str;
        boolean z2;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str2 = C2738e0.f6712e;
        HashSet<String> hashSet = C2807i1.f7121a;
        synchronized (C2807i1.class) {
            str = C2807i1.f7122b;
        }
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str, C1643a.m841b(str2, C1643a.m841b(hexString, 36))), "Release ", hexString, " [", "ExoPlayerLib/2.16.0");
        C1643a.m876s0(sbM831S, "] [", str2, "] [", str);
        sbM831S.append("]");
        Log.i("ExoPlayerImpl", sbM831S.toString());
        C2803h1 c2803h1 = this.f6666i;
        synchronized (c2803h1) {
            if (c2803h1.f7060I || !c2803h1.f7084r.isAlive()) {
                z2 = true;
            } else {
                c2803h1.f7083q.mo2959f(7);
                long jMo2952d = c2803h1.f7056E;
                synchronized (c2803h1) {
                    long jMo2952d2 = c2803h1.f7092z.mo2952d() + jMo2952d;
                    boolean z3 = false;
                    while (!Boolean.valueOf(c2803h1.f7060I).booleanValue() && jMo2952d > 0) {
                        try {
                            c2803h1.f7092z.mo2951c();
                            c2803h1.wait(jMo2952d);
                        } catch (InterruptedException unused) {
                            z3 = true;
                        }
                        jMo2952d = jMo2952d2 - c2803h1.f7092z.mo2952d();
                    }
                    if (z3) {
                        Thread.currentThread().interrupt();
                    }
                    z2 = c2803h1.f7060I;
                }
            }
        }
        if (!z2) {
            C2749p<InterfaceC3128y1.c> c2749p = this.f6667j;
            c2749p.m3035b(10, new C2749p.a() { // from class: b.i.a.c.b0
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj) {
                    int i = C2727f1.f6651b;
                    ((InterfaceC3128y1.c) obj).mo260s(ExoPlaybackException.m8753b(new ExoTimeoutException(1), PointerIconCompat.TYPE_HELP));
                }
            });
            c2749p.m3034a();
        }
        this.f6667j.m3036c();
        this.f6664g.mo2963j(null);
        C2868g1 c2868g1 = this.f6673p;
        if (c2868g1 != null) {
            this.f6675r.mo2845d(c2868g1);
        }
        C2964w1 c2964w1M3567f = this.f6657F.m3567f(1);
        this.f6657F = c2964w1M3567f;
        C2964w1 c2964w1M3562a = c2964w1M3567f.m3562a(c2964w1M3567f.f7948c);
        this.f6657F = c2964w1M3562a;
        c2964w1M3562a.f7963r = c2964w1M3562a.f7965t;
        this.f6657F.f7964s = 0L;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: o */
    public C2788y mo2916o() {
        return C2788y.f6954j;
    }

    /* JADX INFO: renamed from: o0 */
    public void m2917o0(InterfaceC3128y1.c cVar) {
        C2749p<InterfaceC3128y1.c> c2749p = this.f6667j;
        for (C2749p.c<InterfaceC3128y1.c> cVar2 : c2749p.f6739d) {
            if (cVar2.f6743a.equals(cVar)) {
                C2749p.b<InterfaceC3128y1.c> bVar = c2749p.f6738c;
                cVar2.f6746d = true;
                if (cVar2.f6745c) {
                    bVar.mo3037a(cVar2.f6743a, cVar2.f6744b.m3033b());
                }
                c2749p.f6739d.remove(cVar2);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: p */
    public void mo2918p(InterfaceC3128y1.e eVar) {
        m2917o0(eVar);
    }

    /* JADX INFO: renamed from: p0 */
    public final void m2919p0(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.f6670m.remove(i3);
        }
        this.f6653B = this.f6653B.mo2543a(i, i2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: q */
    public int mo2920q() {
        if (mo2900f()) {
            return this.f6657F.f7948c.f5734c;
        }
        return -1;
    }

    /* JADX INFO: renamed from: q0 */
    public void m2921q0(boolean z2, int i, int i2) {
        C2964w1 c2964w1 = this.f6657F;
        if (c2964w1.f7958m == z2 && c2964w1.f7959n == i) {
            return;
        }
        this.f6681x++;
        C2964w1 c2964w1M3565d = c2964w1.m3565d(z2, i);
        ((C2732b0.b) this.f6666i.f7083q.mo2954a(1, z2 ? 1 : 0, i)).m2965b();
        m2924s0(c2964w1M3565d, 0, i2, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: r */
    public void mo2922r(@Nullable SurfaceView surfaceView) {
    }

    /* JADX INFO: renamed from: r0 */
    public final void m2923r0() {
        InterfaceC3128y1.b bVar = this.f6654C;
        InterfaceC3128y1.b bVar2 = this.f6661d;
        InterfaceC3128y1.b.a aVar = new InterfaceC3128y1.b.a();
        aVar.m3826a(bVar2);
        aVar.m3827b(4, !mo2900f());
        aVar.m3827b(5, m3527a0() && !mo2900f());
        aVar.m3827b(6, m3524X() && !mo2900f());
        aVar.m3827b(7, !mo2888K().m3331q() && (m3524X() || !m3526Z() || m3527a0()) && !mo2900f());
        aVar.m3827b(8, m3523W() && !mo2900f());
        aVar.m3827b(9, !mo2888K().m3331q() && (m3523W() || (m3526Z() && m3525Y())) && !mo2900f());
        aVar.m3827b(10, !mo2900f());
        aVar.m3827b(11, m3527a0() && !mo2900f());
        aVar.m3827b(12, m3527a0() && !mo2900f());
        InterfaceC3128y1.b bVarM3828c = aVar.m3828c();
        this.f6654C = bVarM3828c;
        if (bVarM3828c.equals(bVar)) {
            return;
        }
        this.f6667j.m3035b(13, new C2749p.a() { // from class: b.i.a.c.x
            @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
            public final void invoke(Object obj) {
                ((InterfaceC3128y1.c) obj).mo261t(this.f8020a.f6654C);
            }
        });
    }

    /* JADX INFO: renamed from: s0 */
    public final void m2924s0(final C2964w1 c2964w1, final int i, final int i2, boolean z2, boolean z3, final int i3, long j, int i4) {
        Pair pair;
        int i5;
        final C2831o1 c2831o1;
        int i6;
        Object obj;
        C2831o1 c2831o2;
        Object obj2;
        int iMo2554b;
        long jM2877j0;
        long jM2877j1;
        Object obj3;
        C2831o1 c2831o3;
        Object obj4;
        int iMo2554b2;
        C2964w1 c2964w2 = this.f6657F;
        this.f6657F = c2964w1;
        boolean z4 = !c2964w2.f7947b.equals(c2964w1.f7947b);
        AbstractC2832o2 abstractC2832o2 = c2964w2.f7947b;
        AbstractC2832o2 abstractC2832o3 = c2964w1.f7947b;
        if (abstractC2832o3.m3331q() && abstractC2832o2.m3331q()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (abstractC2832o3.m3331q() != abstractC2832o2.m3331q()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (abstractC2832o2.m3330n(abstractC2832o2.mo3327h(c2964w2.f7948c.f5732a, this.f6669l).f7340l, this.f7863a).f7353n.equals(abstractC2832o3.m3330n(abstractC2832o3.mo3327h(c2964w1.f7948c.f5732a, this.f6669l).f7340l, this.f7863a).f7353n)) {
            pair = (z3 && i3 == 0 && c2964w2.f7948c.f5735d < c2964w1.f7948c.f5735d) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z3 && i3 == 0) {
                i5 = 1;
            } else if (z3 && i3 == 1) {
                i5 = 2;
            } else {
                if (!z4) {
                    throw new IllegalStateException();
                }
                i5 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i5));
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        final int iIntValue = ((Integer) pair.second).intValue();
        C2835p1 c2835p1M2899e0 = this.f6655D;
        if (zBooleanValue) {
            c2831o1 = c2964w1.f7947b.m3331q() ? null : c2964w1.f7947b.m3330n(c2964w1.f7947b.mo3327h(c2964w1.f7948c.f5732a, this.f6669l).f7340l, this.f7863a).f7355p;
            this.f6656E = C2835p1.f7368j;
        } else {
            c2831o1 = null;
        }
        if (zBooleanValue || !c2964w2.f7956k.equals(c2964w1.f7956k)) {
            C2835p1.b bVarM3344a = this.f6656E.m3344a();
            List<Metadata> list = c2964w1.f7956k;
            for (int i7 = 0; i7 < list.size(); i7++) {
                Metadata metadata = list.get(i7);
                int i8 = 0;
                while (true) {
                    Metadata.Entry[] entryArr = metadata.f19936j;
                    if (i8 < entryArr.length) {
                        entryArr[i8].mo8878n(bVarM3344a);
                        i8++;
                    }
                }
            }
            this.f6656E = bVarM3344a.m3345a();
            c2835p1M2899e0 = m2899e0();
        }
        boolean z5 = !c2835p1M2899e0.equals(this.f6655D);
        this.f6655D = c2835p1M2899e0;
        if (!c2964w2.f7947b.equals(c2964w1.f7947b)) {
            this.f6667j.m3035b(0, new C2749p.a() { // from class: b.i.a.c.d0
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj5) {
                    C2964w1 c2964w3 = c2964w1;
                    ((InterfaceC3128y1.c) obj5).mo262v(c2964w3.f7947b, i);
                }
            });
        }
        if (z3) {
            AbstractC2832o2.b bVar = new AbstractC2832o2.b();
            if (c2964w2.f7947b.m3331q()) {
                i6 = i4;
                obj = null;
                c2831o2 = null;
                obj2 = null;
                iMo2554b = -1;
            } else {
                Object obj5 = c2964w2.f7948c.f5732a;
                c2964w2.f7947b.mo3327h(obj5, bVar);
                int i9 = bVar.f7340l;
                obj2 = obj5;
                i6 = i9;
                iMo2554b = c2964w2.f7947b.mo2554b(obj5);
                obj = c2964w2.f7947b.m3330n(i9, this.f7863a).f7353n;
                c2831o2 = this.f7863a.f7355p;
            }
            if (i3 == 0) {
                jM2877j0 = bVar.f7342n + bVar.f7341m;
                if (c2964w2.f7948c.m2593a()) {
                    InterfaceC2530a0.a aVar = c2964w2.f7948c;
                    jM2877j0 = bVar.m3332a(aVar.f5733b, aVar.f5734c);
                    jM2877j1 = m2877j0(c2964w2);
                } else {
                    if (c2964w2.f7948c.f5736e != -1 && this.f6657F.f7948c.m2593a()) {
                        jM2877j0 = m2877j0(this.f6657F);
                    }
                    jM2877j1 = jM2877j0;
                }
            } else if (c2964w2.f7948c.m2593a()) {
                jM2877j0 = c2964w2.f7965t;
                jM2877j1 = m2877j0(c2964w2);
            } else {
                jM2877j0 = bVar.f7342n + c2964w2.f7965t;
                jM2877j1 = jM2877j0;
            }
            long jM2992M = C2738e0.m2992M(jM2877j0);
            long jM2992M2 = C2738e0.m2992M(jM2877j1);
            InterfaceC2530a0.a aVar2 = c2964w2.f7948c;
            final InterfaceC3128y1.f fVar = new InterfaceC3128y1.f(obj, i6, c2831o2, obj2, iMo2554b, jM2992M, jM2992M2, aVar2.f5733b, aVar2.f5734c);
            int iMo2881C = mo2881C();
            if (this.f6657F.f7947b.m3331q()) {
                obj3 = null;
                c2831o3 = null;
                obj4 = null;
                iMo2554b2 = -1;
            } else {
                C2964w1 c2964w3 = this.f6657F;
                Object obj6 = c2964w3.f7948c.f5732a;
                c2964w3.f7947b.mo3327h(obj6, this.f6669l);
                iMo2554b2 = this.f6657F.f7947b.mo2554b(obj6);
                obj4 = obj6;
                obj3 = this.f6657F.f7947b.m3330n(iMo2881C, this.f7863a).f7353n;
                c2831o3 = this.f7863a.f7355p;
            }
            long jM2992M3 = C2738e0.m2992M(j);
            long jM2992M4 = this.f6657F.f7948c.m2593a() ? C2738e0.m2992M(m2877j0(this.f6657F)) : jM2992M3;
            InterfaceC2530a0.a aVar3 = this.f6657F.f7948c;
            final InterfaceC3128y1.f fVar2 = new InterfaceC3128y1.f(obj3, iMo2881C, c2831o3, obj4, iMo2554b2, jM2992M3, jM2992M4, aVar3.f5733b, aVar3.f5734c);
            this.f6667j.m3035b(11, new C2749p.a() { // from class: b.i.a.c.a0
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    int i10 = i3;
                    InterfaceC3128y1.f fVar3 = fVar;
                    InterfaceC3128y1.f fVar4 = fVar2;
                    InterfaceC3128y1.c cVar = (InterfaceC3128y1.c) obj7;
                    cVar.mo256j(i10);
                    cVar.mo253g(fVar3, fVar4, i10);
                }
            });
        }
        if (zBooleanValue) {
            this.f6667j.m3035b(1, new C2749p.a() { // from class: b.i.a.c.z
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo241M(c2831o1, iIntValue);
                }
            });
        }
        if (c2964w2.f7952g != c2964w1.f7952g) {
            this.f6667j.m3035b(10, new C2749p.a() { // from class: b.i.a.c.l
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo252f0(c2964w1.f7952g);
                }
            });
            if (c2964w1.f7952g != null) {
                this.f6667j.m3035b(10, new C2749p.a() { // from class: b.i.a.c.y
                    @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                    public final void invoke(Object obj7) {
                        ((InterfaceC3128y1.c) obj7).mo260s(c2964w1.f7952g);
                    }
                });
            }
        }
        C2652r c2652r = c2964w2.f7955j;
        C2652r c2652r2 = c2964w1.f7955j;
        if (c2652r != c2652r2) {
            this.f6663f.mo2752a(c2652r2.f6330e);
            final C2648n c2648n = new C2648n(c2964w1.f7955j.f6328c);
            this.f6667j.m3035b(2, new C2749p.a() { // from class: b.i.a.c.q
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    C2964w1 c2964w4 = c2964w1;
                    ((InterfaceC3128y1.c) obj7).mo243Y(c2964w4.f7954i, c2648n);
                }
            });
            this.f6667j.m3035b(2, new C2749p.a() { // from class: b.i.a.c.t
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo258p(c2964w1.f7955j.f6329d);
                }
            });
        }
        if (z5) {
            final C2835p1 c2835p1 = this.f6655D;
            this.f6667j.m3035b(14, new C2749p.a() { // from class: b.i.a.c.p
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo235A(c2835p1);
                }
            });
        }
        if (c2964w2.f7953h != c2964w1.f7953h) {
            this.f6667j.m3035b(3, new C2749p.a() { // from class: b.i.a.c.o
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    C2964w1 c2964w4 = c2964w1;
                    InterfaceC3128y1.c cVar = (InterfaceC3128y1.c) obj7;
                    cVar.mo255i(c2964w4.f7953h);
                    cVar.mo259r(c2964w4.f7953h);
                }
            });
        }
        if (c2964w2.f7951f != c2964w1.f7951f || c2964w2.f7958m != c2964w1.f7958m) {
            this.f6667j.m3035b(-1, new C2749p.a() { // from class: b.i.a.c.e0
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    C2964w1 c2964w4 = c2964w1;
                    ((InterfaceC3128y1.c) obj7).mo239H(c2964w4.f7958m, c2964w4.f7951f);
                }
            });
        }
        if (c2964w2.f7951f != c2964w1.f7951f) {
            this.f6667j.m3035b(4, new C2749p.a() { // from class: b.i.a.c.m
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo264y(c2964w1.f7951f);
                }
            });
        }
        if (c2964w2.f7958m != c2964w1.f7958m) {
            this.f6667j.m3035b(5, new C2749p.a() { // from class: b.i.a.c.s
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    C2964w1 c2964w4 = c2964w1;
                    ((InterfaceC3128y1.c) obj7).mo242W(c2964w4.f7958m, i2);
                }
            });
        }
        if (c2964w2.f7959n != c2964w1.f7959n) {
            this.f6667j.m3035b(6, new C2749p.a() { // from class: b.i.a.c.r
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo254h(c2964w1.f7959n);
                }
            });
        }
        if (m2878k0(c2964w2) != m2878k0(c2964w1)) {
            this.f6667j.m3035b(7, new C2749p.a() { // from class: b.i.a.c.v
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo257j0(C2727f1.m2878k0(c2964w1));
                }
            });
        }
        if (!c2964w2.f7960o.equals(c2964w1.f7960o)) {
            this.f6667j.m3035b(12, new C2749p.a() { // from class: b.i.a.c.f0
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo247b0(c2964w1.f7960o);
                }
            });
        }
        if (z2) {
            this.f6667j.m3035b(-1, new C2749p.a() { // from class: b.i.a.c.b
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj7) {
                    ((InterfaceC3128y1.c) obj7).mo244a();
                }
            });
        }
        m2923r0();
        this.f6667j.m3034a();
        if (c2964w2.f7961p != c2964w1.f7961p) {
            Iterator<InterfaceC2677e1.a> it = this.f6668k.iterator();
            while (it.hasNext()) {
                it.next().mo2771x(c2964w1.f7961p);
            }
        }
        if (c2964w2.f7962q != c2964w1.f7962q) {
            Iterator<InterfaceC2677e1.a> it2 = this.f6668k.iterator();
            while (it2.hasNext()) {
                it2.next().mo2770o(c2964w1.f7962q);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    @Nullable
    /* JADX INFO: renamed from: t */
    public PlaybackException mo2925t() {
        return this.f6657F.f7952g;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: u */
    public void mo2926u(boolean z2) {
        m2921q0(z2, 0, 1);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: v */
    public long mo2927v() {
        return this.f6677t;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: w */
    public long mo2928w() {
        if (!mo2900f()) {
            return mo2894T();
        }
        C2964w1 c2964w1 = this.f6657F;
        c2964w1.f7947b.mo3327h(c2964w1.f7948c.f5732a, this.f6669l);
        C2964w1 c2964w2 = this.f6657F;
        return c2964w2.f7949d == -9223372036854775807L ? c2964w2.f7947b.m3330n(mo2881C(), this.f7863a).m3339a() : C2738e0.m2992M(this.f6669l.f7342n) + C2738e0.m2992M(this.f6657F.f7949d);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: x */
    public void mo2929x(InterfaceC3128y1.e eVar) {
        m2898d0(eVar);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: y */
    public int mo2930y() {
        return this.f6657F.f7951f;
    }
}
