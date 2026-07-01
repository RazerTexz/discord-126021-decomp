package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.v0;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: ReflectAnnotationSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Annotation f3283b;

    public b(Annotation annotation) {
        d0.z.d.m.checkNotNullParameter(annotation, "annotation");
        this.f3283b = annotation;
    }

    public final Annotation getAnnotation() {
        return this.f3283b;
    }

    @Override // d0.e0.p.d.m0.c.u0
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        d0.z.d.m.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }
}
