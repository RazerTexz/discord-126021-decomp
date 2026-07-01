package d0.e0.p.d.m0.j;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.b.k$a;
import d0.e0.p.d.m0.c.a1;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d0$b;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.j0;
import d0.e0.p.d.m0.c.l0;
import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.v;
import d0.e0.p.d.m0.c.v0$a;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.y;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.v.r;
import d0.e0.p.d.m0.k.v.r$b;
import d0.e0.p.d.m0.k.v.r$b$a;
import d0.e0.p.d.m0.k.v.r$b$b;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.h1;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.k1;
import d0.e0.p.d.m0.n.s;
import d0.e0.p.d.m0.n.t$f;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.g0.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends c implements h {
    public final i d;
    public final Lazy e;

    public d(i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "options");
        this.d = iVar;
        iVar.isLocked();
        this.e = d0.g.lazy(new d$c(this));
    }

    public static final void access$renderAccessorModifiers(d dVar, m0 m0Var, StringBuilder sb) {
        dVar.p(m0Var, sb);
    }

    public static final void access$renderClass(d dVar, d0.e0.p.d.m0.c.e eVar, StringBuilder sb) {
        d0.e0.p.d.m0.c.d unsubstitutedPrimaryConstructor;
        Objects.requireNonNull(dVar);
        boolean z2 = eVar.getKind() == d0.e0.p.d.m0.c.f.ENUM_ENTRY;
        if (!dVar.getStartFromName()) {
            dVar.h(sb, eVar, null);
            if (!z2) {
                u visibility = eVar.getVisibility();
                d0.z.d.m.checkNotNullExpressionValue(visibility, "klass.visibility");
                dVar.I(visibility, sb);
            }
            if ((eVar.getKind() != d0.e0.p.d.m0.c.f.INTERFACE || eVar.getModality() != z.ABSTRACT) && (!eVar.getKind().isSingleton() || eVar.getModality() != z.FINAL)) {
                z modality = eVar.getModality();
                d0.z.d.m.checkNotNullExpressionValue(modality, "klass.modality");
                dVar.q(modality, sb, dVar.e(eVar));
            }
            dVar.p(eVar, sb);
            dVar.s(sb, dVar.getModifiers().contains(g.INNER) && eVar.isInner(), "inner");
            dVar.s(sb, dVar.getModifiers().contains(g.DATA) && eVar.isData(), "data");
            dVar.s(sb, dVar.getModifiers().contains(g.INLINE) && eVar.isInline(), "inline");
            dVar.s(sb, dVar.getModifiers().contains(g.VALUE) && eVar.isValue(), "value");
            dVar.s(sb, dVar.getModifiers().contains(g.FUN) && eVar.isFun(), "fun");
            sb.append(dVar.n(c.a.getClassifierKindPrefix(eVar)));
        }
        if (d0.e0.p.d.m0.k.e.isCompanionObject(eVar)) {
            if (dVar.getRenderCompanionObjectName()) {
                if (dVar.getStartFromName()) {
                    sb.append("companion object");
                }
                dVar.B(sb);
                d0.e0.p.d.m0.c.m containingDeclaration = eVar.getContainingDeclaration();
                if (containingDeclaration != null) {
                    sb.append("of ");
                    d0.e0.p.d.m0.g.e name = containingDeclaration.getName();
                    d0.z.d.m.checkNotNullExpressionValue(name, "containingDeclaration.name");
                    sb.append(dVar.renderName(name, false));
                }
            }
            if (dVar.getVerbose() || !d0.z.d.m.areEqual(eVar.getName(), d0.e0.p.d.m0.g.g.f3425b)) {
                if (!dVar.getStartFromName()) {
                    dVar.B(sb);
                }
                d0.e0.p.d.m0.g.e name2 = eVar.getName();
                d0.z.d.m.checkNotNullExpressionValue(name2, "descriptor.name");
                sb.append(dVar.renderName(name2, true));
            }
        } else {
            if (!dVar.getStartFromName()) {
                dVar.B(sb);
            }
            dVar.t(eVar, sb, true);
        }
        if (z2) {
            return;
        }
        List<z0> declaredTypeParameters = eVar.getDeclaredTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
        dVar.E(declaredTypeParameters, sb, false);
        dVar.j(eVar, sb);
        if (!eVar.getKind().isSingleton() && dVar.getClassWithPrimaryConstructor() && (unsubstitutedPrimaryConstructor = eVar.getUnsubstitutedPrimaryConstructor()) != null) {
            sb.append(" ");
            dVar.h(sb, unsubstitutedPrimaryConstructor, null);
            u visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
            d0.z.d.m.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
            dVar.I(visibility2, sb);
            sb.append(dVar.n("constructor"));
            List<c1> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
            d0.z.d.m.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
            dVar.H(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
        }
        if (!dVar.getWithoutSuperTypes() && !d0.e0.p.d.m0.b.h.isNothing(eVar.getDefaultType())) {
            Collection<c0> supertypes = eVar.getTypeConstructor().getSupertypes();
            d0.z.d.m.checkNotNullExpressionValue(supertypes, "klass.typeConstructor.supertypes");
            if (!supertypes.isEmpty() && (supertypes.size() != 1 || !d0.e0.p.d.m0.b.h.isAnyOrNullableAny(supertypes.iterator().next()))) {
                dVar.B(sb);
                sb.append(": ");
                d0.t.u.joinTo$default(supertypes, sb, ", ", null, null, 0, null, new f(dVar), 60, null);
            }
        }
        dVar.J(declaredTypeParameters, sb);
    }

    public static final /* synthetic */ String access$renderConstant(d dVar, d0.e0.p.d.m0.k.v.g gVar) {
        return dVar.k(gVar);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0031  */
    public static final void access$renderConstructor(d dVar, d0.e0.p.d.m0.c.l lVar, StringBuilder sb) {
        boolean z2;
        d0.e0.p.d.m0.c.d unsubstitutedPrimaryConstructor;
        dVar.h(sb, lVar, null);
        if (dVar.d.getRenderDefaultVisibility() || lVar.getConstructedClass().getModality() != z.SEALED) {
            u visibility = lVar.getVisibility();
            d0.z.d.m.checkNotNullExpressionValue(visibility, "constructor.visibility");
            if (dVar.I(visibility, sb)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        dVar.o(lVar, sb);
        boolean z3 = dVar.getRenderConstructorKeyword() || !lVar.isPrimary() || z2;
        if (z3) {
            sb.append(dVar.n("constructor"));
        }
        d0.e0.p.d.m0.c.i containingDeclaration = lVar.getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "constructor.containingDeclaration");
        if (dVar.getSecondaryConstructorsAsPrimary()) {
            if (z3) {
                sb.append(" ");
            }
            dVar.t(containingDeclaration, sb, true);
            List<z0> typeParameters = lVar.getTypeParameters();
            d0.z.d.m.checkNotNullExpressionValue(typeParameters, "constructor.typeParameters");
            dVar.E(typeParameters, sb, false);
        }
        List<c1> valueParameters = lVar.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
        dVar.H(valueParameters, lVar.hasSynthesizedParameterNames(), sb);
        if (dVar.getRenderConstructorDelegation() && !lVar.isPrimary() && (containingDeclaration instanceof d0.e0.p.d.m0.c.e) && (unsubstitutedPrimaryConstructor = ((d0.e0.p.d.m0.c.e) containingDeclaration).getUnsubstitutedPrimaryConstructor()) != null) {
            List<c1> valueParameters2 = unsubstitutedPrimaryConstructor.getValueParameters();
            ArrayList arrayListA0 = b.d.b.a.a.a0(valueParameters2, "primaryConstructor.valueParameters");
            for (Object obj : valueParameters2) {
                c1 c1Var = (c1) obj;
                if (!c1Var.declaresDefaultValue() && c1Var.getVarargElementType() == null) {
                    arrayListA0.add(obj);
                }
            }
            if (!arrayListA0.isEmpty()) {
                sb.append(" : ");
                sb.append(dVar.n("this"));
                sb.append(d0.t.u.joinToString$default(arrayListA0, ", ", "(", ")", 0, null, e.j, 24, null));
            }
        }
        if (dVar.getSecondaryConstructorsAsPrimary()) {
            List<z0> typeParameters2 = lVar.getTypeParameters();
            d0.z.d.m.checkNotNullExpressionValue(typeParameters2, "constructor.typeParameters");
            dVar.J(typeParameters2, sb);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    public static final void access$renderFunction(d dVar, x xVar, StringBuilder sb) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (!dVar.getStartFromName()) {
            if (!dVar.getStartFromDeclarationKeyword()) {
                dVar.h(sb, xVar, null);
                u visibility = xVar.getVisibility();
                d0.z.d.m.checkNotNullExpressionValue(visibility, "function.visibility");
                dVar.I(visibility, sb);
                dVar.r(xVar, sb);
                if (dVar.getIncludeAdditionalModifiers()) {
                    dVar.p(xVar, sb);
                }
                dVar.w(xVar, sb);
                if (dVar.getIncludeAdditionalModifiers()) {
                    boolean z5 = false;
                    if (xVar.isOperator()) {
                        Collection<? extends x> overriddenDescriptors = xVar.getOverriddenDescriptors();
                        d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "functionDescriptor.overriddenDescriptors");
                        if (!overriddenDescriptors.isEmpty()) {
                            Iterator<T> it = overriddenDescriptors.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z4 = true;
                                    break;
                                } else if (((x) it.next()).isOperator()) {
                                    z4 = false;
                                    break;
                                }
                            }
                        } else {
                            z4 = true;
                            break;
                        }
                        if (z4 || dVar.getAlwaysRenderModifiers()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (xVar.isInfix()) {
                        Collection<? extends x> overriddenDescriptors2 = xVar.getOverriddenDescriptors();
                        d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors2, "functionDescriptor.overriddenDescriptors");
                        if (!overriddenDescriptors2.isEmpty()) {
                            Iterator<T> it2 = overriddenDescriptors2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z3 = true;
                                    break;
                                } else if (((x) it2.next()).isInfix()) {
                                    z3 = false;
                                    break;
                                }
                            }
                        } else {
                            z3 = true;
                            break;
                        }
                        if (z3 || dVar.getAlwaysRenderModifiers()) {
                            z5 = true;
                        }
                    }
                    dVar.s(sb, xVar.isTailrec(), "tailrec");
                    dVar.s(sb, xVar.isSuspend(), "suspend");
                    dVar.s(sb, xVar.isInline(), "inline");
                    dVar.s(sb, z5, "infix");
                    dVar.s(sb, z2, "operator");
                } else {
                    dVar.s(sb, xVar.isSuspend(), "suspend");
                }
                dVar.o(xVar, sb);
                if (dVar.getVerbose()) {
                    if (xVar.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (xVar.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(dVar.n("fun"));
            sb.append(" ");
            List<z0> typeParameters = xVar.getTypeParameters();
            d0.z.d.m.checkNotNullExpressionValue(typeParameters, "function.typeParameters");
            dVar.E(typeParameters, sb, true);
            dVar.z(xVar, sb);
        }
        dVar.t(xVar, sb, true);
        List<c1> valueParameters = xVar.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "function.valueParameters");
        dVar.H(valueParameters, xVar.hasSynthesizedParameterNames(), sb);
        dVar.A(xVar, sb);
        c0 returnType = xVar.getReturnType();
        if (!dVar.getWithoutReturnType() && (dVar.getUnitReturnType() || returnType == null || !d0.e0.p.d.m0.b.h.isUnit(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : dVar.renderType(returnType));
        }
        List<z0> typeParameters2 = xVar.getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters2, "function.typeParameters");
        dVar.J(typeParameters2, sb);
    }

    public static final /* synthetic */ void access$renderName(d dVar, d0.e0.p.d.m0.c.m mVar, StringBuilder sb, boolean z2) {
        dVar.t(mVar, sb, z2);
    }

    public static final void access$renderPackageFragment(d dVar, e0 e0Var, StringBuilder sb) {
        Objects.requireNonNull(dVar);
        dVar.x(e0Var.getFqName(), "package-fragment", sb);
        if (dVar.getDebugMode()) {
            sb.append(" in ");
            dVar.t(e0Var.getContainingDeclaration(), sb, false);
        }
    }

    public static final void access$renderPackageView(d dVar, j0 j0Var, StringBuilder sb) {
        Objects.requireNonNull(dVar);
        dVar.x(j0Var.getFqName(), "package", sb);
        if (dVar.getDebugMode()) {
            sb.append(" in context of ");
            dVar.t(j0Var.getModule(), sb, false);
        }
    }

    public static final void access$renderProperty(d dVar, n0 n0Var, StringBuilder sb) {
        if (!dVar.getStartFromName()) {
            if (!dVar.getStartFromDeclarationKeyword()) {
                if (dVar.getModifiers().contains(g.ANNOTATIONS)) {
                    dVar.h(sb, n0Var, null);
                    v backingField = n0Var.getBackingField();
                    if (backingField != null) {
                        dVar.h(sb, backingField, d0.e0.p.d.m0.c.g1.e.FIELD);
                    }
                    v delegateField = n0Var.getDelegateField();
                    if (delegateField != null) {
                        dVar.h(sb, delegateField, d0.e0.p.d.m0.c.g1.e.PROPERTY_DELEGATE_FIELD);
                    }
                    if (dVar.getPropertyAccessorRenderingPolicy() == o.NONE) {
                        o0 getter = n0Var.getGetter();
                        if (getter != null) {
                            dVar.h(sb, getter, d0.e0.p.d.m0.c.g1.e.PROPERTY_GETTER);
                        }
                        p0 setter = n0Var.getSetter();
                        if (setter != null) {
                            dVar.h(sb, setter, d0.e0.p.d.m0.c.g1.e.PROPERTY_SETTER);
                            List<c1> valueParameters = setter.getValueParameters();
                            d0.z.d.m.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                            c1 c1Var = (c1) d0.t.u.single((List) valueParameters);
                            d0.z.d.m.checkNotNullExpressionValue(c1Var, "it");
                            dVar.h(sb, c1Var, d0.e0.p.d.m0.c.g1.e.SETTER_PARAMETER);
                        }
                    }
                }
                u visibility = n0Var.getVisibility();
                d0.z.d.m.checkNotNullExpressionValue(visibility, "property.visibility");
                dVar.I(visibility, sb);
                dVar.s(sb, dVar.getModifiers().contains(g.CONST) && n0Var.isConst(), "const");
                dVar.p(n0Var, sb);
                dVar.r(n0Var, sb);
                dVar.w(n0Var, sb);
                dVar.s(sb, dVar.getModifiers().contains(g.LATEINIT) && n0Var.isLateInit(), "lateinit");
                dVar.o(n0Var, sb);
            }
            dVar.F(n0Var, sb, false);
            List<z0> typeParameters = n0Var.getTypeParameters();
            d0.z.d.m.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            dVar.E(typeParameters, sb, true);
            dVar.z(n0Var, sb);
        }
        dVar.t(n0Var, sb, true);
        sb.append(": ");
        c0 type = n0Var.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "property.type");
        sb.append(dVar.renderType(type));
        dVar.A(n0Var, sb);
        dVar.m(n0Var, sb);
        List<z0> typeParameters2 = n0Var.getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        dVar.J(typeParameters2, sb);
    }

    public static final void access$renderTypeAlias(d dVar, y0 y0Var, StringBuilder sb) {
        dVar.h(sb, y0Var, null);
        u visibility = y0Var.getVisibility();
        d0.z.d.m.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
        dVar.I(visibility, sb);
        dVar.p(y0Var, sb);
        sb.append(dVar.n("typealias"));
        sb.append(" ");
        dVar.t(y0Var, sb, true);
        List<z0> declaredTypeParameters = y0Var.getDeclaredTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        dVar.E(declaredTypeParameters, sb, false);
        dVar.j(y0Var, sb);
        sb.append(" = ");
        sb.append(dVar.renderType(y0Var.getUnderlyingType()));
    }

    public static final /* synthetic */ void access$renderTypeParameter(d dVar, z0 z0Var, StringBuilder sb, boolean z2) {
        dVar.C(z0Var, sb, z2);
    }

    public static final /* synthetic */ void access$renderValueParameter(d dVar, c1 c1Var, boolean z2, StringBuilder sb, boolean z3) {
        dVar.G(c1Var, z2, sb, z3);
    }

    public static /* synthetic */ void i(d dVar, StringBuilder sb, d0.e0.p.d.m0.c.g1.a aVar, d0.e0.p.d.m0.c.g1.e eVar, int i) {
        int i2 = i & 2;
        dVar.h(sb, aVar, null);
    }

    public final void A(d0.e0.p.d.m0.c.a aVar, StringBuilder sb) {
        q0 extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = aVar.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            c0 type = extensionReceiverParameter.getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
        }
    }

    public final void B(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    public final void C(z0 z0Var, StringBuilder sb, boolean z2) {
        if (z2) {
            sb.append(f());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(z0Var.getIndex());
            sb.append("*/ ");
        }
        s(sb, z0Var.isReified(), "reified");
        String label = z0Var.getVariance().getLabel();
        boolean z3 = true;
        s(sb, label.length() > 0, label);
        h(sb, z0Var, null);
        t(z0Var, sb, z2);
        int size = z0Var.getUpperBounds().size();
        if ((size > 1 && !z2) || size == 1) {
            c0 next = z0Var.getUpperBounds().iterator().next();
            if (!d0.e0.p.d.m0.b.h.isDefaultBound(next)) {
                sb.append(" : ");
                d0.z.d.m.checkNotNullExpressionValue(next, "upperBound");
                sb.append(renderType(next));
            }
        } else if (z2) {
            for (c0 c0Var : z0Var.getUpperBounds()) {
                if (!d0.e0.p.d.m0.b.h.isDefaultBound(c0Var)) {
                    if (z3) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    d0.z.d.m.checkNotNullExpressionValue(c0Var, "upperBound");
                    sb.append(renderType(c0Var));
                    z3 = false;
                }
            }
        }
        if (z2) {
            sb.append(d());
        }
    }

    public final void D(StringBuilder sb, List<? extends z0> list) {
        Iterator<? extends z0> it = list.iterator();
        while (it.hasNext()) {
            C(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    public final void E(List<? extends z0> list, StringBuilder sb, boolean z2) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(f());
            D(sb, list);
            sb.append(d());
            if (z2) {
                sb.append(" ");
            }
        }
    }

    public final void F(d1 d1Var, StringBuilder sb, boolean z2) {
        if (z2 || !(d1Var instanceof c1)) {
            sb.append(n(d1Var.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0067  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e4  */
    public final void G(c1 c1Var, boolean z2, StringBuilder sb, boolean z3) {
        boolean z4;
        boolean z5;
        if (z3) {
            sb.append(n("value-parameter"));
            sb.append(" ");
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(c1Var.getIndex());
            sb.append("*/ ");
        }
        h(sb, c1Var, null);
        s(sb, c1Var.isCrossinline(), "crossinline");
        s(sb, c1Var.isNoinline(), "noinline");
        if (getRenderPrimaryConstructorParametersAsProperties()) {
            d0.e0.p.d.m0.c.a containingDeclaration = c1Var.getContainingDeclaration();
            d0.e0.p.d.m0.c.d dVar = containingDeclaration instanceof d0.e0.p.d.m0.c.d ? (d0.e0.p.d.m0.c.d) containingDeclaration : null;
            if (d0.z.d.m.areEqual(dVar == null ? null : Boolean.valueOf(dVar.isPrimary()), Boolean.TRUE)) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        if (z4) {
            s(sb, getActualPropertiesInPrimaryConstructor(), "actual");
        }
        c0 type = c1Var.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "variable.type");
        c0 varargElementType = c1Var != null ? c1Var.getVarargElementType() : null;
        c0 c0Var = varargElementType == null ? type : varargElementType;
        s(sb, varargElementType != null, "vararg");
        if (z4 || (z3 && !getStartFromName())) {
            F(c1Var, sb, z4);
        }
        if (z2) {
            t(c1Var, sb, z3);
            sb.append(": ");
        }
        sb.append(renderType(c0Var));
        m(c1Var, sb);
        if (getVerbose() && varargElementType != null) {
            sb.append(" /*");
            sb.append(renderType(type));
            sb.append("*/");
        }
        if (getDefaultParameterValueRenderer() != null) {
            z5 = getDebugMode() ? c1Var.declaresDefaultValue() : d0.e0.p.d.m0.k.x.a.declaresOrInheritsDefaultValue(c1Var);
        }
        if (z5) {
            Function1<c1, String> defaultParameterValueRenderer = getDefaultParameterValueRenderer();
            d0.z.d.m.checkNotNull(defaultParameterValueRenderer);
            sb.append(d0.z.d.m.stringPlus(" = ", defaultParameterValueRenderer.invoke(c1Var)));
        }
    }

    public final void H(Collection<? extends c1> collection, boolean z2, StringBuilder sb) {
        int iOrdinal = getParameterNameRenderingPolicy().ordinal();
        boolean z3 = true;
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z2) {
            }
            z3 = false;
        }
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (c1 c1Var : collection) {
            getValueParametersHandler().appendBeforeValueParameter(c1Var, i, size, sb);
            G(c1Var, z3, sb, false);
            getValueParametersHandler().appendAfterValueParameter(c1Var, i, size, sb);
            i++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb);
    }

    public final boolean I(u uVar, StringBuilder sb) {
        if (!getModifiers().contains(g.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            uVar = uVar.normalize();
        }
        if (!getRenderDefaultVisibility() && d0.z.d.m.areEqual(uVar, t.k)) {
            return false;
        }
        sb.append(n(uVar.getInternalDisplayName()));
        sb.append(" ");
        return true;
    }

    public final void J(List<? extends z0> list, StringBuilder sb) {
        if (getWithoutTypeParameters()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (z0 z0Var : list) {
            List<c0> upperBounds = z0Var.getUpperBounds();
            d0.z.d.m.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
            for (c0 c0Var : d0.t.u.drop(upperBounds, 1)) {
                StringBuilder sb2 = new StringBuilder();
                d0.e0.p.d.m0.g.e name = z0Var.getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "typeParameter.name");
                sb2.append(renderName(name, false));
                sb2.append(" : ");
                d0.z.d.m.checkNotNullExpressionValue(c0Var, "it");
                sb2.append(renderType(c0Var));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(" ");
            sb.append(n("where"));
            sb.append(" ");
            d0.t.u.joinTo$default(arrayList, sb, ", ", null, null, 0, null, null, 124, null);
        }
    }

    public final String K(String str, String str2, String str3, String str4, String str5) {
        if (d0.g0.t.startsWith$default(str, str2, false, 2, null) && d0.g0.t.startsWith$default(str3, str4, false, 2, null)) {
            int length = str2.length();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = str.substring(length);
            d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            int length2 = str4.length();
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String strSubstring2 = str3.substring(length2);
            d0.z.d.m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            String strStringPlus = d0.z.d.m.stringPlus(str5, strSubstring);
            if (d0.z.d.m.areEqual(strSubstring, strSubstring2)) {
                return strStringPlus;
            }
            if (b(strSubstring, strSubstring2)) {
                return d0.z.d.m.stringPlus(strStringPlus, "!");
            }
        }
        return null;
    }

    public final boolean L(c0 c0Var) {
        boolean z2;
        if (!d0.e0.p.d.m0.b.g.isBuiltinFunctionalType(c0Var)) {
            return false;
        }
        List<w0> arguments = c0Var.getArguments();
        if ((arguments instanceof Collection) && arguments.isEmpty()) {
            z2 = true;
        } else {
            Iterator<T> it = arguments.iterator();
            while (it.hasNext()) {
                if (((w0) it.next()).isStarProjection()) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public final void a(StringBuilder sb, List<? extends w0> list) {
        d0.t.u.joinTo$default(list, sb, ", ", null, null, 0, null, new d$b(this), 60, null);
    }

    public final boolean b(String str, String str2) {
        if (!d0.z.d.m.areEqual(str, d0.g0.t.replace$default(str2, "?", "", false, 4, (Object) null)) && (!d0.g0.t.endsWith$default(str2, "?", false, 2, null) || !d0.z.d.m.areEqual(d0.z.d.m.stringPlus(str, "?"), str2))) {
            if (!d0.z.d.m.areEqual('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    public final String c(String str) {
        return getTextFormat().escape(str);
    }

    public final String d() {
        return getTextFormat().escape(">");
    }

    public final z e(y yVar) {
        d0.e0.p.d.m0.c.f fVar = d0.e0.p.d.m0.c.f.INTERFACE;
        if (yVar instanceof d0.e0.p.d.m0.c.e) {
            return ((d0.e0.p.d.m0.c.e) yVar).getKind() == fVar ? z.ABSTRACT : z.FINAL;
        }
        d0.e0.p.d.m0.c.m containingDeclaration = yVar.getContainingDeclaration();
        d0.e0.p.d.m0.c.e eVar = containingDeclaration instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) containingDeclaration : null;
        if (eVar != null && (yVar instanceof d0.e0.p.d.m0.c.b)) {
            d0.e0.p.d.m0.c.b bVar = (d0.e0.p.d.m0.c.b) yVar;
            Collection<? extends d0.e0.p.d.m0.c.b> overriddenDescriptors = bVar.getOverriddenDescriptors();
            d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
            if ((!overriddenDescriptors.isEmpty()) && eVar.getModality() != z.FINAL) {
                return z.OPEN;
            }
            if (eVar.getKind() != fVar || d0.z.d.m.areEqual(bVar.getVisibility(), t.a)) {
                return z.FINAL;
            }
            z modality = bVar.getModality();
            z zVar = z.ABSTRACT;
            return modality == zVar ? zVar : z.OPEN;
        }
        return z.FINAL;
    }

    public final String f() {
        return getTextFormat().escape("<");
    }

    public final void g(StringBuilder sb, d0.e0.p.d.m0.n.a aVar) {
        p textFormat = getTextFormat();
        p pVar = p.k;
        if (textFormat == pVar) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        v(sb, aVar.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == pVar) {
            sb.append("</i></font>");
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.d.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.d.getAlwaysRenderModifiers();
    }

    @Override // d0.e0.p.d.m0.j.h
    public a getAnnotationArgumentsRenderingPolicy() {
        return this.d.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<d0.e0.p.d.m0.c.g1.c, Boolean> getAnnotationFilter() {
        return this.d.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.d.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.d.getClassWithPrimaryConstructor();
    }

    public b getClassifierNamePolicy() {
        return this.d.getClassifierNamePolicy();
    }

    @Override // d0.e0.p.d.m0.j.h
    public boolean getDebugMode() {
        return this.d.getDebugMode();
    }

    public Function1<c1, String> getDefaultParameterValueRenderer() {
        return this.d.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.d.getEachAnnotationOnNewLine();
    }

    @Override // d0.e0.p.d.m0.j.h
    public boolean getEnhancedTypes() {
        return this.d.getEnhancedTypes();
    }

    public Set<d0.e0.p.d.m0.g.b> getExcludedAnnotationClasses() {
        return this.d.getExcludedAnnotationClasses();
    }

    @Override // d0.e0.p.d.m0.j.h
    public Set<d0.e0.p.d.m0.g.b> getExcludedTypeAnnotationClasses() {
        return this.d.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.d.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.d.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.d.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.d.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.d.getInformativeErrorType();
    }

    public Set<g> getModifiers() {
        return this.d.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.d.getNormalizedVisibilities();
    }

    public final i getOptions() {
        return this.d;
    }

    public m getOverrideRenderingPolicy() {
        return this.d.getOverrideRenderingPolicy();
    }

    public n getParameterNameRenderingPolicy() {
        return this.d.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.d.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.d.getPresentableUnresolvedTypes();
    }

    public o getPropertyAccessorRenderingPolicy() {
        return this.d.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.d.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.d.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.d.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.d.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.d.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.d.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.d.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.d.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.d.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.d.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.d.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.d.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.d.getStartFromName();
    }

    public p getTextFormat() {
        return this.d.getTextFormat();
    }

    public Function1<c0, c0> getTypeNormalizer() {
        return this.d.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.d.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.d.getUnitReturnType();
    }

    public c$l getValueParametersHandler() {
        return this.d.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.d.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.d.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.d.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.d.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.d.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.d.getWithoutTypeParameters();
    }

    public final void h(StringBuilder sb, d0.e0.p.d.m0.c.g1.a aVar, d0.e0.p.d.m0.c.g1.e eVar) {
        if (getModifiers().contains(g.ANNOTATIONS)) {
            Set<d0.e0.p.d.m0.g.b> excludedTypeAnnotationClasses = aVar instanceof c0 ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            Function1<d0.e0.p.d.m0.c.g1.c, Boolean> annotationFilter = getAnnotationFilter();
            for (d0.e0.p.d.m0.c.g1.c cVar : aVar.getAnnotations()) {
                if (!d0.t.u.contains(excludedTypeAnnotationClasses, cVar.getFqName()) && !d0.z.d.m.areEqual(cVar.getFqName(), k$a.f3229y) && (annotationFilter == null || annotationFilter.invoke(cVar).booleanValue())) {
                    sb.append(renderAnnotation(cVar, eVar));
                    if (getEachAnnotationOnNewLine()) {
                        sb.append('\n');
                        d0.z.d.m.checkNotNullExpressionValue(sb, "append('\\n')");
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    public final void j(d0.e0.p.d.m0.c.i iVar, StringBuilder sb) {
        List<z0> declaredTypeParameters = iVar.getDeclaredTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<z0> parameters = iVar.getTypeConstructor().getParameters();
        d0.z.d.m.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && iVar.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            D(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    public final String k(d0.e0.p.d.m0.k.v.g<?> gVar) {
        if (gVar instanceof d0.e0.p.d.m0.k.v.b) {
            return d0.t.u.joinToString$default(((d0.e0.p.d.m0.k.v.b) gVar).getValue(), ", ", "{", "}", 0, null, new d$d(this), 24, null);
        }
        if (gVar instanceof d0.e0.p.d.m0.k.v.a) {
            return w.removePrefix(c.renderAnnotation$default(this, ((d0.e0.p.d.m0.k.v.a) gVar).getValue(), null, 2, null), "@");
        }
        if (!(gVar instanceof r)) {
            return gVar.toString();
        }
        r$b value = ((r) gVar).getValue();
        if (value instanceof r$b$a) {
            return ((r$b$a) value).getType() + "::class";
        }
        if (!(value instanceof r$b$b)) {
            throw new NoWhenBranchMatchedException();
        }
        r$b$b r_b_b = (r$b$b) value;
        String strAsString = r_b_b.getClassId().asSingleFqName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "classValue.classId.asSingleFqName().asString()");
        for (int i = 0; i < r_b_b.getArrayDimensions(); i++) {
            strAsString = "kotlin.Array<" + strAsString + '>';
        }
        return d0.z.d.m.stringPlus(strAsString, "::class");
    }

    public final void l(StringBuilder sb, c0 c0Var) {
        h(sb, c0Var, null);
        if (d0.e0.p.d.m0.n.e0.isError(c0Var)) {
            if ((c0Var instanceof h1) && getPresentableUnresolvedTypes()) {
                sb.append(((h1) c0Var).getPresentableName());
            } else if (!(c0Var instanceof s) || getInformativeErrorType()) {
                sb.append(c0Var.getConstructor().toString());
            } else {
                sb.append(((s) c0Var).getPresentableName());
            }
            sb.append(renderTypeArguments(c0Var.getArguments()));
        } else {
            u0 constructor = c0Var.getConstructor();
            l0 l0VarBuildPossiblyInnerType = a1.buildPossiblyInnerType(c0Var);
            if (l0VarBuildPossiblyInnerType == null) {
                sb.append(renderTypeConstructor(constructor));
                sb.append(renderTypeArguments(c0Var.getArguments()));
            } else {
                y(sb, l0VarBuildPossiblyInnerType);
            }
        }
        if (c0Var.isMarkedNullable()) {
            sb.append("?");
        }
        if (d0.e0.p.d.m0.n.m0.isDefinitelyNotNullType(c0Var)) {
            sb.append("!!");
        }
    }

    public final void m(d1 d1Var, StringBuilder sb) {
        d0.e0.p.d.m0.k.v.g<?> compileTimeInitializer;
        if (!getIncludePropertyConstant() || (compileTimeInitializer = d1Var.getCompileTimeInitializer()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(c(k(compileTimeInitializer)));
    }

    public final String n(String str) {
        int iOrdinal = getTextFormat().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return getBoldOnlyForNamesInHtml() ? str : b.d.b.a.a.y("<b>", str, "</b>");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void o(d0.e0.p.d.m0.c.b bVar, StringBuilder sb) {
        if (getModifiers().contains(g.MEMBER_KIND) && getVerbose() && bVar.getKind() != d0.e0.p.d.m0.c.b$a.DECLARATION) {
            sb.append("/*");
            String strName = bVar.getKind().name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            d0.z.d.m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append("*/ ");
        }
    }

    public final void p(y yVar, StringBuilder sb) {
        s(sb, yVar.isExternal(), "external");
        boolean z2 = false;
        s(sb, getModifiers().contains(g.EXPECT) && yVar.isExpect(), "expect");
        if (getModifiers().contains(g.ACTUAL) && yVar.isActual()) {
            z2 = true;
        }
        s(sb, z2, "actual");
    }

    public final void q(z zVar, StringBuilder sb, z zVar2) {
        if (getRenderDefaultModality() || zVar != zVar2) {
            boolean zContains = getModifiers().contains(g.MODALITY);
            String strName = zVar.name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            d0.z.d.m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            s(sb, zContains, lowerCase);
        }
    }

    public final void r(d0.e0.p.d.m0.c.b bVar, StringBuilder sb) {
        if (d0.e0.p.d.m0.k.e.isTopLevelDeclaration(bVar) && bVar.getModality() == z.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() == m.RENDER_OVERRIDE && bVar.getModality() == z.OPEN && (!bVar.getOverriddenDescriptors().isEmpty())) {
            return;
        }
        z modality = bVar.getModality();
        d0.z.d.m.checkNotNullExpressionValue(modality, "callable.modality");
        q(modality, sb, e(bVar));
    }

    @Override // d0.e0.p.d.m0.j.c
    public String render(d0.e0.p.d.m0.c.m mVar) {
        String name;
        d0.z.d.m.checkNotNullParameter(mVar, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        mVar.accept(new d$a(this), sb);
        if (getWithDefinedIn() && !(mVar instanceof e0) && !(mVar instanceof j0)) {
            if (mVar instanceof d0.e0.p.d.m0.c.c0) {
                sb.append(" is a module");
            } else {
                d0.e0.p.d.m0.c.m containingDeclaration = mVar.getContainingDeclaration();
                if (containingDeclaration != null && !(containingDeclaration instanceof d0.e0.p.d.m0.c.c0)) {
                    sb.append(" ");
                    sb.append(renderMessage("defined in"));
                    sb.append(" ");
                    d0.e0.p.d.m0.g.c fqName = d0.e0.p.d.m0.k.e.getFqName(containingDeclaration);
                    d0.z.d.m.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
                    sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
                    if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof e0) && (mVar instanceof d0.e0.p.d.m0.c.p) && (name = ((v0$a) ((d0.e0.p.d.m0.c.p) mVar).getSource().getContainingFile()).getName()) != null) {
                        sb.append(" ");
                        sb.append(renderMessage("in file"));
                        sb.append(" ");
                        sb.append(name);
                    }
                }
            }
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // d0.e0.p.d.m0.j.c
    public String renderAnnotation(d0.e0.p.d.m0.c.g1.c cVar, d0.e0.p.d.m0.c.g1.e eVar) {
        d0.e0.p.d.m0.c.d unsubstitutedPrimaryConstructor;
        d0.z.d.m.checkNotNullParameter(cVar, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtilsKt.MENTIONS_CHAR);
        if (eVar != null) {
            sb.append(d0.z.d.m.stringPlus(eVar.getRenderName(), ":"));
        }
        c0 type = cVar.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> allValueArguments = cVar.getAllValueArguments();
            List listEmptyList = null;
            d0.e0.p.d.m0.c.e annotationClass = getRenderDefaultAnnotationArguments() ? d0.e0.p.d.m0.k.x.a.getAnnotationClass(cVar) : null;
            List<c1> valueParameters = (annotationClass == null || (unsubstitutedPrimaryConstructor = annotationClass.getUnsubstitutedPrimaryConstructor()) == null) ? null : unsubstitutedPrimaryConstructor.getValueParameters();
            if (valueParameters != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : valueParameters) {
                    if (((c1) obj).declaresDefaultValue()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((c1) it.next()).getName());
                }
                listEmptyList = arrayList2;
            }
            if (listEmptyList == null) {
                listEmptyList = d0.t.n.emptyList();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listEmptyList) {
                d0.e0.p.d.m0.g.e eVar2 = (d0.e0.p.d.m0.g.e) obj2;
                d0.z.d.m.checkNotNullExpressionValue(eVar2, "it");
                if (!allValueArguments.containsKey(eVar2)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(d0.z.d.m.stringPlus(((d0.e0.p.d.m0.g.e) it2.next()).asString(), " = ..."));
            }
            Set<Map$Entry<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>>> setEntrySet = allValueArguments.entrySet();
            ArrayList arrayList5 = new ArrayList(d0.t.o.collectionSizeOrDefault(setEntrySet, 10));
            Iterator<T> it3 = setEntrySet.iterator();
            while (it3.hasNext()) {
                Map$Entry map$Entry = (Map$Entry) it3.next();
                d0.e0.p.d.m0.g.e eVar3 = (d0.e0.p.d.m0.g.e) map$Entry.getKey();
                d0.e0.p.d.m0.k.v.g<?> gVar = (d0.e0.p.d.m0.k.v.g) map$Entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(eVar3.asString());
                sb2.append(" = ");
                sb2.append(!listEmptyList.contains(eVar3) ? k(gVar) : "...");
                arrayList5.add(sb2.toString());
            }
            List listSorted = d0.t.u.sorted(d0.t.u.plus((Collection) arrayList4, (Iterable) arrayList5));
            if (getIncludeEmptyAnnotationArguments() || (!listSorted.isEmpty())) {
                d0.t.u.joinTo$default(listSorted, sb, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (getVerbose() && (d0.e0.p.d.m0.n.e0.isError(type) || (type.getConstructor().getDeclarationDescriptor() instanceof d0$b))) {
            sb.append(" /* annotation class not found */");
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderClassifierName(d0.e0.p.d.m0.c.h hVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "klass");
        return d0.e0.p.d.m0.n.t.isError(hVar) ? hVar.getTypeConstructor().toString() : getClassifierNamePolicy().renderClassifier(hVar, this);
    }

    @Override // d0.e0.p.d.m0.j.c
    public String renderFlexibleType(String str, String str2, d0.e0.p.d.m0.b.h hVar) {
        d0.z.d.m.checkNotNullParameter(str, "lowerRendered");
        d0.z.d.m.checkNotNullParameter(str2, "upperRendered");
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        if (b(str, str2)) {
            if (!d0.g0.t.startsWith$default(str2, "(", false, 2, null)) {
                return d0.z.d.m.stringPlus(str, "!");
            }
            return '(' + str + ")!";
        }
        b classifierNamePolicy = getClassifierNamePolicy();
        d0.e0.p.d.m0.c.e collection = hVar.getCollection();
        d0.z.d.m.checkNotNullExpressionValue(collection, "builtIns.collection");
        String strSubstringBefore$default = w.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this), "Collection", (String) null, 2, (Object) null);
        String strK = K(str, d0.z.d.m.stringPlus(strSubstringBefore$default, "Mutable"), str2, strSubstringBefore$default, strSubstringBefore$default + "(Mutable)");
        if (strK != null) {
            return strK;
        }
        String strK2 = K(str, d0.z.d.m.stringPlus(strSubstringBefore$default, "MutableMap.MutableEntry"), str2, d0.z.d.m.stringPlus(strSubstringBefore$default, "Map.Entry"), d0.z.d.m.stringPlus(strSubstringBefore$default, "(Mutable)Map.(Mutable)Entry"));
        if (strK2 != null) {
            return strK2;
        }
        b classifierNamePolicy2 = getClassifierNamePolicy();
        d0.e0.p.d.m0.c.e array = hVar.getArray();
        d0.z.d.m.checkNotNullExpressionValue(array, "builtIns.array");
        String strSubstringBefore$default2 = w.substringBefore$default(classifierNamePolicy2.renderClassifier(array, this), "Array", (String) null, 2, (Object) null);
        String strK3 = K(str, d0.z.d.m.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<")), str2, d0.z.d.m.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<out ")), d0.z.d.m.stringPlus(strSubstringBefore$default2, getTextFormat().escape("Array<(out) ")));
        if (strK3 != null) {
            return strK3;
        }
        return '(' + str + ".." + str2 + ')';
    }

    @Override // d0.e0.p.d.m0.j.c
    public String renderFqName(d0.e0.p.d.m0.g.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "fqName");
        List<d0.e0.p.d.m0.g.e> listPathSegments = cVar.pathSegments();
        d0.z.d.m.checkNotNullExpressionValue(listPathSegments, "fqName.pathSegments()");
        return c(q.renderFqName(listPathSegments));
    }

    public String renderMessage(String str) {
        d0.z.d.m.checkNotNullParameter(str, "message");
        int iOrdinal = getTextFormat().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal == 1) {
            return b.d.b.a.a.y("<i>", str, "</i>");
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // d0.e0.p.d.m0.j.c
    public String renderName(d0.e0.p.d.m0.g.e eVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strC = c(q.render(eVar));
        return (getBoldOnlyForNamesInHtml() && getTextFormat() == p.k && z2) ? b.d.b.a.a.y("<b>", strC, "</b>") : strC;
    }

    @Override // d0.e0.p.d.m0.j.c
    public String renderType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        StringBuilder sb = new StringBuilder();
        u(sb, getTypeNormalizer().invoke(c0Var));
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderTypeArguments(List<? extends w0> list) {
        d0.z.d.m.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        a(sb, list);
        sb.append(d());
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String renderTypeConstructor(u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(u0Var, "typeConstructor");
        d0.e0.p.d.m0.c.h declarationDescriptor = u0Var.getDeclarationDescriptor();
        if (declarationDescriptor instanceof z0 ? true : declarationDescriptor instanceof d0.e0.p.d.m0.c.e ? true : declarationDescriptor instanceof y0) {
            return renderClassifierName(declarationDescriptor);
        }
        if (declarationDescriptor == null) {
            return u0Var.toString();
        }
        throw new IllegalStateException(d0.z.d.m.stringPlus("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
    }

    @Override // d0.e0.p.d.m0.j.c
    public String renderTypeProjection(w0 w0Var) {
        d0.z.d.m.checkNotNullParameter(w0Var, "typeProjection");
        StringBuilder sb = new StringBuilder();
        a(sb, d0.t.m.listOf(w0Var));
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void s(StringBuilder sb, boolean z2, String str) {
        if (z2) {
            sb.append(n(str));
            sb.append(" ");
        }
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setAnnotationArgumentsRenderingPolicy(a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "<set-?>");
        this.d.setAnnotationArgumentsRenderingPolicy(aVar);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setClassifierNamePolicy(b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "<set-?>");
        this.d.setClassifierNamePolicy(bVar);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setDebugMode(boolean z2) {
        this.d.setDebugMode(z2);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setExcludedTypeAnnotationClasses(Set<d0.e0.p.d.m0.g.b> set) {
        d0.z.d.m.checkNotNullParameter(set, "<set-?>");
        this.d.setExcludedTypeAnnotationClasses(set);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setModifiers(Set<? extends g> set) {
        d0.z.d.m.checkNotNullParameter(set, "<set-?>");
        this.d.setModifiers(set);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setParameterNameRenderingPolicy(n nVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "<set-?>");
        this.d.setParameterNameRenderingPolicy(nVar);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setReceiverAfterName(boolean z2) {
        this.d.setReceiverAfterName(z2);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setRenderCompanionObjectName(boolean z2) {
        this.d.setRenderCompanionObjectName(z2);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setStartFromName(boolean z2) {
        this.d.setStartFromName(z2);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setTextFormat(p pVar) {
        d0.z.d.m.checkNotNullParameter(pVar, "<set-?>");
        this.d.setTextFormat(pVar);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setWithDefinedIn(boolean z2) {
        this.d.setWithDefinedIn(z2);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setWithoutSuperTypes(boolean z2) {
        this.d.setWithoutSuperTypes(z2);
    }

    @Override // d0.e0.p.d.m0.j.h
    public void setWithoutTypeParameters(boolean z2) {
        this.d.setWithoutTypeParameters(z2);
    }

    public final void t(d0.e0.p.d.m0.c.m mVar, StringBuilder sb, boolean z2) {
        d0.e0.p.d.m0.g.e name = mVar.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(renderName(name, z2));
    }

    public final void u(StringBuilder sb, c0 c0Var) {
        i1 i1VarUnwrap = c0Var.unwrap();
        d0.e0.p.d.m0.n.a aVar = i1VarUnwrap instanceof d0.e0.p.d.m0.n.a ? (d0.e0.p.d.m0.n.a) i1VarUnwrap : null;
        if (aVar == null) {
            v(sb, c0Var);
            return;
        }
        if (getRenderTypeExpansions()) {
            v(sb, aVar.getExpandedType());
            return;
        }
        v(sb, aVar.getAbbreviation());
        if (getRenderUnabbreviatedType()) {
            g(sb, aVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0124  */
    public final void v(StringBuilder sb, c0 c0Var) {
        String strEscape;
        d0.e0.p.d.m0.g.e eVarExtractParameterNameFromFunctionTypeArgument;
        boolean z2;
        if ((c0Var instanceof k1) && getDebugMode() && !((k1) c0Var).isComputed()) {
            sb.append("<Not computed yet>");
            return;
        }
        i1 i1VarUnwrap = c0Var.unwrap();
        if (i1VarUnwrap instanceof d0.e0.p.d.m0.n.v) {
            sb.append(((d0.e0.p.d.m0.n.v) i1VarUnwrap).render(this, this));
            return;
        }
        if (i1VarUnwrap instanceof d0.e0.p.d.m0.n.j0) {
            d0.e0.p.d.m0.n.j0 j0Var = (d0.e0.p.d.m0.n.j0) i1VarUnwrap;
            if (d0.z.d.m.areEqual(j0Var, e1.f3522b) || e1.isDontCarePlaceholder(j0Var)) {
                sb.append("???");
                return;
            }
            if (d0.e0.p.d.m0.n.t.isUninferredParameter(j0Var)) {
                if (!getUninferredTypeParameterAsName()) {
                    sb.append("???");
                    return;
                }
                String string = ((t$f) j0Var.getConstructor()).getTypeParameterDescriptor().getName().toString();
                d0.z.d.m.checkNotNullExpressionValue(string, "type.constructor as UninferredParameterTypeConstructor).typeParameterDescriptor.name.toString()");
                int iOrdinal = getTextFormat().ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    string = b.d.b.a.a.y("<font color=red><b>", string, "</b></font>");
                }
                sb.append(string);
                return;
            }
            if (d0.e0.p.d.m0.n.e0.isError(j0Var)) {
                l(sb, j0Var);
                return;
            }
            if (!L(j0Var)) {
                l(sb, j0Var);
                return;
            }
            int length = sb.length();
            i((d) this.e.getValue(), sb, j0Var, null, 2);
            boolean z3 = sb.length() != length;
            boolean zIsSuspendFunctionType = d0.e0.p.d.m0.b.g.isSuspendFunctionType(j0Var);
            boolean zIsMarkedNullable = j0Var.isMarkedNullable();
            c0 receiverTypeFromFunctionType = d0.e0.p.d.m0.b.g.getReceiverTypeFromFunctionType(j0Var);
            boolean z4 = zIsMarkedNullable || (z3 && receiverTypeFromFunctionType != null);
            if (z4) {
                if (zIsSuspendFunctionType) {
                    sb.insert(length, '(');
                } else {
                    if (z3) {
                        d0.g0.y.last(sb);
                        if (sb.charAt(w.getLastIndex(sb) - 1) != ')') {
                            sb.insert(w.getLastIndex(sb), "()");
                        }
                    }
                    sb.append("(");
                }
            }
            s(sb, zIsSuspendFunctionType, "suspend");
            if (receiverTypeFromFunctionType != null) {
                if (L(receiverTypeFromFunctionType) && !receiverTypeFromFunctionType.isMarkedNullable()) {
                    z2 = true;
                } else if (d0.e0.p.d.m0.b.g.isSuspendFunctionType(receiverTypeFromFunctionType) || !receiverTypeFromFunctionType.getAnnotations().isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    sb.append("(");
                }
                u(sb, receiverTypeFromFunctionType);
                if (z2) {
                    sb.append(")");
                }
                sb.append(".");
            }
            sb.append("(");
            int i = 0;
            for (w0 w0Var : d0.e0.p.d.m0.b.g.getValueParameterTypesFromFunctionType(j0Var)) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append(", ");
                }
                if (getParameterNamesInFunctionalTypes()) {
                    c0 type = w0Var.getType();
                    d0.z.d.m.checkNotNullExpressionValue(type, "typeProjection.type");
                    eVarExtractParameterNameFromFunctionTypeArgument = d0.e0.p.d.m0.b.g.extractParameterNameFromFunctionTypeArgument(type);
                } else {
                    eVarExtractParameterNameFromFunctionTypeArgument = null;
                }
                if (eVarExtractParameterNameFromFunctionTypeArgument != null) {
                    sb.append(renderName(eVarExtractParameterNameFromFunctionTypeArgument, false));
                    sb.append(": ");
                }
                sb.append(renderTypeProjection(w0Var));
                i = i2;
            }
            sb.append(") ");
            int iOrdinal2 = getTextFormat().ordinal();
            if (iOrdinal2 == 0) {
                strEscape = getTextFormat().escape("->");
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                strEscape = "&rarr;";
            }
            sb.append(strEscape);
            sb.append(" ");
            u(sb, d0.e0.p.d.m0.b.g.getReturnTypeFromFunctionType(j0Var));
            if (z4) {
                sb.append(")");
            }
            if (zIsMarkedNullable) {
                sb.append("?");
            }
        }
    }

    public final void w(d0.e0.p.d.m0.c.b bVar, StringBuilder sb) {
        if (getModifiers().contains(g.OVERRIDE) && (!bVar.getOverriddenDescriptors().isEmpty()) && getOverrideRenderingPolicy() != m.RENDER_OPEN) {
            s(sb, true, "override");
            if (getVerbose()) {
                sb.append("/*");
                sb.append(bVar.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    public final void x(d0.e0.p.d.m0.g.b bVar, String str, StringBuilder sb) {
        sb.append(n(str));
        d0.e0.p.d.m0.g.c unsafe = bVar.toUnsafe();
        d0.z.d.m.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String strRenderFqName = renderFqName(unsafe);
        if (strRenderFqName.length() > 0) {
            sb.append(" ");
            sb.append(strRenderFqName);
        }
    }

    public final void y(StringBuilder sb, l0 l0Var) {
        StringBuilder sb2;
        l0 outerType = l0Var.getOuterType();
        if (outerType == null) {
            sb2 = null;
        } else {
            y(sb, outerType);
            sb.append('.');
            d0.e0.p.d.m0.g.e name = l0Var.getClassifierDescriptor().getName();
            d0.z.d.m.checkNotNullExpressionValue(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(renderName(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            u0 typeConstructor = l0Var.getClassifierDescriptor().getTypeConstructor();
            d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb.append(renderTypeConstructor(typeConstructor));
        }
        sb.append(renderTypeArguments(l0Var.getArguments()));
    }

    public final void z(d0.e0.p.d.m0.c.a aVar, StringBuilder sb) {
        q0 extensionReceiverParameter = aVar.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            h(sb, extensionReceiverParameter, d0.e0.p.d.m0.c.g1.e.RECEIVER);
            c0 type = extensionReceiverParameter.getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "receiver.type");
            String strRenderType = renderType(type);
            if (L(type) && !e1.isNullableType(type)) {
                strRenderType = '(' + strRenderType + ')';
            }
            sb.append(strRenderType);
            sb.append(".");
        }
    }
}
