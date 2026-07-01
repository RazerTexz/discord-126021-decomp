package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i, reason: use source file name */
/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltinSpecialProperties {
    public static final BuiltinSpecialProperties a = new BuiltinSpecialProperties();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<FqName, Name> f3319b;
    public static final Map<Name, List<Name>> c;
    public static final Set<FqName> d;
    public static final Set<Name> e;

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.a.r;
        FqName fqName = StandardNames.a.N;
        Map<FqName, Name> mapMapOf = Maps6.mapOf(Tuples.to(BuiltinSpecialProperties2.access$childSafe(fqNameUnsafe, ModelAuditLogEntry.CHANGE_KEY_NAME), Name.identifier(ModelAuditLogEntry.CHANGE_KEY_NAME)), Tuples.to(BuiltinSpecialProperties2.access$childSafe(fqNameUnsafe, "ordinal"), Name.identifier("ordinal")), Tuples.to(BuiltinSpecialProperties2.access$child(StandardNames.a.J, "size"), Name.identifier("size")), Tuples.to(BuiltinSpecialProperties2.access$child(fqName, "size"), Name.identifier("size")), Tuples.to(BuiltinSpecialProperties2.access$childSafe(StandardNames.a.f, "length"), Name.identifier("length")), Tuples.to(BuiltinSpecialProperties2.access$child(fqName, "keys"), Name.identifier("keySet")), Tuples.to(BuiltinSpecialProperties2.access$child(fqName, "values"), Name.identifier("values")), Tuples.to(BuiltinSpecialProperties2.access$child(fqName, "entries"), Name.identifier("entrySet")));
        f3319b = mapMapOf;
        Set<Map.Entry<FqName, Name>> setEntrySet = mapMapOf.entrySet();
        ArrayList<Tuples2> arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Tuples2(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Tuples2 tuples2 : arrayList) {
            Name name = (Name) tuples2.getSecond();
            Object arrayList2 = linkedHashMap.get(name);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(name, arrayList2);
            }
            ((List) arrayList2).add((Name) tuples2.getFirst());
        }
        c = linkedHashMap;
        Set<FqName> setKeySet = f3319b.keySet();
        d = setKeySet;
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((FqName) it2.next()).shortName());
        }
        e = _Collections.toSet(arrayList3);
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return f3319b;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name) {
        Intrinsics3.checkNotNullParameter(name, "name1");
        List<Name> list = c.get(name);
        return list == null ? Collections2.emptyList() : list;
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return d;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return e;
    }
}
