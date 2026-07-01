package d0.f0;

import d0.w.h.Intrinsics2;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.f0.k, reason: use source file name */
/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SequenceBuilder2<T> {
    public abstract Object yield(T t, Continuation<? super Unit> continuation);

    public abstract Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation);

    public final Object yieldAll(Sequence<? extends T> sequence, Continuation<? super Unit> continuation) {
        Object objYieldAll = yieldAll(sequence.iterator(), continuation);
        return objYieldAll == Intrinsics2.getCOROUTINE_SUSPENDED() ? objYieldAll : Unit.a;
    }
}
