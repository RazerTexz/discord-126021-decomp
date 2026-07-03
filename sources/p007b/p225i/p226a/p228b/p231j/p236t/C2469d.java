package p007b.p225i.p226a.p228b.p231j.p236t;

import java.util.concurrent.Executor;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2454e;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.InterfaceC2490r;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c;
import p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.t.d */
/* JADX INFO: compiled from: DefaultScheduler_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2469d implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<Executor> f5342a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<InterfaceC2454e> f5343b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5318a<InterfaceC2490r> f5344c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC5318a<InterfaceC2494c> f5345d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC5318a<InterfaceC2518a> f5346e;

    public C2469d(InterfaceC5318a<Executor> interfaceC5318a, InterfaceC5318a<InterfaceC2454e> interfaceC5318a2, InterfaceC5318a<InterfaceC2490r> interfaceC5318a3, InterfaceC5318a<InterfaceC2494c> interfaceC5318a4, InterfaceC5318a<InterfaceC2518a> interfaceC5318a5) {
        this.f5342a = interfaceC5318a;
        this.f5343b = interfaceC5318a2;
        this.f5344c = interfaceC5318a3;
        this.f5345d = interfaceC5318a4;
        this.f5346e = interfaceC5318a5;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new C2468c(this.f5342a.get(), this.f5343b.get(), this.f5344c.get(), this.f5345d.get(), this.f5346e.get());
    }
}
