package p007b.p225i.p226a.p228b.p231j.p236t;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.InterfaceC2413h;
import p007b.p225i.p226a.p228b.p231j.AbstractC2439f;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;
import p007b.p225i.p226a.p228b.p231j.C2447n;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2454e;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2462m;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.InterfaceC2490r;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c;
import p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a;

/* JADX INFO: renamed from: b.i.a.b.j.t.c */
/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2468c implements InterfaceC2470e {

    /* JADX INFO: renamed from: a */
    public static final Logger f5336a = Logger.getLogger(C2447n.class.getName());

    /* JADX INFO: renamed from: b */
    public final InterfaceC2490r f5337b;

    /* JADX INFO: renamed from: c */
    public final Executor f5338c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2454e f5339d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2494c f5340e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC2518a f5341f;

    public C2468c(Executor executor, InterfaceC2454e interfaceC2454e, InterfaceC2490r interfaceC2490r, InterfaceC2494c interfaceC2494c, InterfaceC2518a interfaceC2518a) {
        this.f5338c = executor;
        this.f5339d = interfaceC2454e;
        this.f5337b = interfaceC2490r;
        this.f5340e = interfaceC2494c;
        this.f5341f = interfaceC2518a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.InterfaceC2470e
    /* JADX INFO: renamed from: a */
    public void mo2373a(final AbstractC2442i abstractC2442i, final AbstractC2439f abstractC2439f, final InterfaceC2413h interfaceC2413h) {
        this.f5338c.execute(new Runnable(this, abstractC2442i, interfaceC2413h, abstractC2439f) { // from class: b.i.a.b.j.t.a

            /* JADX INFO: renamed from: j */
            public final C2468c f5329j;

            /* JADX INFO: renamed from: k */
            public final AbstractC2442i f5330k;

            /* JADX INFO: renamed from: l */
            public final InterfaceC2413h f5331l;

            /* JADX INFO: renamed from: m */
            public final AbstractC2439f f5332m;

            {
                this.f5329j = this;
                this.f5330k = abstractC2442i;
                this.f5331l = interfaceC2413h;
                this.f5332m = abstractC2439f;
            }

            @Override // java.lang.Runnable
            public void run() {
                final C2468c c2468c = this.f5329j;
                final AbstractC2442i abstractC2442i2 = this.f5330k;
                InterfaceC2413h interfaceC2413h2 = this.f5331l;
                AbstractC2439f abstractC2439f2 = this.f5332m;
                Logger logger = C2468c.f5336a;
                try {
                    InterfaceC2462m interfaceC2462m = c2468c.f5339d.get(abstractC2442i2.mo2348b());
                    if (interfaceC2462m == null) {
                        String str = String.format("Transport backend '%s' is not registered", abstractC2442i2.mo2348b());
                        C2468c.f5336a.warning(str);
                        interfaceC2413h2.mo2292a(new IllegalArgumentException(str));
                    } else {
                        final AbstractC2439f abstractC2439fMo2298b = interfaceC2462m.mo2298b(abstractC2439f2);
                        c2468c.f5341f.mo2406a(new InterfaceC2518a.a(c2468c, abstractC2442i2, abstractC2439fMo2298b) { // from class: b.i.a.b.j.t.b

                            /* JADX INFO: renamed from: a */
                            public final C2468c f5333a;

                            /* JADX INFO: renamed from: b */
                            public final AbstractC2442i f5334b;

                            /* JADX INFO: renamed from: c */
                            public final AbstractC2439f f5335c;

                            {
                                this.f5333a = c2468c;
                                this.f5334b = abstractC2442i2;
                                this.f5335c = abstractC2439fMo2298b;
                            }

                            @Override // p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a.a
                            public Object execute() {
                                C2468c c2468c2 = this.f5333a;
                                AbstractC2442i abstractC2442i3 = this.f5334b;
                                c2468c2.f5340e.mo2394a0(abstractC2442i3, this.f5335c);
                                c2468c2.f5337b.mo2382a(abstractC2442i3, 1);
                                return null;
                            }
                        });
                        interfaceC2413h2.mo2292a(null);
                    }
                } catch (Exception e) {
                    Logger logger2 = C2468c.f5336a;
                    StringBuilder sbM833U = C1643a.m833U("Error scheduling event ");
                    sbM833U.append(e.getMessage());
                    logger2.warning(sbM833U.toString());
                    interfaceC2413h2.mo2292a(e);
                }
            }
        });
    }
}
