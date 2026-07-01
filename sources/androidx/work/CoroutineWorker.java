package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import b.i.a.f.e.o.f;
import b.i.b.d.a.ListenableFuture8;
import d0.Result2;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.z.d.Intrinsics3;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import s.a.CancellableContinuationImpl5;
import s.a.CompletableJob;
import s.a.Dispatchers;
import s.a.f1;

/* JADX INFO: compiled from: CoroutineWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final CompletableJob job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineWorker.kt */
    @DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object L$0;
        public int label;
        private CoroutineScope p$;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 anonymousClass1 = CoroutineWorker.this.new AnonymousClass1(continuation);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    CoroutineScope coroutineScope = this.p$;
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
                    Result3.throwOnFailure(obj);
                }
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().set((ListenableWorker.Result) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().setException(th);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkParameterIsNotNull(context, "appContext");
        Intrinsics3.checkParameterIsNotNull(workerParameters, "params");
        this.job = new f1(null);
        SettableFuture<ListenableWorker.Result> settableFutureCreate = SettableFuture.create();
        Intrinsics3.checkExpressionValueIsNotNull(settableFutureCreate, "SettableFuture.create()");
        this.future = settableFutureCreate;
        Runnable runnable = new Runnable() { // from class: androidx.work.CoroutineWorker.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CoroutineWorker.this.getFuture$work_runtime_ktx_release().isCancelled()) {
                    f.t(CoroutineWorker.this.getJob(), null, 1, null);
                }
            }
        };
        TaskExecutor taskExecutor = getTaskExecutor();
        Intrinsics3.checkExpressionValueIsNotNull(taskExecutor, "taskExecutor");
        settableFutureCreate.addListener(runnable, taskExecutor.getBackgroundExecutor());
        this.coroutineContext = Dispatchers.a;
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
    public final CompletableJob getJob() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, Continuation<? super Unit> continuation) throws Throwable {
        Object objU;
        final ListenableFuture8<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        Intrinsics3.checkExpressionValueIsNotNull(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        if (foregroundAsync.isDone()) {
            try {
                objU = foregroundAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            final CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
            foregroundAsync.addListener(new Runnable() { // from class: androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        CancellableContinuation cancellableContinuation = cancellableContinuationImpl5;
                        V v = foregroundAsync.get();
                        Result2.a aVar = Result2.j;
                        cancellableContinuation.resumeWith(Result2.m97constructorimpl(v));
                    } catch (Throwable th) {
                        Throwable cause2 = th.getCause();
                        if (cause2 == null) {
                            cause2 = th;
                        }
                        if (th instanceof CancellationException) {
                            cancellableContinuationImpl5.k(cause2);
                            return;
                        }
                        CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl5;
                        Result2.a aVar2 = Result2.j;
                        cancellableContinuation2.resumeWith(Result2.m97constructorimpl(Result3.createFailure(cause2)));
                    }
                }
            }, DirectExecutor.INSTANCE);
            objU = cancellableContinuationImpl5.u();
            if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
        }
        return objU == Intrinsics2.getCOROUTINE_SUSPENDED() ? objU : Unit.a;
    }

    public final Object setProgress(Data data, Continuation<? super Unit> continuation) throws Throwable {
        Object objU;
        final ListenableFuture8<Void> progressAsync = setProgressAsync(data);
        Intrinsics3.checkExpressionValueIsNotNull(progressAsync, "setProgressAsync(data)");
        if (progressAsync.isDone()) {
            try {
                objU = progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            final CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
            progressAsync.addListener(new Runnable() { // from class: androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        CancellableContinuation cancellableContinuation = cancellableContinuationImpl5;
                        V v = progressAsync.get();
                        Result2.a aVar = Result2.j;
                        cancellableContinuation.resumeWith(Result2.m97constructorimpl(v));
                    } catch (Throwable th) {
                        Throwable cause2 = th.getCause();
                        if (cause2 == null) {
                            cause2 = th;
                        }
                        if (th instanceof CancellationException) {
                            cancellableContinuationImpl5.k(cause2);
                            return;
                        }
                        CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl5;
                        Result2.a aVar2 = Result2.j;
                        cancellableContinuation2.resumeWith(Result2.m97constructorimpl(Result3.createFailure(cause2)));
                    }
                }
            }, DirectExecutor.INSTANCE);
            objU = cancellableContinuationImpl5.u();
            if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
        }
        return objU == Intrinsics2.getCOROUTINE_SUSPENDED() ? objU : Unit.a;
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture8<ListenableWorker.Result> startWork() {
        f.H0(f.c(getCoroutineContext().plus(this.job)), null, null, new AnonymousClass1(null), 3, null);
        return this.future;
    }
}
