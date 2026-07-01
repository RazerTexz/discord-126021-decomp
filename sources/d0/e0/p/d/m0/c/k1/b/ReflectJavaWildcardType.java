package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.k1.b.ReflectJavaType;
import d0.e0.p.d.m0.e.a.k0.javaTypes;
import d0.t.Collections2;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.z, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaWildcardType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaWildcardType extends ReflectJavaType implements javaTypes {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WildcardType f3297b;
    public final Collection<d0.e0.p.d.m0.e.a.k0.a> c;

    public ReflectJavaWildcardType(WildcardType wildcardType) {
        Intrinsics3.checkNotNullParameter(wildcardType, "reflectType");
        this.f3297b = wildcardType;
        this.c = Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public Collection<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes
    public ReflectJavaType getBound() {
        Type[] upperBounds = this.f3297b.getUpperBounds();
        Type[] lowerBounds = this.f3297b.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(Intrinsics3.stringPlus("Wildcard types with many bounds are not yet supported: ", this.f3297b));
        }
        if (lowerBounds.length == 1) {
            ReflectJavaType.a aVar = ReflectJavaType.a;
            Intrinsics3.checkNotNullExpressionValue(lowerBounds, "lowerBounds");
            Object objSingle = _Arrays.single(lowerBounds);
            Intrinsics3.checkNotNullExpressionValue(objSingle, "lowerBounds.single()");
            return aVar.create((Type) objSingle);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        Intrinsics3.checkNotNullExpressionValue(upperBounds, "upperBounds");
        Type type = (Type) _Arrays.single(upperBounds);
        if (Intrinsics3.areEqual(type, Object.class)) {
            return null;
        }
        ReflectJavaType.a aVar2 = ReflectJavaType.a;
        Intrinsics3.checkNotNullExpressionValue(type, "ub");
        return aVar2.create(type);
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaType
    public Type getReflectType() {
        return this.f3297b;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.javaTypes
    public boolean isExtends() {
        Type[] upperBounds = this.f3297b.getUpperBounds();
        Intrinsics3.checkNotNullExpressionValue(upperBounds, "reflectType.upperBounds");
        return !Intrinsics3.areEqual(_Arrays.firstOrNull(upperBounds), Object.class);
    }
}
