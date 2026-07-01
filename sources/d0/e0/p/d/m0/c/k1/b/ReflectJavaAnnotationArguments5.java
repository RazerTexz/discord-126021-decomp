package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.annotationArguments5;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.o, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments5 extends ReflectJavaAnnotationArguments implements annotationArguments5 {
    public final Enum<?> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments5(Name name, Enum<?> r3) {
        super(name);
        Intrinsics3.checkNotNullParameter(r3, "value");
        this.c = r3;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.annotationArguments5
    public Name getEntryName() {
        return Name.identifier(this.c.name());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.annotationArguments5
    public ClassId getEnumClassId() {
        Class<?> enclosingClass = this.c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        Intrinsics3.checkNotNullExpressionValue(enclosingClass, "enumClass");
        return reflectClassUtil.getClassId(enclosingClass);
    }
}
