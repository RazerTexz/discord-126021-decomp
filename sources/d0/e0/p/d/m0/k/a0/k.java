package d0.e0.p.d.m0.k.a0;

import d0.t.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final Set<d0.e0.p.d.m0.g.e> flatMapClassifierNamesOrNull(Iterable<? extends i> iterable) {
        d0.z.d.m.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends i> it = iterable.iterator();
        while (it.hasNext()) {
            Set<d0.e0.p.d.m0.g.e> classifierNames = it.next().getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            r.addAll(hashSet, classifierNames);
        }
        return hashSet;
    }
}
