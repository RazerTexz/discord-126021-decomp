package p507d0.p580t;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.r */
/* JADX INFO: compiled from: MutableCollections.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12160r extends C12153q {
    /* JADX INFO: renamed from: a */
    public static final <T> boolean m10082a(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z2) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue() == z2) {
                it.remove();
                z3 = true;
            }
        }
        return z3;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(collection, "$this$addAll");
        C12238m.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z2 = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(collection, "$this$removeAll");
        C12238m.checkNotNullParameter(iterable, "elements");
        return C12224e0.asMutableCollection(collection).removeAll(C12149o.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> T removeFirst(List<T> list) {
        C12238m.checkNotNullParameter(list, "$this$removeFirst");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(collection, "$this$retainAll");
        C12238m.checkNotNullParameter(iterable, "elements");
        return C12224e0.asMutableCollection(collection).retainAll(C12149o.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> boolean removeAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        C12238m.checkNotNullParameter(iterable, "$this$removeAll");
        C12238m.checkNotNullParameter(function1, "predicate");
        return m10082a(iterable, function1, true);
    }

    public static final <T> boolean removeAll(List<T> list, Function1<? super T, Boolean> function1) {
        int i;
        C12238m.checkNotNullParameter(list, "$this$removeAll");
        C12238m.checkNotNullParameter(function1, "predicate");
        if (!(list instanceof RandomAccess)) {
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
            return m10082a(C12224e0.asMutableIterable(list), function1, true);
        }
        int lastIndex = C12147n.getLastIndex(list);
        if (lastIndex >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                T t = list.get(i2);
                if (!function1.invoke(t).booleanValue()) {
                    if (i != i2) {
                        list.set(i, t);
                    }
                    i++;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int lastIndex2 = C12147n.getLastIndex(list);
        if (lastIndex2 >= i) {
            while (true) {
                list.remove(lastIndex2);
                if (lastIndex2 == i) {
                    break;
                }
                lastIndex2--;
            }
        }
        return true;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(collection, "$this$addAll");
        C12238m.checkNotNullParameter(sequence, "elements");
        Iterator<? extends T> it = sequence.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean addAll(Collection<? super T> collection, T[] tArr) {
        C12238m.checkNotNullParameter(collection, "$this$addAll");
        C12238m.checkNotNullParameter(tArr, "elements");
        return collection.addAll(C12139j.asList(tArr));
    }
}
