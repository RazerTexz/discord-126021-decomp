package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;
import p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2456g;
import p007b.p225i.p226a.p228b.p231j.p232q.C2450a;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2454e;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2462m;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2499h;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c;
import p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.l */
/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2484l {

    /* JADX INFO: renamed from: a */
    public final Context f5385a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2454e f5386b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2494c f5387c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2490r f5388d;

    /* JADX INFO: renamed from: e */
    public final Executor f5389e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC2518a f5390f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC2519a f5391g;

    public C2484l(Context context, InterfaceC2454e interfaceC2454e, InterfaceC2494c interfaceC2494c, InterfaceC2490r interfaceC2490r, Executor executor, InterfaceC2518a interfaceC2518a, InterfaceC2519a interfaceC2519a) {
        this.f5385a = context;
        this.f5386b = interfaceC2454e;
        this.f5387c = interfaceC2494c;
        this.f5388d = interfaceC2490r;
        this.f5389e = executor;
        this.f5390f = interfaceC2518a;
        this.f5391g = interfaceC2519a;
    }

    /* JADX INFO: renamed from: a */
    public void m2385a(final AbstractC2442i abstractC2442i, final int i) {
        AbstractC2456g abstractC2456gMo2297a;
        InterfaceC2462m interfaceC2462m = this.f5386b.get(abstractC2442i.mo2348b());
        final Iterable iterable = (Iterable) this.f5390f.mo2406a(new InterfaceC2518a.a(this, abstractC2442i) { // from class: b.i.a.b.j.t.h.h

            /* JADX INFO: renamed from: a */
            public final C2484l f5374a;

            /* JADX INFO: renamed from: b */
            public final AbstractC2442i f5375b;

            {
                this.f5374a = this;
                this.f5375b = abstractC2442i;
            }

            @Override // p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a.a
            public Object execute() {
                C2484l c2484l = this.f5374a;
                return c2484l.f5387c.mo2400r(this.f5375b);
            }
        });
        if (iterable.iterator().hasNext()) {
            if (interfaceC2462m == null) {
                C1460d.m486X("Uploader", "Unknown backend for %s, deleting event batch for it...", abstractC2442i);
                abstractC2456gMo2297a = AbstractC2456g.m2370a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AbstractC2499h) it.next()).mo2391a());
                }
                byte[] bArrMo2349c = abstractC2442i.mo2349c();
                if (1 == 0) {
                    throw new IllegalStateException(C1643a.m883w("Missing required properties:", ""));
                }
                abstractC2456gMo2297a = interfaceC2462m.mo2297a(new C2450a(arrayList, bArrMo2349c, null));
            }
            final AbstractC2456g abstractC2456g = abstractC2456gMo2297a;
            this.f5390f.mo2406a(new InterfaceC2518a.a(this, abstractC2456g, iterable, abstractC2442i, i) { // from class: b.i.a.b.j.t.h.i

                /* JADX INFO: renamed from: a */
                public final C2484l f5376a;

                /* JADX INFO: renamed from: b */
                public final AbstractC2456g f5377b;

                /* JADX INFO: renamed from: c */
                public final Iterable f5378c;

                /* JADX INFO: renamed from: d */
                public final AbstractC2442i f5379d;

                /* JADX INFO: renamed from: e */
                public final int f5380e;

                {
                    this.f5376a = this;
                    this.f5377b = abstractC2456g;
                    this.f5378c = iterable;
                    this.f5379d = abstractC2442i;
                    this.f5380e = i;
                }

                @Override // p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a.a
                public Object execute() {
                    C2484l c2484l = this.f5376a;
                    AbstractC2456g abstractC2456g2 = this.f5377b;
                    Iterable<AbstractC2499h> iterable2 = this.f5378c;
                    AbstractC2442i abstractC2442i2 = this.f5379d;
                    int i2 = this.f5380e;
                    if (abstractC2456g2.mo2365c() == AbstractC2456g.a.TRANSIENT_ERROR) {
                        c2484l.f5387c.mo2399n0(iterable2);
                        c2484l.f5388d.mo2382a(abstractC2442i2, i2 + 1);
                        return null;
                    }
                    c2484l.f5387c.mo2398m(iterable2);
                    if (abstractC2456g2.mo2365c() == AbstractC2456g.a.OK) {
                        c2484l.f5387c.mo2401v(abstractC2442i2, abstractC2456g2.mo2364b() + c2484l.f5391g.mo2413a());
                    }
                    if (!c2484l.f5387c.mo2397l0(abstractC2442i2)) {
                        return null;
                    }
                    c2484l.f5388d.mo2382a(abstractC2442i2, 1);
                    return null;
                }
            });
        }
    }
}
