package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p507d0.p584w.C12179f;

/* JADX INFO: renamed from: d0.w.i.a.i */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12192i extends AbstractC12184a {
    public AbstractC12192i(Continuation<Object> continuation) {
        super(continuation);
        if (continuation != null) {
            if (!(continuation.getContext() == C12179f.f25237j)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return C12179f.f25237j;
    }
}
