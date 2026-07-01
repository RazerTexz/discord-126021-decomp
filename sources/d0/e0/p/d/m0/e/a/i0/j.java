package d0.e0.p.d.m0.e.a.i0;

import d0.z.d.m;

/* JADX INFO: compiled from: ModuleClassResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements i {
    public d0.e0.p.d.m0.k.y.b a;

    public final d0.e0.p.d.m0.k.y.b getResolver() {
        d0.e0.p.d.m0.k.y.b bVar = this.a;
        if (bVar != null) {
            return bVar;
        }
        m.throwUninitializedPropertyAccessException("resolver");
        throw null;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.i
    public d0.e0.p.d.m0.c.e resolveClass(d0.e0.p.d.m0.e.a.k0.g gVar) {
        m.checkNotNullParameter(gVar, "javaClass");
        return getResolver().resolveClass(gVar);
    }

    public final void setResolver(d0.e0.p.d.m0.k.y.b bVar) {
        m.checkNotNullParameter(bVar, "<set-?>");
        this.a = bVar;
    }
}
