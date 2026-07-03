package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.p243a3.AbstractC2557o;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.p244p0.C2562c;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.a3.v */
/* JADX INFO: compiled from: MaskingMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2568v extends AbstractC2557o<Void> {

    /* JADX INFO: renamed from: j */
    public final InterfaceC2530a0 f5712j;

    /* JADX INFO: renamed from: k */
    public final boolean f5713k;

    /* JADX INFO: renamed from: l */
    public final AbstractC2832o2.c f5714l;

    /* JADX INFO: renamed from: m */
    public final AbstractC2832o2.b f5715m;

    /* JADX INFO: renamed from: n */
    public a f5716n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public C2567u f5717o;

    /* JADX INFO: renamed from: p */
    public boolean f5718p;

    /* JADX INFO: renamed from: q */
    public boolean f5719q;

    /* JADX INFO: renamed from: r */
    public boolean f5720r;

    /* JADX INFO: renamed from: b.i.a.c.a3.v$a */
    /* JADX INFO: compiled from: MaskingMediaSource.java */
    public static final class a extends AbstractC2564r {

        /* JADX INFO: renamed from: l */
        public static final Object f5721l = new Object();

        /* JADX INFO: renamed from: m */
        @Nullable
        public final Object f5722m;

        /* JADX INFO: renamed from: n */
        @Nullable
        public final Object f5723n;

        public a(AbstractC2832o2 abstractC2832o2, @Nullable Object obj, @Nullable Object obj2) {
            super(abstractC2832o2);
            this.f5722m = obj;
            this.f5723n = obj2;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.AbstractC2564r, p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: b */
        public int mo2554b(Object obj) {
            Object obj2;
            AbstractC2832o2 abstractC2832o2 = this.f5697k;
            if (f5721l.equals(obj) && (obj2 = this.f5723n) != null) {
                obj = obj2;
            }
            return abstractC2832o2.mo2554b(obj);
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: g */
        public AbstractC2832o2.b mo2513g(int i, AbstractC2832o2.b bVar, boolean z2) {
            this.f5697k.mo2513g(i, bVar, z2);
            if (C2738e0.m2993a(bVar.f7339k, this.f5723n) && z2) {
                bVar.f7339k = f5721l;
            }
            return bVar;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.AbstractC2564r, p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: m */
        public Object mo2556m(int i) {
            Object objMo2556m = this.f5697k.mo2556m(i);
            return C2738e0.m2993a(objMo2556m, this.f5723n) ? f5721l : objMo2556m;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: o */
        public AbstractC2832o2.c mo2514o(int i, AbstractC2832o2.c cVar, long j) {
            this.f5697k.mo2514o(i, cVar, j);
            if (C2738e0.m2993a(cVar.f7353n, this.f5722m)) {
                cVar.f7353n = AbstractC2832o2.c.f7345j;
            }
            return cVar;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.v$b */
    /* JADX INFO: compiled from: MaskingMediaSource.java */
    @VisibleForTesting
    public static final class b extends AbstractC2832o2 {

        /* JADX INFO: renamed from: k */
        public final C2831o1 f5724k;

        public b(C2831o1 c2831o1) {
            this.f5724k = c2831o1;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: b */
        public int mo2554b(Object obj) {
            return obj == a.f5721l ? 0 : -1;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: g */
        public AbstractC2832o2.b mo2513g(int i, AbstractC2832o2.b bVar, boolean z2) {
            bVar.m3337f(z2 ? 0 : null, z2 ? a.f5721l : null, 0, -9223372036854775807L, 0L, C2562c.f5680j, true);
            return bVar;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: i */
        public int mo2555i() {
            return 1;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: m */
        public Object mo2556m(int i) {
            return a.f5721l;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: o */
        public AbstractC2832o2.c mo2514o(int i, AbstractC2832o2.c cVar, long j) {
            cVar.m3342e(AbstractC2832o2.c.f7345j, this.f5724k, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            cVar.f7364y = true;
            return cVar;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: p */
        public int mo2557p() {
            return 1;
        }
    }

    public C2568v(InterfaceC2530a0 interfaceC2530a0, boolean z2) {
        this.f5712j = interfaceC2530a0;
        this.f5713k = z2 && interfaceC2530a0.mo2454i();
        this.f5714l = new AbstractC2832o2.c();
        this.f5715m = new AbstractC2832o2.b();
        AbstractC2832o2 abstractC2832o2Mo2456k = interfaceC2530a0.mo2456k();
        if (abstractC2832o2Mo2456k == null) {
            this.f5716n = new a(new b(interfaceC2530a0.mo2450e()), AbstractC2832o2.c.f7345j, a.f5721l);
        } else {
            this.f5716n = new a(abstractC2832o2Mo2456k, null, null);
            this.f5720r = true;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: e */
    public C2831o1 mo2450e() {
        return this.f5712j.mo2450e();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: h */
    public void mo2453h() {
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: j */
    public void mo2455j(InterfaceC2570x interfaceC2570x) {
        C2567u c2567u = (C2567u) interfaceC2570x;
        if (c2567u.f5709n != null) {
            InterfaceC2530a0 interfaceC2530a0 = c2567u.f5708m;
            Objects.requireNonNull(interfaceC2530a0);
            interfaceC2530a0.mo2455j(c2567u.f5709n);
        }
        if (interfaceC2570x == this.f5717o) {
            this.f5717o = null;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.AbstractC2551l
    /* JADX INFO: renamed from: q */
    public void mo2509q(@Nullable InterfaceC2680a0 interfaceC2680a0) {
        this.f5666i = interfaceC2680a0;
        this.f5665h = C2738e0.m3002j();
        if (this.f5713k) {
            return;
        }
        this.f5718p = true;
        m2566t(null, this.f5712j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.AbstractC2551l
    /* JADX INFO: renamed from: s */
    public void mo2510s() {
        this.f5719q = false;
        this.f5718p = false;
        for (AbstractC2557o.b bVar : this.f5664g.values()) {
            bVar.f5671a.mo2446a(bVar.f5672b);
            bVar.f5671a.mo2448c(bVar.f5673c);
            bVar.f5671a.mo2452g(bVar.f5673c);
        }
        this.f5664g.clear();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public C2567u mo2459n(InterfaceC2530a0.a aVar, C2713o c2713o, long j) {
        C2567u c2567u = new C2567u(aVar, c2713o, j);
        InterfaceC2530a0 interfaceC2530a0 = this.f5712j;
        C1460d.m426D(c2567u.f5708m == null);
        c2567u.f5708m = interfaceC2530a0;
        if (this.f5719q) {
            Object obj = aVar.f5732a;
            if (this.f5716n.f5723n != null && obj.equals(a.f5721l)) {
                obj = this.f5716n.f5723n;
            }
            c2567u.m2590d(aVar.m2460b(obj));
        } else {
            this.f5717o = c2567u;
            if (!this.f5718p) {
                this.f5718p = true;
                m2566t(null, this.f5712j);
            }
        }
        return c2567u;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    /* JADX INFO: renamed from: v */
    public final void m2592v(long j) {
        C2567u c2567u = this.f5717o;
        int iMo2554b = this.f5716n.mo2554b(c2567u.f5705j.f5732a);
        if (iMo2554b == -1) {
            return;
        }
        long j2 = this.f5716n.m3326f(iMo2554b, this.f5715m).f7341m;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        c2567u.f5711p = j;
    }
}
