package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j1;
import d0.t.u;
import java.util.List;

/* JADX INFO: compiled from: inlineClassesUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    static {
        new d0.e0.p.d.m0.g.b("kotlin.jvm.JvmInline");
    }

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(d0.e0.p.d.m0.c.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "<this>");
        if (aVar instanceof o0) {
            n0 correspondingProperty = ((o0) aVar).getCorrespondingProperty();
            d0.z.d.m.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
            if (isUnderlyingPropertyOfInlineClass(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClass(d0.e0.p.d.m0.c.m mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "<this>");
        if (mVar instanceof d0.e0.p.d.m0.c.e) {
            d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) mVar;
            if (eVar.isInline() || eVar.isValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        return isInlineClass(declarationDescriptor);
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(d1 d1Var) {
        d0.z.d.m.checkNotNullParameter(d1Var, "<this>");
        if (d1Var.getExtensionReceiverParameter() != null) {
            return false;
        }
        d0.e0.p.d.m0.c.m containingDeclaration = d1Var.getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "this.containingDeclaration");
        if (!isInlineClass(containingDeclaration)) {
            return false;
        }
        c1 c1VarUnderlyingRepresentation = underlyingRepresentation((d0.e0.p.d.m0.c.e) containingDeclaration);
        return d0.z.d.m.areEqual(c1VarUnderlyingRepresentation == null ? null : c1VarUnderlyingRepresentation.getName(), d1Var.getName());
    }

    public static final c0 substitutedUnderlyingType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        c1 c1VarUnsubstitutedUnderlyingParameter = unsubstitutedUnderlyingParameter(c0Var);
        if (c1VarUnsubstitutedUnderlyingParameter == null) {
            return null;
        }
        return d0.e0.p.d.m0.n.c1.create(c0Var).substitute(c1VarUnsubstitutedUnderlyingParameter.getType(), j1.INVARIANT);
    }

    public static final c1 underlyingRepresentation(d0.e0.p.d.m0.c.e eVar) {
        d0.e0.p.d.m0.c.d unsubstitutedPrimaryConstructor;
        List<c1> valueParameters;
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        if (!isInlineClass(eVar) || (unsubstitutedPrimaryConstructor = eVar.getUnsubstitutedPrimaryConstructor()) == null || (valueParameters = unsubstitutedPrimaryConstructor.getValueParameters()) == null) {
            return null;
        }
        return (c1) u.singleOrNull((List) valueParameters);
    }

    public static final c1 unsubstitutedUnderlyingParameter(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof d0.e0.p.d.m0.c.e)) {
            declarationDescriptor = null;
        }
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) declarationDescriptor;
        if (eVar == null) {
            return null;
        }
        return underlyingRepresentation(eVar);
    }
}
