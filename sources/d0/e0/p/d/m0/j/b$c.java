package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.z0;

/* JADX INFO: compiled from: ClassifierNamePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$c implements b {
    public static final b$c a = new b$c();

    public final String a(d0.e0.p.d.m0.c.h hVar) {
        String strRender;
        d0.e0.p.d.m0.g.e name = hVar.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "descriptor.name");
        String strRender2 = q.render(name);
        if (hVar instanceof z0) {
            return strRender2;
        }
        d0.e0.p.d.m0.c.m containingDeclaration = hVar.getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
        if (containingDeclaration instanceof d0.e0.p.d.m0.c.e) {
            strRender = a((d0.e0.p.d.m0.c.h) containingDeclaration);
        } else if (containingDeclaration instanceof e0) {
            d0.e0.p.d.m0.g.c unsafe = ((e0) containingDeclaration).getFqName().toUnsafe();
            d0.z.d.m.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
            strRender = q.render(unsafe);
        } else {
            strRender = null;
        }
        if (strRender == null || d0.z.d.m.areEqual(strRender, "")) {
            return strRender2;
        }
        return ((Object) strRender) + '.' + strRender2;
    }

    @Override // d0.e0.p.d.m0.j.b
    public String renderClassifier(d0.e0.p.d.m0.c.h hVar, c cVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "classifier");
        d0.z.d.m.checkNotNullParameter(cVar, "renderer");
        return a(hVar);
    }
}
