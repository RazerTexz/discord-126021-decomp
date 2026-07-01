package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.z0;

/* JADX INFO: compiled from: ClassifierNamePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a implements b {
    public static final b$a a = new b$a();

    @Override // d0.e0.p.d.m0.j.b
    public String renderClassifier(d0.e0.p.d.m0.c.h hVar, c cVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "classifier");
        d0.z.d.m.checkNotNullParameter(cVar, "renderer");
        if (hVar instanceof z0) {
            d0.e0.p.d.m0.g.e name = ((z0) hVar).getName();
            d0.z.d.m.checkNotNullExpressionValue(name, "classifier.name");
            return cVar.renderName(name, false);
        }
        d0.e0.p.d.m0.g.c fqName = d0.e0.p.d.m0.k.e.getFqName(hVar);
        d0.z.d.m.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
        return cVar.renderFqName(fqName);
    }
}
