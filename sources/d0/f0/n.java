package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public class n extends m {
    public static final <T> Sequence<T> asSequence(Iterator<? extends T> it) {
        d0.z.d.m.checkNotNullParameter(it, "$this$asSequence");
        return constrainOnce(new n$a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$constrainOnce");
        return sequence instanceof a ? sequence : new a(sequence);
    }

    public static final <T> Sequence<T> emptySequence() {
        return f.a;
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$flatten");
        n$b n_b = n$b.j;
        return sequence instanceof u ? ((u) sequence).flatten$kotlin_stdlib(n_b) : new h(sequence, o.j, n_b);
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "$this$flatten");
        n$c n_c = n$c.j;
        return sequence instanceof u ? ((u) sequence).flatten$kotlin_stdlib(n_c) : new h(sequence, o.j, n_c);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "nextFunction");
        return constrainOnce(new i(function0, new n$d(function0)));
    }

    public static final <T> Sequence<T> sequenceOf(T... tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? emptySequence() : d0.t.k.asSequence(tArr);
    }

    public static final <T> Sequence<T> generateSequence(T t, Function1<? super T, ? extends T> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "nextFunction");
        return t == null ? f.a : new i(new n$e(t), function1);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        d0.z.d.m.checkNotNullParameter(function0, "seedFunction");
        d0.z.d.m.checkNotNullParameter(function1, "nextFunction");
        return new i(function0, function1);
    }
}
