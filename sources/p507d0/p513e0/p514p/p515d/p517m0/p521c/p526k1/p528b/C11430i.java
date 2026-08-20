package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11573f;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.i */
/* JADX INFO: compiled from: ReflectJavaArrayType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11430i extends AbstractC11444w implements InterfaceC11573f {

    /* JADX INFO: renamed from: b */
    public final Type f23043b;

    /* JADX INFO: renamed from: c */
    public final AbstractC11444w f23044c;

    /* JADX INFO: renamed from: d */
    public final Collection<InterfaceC11564a> f23045d;

    public C11430i(Type type) {
        AbstractC11444w abstractC11444wCreate;
        C12238m.checkNotNullParameter(type, "reflectType");
        this.f23043b = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    AbstractC11444w.a aVar = AbstractC11444w.f23065a;
                    Class<?> componentType = cls.getComponentType();
                    C12238m.checkNotNullExpressionValue(componentType, "getComponentType()");
                    abstractC11444wCreate = aVar.create(componentType);
                }
            }
            StringBuilder sbM833U = C1643a.m833U("Not an array type (");
            sbM833U.append(type.getClass());
            sbM833U.append("): ");
            sbM833U.append(type);
            throw new IllegalArgumentException(sbM833U.toString());
        }
        AbstractC11444w.a aVar2 = AbstractC11444w.f23065a;
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        C12238m.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
        abstractC11444wCreate = aVar2.create(genericComponentType);
        this.f23044c = abstractC11444wCreate;
        this.f23045d = C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public Collection<InterfaceC11564a> getAnnotations() {
        return this.f23045d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11444w
    public Type getReflectType() {
        return this.f23043b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11573f
    public AbstractC11444w getComponentType() {
        return this.f23044c;
    }
}
