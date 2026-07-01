package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h<T, R, E> implements Sequence<E> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, R> f3572b;
    public final Function1<R, Iterator<E>> c;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1, Function1<? super R, ? extends Iterator<? extends E>> function2) {
        d0.z.d.m.checkNotNullParameter(sequence, "sequence");
        d0.z.d.m.checkNotNullParameter(function1, "transformer");
        d0.z.d.m.checkNotNullParameter(function2, "iterator");
        this.a = sequence;
        this.f3572b = function1;
        this.c = function2;
    }

    public static final /* synthetic */ Function1 access$getIterator$p(h hVar) {
        return hVar.c;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(h hVar) {
        return hVar.a;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(h hVar) {
        return hVar.f3572b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new h$a(this);
    }
}
