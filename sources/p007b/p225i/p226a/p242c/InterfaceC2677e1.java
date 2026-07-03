package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.os.Looper;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p243a3.C2559p;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2534c0;
import p007b.p225i.p226a.p242c.p255c3.AbstractC2651q;
import p007b.p225i.p226a.p242c.p255c3.C2642h;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p257e3.C2714p;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;
import p007b.p225i.p226a.p242c.p262s2.C2868g1;
import p007b.p225i.p226a.p242c.p263t2.C2931o;
import p007b.p225i.p226a.p242c.p267x2.C3017f;
import p007b.p225i.p355b.p356a.InterfaceC4492l;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: renamed from: b.i.a.c.e1 */
/* JADX INFO: compiled from: ExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2677e1 extends InterfaceC3128y1 {

    /* JADX INFO: renamed from: b.i.a.c.e1$a */
    /* JADX INFO: compiled from: ExoPlayer.java */
    public interface a {
        /* JADX INFO: renamed from: o */
        void mo2770o(boolean z2);

        /* JADX INFO: renamed from: x */
        void mo2771x(boolean z2);
    }

    /* JADX INFO: renamed from: b.i.a.c.e1$b */
    /* JADX INFO: compiled from: ExoPlayer.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final Context f6412a;

        /* JADX INFO: renamed from: b */
        public InterfaceC2740g f6413b;

        /* JADX INFO: renamed from: c */
        public InterfaceC4492l<InterfaceC2808i2> f6414c;

        /* JADX INFO: renamed from: d */
        public InterfaceC4492l<InterfaceC2534c0> f6415d;

        /* JADX INFO: renamed from: e */
        public InterfaceC4492l<AbstractC2651q> f6416e;

        /* JADX INFO: renamed from: f */
        public InterfaceC4492l<InterfaceC2827n1> f6417f;

        /* JADX INFO: renamed from: g */
        public InterfaceC4492l<InterfaceC2704f> f6418g;

        /* JADX INFO: renamed from: h */
        public InterfaceC4492l<C2868g1> f6419h;

        /* JADX INFO: renamed from: i */
        public Looper f6420i;

        /* JADX INFO: renamed from: j */
        public C2931o f6421j;

        /* JADX INFO: renamed from: k */
        public int f6422k;

        /* JADX INFO: renamed from: l */
        public boolean f6423l;

        /* JADX INFO: renamed from: m */
        public C2812j2 f6424m;

        /* JADX INFO: renamed from: n */
        public long f6425n;

        /* JADX INFO: renamed from: o */
        public long f6426o;

        /* JADX INFO: renamed from: p */
        public InterfaceC2823m1 f6427p;

        /* JADX INFO: renamed from: q */
        public long f6428q;

        /* JADX INFO: renamed from: r */
        public long f6429r;

        /* JADX INFO: renamed from: s */
        public boolean f6430s;

        public b(final Context context) {
            InterfaceC4492l<InterfaceC2808i2> interfaceC4492l = new InterfaceC4492l() { // from class: b.i.a.c.f
                @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
                public final Object get() {
                    return new C2575b1(context);
                }
            };
            InterfaceC4492l<InterfaceC2534c0> interfaceC4492l2 = new InterfaceC4492l() { // from class: b.i.a.c.h
                @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
                public final Object get() {
                    return new C2559p(context, new C3017f());
                }
            };
            InterfaceC4492l<AbstractC2651q> interfaceC4492l3 = new InterfaceC4492l() { // from class: b.i.a.c.g
                @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
                public final Object get() {
                    return new C2642h(context);
                }
            };
            C2525a c2525a = new InterfaceC4492l() { // from class: b.i.a.c.a
                @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
                public final Object get() {
                    return new C3153z0(new C2713o(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
                }
            };
            InterfaceC4492l<InterfaceC2704f> interfaceC4492l4 = new InterfaceC4492l() { // from class: b.i.a.c.e
                @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
                public final Object get() {
                    C2714p c2714p;
                    Context context2 = context;
                    AbstractC4523p<Long> abstractC4523p = C2714p.f6569a;
                    synchronized (C2714p.class) {
                        if (C2714p.f6575g == null) {
                            C2714p.b bVar = new C2714p.b(context2);
                            C2714p.f6575g = new C2714p(bVar.f6589a, bVar.f6590b, bVar.f6591c, bVar.f6592d, bVar.f6593e, null);
                        }
                        c2714p = C2714p.f6575g;
                    }
                    return c2714p;
                }
            };
            this.f6412a = context;
            this.f6414c = interfaceC4492l;
            this.f6415d = interfaceC4492l2;
            this.f6416e = interfaceC4492l3;
            this.f6417f = c2525a;
            this.f6418g = interfaceC4492l4;
            this.f6419h = new InterfaceC4492l() { // from class: b.i.a.c.i
                @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
                public final Object get() {
                    InterfaceC2740g interfaceC2740g = this.f7119j.f6413b;
                    Objects.requireNonNull(interfaceC2740g);
                    return new C2868g1(interfaceC2740g);
                }
            };
            this.f6420i = C2738e0.m3007o();
            this.f6421j = C2931o.f7779j;
            this.f6422k = 1;
            this.f6423l = true;
            this.f6424m = C2812j2.f7190b;
            this.f6425n = 5000L;
            this.f6426o = 15000L;
            this.f6427p = new C3127y0(0.97f, 1.03f, 1000L, 1.0E-7f, C2738e0.m2981B(20L), C2738e0.m2981B(500L), 0.999f, null);
            this.f6413b = InterfaceC2740g.f6720a;
            this.f6428q = 500L;
            this.f6429r = 2000L;
        }
    }
}
