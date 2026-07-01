package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.u0;
import java.util.List;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a<d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.k.v.g<?>> {
    public final c0 c;
    public final d0 d;
    public final d0.e0.p.d.m0.l.b.e e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c0 c0Var, d0 d0Var, d0.e0.p.d.m0.m.o oVar, n nVar) {
        super(oVar, nVar);
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(nVar, "kotlinClassFinder");
        this.c = c0Var;
        this.d = d0Var;
        this.e = new d0.e0.p.d.m0.l.b.e(c0Var, d0Var);
    }

    @Override // d0.e0.p.d.m0.e.b.a
    public p$a h(d0.e0.p.d.m0.g.a aVar, u0 u0Var, List<d0.e0.p.d.m0.c.g1.c> list) {
        d0.z.d.m.checkNotNullParameter(aVar, "annotationClassId");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        d0.z.d.m.checkNotNullParameter(list, "result");
        return new c$a(d0.e0.p.d.m0.c.w.findNonGenericClassAcrossDependencies(this.c, aVar, this.d), this, list, u0Var);
    }
}
