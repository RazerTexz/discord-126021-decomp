package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.e.a.k0.javaTypes4;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.v, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaPrimitiveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaPrimitiveType extends ReflectJavaType implements javaTypes4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f3295b;
    public final Collection<d0.e0.p.d.m0.e.a.k0.a> c;

    public ReflectJavaPrimitiveType(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "reflectType");
        this.f3295b = cls;
        this.c = Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public Collection<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaType
    public Type getReflectType() {
        return this.f3295b;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes4
    public PrimitiveType getType() {
        if (Intrinsics3.areEqual(this.f3295b, Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(this.f3295b.getName()).getPrimitiveType();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }
}
