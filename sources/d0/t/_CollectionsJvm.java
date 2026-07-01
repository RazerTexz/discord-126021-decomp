package d0.t;

import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: renamed from: d0.t.t, reason: use source file name */
/* JADX INFO: compiled from: _CollectionsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class _CollectionsJvm extends ReversedViews3 {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> cls) {
        Intrinsics3.checkNotNullParameter(iterable, "$this$filterIsInstance");
        Intrinsics3.checkNotNullParameter(cls, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), cls);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C c, Class<R> cls) {
        Intrinsics3.checkNotNullParameter(iterable, "$this$filterIsInstanceTo");
        Intrinsics3.checkNotNullParameter(c, "destination");
        Intrinsics3.checkNotNullParameter(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T> void reverse(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$reverse");
        Collections.reverse(list);
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics3.checkNotNullParameter(iterable, "$this$toSortedSet");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) _Collections.toCollection(iterable, new TreeSet(comparator));
    }
}
