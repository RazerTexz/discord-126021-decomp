package p659s.p660a.p664d2.p665g;

import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12112k;
import p507d0.p579g0.C12096m;
import p507d0.p584w.C12179f;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p592z.p594d.AbstractC12240o;
import p659s.p660a.p664d2.InterfaceC13083e;

/* JADX INFO: renamed from: s.a.d2.g.e */
/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13089e<T> extends AbstractC12187d implements InterfaceC13083e<T>, CoroutineStackFrame {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final InterfaceC13083e<T> collector;
    private Continuation<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    /* JADX INFO: renamed from: s.a.d2.g.e$a */
    /* JADX INFO: compiled from: SafeCollector.kt */
    public static final class a extends AbstractC12240o implements Function2<Integer, CoroutineContext.Element, Integer> {

        /* JADX INFO: renamed from: j */
        public static final a f27791j = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Integer invoke(Integer num, CoroutineContext.Element element) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C13089e(InterfaceC13083e<? super T> interfaceC13083e, CoroutineContext coroutineContext) {
        super(C13088d.f27790j, C12179f.f25237j);
        this.collector = interfaceC13083e;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, a.f27791j)).intValue();
    }

    /* JADX INFO: renamed from: b */
    public final Object m11249b(Continuation<? super Unit> continuation, T t) {
        CoroutineContext context = continuation.getContext();
        Job job = (Job) context.get(Job.INSTANCE);
        if (job != null && !job.mo10910a()) {
            throw job.mo10914q();
        }
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            if (coroutineContext instanceof C13087c) {
                StringBuilder sbM833U = C1643a.m833U("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
                sbM833U.append(((C13087c) coroutineContext).f27789k);
                sbM833U.append(", but then emission attempt of value '");
                sbM833U.append(t);
                sbM833U.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                throw new IllegalStateException(C12096m.trimIndent(sbM833U.toString()).toString());
            }
            if (((Number) context.fold(0, new C13091g(this))).intValue() != this.collectContextSize) {
                StringBuilder sbM836X = C1643a.m836X("Flow invariant is violated:\n", "\t\tFlow was collected in ");
                sbM836X.append(this.collectContext);
                sbM836X.append(",\n");
                sbM836X.append("\t\tbut emission happened in ");
                sbM836X.append(context);
                throw new IllegalStateException(C1643a.m822J(sbM836X, ".\n", "\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.lastEmissionContext = context;
        }
        this.completion = continuation;
        Function3<InterfaceC13083e<Object>, Object, Continuation<? super Unit>, Object> function3 = C13090f.f27792a;
        InterfaceC13083e<T> interfaceC13083e = this.collector;
        Objects.requireNonNull(interfaceC13083e, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        return function3.invoke(interfaceC13083e, t, this);
    }

    @Override // p659s.p660a.p664d2.InterfaceC13083e
    public Object emit(T t, Continuation<? super Unit> continuation) {
        try {
            Object objM11249b = m11249b(continuation, t);
            if (objM11249b == C12183c.getCOROUTINE_SUSPENDED()) {
                C12190g.probeCoroutineSuspended(continuation);
            }
            return objM11249b == C12183c.getCOROUTINE_SUSPENDED() ? objM11249b : Unit.f27425a;
        } catch (Throwable th) {
            this.lastEmissionContext = new C13087c(th);
            throw th;
        }
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.completion;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12187d, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext context;
        Continuation<? super Unit> continuation = this.completion;
        return (continuation == null || (context = continuation.getContext()) == null) ? C12179f.f25237j : context;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public Object invokeSuspend(Object obj) {
        Throwable thM11476exceptionOrNullimpl = C12112k.m11476exceptionOrNullimpl(obj);
        if (thM11476exceptionOrNullimpl != null) {
            this.lastEmissionContext = new C13087c(thM11476exceptionOrNullimpl);
        }
        Continuation<? super Unit> continuation = this.completion;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return C12183c.getCOROUTINE_SUSPENDED();
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12187d, p507d0.p584w.p586i.p587a.AbstractC12184a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
