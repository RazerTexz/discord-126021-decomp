package d0.e0.p.d.m0.n;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a {
    public k$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final k makeDefinitelyNotNull$descriptors(i1 i1Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(i1Var, "type");
        if (i1Var instanceof k) {
            return (k) i1Var;
        }
        i1Var.getConstructor();
        boolean zIsNullableType = false;
        if ((i1Var.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.z0) || (i1Var instanceof d0.e0.p.d.m0.n.l1.i)) {
            zIsNullableType = (z2 && (i1Var.getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.z0)) ? e1.isNullableType(i1Var) : !d0.e0.p.d.m0.n.l1.n.a.isSubtypeOfAny(i1Var);
        }
        if (!zIsNullableType) {
            return null;
        }
        if (i1Var instanceof v) {
            v vVar = (v) i1Var;
            d0.z.d.m.areEqual(vVar.getLowerBound().getConstructor(), vVar.getUpperBound().getConstructor());
        }
        return new k(y.lowerIfFlexible(i1Var), z2, null);
    }
}
