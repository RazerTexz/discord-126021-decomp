package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.f.q$b;
import d0.e0.p.d.m0.f.q$b$c;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.m0;
import d0.e0.p.d.m0.n.n0;
import d0.e0.p.d.m0.n.o0;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import d0.t.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 {
    public final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3483b;
    public final String c;
    public final String d;
    public boolean e;
    public final Function1<Integer, d0.e0.p.d.m0.c.h> f;
    public final Function1<Integer, d0.e0.p.d.m0.c.h> g;
    public final Map<Integer, z0> h;

    public c0(l lVar, c0 c0Var, List<d0.e0.p.d.m0.f.s> list, String str, String str2, boolean z2) {
        Map<Integer, z0> linkedHashMap;
        d0.z.d.m.checkNotNullParameter(lVar, "c");
        d0.z.d.m.checkNotNullParameter(list, "typeParameterProtos");
        d0.z.d.m.checkNotNullParameter(str, "debugName");
        d0.z.d.m.checkNotNullParameter(str2, "containerPresentableName");
        this.a = lVar;
        this.f3483b = c0Var;
        this.c = str;
        this.d = str2;
        this.e = z2;
        this.f = lVar.getStorageManager().createMemoizedFunctionWithNullableValues(new c0$a(this));
        this.g = lVar.getStorageManager().createMemoizedFunctionWithNullableValues(new c0$c(this));
        if (list.isEmpty()) {
            linkedHashMap = h0.emptyMap();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            for (d0.e0.p.d.m0.f.s sVar : list) {
                linkedHashMap.put(Integer.valueOf(sVar.getId()), new d0.e0.p.d.m0.l.b.e0.m(this.a, sVar, i));
                i++;
            }
        }
        this.h = linkedHashMap;
    }

    public static final d0.e0.p.d.m0.c.h access$computeClassifierDescriptor(c0 c0Var, int i) {
        d0.e0.p.d.m0.g.a classId = w.getClassId(c0Var.a.getNameResolver(), i);
        return classId.isLocal() ? c0Var.a.getComponents().deserializeClass(classId) : d0.e0.p.d.m0.c.w.findClassifierAcrossModuleDependencies(c0Var.a.getComponents().getModuleDescriptor(), classId);
    }

    public static final d0.e0.p.d.m0.c.h access$computeTypeAliasDescriptor(c0 c0Var, int i) {
        d0.e0.p.d.m0.g.a classId = w.getClassId(c0Var.a.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return d0.e0.p.d.m0.c.w.findTypeAliasAcrossModuleDependencies(c0Var.a.getComponents().getModuleDescriptor(), classId);
    }

    public static final /* synthetic */ l access$getC$p(c0 c0Var) {
        return c0Var.a;
    }

    public static final List<q$b> c(d0.e0.p.d.m0.f.q qVar, c0 c0Var) {
        List<q$b> argumentList = qVar.getArgumentList();
        d0.z.d.m.checkNotNullExpressionValue(argumentList, "argumentList");
        d0.e0.p.d.m0.f.q qVarOuterType = d0.e0.p.d.m0.f.z.f.outerType(qVar, c0Var.a.getTypeTable());
        List<q$b> listC = qVarOuterType == null ? null : c(qVarOuterType, c0Var);
        if (listC == null) {
            listC = d0.t.n.emptyList();
        }
        return d0.t.u.plus((Collection) argumentList, (Iterable) listC);
    }

    public static final d0.e0.p.d.m0.c.e d(c0 c0Var, d0.e0.p.d.m0.f.q qVar, int i) {
        d0.e0.p.d.m0.g.a classId = w.getClassId(c0Var.a.getNameResolver(), i);
        List<Integer> mutableList = d0.f0.q.toMutableList(d0.f0.q.map(d0.f0.n.generateSequence(qVar, new c0$e(c0Var)), c0$f.j));
        int iCount = d0.f0.q.count(d0.f0.n.generateSequence(classId, c0$d.j));
        while (mutableList.size() < iCount) {
            mutableList.add(0);
        }
        return c0Var.a.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    public static /* synthetic */ j0 simpleType$default(c0 c0Var, d0.e0.p.d.m0.f.q qVar, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return c0Var.simpleType(qVar, z2);
    }

    public final j0 a(int i) {
        if (w.getClassId(this.a.getNameResolver(), i).isLocal()) {
            return this.a.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    public final j0 b(d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.n.c0 c0Var2) {
        d0.e0.p.d.m0.b.h builtIns = d0.e0.p.d.m0.n.o1.a.getBuiltIns(c0Var);
        d0.e0.p.d.m0.c.g1.g annotations = c0Var.getAnnotations();
        d0.e0.p.d.m0.n.c0 receiverTypeFromFunctionType = d0.e0.p.d.m0.b.g.getReceiverTypeFromFunctionType(c0Var);
        List listDropLast = d0.t.u.dropLast(d0.e0.p.d.m0.b.g.getValueParameterTypesFromFunctionType(c0Var), 1);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listDropLast, 10));
        Iterator it = listDropLast.iterator();
        while (it.hasNext()) {
            arrayList.add(((w0) it.next()).getType());
        }
        return d0.e0.p.d.m0.b.g.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, arrayList, null, c0Var2, true).makeNullableAsSpecified(c0Var.isMarkedNullable());
    }

    public final u0 e(int i) {
        z0 z0Var = this.h.get(Integer.valueOf(i));
        u0 typeConstructor = z0Var == null ? null : z0Var.getTypeConstructor();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        c0 c0Var = this.f3483b;
        if (c0Var == null) {
            return null;
        }
        return c0Var.e(i);
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.e;
    }

    public final List<z0> getOwnTypeParameters() {
        return d0.t.u.toList(this.h.values());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v42, types: [d0.e0.p.d.m0.c.h1.e] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v15, types: [d0.e0.p.d.m0.n.j0] */
    /* JADX WARN: Type inference failed for: r15v16, types: [d0.e0.p.d.m0.n.j0] */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    public final j0 simpleType(d0.e0.p.d.m0.f.q qVar, boolean z2) {
        u0 u0VarCreateErrorTypeConstructor;
        Object next;
        ?? SimpleType$default;
        int size;
        j0 j0VarWithAbbreviation;
        w0 y0Var;
        d0.z.d.m.checkNotNullParameter(qVar, "proto");
        Object objSimpleType$default = null;
        j0 j0VarA = qVar.hasClassName() ? a(qVar.getClassName()) : qVar.hasTypeAliasName() ? a(qVar.getTypeAliasName()) : null;
        if (j0VarA != null) {
            return j0VarA;
        }
        if (qVar.hasClassName()) {
            d0.e0.p.d.m0.c.h hVarInvoke = this.f.invoke(Integer.valueOf(qVar.getClassName()));
            if (hVarInvoke == null) {
                hVarInvoke = d(this, qVar, qVar.getClassName());
            }
            u0VarCreateErrorTypeConstructor = hVarInvoke.getTypeConstructor();
            d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor");
        } else if (qVar.hasTypeParameter()) {
            u0VarCreateErrorTypeConstructor = e(qVar.getTypeParameter());
            if (u0VarCreateErrorTypeConstructor == null) {
                StringBuilder sbU = b.d.b.a.a.U("Unknown type parameter ");
                sbU.append(qVar.getTypeParameter());
                sbU.append(". Please try recompiling module containing \"");
                sbU.append(this.d);
                sbU.append('\"');
                u0VarCreateErrorTypeConstructor = d0.e0.p.d.m0.n.t.createErrorTypeConstructor(sbU.toString());
                d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )");
            }
        } else if (qVar.hasTypeParameterName()) {
            d0.e0.p.d.m0.c.m containingDeclaration = this.a.getContainingDeclaration();
            String string = this.a.getNameResolver().getString(qVar.getTypeParameterName());
            Iterator it = getOwnTypeParameters().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!d0.z.d.m.areEqual(((z0) next).getName().asString(), string));
            z0 z0Var = (z0) next;
            u0 typeConstructor = z0Var == null ? null : z0Var.getTypeConstructor();
            u0VarCreateErrorTypeConstructor = typeConstructor == null ? d0.e0.p.d.m0.n.t.createErrorTypeConstructor("Deserialized type parameter " + string + " in " + containingDeclaration) : typeConstructor;
            d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }");
        } else if (qVar.hasTypeAliasName()) {
            d0.e0.p.d.m0.c.h hVarInvoke2 = this.g.invoke(Integer.valueOf(qVar.getTypeAliasName()));
            if (hVarInvoke2 == null) {
                hVarInvoke2 = d(this, qVar, qVar.getTypeAliasName());
            }
            u0VarCreateErrorTypeConstructor = hVarInvoke2.getTypeConstructor();
            d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor");
        } else {
            u0VarCreateErrorTypeConstructor = d0.e0.p.d.m0.n.t.createErrorTypeConstructor("Unknown type");
            d0.z.d.m.checkNotNullExpressionValue(u0VarCreateErrorTypeConstructor, "createErrorTypeConstructor(\"Unknown type\")");
        }
        if (d0.e0.p.d.m0.n.t.isError(u0VarCreateErrorTypeConstructor.getDeclarationDescriptor())) {
            j0 j0VarCreateErrorTypeWithCustomConstructor = d0.e0.p.d.m0.n.t.createErrorTypeWithCustomConstructor(u0VarCreateErrorTypeConstructor.toString(), u0VarCreateErrorTypeConstructor);
            d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorTypeWithCustomConstructor, "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)");
            return j0VarCreateErrorTypeWithCustomConstructor;
        }
        d0.e0.p.d.m0.l.b.e0.a aVar = new d0.e0.p.d.m0.l.b.e0.a(this.a.getStorageManager(), new c0$b(this, qVar));
        List<q$b> listC = c(qVar, this);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listC, 10));
        int i = 0;
        for (Object obj : listC) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            q$b q_b = (q$b) obj;
            List<z0> parameters = u0VarCreateErrorTypeConstructor.getParameters();
            d0.z.d.m.checkNotNullExpressionValue(parameters, "constructor.parameters");
            z0 z0Var2 = (z0) d0.t.u.getOrNull(parameters, i);
            if (q_b.getProjection() == q$b$c.STAR) {
                y0Var = z0Var2 == null ? new n0(this.a.getComponents().getModuleDescriptor().getBuiltIns()) : new o0(z0Var2);
            } else {
                z zVar = z.a;
                q$b$c projection = q_b.getProjection();
                d0.z.d.m.checkNotNullExpressionValue(projection, "typeArgumentProto.projection");
                j1 j1VarVariance = zVar.variance(projection);
                d0.e0.p.d.m0.f.q qVarType = d0.e0.p.d.m0.f.z.f.type(q_b, this.a.getTypeTable());
                y0Var = qVarType == null ? new y0(d0.e0.p.d.m0.n.t.createErrorType("No type recorded")) : new y0(j1VarVariance, type(qVarType));
            }
            arrayList.add(y0Var);
            i = i2;
        }
        List list = d0.t.u.toList(arrayList);
        d0.e0.p.d.m0.c.h declarationDescriptor = u0VarCreateErrorTypeConstructor.getDeclarationDescriptor();
        boolean z3 = true;
        if (z2 && (declarationDescriptor instanceof d0.e0.p.d.m0.c.y0)) {
            d0 d0Var = d0.a;
            j0 j0VarComputeExpandedType = d0.computeExpandedType((d0.e0.p.d.m0.c.y0) declarationDescriptor, list);
            if (!e0.isNullable(j0VarComputeExpandedType) && !qVar.getNullable()) {
                z3 = false;
            }
            SimpleType$default = j0VarComputeExpandedType.makeNullableAsSpecified(z3).replaceAnnotations(d0.e0.p.d.m0.c.g1.g.f.create(d0.t.u.plus((Iterable) aVar, (Iterable) j0VarComputeExpandedType.getAnnotations())));
        } else {
            Boolean bool = d0.e0.p.d.m0.f.z.b.a.get(qVar.getFlags());
            d0.z.d.m.checkNotNullExpressionValue(bool, "SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                boolean nullable = qVar.getNullable();
                int size2 = u0VarCreateErrorTypeConstructor.getParameters().size() - list.size();
                if (size2 == 0) {
                    d0 d0Var2 = d0.a;
                    j0 j0VarSimpleType$default = d0.simpleType$default(aVar, u0VarCreateErrorTypeConstructor, list, nullable, null, 16, null);
                    if (d0.e0.p.d.m0.b.g.isFunctionType(j0VarSimpleType$default)) {
                        boolean releaseCoroutines = this.a.getComponents().getConfiguration().getReleaseCoroutines();
                        w0 w0Var = (w0) d0.t.u.lastOrNull((List) d0.e0.p.d.m0.b.g.getValueParameterTypesFromFunctionType(j0VarSimpleType$default));
                        d0.e0.p.d.m0.n.c0 type = w0Var == null ? null : w0Var.getType();
                        if (type != null) {
                            d0.e0.p.d.m0.c.h declarationDescriptor2 = type.getConstructor().getDeclarationDescriptor();
                            d0.e0.p.d.m0.g.b fqNameSafe = declarationDescriptor2 == null ? null : d0.e0.p.d.m0.k.x.a.getFqNameSafe(declarationDescriptor2);
                            if (type.getArguments().size() == 1 && (d0.e0.p.d.m0.b.l.isContinuation(fqNameSafe, true) || d0.e0.p.d.m0.b.l.isContinuation(fqNameSafe, false))) {
                                d0.e0.p.d.m0.n.c0 type2 = ((w0) d0.t.u.single((List) type.getArguments())).getType();
                                d0.z.d.m.checkNotNullExpressionValue(type2, "continuationArgumentType.arguments.single().type");
                                d0.e0.p.d.m0.c.m containingDeclaration2 = this.a.getContainingDeclaration();
                                if (!(containingDeclaration2 instanceof d0.e0.p.d.m0.c.a)) {
                                    containingDeclaration2 = null;
                                }
                                d0.e0.p.d.m0.c.a aVar2 = (d0.e0.p.d.m0.c.a) containingDeclaration2;
                                if (d0.z.d.m.areEqual(aVar2 != null ? d0.e0.p.d.m0.k.x.a.fqNameOrNull(aVar2) : null, b0.a)) {
                                    j0VarSimpleType$default = b(j0VarSimpleType$default, type2);
                                } else {
                                    if (!this.e && (!releaseCoroutines || !d0.e0.p.d.m0.b.l.isContinuation(fqNameSafe, !releaseCoroutines))) {
                                        z3 = false;
                                    }
                                    this.e = z3;
                                    j0VarSimpleType$default = b(j0VarSimpleType$default, type2);
                                }
                            }
                            objSimpleType$default = j0VarSimpleType$default;
                        }
                    }
                } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
                    d0 d0Var3 = d0.a;
                    u0 typeConstructor2 = u0VarCreateErrorTypeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
                    d0.z.d.m.checkNotNullExpressionValue(typeConstructor2, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
                    objSimpleType$default = d0.simpleType$default(aVar, typeConstructor2, list, nullable, null, 16, null);
                }
                if (objSimpleType$default == null) {
                    j0 j0VarCreateErrorTypeWithArguments = d0.e0.p.d.m0.n.t.createErrorTypeWithArguments(d0.z.d.m.stringPlus("Bad suspend function in metadata with constructor: ", u0VarCreateErrorTypeConstructor), list);
                    d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorTypeWithArguments, "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
                    SimpleType$default = j0VarCreateErrorTypeWithArguments;
                } else {
                    SimpleType$default = objSimpleType$default;
                }
            } else {
                d0 d0Var4 = d0.a;
                SimpleType$default = d0.simpleType$default(aVar, u0VarCreateErrorTypeConstructor, list, qVar.getNullable(), null, 16, null);
            }
        }
        d0.e0.p.d.m0.f.q qVarAbbreviatedType = d0.e0.p.d.m0.f.z.f.abbreviatedType(qVar, this.a.getTypeTable());
        ?? r15 = SimpleType$default;
        if (qVarAbbreviatedType != null && (j0VarWithAbbreviation = m0.withAbbreviation(SimpleType$default, simpleType(qVarAbbreviatedType, false))) != null) {
            r15 = SimpleType$default;
            r15 = j0VarWithAbbreviation;
        }
        r15 = SimpleType$default;
        return qVar.hasClassName() ? this.a.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(w.getClassId(this.a.getNameResolver(), qVar.getClassName()), r15) : r15;
    }

    public String toString() {
        String str = this.c;
        c0 c0Var = this.f3483b;
        return d0.z.d.m.stringPlus(str, c0Var == null ? "" : d0.z.d.m.stringPlus(". Child of ", c0Var.c));
    }

    public final d0.e0.p.d.m0.n.c0 type(d0.e0.p.d.m0.f.q qVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "proto");
        if (!qVar.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(qVar, true);
        }
        String string = this.a.getNameResolver().getString(qVar.getFlexibleTypeCapabilitiesId());
        j0 j0VarSimpleType$default = simpleType$default(this, qVar, false, 2, null);
        d0.e0.p.d.m0.f.q qVarFlexibleUpperBound = d0.e0.p.d.m0.f.z.f.flexibleUpperBound(qVar, this.a.getTypeTable());
        d0.z.d.m.checkNotNull(qVarFlexibleUpperBound);
        return this.a.getComponents().getFlexibleTypeDeserializer().create(qVar, string, j0VarSimpleType$default, simpleType$default(this, qVarFlexibleUpperBound, false, 2, null));
    }

    public /* synthetic */ c0(l lVar, c0 c0Var, List list, String str, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lVar, c0Var, list, str, str2, (i & 32) != 0 ? false : z2);
    }
}
