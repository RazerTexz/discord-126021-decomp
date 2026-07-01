package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.n.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeIntersectionScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o$a {
    public o$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final i create(String str, Collection<? extends c0> collection) {
        d0.z.d.m.checkNotNullParameter(str, "message");
        d0.z.d.m.checkNotNullParameter(collection, "types");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((c0) it.next()).getMemberScope());
        }
        d0.e0.p.d.m0.p.i<i> iVarListOfNonEmptyScopes = d0.e0.p.d.m0.o.n.a.listOfNonEmptyScopes(arrayList);
        i iVarCreateOrSingle$descriptors = b.f3451b.createOrSingle$descriptors(str, iVarListOfNonEmptyScopes);
        return iVarListOfNonEmptyScopes.size() <= 1 ? iVarCreateOrSingle$descriptors : new o(str, iVarCreateOrSingle$descriptors, null);
    }
}
