package d0.f0;

import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T, K> implements Sequence<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, K> f3569b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        Intrinsics3.checkNotNullParameter(sequence, "source");
        Intrinsics3.checkNotNullParameter(function1, "keySelector");
        this.a = sequence;
        this.f3569b = function1;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new b(this.a.iterator(), this.f3569b);
    }
}
