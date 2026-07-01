package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Pair;

/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final i a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.e> f3319b;
    public static final Map<d0.e0.p.d.m0.g.e, List<d0.e0.p.d.m0.g.e>> c;
    public static final Set<d0.e0.p.d.m0.g.b> d;
    public static final Set<d0.e0.p.d.m0.g.e> e;

    static {
        d0.e0.p.d.m0.g.c cVar = d0.e0.p.d.m0.b.k$a.r;
        d0.e0.p.d.m0.g.b bVar = d0.e0.p.d.m0.b.k$a.N;
        Map<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.e> mapMapOf = h0.mapOf(d0.o.to(j.access$childSafe(cVar, ModelAuditLogEntry.CHANGE_KEY_NAME), d0.e0.p.d.m0.g.e.identifier(ModelAuditLogEntry.CHANGE_KEY_NAME)), d0.o.to(j.access$childSafe(cVar, "ordinal"), d0.e0.p.d.m0.g.e.identifier("ordinal")), d0.o.to(j.access$child(d0.e0.p.d.m0.b.k$a.J, "size"), d0.e0.p.d.m0.g.e.identifier("size")), d0.o.to(j.access$child(bVar, "size"), d0.e0.p.d.m0.g.e.identifier("size")), d0.o.to(j.access$childSafe(d0.e0.p.d.m0.b.k$a.f, "length"), d0.e0.p.d.m0.g.e.identifier("length")), d0.o.to(j.access$child(bVar, "keys"), d0.e0.p.d.m0.g.e.identifier("keySet")), d0.o.to(j.access$child(bVar, "values"), d0.e0.p.d.m0.g.e.identifier("values")), d0.o.to(j.access$child(bVar, "entries"), d0.e0.p.d.m0.g.e.identifier("entrySet")));
        f3319b = mapMapOf;
        Set<Map$Entry<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.e>> setEntrySet = mapMapOf.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            arrayList.add(new Pair(((d0.e0.p.d.m0.g.b) map$Entry.getKey()).shortName(), map$Entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            d0.e0.p.d.m0.g.e eVar = (d0.e0.p.d.m0.g.e) pair.getSecond();
            Object arrayList2 = linkedHashMap.get(eVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(eVar, arrayList2);
            }
            ((List) arrayList2).add((d0.e0.p.d.m0.g.e) pair.getFirst());
        }
        c = linkedHashMap;
        Set<d0.e0.p.d.m0.g.b> setKeySet = f3319b.keySet();
        d = setKeySet;
        ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((d0.e0.p.d.m0.g.b) it2.next()).shortName());
        }
        e = d0.t.u.toSet(arrayList3);
    }

    public final Map<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.e> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return f3319b;
    }

    public final List<d0.e0.p.d.m0.g.e> getPropertyNameCandidatesBySpecialGetterName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "name1");
        List<d0.e0.p.d.m0.g.e> list = c.get(eVar);
        return list == null ? d0.t.n.emptyList() : list;
    }

    public final Set<d0.e0.p.d.m0.g.b> getSPECIAL_FQ_NAMES() {
        return d;
    }

    public final Set<d0.e0.p.d.m0.g.e> getSPECIAL_SHORT_NAMES() {
        return e;
    }
}
