package p007b.p225i.p226a.p228b.p231j.p232q;

import android.content.Context;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.q.l */
/* JADX INFO: compiled from: MetadataBackendRegistry_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2461l implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<Context> f5323a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<C2458i> f5324b;

    public C2461l(InterfaceC5318a<Context> interfaceC5318a, InterfaceC5318a<C2458i> interfaceC5318a2) {
        this.f5323a = interfaceC5318a;
        this.f5324b = interfaceC5318a2;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new C2460k(this.f5323a.get(), this.f5324b.get());
    }
}
