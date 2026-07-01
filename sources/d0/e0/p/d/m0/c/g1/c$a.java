package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.n.t;

/* JADX INFO: compiled from: AnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public static d0.e0.p.d.m0.g.b getFqName(c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "this");
        d0.e0.p.d.m0.c.e annotationClass = d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar);
        if (annotationClass == null) {
            return null;
        }
        if (t.isError(annotationClass)) {
            annotationClass = null;
        }
        if (annotationClass == null) {
            return null;
        }
        return d0.e0.p.d.m0.k.x.a.fqNameOrNull(annotationClass);
    }
}
