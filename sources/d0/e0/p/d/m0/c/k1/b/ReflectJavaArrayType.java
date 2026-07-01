package d0.e0.p.d.m0.c.k1.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaType;
import d0.e0.p.d.m0.e.a.k0.javaTypes2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.i, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaArrayType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaArrayType extends ReflectJavaType implements javaTypes2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3293b;
    public final ReflectJavaType c;
    public final Collection<d0.e0.p.d.m0.e.a.k0.a> d;

    public ReflectJavaArrayType(Type type) {
        ReflectJavaType reflectJavaTypeCreate;
        Intrinsics3.checkNotNullParameter(type, "reflectType");
        this.f3293b = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    ReflectJavaType.a aVar = ReflectJavaType.a;
                    Class<?> componentType = cls.getComponentType();
                    Intrinsics3.checkNotNullExpressionValue(componentType, "getComponentType()");
                    reflectJavaTypeCreate = aVar.create(componentType);
                }
            }
            StringBuilder sbU = outline.U("Not an array type (");
            sbU.append(type.getClass());
            sbU.append("): ");
            sbU.append(type);
            throw new IllegalArgumentException(sbU.toString());
        }
        ReflectJavaType.a aVar2 = ReflectJavaType.a;
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        Intrinsics3.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
        reflectJavaTypeCreate = aVar2.create(genericComponentType);
        this.c = reflectJavaTypeCreate;
        this.d = Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public Collection<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaType
    public Type getReflectType() {
        return this.f3293b;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes2
    public ReflectJavaType getComponentType() {
        return this.c;
    }
}
