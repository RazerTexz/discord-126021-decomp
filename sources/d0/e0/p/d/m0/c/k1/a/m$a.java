package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.v0;

/* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a implements d0.e0.p.d.m0.e.a.j0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.c.k1.b.n f3288b;

    public m$a(d0.e0.p.d.m0.c.k1.b.n nVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "javaElement");
        this.f3288b = nVar;
    }

    @Override // d0.e0.p.d.m0.c.u0
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        d0.z.d.m.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    @Override // d0.e0.p.d.m0.e.a.j0.a
    public d0.e0.p.d.m0.c.k1.b.n getJavaElement() {
        return this.f3288b;
    }

    public String toString() {
        return m$a.class.getName() + ": " + getJavaElement();
    }

    @Override // d0.e0.p.d.m0.e.a.j0.a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.l getJavaElement() {
        return getJavaElement();
    }
}
