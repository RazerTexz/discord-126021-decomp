package d0.f0;

import d0.t.n0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public class q extends p {
    public static final <T> boolean any(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$any");
        return sequence.iterator().hasNext();
    }

    public static final <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$asIterable");
        return new q$a(sequence);
    }

    public static final <T> int count(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$count");
        Iterator<? extends T> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                d0.t.n.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> Sequence<T> distinct(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$distinct");
        return distinctBy(sequence, q$b.j);
    }

    public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$distinctBy");
        d0.z.d.m.checkNotNullParameter(function1, "selector");
        return new c(sequence, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> drop(Sequence<? extends T> sequence, int i) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$drop");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return sequence;
        }
        return sequence instanceof e ? ((e) sequence).drop(i) : new d(sequence, i);
    }

    public static final <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$filter");
        d0.z.d.m.checkNotNullParameter(function1, "predicate");
        return new g(sequence, true, function1);
    }

    public static final <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$filterNot");
        d0.z.d.m.checkNotNullParameter(function1, "predicate");
        return new g(sequence, false, function1);
    }

    public static final <T> Sequence<T> filterNotNull(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$filterNotNull");
        Sequence<T> sequenceFilterNot = filterNot(sequence, q$c.j);
        Objects.requireNonNull(sequenceFilterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return sequenceFilterNot;
    }

    public static final <T> T firstOrNull(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$firstOrNull");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$flatMap");
        d0.z.d.m.checkNotNullParameter(function1, "transform");
        return new h(sequence, function1, q$d.j);
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> sequence, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$joinTo");
        d0.z.d.m.checkNotNullParameter(a, "buffer");
        d0.z.d.m.checkNotNullParameter(charSequence, "separator");
        d0.z.d.m.checkNotNullParameter(charSequence2, "prefix");
        d0.z.d.m.checkNotNullParameter(charSequence3, "postfix");
        d0.z.d.m.checkNotNullParameter(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : sequence) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            d0.g0.l.appendElement(a, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <T> String joinToString(Sequence<? extends T> sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$joinToString");
        d0.z.d.m.checkNotNullParameter(charSequence, "separator");
        d0.z.d.m.checkNotNullParameter(charSequence2, "prefix");
        d0.z.d.m.checkNotNullParameter(charSequence3, "postfix");
        d0.z.d.m.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(sequence, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static final <T> T last(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$last");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T, R> Sequence<R> map(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$map");
        d0.z.d.m.checkNotNullParameter(function1, "transform");
        return new u(sequence, function1);
    }

    public static final <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$mapNotNull");
        d0.z.d.m.checkNotNullParameter(function1, "transform");
        return filterNotNull(new u(sequence, function1));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, T t) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$plus");
        return n.flatten(n.sequenceOf(sequence, n.sequenceOf(t)));
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sorted(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$sorted");
        return new q$e(sequence);
    }

    public static final <T> Sequence<T> sortedWith(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$sortedWith");
        d0.z.d.m.checkNotNullParameter(comparator, "comparator");
        return new q$f(sequence, comparator);
    }

    public static final <T> Sequence<T> take(Sequence<? extends T> sequence, int i) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return n.emptySequence();
        }
        return sequence instanceof e ? ((e) sequence).take(i) : new s(sequence, i);
    }

    public static final <T> Sequence<T> takeWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$takeWhile");
        d0.z.d.m.checkNotNullParameter(function1, "predicate");
        return new t(sequence, function1);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> sequence, C c) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$toCollection");
        d0.z.d.m.checkNotNullParameter(c, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> HashSet<T> toHashSet(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$toHashSet");
        return (HashSet) toCollection(sequence, new HashSet());
    }

    public static final <T> List<T> toList(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$toList");
        return d0.t.n.optimizeReadOnlyList(toMutableList(sequence));
    }

    public static final <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$toMutableList");
        return (List) toCollection(sequence, new ArrayList());
    }

    public static final <T> Set<T> toSet(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$toSet");
        return n0.optimizeReadOnlySet((Set) toCollection(sequence, new LinkedHashSet()));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Iterable<? extends T> iterable) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$plus");
        d0.z.d.m.checkNotNullParameter(iterable, "elements");
        return n.flatten(n.sequenceOf(sequence, d0.t.u.asSequence(iterable)));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Sequence<? extends T> sequence2) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$plus");
        d0.z.d.m.checkNotNullParameter(sequence2, "elements");
        return n.flatten(n.sequenceOf(sequence, sequence2));
    }
}
