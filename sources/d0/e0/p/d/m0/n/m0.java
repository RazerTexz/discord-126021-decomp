package d0.e0.p.d.m0.n;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 {
    public static final j0 a(c0 c0Var) {
        a0 alternative;
        u0 constructor = c0Var.getConstructor();
        a0 a0Var = constructor instanceof a0 ? (a0) constructor : null;
        if (a0Var == null) {
            return null;
        }
        Collection<c0> supertypes = a0Var.getSupertypes();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(supertypes, 10));
        boolean z2 = false;
        for (c0 c0VarMakeDefinitelyNotNullOrNotNull$default : supertypes) {
            if (e1.isNullableType(c0VarMakeDefinitelyNotNullOrNotNull$default)) {
                c0VarMakeDefinitelyNotNullOrNotNull$default = makeDefinitelyNotNullOrNotNull$default(c0VarMakeDefinitelyNotNullOrNotNull$default.unwrap(), false, 1, null);
                z2 = true;
            }
            arrayList.add(c0VarMakeDefinitelyNotNullOrNotNull$default);
        }
        if (z2) {
            c0 alternativeType = a0Var.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = null;
            } else if (e1.isNullableType(alternativeType)) {
                alternativeType = makeDefinitelyNotNullOrNotNull$default(alternativeType.unwrap(), false, 1, null);
            }
            alternative = new a0(arrayList).setAlternative(alternativeType);
        } else {
            alternative = null;
        }
        if (alternative == null) {
            return null;
        }
        return alternative.createType();
    }

    public static final a getAbbreviatedType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        i1 i1VarUnwrap = c0Var.unwrap();
        if (i1VarUnwrap instanceof a) {
            return (a) i1VarUnwrap;
        }
        return null;
    }

    public static final j0 getAbbreviation(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        a abbreviatedType = getAbbreviatedType(c0Var);
        if (abbreviatedType == null) {
            return null;
        }
        return abbreviatedType.getAbbreviation();
    }

    public static final boolean isDefinitelyNotNullType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        return c0Var.unwrap() instanceof k;
    }

    public static final i1 makeDefinitelyNotNullOrNotNull(i1 i1Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(i1Var, "<this>");
        k kVarMakeDefinitelyNotNull$descriptors = k.k.makeDefinitelyNotNull$descriptors(i1Var, z2);
        if (kVarMakeDefinitelyNotNull$descriptors != null) {
            return kVarMakeDefinitelyNotNull$descriptors;
        }
        j0 j0VarA = a(i1Var);
        return j0VarA == null ? i1Var.makeNullableAsSpecified(false) : j0VarA;
    }

    public static /* synthetic */ i1 makeDefinitelyNotNullOrNotNull$default(i1 i1Var, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return makeDefinitelyNotNullOrNotNull(i1Var, z2);
    }

    public static final j0 makeSimpleTypeDefinitelyNotNullOrNotNull(j0 j0Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(j0Var, "<this>");
        k kVarMakeDefinitelyNotNull$descriptors = k.k.makeDefinitelyNotNull$descriptors(j0Var, z2);
        if (kVarMakeDefinitelyNotNull$descriptors != null) {
            return kVarMakeDefinitelyNotNull$descriptors;
        }
        j0 j0VarA = a(j0Var);
        return j0VarA == null ? j0Var.makeNullableAsSpecified(false) : j0VarA;
    }

    public static /* synthetic */ j0 makeSimpleTypeDefinitelyNotNullOrNotNull$default(j0 j0Var, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return makeSimpleTypeDefinitelyNotNullOrNotNull(j0Var, z2);
    }

    public static final j0 withAbbreviation(j0 j0Var, j0 j0Var2) {
        d0.z.d.m.checkNotNullParameter(j0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(j0Var2, "abbreviatedType");
        return e0.isError(j0Var) ? j0Var : new a(j0Var, j0Var2);
    }

    public static final d0.e0.p.d.m0.n.l1.i withNotNullProjection(d0.e0.p.d.m0.n.l1.i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "<this>");
        return new d0.e0.p.d.m0.n.l1.i(iVar.getCaptureStatus(), iVar.getConstructor(), iVar.getLowerType(), iVar.getAnnotations(), iVar.isMarkedNullable(), true);
    }
}
