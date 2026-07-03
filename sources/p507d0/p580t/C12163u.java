package p507d0.p580t;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p510c0.AbstractC11216c;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12095l;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.u */
/* JADX INFO: compiled from: _Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12163u extends C12162t {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.t.u$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements Sequence<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Iterable f25219a;

        public a(Iterable iterable) {
            this.f25219a = iterable;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return this.f25219a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.t.u$b */
    /* JADX INFO: compiled from: _Collections.kt */
    public static final class b<T> extends AbstractC12240o implements Function1<Integer, T> {
        public final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(1);
            this.$index = i;
        }

        public final T invoke(int i) {
            throw new IndexOutOfBoundsException(C1643a.m813A(C1643a.m833U("Collection doesn't contain element at index "), this.$index, '.'));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.t.u$c */
    /* JADX INFO: compiled from: _Collections.kt */
    public static final class c<T> extends AbstractC12240o implements Function0<Iterator<? extends T>> {
        public final /* synthetic */ Iterable $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterable iterable) {
            super(0);
            this.$this_withIndex = iterable;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Iterator<T> invoke() {
            return this.$this_withIndex.iterator();
        }
    }

    public static final <T> boolean all(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        C12238m.checkNotNullParameter(iterable, "$this$all");
        C12238m.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!function1.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> Sequence<T> asSequence(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$asSequence");
        return new a(iterable);
    }

    public static final double averageOfLong(Iterable<Long> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$average");
        Iterator<Long> it = iterable.iterator();
        double dLongValue = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i++;
            if (i < 0) {
                C12147n.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i);
    }

    public static final <T> List<List<T>> chunked(Iterable<? extends T> iterable, int i) {
        C12238m.checkNotNullParameter(iterable, "$this$chunked");
        return windowed(iterable, i, i, true);
    }

    public static final <T> boolean contains(Iterable<? extends T> iterable, T t) {
        C12238m.checkNotNullParameter(iterable, "$this$contains");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return indexOf(iterable, t) >= 0;
    }

    public static final <T> int count(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$count");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int i = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                C12147n.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> List<T> distinct(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$distinct");
        return toList(toMutableSet(iterable));
    }

    public static final <T> List<T> drop(Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        C12238m.checkNotNullParameter(iterable, "$this$drop");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m873r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return toList(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i;
            if (size <= 0) {
                return C12147n.emptyList();
            }
            if (size == 1) {
                return C12145m.listOf(last(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i < size2) {
                        arrayList.add(((List) iterable).get(i));
                        i++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t : iterable) {
            if (i2 >= i) {
                arrayList.add(t);
            } else {
                i2++;
            }
        }
        return C12147n.optimizeReadOnlyList(arrayList);
    }

    public static final <T> List<T> dropLast(List<? extends T> list, int i) {
        C12238m.checkNotNullParameter(list, "$this$dropLast");
        if (i >= 0) {
            return take(list, C11226f.coerceAtLeast(list.size() - i, 0));
        }
        throw new IllegalArgumentException(C1643a.m873r("Requested element count ", i, " is less than zero.").toString());
    }

    public static final <T> T elementAt(Iterable<? extends T> iterable, int i) {
        C12238m.checkNotNullParameter(iterable, "$this$elementAt");
        return iterable instanceof List ? (T) ((List) iterable).get(i) : (T) elementAtOrElse(iterable, i, new b(i));
    }

    public static final <T> T elementAtOrElse(Iterable<? extends T> iterable, int i, Function1<? super Integer, ? extends T> function1) {
        C12238m.checkNotNullParameter(iterable, "$this$elementAtOrElse");
        C12238m.checkNotNullParameter(function1, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i < 0 || i > C12147n.getLastIndex(list)) ? function1.invoke(Integer.valueOf(i)) : (T) list.get(i);
        }
        if (i < 0) {
            return function1.invoke(Integer.valueOf(i));
        }
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return function1.invoke(Integer.valueOf(i));
    }

    public static final <T> List<T> filter(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        C12238m.checkNotNullParameter(iterable, "$this$filter");
        C12238m.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (function1.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$filterNotNull");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C c2) {
        C12238m.checkNotNullParameter(iterable, "$this$filterNotNullTo");
        C12238m.checkNotNullParameter(c2, "destination");
        for (T t : iterable) {
            if (t != null) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T> T first(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T firstOrNull(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$firstOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T> T getOrNull(List<? extends T> list, int i) {
        C12238m.checkNotNullParameter(list, "$this$getOrNull");
        if (i < 0 || i > C12147n.getLastIndex(list)) {
            return null;
        }
        return list.get(i);
    }

    public static final <T> int indexOf(Iterable<? extends T> iterable, T t) {
        C12238m.checkNotNullParameter(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            if (C12238m.areEqual(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> Set<T> intersect(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        C12238m.checkNotNullParameter(iterable, "$this$intersect");
        C12238m.checkNotNullParameter(iterable2, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        C12160r.retainAll(mutableSet, iterable2);
        return mutableSet;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        C12238m.checkNotNullParameter(iterable, "$this$joinTo");
        C12238m.checkNotNullParameter(a2, "buffer");
        C12238m.checkNotNullParameter(charSequence, "separator");
        C12238m.checkNotNullParameter(charSequence2, "prefix");
        C12238m.checkNotNullParameter(charSequence3, "postfix");
        C12238m.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            C12095l.appendElement(a2, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        C12238m.checkNotNullParameter(iterable, "$this$joinToString");
        C12238m.checkNotNullParameter(charSequence, "separator");
        C12238m.checkNotNullParameter(charSequence2, "prefix");
        C12238m.checkNotNullParameter(charSequence3, "postfix");
        C12238m.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        C12238m.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static final <T> T last(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$last");
        if (iterable instanceof List) {
            return (T) last((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> T lastOrNull(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$lastOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T, R> List<R> map(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        C12238m.checkNotNullParameter(iterable, "$this$map");
        C12238m.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m11488maxOrNull(Iterable<Float> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$maxOrNull");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$minOrNull");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T minWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        C12238m.checkNotNullParameter(iterable, "$this$minWithOrNull");
        C12238m.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, T t) {
        C12238m.checkNotNullParameter(iterable, "$this$minus");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(iterable, 10));
        boolean z2 = false;
        for (T t2 : iterable) {
            boolean z3 = true;
            if (!z2 && C12238m.areEqual(t2, t)) {
                z2 = true;
                z3 = false;
            }
            if (z3) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T t) {
        C12238m.checkNotNullParameter(iterable, "$this$plus");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object) t);
        }
        ArrayList arrayList = new ArrayList();
        C12160r.addAll(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T> T random(Collection<? extends T> collection, AbstractC11216c abstractC11216c) {
        C12238m.checkNotNullParameter(collection, "$this$random");
        C12238m.checkNotNullParameter(abstractC11216c, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) elementAt(collection, abstractC11216c.nextInt(collection.size()));
    }

    public static final <T> List<T> reversed(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$reversed");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        C12162t.reverse(mutableList);
        return mutableList;
    }

    public static final <T> T single(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) single((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T singleOrNull(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$singleOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static final <T> List<T> slice(List<? extends T> list, IntRange intRange) {
        C12238m.checkNotNullParameter(list, "$this$slice");
        C12238m.checkNotNullParameter(intRange, "indices");
        return intRange.isEmpty() ? C12147n.emptyList() : toList(list.subList(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$sorted");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            C12153q.sort(mutableList);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Comparable[] comparableArr = (Comparable[]) array;
        C12139j.sort(comparableArr);
        return C12139j.asList(comparableArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        C12238m.checkNotNullParameter(iterable, "$this$sortedWith");
        C12238m.checkNotNullParameter(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            C12153q.sortWith(mutableList, comparator);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        C12139j.sortWith(array, comparator);
        return C12139j.asList(array);
    }

    public static final float sumOfFloat(Iterable<Float> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Float> it = iterable.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    public static final int sumOfInt(Iterable<Integer> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    public static final long sumOfLong(Iterable<Long> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Long> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public static final <T> List<T> take(Iterable<? extends T> iterable, int i) {
        C12238m.checkNotNullParameter(iterable, "$this$take");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m873r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return C12147n.emptyList();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return toList(iterable);
            }
            if (i == 1) {
                return C12145m.listOf(first(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return C12147n.optimizeReadOnlyList(arrayList);
    }

    public static final <T> List<T> takeLast(List<? extends T> list, int i) {
        C12238m.checkNotNullParameter(list, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m873r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return C12147n.emptyList();
        }
        int size = list.size();
        if (i >= size) {
            return toList(list);
        }
        if (i == 1) {
            return C12145m.listOf(last((List) list));
        }
        ArrayList arrayList = new ArrayList(i);
        if (list instanceof RandomAccess) {
            for (int i2 = size - i; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C c2) {
        C12238m.checkNotNullParameter(iterable, "$this$toCollection");
        C12238m.checkNotNullParameter(c2, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T> HashSet<T> toHashSet(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$toHashSet");
        return (HashSet) toCollection(iterable, new HashSet(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(iterable, 12))));
    }

    public static final int[] toIntArray(Collection<Integer> collection) {
        C12238m.checkNotNullParameter(collection, "$this$toIntArray");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    public static final <T> List<T> toList(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return C12147n.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C12147n.emptyList();
        }
        if (size != 1) {
            return toMutableList(collection);
        }
        return C12145m.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$toMutableList");
        return iterable instanceof Collection ? toMutableList((Collection) iterable) : (List) toCollection(iterable, new ArrayList());
    }

    public static final <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$toMutableSet");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) toCollection(iterable, new LinkedHashSet());
    }

    public static final <T> Set<T> toSet(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$toSet");
        if (!(iterable instanceof Collection)) {
            return C12148n0.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return C12148n0.emptySet();
        }
        if (size != 1) {
            return (Set) toCollection(iterable, new LinkedHashSet(C12134g0.mapCapacity(collection.size())));
        }
        return C12146m0.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> Set<T> union(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        C12238m.checkNotNullParameter(iterable, "$this$union");
        C12238m.checkNotNullParameter(iterable2, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        C12160r.addAll(mutableSet, iterable2);
        return mutableSet;
    }

    public static final <T> List<List<T>> windowed(Iterable<? extends T> iterable, int i, int i2, boolean z2) {
        C12238m.checkNotNullParameter(iterable, "$this$windowed");
        C12152p0.checkWindowSizeStep(i, i2);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itWindowedIterator = C12152p0.windowedIterator(iterable.iterator(), i, i2, z2, false);
            while (itWindowedIterator.hasNext()) {
                arrayList.add((List) itWindowedIterator.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i2) + (size % i2 == 0 ? 0 : 1));
        int i3 = 0;
        while (i3 >= 0 && size > i3) {
            int iCoerceAtMost = C11226f.coerceAtMost(i, size - i3);
            if (iCoerceAtMost < i && !z2) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(iCoerceAtMost);
            for (int i4 = 0; i4 < iCoerceAtMost; i4++) {
                arrayList3.add(list.get(i4 + i3));
            }
            arrayList2.add(arrayList3);
            i3 += i2;
        }
        return arrayList2;
    }

    public static final <T> Iterable<C12168z<T>> withIndex(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$withIndex");
        return new C12122a0(new c(iterable));
    }

    public static final <T, R> List<Pair<T, R>> zip(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        C12238m.checkNotNullParameter(iterable, "$this$zip");
        C12238m.checkNotNullParameter(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(C12149o.collectionSizeOrDefault(iterable, 10), C12149o.collectionSizeOrDefault(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(C12116o.m10073to(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        C12238m.checkNotNullParameter(iterable, "$this$minus");
        C12238m.checkNotNullParameter(iterable2, "elements");
        Collection collectionConvertToSetForSetOperationWith = C12149o.convertToSetForSetOperationWith(iterable2, iterable);
        if (collectionConvertToSetForSetOperationWith.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!collectionConvertToSetForSetOperationWith.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> toMutableList(Collection<? extends T> collection) {
        C12238m.checkNotNullParameter(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T t) {
        C12238m.checkNotNullParameter(collection, "$this$plus");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T> T first(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$first");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T singleOrNull(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$singleOrNull");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static final <T> T firstOrNull(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> T lastOrNull(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$lastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final <T> T last(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$last");
        if (!list.isEmpty()) {
            return list.get(C12147n.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(iterable, "$this$maxOrNull");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        C12238m.checkNotNullParameter(iterable, "$this$plus");
        C12238m.checkNotNullParameter(iterable2, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Iterable) iterable2);
        }
        ArrayList arrayList = new ArrayList();
        C12160r.addAll(arrayList, iterable);
        C12160r.addAll(arrayList, iterable2);
        return arrayList;
    }

    public static final <T> T single(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(collection, "$this$plus");
        C12238m.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        C12160r.addAll(arrayList2, iterable);
        return arrayList2;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(collection, "$this$plus");
        C12238m.checkNotNullParameter(sequence, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        C12160r.addAll(arrayList, sequence);
        return arrayList;
    }
}
