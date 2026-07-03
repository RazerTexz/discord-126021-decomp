package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.g */
/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11428g {
    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    /* JADX WARN: Code duplicated, block: B:16:? A[RETURN, SYNTHETIC] */
    public static final C11424c findAnnotation(Annotation[] annotationArr, C11713b c11713b) {
        C12238m.checkNotNullParameter(annotationArr, "<this>");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        for (Annotation annotation : annotationArr) {
            if (C12238m.areEqual(C11423b.getClassId(C12209a.getJavaClass(C12209a.getAnnotationClass(annotation))).asSingleFqName(), c11713b)) {
                if (annotation == null) {
                    return null;
                }
                return new C11424c(annotation);
            }
        }
        annotation = null;
        if (annotation == null) {
            return null;
        }
        return new C11424c(annotation);
    }

    public static final List<C11424c> getAnnotations(Annotation[] annotationArr) {
        C12238m.checkNotNullParameter(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new C11424c(annotation));
        }
        return arrayList;
    }
}
