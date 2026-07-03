package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.C11515f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11513d;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.AbstractC11650k;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11660u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.x */
/* JADX INFO: compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11630x implements InterfaceC11788f {

    /* JADX INFO: renamed from: a */
    public static final a f23529a = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.x$a */
    /* JADX INFO: compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final AbstractC11650k m9527a(InterfaceC11472x interfaceC11472x, InterfaceC11326c1 interfaceC11326c1) {
            if (!C11660u.forceSingleValueParameterBoxing(interfaceC11472x)) {
                boolean z2 = false;
                if (interfaceC11472x.getValueParameters().size() == 1) {
                    InterfaceC11450m containingDeclaration = interfaceC11472x.getContainingDeclaration();
                    InterfaceC11330e interfaceC11330e = containingDeclaration instanceof InterfaceC11330e ? (InterfaceC11330e) containingDeclaration : null;
                    if (interfaceC11330e != null) {
                        List<InterfaceC11326c1> valueParameters = interfaceC11472x.getValueParameters();
                        C12238m.checkNotNullExpressionValue(valueParameters, "f.valueParameters");
                        InterfaceC11352h declarationDescriptor = ((InterfaceC11326c1) C12163u.single((List) valueParameters)).getType().getConstructor().getDeclarationDescriptor();
                        InterfaceC11330e interfaceC11330e2 = declarationDescriptor instanceof InterfaceC11330e ? (InterfaceC11330e) declarationDescriptor : null;
                        if (interfaceC11330e2 != null) {
                            z2 = AbstractC11288h.isPrimitiveClass(interfaceC11330e) && C12238m.areEqual(C11836a.getFqNameSafe(interfaceC11330e), C11836a.getFqNameSafe(interfaceC11330e2));
                        }
                    }
                }
                if (!z2) {
                    AbstractC11913c0 type = interfaceC11326c1.getType();
                    C12238m.checkNotNullExpressionValue(type, "valueParameterDescriptor.type");
                    return C11660u.mapToJvmType(type);
                }
            }
            AbstractC11913c0 type2 = interfaceC11326c1.getType();
            C12238m.checkNotNullExpressionValue(type2, "valueParameterDescriptor.type");
            return C11660u.mapToJvmType(C11992a.makeNullable(type2));
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2) {
            C12238m.checkNotNullParameter(interfaceC11318a, "superDescriptor");
            C12238m.checkNotNullParameter(interfaceC11318a2, "subDescriptor");
            if ((interfaceC11318a2 instanceof C11515f) && (interfaceC11318a instanceof InterfaceC11472x)) {
                C11515f c11515f = (C11515f) interfaceC11318a2;
                c11515f.getValueParameters().size();
                InterfaceC11472x interfaceC11472x = (InterfaceC11472x) interfaceC11318a;
                interfaceC11472x.getValueParameters().size();
                List<InterfaceC11326c1> valueParameters = c11515f.getOriginal().getValueParameters();
                C12238m.checkNotNullExpressionValue(valueParameters, "subDescriptor.original.valueParameters");
                List<InterfaceC11326c1> valueParameters2 = interfaceC11472x.getOriginal().getValueParameters();
                C12238m.checkNotNullExpressionValue(valueParameters2, "superDescriptor.original.valueParameters");
                for (Pair pair : C12163u.zip(valueParameters, valueParameters2)) {
                    InterfaceC11326c1 interfaceC11326c1 = (InterfaceC11326c1) pair.component1();
                    InterfaceC11326c1 interfaceC11326c2 = (InterfaceC11326c1) pair.component2();
                    C12238m.checkNotNullExpressionValue(interfaceC11326c1, "subParameter");
                    boolean z2 = m9527a((InterfaceC11472x) interfaceC11318a2, interfaceC11326c1) instanceof AbstractC11650k.d;
                    C12238m.checkNotNullExpressionValue(interfaceC11326c2, "superParameter");
                    if (z2 != (m9527a(interfaceC11472x, interfaceC11326c2) instanceof AbstractC11650k.d)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f
    public InterfaceC11788f.a getContract() {
        return InterfaceC11788f.a.CONFLICTS_ONLY;
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
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f
    public InterfaceC11788f.b isOverridable(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, InterfaceC11330e interfaceC11330e) {
        InterfaceC11321b overriddenSpecialBuiltin;
        Boolean boolValueOf;
        boolean z2;
        InterfaceC11472x interfaceC11472x;
        Boolean boolValueOf2;
        InterfaceC11788f.b bVar = InterfaceC11788f.b.INCOMPATIBLE;
        C12238m.checkNotNullParameter(interfaceC11318a, "superDescriptor");
        C12238m.checkNotNullParameter(interfaceC11318a2, "subDescriptor");
        boolean z3 = false;
        if ((interfaceC11318a instanceof InterfaceC11321b) && (interfaceC11318a2 instanceof InterfaceC11472x) && !AbstractC11288h.isBuiltIn(interfaceC11318a2)) {
            C11509h c11509h = C11509h.f23259m;
            InterfaceC11472x interfaceC11472x2 = (InterfaceC11472x) interfaceC11318a2;
            C11716e name = interfaceC11472x2.getName();
            C12238m.checkNotNullExpressionValue(name, "subDescriptor.name");
            if (c11509h.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
                overriddenSpecialBuiltin = C11492d0.getOverriddenSpecialBuiltin((InterfaceC11321b) interfaceC11318a);
                boolValueOf = Boolean.valueOf(interfaceC11472x2.isHiddenToOvercomeSignatureClash());
                z2 = interfaceC11318a instanceof InterfaceC11472x;
                if (z2) {
                    interfaceC11472x = (InterfaceC11472x) interfaceC11318a;
                } else {
                    interfaceC11472x = null;
                }
                if (interfaceC11472x == null) {
                    boolValueOf2 = null;
                } else {
                    boolValueOf2 = Boolean.valueOf(interfaceC11472x.isHiddenToOvercomeSignatureClash());
                }
                if (!(!C12238m.areEqual(boolValueOf, boolValueOf2))) {
                    if (interfaceC11330e instanceof InterfaceC11513d) {
                        if (overriddenSpecialBuiltin instanceof InterfaceC11472x) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                    }
                } else if (interfaceC11330e instanceof InterfaceC11513d) {
                    if (overriddenSpecialBuiltin instanceof InterfaceC11472x) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                }
            } else {
                C11497g c11497g = C11497g.f23218m;
                C11716e name2 = interfaceC11472x2.getName();
                C12238m.checkNotNullExpressionValue(name2, "subDescriptor.name");
                if (c11497g.getSameAsRenamedInJvmBuiltin(name2)) {
                    overriddenSpecialBuiltin = C11492d0.getOverriddenSpecialBuiltin((InterfaceC11321b) interfaceC11318a);
                    boolValueOf = Boolean.valueOf(interfaceC11472x2.isHiddenToOvercomeSignatureClash());
                    z2 = interfaceC11318a instanceof InterfaceC11472x;
                    if (z2) {
                        interfaceC11472x = (InterfaceC11472x) interfaceC11318a;
                    } else {
                        interfaceC11472x = null;
                    }
                    if (interfaceC11472x == null) {
                        boolValueOf2 = null;
                    } else {
                        boolValueOf2 = Boolean.valueOf(interfaceC11472x.isHiddenToOvercomeSignatureClash());
                    }
                    if (!(!C12238m.areEqual(boolValueOf, boolValueOf2)) && (overriddenSpecialBuiltin == null || !interfaceC11472x2.isHiddenToOvercomeSignatureClash())) {
                        z3 = true;
                    } else if ((interfaceC11330e instanceof InterfaceC11513d) && interfaceC11472x2.getInitialSignatureDescriptor() == null && overriddenSpecialBuiltin != null && !C11492d0.hasRealKotlinSuperClassWithOverrideOf(interfaceC11330e, overriddenSpecialBuiltin)) {
                        if ((overriddenSpecialBuiltin instanceof InterfaceC11472x) || !z2 || C11509h.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((InterfaceC11472x) overriddenSpecialBuiltin) == null) {
                            z3 = true;
                        } else {
                            String strComputeJvmDescriptor$default = C11660u.computeJvmDescriptor$default(interfaceC11472x2, false, false, 2, null);
                            InterfaceC11472x original = ((InterfaceC11472x) interfaceC11318a).getOriginal();
                            C12238m.checkNotNullExpressionValue(original, "superDescriptor.original");
                            if (!C12238m.areEqual(strComputeJvmDescriptor$default, C11660u.computeJvmDescriptor$default(original, false, false, 2, null))) {
                                z3 = true;
                            }
                        }
                    }
                }
            }
        }
        return (z3 || f23529a.doesJavaOverrideHaveIncompatibleValueParameterKinds(interfaceC11318a, interfaceC11318a2)) ? bVar : InterfaceC11788f.b.UNKNOWN;
    }
}
