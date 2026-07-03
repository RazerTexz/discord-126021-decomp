package p507d0.p578f0;

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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12095l;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12153q;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.f0.q */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12078q extends C12077p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$a */
    /* JADX INFO: compiled from: Iterables.kt */
    public static final class a<T> implements Iterable<T>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Sequence f25109j;

        public a(Sequence sequence) {
            this.f25109j = sequence;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f25109j.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$b */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class b<T> extends AbstractC12240o implements Function1<T, T> {

        /* JADX INFO: renamed from: j */
        public static final b f25110j = new b();

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
    public static final class c<T> extends AbstractC12240o implements Function1<T, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final c f25111j = new c();

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
    public static final /* synthetic */ class d<R> extends C12236k implements Function1<Sequence<? extends R>, Iterator<? extends R>> {

        /* JADX INFO: renamed from: j */
        public static final d f25112j = new d();

        public d() {
            super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Iterator<R> invoke(Sequence<? extends R> sequence) {
            C12238m.checkNotNullParameter(sequence, "p1");
            return sequence.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$e */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class e<T> implements Sequence<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Sequence f25113a;

        public e(Sequence<? extends T> sequence) {
            this.f25113a = sequence;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            List mutableList = C12078q.toMutableList(this.f25113a);
            C12153q.sort(mutableList);
            return mutableList.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.q$f */
    /* JADX INFO: compiled from: _Sequences.kt */
    public static final class f<T> implements Sequence<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Sequence f25114a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Comparator f25115b;

        public f(Sequence<? extends T> sequence, Comparator comparator) {
            this.f25114a = sequence;
            this.f25115b = comparator;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            List mutableList = C12078q.toMutableList(this.f25114a);
            C12153q.sortWith(mutableList, this.f25115b);
            return mutableList.iterator();
        }
    }

    public static final <T> boolean any(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$any");
        return sequence.iterator().hasNext();
    }

    public static final <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$asIterable");
        return new a(sequence);
    }

    public static final <T> int count(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$count");
        Iterator<? extends T> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                C12147n.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> Sequence<T> distinct(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$distinct");
        return distinctBy(sequence, b.f25110j);
    }

    public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        C12238m.checkNotNullParameter(sequence, "$this$distinctBy");
        C12238m.checkNotNullParameter(function1, "selector");
        return new C12064c(sequence, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> drop(Sequence<? extends T> sequence, int i) {
        C12238m.checkNotNullParameter(sequence, "$this$drop");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m873r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return sequence;
        }
        return sequence instanceof InterfaceC12066e ? ((InterfaceC12066e) sequence).drop(i) : new C12065d(sequence, i);
    }

    public static final <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        C12238m.checkNotNullParameter(sequence, "$this$filter");
        C12238m.checkNotNullParameter(function1, "predicate");
        return new C12068g(sequence, true, function1);
    }

    public static final <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        C12238m.checkNotNullParameter(sequence, "$this$filterNot");
        C12238m.checkNotNullParameter(function1, "predicate");
        return new C12068g(sequence, false, function1);
    }

    public static final <T> Sequence<T> filterNotNull(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$filterNotNull");
        Sequence<T> sequenceFilterNot = filterNot(sequence, c.f25111j);
        Objects.requireNonNull(sequenceFilterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return sequenceFilterNot;
    }

    public static final <T> T firstOrNull(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$firstOrNull");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        C12238m.checkNotNullParameter(sequence, "$this$flatMap");
        C12238m.checkNotNullParameter(function1, "transform");
        return new C12069h(sequence, function1, d.f25112j);
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> sequence, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        C12238m.checkNotNullParameter(sequence, "$this$joinTo");
        C12238m.checkNotNullParameter(a2, "buffer");
        C12238m.checkNotNullParameter(charSequence, "separator");
        C12238m.checkNotNullParameter(charSequence2, "prefix");
        C12238m.checkNotNullParameter(charSequence3, "postfix");
        C12238m.checkNotNullParameter(charSequence4, "truncated");
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
            C12095l.appendElement(a2, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String joinToString(Sequence<? extends T> sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        C12238m.checkNotNullParameter(sequence, "$this$joinToString");
        C12238m.checkNotNullParameter(charSequence, "separator");
        C12238m.checkNotNullParameter(charSequence2, "prefix");
        C12238m.checkNotNullParameter(charSequence3, "postfix");
        C12238m.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        C12238m.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
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
        C12238m.checkNotNullParameter(sequence, "$this$last");
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
        C12238m.checkNotNullParameter(sequence, "$this$map");
        C12238m.checkNotNullParameter(function1, "transform");
        return new C12082u(sequence, function1);
    }

    public static final <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        C12238m.checkNotNullParameter(sequence, "$this$mapNotNull");
        C12238m.checkNotNullParameter(function1, "transform");
        return filterNotNull(new C12082u(sequence, function1));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, T t) {
        C12238m.checkNotNullParameter(sequence, "$this$plus");
        return C12075n.flatten(C12075n.sequenceOf(sequence, C12075n.sequenceOf(t)));
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sorted(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$sorted");
        return new e(sequence);
    }

    public static final <T> Sequence<T> sortedWith(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        C12238m.checkNotNullParameter(sequence, "$this$sortedWith");
        C12238m.checkNotNullParameter(comparator, "comparator");
        return new f(sequence, comparator);
    }

    public static final <T> Sequence<T> take(Sequence<? extends T> sequence, int i) {
        C12238m.checkNotNullParameter(sequence, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m873r("Requested element count ", i, " is less than zero.").toString());
        }
        if (i == 0) {
            return C12075n.emptySequence();
        }
        return sequence instanceof InterfaceC12066e ? ((InterfaceC12066e) sequence).take(i) : new C12080s(sequence, i);
    }

    public static final <T> Sequence<T> takeWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        C12238m.checkNotNullParameter(sequence, "$this$takeWhile");
        C12238m.checkNotNullParameter(function1, "predicate");
        return new C12081t(sequence, function1);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> sequence, C c2) {
        C12238m.checkNotNullParameter(sequence, "$this$toCollection");
        C12238m.checkNotNullParameter(c2, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T> HashSet<T> toHashSet(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$toHashSet");
        return (HashSet) toCollection(sequence, new HashSet());
    }

    public static final <T> List<T> toList(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$toList");
        return C12147n.optimizeReadOnlyList(toMutableList(sequence));
    }

    public static final <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$toMutableList");
        return (List) toCollection(sequence, new ArrayList());
    }

    public static final <T> Set<T> toSet(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$toSet");
        return C12148n0.optimizeReadOnlySet((Set) toCollection(sequence, new LinkedHashSet()));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Iterable<? extends T> iterable) {
        C12238m.checkNotNullParameter(sequence, "$this$plus");
        C12238m.checkNotNullParameter(iterable, "elements");
        return C12075n.flatten(C12075n.sequenceOf(sequence, C12163u.asSequence(iterable)));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Sequence<? extends T> sequence2) {
        C12238m.checkNotNullParameter(sequence, "$this$plus");
        C12238m.checkNotNullParameter(sequence2, "elements");
        return C12075n.flatten(C12075n.sequenceOf(sequence, sequence2));
    }
}
