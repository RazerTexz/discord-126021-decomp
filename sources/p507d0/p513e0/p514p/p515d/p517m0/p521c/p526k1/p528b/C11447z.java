package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11444w;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11567b0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.z */
/* JADX INFO: compiled from: ReflectJavaWildcardType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11447z extends AbstractC11444w implements InterfaceC11567b0 {

    /* JADX INFO: renamed from: b */
    public final WildcardType f23071b;

    /* JADX INFO: renamed from: c */
    public final Collection<InterfaceC11564a> f23072c;

    public C11447z(WildcardType wildcardType) {
        C12238m.checkNotNullParameter(wildcardType, "reflectType");
        this.f23071b = wildcardType;
        this.f23072c = C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public Collection<InterfaceC11564a> getAnnotations() {
        return this.f23072c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11567b0
    public AbstractC11444w getBound() {
        Type[] upperBounds = this.f23071b.getUpperBounds();
        Type[] lowerBounds = this.f23071b.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(C12238m.stringPlus("Wildcard types with many bounds are not yet supported: ", this.f23071b));
        }
        if (lowerBounds.length == 1) {
            AbstractC11444w.a aVar = AbstractC11444w.f23065a;
            C12238m.checkNotNullExpressionValue(lowerBounds, "lowerBounds");
            Object objSingle = C12141k.single(lowerBounds);
            C12238m.checkNotNullExpressionValue(objSingle, "lowerBounds.single()");
            return aVar.create((Type) objSingle);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        C12238m.checkNotNullExpressionValue(upperBounds, "upperBounds");
        Type type = (Type) C12141k.single(upperBounds);
        if (C12238m.areEqual(type, Object.class)) {
            return null;
        }
        AbstractC11444w.a aVar2 = AbstractC11444w.f23065a;
        C12238m.checkNotNullExpressionValue(type, "ub");
        return aVar2.create(type);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11444w
    public Type getReflectType() {
        return this.f23071b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11567b0
    public boolean isExtends() {
        Type[] upperBounds = this.f23071b.getUpperBounds();
        C12238m.checkNotNullExpressionValue(upperBounds, "reflectType.upperBounds");
        return !C12238m.areEqual(C12141k.firstOrNull(upperBounds), Object.class);
    }
}
