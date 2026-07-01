package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.b0;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* JADX INFO: compiled from: ReflectJavaWildcardType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends w implements b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WildcardType f3297b;
    public final Collection<d0.e0.p.d.m0.e.a.k0.a> c;

    public z(WildcardType wildcardType) {
        d0.z.d.m.checkNotNullParameter(wildcardType, "reflectType");
        this.f3297b = wildcardType;
        this.c = d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public Collection<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.b0
    public w getBound() {
        Type[] upperBounds = this.f3297b.getUpperBounds();
        Type[] lowerBounds = this.f3297b.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(d0.z.d.m.stringPlus("Wildcard types with many bounds are not yet supported: ", this.f3297b));
        }
        if (lowerBounds.length == 1) {
            w$a w_a = w.a;
            d0.z.d.m.checkNotNullExpressionValue(lowerBounds, "lowerBounds");
            Object objSingle = d0.t.k.single(lowerBounds);
            d0.z.d.m.checkNotNullExpressionValue(objSingle, "lowerBounds.single()");
            return w_a.create((Type) objSingle);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        d0.z.d.m.checkNotNullExpressionValue(upperBounds, "upperBounds");
        Type type = (Type) d0.t.k.single(upperBounds);
        if (d0.z.d.m.areEqual(type, Object.class)) {
            return null;
        }
        w$a w_a2 = w.a;
        d0.z.d.m.checkNotNullExpressionValue(type, "ub");
        return w_a2.create(type);
    }

    @Override // d0.e0.p.d.m0.c.k1.b.w
    public Type getReflectType() {
        return this.f3297b;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.b0
    public boolean isExtends() {
        Type[] upperBounds = this.f3297b.getUpperBounds();
        d0.z.d.m.checkNotNullExpressionValue(upperBounds, "reflectType.upperBounds");
        return !d0.z.d.m.areEqual(d0.t.k.firstOrNull(upperBounds), Object.class);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.b0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.x getBound() {
        return getBound();
    }
}
