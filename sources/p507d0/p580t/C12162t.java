package p507d0.p580t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.t */
/* JADX INFO: compiled from: _CollectionsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12162t extends C12161s {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> cls) {
        C12238m.checkNotNullParameter(iterable, "$this$filterIsInstance");
        C12238m.checkNotNullParameter(cls, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), cls);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C c, Class<R> cls) {
        C12238m.checkNotNullParameter(iterable, "$this$filterIsInstanceTo");
        C12238m.checkNotNullParameter(c, "destination");
        C12238m.checkNotNullParameter(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T> void reverse(List<T> list) {
        C12238m.checkNotNullParameter(list, "$this$reverse");
        Collections.reverse(list);
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        C12238m.checkNotNullParameter(iterable, "$this$toSortedSet");
        C12238m.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) C12163u.toCollection(iterable, new TreeSet(comparator));
    }
}
