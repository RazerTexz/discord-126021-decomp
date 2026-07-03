package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11455o0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.g */
/* JADX INFO: compiled from: inlineClassesUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11789g {
    static {
        new C11713b("kotlin.jvm.JvmInline");
    }

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(InterfaceC11318a interfaceC11318a) {
        C12238m.checkNotNullParameter(interfaceC11318a, "<this>");
        if (interfaceC11318a instanceof InterfaceC11455o0) {
            InterfaceC11453n0 correspondingProperty = ((InterfaceC11455o0) interfaceC11318a).getCorrespondingProperty();
            C12238m.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
            if (isUnderlyingPropertyOfInlineClass(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClass(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        if (interfaceC11450m instanceof InterfaceC11330e) {
            InterfaceC11330e interfaceC11330e = (InterfaceC11330e) interfaceC11450m;
            if (interfaceC11330e.isInline() || interfaceC11330e.isValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        return isInlineClass(declarationDescriptor);
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(InterfaceC11329d1 interfaceC11329d1) {
        C12238m.checkNotNullParameter(interfaceC11329d1, "<this>");
        if (interfaceC11329d1.getExtensionReceiverParameter() != null) {
            return false;
        }
        InterfaceC11450m containingDeclaration = interfaceC11329d1.getContainingDeclaration();
        C12238m.checkNotNullExpressionValue(containingDeclaration, "this.containingDeclaration");
        if (!isInlineClass(containingDeclaration)) {
            return false;
        }
        InterfaceC11326c1 interfaceC11326c1UnderlyingRepresentation = underlyingRepresentation((InterfaceC11330e) containingDeclaration);
        return C12238m.areEqual(interfaceC11326c1UnderlyingRepresentation == null ? null : interfaceC11326c1UnderlyingRepresentation.getName(), interfaceC11329d1.getName());
    }

    public static final AbstractC11913c0 substitutedUnderlyingType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11326c1 interfaceC11326c1UnsubstitutedUnderlyingParameter = unsubstitutedUnderlyingParameter(abstractC11913c0);
        if (interfaceC11326c1UnsubstitutedUnderlyingParameter == null) {
            return null;
        }
        return C11914c1.create(abstractC11913c0).substitute(interfaceC11326c1UnsubstitutedUnderlyingParameter.getType(), EnumC11935j1.INVARIANT);
    }

    public static final InterfaceC11326c1 underlyingRepresentation(InterfaceC11330e interfaceC11330e) {
        InterfaceC11327d unsubstitutedPrimaryConstructor;
        List<InterfaceC11326c1> valueParameters;
        C12238m.checkNotNullParameter(interfaceC11330e, "<this>");
        if (!isInlineClass(interfaceC11330e) || (unsubstitutedPrimaryConstructor = interfaceC11330e.getUnsubstitutedPrimaryConstructor()) == null || (valueParameters = unsubstitutedPrimaryConstructor.getValueParameters()) == null) {
            return null;
        }
        return (InterfaceC11326c1) C12163u.singleOrNull((List) valueParameters);
    }

    public static final InterfaceC11326c1 unsubstitutedUnderlyingParameter(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof InterfaceC11330e)) {
            declarationDescriptor = null;
        }
        InterfaceC11330e interfaceC11330e = (InterfaceC11330e) declarationDescriptor;
        if (interfaceC11330e == null) {
            return null;
        }
        return underlyingRepresentation(interfaceC11330e);
    }
}
