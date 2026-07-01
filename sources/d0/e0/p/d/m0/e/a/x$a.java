package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.e.b.k$d;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x$a {
    public x$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final d0.e0.p.d.m0.e.b.k a(d0.e0.p.d.m0.c.x xVar, c1 c1Var) {
        if (!d0.e0.p.d.m0.e.b.u.forceSingleValueParameterBoxing(xVar)) {
            boolean z2 = false;
            if (xVar.getValueParameters().size() == 1) {
                d0.e0.p.d.m0.c.m containingDeclaration = xVar.getContainingDeclaration();
                d0.e0.p.d.m0.c.e eVar = containingDeclaration instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) containingDeclaration : null;
                if (eVar != null) {
                    List<c1> valueParameters = xVar.getValueParameters();
                    d0.z.d.m.checkNotNullExpressionValue(valueParameters, "f.valueParameters");
                    d0.e0.p.d.m0.c.h declarationDescriptor = ((c1) d0.t.u.single((List) valueParameters)).getType().getConstructor().getDeclarationDescriptor();
                    d0.e0.p.d.m0.c.e eVar2 = declarationDescriptor instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) declarationDescriptor : null;
                    if (eVar2 != null) {
                        z2 = d0.e0.p.d.m0.b.h.isPrimitiveClass(eVar) && d0.z.d.m.areEqual(d0.e0.p.d.m0.k.x.a.getFqNameSafe(eVar), d0.e0.p.d.m0.k.x.a.getFqNameSafe(eVar2));
                    }
                }
            }
            if (!z2) {
                d0.e0.p.d.m0.n.c0 type = c1Var.getType();
                d0.z.d.m.checkNotNullExpressionValue(type, "valueParameterDescriptor.type");
                return d0.e0.p.d.m0.e.b.u.mapToJvmType(type);
            }
        }
        d0.e0.p.d.m0.n.c0 type2 = c1Var.getType();
        d0.z.d.m.checkNotNullExpressionValue(type2, "valueParameterDescriptor.type");
        return d0.e0.p.d.m0.e.b.u.mapToJvmType(d0.e0.p.d.m0.n.o1.a.makeNullable(type2));
    }

    public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
        d0.z.d.m.checkNotNullParameter(aVar, "superDescriptor");
        d0.z.d.m.checkNotNullParameter(aVar2, "subDescriptor");
        if ((aVar2 instanceof d0.e0.p.d.m0.e.a.h0.f) && (aVar instanceof d0.e0.p.d.m0.c.x)) {
            d0.e0.p.d.m0.e.a.h0.f fVar = (d0.e0.p.d.m0.e.a.h0.f) aVar2;
            fVar.getValueParameters().size();
            d0.e0.p.d.m0.c.x xVar = (d0.e0.p.d.m0.c.x) aVar;
            xVar.getValueParameters().size();
            List<c1> valueParameters = fVar.getOriginal().getValueParameters();
            d0.z.d.m.checkNotNullExpressionValue(valueParameters, "subDescriptor.original.valueParameters");
            List<c1> valueParameters2 = xVar.getOriginal().getValueParameters();
            d0.z.d.m.checkNotNullExpressionValue(valueParameters2, "superDescriptor.original.valueParameters");
            for (Pair pair : d0.t.u.zip(valueParameters, valueParameters2)) {
                c1 c1Var = (c1) pair.component1();
                c1 c1Var2 = (c1) pair.component2();
                d0.z.d.m.checkNotNullExpressionValue(c1Var, "subParameter");
                boolean z2 = a((d0.e0.p.d.m0.c.x) aVar2, c1Var) instanceof k$d;
                d0.z.d.m.checkNotNullExpressionValue(c1Var2, "superParameter");
                if (z2 != (a(xVar, c1Var2) instanceof k$d)) {
                    return true;
                }
            }
        }
        return false;
    }
}
