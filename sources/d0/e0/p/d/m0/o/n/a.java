package d0.e0.p.d.m0.o.n;

import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.p.i;
import d0.z.d.m;
import java.util.Collection;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: scopeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> collection, Collection<? extends T> collection2) {
        m.checkNotNullParameter(collection2, "collection");
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

    public static final i<d0.e0.p.d.m0.k.a0.i> listOfNonEmptyScopes(Iterable<? extends d0.e0.p.d.m0.k.a0.i> iterable) {
        m.checkNotNullParameter(iterable, "scopes");
        i<d0.e0.p.d.m0.k.a0.i> iVar = new i<>();
        for (d0.e0.p.d.m0.k.a0.i iVar2 : iterable) {
            d0.e0.p.d.m0.k.a0.i iVar3 = iVar2;
            if ((iVar3 == null || iVar3 == i$b.f3461b) ? false : true) {
                iVar.add(iVar2);
            }
        }
        return iVar;
    }
}
