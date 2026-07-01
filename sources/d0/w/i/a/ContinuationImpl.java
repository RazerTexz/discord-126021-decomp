package d0.w.i.a;

import b.d.b.a.outline;
import d0.Result2;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: renamed from: d0.w.i.a.a, reason: use source file name */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    public ContinuationImpl(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return DebugMetadata2.getStackTraceElement(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        ContinuationImpl continuationImpl = this;
        while (true) {
            DebugProbes.probeCoroutineResumed(continuationImpl);
            Continuation<Object> continuation = continuationImpl.completion;
            Intrinsics3.checkNotNull(continuation);
            try {
                Object objInvokeSuspend = continuationImpl.invokeSuspend(obj);
                if (objInvokeSuspend == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    return;
                }
                Result2.a aVar = Result2.j;
                obj = Result2.m97constructorimpl(objInvokeSuspend);
            } catch (Throwable th) {
                Result2.a aVar2 = Result2.j;
                obj = Result2.m97constructorimpl(Result3.createFailure(th));
            }
            continuationImpl.releaseIntercepted();
            if (!(continuation instanceof ContinuationImpl)) {
                continuation.resumeWith(obj);
                return;
            }
            continuationImpl = (ContinuationImpl) continuation;
        }
    }

    public String toString() {
        StringBuilder sbU = outline.U("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sbU.append(stackTraceElement);
        return sbU.toString();
    }

    public Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
