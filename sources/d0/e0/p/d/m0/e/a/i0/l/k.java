package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.f0;
import d0.e0.p.d.m0.e.a.g0.g$a;
import d0.e0.p.d.m0.e.b.u;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.m.f$m;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends d0.e0.p.d.m0.k.a0.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3335b = {a0.property1(new y(a0.getOrCreateKotlinClass(k.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(k.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(k.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    public final d0.e0.p.d.m0.e.a.i0.g c;
    public final k d;
    public final d0.e0.p.d.m0.m.j<Collection<d0.e0.p.d.m0.c.m>> e;
    public final d0.e0.p.d.m0.m.j<b> f;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<t0>> g;
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.e, n0> h;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<t0>> i;
    public final d0.e0.p.d.m0.m.j j;
    public final d0.e0.p.d.m0.m.j k;
    public final d0.e0.p.d.m0.m.j l;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, List<n0>> m;

    public /* synthetic */ k(d0.e0.p.d.m0.e.a.i0.g gVar, k kVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, (i & 2) != 0 ? null : kVar);
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.i access$getDeclaredField$p(k kVar) {
        return kVar.h;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.h access$getDeclaredFunctions$p(k kVar) {
        return kVar.g;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0086  */
    public static final n0 access$resolveProperty(k kVar, d0.e0.p.d.m0.e.a.k0.n nVar) {
        boolean z2;
        Objects.requireNonNull(kVar);
        d0.e0.p.d.m0.e.a.h0.g gVarCreate = d0.e0.p.d.m0.e.a.h0.g.create(kVar.j(), d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(kVar.c, nVar), z.FINAL, f0.toDescriptorVisibility(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), kVar.c.getComponents().getSourceElementFactory().source(nVar), nVar.isFinal() && nVar.isStatic());
        d0.z.d.m.checkNotNullExpressionValue(gVarCreate, "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )");
        gVarCreate.initialize(null, null, null, null);
        c0 c0VarTransformJavaType = kVar.c.getTypeResolver().transformJavaType(nVar.getType(), d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, null, 3, null));
        if (d0.e0.p.d.m0.b.h.isPrimitiveType(c0VarTransformJavaType) || d0.e0.p.d.m0.b.h.isString(c0VarTransformJavaType)) {
            z2 = (nVar.isFinal() && nVar.isStatic()) && nVar.getHasConstantNotNullInitializer();
        }
        if (z2) {
            c0VarTransformJavaType = e1.makeNotNullable(c0VarTransformJavaType);
            d0.z.d.m.checkNotNullExpressionValue(c0VarTransformJavaType, "makeNotNullable(propertyType)");
        }
        gVarCreate.setType(c0VarTransformJavaType, d0.t.n.emptyList(), kVar.i(), null);
        if (d0.e0.p.d.m0.k.e.shouldRecordInitializerForProperty(gVarCreate, gVarCreate.getType())) {
            gVarCreate.setCompileTimeInitializer(kVar.c.getStorageManager().createNullableLazyValue(new l(kVar, nVar, gVarCreate)));
        }
        ((g$a) kVar.c.getComponents().getJavaResolverCache()).recordField(nVar, gVarCreate);
        return gVarCreate;
    }

    public static final void access$retainMostSpecificMethods(k kVar, Set set) {
        Objects.requireNonNull(kVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strComputeJvmDescriptor$default = u.computeJvmDescriptor$default((t0) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strComputeJvmDescriptor$default);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strComputeJvmDescriptor$default, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection collectionSelectMostSpecificInEachOverridableGroup = d0.e0.p.d.m0.k.p.selectMostSpecificInEachOverridableGroup(list, m.j);
                set.removeAll(list);
                set.addAll(collectionSelectMostSpecificInEachOverridableGroup);
            }
        }
    }

    public abstract Set<d0.e0.p.d.m0.g.e> a(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    public abstract Set<d0.e0.p.d.m0.g.e> b(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    public void c(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    public abstract b d();

    public final c0 e(d0.e0.p.d.m0.e.a.k0.r rVar, d0.e0.p.d.m0.e.a.i0.g gVar) {
        d0.z.d.m.checkNotNullParameter(rVar, "method");
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        return gVar.getTypeResolver().transformJavaType(rVar.getReturnType(), d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, rVar.getContainingClass().isAnnotationType(), null, 2, null));
    }

    public abstract void f(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar);

    public abstract void g(d0.e0.p.d.m0.g.e eVar, Collection<n0> collection);

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.l, this, (KProperty<?>) f3335b[2]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return this.e.invoke();
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getFunctionNames().contains(eVar) ? d0.t.n.emptyList() : (Collection) ((f$m) this.i).invoke(eVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getVariableNames().contains(eVar) ? d0.t.n.emptyList() : (Collection) ((f$m) this.m).invoke(eVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.j, this, (KProperty<?>) f3335b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.k, this, (KProperty<?>) f3335b[1]);
    }

    public abstract Set<d0.e0.p.d.m0.g.e> h(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    public abstract q0 i();

    public abstract d0.e0.p.d.m0.c.m j();

    public boolean k(d0.e0.p.d.m0.e.a.h0.f fVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "<this>");
        return true;
    }

    public abstract k$a l(d0.e0.p.d.m0.e.a.k0.r rVar, List<? extends z0> list, c0 c0Var, List<? extends c1> list2);

    public final d0.e0.p.d.m0.e.a.h0.f m(d0.e0.p.d.m0.e.a.k0.r rVar) {
        d0.z.d.m.checkNotNullParameter(rVar, "method");
        d0.e0.p.d.m0.e.a.h0.f fVarCreateJavaMethod = d0.e0.p.d.m0.e.a.h0.f.createJavaMethod(j(), d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(this.c, rVar), rVar.getName(), this.c.getComponents().getSourceElementFactory().source(rVar), this.f.invoke().findRecordComponentByName(rVar.getName()) != null && rVar.getValueParameters().isEmpty());
        d0.z.d.m.checkNotNullExpressionValue(fVarCreateJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        d0.e0.p.d.m0.e.a.i0.g gVarChildForMethod$default = d0.e0.p.d.m0.e.a.i0.a.childForMethod$default(this.c, fVarCreateJavaMethod, rVar, 0, 4, null);
        List<d0.e0.p.d.m0.e.a.k0.y> typeParameters = rVar.getTypeParameters();
        List<? extends z0> arrayList = new ArrayList<>(d0.t.o.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            z0 z0VarResolveTypeParameter = gVarChildForMethod$default.getTypeParameterResolver().resolveTypeParameter((d0.e0.p.d.m0.e.a.k0.y) it.next());
            d0.z.d.m.checkNotNull(z0VarResolveTypeParameter);
            arrayList.add(z0VarResolveTypeParameter);
        }
        k$b k_bN = n(gVarChildForMethod$default, fVarCreateJavaMethod, rVar.getValueParameters());
        k$a k_aL = l(rVar, arrayList, e(rVar, gVarChildForMethod$default), k_bN.getDescriptors());
        c0 receiverType = k_aL.getReceiverType();
        fVarCreateJavaMethod.initialize(receiverType == null ? null : d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(fVarCreateJavaMethod, receiverType, d0.e0.p.d.m0.c.g1.g.f.getEMPTY()), i(), k_aL.getTypeParameters(), k_aL.getValueParameters(), k_aL.getReturnType(), z.j.convertFromFlags(false, rVar.isAbstract(), !rVar.isFinal()), f0.toDescriptorVisibility(rVar.getVisibility()), k_aL.getReceiverType() != null ? g0.mapOf(d0.o.to(d0.e0.p.d.m0.e.a.h0.f.M, d0.t.u.first((List) k_bN.getDescriptors()))) : h0.emptyMap());
        fVarCreateJavaMethod.setParameterNamesStatus(k_aL.getHasStableParameterNames(), k_bN.getHasSynthesizedNames());
        if (!k_aL.getErrors().isEmpty()) {
            ((d0.e0.p.d.m0.e.a.g0.j$a) gVarChildForMethod$default.getComponents().getSignaturePropagator()).reportSignatureErrors(fVarCreateJavaMethod, k_aL.getErrors());
        }
        return fVarCreateJavaMethod;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0070  */
    /* JADX WARN: Code duplicated, block: B:44:0x0119  */
    /* JADX WARN: Code duplicated, block: B:46:0x011f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0122  */
    /* JADX WARN: Code duplicated, block: B:57:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public final k$b n(d0.e0.p.d.m0.e.a.i0.g gVar, x xVar, List<? extends d0.e0.p.d.m0.e.a.k0.a0> list) {
        String value;
        Pair pair;
        d0.e0.p.d.m0.g.e name;
        d0.e0.p.d.m0.e.a.i0.g gVar2 = gVar;
        d0.z.d.m.checkNotNullParameter(gVar2, "c");
        d0.z.d.m.checkNotNullParameter(xVar, "function");
        d0.z.d.m.checkNotNullParameter(list, "jValueParameters");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterable<d0.t.z> iterableWithIndex = d0.t.u.withIndex(list);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(iterableWithIndex, 10));
        boolean z2 = false;
        boolean z3 = false;
        for (d0.t.z zVar : iterableWithIndex) {
            int iComponent1 = zVar.component1();
            d0.e0.p.d.m0.e.a.k0.a0 a0Var = (d0.e0.p.d.m0.e.a.k0.a0) zVar.component2();
            d0.e0.p.d.m0.c.g1.g gVarResolveAnnotations = d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(gVar2, a0Var);
            d0.e0.p.d.m0.e.a.i0.m.a attributes$default = d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, z2, null, 3, null);
            d0.e0.p.d.m0.g.b bVar = d0.e0.p.d.m0.e.a.a0.q;
            d0.z.d.m.checkNotNullExpressionValue(bVar, "PARAMETER_NAME_FQ_NAME");
            d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = gVarResolveAnnotations.findAnnotation(bVar);
            d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = cVarFindAnnotation == null ? null : d0.e0.p.d.m0.k.x.a.firstArgument(cVarFindAnnotation);
            if (gVarFirstArgument != null) {
                if (!(gVarFirstArgument instanceof w)) {
                    gVarFirstArgument = null;
                }
                w wVar = (w) gVarFirstArgument;
                if (wVar == null) {
                    value = null;
                } else {
                    value = wVar.getValue();
                }
            } else {
                value = null;
            }
            if (a0Var.isVararg()) {
                d0.e0.p.d.m0.e.a.k0.x type = a0Var.getType();
                d0.e0.p.d.m0.e.a.k0.f fVar = type instanceof d0.e0.p.d.m0.e.a.k0.f ? (d0.e0.p.d.m0.e.a.k0.f) type : null;
                if (fVar == null) {
                    throw new AssertionError(d0.z.d.m.stringPlus("Vararg parameter should be an array: ", a0Var));
                }
                c0 c0VarTransformArrayType = gVar.getTypeResolver().transformArrayType(fVar, attributes$default, true);
                pair = d0.o.to(c0VarTransformArrayType, gVar.getModule().getBuiltIns().getArrayElementType(c0VarTransformArrayType));
            } else {
                pair = d0.o.to(gVar.getTypeResolver().transformJavaType(a0Var.getType(), attributes$default), null);
            }
            c0 c0Var = (c0) pair.component1();
            c0 c0Var2 = (c0) pair.component2();
            if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.c.i1.k) xVar).getName().asString(), "equals") && list.size() == 1 && d0.z.d.m.areEqual(gVar.getModule().getBuiltIns().getNullableAnyType(), c0Var)) {
                name = d0.e0.p.d.m0.g.e.identifier("other");
            } else if (value == null) {
                name = a0Var.getName();
                if (name == null) {
                    z3 = true;
                }
                if (name == null) {
                    name = d0.e0.p.d.m0.g.e.identifier(d0.z.d.m.stringPlus("p", Integer.valueOf(iComponent1)));
                    d0.z.d.m.checkNotNullExpressionValue(name, "identifier(\"p$index\")");
                }
            } else if ((value.length() > 0) && linkedHashSet.add(value)) {
                name = d0.e0.p.d.m0.g.e.identifier(value);
            } else {
                name = a0Var.getName();
                if (name == null) {
                    z3 = true;
                }
                if (name == null) {
                    name = d0.e0.p.d.m0.g.e.identifier(d0.z.d.m.stringPlus("p", Integer.valueOf(iComponent1)));
                    d0.z.d.m.checkNotNullExpressionValue(name, "identifier(\"p$index\")");
                }
            }
            d0.e0.p.d.m0.g.e eVar = name;
            d0.z.d.m.checkNotNullExpressionValue(eVar, "if (function.name.asString() == \"equals\" &&\n                jValueParameters.size == 1 &&\n                c.module.builtIns.nullableAnyType == outType\n            ) {\n                // This is a hack to prevent numerous warnings on Kotlin classes that inherit Java classes: if you override \"equals\" in such\n                // class without this hack, you'll be warned that in the superclass the name is \"p0\" (regardless of the fact that it's\n                // \"other\" in Any)\n                // TODO: fix Java parameter name loading logic somehow (don't always load \"p0\", \"p1\", etc.)\n                Name.identifier(\"other\")\n            } else if (parameterName != null && parameterName.isNotEmpty() && usedNames.add(parameterName)) {\n                Name.identifier(parameterName)\n            } else {\n                // TODO: parameter names may be drawn from attached sources, which is slow; it's better to make them lazy\n                val javaName = javaParameter.name\n                if (javaName == null) synthesizedNames = true\n                javaName ?: Name.identifier(\"p$index\")\n            }");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new l0(xVar, null, iComponent1, gVarResolveAnnotations, eVar, c0Var, false, false, false, c0Var2, gVar.getComponents().getSourceElementFactory().source(a0Var)));
            arrayList = arrayList2;
            z3 = z3;
            z2 = false;
            gVar2 = gVar;
        }
        return new k$b(d0.t.u.toList(arrayList), z3);
    }

    public String toString() {
        return d0.z.d.m.stringPlus("Lazy scope for ", j());
    }

    public k(d0.e0.p.d.m0.e.a.i0.g gVar, k kVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        this.c = gVar;
        this.d = kVar;
        this.e = gVar.getStorageManager().createRecursionTolerantLazyValue(new k$c(this), d0.t.n.emptyList());
        this.f = gVar.getStorageManager().createLazyValue(new k$g(this));
        this.g = gVar.getStorageManager().createMemoizedFunction(new k$f(this));
        this.h = gVar.getStorageManager().createMemoizedFunctionWithNullableValues(new k$e(this));
        this.i = gVar.getStorageManager().createMemoizedFunction(new k$i(this));
        this.j = gVar.getStorageManager().createLazyValue(new k$h(this));
        this.k = gVar.getStorageManager().createLazyValue(new k$k(this));
        this.l = gVar.getStorageManager().createLazyValue(new k$d(this));
        this.m = gVar.getStorageManager().createMemoizedFunction(new k$j(this));
    }
}
