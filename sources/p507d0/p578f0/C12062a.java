package p507d0.p578f0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.f0.a */
/* JADX INFO: compiled from: SequencesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12062a<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a */
    public final AtomicReference<Sequence<T>> f25071a;

    public C12062a(Sequence<? extends T> sequence) {
        C12238m.checkNotNullParameter(sequence, "sequence");
        this.f25071a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        Sequence<T> andSet = this.f25071a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
