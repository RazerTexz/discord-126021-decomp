package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u<T, R> implements Sequence<R> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, R> f3578b;

    /* JADX WARN: Multi-variable type inference failed */
    public u(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "sequence");
        d0.z.d.m.checkNotNullParameter(function1, "transformer");
        this.a = sequence;
        this.f3578b = function1;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(u uVar) {
        return uVar.a;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(u uVar) {
        return uVar.f3578b;
    }

    public final <E> Sequence<E> flatten$kotlin_stdlib(Function1<? super R, ? extends Iterator<? extends E>> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "iterator");
        return new h(this.a, this.f3578b, function1);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new u$a(this);
    }
}
