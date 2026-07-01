package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.annotationArguments4;
import d0.e0.p.d.m0.e.a.k0.javaTypes5;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.k, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments4 extends ReflectJavaAnnotationArguments implements annotationArguments4 {
    public final Class<?> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments4(Name name, Class<?> cls) {
        super(name);
        Intrinsics3.checkNotNullParameter(cls, "klass");
        this.c = cls;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.annotationArguments4
    public javaTypes5 getReferencedType() {
        return ReflectJavaType.a.create(this.c);
    }
}
