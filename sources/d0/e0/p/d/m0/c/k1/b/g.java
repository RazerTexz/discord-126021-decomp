package d0.e0.p.d.m0.c.k1.b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    /* JADX WARN: Code duplicated, block: B:16:? A[RETURN, SYNTHETIC] */
    public static final c findAnnotation(Annotation[] annotationArr, d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(annotationArr, "<this>");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        for (Annotation annotation : annotationArr) {
            if (d0.z.d.m.areEqual(b.getClassId(d0.z.a.getJavaClass(d0.z.a.getAnnotationClass(annotation))).asSingleFqName(), bVar)) {
                if (annotation == null) {
                    return null;
                }
                return new c(annotation);
            }
        }
        annotation = null;
        if (annotation == null) {
            return null;
        }
        return new c(annotation);
    }

    public static final List<c> getAnnotations(Annotation[] annotationArr) {
        d0.z.d.m.checkNotNullParameter(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new c(annotation));
        }
        return arrayList;
    }
}
