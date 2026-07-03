package p007b.p225i.p226a.p242c.p243a3;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.p243a3.C2568v;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;

/* JADX INFO: renamed from: b.i.a.c.a3.o */
/* JADX INFO: compiled from: CompositeMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2557o<T> extends AbstractC2551l {

    /* JADX INFO: renamed from: g */
    public final HashMap<T, b<T>> f5664g = new HashMap<>();

    /* JADX INFO: renamed from: h */
    @Nullable
    public Handler f5665h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public InterfaceC2680a0 f5666i;

    /* JADX INFO: renamed from: b.i.a.c.a3.o$a */
    /* JADX INFO: compiled from: CompositeMediaSource.java */
    public final class a implements InterfaceC2532b0, InterfaceC2988s {

        /* JADX INFO: renamed from: j */
        public final T f5667j;

        /* JADX INFO: renamed from: k */
        public InterfaceC2532b0.a f5668k;

        /* JADX INFO: renamed from: l */
        public InterfaceC2988s.a f5669l;

        public a(T t) {
            this.f5668k = AbstractC2557o.this.f5635c.m2472g(0, null, 0L);
            this.f5669l = AbstractC2557o.this.f5636d.m3593g(0, null);
            this.f5667j = t;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: J */
        public void mo2567J(int i, @Nullable InterfaceC2530a0.a aVar) {
            m2569a(i, aVar);
            this.f5669l.m3588b();
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: S */
        public void mo2568S(int i, @Nullable InterfaceC2530a0.a aVar) {
            m2569a(i, aVar);
            this.f5669l.m3587a();
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: X */
        public void mo2461X(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w) {
            m2569a(i, aVar);
            this.f5668k.m2469d(c2566t, m2570b(c2569w));
        }

        /* JADX INFO: renamed from: a */
        public final boolean m2569a(int i, @Nullable InterfaceC2530a0.a aVar) {
            InterfaceC2530a0.a aVarM2460b;
            if (aVar != null) {
                AbstractC2557o abstractC2557o = AbstractC2557o.this;
                T t = this.f5667j;
                C2568v c2568v = (C2568v) abstractC2557o;
                Objects.requireNonNull(c2568v);
                Object obj = aVar.f5732a;
                Object obj2 = c2568v.f5716n.f5723n;
                if (obj2 != null && obj2.equals(obj)) {
                    obj = C2568v.a.f5721l;
                }
                aVarM2460b = aVar.m2460b(obj);
            } else {
                aVarM2460b = null;
            }
            Objects.requireNonNull(AbstractC2557o.this);
            InterfaceC2532b0.a aVar2 = this.f5668k;
            if (aVar2.f5481a != i || !C2738e0.m2993a(aVar2.f5482b, aVarM2460b)) {
                this.f5668k = AbstractC2557o.this.f5635c.m2472g(i, aVarM2460b, 0L);
            }
            InterfaceC2988s.a aVar3 = this.f5669l;
            if (aVar3.f8012a == i && C2738e0.m2993a(aVar3.f8013b, aVarM2460b)) {
                return true;
            }
            this.f5669l = new InterfaceC2988s.a(AbstractC2557o.this.f5636d.f8014c, i, aVarM2460b);
            return true;
        }

        /* JADX INFO: renamed from: b */
        public final C2569w m2570b(C2569w c2569w) {
            AbstractC2557o abstractC2557o = AbstractC2557o.this;
            long j = c2569w.f5730f;
            Objects.requireNonNull(abstractC2557o);
            AbstractC2557o abstractC2557o2 = AbstractC2557o.this;
            long j2 = c2569w.f5731g;
            Objects.requireNonNull(abstractC2557o2);
            return (j == c2569w.f5730f && j2 == c2569w.f5731g) ? c2569w : new C2569w(c2569w.f5725a, c2569w.f5726b, c2569w.f5727c, c2569w.f5728d, c2569w.f5729e, j, j2);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: c0 */
        public void mo2571c0(int i, @Nullable InterfaceC2530a0.a aVar, int i2) {
            m2569a(i, aVar);
            this.f5669l.m3590d(i2);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: d0 */
        public void mo2572d0(int i, @Nullable InterfaceC2530a0.a aVar) {
            m2569a(i, aVar);
            this.f5669l.m3592f();
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: g0 */
        public void mo2462g0(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w, IOException iOException, boolean z2) {
            m2569a(i, aVar);
            this.f5668k.m2470e(c2566t, m2570b(c2569w), iOException, z2);
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: i0 */
        public void mo2573i0(int i, @Nullable InterfaceC2530a0.a aVar) {
            m2569a(i, aVar);
            this.f5669l.m3589c();
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: o */
        public void mo2463o(int i, @Nullable InterfaceC2530a0.a aVar, C2569w c2569w) {
            m2569a(i, aVar);
            this.f5668k.m2467b(m2570b(c2569w));
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: q */
        public void mo2464q(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w) {
            m2569a(i, aVar);
            this.f5668k.m2468c(c2566t, m2570b(c2569w));
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: u */
        public void mo2574u(int i, @Nullable InterfaceC2530a0.a aVar, Exception exc) {
            m2569a(i, aVar);
            this.f5669l.m3591e(exc);
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: x */
        public void mo2465x(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w) {
            m2569a(i, aVar);
            this.f5668k.m2471f(c2566t, m2570b(c2569w));
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.o$b */
    /* JADX INFO: compiled from: CompositeMediaSource.java */
    public static final class b<T> {

        /* JADX INFO: renamed from: a */
        public final InterfaceC2530a0 f5671a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC2530a0.b f5672b;

        /* JADX INFO: renamed from: c */
        public final AbstractC2557o<T>.a f5673c;

        public b(InterfaceC2530a0 interfaceC2530a0, InterfaceC2530a0.b bVar, AbstractC2557o<T>.a aVar) {
            this.f5671a = interfaceC2530a0;
            this.f5672b = bVar;
            this.f5673c = aVar;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.AbstractC2551l
    @CallSuper
    /* JADX INFO: renamed from: o */
    public void mo2551o() {
        for (b<T> bVar : this.f5664g.values()) {
            bVar.f5671a.mo2449d(bVar.f5672b);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.AbstractC2551l
    @CallSuper
    /* JADX INFO: renamed from: p */
    public void mo2552p() {
        for (b<T> bVar : this.f5664g.values()) {
            bVar.f5671a.mo2458m(bVar.f5672b);
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m2566t(T t, InterfaceC2530a0 interfaceC2530a0) {
        final Object obj = null;
        C1460d.m531j(!this.f5664g.containsKey(null));
        InterfaceC2530a0.b bVar = new InterfaceC2530a0.b() { // from class: b.i.a.c.a3.a
            /* JADX WARN: Code duplicated, block: B:19:0x007e  */
            /* JADX WARN: Code duplicated, block: B:35:0x00da  */
            /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
            @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0.b
            /* JADX INFO: renamed from: a */
            public final void mo2445a(InterfaceC2530a0 interfaceC2530a1, AbstractC2832o2 abstractC2832o2) {
                long j;
                C2568v.a aVar;
                InterfaceC2530a0.a aVarM2460b;
                C2568v.a aVar2;
                AbstractC2557o abstractC2557o = this.f5473a;
                Object obj2 = obj;
                Objects.requireNonNull(abstractC2557o);
                C2568v c2568v = (C2568v) abstractC2557o;
                if (c2568v.f5719q) {
                    C2568v.a aVar3 = c2568v.f5716n;
                    c2568v.f5716n = new C2568v.a(abstractC2832o2, aVar3.f5722m, aVar3.f5723n);
                    C2567u c2567u = c2568v.f5717o;
                    if (c2567u != null) {
                        c2568v.m2592v(c2567u.f5711p);
                    }
                } else {
                    if (!abstractC2832o2.m3331q()) {
                        abstractC2832o2.m3330n(0, c2568v.f5714l);
                        AbstractC2832o2.c cVar = c2568v.f5714l;
                        long j2 = cVar.f7365z;
                        Object obj3 = cVar.f7353n;
                        C2567u c2567u2 = c2568v.f5717o;
                        if (c2567u2 != null) {
                            long j3 = c2567u2.f5706k;
                            c2568v.f5716n.mo3327h(c2567u2.f5705j.f5732a, c2568v.f5715m);
                            long j4 = c2568v.f5715m.f7342n + j3;
                            if (j4 != c2568v.f5716n.m3330n(0, c2568v.f5714l).f7365z) {
                                j = j4;
                            } else {
                                j = j2;
                            }
                        } else {
                            j = j2;
                        }
                        Pair<Object, Long> pairM3328j = abstractC2832o2.m3328j(c2568v.f5714l, c2568v.f5715m, 0, j);
                        Object obj4 = pairM3328j.first;
                        long jLongValue = ((Long) pairM3328j.second).longValue();
                        if (c2568v.f5720r) {
                            C2568v.a aVar4 = c2568v.f5716n;
                            aVar = new C2568v.a(abstractC2832o2, aVar4.f5722m, aVar4.f5723n);
                        } else {
                            aVar = new C2568v.a(abstractC2832o2, obj3, obj4);
                        }
                        c2568v.f5716n = aVar;
                        C2567u c2567u3 = c2568v.f5717o;
                        if (c2567u3 != null) {
                            c2568v.m2592v(jLongValue);
                            InterfaceC2530a0.a aVar5 = c2567u3.f5705j;
                            Object obj5 = aVar5.f5732a;
                            if (c2568v.f5716n.f5723n != null && obj5.equals(C2568v.a.f5721l)) {
                                obj5 = c2568v.f5716n.f5723n;
                            }
                            aVarM2460b = aVar5.m2460b(obj5);
                        }
                        c2568v.f5720r = true;
                        c2568v.f5719q = true;
                        c2568v.m2553r(c2568v.f5716n);
                        if (aVarM2460b != null) {
                            C2567u c2567u4 = c2568v.f5717o;
                            Objects.requireNonNull(c2567u4);
                            c2567u4.m2590d(aVarM2460b);
                        }
                    }
                    if (c2568v.f5720r) {
                        C2568v.a aVar6 = c2568v.f5716n;
                        aVar2 = new C2568v.a(abstractC2832o2, aVar6.f5722m, aVar6.f5723n);
                    } else {
                        aVar2 = new C2568v.a(abstractC2832o2, AbstractC2832o2.c.f7345j, C2568v.a.f5721l);
                    }
                    c2568v.f5716n = aVar2;
                }
                aVarM2460b = null;
                c2568v.f5720r = true;
                c2568v.f5719q = true;
                c2568v.m2553r(c2568v.f5716n);
                if (aVarM2460b != null) {
                    C2567u c2567u5 = c2568v.f5717o;
                    Objects.requireNonNull(c2567u5);
                    c2567u5.m2590d(aVarM2460b);
                }
            }
        };
        a aVar = new a(null);
        this.f5664g.put(null, new b<>(interfaceC2530a0, bVar, aVar));
        Handler handler = this.f5665h;
        Objects.requireNonNull(handler);
        interfaceC2530a0.mo2447b(handler, aVar);
        Handler handler2 = this.f5665h;
        Objects.requireNonNull(handler2);
        interfaceC2530a0.mo2451f(handler2, aVar);
        interfaceC2530a0.mo2457l(bVar, this.f5666i);
        if (!this.f5634b.isEmpty()) {
            return;
        }
        interfaceC2530a0.mo2449d(bVar);
    }
}
