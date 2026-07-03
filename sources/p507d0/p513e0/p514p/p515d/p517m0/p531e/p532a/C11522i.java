package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i */
/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11522i {

    /* JADX INFO: renamed from: a */
    public static final C11522i f23276a = new C11522i();

    /* JADX INFO: renamed from: b */
    public static final Map<C11713b, C11716e> f23277b;

    /* JADX INFO: renamed from: c */
    public static final Map<C11716e, List<C11716e>> f23278c;

    /* JADX INFO: renamed from: d */
    public static final Set<C11713b> f23279d;

    /* JADX INFO: renamed from: e */
    public static final Set<C11716e> f23280e;

    static {
        C11714c c11714c = C11291k.a.f22563r;
        C11713b c11713b = C11291k.a.f22517N;
        Map<C11713b, C11716e> mapMapOf = C12136h0.mapOf(C12116o.m10073to(C11560j.access$childSafe(c11714c, ModelAuditLogEntry.CHANGE_KEY_NAME), C11716e.identifier(ModelAuditLogEntry.CHANGE_KEY_NAME)), C12116o.m10073to(C11560j.access$childSafe(c11714c, "ordinal"), C11716e.identifier("ordinal")), C12116o.m10073to(C11560j.access$child(C11291k.a.f22513J, "size"), C11716e.identifier("size")), C12116o.m10073to(C11560j.access$child(c11713b, "size"), C11716e.identifier("size")), C12116o.m10073to(C11560j.access$childSafe(C11291k.a.f22540f, "length"), C11716e.identifier("length")), C12116o.m10073to(C11560j.access$child(c11713b, "keys"), C11716e.identifier("keySet")), C12116o.m10073to(C11560j.access$child(c11713b, "values"), C11716e.identifier("values")), C12116o.m10073to(C11560j.access$child(c11713b, "entries"), C11716e.identifier("entrySet")));
        f23277b = mapMapOf;
        Set<Map.Entry<C11713b, C11716e>> setEntrySet = mapMapOf.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(C12149o.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((C11713b) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            C11716e c11716e = (C11716e) pair.getSecond();
            Object arrayList2 = linkedHashMap.get(c11716e);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(c11716e, arrayList2);
            }
            ((List) arrayList2).add((C11716e) pair.getFirst());
        }
        f23278c = linkedHashMap;
        Set<C11713b> setKeySet = f23277b.keySet();
        f23279d = setKeySet;
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((C11713b) it2.next()).shortName());
        }
        f23280e = C12163u.toSet(arrayList3);
    }

    public final Map<C11713b, C11716e> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return f23277b;
    }

    public final List<C11716e> getPropertyNameCandidatesBySpecialGetterName(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, "name1");
        List<C11716e> list = f23278c.get(c11716e);
        return list == null ? C12147n.emptyList() : list;
    }

    public final Set<C11713b> getSPECIAL_FQ_NAMES() {
        return f23279d;
    }

    public final Set<C11716e> getSPECIAL_SHORT_NAMES() {
        return f23280e;
    }
}
