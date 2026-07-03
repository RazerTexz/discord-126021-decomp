package p507d0.p584w.p586i.p587a;

import java.io.Serializable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.i.a.a */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12184a implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    public AbstractC12184a(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public Continuation<Unit> create(Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
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
        return C12189f.getStackTraceElement(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        AbstractC12184a abstractC12184a = this;
        while (true) {
            C12190g.probeCoroutineResumed(abstractC12184a);
            Continuation<Object> continuation = abstractC12184a.completion;
            C12238m.checkNotNull(continuation);
            try {
                Object objInvokeSuspend = abstractC12184a.invokeSuspend(obj);
                if (objInvokeSuspend == C12183c.getCOROUTINE_SUSPENDED()) {
                    return;
                }
                C12112k.a aVar = C12112k.f25169j;
                obj = C12112k.m11474constructorimpl(objInvokeSuspend);
            } catch (Throwable th) {
                C12112k.a aVar2 = C12112k.f25169j;
                obj = C12112k.m11474constructorimpl(C12113l.createFailure(th));
            }
            abstractC12184a.releaseIntercepted();
            if (!(continuation instanceof AbstractC12184a)) {
                continuation.resumeWith(obj);
                return;
            }
            abstractC12184a = (AbstractC12184a) continuation;
        }
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sbM833U.append(stackTraceElement);
        return sbM833U.toString();
    }

    public Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
