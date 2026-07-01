package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.g.FqName;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.f, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ReflectJavaAnnotationOwner extends d0.e0.p.d.m0.e.a.k0.d {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.f$a */
    /* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
    public static final class a {
        public static ReflectJavaAnnotation findAnnotation(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, FqName fqName) {
            Annotation[] declaredAnnotations;
            Intrinsics3.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
                return null;
            }
            return ReflectJavaAnnotationOwner2.findAnnotation(declaredAnnotations, fqName);
        }

        public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
            return declaredAnnotations == null ? Collections2.emptyList() : ReflectJavaAnnotationOwner2.getAnnotations(declaredAnnotations);
        }

        public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
            return false;
        }
    }

    AnnotatedElement getElement();
}
