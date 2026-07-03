package p007b.p225i.p226a.p228b.p231j;

import p007b.p225i.p226a.p228b.p231j.p236t.InterfaceC2470e;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2484l;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2488p;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.p */
/* JADX INFO: compiled from: TransportRuntime_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2449p implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<InterfaceC2519a> f5295a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<InterfaceC2519a> f5296b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5318a<InterfaceC2470e> f5297c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC5318a<C2484l> f5298d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC5318a<C2488p> f5299e;

    public C2449p(InterfaceC5318a<InterfaceC2519a> interfaceC5318a, InterfaceC5318a<InterfaceC2519a> interfaceC5318a2, InterfaceC5318a<InterfaceC2470e> interfaceC5318a3, InterfaceC5318a<C2484l> interfaceC5318a4, InterfaceC5318a<C2488p> interfaceC5318a5) {
        this.f5295a = interfaceC5318a;
        this.f5296b = interfaceC5318a2;
        this.f5297c = interfaceC5318a3;
        this.f5298d = interfaceC5318a4;
        this.f5299e = interfaceC5318a5;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new C2447n(this.f5295a.get(), this.f5296b.get(), this.f5297c.get(), this.f5298d.get(), this.f5299e.get());
    }
}
