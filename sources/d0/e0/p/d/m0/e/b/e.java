package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.h1.c$b;
import d0.e0.p.d.m0.l.b.t$a;
import java.util.List;

/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final d0.e0.p.d.m0.l.b.j a;

    public e(d0.e0.p.d.m0.m.o oVar, c0 c0Var, d0.e0.p.d.m0.l.b.k kVar, g gVar, c cVar, d0.e0.p.d.m0.e.a.i0.f fVar, d0 d0Var, d0.e0.p.d.m0.l.b.p pVar, d0.e0.p.d.m0.d.b.c cVar2, d0.e0.p.d.m0.l.b.i iVar, d0.e0.p.d.m0.n.l1.l lVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        d0.z.d.m.checkNotNullParameter(kVar, "configuration");
        d0.z.d.m.checkNotNullParameter(gVar, "classDataFinder");
        d0.z.d.m.checkNotNullParameter(cVar, "annotationAndConstantLoader");
        d0.z.d.m.checkNotNullParameter(fVar, "packageFragmentProvider");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        d0.z.d.m.checkNotNullParameter(pVar, "errorReporter");
        d0.z.d.m.checkNotNullParameter(cVar2, "lookupTracker");
        d0.z.d.m.checkNotNullParameter(iVar, "contractDeserializer");
        d0.z.d.m.checkNotNullParameter(lVar, "kotlinTypeChecker");
        d0.e0.p.d.m0.b.h builtIns = c0Var.getBuiltIns();
        d0.e0.p.d.m0.b.q.f fVar2 = builtIns instanceof d0.e0.p.d.m0.b.q.f ? (d0.e0.p.d.m0.b.q.f) builtIns : null;
        t$a t_a = t$a.a;
        h hVar = h.a;
        List listEmptyList = d0.t.n.emptyList();
        d0.e0.p.d.m0.c.h1.a customizer = fVar2 == null ? null : fVar2.getCustomizer();
        d0.e0.p.d.m0.c.h1.a aVar = customizer == null ? d0.e0.p.d.m0.c.h1.a$a.a : customizer;
        d0.e0.p.d.m0.b.q.g customizer2 = fVar2 != null ? fVar2.getCustomizer() : null;
        this.a = new d0.e0.p.d.m0.l.b.j(oVar, c0Var, kVar, gVar, cVar, fVar, t_a, pVar, cVar2, hVar, listEmptyList, d0Var, iVar, aVar, customizer2 == null ? c$b.a : customizer2, d0.e0.p.d.m0.f.a0.b.h.a.getEXTENSION_REGISTRY(), lVar, new d0.e0.p.d.m0.k.z.b(oVar, d0.t.n.emptyList()), null, 262144, null);
    }

    public final d0.e0.p.d.m0.l.b.j getComponents() {
        return this.a;
    }
}
