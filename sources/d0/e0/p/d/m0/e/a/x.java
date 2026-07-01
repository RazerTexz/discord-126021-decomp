package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.k.f$a;
import d0.e0.p.d.m0.k.f$b;

/* JADX INFO: compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements d0.e0.p.d.m0.k.f {
    public static final x$a a = new x$a(null);

    @Override // d0.e0.p.d.m0.k.f
    public f$a getContract() {
        return f$a.CONFLICTS_ONLY;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0042  */
    /* JADX WARN: Code duplicated, block: B:16:0x0056  */
    /* JADX WARN: Code duplicated, block: B:17:0x005a  */
    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:20:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0077  */
    /* JADX WARN: Code duplicated, block: B:27:0x0079  */
    /* JADX WARN: Code duplicated, block: B:29:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0091 A[ADDED_TO_REGION] */
    @Override // d0.e0.p.d.m0.k.f
    public f$b isOverridable(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, d0.e0.p.d.m0.c.e eVar) {
        d0.e0.p.d.m0.c.b overriddenSpecialBuiltin;
        Boolean boolValueOf;
        boolean z2;
        d0.e0.p.d.m0.c.x xVar;
        Boolean boolValueOf2;
        f$b f_b = f$b.INCOMPATIBLE;
        d0.z.d.m.checkNotNullParameter(aVar, "superDescriptor");
        d0.z.d.m.checkNotNullParameter(aVar2, "subDescriptor");
        boolean z3 = false;
        if ((aVar instanceof d0.e0.p.d.m0.c.b) && (aVar2 instanceof d0.e0.p.d.m0.c.x) && !d0.e0.p.d.m0.b.h.isBuiltIn(aVar2)) {
            h hVar = h.m;
            d0.e0.p.d.m0.c.x xVar2 = (d0.e0.p.d.m0.c.x) aVar2;
            d0.e0.p.d.m0.g.e name = xVar2.getName();
            d0.z.d.m.checkNotNullExpressionValue(name, "subDescriptor.name");
            if (hVar.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
                overriddenSpecialBuiltin = d0.getOverriddenSpecialBuiltin((d0.e0.p.d.m0.c.b) aVar);
                boolValueOf = Boolean.valueOf(xVar2.isHiddenToOvercomeSignatureClash());
                z2 = aVar instanceof d0.e0.p.d.m0.c.x;
                if (z2) {
                    xVar = (d0.e0.p.d.m0.c.x) aVar;
                } else {
                    xVar = null;
                }
                if (xVar == null) {
                    boolValueOf2 = null;
                } else {
                    boolValueOf2 = Boolean.valueOf(xVar.isHiddenToOvercomeSignatureClash());
                }
                if (!(!d0.z.d.m.areEqual(boolValueOf, boolValueOf2))) {
                    if (eVar instanceof d0.e0.p.d.m0.e.a.h0.d) {
                        if (overriddenSpecialBuiltin instanceof d0.e0.p.d.m0.c.x) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                    }
                } else if (eVar instanceof d0.e0.p.d.m0.e.a.h0.d) {
                    if (overriddenSpecialBuiltin instanceof d0.e0.p.d.m0.c.x) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                }
            } else {
                g gVar = g.m;
                d0.e0.p.d.m0.g.e name2 = xVar2.getName();
                d0.z.d.m.checkNotNullExpressionValue(name2, "subDescriptor.name");
                if (gVar.getSameAsRenamedInJvmBuiltin(name2)) {
                    overriddenSpecialBuiltin = d0.getOverriddenSpecialBuiltin((d0.e0.p.d.m0.c.b) aVar);
                    boolValueOf = Boolean.valueOf(xVar2.isHiddenToOvercomeSignatureClash());
                    z2 = aVar instanceof d0.e0.p.d.m0.c.x;
                    if (z2) {
                        xVar = (d0.e0.p.d.m0.c.x) aVar;
                    } else {
                        xVar = null;
                    }
                    if (xVar == null) {
                        boolValueOf2 = null;
                    } else {
                        boolValueOf2 = Boolean.valueOf(xVar.isHiddenToOvercomeSignatureClash());
                    }
                    if (!(!d0.z.d.m.areEqual(boolValueOf, boolValueOf2)) && (overriddenSpecialBuiltin == null || !xVar2.isHiddenToOvercomeSignatureClash())) {
                        z3 = true;
                    } else if ((eVar instanceof d0.e0.p.d.m0.e.a.h0.d) && xVar2.getInitialSignatureDescriptor() == null && overriddenSpecialBuiltin != null && !d0.hasRealKotlinSuperClassWithOverrideOf(eVar, overriddenSpecialBuiltin)) {
                        if ((overriddenSpecialBuiltin instanceof d0.e0.p.d.m0.c.x) || !z2 || h.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((d0.e0.p.d.m0.c.x) overriddenSpecialBuiltin) == null) {
                            z3 = true;
                        } else {
                            String strComputeJvmDescriptor$default = d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(xVar2, false, false, 2, null);
                            d0.e0.p.d.m0.c.x original = ((d0.e0.p.d.m0.c.x) aVar).getOriginal();
                            d0.z.d.m.checkNotNullExpressionValue(original, "superDescriptor.original");
                            if (!d0.z.d.m.areEqual(strComputeJvmDescriptor$default, d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(original, false, false, 2, null))) {
                                z3 = true;
                            }
                        }
                    }
                }
            }
        }
        return (z3 || a.doesJavaOverrideHaveIncompatibleValueParameterKinds(aVar, aVar2)) ? f_b : f$b.UNKNOWN;
    }
}
