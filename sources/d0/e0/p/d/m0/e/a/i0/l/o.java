package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.t.n0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends r {
    public final d0.e0.p.d.m0.e.a.k0.g n;
    public final f o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.k0.g gVar2, f fVar) {
        super(gVar);
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(gVar2, "jClass");
        d0.z.d.m.checkNotNullParameter(fVar, "ownerDescriptor");
        this.n = gVar2;
        this.o = fVar;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> a(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> b(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        Set<d0.e0.p.d.m0.g.e> mutableSet = u.toMutableSet(this.f.invoke().getMethodNames());
        o parentJavaStaticClassScope = d0.e0.p.d.m0.e.a.h0.k.getParentJavaStaticClassScope(this.o);
        Set<d0.e0.p.d.m0.g.e> functionNames = parentJavaStaticClassScope == null ? null : parentJavaStaticClassScope.getFunctionNames();
        if (functionNames == null) {
            functionNames = n0.emptySet();
        }
        mutableSet.addAll(functionNames);
        if (this.n.isEnum()) {
            mutableSet.addAll(d0.t.n.listOf((Object[]) new d0.e0.p.d.m0.g.e[]{d0.e0.p.d.m0.b.k.c, d0.e0.p.d.m0.b.k.f3215b}));
        }
        return mutableSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public b d() {
        return new a(this.n, n.j);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public void f(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        o parentJavaStaticClassScope = d0.e0.p.d.m0.e.a.h0.k.getParentJavaStaticClassScope(this.o);
        Collection<? extends t0> collectionResolveOverridesForStaticMembers = d0.e0.p.d.m0.e.a.g0.a.resolveOverridesForStaticMembers(eVar, parentJavaStaticClassScope == null ? n0.emptySet() : u.toSet(parentJavaStaticClassScope.getContributedFunctions(eVar, d0.e0.p.d.m0.d.b.d.WHEN_GET_SUPER_MEMBERS)), collection, this.o, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        d0.z.d.m.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(collectionResolveOverridesForStaticMembers);
        if (this.n.isEnum()) {
            if (d0.z.d.m.areEqual(eVar, d0.e0.p.d.m0.b.k.c)) {
                t0 t0VarCreateEnumValueOfMethod = d0.e0.p.d.m0.k.d.createEnumValueOfMethod(this.o);
                d0.z.d.m.checkNotNullExpressionValue(t0VarCreateEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(t0VarCreateEnumValueOfMethod);
            } else if (d0.z.d.m.areEqual(eVar, d0.e0.p.d.m0.b.k.f3215b)) {
                t0 t0VarCreateEnumValuesMethod = d0.e0.p.d.m0.k.d.createEnumValuesMethod(this.o);
                d0.z.d.m.checkNotNullExpressionValue(t0VarCreateEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(t0VarCreateEnumValuesMethod);
            }
        }
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.r, d0.e0.p.d.m0.e.a.i0.l.k
    public void g(d0.e0.p.d.m0.g.e eVar, Collection<d0.e0.p.d.m0.c.n0> collection) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(collection, "result");
        f fVar = this.o;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        d0.e0.p.d.m0.p.b.dfs(d0.t.m.listOf(fVar), p.a, new q(fVar, linkedHashSet, new o$a(eVar)));
        if (!collection.isEmpty()) {
            Collection<? extends d0.e0.p.d.m0.c.n0> collectionResolveOverridesForStaticMembers = d0.e0.p.d.m0.e.a.g0.a.resolveOverridesForStaticMembers(eVar, linkedHashSet, collection, this.o, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
            d0.z.d.m.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(collectionResolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : linkedHashSet) {
            d0.e0.p.d.m0.c.n0 n0VarO = o((d0.e0.p.d.m0.c.n0) obj);
            Object arrayList = linkedHashMap.get(n0VarO);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(n0VarO, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection collectionResolveOverridesForStaticMembers2 = d0.e0.p.d.m0.e.a.g0.a.resolveOverridesForStaticMembers(eVar, (Collection) ((Map$Entry) it.next()).getValue(), collection, this.o, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
            d0.z.d.m.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            d0.t.r.addAll(arrayList2, collectionResolveOverridesForStaticMembers2);
        }
        collection.addAll(arrayList2);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> h(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        Set<d0.e0.p.d.m0.g.e> mutableSet = u.toMutableSet(this.f.invoke().getFieldNames());
        f fVar = this.o;
        d0.e0.p.d.m0.p.b.dfs(d0.t.m.listOf(fVar), p.a, new q(fVar, mutableSet, o$b.j));
        return mutableSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public d0.e0.p.d.m0.c.m j() {
        return this.o;
    }

    public final d0.e0.p.d.m0.c.n0 o(d0.e0.p.d.m0.c.n0 n0Var) {
        if (n0Var.getKind().isReal()) {
            return n0Var;
        }
        Collection<? extends d0.e0.p.d.m0.c.n0> overriddenDescriptors = n0Var.getOverriddenDescriptors();
        d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (d0.e0.p.d.m0.c.n0 n0Var2 : overriddenDescriptors) {
            d0.z.d.m.checkNotNullExpressionValue(n0Var2, "it");
            arrayList.add(o(n0Var2));
        }
        return (d0.e0.p.d.m0.c.n0) u.single(u.distinct(arrayList));
    }
}
