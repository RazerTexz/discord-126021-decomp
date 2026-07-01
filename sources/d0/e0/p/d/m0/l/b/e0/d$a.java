package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.l.b.w;
import d0.e0.p.d.m0.n.c0;
import d0.t.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends h {
    public final d0.e0.p.d.m0.n.l1.g g;
    public final d0.e0.p.d.m0.m.j<Collection<d0.e0.p.d.m0.c.m>> h;
    public final d0.e0.p.d.m0.m.j<Collection<c0>> i;
    public final /* synthetic */ d j;

    public d$a(d dVar, d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(dVar, "this$0");
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        this.j = dVar;
        d0.e0.p.d.m0.l.b.l c = dVar.getC();
        List<d0.e0.p.d.m0.f.i> functionList = dVar.getClassProto().getFunctionList();
        d0.z.d.m.checkNotNullExpressionValue(functionList, "classProto.functionList");
        List<d0.e0.p.d.m0.f.n> propertyList = dVar.getClassProto().getPropertyList();
        d0.z.d.m.checkNotNullExpressionValue(propertyList, "classProto.propertyList");
        List<r> typeAliasList = dVar.getClassProto().getTypeAliasList();
        d0.z.d.m.checkNotNullExpressionValue(typeAliasList, "classProto.typeAliasList");
        List<Integer> nestedClassNameList = dVar.getClassProto().getNestedClassNameList();
        d0.z.d.m.checkNotNullExpressionValue(nestedClassNameList, "classProto.nestedClassNameList");
        d0.e0.p.d.m0.f.z.c nameResolver = dVar.getC().getNameResolver();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(nestedClassNameList, 10));
        Iterator<T> it = nestedClassNameList.iterator();
        while (it.hasNext()) {
            arrayList.add(w.getName(nameResolver, ((Number) it.next()).intValue()));
        }
        super(c, functionList, propertyList, typeAliasList, new d$a$a(arrayList));
        this.g = gVar;
        this.h = this.c.getStorageManager().createLazyValue(new d$a$b(this));
        this.i = this.c.getStorageManager().createLazyValue(new d$a$d(this));
    }

    public static final d access$getClassDescriptor(d$a d_a) {
        return d_a.j;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.n.l1.g access$getKotlinTypeRefiner$p(d$a d_a) {
        return d_a.g;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public void a(Collection<d0.e0.p.d.m0.c.m> collection, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        d$c d_cAccess$getEnumEntries$p = d.access$getEnumEntries$p(this.j);
        Collection<d0.e0.p.d.m0.c.e> collectionAll = d_cAccess$getEnumEntries$p == null ? null : d_cAccess$getEnumEntries$p.all();
        if (collectionAll == null) {
            collectionAll = d0.t.n.emptyList();
        }
        collection.addAll(collectionAll);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public void c(d0.e0.p.d.m0.g.e eVar, List<t0> list) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(list, "functions");
        ArrayList arrayList = new ArrayList();
        Iterator<c0> it = this.i.invoke().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getMemberScope().getContributedFunctions(eVar, d0.e0.p.d.m0.d.b.d.FOR_ALREADY_TRACKED));
        }
        list.addAll(this.c.getComponents().getAdditionalClassPartsProvider().getFunctions(eVar, this.j));
        k(eVar, arrayList, list);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public void d(d0.e0.p.d.m0.g.e eVar, List<n0> list) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(list, "descriptors");
        ArrayList arrayList = new ArrayList();
        Iterator<c0> it = this.i.invoke().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getMemberScope().getContributedVariables(eVar, d0.e0.p.d.m0.d.b.d.FOR_ALREADY_TRACKED));
        }
        k(eVar, arrayList, list);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public d0.e0.p.d.m0.g.a e(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.e0.p.d.m0.g.a aVarCreateNestedClassId = d.access$getClassId$p(this.j).createNestedClassId(eVar);
        d0.z.d.m.checkNotNullExpressionValue(aVarCreateNestedClassId, "classId.createNestedClassId(name)");
        return aVarCreateNestedClassId;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public Set<d0.e0.p.d.m0.g.e> f() {
        List<c0> supertypes = d.access$getTypeConstructor$p(this.j).getSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            Set<d0.e0.p.d.m0.g.e> classifierNames = ((c0) it.next()).getMemberScope().getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            d0.t.r.addAll(linkedHashSet, classifierNames);
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public Set<d0.e0.p.d.m0.g.e> g() {
        List<c0> supertypes = d.access$getTypeConstructor$p(this.j).getSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            d0.t.r.addAll(linkedHashSet, ((c0) it.next()).getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(this.c.getComponents().getAdditionalClassPartsProvider().getFunctionsNames(this.j));
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.e0.p.d.m0.c.e eVarFindEnumEntry;
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        d$c d_cAccess$getEnumEntries$p = d.access$getEnumEntries$p(this.j);
        return (d_cAccess$getEnumEntries$p == null || (eVarFindEnumEntry = d_cAccess$getEnumEntries$p.findEnumEntry(eVar)) == null) ? super.getContributedClassifier(eVar, bVar) : eVarFindEnumEntry;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return this.h.invoke();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        return super.getContributedFunctions(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        return super.getContributedVariables(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public Set<d0.e0.p.d.m0.g.e> h() {
        List<c0> supertypes = d.access$getTypeConstructor$p(this.j).getSupertypes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            d0.t.r.addAll(linkedHashSet, ((c0) it.next()).getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.h
    public boolean j(t0 t0Var) {
        d0.z.d.m.checkNotNullParameter(t0Var, "function");
        return this.c.getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.j, t0Var);
    }

    public final <D extends d0.e0.p.d.m0.c.b> void k(d0.e0.p.d.m0.g.e eVar, Collection<? extends D> collection, List<D> list) {
        this.c.getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(eVar, collection, new ArrayList(list), this.j, new d$a$c(list));
    }

    public void recordLookup(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        d0.e0.p.d.m0.d.a.record(this.c.getComponents().getLookupTracker(), bVar, this.j, eVar);
    }
}
