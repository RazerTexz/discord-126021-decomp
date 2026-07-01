package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: compiled from: ReflectJavaArrayType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends w implements d0.e0.p.d.m0.e.a.k0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3293b;
    public final w c;
    public final Collection<d0.e0.p.d.m0.e.a.k0.a> d;

    public i(Type type) {
        w wVarCreate;
        d0.z.d.m.checkNotNullParameter(type, "reflectType");
        this.f3293b = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    w$a w_a = w.a;
                    Class<?> componentType = cls.getComponentType();
                    d0.z.d.m.checkNotNullExpressionValue(componentType, "getComponentType()");
                    wVarCreate = w_a.create(componentType);
                }
            }
            StringBuilder sbU = b.d.b.a.a.U("Not an array type (");
            sbU.append(type.getClass());
            sbU.append("): ");
            sbU.append(type);
            throw new IllegalArgumentException(sbU.toString());
        }
        w$a w_a2 = w.a;
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        d0.z.d.m.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
        wVarCreate = w_a2.create(genericComponentType);
        this.c = wVarCreate;
        this.d = d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public Collection<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.f
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.x getComponentType() {
        return getComponentType();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.w
    public Type getReflectType() {
        return this.f3293b;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.f
    public w getComponentType() {
        return this.c;
    }
}
