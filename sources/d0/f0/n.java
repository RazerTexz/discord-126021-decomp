package d0.f0;

import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public class n extends SequencesJVM2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements Sequence<T> {
        public final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class b<T> extends Lambda implements Function1<Sequence<? extends T>, Iterator<? extends T>> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Iterator<T> invoke(Sequence<? extends T> sequence) {
            Intrinsics3.checkNotNullParameter(sequence, "it");
            return sequence.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class c<T> extends Lambda implements Function1<Iterable<? extends T>, Iterator<? extends T>> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Iterator<T> invoke(Iterable<? extends T> iterable) {
            Intrinsics3.checkNotNullParameter(iterable, "it");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class d<T> extends Lambda implements Function1<T, T> {
        public final /* synthetic */ Function0 $nextFunction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(1);
            this.$nextFunction = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            Intrinsics3.checkNotNullParameter(t, "it");
            return (T) this.$nextFunction.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class e<T> extends Lambda implements Function0<T> {
        public final /* synthetic */ Object $seed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Object obj) {
            super(0);
            this.$seed = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) this.$seed;
        }
    }

    public static final <T> Sequence<T> asSequence(Iterator<? extends T> it) {
        Intrinsics3.checkNotNullParameter(it, "$this$asSequence");
        return constrainOnce(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$constrainOnce");
        return sequence instanceof SequencesJVM ? sequence : new SequencesJVM(sequence);
    }

    public static final <T> Sequence<T> emptySequence() {
        return f.a;
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$flatten");
        b bVar = b.j;
        return sequence instanceof u ? ((u) sequence).flatten$kotlin_stdlib(bVar) : new h(sequence, o.j, bVar);
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "$this$flatten");
        c cVar = c.j;
        return sequence instanceof u ? ((u) sequence).flatten$kotlin_stdlib(cVar) : new h(sequence, o.j, cVar);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0) {
        Intrinsics3.checkNotNullParameter(function0, "nextFunction");
        return constrainOnce(new i(function0, new d(function0)));
    }

    public static final <T> Sequence<T> sequenceOf(T... tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? emptySequence() : _Arrays.asSequence(tArr);
    }

    public static final <T> Sequence<T> generateSequence(T t, Function1<? super T, ? extends T> function1) {
        Intrinsics3.checkNotNullParameter(function1, "nextFunction");
        return t == null ? f.a : new i(new e(t), function1);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics3.checkNotNullParameter(function0, "seedFunction");
        Intrinsics3.checkNotNullParameter(function1, "nextFunction");
        return new i(function0, function1);
    }
}
