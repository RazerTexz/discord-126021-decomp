package d0.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: _CollectionsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class t extends s {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> cls) {
        d0.z.d.m.checkNotNullParameter(iterable, "$this$filterIsInstance");
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), cls);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C c, Class<R> cls) {
        d0.z.d.m.checkNotNullParameter(iterable, "$this$filterIsInstanceTo");
        d0.z.d.m.checkNotNullParameter(c, "destination");
        d0.z.d.m.checkNotNullParameter(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T> void reverse(List<T> list) {
        d0.z.d.m.checkNotNullParameter(list, "$this$reverse");
        Collections.reverse(list);
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        d0.z.d.m.checkNotNullParameter(iterable, "$this$toSortedSet");
        d0.z.d.m.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) u.toCollection(iterable, new TreeSet(comparator));
    }
}
