package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.a */
/* JADX INFO: compiled from: collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12033a {
    /* JADX INFO: renamed from: a */
    public static final int m10042a(int i) {
        if (i < 3) {
            return 3;
        }
        return (i / 3) + i + 1;
    }

    public static final <T> void addIfNotNull(Collection<T> collection, T t) {
        C12238m.checkNotNullParameter(collection, "<this>");
        if (t != null) {
            collection.add(t);
        }
    }

    public static final <T> List<T> compact(ArrayList<T> arrayList) {
        C12238m.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return C12147n.emptyList();
        }
        if (size == 1) {
            return C12145m.listOf(C12163u.first((List) arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> iterable) {
        C12238m.checkNotNullParameter(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(m10042a(i));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int i) {
        return new HashSet<>(m10042a(i));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i) {
        return new LinkedHashSet<>(m10042a(i));
    }
}
