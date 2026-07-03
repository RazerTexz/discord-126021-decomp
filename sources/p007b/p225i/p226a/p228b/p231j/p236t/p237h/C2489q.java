package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import java.util.concurrent.Executor;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c;
import p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.q */
/* JADX INFO: compiled from: WorkInitializer_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2489q implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<Executor> f5405a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<InterfaceC2494c> f5406b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5318a<InterfaceC2490r> f5407c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC5318a<InterfaceC2518a> f5408d;

    public C2489q(InterfaceC5318a<Executor> interfaceC5318a, InterfaceC5318a<InterfaceC2494c> interfaceC5318a2, InterfaceC5318a<InterfaceC2490r> interfaceC5318a3, InterfaceC5318a<InterfaceC2518a> interfaceC5318a4) {
        this.f5405a = interfaceC5318a;
        this.f5406b = interfaceC5318a2;
        this.f5407c = interfaceC5318a3;
        this.f5408d = interfaceC5318a4;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new C2488p(this.f5405a.get(), this.f5406b.get(), this.f5407c.get(), this.f5408d.get());
    }
}
