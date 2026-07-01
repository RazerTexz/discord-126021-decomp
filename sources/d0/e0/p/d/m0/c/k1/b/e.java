package d0.e0.p.d.m0.c.k1.b;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends d implements d0.e0.p.d.m0.e.a.k0.c {
    public final Annotation c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d0.e0.p.d.m0.g.e eVar, Annotation annotation) {
        super(eVar);
        d0.z.d.m.checkNotNullParameter(annotation, "annotation");
        this.c = annotation;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.c
    public d0.e0.p.d.m0.e.a.k0.a getAnnotation() {
        return new c(this.c);
    }
}
