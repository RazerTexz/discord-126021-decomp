package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.annotationArguments6;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.q, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments6 extends ReflectJavaAnnotationArguments implements annotationArguments6 {
    public final Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments6(Name name, Object obj) {
        super(name);
        Intrinsics3.checkNotNullParameter(obj, "value");
        this.c = obj;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.annotationArguments6
    public Object getValue() {
        return this.c;
    }
}
