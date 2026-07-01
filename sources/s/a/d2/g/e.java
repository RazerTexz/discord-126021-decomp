package s.a.d2.g;

import d0.g0.m;
import d0.k;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e<T> extends d0.w.i.a.d implements s.a.d2.e<T>, CoroutineStackFrame {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final s.a.d2.e<T> collector;
    private Continuation<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public e(s.a.d2.e<? super T> eVar, CoroutineContext coroutineContext) {
        super(d.j, d0.w.f.j);
        this.collector = eVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, e$a.j)).intValue();
    }

    public final Object b(Continuation<? super Unit> continuation, T t) {
        CoroutineContext context = continuation.getContext();
        Job job = (Job) context.get(Job.h);
        if (job != null && !job.a()) {
            throw job.q();
        }
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            if (coroutineContext instanceof c) {
                StringBuilder sbU = b.d.b.a.a.U("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
                sbU.append(((c) coroutineContext).k);
                sbU.append(", but then emission attempt of value '");
                sbU.append(t);
                sbU.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                throw new IllegalStateException(m.trimIndent(sbU.toString()).toString());
            }
            if (((Number) context.fold(0, new g(this))).intValue() != this.collectContextSize) {
                StringBuilder sbX = b.d.b.a.a.X("Flow invariant is violated:\n", "\t\tFlow was collected in ");
                sbX.append(this.collectContext);
                sbX.append(",\n");
                sbX.append("\t\tbut emission happened in ");
                sbX.append(context);
                throw new IllegalStateException(b.d.b.a.a.J(sbX, ".\n", "\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.lastEmissionContext = context;
        }
        this.completion = continuation;
        Function3<s.a.d2.e<Object>, Object, Continuation<? super Unit>, Object> function3 = f.a;
        s.a.d2.e<T> eVar = this.collector;
        Objects.requireNonNull(eVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        return function3.invoke(eVar, t, this);
    }

    @Override // s.a.d2.e
    public Object emit(T t, Continuation<? super Unit> continuation) {
        try {
            Object objB = b(continuation, t);
            if (objB == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                d0.w.i.a.g.probeCoroutineSuspended(continuation);
            }
            return objB == d0.w.h.c.getCOROUTINE_SUSPENDED() ? objB : Unit.a;
        } catch (Throwable th) {
            this.lastEmissionContext = new c(th);
            throw th;
        }
    }

    @Override // d0.w.i.a.a
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.completion;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // d0.w.i.a.d, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext context;
        Continuation<? super Unit> continuation = this.completion;
        return (continuation == null || (context = continuation.getContext()) == null) ? d0.w.f.j : context;
    }

    @Override // d0.w.i.a.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // d0.w.i.a.a
    public Object invokeSuspend(Object obj) {
        Throwable thM99exceptionOrNullimpl = k.m99exceptionOrNullimpl(obj);
        if (thM99exceptionOrNullimpl != null) {
            this.lastEmissionContext = new c(thM99exceptionOrNullimpl);
        }
        Continuation<? super Unit> continuation = this.completion;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return d0.w.h.c.getCOROUTINE_SUSPENDED();
    }

    @Override // d0.w.i.a.d, d0.w.i.a.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
