package s.a.d2.g;

import b.d.b.a.outline;
import d0.Result2;
import d0.g0.Indent;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.DebugProbes;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;
import s.a.d2.FlowCollector;

/* JADX INFO: renamed from: s.a.d2.g.e, reason: use source file name */
/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SafeCollector3<T> extends ContinuationImpl3 implements FlowCollector<T>, CoroutineStackFrame {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final FlowCollector<T> collector;
    private Continuation<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    /* JADX INFO: renamed from: s.a.d2.g.e$a */
    /* JADX INFO: compiled from: SafeCollector.kt */
    public static final class a extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {
        public static final a j = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Integer invoke(Integer num, CoroutineContext.Element element) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector3(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super(SafeCollector2.j, CoroutineContextImpl4.j);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, a.j)).intValue();
    }

    public final Object b(Continuation<? super Unit> continuation, T t) {
        CoroutineContext context = continuation.getContext();
        Job job = (Job) context.get(Job.INSTANCE);
        if (job != null && !job.a()) {
            throw job.q();
        }
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            if (coroutineContext instanceof SafeCollector) {
                StringBuilder sbU = outline.U("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
                sbU.append(((SafeCollector) coroutineContext).k);
                sbU.append(", but then emission attempt of value '");
                sbU.append(t);
                sbU.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                throw new IllegalStateException(Indent.trimIndent(sbU.toString()).toString());
            }
            if (((Number) context.fold(0, new g(this))).intValue() != this.collectContextSize) {
                StringBuilder sbX = outline.X("Flow invariant is violated:\n", "\t\tFlow was collected in ");
                sbX.append(this.collectContext);
                sbX.append(",\n");
                sbX.append("\t\tbut emission happened in ");
                sbX.append(context);
                throw new IllegalStateException(outline.J(sbX, ".\n", "\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.lastEmissionContext = context;
        }
        this.completion = continuation;
        Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> function3 = SafeCollector4.a;
        FlowCollector<T> flowCollector = this.collector;
        Objects.requireNonNull(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        return function3.invoke(flowCollector, t, this);
    }

    @Override // s.a.d2.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        try {
            Object objB = b(continuation, t);
            if (objB == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return objB == Intrinsics2.getCOROUTINE_SUSPENDED() ? objB : Unit.a;
        } catch (Throwable th) {
            this.lastEmissionContext = new SafeCollector(th);
            throw th;
        }
    }

    @Override // d0.w.i.a.ContinuationImpl
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.completion;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // d0.w.i.a.ContinuationImpl3, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext context;
        Continuation<? super Unit> continuation = this.completion;
        return (continuation == null || (context = continuation.getContext()) == null) ? CoroutineContextImpl4.j : context;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public Object invokeSuspend(Object obj) {
        Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(obj);
        if (thM99exceptionOrNullimpl != null) {
            this.lastEmissionContext = new SafeCollector(thM99exceptionOrNullimpl);
        }
        Continuation<? super Unit> continuation = this.completion;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return Intrinsics2.getCOROUTINE_SUSPENDED();
    }

    @Override // d0.w.i.a.ContinuationImpl3, d0.w.i.a.ContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
