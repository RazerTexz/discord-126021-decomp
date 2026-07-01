package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t<T> implements Sequence<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Boolean> f3577b;

    /* JADX WARN: Multi-variable type inference failed */
    public t(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "sequence");
        d0.z.d.m.checkNotNullParameter(function1, "predicate");
        this.a = sequence;
        this.f3577b = function1;
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(t tVar) {
        return tVar.f3577b;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(t tVar) {
        return tVar.a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new t$a(this);
    }
}
