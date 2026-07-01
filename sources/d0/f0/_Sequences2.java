package d0.f0;

import b.d.b.a.outline;
import d0.g0.Appendable;
import d0.t.Collections2;
import d0.t.MutableCollectionsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.g0.KMarkers;
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

/* JADX INFO: renamed from: d0.f0.q, reason: use source file name */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public class _Sequences2 extends _SequencesJvm {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$a */
    /* JADX INFO: compiled from: Iterables.kt */
    public static final class a<T> implements Iterable<T>, KMarkers {
        public final /* synthetic */ Sequence j;

        public a(Sequence sequence) {
            this.j = sequence;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.j.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$b */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class b<T> extends Lambda implements Function1<T, T> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$c */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class c<T> extends Lambda implements Function1<T, Boolean> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke2(obj));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(T t) {
            return t == null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: d0.f0.q$d */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final /* synthetic */ class d<R> extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
        public static final d j = new d();

        public d() {
            super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Iterator<R> invoke(Sequence<? extends R> sequence) {
            Intrinsics3.checkNotNullParameter(sequence, "p1");
            return sequence.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$e */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class e<T> implements Sequence<T> {
        public final /* synthetic */ Sequence a;

        public e(Sequence<? extends T> sequence) {
            this.a = sequence;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            List mutableList = _Sequences2.toMutableList(this.a);
            MutableCollectionsJVM.sort(mutableList);
            return mutableList.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$f */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class f<T> implements Sequence<T> {
        public final /* synthetic */ Sequence a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator f3574b;

        public f(Sequence<? extends T> sequence, Comparator comparator) {
            this.a = sequence;
            this.f3574b = comparator;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            List mutableList = _Sequences2.toMutableList(this.a);
            MutableCollectionsJVM.sortWith(mutableList, this.f3574b);
            return mutableList.iterator();
        }
    }

    public static final <T> boolean any(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$any");
        return sequence.iterator().hasNext();
    }

    public static final <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$asIterable");
        return new a(sequence);
    }

    public static final <T> int count(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$count");
        Iterator<? extends T> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                Collections2.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> Sequence<T> distinct(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$distinct");
        return distinctBy(sequence, b.j);
    }

    public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$distinctBy");
        Intrinsics3.checkNotNullParameter(function1, "selector");
        return new d0.f0.c(sequence, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> drop(Sequence<? extends T> sequence, int i) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$drop");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return sequence;
        }
        return sequence instanceof d0.f0.e ? ((d0.f0.e) sequence).drop(i) : new d0.f0.d(sequence, i);
    }

    public static final <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$filter");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return new g(sequence, true, function1);
    }

    public static final <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$filterNot");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return new g(sequence, false, function1);
    }

    public static final <T> Sequence<T> filterNotNull(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$filterNotNull");
        Sequence<T> sequenceFilterNot = filterNot(sequence, c.j);
        Objects.requireNonNull(sequenceFilterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return sequenceFilterNot;
    }

    public static final <T> T firstOrNull(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$firstOrNull");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$flatMap");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        return new h(sequence, function1, d.j);
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> sequence, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics3.checkNotNullParameter(sequence, "$this$joinTo");
        Intrinsics3.checkNotNullParameter(a2, "buffer");
        Intrinsics3.checkNotNullParameter(charSequence, "separator");
        Intrinsics3.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics3.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics3.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : sequence) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            Appendable.appendElement(a2, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String joinToString(Sequence<? extends T> sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$joinToString");
        Intrinsics3.checkNotNullParameter(charSequence, "separator");
        Intrinsics3.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics3.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics3.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics3.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
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
        Intrinsics3.checkNotNullParameter(sequence, "$this$last");
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
        Intrinsics3.checkNotNullParameter(sequence, "$this$map");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        return new u(sequence, function1);
    }

    public static final <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$mapNotNull");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        return filterNotNull(new u(sequence, function1));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, T t) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$plus");
        return n.flatten(n.sequenceOf(sequence, n.sequenceOf(t)));
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sorted(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$sorted");
        return new e(sequence);
    }

    public static final <T> Sequence<T> sortedWith(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$sortedWith");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        return new f(sequence, comparator);
    }

    public static final <T> Sequence<T> take(Sequence<? extends T> sequence, int i) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return n.emptySequence();
        }
        return sequence instanceof d0.f0.e ? ((d0.f0.e) sequence).take(i) : new s(sequence, i);
    }

    public static final <T> Sequence<T> takeWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$takeWhile");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return new t(sequence, function1);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> sequence, C c2) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toCollection");
        Intrinsics3.checkNotNullParameter(c2, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T> HashSet<T> toHashSet(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toHashSet");
        return (HashSet) toCollection(sequence, new HashSet());
    }

    public static final <T> List<T> toList(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toList");
        return Collections2.optimizeReadOnlyList(toMutableList(sequence));
    }

    public static final <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toMutableList");
        return (List) toCollection(sequence, new ArrayList());
    }

    public static final <T> Set<T> toSet(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$toSet");
        return Sets5.optimizeReadOnlySet((Set) toCollection(sequence, new LinkedHashSet()));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Iterable<? extends T> iterable) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics3.checkNotNullParameter(iterable, "elements");
        return n.flatten(n.sequenceOf(sequence, _Collections.asSequence(iterable)));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Sequence<? extends T> sequence2) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics3.checkNotNullParameter(sequence2, "elements");
        return n.flatten(n.sequenceOf(sequence, sequence2));
    }
}
