package p507d0.p578f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.f0.n */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12075n extends C12074m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.n$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements Sequence<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Iterator f25105a;

        public a(Iterator it) {
            this.f25105a = it;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return this.f25105a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.n$b */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class b<T> extends AbstractC12240o implements Function1<Sequence<? extends T>, Iterator<? extends T>> {

        /* JADX INFO: renamed from: j */
        public static final b f25106j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Iterator<T> invoke(Sequence<? extends T> sequence) {
            C12238m.checkNotNullParameter(sequence, "it");
            return sequence.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.n$c */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class c<T> extends AbstractC12240o implements Function1<Iterable<? extends T>, Iterator<? extends T>> {

        /* JADX INFO: renamed from: j */
        public static final c f25107j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Iterator<T> invoke(Iterable<? extends T> iterable) {
            C12238m.checkNotNullParameter(iterable, "it");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.n$d */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class d<T> extends AbstractC12240o implements Function1<T, T> {
        public final /* synthetic */ Function0 $nextFunction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(1);
            this.$nextFunction = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            C12238m.checkNotNullParameter(t, "it");
            return (T) this.$nextFunction.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.n$e */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class e<T> extends AbstractC12240o implements Function0<T> {
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
        C12238m.checkNotNullParameter(it, "$this$asSequence");
        return constrainOnce(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$constrainOnce");
        return sequence instanceof C12062a ? sequence : new C12062a(sequence);
    }

    public static final <T> Sequence<T> emptySequence() {
        return C12067f.f25081a;
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$flatten");
        b bVar = b.f25106j;
        return sequence instanceof C12082u ? ((C12082u) sequence).flatten$kotlin_stdlib(bVar) : new C12069h(sequence, C12076o.f25108j, bVar);
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        C12238m.checkNotNullParameter(sequence, "$this$flatten");
        c cVar = c.f25107j;
        return sequence instanceof C12082u ? ((C12082u) sequence).flatten$kotlin_stdlib(cVar) : new C12069h(sequence, C12076o.f25108j, cVar);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0) {
        C12238m.checkNotNullParameter(function0, "nextFunction");
        return constrainOnce(new C12070i(function0, new d(function0)));
    }

    public static final <T> Sequence<T> sequenceOf(T... tArr) {
        C12238m.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? emptySequence() : C12141k.asSequence(tArr);
    }

    public static final <T> Sequence<T> generateSequence(T t, Function1<? super T, ? extends T> function1) {
        C12238m.checkNotNullParameter(function1, "nextFunction");
        return t == null ? C12067f.f25081a : new C12070i(new e(t), function1);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        C12238m.checkNotNullParameter(function0, "seedFunction");
        C12238m.checkNotNullParameter(function1, "nextFunction");
        return new C12070i(function0, function1);
    }
}
