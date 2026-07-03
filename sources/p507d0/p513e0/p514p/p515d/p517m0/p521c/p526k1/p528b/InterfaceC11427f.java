package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.f */
/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11427f extends InterfaceC11570d {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.f$a */
    /* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
    public static final class a {
        public static C11424c findAnnotation(InterfaceC11427f interfaceC11427f, C11713b c11713b) {
            Annotation[] declaredAnnotations;
            C12238m.checkNotNullParameter(interfaceC11427f, "this");
            C12238m.checkNotNullParameter(c11713b, "fqName");
            AnnotatedElement element = interfaceC11427f.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
                return null;
            }
            return C11428g.findAnnotation(declaredAnnotations, c11713b);
        }

        public static List<C11424c> getAnnotations(InterfaceC11427f interfaceC11427f) {
            C12238m.checkNotNullParameter(interfaceC11427f, "this");
            AnnotatedElement element = interfaceC11427f.getElement();
            Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
            return declaredAnnotations == null ? C12147n.emptyList() : C11428g.getAnnotations(declaredAnnotations);
        }

        public static boolean isDeprecatedInJavaDoc(InterfaceC11427f interfaceC11427f) {
            C12238m.checkNotNullParameter(interfaceC11427f, "this");
            return false;
        }
    }

    AnnotatedElement getElement();
}
