package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.g.Name;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.k, reason: use source file name */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MemberScope4 {
    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope3> iterable) {
        Intrinsics3.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends MemberScope3> it = iterable.iterator();
        while (it.hasNext()) {
            Set<Name> classifierNames = it.next().getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            MutableCollections.addAll(hashSet, classifierNames);
        }
        return hashSet;
    }
}
