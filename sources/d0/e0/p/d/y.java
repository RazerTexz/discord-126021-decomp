package d0.e0.p.d;

import d0.e0.p.d.m0.c.z0;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: KTypeParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements d0.e0.h {
    public static final /* synthetic */ KProperty[] j = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(y.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    public final c0$a k;
    public final z l;
    public final z0 m;

    public y(z zVar, z0 z0Var) {
        Class<?> klass;
        h<?> hVarA;
        Object objAccept;
        d0.z.d.m.checkNotNullParameter(z0Var, "descriptor");
        this.m = z0Var;
        this.k = c0.lazySoft(new y$a(this));
        if (zVar == null) {
            d0.e0.p.d.m0.c.m containingDeclaration = getDescriptor().getContainingDeclaration();
            d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof d0.e0.p.d.m0.c.e) {
                objAccept = a((d0.e0.p.d.m0.c.e) containingDeclaration);
            } else {
                if (!(containingDeclaration instanceof d0.e0.p.d.m0.c.b)) {
                    throw new a0("Unknown type parameter container: " + containingDeclaration);
                }
                d0.e0.p.d.m0.c.m containingDeclaration2 = ((d0.e0.p.d.m0.c.b) containingDeclaration).getContainingDeclaration();
                d0.z.d.m.checkNotNullExpressionValue(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof d0.e0.p.d.m0.c.e) {
                    hVarA = a((d0.e0.p.d.m0.c.e) containingDeclaration2);
                } else {
                    d0.e0.p.d.m0.l.b.e0.g gVar = (d0.e0.p.d.m0.l.b.e0.g) (!(containingDeclaration instanceof d0.e0.p.d.m0.l.b.e0.g) ? null : containingDeclaration);
                    if (gVar == null) {
                        throw new a0("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                    d0.e0.p.d.m0.l.b.e0.f containerSource = gVar.getContainerSource();
                    d0.e0.p.d.m0.e.b.j jVar = (d0.e0.p.d.m0.e.b.j) (containerSource instanceof d0.e0.p.d.m0.e.b.j ? containerSource : null);
                    d0.e0.p.d.m0.e.b.p knownJvmBinaryClass = jVar != null ? jVar.getKnownJvmBinaryClass() : null;
                    d0.e0.p.d.m0.c.k1.a.f fVar = (d0.e0.p.d.m0.c.k1.a.f) (knownJvmBinaryClass instanceof d0.e0.p.d.m0.c.k1.a.f ? knownJvmBinaryClass : null);
                    if (fVar == null || (klass = fVar.getKlass()) == null) {
                        throw new a0("Container of deserialized member is not resolved: " + gVar);
                    }
                    d0.e0.c kotlinClass = d0.z.a.getKotlinClass(klass);
                    Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    hVarA = (h) kotlinClass;
                }
                objAccept = containingDeclaration.accept(new a(hVarA), Unit.a);
            }
            d0.z.d.m.checkNotNullExpressionValue(objAccept, "when (val declaration = … $declaration\")\n        }");
            zVar = (z) objAccept;
        }
        this.l = zVar;
    }

    public final h<?> a(d0.e0.p.d.m0.c.e eVar) {
        Class<?> javaClass = j0.toJavaClass(eVar);
        h<?> hVar = (h) (javaClass != null ? d0.z.a.getKotlinClass(javaClass) : null);
        if (hVar != null) {
            return hVar;
        }
        StringBuilder sbU = b.d.b.a.a.U("Type parameter container is not resolved: ");
        sbU.append(eVar.getContainingDeclaration());
        throw new a0(sbU.toString());
    }

    public boolean equals(Object obj) {
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (d0.z.d.m.areEqual(this.l, yVar.l) && d0.z.d.m.areEqual(getName(), yVar.getName())) {
                return true;
            }
        }
        return false;
    }

    public z0 getDescriptor() {
        return this.m;
    }

    @Override // d0.e0.h
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        return strAsString;
    }

    @Override // d0.e0.h
    public List<KType> getUpperBounds() {
        return (List) this.k.getValue(this, j[0]);
    }

    @Override // d0.e0.h
    public d0.e0.j getVariance() {
        int iOrdinal = getDescriptor().getVariance().ordinal();
        if (iOrdinal == 0) {
            return d0.e0.j.INVARIANT;
        }
        if (iOrdinal == 1) {
            return d0.e0.j.IN;
        }
        if (iOrdinal == 2) {
            return d0.e0.j.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return getName().hashCode() + (this.l.hashCode() * 31);
    }

    public String toString() {
        return d0.z.d.f0.j.toString(this);
    }
}
