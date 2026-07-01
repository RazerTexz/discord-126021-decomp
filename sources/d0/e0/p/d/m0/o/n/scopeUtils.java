package d0.e0.p.d.m0.o.n;

import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.p.SmartList;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.LinkedHashSet;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.n.a, reason: use source file name */
/* JADX INFO: compiled from: scopeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class scopeUtils {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics3.checkNotNullParameter(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final SmartList<MemberScope3> listOfNonEmptyScopes(Iterable<? extends MemberScope3> iterable) {
        Intrinsics3.checkNotNullParameter(iterable, "scopes");
        SmartList<MemberScope3> smartList = new SmartList<>();
        for (MemberScope3 memberScope3 : iterable) {
            MemberScope3 memberScope4 = memberScope3;
            if ((memberScope4 == null || memberScope4 == MemberScope3.b.f3461b) ? false : true) {
                smartList.add(memberScope3);
            }
        }
        return smartList;
    }
}
