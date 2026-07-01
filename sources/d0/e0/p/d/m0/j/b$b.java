package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.z0;
import d0.t.s;
import java.util.ArrayList;

/* JADX INFO: compiled from: ClassifierNamePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b implements b {
    public static final b$b a = new b$b();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [d0.e0.p.d.m0.c.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [d0.e0.p.d.m0.c.m] */
    /* JADX WARN: Type inference failed for: r2v2, types: [d0.e0.p.d.m0.c.m] */
    @Override // d0.e0.p.d.m0.j.b
    public String renderClassifier(d0.e0.p.d.m0.c.h hVar, c cVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "classifier");
        d0.z.d.m.checkNotNullParameter(cVar, "renderer");
        if (hVar instanceof z0) {
            d0.e0.p.d.m0.g.e name = ((z0) hVar).getName();
            d0.z.d.m.checkNotNullExpressionValue(name, "classifier.name");
            return cVar.renderName(name, false);
        }
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(hVar.getName());
            hVar = hVar.getContainingDeclaration();
        } while (hVar instanceof d0.e0.p.d.m0.c.e);
        return q.renderFqName(s.asReversedMutable(arrayList));
    }
}
