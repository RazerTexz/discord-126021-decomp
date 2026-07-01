package d0.e0.p.d.m0.c.k1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a {
    public static c findAnnotation(f fVar, d0.e0.p.d.m0.g.b bVar) {
        Annotation[] declaredAnnotations;
        d0.z.d.m.checkNotNullParameter(fVar, "this");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        AnnotatedElement element = fVar.getElement();
        if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
            return null;
        }
        return g.findAnnotation(declaredAnnotations, bVar);
    }

    public static List<c> getAnnotations(f fVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "this");
        AnnotatedElement element = fVar.getElement();
        Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
        return declaredAnnotations == null ? d0.t.n.emptyList() : g.getAnnotations(declaredAnnotations);
    }

    public static boolean isDeprecatedInJavaDoc(f fVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "this");
        return false;
    }
}
