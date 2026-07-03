package p007b.p225i.p226a.p242c;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import p007b.p225i.p226a.p242c.p243a3.C2566t;
import p007b.p225i.p226a.p242c.p243a3.C2567u;
import p007b.p225i.p226a.p242c.p243a3.C2568v;
import p007b.p225i.p226a.p242c.p243a3.C2569w;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p262s2.C2868g1;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;

/* JADX INFO: renamed from: b.i.a.c.u1 */
/* JADX INFO: compiled from: MediaSourceList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2945u1 {

    /* JADX INFO: renamed from: d */
    public final d f7867d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2532b0.a f7868e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC2988s.a f7869f;

    /* JADX INFO: renamed from: g */
    public final HashMap<c, b> f7870g;

    /* JADX INFO: renamed from: h */
    public final Set<c> f7871h;

    /* JADX INFO: renamed from: j */
    public boolean f7873j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public InterfaceC2680a0 f7874k;

    /* JADX INFO: renamed from: i */
    public InterfaceC2550k0 f7872i = new InterfaceC2550k0.a(0, new Random());

    /* JADX INFO: renamed from: b */
    public final IdentityHashMap<InterfaceC2570x, c> f7865b = new IdentityHashMap<>();

    /* JADX INFO: renamed from: c */
    public final Map<Object, c> f7866c = new HashMap();

    /* JADX INFO: renamed from: a */
    public final List<c> f7864a = new ArrayList();

    /* JADX INFO: renamed from: b.i.a.c.u1$a */
    /* JADX INFO: compiled from: MediaSourceList.java */
    public final class a implements InterfaceC2532b0, InterfaceC2988s {

        /* JADX INFO: renamed from: j */
        public final c f7875j;

        /* JADX INFO: renamed from: k */
        public InterfaceC2532b0.a f7876k;

        /* JADX INFO: renamed from: l */
        public InterfaceC2988s.a f7877l;

        public a(c cVar) {
            this.f7876k = C2945u1.this.f7868e;
            this.f7877l = C2945u1.this.f7869f;
            this.f7875j = cVar;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: J */
        public void mo2567J(int i, @Nullable InterfaceC2530a0.a aVar) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3588b();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: S */
        public void mo2568S(int i, @Nullable InterfaceC2530a0.a aVar) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3587a();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: X */
        public void mo2461X(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2469d(c2566t, c2569w);
            }
        }

        /* JADX INFO: renamed from: a */
        public final boolean m3544a(int i, @Nullable InterfaceC2530a0.a aVar) {
            InterfaceC2530a0.a aVarM2460b = null;
            if (aVar != null) {
                c cVar = this.f7875j;
                for (int i2 = 0; i2 < cVar.f7884c.size(); i2++) {
                    if (cVar.f7884c.get(i2).f5735d == aVar.f5735d) {
                        aVarM2460b = aVar.m2460b(Pair.create(cVar.f7883b, aVar.f5732a));
                        break;
                    }
                }
                if (aVarM2460b == null) {
                    return false;
                }
            }
            int i3 = i + this.f7875j.f7885d;
            InterfaceC2532b0.a aVar2 = this.f7876k;
            if (aVar2.f5481a != i3 || !C2738e0.m2993a(aVar2.f5482b, aVarM2460b)) {
                this.f7876k = C2945u1.this.f7868e.m2472g(i3, aVarM2460b, 0L);
            }
            InterfaceC2988s.a aVar3 = this.f7877l;
            if (aVar3.f8012a == i3 && C2738e0.m2993a(aVar3.f8013b, aVarM2460b)) {
                return true;
            }
            this.f7877l = C2945u1.this.f7869f.m3593g(i3, aVarM2460b);
            return true;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: c0 */
        public void mo2571c0(int i, @Nullable InterfaceC2530a0.a aVar, int i2) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3590d(i2);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: d0 */
        public void mo2572d0(int i, @Nullable InterfaceC2530a0.a aVar) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3592f();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: g0 */
        public void mo2462g0(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w, IOException iOException, boolean z2) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2470e(c2566t, c2569w, iOException, z2);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: i0 */
        public void mo2573i0(int i, @Nullable InterfaceC2530a0.a aVar) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3589c();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: o */
        public void mo2463o(int i, @Nullable InterfaceC2530a0.a aVar, C2569w c2569w) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2467b(c2569w);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: q */
        public void mo2464q(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2468c(c2566t, c2569w);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s
        /* JADX INFO: renamed from: u */
        public void mo2574u(int i, @Nullable InterfaceC2530a0.a aVar, Exception exc) {
            if (m3544a(i, aVar)) {
                this.f7877l.m3591e(exc);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0
        /* JADX INFO: renamed from: x */
        public void mo2465x(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w) {
            if (m3544a(i, aVar)) {
                this.f7876k.m2471f(c2566t, c2569w);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.u1$b */
    /* JADX INFO: compiled from: MediaSourceList.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC2530a0 f7879a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC2530a0.b f7880b;

        /* JADX INFO: renamed from: c */
        public final a f7881c;

        public b(InterfaceC2530a0 interfaceC2530a0, InterfaceC2530a0.b bVar, a aVar) {
            this.f7879a = interfaceC2530a0;
            this.f7880b = bVar;
            this.f7881c = aVar;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.u1$c */
    /* JADX INFO: compiled from: MediaSourceList.java */
    public static final class c implements InterfaceC2910t1 {

        /* JADX INFO: renamed from: a */
        public final C2568v f7882a;

        /* JADX INFO: renamed from: d */
        public int f7885d;

        /* JADX INFO: renamed from: e */
        public boolean f7886e;

        /* JADX INFO: renamed from: c */
        public final List<InterfaceC2530a0.a> f7884c = new ArrayList();

        /* JADX INFO: renamed from: b */
        public final Object f7883b = new Object();

        public c(InterfaceC2530a0 interfaceC2530a0, boolean z2) {
            this.f7882a = new C2568v(interfaceC2530a0, z2);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC2910t1
        /* JADX INFO: renamed from: a */
        public AbstractC2832o2 mo2931a() {
            return this.f7882a.f5716n;
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC2910t1
        public Object getUid() {
            return this.f7883b;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.u1$d */
    /* JADX INFO: compiled from: MediaSourceList.java */
    public interface d {
    }

    public C2945u1(d dVar, @Nullable C2868g1 c2868g1, Handler handler) {
        this.f7867d = dVar;
        InterfaceC2532b0.a aVar = new InterfaceC2532b0.a();
        this.f7868e = aVar;
        InterfaceC2988s.a aVar2 = new InterfaceC2988s.a();
        this.f7869f = aVar2;
        this.f7870g = new HashMap<>();
        this.f7871h = new HashSet();
        if (c2868g1 != null) {
            aVar.f5483c.add(new InterfaceC2532b0.a.C13222a(handler, c2868g1));
            aVar2.f8014c.add(new InterfaceC2988s.a.C13226a(handler, c2868g1));
        }
    }

    /* JADX INFO: renamed from: a */
    public AbstractC2832o2 m3535a(int i, List<c> list, InterfaceC2550k0 interfaceC2550k0) {
        if (!list.isEmpty()) {
            this.f7872i = interfaceC2550k0;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.f7864a.get(i2 - 1);
                    cVar.f7885d = cVar2.f7882a.f5716n.mo2557p() + cVar2.f7885d;
                    cVar.f7886e = false;
                    cVar.f7884c.clear();
                } else {
                    cVar.f7885d = 0;
                    cVar.f7886e = false;
                    cVar.f7884c.clear();
                }
                m3536b(i2, cVar.f7882a.f5716n.mo2557p());
                this.f7864a.add(i2, cVar);
                this.f7866c.put(cVar.f7883b, cVar);
                if (this.f7873j) {
                    m3541g(cVar);
                    if (this.f7865b.isEmpty()) {
                        this.f7871h.add(cVar);
                    } else {
                        b bVar = this.f7870g.get(cVar);
                        if (bVar != null) {
                            bVar.f7879a.mo2449d(bVar.f7880b);
                        }
                    }
                }
            }
        }
        return m3537c();
    }

    /* JADX INFO: renamed from: b */
    public final void m3536b(int i, int i2) {
        while (i < this.f7864a.size()) {
            this.f7864a.get(i).f7885d += i2;
            i++;
        }
    }

    /* JADX INFO: renamed from: c */
    public AbstractC2832o2 m3537c() {
        if (this.f7864a.isEmpty()) {
            return AbstractC2832o2.f7337j;
        }
        int iMo2557p = 0;
        for (int i = 0; i < this.f7864a.size(); i++) {
            c cVar = this.f7864a.get(i);
            cVar.f7885d = iMo2557p;
            iMo2557p += cVar.f7882a.f5716n.mo2557p();
        }
        return new C2634c2(this.f7864a, this.f7872i);
    }

    /* JADX INFO: renamed from: d */
    public final void m3538d() {
        Iterator<c> it = this.f7871h.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f7884c.isEmpty()) {
                b bVar = this.f7870g.get(next);
                if (bVar != null) {
                    bVar.f7879a.mo2449d(bVar.f7880b);
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public int m3539e() {
        return this.f7864a.size();
    }

    /* JADX INFO: renamed from: f */
    public final void m3540f(c cVar) {
        if (cVar.f7886e && cVar.f7884c.isEmpty()) {
            b bVarRemove = this.f7870g.remove(cVar);
            Objects.requireNonNull(bVarRemove);
            bVarRemove.f7879a.mo2446a(bVarRemove.f7880b);
            bVarRemove.f7879a.mo2448c(bVarRemove.f7881c);
            bVarRemove.f7879a.mo2452g(bVarRemove.f7881c);
            this.f7871h.remove(cVar);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m3541g(c cVar) {
        C2568v c2568v = cVar.f7882a;
        InterfaceC2530a0.b bVar = new InterfaceC2530a0.b() { // from class: b.i.a.c.n0
            @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0.b
            /* JADX INFO: renamed from: a */
            public final void mo2445a(InterfaceC2530a0 interfaceC2530a0, AbstractC2832o2 abstractC2832o2) {
                ((C2803h1) this.f7256a.f7867d).f7083q.mo2959f(22);
            }
        };
        a aVar = new a(cVar);
        this.f7870g.put(cVar, new b(c2568v, bVar, aVar));
        Handler handler = new Handler(C2738e0.m3007o(), null);
        Objects.requireNonNull(c2568v);
        InterfaceC2532b0.a aVar2 = c2568v.f5635c;
        Objects.requireNonNull(aVar2);
        aVar2.f5483c.add(new InterfaceC2532b0.a.C13222a(handler, aVar));
        Handler handler2 = new Handler(C2738e0.m3007o(), null);
        InterfaceC2988s.a aVar3 = c2568v.f5636d;
        Objects.requireNonNull(aVar3);
        aVar3.f8014c.add(new InterfaceC2988s.a.C13226a(handler2, aVar));
        c2568v.mo2457l(bVar, this.f7874k);
    }

    /* JADX INFO: renamed from: h */
    public void m3542h(InterfaceC2570x interfaceC2570x) {
        c cVarRemove = this.f7865b.remove(interfaceC2570x);
        Objects.requireNonNull(cVarRemove);
        cVarRemove.f7882a.mo2455j(interfaceC2570x);
        cVarRemove.f7884c.remove(((C2567u) interfaceC2570x).f5705j);
        if (!this.f7865b.isEmpty()) {
            m3538d();
        }
        m3540f(cVarRemove);
    }

    /* JADX INFO: renamed from: i */
    public final void m3543i(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVarRemove = this.f7864a.remove(i3);
            this.f7866c.remove(cVarRemove.f7883b);
            m3536b(i3, -cVarRemove.f7882a.f5716n.mo2557p());
            cVarRemove.f7886e = true;
            if (this.f7873j) {
                m3540f(cVarRemove);
            }
        }
    }
}
