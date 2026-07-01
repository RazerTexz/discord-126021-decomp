package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.v0;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.b, reason: use source file name */
/* JADX INFO: compiled from: ReflectAnnotationSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectAnnotationSource implements SourceElement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Annotation f3283b;

    public ReflectAnnotationSource(Annotation annotation) {
        Intrinsics3.checkNotNullParameter(annotation, "annotation");
        this.f3283b = annotation;
    }

    public final Annotation getAnnotation() {
        return this.f3283b;
    }

    @Override // d0.e0.p.d.m0.c.SourceElement
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        Intrinsics3.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }
}
