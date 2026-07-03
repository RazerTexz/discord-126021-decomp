package p507d0.p578f0;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.sequences.Sequence;
import p507d0.p584w.p585h.C12183c;

/* JADX INFO: renamed from: d0.f0.k */
/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12072k<T> {
    public abstract Object yield(T t, Continuation<? super Unit> continuation);

    public abstract Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation);

    public final Object yieldAll(Sequence<? extends T> sequence, Continuation<? super Unit> continuation) {
        Object objYieldAll = yieldAll(sequence.iterator(), continuation);
        return objYieldAll == C12183c.getCOROUTINE_SUSPENDED() ? objYieldAll : Unit.f27425a;
    }
}
