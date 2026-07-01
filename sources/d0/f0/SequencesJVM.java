package d0.f0;

import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.f0.a, reason: use source file name */
/* JADX INFO: compiled from: SequencesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SequencesJVM<T> implements Sequence<T> {
    public final AtomicReference<Sequence<T>> a;

    public SequencesJVM(Sequence<? extends T> sequence) {
        Intrinsics3.checkNotNullParameter(sequence, "sequence");
        this.a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        Sequence<T> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
