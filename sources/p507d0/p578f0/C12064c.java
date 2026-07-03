package p507d0.p578f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.f0.c */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12064c<T, K> implements Sequence<T> {

    /* JADX INFO: renamed from: a */
    public final Sequence<T> f25075a;

    /* JADX INFO: renamed from: b */
    public final Function1<T, K> f25076b;

    /* JADX WARN: Multi-variable type inference failed */
    public C12064c(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        C12238m.checkNotNullParameter(sequence, "source");
        C12238m.checkNotNullParameter(function1, "keySelector");
        this.f25075a = sequence;
        this.f25076b = function1;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new C12063b(this.f25075a.iterator(), this.f25076b);
    }
}
