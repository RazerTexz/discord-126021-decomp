package p507d0.p580t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.o */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12149o extends C12147n {
    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i) {
        C12238m.checkNotNullParameter(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$collectionSizeOrNull");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static final <T> Collection<T> convertToSetForSetOperationWith(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        C12238m.checkNotNullParameter(iterable, "$this$convertToSetForSetOperationWith");
        C12238m.checkNotNullParameter(iterable2, "source");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return C12163u.toHashSet(iterable);
        }
        if ((iterable2 instanceof Collection) && ((Collection) iterable2).size() < 2) {
            return (Collection) iterable;
        }
        Collection<T> collection = (Collection) iterable;
        return collection.size() > 2 && (collection instanceof ArrayList) ? C12163u.toHashSet(iterable) : collection;
    }

    public static final <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            C12160r.addAll(arrayList, it.next());
        }
        return arrayList;
    }
}
