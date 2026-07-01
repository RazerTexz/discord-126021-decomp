package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.k.a0.l$a;
import d0.e0.p.d.m0.l.b.w;
import d0.e0.p.d.m0.n.c0;
import d0.t.g0;
import d0.t.o;
import d0.t.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$c {
    public final Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.f.g> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.c.e> f3491b;
    public final d0.e0.p.d.m0.m.j<Set<d0.e0.p.d.m0.g.e>> c;
    public final /* synthetic */ d d;

    public d$c(d dVar) {
        d0.z.d.m.checkNotNullParameter(dVar, "this$0");
        this.d = dVar;
        List<d0.e0.p.d.m0.f.g> enumEntryList = dVar.getClassProto().getEnumEntryList();
        d0.z.d.m.checkNotNullExpressionValue(enumEntryList, "classProto.enumEntryList");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(enumEntryList, 10)), 16));
        for (Object obj : enumEntryList) {
            linkedHashMap.put(w.getName(dVar.getC().getNameResolver(), ((d0.e0.p.d.m0.f.g) obj).getName()), obj);
        }
        this.a = linkedHashMap;
        this.f3491b = this.d.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new d$c$a(this, this.d));
        this.c = this.d.getC().getStorageManager().createLazyValue(new d$c$b(this));
    }

    public static final Set access$computeEnumMemberNames(d$c d_c) {
        Objects.requireNonNull(d_c);
        HashSet hashSet = new HashSet();
        Iterator<c0> it = d_c.d.getTypeConstructor().getSupertypes().iterator();
        while (it.hasNext()) {
            for (d0.e0.p.d.m0.c.m mVar : l$a.getContributedDescriptors$default(it.next().getMemberScope(), null, null, 3, null)) {
                if ((mVar instanceof t0) || (mVar instanceof n0)) {
                    hashSet.add(mVar.getName());
                }
            }
        }
        List<d0.e0.p.d.m0.f.i> functionList = d_c.d.getClassProto().getFunctionList();
        d0.z.d.m.checkNotNullExpressionValue(functionList, "classProto.functionList");
        d dVar = d_c.d;
        Iterator<T> it2 = functionList.iterator();
        while (it2.hasNext()) {
            hashSet.add(w.getName(dVar.getC().getNameResolver(), ((d0.e0.p.d.m0.f.i) it2.next()).getName()));
        }
        List<d0.e0.p.d.m0.f.n> propertyList = d_c.d.getClassProto().getPropertyList();
        d0.z.d.m.checkNotNullExpressionValue(propertyList, "classProto.propertyList");
        d dVar2 = d_c.d;
        Iterator<T> it3 = propertyList.iterator();
        while (it3.hasNext()) {
            hashSet.add(w.getName(dVar2.getC().getNameResolver(), ((d0.e0.p.d.m0.f.n) it3.next()).getName()));
        }
        return o0.plus((Set) hashSet, (Iterable) hashSet);
    }

    public static final /* synthetic */ Map access$getEnumEntryProtos$p(d$c d_c) {
        return d_c.a;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.j access$getEnumMemberNames$p(d$c d_c) {
        return d_c.c;
    }

    public final Collection<d0.e0.p.d.m0.c.e> all() {
        Set<d0.e0.p.d.m0.g.e> setKeySet = this.a.keySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.e eVarFindEnumEntry = findEnumEntry((d0.e0.p.d.m0.g.e) it.next());
            if (eVarFindEnumEntry != null) {
                arrayList.add(eVarFindEnumEntry);
            }
        }
        return arrayList;
    }

    public final d0.e0.p.d.m0.c.e findEnumEntry(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f3491b.invoke(eVar);
    }
}
