package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.a$a;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.d0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.b0;
import d0.e0.p.d.m0.e.a.f0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public final d0.e0.p.d.m0.e.a.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.p.e f3348b;
    public final d c;

    public l(d0.e0.p.d.m0.e.a.c cVar, d0.e0.p.d.m0.p.e eVar, d dVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "annotationTypeQualifierResolver");
        d0.z.d.m.checkNotNullParameter(eVar, "javaTypeEnhancementState");
        d0.z.d.m.checkNotNullParameter(dVar, "typeEnhancement");
        this.a = cVar;
        this.f3348b = eVar;
        this.c = dVar;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.c access$getAnnotationTypeQualifierResolver$p(l lVar) {
        return lVar.a;
    }

    public static final /* synthetic */ d access$getTypeEnhancement$p(l lVar) {
        return lVar.c;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e2  */
    public final i a(d0.e0.p.d.m0.c.g1.c cVar, boolean z2, boolean z3) {
        i iVar;
        i iVar2;
        i iVar3;
        h hVar = h.FORCE_FLEXIBILITY;
        h hVar2 = h.NULLABLE;
        d0.e0.p.d.m0.g.b fqName = cVar.getFqName();
        if (fqName == null) {
            return null;
        }
        boolean z4 = (cVar instanceof d0.e0.p.d.m0.e.a.i0.l.e) && (((d0.e0.p.d.m0.e.a.i0.l.e) cVar).isFreshlySupportedTypeUseAnnotation() || z3) && !z2;
        if (this.f3348b.getJspecifyReportLevel() != d0.e0.p.d.m0.p.h.IGNORE) {
            boolean z5 = this.f3348b.getJspecifyReportLevel() == d0.e0.p.d.m0.p.h.WARN;
            if (d0.z.d.m.areEqual(fqName, b0.getJSPECIFY_NULLABLE())) {
                iVar = new i(hVar2, z5);
            } else if (d0.z.d.m.areEqual(fqName, b0.getJSPECIFY_NULLNESS_UNKNOWN())) {
                iVar = new i(hVar, z5);
            } else {
                iVar = null;
            }
        } else {
            iVar = null;
        }
        if (iVar == null) {
            h hVar3 = h.NOT_NULL;
            if (b0.getNULLABLE_ANNOTATIONS().contains(fqName)) {
                iVar = new i(hVar2, z4);
            } else {
                if (b0.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
                    iVar3 = new i(hVar3, z4);
                } else if (d0.z.d.m.areEqual(fqName, b0.getJAVAX_NONNULL_ANNOTATION())) {
                    d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = d0.e0.p.d.m0.k.x.a.firstArgument(cVar);
                    d0.e0.p.d.m0.k.v.j jVar = gVarFirstArgument instanceof d0.e0.p.d.m0.k.v.j ? (d0.e0.p.d.m0.k.v.j) gVarFirstArgument : null;
                    if (jVar != null) {
                        switch (jVar.getEnumEntryName().asString()) {
                            case "MAYBE":
                            case "NEVER":
                                iVar = new i(hVar2, z4);
                                break;
                            case "UNKNOWN":
                                iVar = new i(hVar, z4);
                                break;
                            case "ALWAYS":
                                iVar3 = new i(hVar3, z4);
                                break;
                            default:
                                iVar = null;
                                break;
                        }
                    } else {
                        iVar3 = new i(hVar3, z4);
                    }
                } else if (d0.z.d.m.areEqual(fqName, b0.getCOMPATQUAL_NULLABLE_ANNOTATION()) && this.f3348b.getEnableCompatqualCheckerFrameworkAnnotations()) {
                    iVar = new i(hVar2, z4);
                } else if (d0.z.d.m.areEqual(fqName, b0.getCOMPATQUAL_NONNULL_ANNOTATION()) && this.f3348b.getEnableCompatqualCheckerFrameworkAnnotations()) {
                    iVar3 = new i(hVar3, z4);
                } else {
                    if (d0.z.d.m.areEqual(fqName, b0.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
                        iVar2 = new i(hVar3, true);
                    } else if (d0.z.d.m.areEqual(fqName, b0.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
                        iVar2 = new i(hVar2, true);
                    } else {
                        iVar = null;
                    }
                    iVar = iVar2;
                }
                iVar = iVar3;
            }
            if (iVar == null) {
                return null;
            }
        }
        return (!iVar.isForWarningOnly() && (cVar instanceof d0.e0.p.d.m0.e.a.h0.i) && ((d0.e0.p.d.m0.e.a.h0.i) cVar).isIdeExternalAnnotation()) ? i.copy$default(iVar, null, true, 1, null) : iVar;
    }

    public final l$b b(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.g1.a aVar, boolean z2, d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.a aVar2, Function1<? super d0.e0.p.d.m0.c.b, ? extends c0> function1) {
        c0 c0VarInvoke = function1.invoke(bVar);
        Collection<? extends d0.e0.p.d.m0.c.b> overriddenDescriptors = bVar.getOverriddenDescriptors();
        d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (d0.e0.p.d.m0.c.b bVar2 : overriddenDescriptors) {
            d0.z.d.m.checkNotNullExpressionValue(bVar2, "it");
            arrayList.add(function1.invoke(bVar2));
        }
        return new l$b(this, aVar, c0VarInvoke, arrayList, z2, d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(gVar, function1.invoke(bVar).getAnnotations()), aVar2, false, 64, null);
    }

    public final l$b c(d0.e0.p.d.m0.c.b bVar, c1 c1Var, d0.e0.p.d.m0.e.a.i0.g gVar, Function1<? super d0.e0.p.d.m0.c.b, ? extends c0> function1) {
        d0.e0.p.d.m0.e.a.i0.g gVarCopyWithNewDefaultTypeQualifiers;
        return b(bVar, c1Var, false, (c1Var == null || (gVarCopyWithNewDefaultTypeQualifiers = d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(gVar, c1Var.getAnnotations())) == null) ? gVar : gVarCopyWithNewDefaultTypeQualifiers, d0.e0.p.d.m0.e.a.a.VALUE_PARAMETER, function1);
    }

    /* JADX WARN: Code duplicated, block: B:126:0x022b  */
    /* JADX WARN: Code duplicated, block: B:146:0x026a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x026c  */
    /* JADX WARN: Code duplicated, block: B:148:0x027a  */
    /* JADX WARN: Code duplicated, block: B:150:0x027d  */
    /* JADX WARN: Code duplicated, block: B:151:0x027f  */
    /* JADX WARN: Code duplicated, block: B:155:0x0298 A[LOOP:4: B:153:0x0292->B:155:0x0298, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:22:0x007f  */
    public final <D extends d0.e0.p.d.m0.c.b> Collection<D> enhanceSignatures(d0.e0.p.d.m0.e.a.i0.g gVar, Collection<? extends D> collection) {
        d0.e0.p.d.m0.c.b bVar;
        l$a l_aEnhance$default;
        boolean z2;
        Pair<a$a<?>, ?> pair;
        c0 type;
        ArrayList arrayList;
        boolean z3;
        boolean z4;
        c0 type2;
        boolean zDeclaresDefaultValue;
        List<w> parametersInfo;
        String strSignature;
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(collection, "platformSignatures");
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.b bVarEnhance = (d0.e0.p.d.m0.c.b) it.next();
            if (bVarEnhance instanceof d0.e0.p.d.m0.e.a.h0.b) {
                d0.e0.p.d.m0.e.a.h0.b bVar2 = (d0.e0.p.d.m0.e.a.h0.b) bVarEnhance;
                if (bVar2.getKind() != b$a.FAKE_OVERRIDE || bVar2.getOriginal().getOverriddenDescriptors().size() != 1) {
                    d0.e0.p.d.m0.e.a.i0.g gVarCopyWithNewDefaultTypeQualifiers = d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(gVar, bVarEnhance.getAnnotations());
                    w wVar = null;
                    if (bVarEnhance instanceof d0.e0.p.d.m0.e.a.h0.g) {
                        d0.e0.p.d.m0.e.a.h0.g gVar2 = (d0.e0.p.d.m0.e.a.h0.g) bVarEnhance;
                        d0 getter = gVar2.getGetter();
                        if (d0.z.d.m.areEqual(getter == null ? null : Boolean.valueOf(getter.isDefault()), Boolean.FALSE)) {
                            d0 getter2 = gVar2.getGetter();
                            d0.z.d.m.checkNotNull(getter2);
                            bVar = getter2;
                        } else {
                            bVar = bVarEnhance;
                        }
                    } else {
                        bVar = bVarEnhance;
                    }
                    d0.e0.p.d.m0.e.a.h0.b bVar3 = (d0.e0.p.d.m0.e.a.h0.b) bVarEnhance;
                    if (bVar3.getExtensionReceiverParameter() != null) {
                        d0.e0.p.d.m0.c.x xVar = (d0.e0.p.d.m0.c.x) (!(bVar instanceof d0.e0.p.d.m0.c.x) ? null : bVar);
                        l_aEnhance$default = l$b.enhance$default(c(bVarEnhance, xVar == null ? null : (c1) xVar.getUserData(d0.e0.p.d.m0.e.a.h0.f.M), gVarCopyWithNewDefaultTypeQualifiers, n.j), null, 1, null);
                    } else {
                        l_aEnhance$default = null;
                    }
                    d0.e0.p.d.m0.e.a.h0.f fVar = bVarEnhance instanceof d0.e0.p.d.m0.e.a.h0.f ? (d0.e0.p.d.m0.e.a.h0.f) bVarEnhance : null;
                    k kVar = (fVar == null || (strSignature = d0.e0.p.d.m0.e.b.t.signature(d0.e0.p.d.m0.e.b.w.a, (d0.e0.p.d.m0.c.e) fVar.getContainingDeclaration(), d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(fVar, false, false, 3, null))) == null) ? null : j.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(strSignature);
                    if (kVar != null) {
                        kVar.getParametersInfo().size();
                        bVar3.getValueParameters().size();
                    }
                    List<c1> valueParameters = bVar.getValueParameters();
                    d0.z.d.m.checkNotNullExpressionValue(valueParameters, "annotationOwnerForMember.valueParameters");
                    ArrayList<l$c> arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(valueParameters, 10));
                    for (c1 c1Var : valueParameters) {
                        l$a l_aEnhance = c(bVarEnhance, c1Var, gVarCopyWithNewDefaultTypeQualifiers, new p(c1Var)).enhance((kVar == null || (parametersInfo = kVar.getParametersInfo()) == null) ? wVar : (w) d0.t.u.getOrNull(parametersInfo, c1Var.getIndex()));
                        if (l_aEnhance.getWereChanges()) {
                            type2 = l_aEnhance.getType();
                        } else {
                            type2 = c1Var.getType();
                            d0.z.d.m.checkNotNullExpressionValue(type2, "p.type");
                        }
                        d0.z.d.m.checkNotNullExpressionValue(c1Var, "p");
                        d0.e0.p.d.m0.e.a.h0.a defaultValueFromAnnotation = d0.e0.p.d.m0.e.a.h0.k.getDefaultValueFromAnnotation(c1Var);
                        if (defaultValueFromAnnotation instanceof d0.e0.p.d.m0.e.a.h0.j) {
                            zDeclaresDefaultValue = f0.lexicalCastFrom(type2, ((d0.e0.p.d.m0.e.a.h0.j) defaultValueFromAnnotation).getValue()) != null;
                        } else if (d0.z.d.m.areEqual(defaultValueFromAnnotation, d0.e0.p.d.m0.e.a.h0.h.a)) {
                            zDeclaresDefaultValue = e1.acceptsNullable(type2);
                        } else {
                            if (defaultValueFromAnnotation != null) {
                                throw new NoWhenBranchMatchedException();
                            }
                            zDeclaresDefaultValue = c1Var.declaresDefaultValue();
                        }
                        boolean z5 = zDeclaresDefaultValue && c1Var.getOverriddenDescriptors().isEmpty();
                        arrayList3.add(new l$c(l_aEnhance.getType(), z5, l_aEnhance.getWereChanges() || z5 != c1Var.declaresDefaultValue(), l_aEnhance.getContainsFunctionN()));
                        wVar = null;
                    }
                    n0 n0Var = (n0) (!(bVarEnhance instanceof n0) ? null : bVarEnhance);
                    Boolean boolValueOf = n0Var == null ? null : Boolean.valueOf(d0.e0.p.d.m0.e.a.i0.l.c.isJavaField(n0Var));
                    Boolean bool = Boolean.TRUE;
                    l$a l_aEnhance2 = b(bVarEnhance, bVar, true, gVarCopyWithNewDefaultTypeQualifiers, d0.z.d.m.areEqual(boolValueOf, bool) ? d0.e0.p.d.m0.e.a.a.FIELD : d0.e0.p.d.m0.e.a.a.METHOD_RETURN_TYPE, o.j).enhance(kVar == null ? null : kVar.getReturnTypeInfo());
                    if (d0.z.d.m.areEqual(l_aEnhance$default == null ? null : Boolean.valueOf(l_aEnhance$default.getContainsFunctionN()), bool) || l_aEnhance2.getContainsFunctionN()) {
                        z2 = true;
                    } else {
                        if (arrayList3.isEmpty()) {
                            z4 = false;
                            break;
                        }
                        Iterator it2 = arrayList3.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z4 = false;
                                break;
                            }
                            if (((l$c) it2.next()).getContainsFunctionN()) {
                                z4 = true;
                                break;
                            }
                        }
                        if (z4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    if (d0.z.d.m.areEqual(l_aEnhance$default == null ? null : Boolean.valueOf(l_aEnhance$default.getWereChanges()), Boolean.TRUE) || l_aEnhance2.getWereChanges()) {
                        if (z2) {
                            pair = d0.o.to(d0.e0.p.d.m0.k.w.a.getDEPRECATED_FUNCTION_KEY(), new d0.e0.p.d.m0.e.a.m(bVarEnhance));
                        } else {
                            pair = null;
                        }
                        if (l_aEnhance$default == null) {
                            type = null;
                        } else {
                            type = l_aEnhance$default.getType();
                        }
                        arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList3, 10));
                        for (l$c l_c : arrayList3) {
                            arrayList.add(new d0.e0.p.d.m0.e.a.h0.l(l_c.getType(), l_c.getHasDefaultValue()));
                        }
                        bVarEnhance = bVar3.enhance(type, arrayList, l_aEnhance2.getType(), pair);
                    } else {
                        if (arrayList3.isEmpty()) {
                            z3 = false;
                            break;
                        }
                        Iterator it3 = arrayList3.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z3 = false;
                                break;
                            }
                            if (((l$c) it3.next()).getWereChanges()) {
                                z3 = true;
                                break;
                            }
                        }
                        if (z3 || z2) {
                            if (z2) {
                                pair = d0.o.to(d0.e0.p.d.m0.k.w.a.getDEPRECATED_FUNCTION_KEY(), new d0.e0.p.d.m0.e.a.m(bVarEnhance));
                            } else {
                                pair = null;
                            }
                            if (l_aEnhance$default == null) {
                                type = null;
                            } else {
                                type = l_aEnhance$default.getType();
                            }
                            arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList3, 10));
                            while (r3.hasNext()) {
                                arrayList.add(new d0.e0.p.d.m0.e.a.h0.l(l_c.getType(), l_c.getHasDefaultValue()));
                            }
                            bVarEnhance = bVar3.enhance(type, arrayList, l_aEnhance2.getType(), pair);
                        }
                    }
                }
            }
            arrayList2.add(bVarEnhance);
        }
        return arrayList2;
    }

    public final c0 enhanceSuperType(c0 c0Var, d0.e0.p.d.m0.e.a.i0.g gVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        d0.z.d.m.checkNotNullParameter(gVar, "context");
        return l$b.enhance$default(new l$b(this, null, c0Var, d0.t.n.emptyList(), false, gVar, d0.e0.p.d.m0.e.a.a.TYPE_USE, false, 64, null), null, 1, null).getType();
    }

    public final List<c0> enhanceTypeParameterBounds(z0 z0Var, List<? extends c0> list, d0.e0.p.d.m0.e.a.i0.g gVar) {
        d0.z.d.m.checkNotNullParameter(z0Var, "typeParameter");
        d0.z.d.m.checkNotNullParameter(list, "bounds");
        d0.z.d.m.checkNotNullParameter(gVar, "context");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        for (c0 type : list) {
            if (!d0.e0.p.d.m0.n.o1.a.contains(type, l$d.j)) {
                type = l$b.enhance$default(new l$b(this, z0Var, type, d0.t.n.emptyList(), false, gVar, d0.e0.p.d.m0.e.a.a.TYPE_PARAMETER_BOUNDS, true), null, 1, null).getType();
            }
            arrayList.add(type);
        }
        return arrayList;
    }

    public final i extractNullability(d0.e0.p.d.m0.c.g1.c cVar, boolean z2, boolean z3) {
        i iVarA;
        d0.z.d.m.checkNotNullParameter(cVar, "annotationDescriptor");
        i iVarA2 = a(cVar, z2, z3);
        if (iVarA2 != null) {
            return iVarA2;
        }
        d0.e0.p.d.m0.c.g1.c cVarResolveTypeQualifierAnnotation = this.a.resolveTypeQualifierAnnotation(cVar);
        if (cVarResolveTypeQualifierAnnotation == null) {
            return null;
        }
        d0.e0.p.d.m0.p.h hVarResolveJsr305AnnotationState = this.a.resolveJsr305AnnotationState(cVar);
        if (hVarResolveJsr305AnnotationState.isIgnore() || (iVarA = a(cVarResolveTypeQualifierAnnotation, z2, z3)) == null) {
            return null;
        }
        return i.copy$default(iVarA, null, hVarResolveJsr305AnnotationState.isWarning(), 1, null);
    }
}
