package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.annotationArguments2;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.e, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments2 extends ReflectJavaAnnotationArguments implements annotationArguments2 {
    public final Annotation c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments2(Name name, Annotation annotation) {
        super(name);
        Intrinsics3.checkNotNullParameter(annotation, "annotation");
        this.c = annotation;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.annotationArguments2
    public d0.e0.p.d.m0.e.a.k0.a getAnnotation() {
        return new ReflectJavaAnnotation(this.c);
    }
}
