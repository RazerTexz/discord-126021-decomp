package p007b.p225i.p226a.p228b.p231j.p232q;

import android.content.Context;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.q.j */
/* JADX INFO: compiled from: CreationContextFactory_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2459j implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<Context> f5315a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<InterfaceC2519a> f5316b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5318a<InterfaceC2519a> f5317c;

    public C2459j(InterfaceC5318a<Context> interfaceC5318a, InterfaceC5318a<InterfaceC2519a> interfaceC5318a2, InterfaceC5318a<InterfaceC2519a> interfaceC5318a3) {
        this.f5315a = interfaceC5318a;
        this.f5316b = interfaceC5318a2;
        this.f5317c = interfaceC5318a3;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new C2458i(this.f5315a.get(), this.f5316b.get(), this.f5317c.get());
    }
}
