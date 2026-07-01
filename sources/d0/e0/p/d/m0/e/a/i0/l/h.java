package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.e0;
import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.x$a;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.e.a.d0;
import d0.e0.p.d.m0.e.a.f0;
import d0.e0.p.d.m0.e.a.g0.g$a;
import d0.e0.p.d.m0.e.a.k0.w;
import d0.e0.p.d.m0.e.a.k0.x;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.e.a.z;
import d0.e0.p.d.m0.k.k$d$a;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import d0.t.o0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends k {
    public final d0.e0.p.d.m0.c.e n;
    public final d0.e0.p.d.m0.e.a.k0.g o;
    public final boolean p;
    public final d0.e0.p.d.m0.m.j<List<d0.e0.p.d.m0.c.d>> q;
    public final d0.e0.p.d.m0.m.j<Set<d0.e0.p.d.m0.g.e>> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.j<Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.e.a.k0.n>> f3332s;
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.c.i1.h> t;

    public /* synthetic */ h(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.e.a.k0.g gVar2, boolean z2, h hVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, eVar, gVar2, z2, (i & 16) != 0 ? null : hVar);
    }

    public static final d0.e0.p.d.m0.c.d access$createDefaultConstructor(h hVar) {
        List<c1> listEmptyList;
        Pair pair;
        boolean zIsAnnotationType = hVar.o.isAnnotationType();
        if ((hVar.o.isInterface() || !hVar.o.hasDefaultConstructor()) && !zIsAnnotationType) {
            return null;
        }
        d0.e0.p.d.m0.c.e eVar = hVar.n;
        d0.e0.p.d.m0.e.a.h0.c cVarCreateJavaConstructor = d0.e0.p.d.m0.e.a.h0.c.createJavaConstructor(eVar, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), true, hVar.c.getComponents().getSourceElementFactory().source(hVar.o));
        d0.z.d.m.checkNotNullExpressionValue(cVarCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        if (zIsAnnotationType) {
            Collection<d0.e0.p.d.m0.e.a.k0.r> methods = hVar.o.getMethods();
            listEmptyList = new ArrayList<>(methods.size());
            d0.e0.p.d.m0.e.a.i0.m.a attributes$default = d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, true, null, 2, null);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : methods) {
                if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.e.a.k0.r) obj).getName(), a0.f3305b)) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            }
            Pair pair2 = new Pair(arrayList, arrayList2);
            List list = (List) pair2.component1();
            List<d0.e0.p.d.m0.e.a.k0.r> list2 = (List) pair2.component2();
            list.size();
            d0.e0.p.d.m0.e.a.k0.r rVar = (d0.e0.p.d.m0.e.a.k0.r) u.firstOrNull(list);
            if (rVar != null) {
                x returnType = rVar.getReturnType();
                if (returnType instanceof d0.e0.p.d.m0.e.a.k0.f) {
                    d0.e0.p.d.m0.e.a.k0.f fVar = (d0.e0.p.d.m0.e.a.k0.f) returnType;
                    pair = new Pair(hVar.c.getTypeResolver().transformArrayType(fVar, attributes$default, true), hVar.c.getTypeResolver().transformJavaType(fVar.getComponentType(), attributes$default));
                } else {
                    pair = new Pair(hVar.c.getTypeResolver().transformJavaType(returnType, attributes$default), null);
                }
                hVar.o(listEmptyList, cVarCreateJavaConstructor, 0, rVar, (c0) pair.component1(), (c0) pair.component2());
            }
            int i = rVar != null ? 1 : 0;
            int i2 = 0;
            for (d0.e0.p.d.m0.e.a.k0.r rVar2 : list2) {
                hVar.o(listEmptyList, cVarCreateJavaConstructor, i2 + i, rVar2, hVar.c.getTypeResolver().transformJavaType(rVar2.getReturnType(), attributes$default), null);
                i2++;
            }
        } else {
            listEmptyList = Collections.emptyList();
        }
        cVarCreateJavaConstructor.setHasSynthesizedParameterNames(false);
        cVarCreateJavaConstructor.initialize(listEmptyList, hVar.B(eVar));
        cVarCreateJavaConstructor.setHasStableParameterNames(true);
        cVarCreateJavaConstructor.setReturnType(eVar.getDefaultType());
        ((g$a) hVar.c.getComponents().getJavaResolverCache()).recordConstructor(hVar.o, cVarCreateJavaConstructor);
        return cVarCreateJavaConstructor;
    }

    public static final d0.e0.p.d.m0.c.d access$createDefaultRecordConstructor(h hVar) {
        d0.e0.p.d.m0.c.e eVar = hVar.n;
        d0.e0.p.d.m0.e.a.h0.c cVarCreateJavaConstructor = d0.e0.p.d.m0.e.a.h0.c.createJavaConstructor(eVar, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), true, hVar.c.getComponents().getSourceElementFactory().source(hVar.o));
        d0.z.d.m.checkNotNullExpressionValue(cVarCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        Collection<w> recordComponents = hVar.o.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        c0 c0Var = null;
        d0.e0.p.d.m0.e.a.i0.m.a attributes$default = d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, null, 2, null);
        int i = 0;
        for (w wVar : recordComponents) {
            int i2 = i + 1;
            c0 c0VarTransformJavaType = hVar.c.getTypeResolver().transformJavaType(wVar.getType(), attributes$default);
            arrayList.add(new l0(cVarCreateJavaConstructor, null, i, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), wVar.getName(), c0VarTransformJavaType, false, false, false, wVar.isVararg() ? hVar.c.getComponents().getModule().getBuiltIns().getArrayElementType(c0VarTransformJavaType) : c0Var, hVar.c.getComponents().getSourceElementFactory().source(wVar)));
            i = i2;
            attributes$default = attributes$default;
            c0Var = c0Var;
        }
        cVarCreateJavaConstructor.setHasSynthesizedParameterNames(false);
        cVarCreateJavaConstructor.initialize(arrayList, hVar.B(eVar));
        cVarCreateJavaConstructor.setHasStableParameterNames(false);
        cVarCreateJavaConstructor.setReturnType(eVar.getDefaultType());
        return cVarCreateJavaConstructor;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.j access$getEnumEntryIndex$p(h hVar) {
        return hVar.f3332s;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.k0.g access$getJClass$p(h hVar) {
        return hVar.o;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.j access$getNestedClassIndex$p(h hVar) {
        return hVar.r;
    }

    public static final d0.e0.p.d.m0.e.a.h0.c access$resolveConstructor(h hVar, d0.e0.p.d.m0.e.a.k0.k kVar) {
        d0.e0.p.d.m0.c.e eVar = hVar.n;
        d0.e0.p.d.m0.e.a.h0.c cVarCreateJavaConstructor = d0.e0.p.d.m0.e.a.h0.c.createJavaConstructor(eVar, d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(hVar.c, kVar), false, hVar.c.getComponents().getSourceElementFactory().source(kVar));
        d0.z.d.m.checkNotNullExpressionValue(cVarCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor,\n            c.resolveAnnotations(constructor), /* isPrimary = */\n            false,\n            c.components.sourceElementFactory.source(constructor)\n        )");
        d0.e0.p.d.m0.e.a.i0.g gVarChildForMethod = d0.e0.p.d.m0.e.a.i0.a.childForMethod(hVar.c, cVarCreateJavaConstructor, kVar, eVar.getDeclaredTypeParameters().size());
        k$b k_bN = hVar.n(gVarChildForMethod, cVarCreateJavaConstructor, kVar.getValueParameters());
        List<z0> declaredTypeParameters = eVar.getDeclaredTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
        List<y> typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            z0 z0VarResolveTypeParameter = gVarChildForMethod.getTypeParameterResolver().resolveTypeParameter((y) it.next());
            d0.z.d.m.checkNotNull(z0VarResolveTypeParameter);
            arrayList.add(z0VarResolveTypeParameter);
        }
        cVarCreateJavaConstructor.initialize(k_bN.getDescriptors(), f0.toDescriptorVisibility(kVar.getVisibility()), u.plus((Collection) declaredTypeParameters, (Iterable) arrayList));
        cVarCreateJavaConstructor.setHasStableParameterNames(false);
        cVarCreateJavaConstructor.setHasSynthesizedParameterNames(k_bN.getHasSynthesizedNames());
        cVarCreateJavaConstructor.setReturnType(eVar.getDefaultType());
        ((g$a) gVarChildForMethod.getComponents().getJavaResolverCache()).recordConstructor(kVar, cVarCreateJavaConstructor);
        return cVarCreateJavaConstructor;
    }

    public static final Collection access$searchMethodsByNameWithoutBuiltinMagic(h hVar, d0.e0.p.d.m0.g.e eVar) {
        Collection<d0.e0.p.d.m0.e.a.k0.r> collectionFindMethodsByName = hVar.f.invoke().findMethodsByName(eVar);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(collectionFindMethodsByName, 10));
        Iterator<T> it = collectionFindMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(hVar.m((d0.e0.p.d.m0.e.a.k0.r) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    public static final Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(h hVar, d0.e0.p.d.m0.g.e eVar) {
        boolean z2;
        Set<t0> setC = hVar.C(eVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setC) {
            t0 t0Var = (t0) obj;
            if (d0.doesOverrideBuiltinWithDifferentJvmName(t0Var)) {
                z2 = true;
            } else {
                d0.e0.p.d.m0.e.a.h hVar2 = d0.e0.p.d.m0.e.a.h.m;
                if (d0.e0.p.d.m0.e.a.h.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(t0Var) != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (!z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final t0 A(n0 n0Var, Function1<? super d0.e0.p.d.m0.g.e, ? extends Collection<? extends t0>> function1) {
        t0 t0Var;
        c0 returnType;
        z zVar = z.a;
        String strAsString = n0Var.getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(z.setterName(strAsString));
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = function1.invoke(eVarIdentifier).iterator();
        do {
            t0Var = null;
            if (!it.hasNext()) {
                break;
            }
            t0 t0Var2 = (t0) it.next();
            if (t0Var2.getValueParameters().size() == 1 && (returnType = t0Var2.getReturnType()) != null && d0.e0.p.d.m0.b.h.isUnit(returnType)) {
                d0.e0.p.d.m0.n.l1.f fVar = d0.e0.p.d.m0.n.l1.f.a;
                List<c1> valueParameters = t0Var2.getValueParameters();
                d0.z.d.m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
                if (fVar.equalTypes(((c1) u.single((List) valueParameters)).getType(), n0Var.getType())) {
                    t0Var = t0Var2;
                }
            }
        } while (t0Var == null);
        return t0Var;
    }

    public final d0.e0.p.d.m0.c.u B(d0.e0.p.d.m0.c.e eVar) {
        d0.e0.p.d.m0.c.u visibility = eVar.getVisibility();
        d0.z.d.m.checkNotNullExpressionValue(visibility, "classDescriptor.visibility");
        if (!d0.z.d.m.areEqual(visibility, d0.e0.p.d.m0.e.a.w.f3359b)) {
            return visibility;
        }
        d0.e0.p.d.m0.c.u uVar = d0.e0.p.d.m0.e.a.w.c;
        d0.z.d.m.checkNotNullExpressionValue(uVar, "PROTECTED_AND_PACKAGE");
        return uVar;
    }

    public final Set<t0> C(d0.e0.p.d.m0.g.e eVar) {
        Collection<c0> collectionS = s();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = collectionS.iterator();
        while (it.hasNext()) {
            d0.t.r.addAll(linkedHashSet, ((c0) it.next()).getMemberScope().getContributedFunctions(eVar, d0.e0.p.d.m0.d.b.d.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    public final Set<n0> D(d0.e0.p.d.m0.g.e eVar) {
        Collection<c0> collectionS = s();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionS.iterator();
        while (it.hasNext()) {
            Collection<? extends n0> contributedVariables = ((c0) it.next()).getMemberScope().getContributedVariables(eVar, d0.e0.p.d.m0.d.b.d.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(contributedVariables, 10));
            Iterator<T> it2 = contributedVariables.iterator();
            while (it2.hasNext()) {
                arrayList2.add((n0) it2.next());
            }
            d0.t.r.addAll(arrayList, arrayList2);
        }
        return u.toSet(arrayList);
    }

    public final boolean E(t0 t0Var, d0.e0.p.d.m0.c.x xVar) {
        String strComputeJvmDescriptor$default = d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(t0Var, false, false, 2, null);
        d0.e0.p.d.m0.c.x original = xVar.getOriginal();
        d0.z.d.m.checkNotNullExpressionValue(original, "builtinWithErasedParameters.original");
        return d0.z.d.m.areEqual(strComputeJvmDescriptor$default, d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(original, false, false, 2, null)) && !w(t0Var, xVar);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:25:0x0071  */
    /* JADX WARN: Code duplicated, block: B:60:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x016d  */
    public final boolean F(t0 t0Var) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        d0.e0.p.d.m0.g.e name = t0Var.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "function.name");
        List<d0.e0.p.d.m0.g.e> propertyNamesCandidatesByAccessorName = d0.e0.p.d.m0.e.a.c0.getPropertyNamesCandidatesByAccessorName(name);
        if (!(propertyNamesCandidatesByAccessorName instanceof Collection) || !propertyNamesCandidatesByAccessorName.isEmpty()) {
            Iterator<T> it = propertyNamesCandidatesByAccessorName.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z4 = false;
                    break;
                }
                Set<n0> setD = D((d0.e0.p.d.m0.g.e) it.next());
                if (!(setD instanceof Collection) || !setD.isEmpty()) {
                    Iterator<T> it2 = setD.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z3 = false;
                            break;
                        }
                        n0 n0Var = (n0) it2.next();
                        if (v(n0Var, new h$g(t0Var, this))) {
                            if (!n0Var.isVar()) {
                                z zVar = z.a;
                                String strAsString = t0Var.getName().asString();
                                d0.z.d.m.checkNotNullExpressionValue(strAsString, "function.name.asString()");
                                if (z.isSetterName(strAsString)) {
                                    z2 = false;
                                }
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            z3 = true;
                            break;
                        }
                    }
                } else {
                    z3 = false;
                    break;
                    break;
                }
                if (z3) {
                    z4 = true;
                    break;
                }
            }
        } else {
            z4 = false;
            break;
        }
        if (z4) {
            return false;
        }
        d0.e0.p.d.m0.e.a.g gVar = d0.e0.p.d.m0.e.a.g.m;
        d0.e0.p.d.m0.g.e name2 = t0Var.getName();
        d0.z.d.m.checkNotNullExpressionValue(name2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<d0.e0.p.d.m0.g.e> builtinFunctionNamesByJvmName = gVar.getBuiltinFunctionNamesByJvmName(name2);
        if (!(builtinFunctionNamesByJvmName instanceof Collection) || !builtinFunctionNamesByJvmName.isEmpty()) {
            Iterator<T> it3 = builtinFunctionNamesByJvmName.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z6 = false;
                    break;
                }
                d0.e0.p.d.m0.g.e eVar = (d0.e0.p.d.m0.g.e) it3.next();
                Set<t0> setC = C(eVar);
                ArrayList arrayList = new ArrayList();
                for (Object obj : setC) {
                    if (d0.doesOverrideBuiltinWithDifferentJvmName((t0) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    z5 = false;
                    break;
                }
                x$a<? extends t0> x_aNewCopyBuilder = t0Var.newCopyBuilder();
                x_aNewCopyBuilder.setName(eVar);
                x_aNewCopyBuilder.setSignatureChange();
                x_aNewCopyBuilder.setPreserveSourceElement();
                d0.e0.p.d.m0.c.x xVar = (t0) x_aNewCopyBuilder.build();
                d0.z.d.m.checkNotNull(xVar);
                if (arrayList.isEmpty()) {
                    z5 = false;
                    break;
                    break;
                }
                Iterator it4 = arrayList.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z5 = false;
                        break;
                        break;
                    }
                    if (x((t0) it4.next(), xVar)) {
                        z5 = true;
                        break;
                    }
                }
                if (z5) {
                    z6 = true;
                    break;
                }
            }
        } else {
            z6 = false;
            break;
        }
        if (!z6) {
            d0.e0.p.d.m0.e.a.h hVar = d0.e0.p.d.m0.e.a.h.m;
            d0.e0.p.d.m0.g.e name3 = t0Var.getName();
            d0.z.d.m.checkNotNullExpressionValue(name3, ModelAuditLogEntry.CHANGE_KEY_NAME);
            if (!hVar.getSameAsBuiltinMethodWithErasedValueParameters(name3)) {
                z7 = false;
                break;
            }
            d0.e0.p.d.m0.g.e name4 = t0Var.getName();
            d0.z.d.m.checkNotNullExpressionValue(name4, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Set<t0> setC2 = C(name4);
            ArrayList arrayList2 = new ArrayList();
            for (t0 t0Var2 : setC2) {
                d0.e0.p.d.m0.e.a.h hVar2 = d0.e0.p.d.m0.e.a.h.m;
                d0.e0.p.d.m0.c.x overriddenBuiltinFunctionWithErasedValueParametersInJava = d0.e0.p.d.m0.e.a.h.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(t0Var2);
                if (overriddenBuiltinFunctionWithErasedValueParametersInJava != null) {
                    arrayList2.add(overriddenBuiltinFunctionWithErasedValueParametersInJava);
                }
            }
            if (arrayList2.isEmpty()) {
                z7 = false;
                break;
            }
            Iterator it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z7 = false;
                    break;
                }
                if (E(t0Var, (d0.e0.p.d.m0.c.x) it5.next())) {
                    z7 = true;
                    break;
                }
            }
            if (!z7) {
                t0 t0VarU = u(t0Var);
                if (t0VarU == null) {
                    z8 = false;
                } else {
                    d0.e0.p.d.m0.g.e name5 = t0Var.getName();
                    d0.z.d.m.checkNotNullExpressionValue(name5, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    Set<t0> setC3 = C(name5);
                    if (setC3.isEmpty()) {
                        z8 = false;
                    } else {
                        for (t0 t0Var3 : setC3) {
                            if (t0Var3.isSuspend() && w(t0VarU, t0Var3)) {
                                z8 = true;
                            }
                        }
                        z8 = false;
                    }
                }
                if (!z8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> a(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        return o0.plus((Set) this.r.invoke(), (Iterable) this.f3332s.invoke().keySet());
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set b(d0.e0.p.d.m0.k.a0.d dVar, Function1 function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        Collection<c0> supertypes = this.n.getTypeConstructor().getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            d0.t.r.addAll(linkedHashSet, ((c0) it.next()).getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(this.f.invoke().getMethodNames());
        linkedHashSet.addAll(this.f.invoke().getRecordComponentNames());
        linkedHashSet.addAll(a(dVar, function1));
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public void c(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar) {
        boolean z2;
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!this.o.isRecord() || this.f.invoke().findRecordComponentByName(eVar) == null) {
            return;
        }
        if (!collection.isEmpty()) {
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                } else if (((t0) it.next()).getValueParameters().isEmpty()) {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            w wVarFindRecordComponentByName = this.f.invoke().findRecordComponentByName(eVar);
            d0.z.d.m.checkNotNull(wVarFindRecordComponentByName);
            d0.e0.p.d.m0.e.a.h0.f fVarCreateJavaMethod = d0.e0.p.d.m0.e.a.h0.f.createJavaMethod(this.n, d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(this.c, wVarFindRecordComponentByName), wVarFindRecordComponentByName.getName(), this.c.getComponents().getSourceElementFactory().source(wVarFindRecordComponentByName), true);
            d0.z.d.m.checkNotNullExpressionValue(fVarCreateJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, recordComponent.name, c.components.sourceElementFactory.source(recordComponent), true\n        )");
            fVarCreateJavaMethod.initialize(null, i(), d0.t.n.emptyList(), d0.t.n.emptyList(), this.c.getTypeResolver().transformJavaType(wVarFindRecordComponentByName.getType(), d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, null, 2, null)), d0.e0.p.d.m0.c.z.j.convertFromFlags(false, false, true), t.e, null);
            fVarCreateJavaMethod.setParameterNamesStatus(false, false);
            ((g$a) this.c.getComponents().getJavaResolverCache()).recordMethod(wVarFindRecordComponentByName, fVarCreateJavaMethod);
            collection.add(fVarCreateJavaMethod);
        }
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public b d() {
        return new a(this.o, g.j);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public void f(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar) {
        boolean z2;
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Set<t0> setC = C(eVar);
        if (!d0.e0.p.d.m0.e.a.g.m.getSameAsRenamedInJvmBuiltin(eVar) && !d0.e0.p.d.m0.e.a.h.m.getSameAsBuiltinMethodWithErasedValueParameters(eVar)) {
            if (setC.isEmpty()) {
                z2 = true;
                break;
            }
            Iterator<T> it = setC.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((d0.e0.p.d.m0.c.x) it.next()).isSuspend()) {
                        z2 = false;
                        break;
                    }
                } else {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : setC) {
                    if (F((t0) obj)) {
                        arrayList.add(obj);
                    }
                }
                p(collection, eVar, arrayList, false);
                return;
            }
        }
        Collection<t0> collectionCreate = d0.e0.p.d.m0.p.j.j.create();
        Collection<? extends t0> collectionResolveOverridesForNonStaticMembers = d0.e0.p.d.m0.e.a.g0.a.resolveOverridesForNonStaticMembers(eVar, setC, d0.t.n.emptyList(), this.n, d0.e0.p.d.m0.l.b.p.a, this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        d0.z.d.m.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, emptyList(), ownerDescriptor, ErrorReporter.DO_NOTHING,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        q(eVar, collection, collectionResolveOverridesForNonStaticMembers, collection, new h$a(this));
        q(eVar, collection, collectionResolveOverridesForNonStaticMembers, collectionCreate, new h$b(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setC) {
            if (F((t0) obj2)) {
                arrayList2.add(obj2);
            }
        }
        p(collection, eVar, u.plus((Collection) arrayList2, (Iterable) collectionCreate), true);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public void g(d0.e0.p.d.m0.g.e eVar, Collection<n0> collection) {
        d0.e0.p.d.m0.e.a.k0.r rVar;
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(collection, "result");
        if (this.o.isAnnotationType() && (rVar = (d0.e0.p.d.m0.e.a.k0.r) u.singleOrNull(this.f.invoke().findMethodsByName(eVar))) != null) {
            d0.e0.p.d.m0.e.a.h0.g gVarCreate = d0.e0.p.d.m0.e.a.h0.g.create(this.n, d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(this.c, rVar), d0.e0.p.d.m0.c.z.FINAL, f0.toDescriptorVisibility(rVar.getVisibility()), false, rVar.getName(), this.c.getComponents().getSourceElementFactory().source(rVar), false);
            d0.z.d.m.checkNotNullExpressionValue(gVarCreate, "create(\n            ownerDescriptor, annotations, modality, method.visibility.toDescriptorVisibility(),\n            /* isVar = */ false, method.name, c.components.sourceElementFactory.source(method),\n            /* isStaticFinal = */ false\n        )");
            d0.e0.p.d.m0.c.i1.d0 d0VarCreateDefaultGetter = d0.e0.p.d.m0.k.d.createDefaultGetter(gVarCreate, d0.e0.p.d.m0.c.g1.g.f.getEMPTY());
            d0.z.d.m.checkNotNullExpressionValue(d0VarCreateDefaultGetter, "createDefaultGetter(propertyDescriptor, Annotations.EMPTY)");
            gVarCreate.initialize(d0VarCreateDefaultGetter, null);
            c0 c0VarE = e(rVar, d0.e0.p.d.m0.e.a.i0.a.childForMethod$default(this.c, gVarCreate, rVar, 0, 4, null));
            gVarCreate.setType(c0VarE, d0.t.n.emptyList(), i(), null);
            d0VarCreateDefaultGetter.initialize(c0VarE);
            collection.add(gVarCreate);
        }
        Set<n0> setD = D(eVar);
        if (setD.isEmpty()) {
            return;
        }
        d0.e0.p.d.m0.p.j$b j_b = d0.e0.p.d.m0.p.j.j;
        d0.e0.p.d.m0.p.j jVarCreate = j_b.create();
        d0.e0.p.d.m0.p.j jVarCreate2 = j_b.create();
        r(setD, collection, jVarCreate, new h$c(this));
        r(o0.minus((Set) setD, (Iterable) jVarCreate), jVarCreate2, null, new h$d(this));
        Collection<? extends n0> collectionResolveOverridesForNonStaticMembers = d0.e0.p.d.m0.e.a.g0.a.resolveOverridesForNonStaticMembers(eVar, o0.plus((Set) setD, (Iterable) jVarCreate2), collection, this.n, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        d0.z.d.m.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n                name,\n                propertiesFromSupertypes + propertiesOverridesFromSuperTypes,\n                result,\n                ownerDescriptor,\n                c.components.errorReporter,\n                c.components.kotlinTypeChecker.overridingUtil\n            )");
        collection.addAll(collectionResolveOverridesForNonStaticMembers);
    }

    public final d0.e0.p.d.m0.m.j<List<d0.e0.p.d.m0.c.d>> getConstructors$descriptors_jvm() {
        return this.q;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.c.i1.h> iVar;
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        h hVar = (h) this.d;
        d0.e0.p.d.m0.c.i1.h hVarInvoke = null;
        if (hVar != null && (iVar = hVar.t) != null) {
            hVarInvoke = iVar.invoke(eVar);
        }
        return hVarInvoke == null ? this.t.invoke(eVar) : hVarInvoke;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        return super.getContributedFunctions(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        return super.getContributedVariables(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> h(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        if (this.o.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f.invoke().getFieldNames());
        Collection<c0> supertypes = this.n.getTypeConstructor().getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            d0.t.r.addAll(linkedHashSet, ((c0) it.next()).getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public q0 i() {
        return d0.e0.p.d.m0.k.e.getDispatchReceiverParameterIfNeeded(this.n);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public d0.e0.p.d.m0.c.m j() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public boolean k(d0.e0.p.d.m0.e.a.h0.f fVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "<this>");
        if (this.o.isAnnotationType()) {
            return false;
        }
        return F(fVar);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public k$a l(d0.e0.p.d.m0.e.a.k0.r rVar, List<? extends z0> list, c0 c0Var, List<? extends c1> list2) {
        d0.z.d.m.checkNotNullParameter(rVar, "method");
        d0.z.d.m.checkNotNullParameter(list, "methodTypeParameters");
        d0.z.d.m.checkNotNullParameter(c0Var, "returnType");
        d0.z.d.m.checkNotNullParameter(list2, "valueParameters");
        d0.e0.p.d.m0.e.a.g0.j$b j_bResolvePropagatedSignature = ((d0.e0.p.d.m0.e.a.g0.j$a) this.c.getComponents().getSignaturePropagator()).resolvePropagatedSignature(rVar, this.n, c0Var, null, list2, list);
        d0.z.d.m.checkNotNullExpressionValue(j_bResolvePropagatedSignature, "c.components.signaturePropagator.resolvePropagatedSignature(\n            method, ownerDescriptor, returnType, null, valueParameters, methodTypeParameters\n        )");
        c0 returnType = j_bResolvePropagatedSignature.getReturnType();
        d0.z.d.m.checkNotNullExpressionValue(returnType, "propagated.returnType");
        c0 receiverType = j_bResolvePropagatedSignature.getReceiverType();
        List<c1> valueParameters = j_bResolvePropagatedSignature.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "propagated.valueParameters");
        List<z0> typeParameters = j_bResolvePropagatedSignature.getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "propagated.typeParameters");
        boolean zHasStableParameterNames = j_bResolvePropagatedSignature.hasStableParameterNames();
        List<String> errors = j_bResolvePropagatedSignature.getErrors();
        d0.z.d.m.checkNotNullExpressionValue(errors, "propagated.errors");
        return new k$a(returnType, receiverType, valueParameters, typeParameters, zHasStableParameterNames, errors);
    }

    public final void o(List<c1> list, d0.e0.p.d.m0.c.l lVar, int i, d0.e0.p.d.m0.e.a.k0.r rVar, c0 c0Var, c0 c0Var2) {
        d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        d0.e0.p.d.m0.g.e name = rVar.getName();
        c0 c0VarMakeNotNullable = e1.makeNotNullable(c0Var);
        d0.z.d.m.checkNotNullExpressionValue(c0VarMakeNotNullable, "makeNotNullable(returnType)");
        list.add(new l0(lVar, null, i, empty, name, c0VarMakeNotNullable, rVar.getHasAnnotationParameterDefaultValue(), false, false, c0Var2 == null ? null : e1.makeNotNullable(c0Var2), this.c.getComponents().getSourceElementFactory().source(rVar)));
    }

    public final void p(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar, Collection<? extends t0> collection2, boolean z2) {
        Collection<? extends t0> collectionResolveOverridesForNonStaticMembers = d0.e0.p.d.m0.e.a.g0.a.resolveOverridesForNonStaticMembers(eVar, collection2, collection, this.n, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        d0.z.d.m.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, result, ownerDescriptor, c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        if (!z2) {
            collection.addAll(collectionResolveOverridesForNonStaticMembers);
            return;
        }
        List listPlus = u.plus((Collection) collection, (Iterable) collectionResolveOverridesForNonStaticMembers);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(collectionResolveOverridesForNonStaticMembers, 10));
        for (t0 t0VarT : collectionResolveOverridesForNonStaticMembers) {
            t0 t0Var = (t0) d0.getOverriddenSpecialBuiltin(t0VarT);
            if (t0Var == null) {
                d0.z.d.m.checkNotNullExpressionValue(t0VarT, "resolvedOverride");
            } else {
                d0.z.d.m.checkNotNullExpressionValue(t0VarT, "resolvedOverride");
                t0VarT = t(t0VarT, t0Var, listPlus);
            }
            arrayList.add(t0VarT);
        }
        collection.addAll(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x010f  */
    public final void q(d0.e0.p.d.m0.g.e eVar, Collection<? extends t0> collection, Collection<? extends t0> collection2, Collection<t0> collection3, Function1<? super d0.e0.p.d.m0.g.e, ? extends Collection<? extends t0>> function1) {
        t0 t0VarT;
        t0 t0VarT2;
        t0 t0VarU;
        Object next;
        t0 t0Var;
        for (t0 t0Var2 : collection2) {
            t0 t0Var3 = (t0) d0.getOverriddenBuiltinWithDifferentJvmName(t0Var2);
            if (t0Var3 == null) {
                t0VarT = null;
            } else {
                String jvmMethodNameIfSpecial = d0.getJvmMethodNameIfSpecial(t0Var3);
                d0.z.d.m.checkNotNull(jvmMethodNameIfSpecial);
                d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(jvmMethodNameIfSpecial);
                d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(nameInJava)");
                Iterator<? extends t0> it = function1.invoke(eVarIdentifier).iterator();
                while (true) {
                    if (it.hasNext()) {
                        x$a<? extends t0> x_aNewCopyBuilder = it.next().newCopyBuilder();
                        x_aNewCopyBuilder.setName(eVar);
                        x_aNewCopyBuilder.setSignatureChange();
                        x_aNewCopyBuilder.setPreserveSourceElement();
                        t0 t0Var4 = (t0) x_aNewCopyBuilder.build();
                        d0.z.d.m.checkNotNull(t0Var4);
                        if (x(t0Var3, t0Var4)) {
                            t0VarT = t(t0Var4, t0Var3, collection);
                        }
                    } else {
                        t0VarT = null;
                    }
                }
            }
            d0.e0.p.d.m0.p.a.addIfNotNull(collection3, t0VarT);
            d0.e0.p.d.m0.e.a.h hVar = d0.e0.p.d.m0.e.a.h.m;
            d0.e0.p.d.m0.c.x overriddenBuiltinFunctionWithErasedValueParametersInJava = d0.e0.p.d.m0.e.a.h.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(t0Var2);
            if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null) {
                t0VarT2 = null;
            } else {
                d0.e0.p.d.m0.g.e name = overriddenBuiltinFunctionWithErasedValueParametersInJava.getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "overridden.name");
                Iterator<T> it2 = function1.invoke(name).iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!E((t0) next, overriddenBuiltinFunctionWithErasedValueParametersInJava));
                t0 t0Var5 = (t0) next;
                if (t0Var5 == null) {
                    t0Var = null;
                } else {
                    x$a<? extends t0> x_aNewCopyBuilder2 = t0Var5.newCopyBuilder();
                    List<c1> valueParameters = overriddenBuiltinFunctionWithErasedValueParametersInJava.getValueParameters();
                    d0.z.d.m.checkNotNullExpressionValue(valueParameters, "overridden.valueParameters");
                    ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(valueParameters, 10));
                    for (c1 c1Var : valueParameters) {
                        c0 type = c1Var.getType();
                        d0.z.d.m.checkNotNullExpressionValue(type, "it.type");
                        arrayList.add(new d0.e0.p.d.m0.e.a.h0.l(type, c1Var.declaresDefaultValue()));
                    }
                    List<c1> valueParameters2 = t0Var5.getValueParameters();
                    d0.z.d.m.checkNotNullExpressionValue(valueParameters2, "override.valueParameters");
                    x_aNewCopyBuilder2.setValueParameters(d0.e0.p.d.m0.e.a.h0.k.copyValueParameters(arrayList, valueParameters2, overriddenBuiltinFunctionWithErasedValueParametersInJava));
                    x_aNewCopyBuilder2.setSignatureChange();
                    x_aNewCopyBuilder2.setPreserveSourceElement();
                    t0Var = (t0) x_aNewCopyBuilder2.build();
                }
                if (t0Var != null) {
                    if (!F(t0Var)) {
                        t0Var = null;
                    }
                    if (t0Var == null) {
                        t0VarT2 = null;
                    } else {
                        t0VarT2 = t(t0Var, overriddenBuiltinFunctionWithErasedValueParametersInJava, collection);
                    }
                } else {
                    t0VarT2 = null;
                }
            }
            d0.e0.p.d.m0.p.a.addIfNotNull(collection3, t0VarT2);
            if (!t0Var2.isSuspend()) {
                t0VarU = null;
                break;
            }
            d0.e0.p.d.m0.g.e name2 = t0Var2.getName();
            d0.z.d.m.checkNotNullExpressionValue(name2, "descriptor.name");
            Iterator<T> it3 = function1.invoke(name2).iterator();
            do {
                if (!it3.hasNext()) {
                    t0VarU = null;
                    break;
                    break;
                } else {
                    t0VarU = u((t0) it3.next());
                    if (t0VarU == null || !w(t0VarU, t0Var2)) {
                        t0VarU = null;
                    }
                }
            } while (t0VarU == null);
            d0.e0.p.d.m0.p.a.addIfNotNull(collection3, t0VarU);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(Set<? extends n0> set, Collection<n0> collection, Set<n0> set2, Function1<? super d0.e0.p.d.m0.g.e, ? extends Collection<? extends t0>> function1) {
        t0 t0VarA;
        d0.e0.p.d.m0.c.i1.d0 d0Var;
        for (n0 n0Var : set) {
            d0.e0.p.d.m0.e.a.h0.e eVar = null;
            p0 p0Var = null;
            if (v(n0Var, function1)) {
                t0 t0VarZ = z(n0Var, function1);
                d0.z.d.m.checkNotNull(t0VarZ);
                if (n0Var.isVar()) {
                    t0VarA = A(n0Var, function1);
                    d0.z.d.m.checkNotNull(t0VarA);
                } else {
                    t0VarA = null;
                }
                if (t0VarA != null) {
                    t0VarA.getModality();
                    t0VarZ.getModality();
                }
                d0.e0.p.d.m0.e.a.h0.e eVar2 = new d0.e0.p.d.m0.e.a.h0.e(this.n, t0VarZ, t0VarA, n0Var);
                c0 returnType = t0VarZ.getReturnType();
                d0.z.d.m.checkNotNull(returnType);
                eVar2.setType(returnType, d0.t.n.emptyList(), i(), null);
                d0.e0.p.d.m0.c.i1.d0 d0VarCreateGetter = d0.e0.p.d.m0.k.d.createGetter(eVar2, t0VarZ.getAnnotations(), false, false, false, t0VarZ.getSource());
                d0VarCreateGetter.setInitialSignatureDescriptor(t0VarZ);
                d0VarCreateGetter.initialize(eVar2.getType());
                d0.z.d.m.checkNotNullExpressionValue(d0VarCreateGetter, "createGetter(\n            propertyDescriptor, getterMethod.annotations, /* isDefault = */false,\n            /* isExternal = */ false, /* isInline = */ false, getterMethod.source\n        ).apply {\n            initialSignatureDescriptor = getterMethod\n            initialize(propertyDescriptor.type)\n        }");
                if (t0VarA != null) {
                    List<c1> valueParameters = t0VarA.getValueParameters();
                    d0.z.d.m.checkNotNullExpressionValue(valueParameters, "setterMethod.valueParameters");
                    c1 c1Var = (c1) u.firstOrNull((List) valueParameters);
                    if (c1Var == null) {
                        throw new AssertionError(d0.z.d.m.stringPlus("No parameter found for ", t0VarA));
                    }
                    e0 e0VarCreateSetter = d0.e0.p.d.m0.k.d.createSetter(eVar2, t0VarA.getAnnotations(), c1Var.getAnnotations(), false, false, false, t0VarA.getVisibility(), t0VarA.getSource());
                    e0VarCreateSetter.setInitialSignatureDescriptor(t0VarA);
                    p0Var = e0VarCreateSetter;
                    d0Var = d0VarCreateGetter;
                } else {
                    d0Var = d0VarCreateGetter;
                }
                eVar2.initialize(d0Var, p0Var);
                eVar = eVar2;
            }
            if (eVar != null) {
                collection.add(eVar);
                if (set2 == null) {
                    return;
                }
                ((d0.e0.p.d.m0.p.j) set2).add(n0Var);
                return;
            }
        }
    }

    public void recordLookup(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        d0.e0.p.d.m0.d.a.record(this.c.getComponents().getLookupTracker(), bVar, this.n, eVar);
    }

    public final Collection<c0> s() {
        if (!this.p) {
            return this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(this.n);
        }
        Collection<c0> supertypes = this.n.getTypeConstructor().getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        return supertypes;
    }

    public final t0 t(t0 t0Var, d0.e0.p.d.m0.c.a aVar, Collection<? extends t0> collection) {
        boolean z2 = true;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            for (t0 t0Var2 : collection) {
                if (!d0.z.d.m.areEqual(t0Var, t0Var2) && t0Var2.getInitialSignatureDescriptor() == null && w(t0Var2, aVar)) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return t0Var;
        }
        t0 t0Var3 = (t0) t0Var.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        d0.z.d.m.checkNotNull(t0Var3);
        return t0Var3;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public String toString() {
        return d0.z.d.m.stringPlus("Lazy Java member scope for ", this.o.getFqName());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:4:0x0012  */
    public final t0 u(t0 t0Var) {
        d0.e0.p.d.m0.g.b safe;
        List<c1> valueParameters = t0Var.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "valueParameters");
        c1 c1Var = (c1) u.lastOrNull((List) valueParameters);
        if (c1Var != null) {
            d0.e0.p.d.m0.c.h declarationDescriptor = c1Var.getType().getConstructor().getDeclarationDescriptor();
            d0.e0.p.d.m0.g.c fqNameUnsafe = declarationDescriptor == null ? null : d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(declarationDescriptor);
            if (fqNameUnsafe != null) {
                if (!fqNameUnsafe.isSafe()) {
                    fqNameUnsafe = null;
                }
                if (fqNameUnsafe == null) {
                    safe = null;
                } else {
                    safe = fqNameUnsafe.toSafe();
                }
            } else {
                safe = null;
            }
            if (!d0.e0.p.d.m0.b.l.isContinuation(safe, this.c.getComponents().getSettings().isReleaseCoroutines())) {
                c1Var = null;
            }
        } else {
            c1Var = null;
        }
        if (c1Var == null) {
            return null;
        }
        x$a<? extends t0> x_aNewCopyBuilder = t0Var.newCopyBuilder();
        List<c1> valueParameters2 = t0Var.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters2, "valueParameters");
        t0 t0Var2 = (t0) x_aNewCopyBuilder.setValueParameters(u.dropLast(valueParameters2, 1)).setReturnType(c1Var.getType().getArguments().get(0).getType()).build();
        g0 g0Var = (g0) t0Var2;
        if (g0Var != null) {
            g0Var.setSuspend(true);
        }
        return t0Var2;
    }

    public final boolean v(n0 n0Var, Function1<? super d0.e0.p.d.m0.g.e, ? extends Collection<? extends t0>> function1) {
        if (c.isJavaField(n0Var)) {
            return false;
        }
        t0 t0VarZ = z(n0Var, function1);
        t0 t0VarA = A(n0Var, function1);
        if (t0VarZ == null) {
            return false;
        }
        if (n0Var.isVar()) {
            return t0VarA != null && t0VarA.getModality() == t0VarZ.getModality();
        }
        return true;
    }

    public final boolean w(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
        k$d$a result = d0.e0.p.d.m0.k.k.f3468b.isOverridableByWithoutExternalConditions(aVar2, aVar, true).getResult();
        d0.z.d.m.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, this, true).result");
        return result == k$d$a.OVERRIDABLE && !d0.e0.p.d.m0.e.a.x.a.doesJavaOverrideHaveIncompatibleValueParameterKinds(aVar2, aVar);
    }

    public final boolean x(t0 t0Var, d0.e0.p.d.m0.c.x xVar) {
        if (d0.e0.p.d.m0.e.a.g.m.isRemoveAtByIndex(t0Var)) {
            xVar = xVar.getOriginal();
        }
        d0.z.d.m.checkNotNullExpressionValue(xVar, "if (superDescriptor.isRemoveAtByIndex) subDescriptor.original else subDescriptor");
        return w(xVar, t0Var);
    }

    public final t0 y(n0 n0Var, String str, Function1<? super d0.e0.p.d.m0.g.e, ? extends Collection<? extends t0>> function1) {
        t0 t0Var;
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str);
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(getterName)");
        Iterator<T> it = function1.invoke(eVarIdentifier).iterator();
        do {
            t0Var = null;
            if (!it.hasNext()) {
                break;
            }
            t0 t0Var2 = (t0) it.next();
            if (t0Var2.getValueParameters().size() == 0) {
                d0.e0.p.d.m0.n.l1.f fVar = d0.e0.p.d.m0.n.l1.f.a;
                c0 returnType = t0Var2.getReturnType();
                if (returnType == null ? false : fVar.isSubtypeOf(returnType, n0Var.getType())) {
                    t0Var = t0Var2;
                }
            }
        } while (t0Var == null);
        return t0Var;
    }

    public final t0 z(n0 n0Var, Function1<? super d0.e0.p.d.m0.g.e, ? extends Collection<? extends t0>> function1) {
        d0.e0.p.d.m0.c.o0 getter = n0Var.getGetter();
        d0.e0.p.d.m0.c.o0 o0Var = getter == null ? null : (d0.e0.p.d.m0.c.o0) d0.getOverriddenBuiltinWithDifferentJvmName(getter);
        String builtinSpecialPropertyGetterName = o0Var != null ? d0.e0.p.d.m0.e.a.k.a.getBuiltinSpecialPropertyGetterName(o0Var) : null;
        if (builtinSpecialPropertyGetterName != null && !d0.hasRealKotlinSuperClassWithOverrideOf(this.n, o0Var)) {
            return y(n0Var, builtinSpecialPropertyGetterName, function1);
        }
        z zVar = z.a;
        String strAsString = n0Var.getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return y(n0Var, z.getterName(strAsString), function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.e.a.k0.g gVar2, boolean z2, h hVar) {
        super(gVar, hVar);
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(eVar, "ownerDescriptor");
        d0.z.d.m.checkNotNullParameter(gVar2, "jClass");
        this.n = eVar;
        this.o = gVar2;
        this.p = z2;
        this.q = gVar.getStorageManager().createLazyValue(new h$e(this, gVar));
        this.r = gVar.getStorageManager().createLazyValue(new h$h(this));
        this.f3332s = gVar.getStorageManager().createLazyValue(new h$f(this));
        this.t = gVar.getStorageManager().createMemoizedFunctionWithNullableValues(new h$i(this, gVar));
    }
}
