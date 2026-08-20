package p007b.p225i.p226a.p228b.p231j;

import android.content.Context;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.InterfaceC2412g;
import p007b.p225i.p226a.p228b.p229i.C2414a;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;
import p007b.p225i.p226a.p228b.p231j.p236t.InterfaceC2470e;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2484l;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2488p;
import p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;

/* JADX INFO: renamed from: b.i.a.b.j.n */
/* JADX INFO: compiled from: TransportRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2447n implements InterfaceC2446m {

    /* JADX INFO: renamed from: a */
    public static volatile AbstractC2448o f5290a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2519a f5291b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2519a f5292c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2470e f5293d;

    /* JADX INFO: renamed from: e */
    public final C2484l f5294e;

    public C2447n(InterfaceC2519a interfaceC2519a, InterfaceC2519a interfaceC2519a2, InterfaceC2470e interfaceC2470e, C2484l c2484l, final C2488p c2488p) {
        this.f5291b = interfaceC2519a;
        this.f5292c = interfaceC2519a2;
        this.f5293d = interfaceC2470e;
        this.f5294e = c2484l;
        c2488p.f5401a.execute(new Runnable(c2488p) { // from class: b.i.a.b.j.t.h.n

            /* JADX INFO: renamed from: j */
            public final C2488p f5399j;

            {
                this.f5399j = c2488p;
            }

            @Override // java.lang.Runnable
            public void run() {
                final C2488p c2488p2 = this.f5399j;
                c2488p2.f5404d.mo2406a(new InterfaceC2518a.a(c2488p2) { // from class: b.i.a.b.j.t.h.o

                    /* JADX INFO: renamed from: a */
                    public final C2488p f5400a;

                    {
                        this.f5400a = c2488p2;
                    }

                    @Override // p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a.a
                    public Object execute() {
                        C2488p c2488p3 = this.f5400a;
                        Iterator<AbstractC2442i> it = c2488p3.f5402b.mo2402z().iterator();
                        while (it.hasNext()) {
                            c2488p3.f5403c.mo2382a(it.next(), 1);
                        }
                        return null;
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static C2447n m2359a() {
        AbstractC2448o abstractC2448o = f5290a;
        if (abstractC2448o != null) {
            return ((C2436c) abstractC2448o).f5275u.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    /* JADX INFO: renamed from: b */
    public static void m2360b(Context context) {
        if (f5290a == null) {
            synchronized (C2447n.class) {
                if (f5290a == null) {
                    Objects.requireNonNull(context);
                    f5290a = new C2436c(context, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC2412g m2361c(InterfaceC2437d interfaceC2437d) {
        Set setSingleton;
        if (interfaceC2437d instanceof InterfaceC2437d) {
            Objects.requireNonNull((C2414a) interfaceC2437d);
            setSingleton = Collections.unmodifiableSet(C2414a.f5126d);
        } else {
            setSingleton = Collections.singleton(new C2407b("proto"));
        }
        AbstractC2442i.a aVarM2358a = AbstractC2442i.m2358a();
        Objects.requireNonNull(interfaceC2437d);
        aVarM2358a.mo2352b("cct");
        C2435b.b bVar = (C2435b.b) aVarM2358a;
        bVar.f5262b = ((C2414a) interfaceC2437d).m2294b();
        return new C2443j(setSingleton, bVar.mo2351a(), this);
    }
}
