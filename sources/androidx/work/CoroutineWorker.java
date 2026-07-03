package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p359d.p360a.InterfaceFutureC4539a;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13110f1;
import p659s.p660a.C13124k0;
import p659s.p660a.C13126l;
import p659s.p660a.InterfaceC13153u;

/* JADX INFO: compiled from: CoroutineWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final InterfaceC13153u job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1 */
    /* JADX INFO: compiled from: CoroutineWorker.kt */
    @InterfaceC12188e(m10084c = "androidx.work.CoroutineWorker$startWork$1", m10085f = "CoroutineWorker.kt", m10086l = {68}, m10087m = "invokeSuspend")
    public static final class C07141 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object L$0;
        public int label;

        /* JADX INFO: renamed from: p$ */
        private CoroutineScope f162p$;

        public C07141(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkParameterIsNotNull(continuation, "completion");
            C07141 c07141 = CoroutineWorker.this.new C07141(continuation);
            c07141.f162p$ = (CoroutineScope) obj;
            return c07141;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07141) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    C12113l.throwOnFailure(obj);
                    CoroutineScope coroutineScope = this.f162p$;
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = coroutineWorker.doWork(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C12113l.throwOnFailure(obj);
                }
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().setException(th);
            }
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        C12238m.checkParameterIsNotNull(context, "appContext");
        C12238m.checkParameterIsNotNull(workerParameters, "params");
        this.job = new C13110f1(null);
        SettableFuture<ListenableWorker.Result> settableFutureCreate = SettableFuture.create();
        C12238m.checkExpressionValueIsNotNull(settableFutureCreate, "SettableFuture.create()");
        this.future = settableFutureCreate;
        Runnable runnable = new Runnable() { // from class: androidx.work.CoroutineWorker.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CoroutineWorker.this.getFuture$work_runtime_ktx_release().isCancelled()) {
                    C3404f.m4343t(CoroutineWorker.this.getJob(), null, 1, null);
                }
            }
        };
        TaskExecutor taskExecutor = getTaskExecutor();
        C12238m.checkExpressionValueIsNotNull(taskExecutor, "taskExecutor");
        settableFutureCreate.addListener(runnable, taskExecutor.getBackgroundExecutor());
        this.coroutineContext = C13124k0.f27866a;
    }

    public static /* synthetic */ void coroutineContext$annotations() {
    }

    public abstract Object doWork(Continuation<? super ListenableWorker.Result> continuation);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    /* JADX INFO: renamed from: getJob$work_runtime_ktx_release, reason: from getter */
    public final InterfaceC13153u getJob() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, Continuation<? super Unit> continuation) throws Throwable {
        Object objM11326u;
        final InterfaceFutureC4539a<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        C12238m.checkExpressionValueIsNotNull(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                objM11326u = foregroundAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            final C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
            foregroundAsync.addListener(new Runnable() { // from class: androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        CancellableContinuation cancellableContinuation = c13126l;
                        V v = foregroundAsync.get();
                        C12112k.a aVar = C12112k.f25169j;
                        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(v));
                    } catch (Throwable th) {
                        Throwable cause2 = th.getCause();
                        if (cause2 == null) {
                            cause2 = th;
                        }
                        if (th instanceof CancellationException) {
                            c13126l.mo10906k(cause2);
                            return;
                        }
                        CancellableContinuation cancellableContinuation2 = c13126l;
                        C12112k.a aVar2 = C12112k.f25169j;
                        cancellableContinuation2.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(cause2)));
                    }
                }
            }, DirectExecutor.INSTANCE);
            objM11326u = c13126l.m11326u();
            if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
                C12190g.probeCoroutineSuspended(continuation);
            }
        }
        return objM11326u == C12183c.getCOROUTINE_SUSPENDED() ? objM11326u : Unit.f27425a;
    }

    public final Object setProgress(Data data, Continuation<? super Unit> continuation) throws Throwable {
        Object objM11326u;
        final InterfaceFutureC4539a<Void> progressAsync = setProgressAsync(data);
        C12238m.checkExpressionValueIsNotNull(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                objM11326u = progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            final C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
            progressAsync.addListener(new Runnable() { // from class: androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        CancellableContinuation cancellableContinuation = c13126l;
                        V v = progressAsync.get();
                        C12112k.a aVar = C12112k.f25169j;
                        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(v));
                    } catch (Throwable th) {
                        Throwable cause2 = th.getCause();
                        if (cause2 == null) {
                            cause2 = th;
                        }
                        if (th instanceof CancellationException) {
                            c13126l.mo10906k(cause2);
                            return;
                        }
                        CancellableContinuation cancellableContinuation2 = c13126l;
                        C12112k.a aVar2 = C12112k.f25169j;
                        cancellableContinuation2.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(cause2)));
                    }
                }
            }, DirectExecutor.INSTANCE);
            objM11326u = c13126l.m11326u();
            if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
                C12190g.probeCoroutineSuspended(continuation);
            }
        }
        return objM11326u == C12183c.getCOROUTINE_SUSPENDED() ? objM11326u : Unit.f27425a;
    }

    @Override // androidx.work.ListenableWorker
    public final InterfaceFutureC4539a<ListenableWorker.Result> startWork() {
        C3404f.m4211H0(C3404f.m4275c(getCoroutineContext().plus(this.job)), null, null, new C07141(null), 3, null);
        return this.future;
    }
}
