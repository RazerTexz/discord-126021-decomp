package b.i.a.b.j.q;

import android.content.Context;

/* JADX INFO: compiled from: MetadataBackendRegistry_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements c0.a.a {
    public final c0.a.a<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0.a.a<i> f778b;

    public l(c0.a.a<Context> aVar, c0.a.a<i> aVar2) {
        this.a = aVar;
        this.f778b = aVar2;
    }

    @Override // c0.a.a
    public Object get() {
        return new k(this.a.get(), this.f778b.get());
    }
}
