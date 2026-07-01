package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.t.r;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3456b = {a0.property1(new y(a0.getOrCreateKotlinClass(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    public final d0.e0.p.d.m0.c.e c;
    public final d0.e0.p.d.m0.m.j d;

    public e(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(eVar, "containingClass");
        this.c = eVar;
        this.d = oVar.createLazyValue(new e$a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [d0.e0.p.d.m0.k.k] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Collection] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final List access$createFakeOverrides(e eVar, List list) {
        ?? EmptyList;
        Objects.requireNonNull(eVar);
        ArrayList arrayList = new ArrayList(3);
        Collection<c0> supertypes = eVar.c.getTypeConstructor().getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = supertypes.iterator();
        while (it.hasNext()) {
            r.addAll(arrayList2, l$a.getContributedDescriptors$default(((c0) it.next()).getMemberScope(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof d0.e0.p.d.m0.c.b) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            d0.e0.p.d.m0.g.e name = ((d0.e0.p.d.m0.c.b) obj2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        for (Map$Entry map$Entry : linkedHashMap.entrySet()) {
            d0.e0.p.d.m0.g.e eVar2 = (d0.e0.p.d.m0.g.e) map$Entry.getKey();
            List list2 = (List) map$Entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((d0.e0.p.d.m0.c.b) obj3) instanceof x);
                Object arrayList5 = linkedHashMap2.get(boolValueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            for (Map$Entry map$Entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) map$Entry2.getKey()).booleanValue();
                List list3 = (List) map$Entry2.getValue();
                ?? r4 = d0.e0.p.d.m0.k.k.f3468b;
                if (zBooleanValue) {
                    EmptyList = new ArrayList();
                    for (Object obj4 : list) {
                        if (d0.z.d.m.areEqual(((x) obj4).getName(), eVar2)) {
                            EmptyList.add(obj4);
                        }
                    }
                } else {
                    EmptyList = d0.t.n.emptyList();
                }
                r4.generateOverridesInFunctionGroup(eVar2, list3, EmptyList, eVar.c, new f(arrayList, eVar));
            }
        }
        return d0.e0.p.d.m0.p.a.compact(arrayList);
    }

    public abstract List<x> a();

    public final List<d0.e0.p.d.m0.c.m> b() {
        return (List) d0.e0.p.d.m0.m.n.getValue(this.d, this, (KProperty<?>) f3456b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return !dVar.acceptsKinds(d.n.getKindMask()) ? d0.t.n.emptyList() : b();
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List<d0.e0.p.d.m0.c.m> listB = b();
        d0.e0.p.d.m0.p.i iVar = new d0.e0.p.d.m0.p.i();
        for (Object obj : listB) {
            if ((obj instanceof t0) && d0.z.d.m.areEqual(((t0) obj).getName(), eVar)) {
                iVar.add(obj);
            }
        }
        return iVar;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List<d0.e0.p.d.m0.c.m> listB = b();
        d0.e0.p.d.m0.p.i iVar = new d0.e0.p.d.m0.p.i();
        for (Object obj : listB) {
            if ((obj instanceof n0) && d0.z.d.m.areEqual(((n0) obj).getName(), eVar)) {
                iVar.add(obj);
            }
        }
        return iVar;
    }
}
