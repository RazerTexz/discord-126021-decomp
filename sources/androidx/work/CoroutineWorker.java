package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import b.i.a.f.e.o.f;
import b.i.b.d.a.a;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.g;
import d0.z.d.m;
import java.util.concurrent.ExecutionException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.f1;
import s.a.k0;
import s.a.l;
import s.a.u;

/* JADX INFO: compiled from: CoroutineWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker$Result> future;
    private final u job;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.checkParameterIsNotNull(context, "appContext");
        m.checkParameterIsNotNull(workerParameters, "params");
        this.job = new f1(null);
        SettableFuture<ListenableWorker$Result> settableFutureCreate = SettableFuture.create();
        m.checkExpressionValueIsNotNull(settableFutureCreate, "SettableFuture.create()");
        this.future = settableFutureCreate;
        CoroutineWorker$1 coroutineWorker$1 = new CoroutineWorker$1(this);
        TaskExecutor taskExecutor = getTaskExecutor();
        m.checkExpressionValueIsNotNull(taskExecutor, "taskExecutor");
        settableFutureCreate.addListener(coroutineWorker$1, taskExecutor.getBackgroundExecutor());
        this.coroutineContext = k0.a;
    }

    public static /* synthetic */ void coroutineContext$annotations() {
    }

    public abstract Object doWork(Continuation<? super ListenableWorker$Result> continuation);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public final SettableFuture<ListenableWorker$Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    /* JADX INFO: renamed from: getJob$work_runtime_ktx_release, reason: from getter */
    public final u getJob() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, Continuation<? super Unit> continuation) throws Throwable {
        Object objU;
        a<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        m.checkExpressionValueIsNotNull(foregroundAsync, "setForegroundAsync(foregroundInfo)");
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
            l lVar = new l(b.intercepted(continuation), 1);
            foregroundAsync.addListener(new CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2(lVar, foregroundAsync), DirectExecutor.INSTANCE);
            objU = lVar.u();
            if (objU == c.getCOROUTINE_SUSPENDED()) {
                g.probeCoroutineSuspended(continuation);
            }
        }
        return objU == c.getCOROUTINE_SUSPENDED() ? objU : Unit.a;
    }

    public final Object setProgress(Data data, Continuation<? super Unit> continuation) throws Throwable {
        Object objU;
        a<Void> progressAsync = setProgressAsync(data);
        m.checkExpressionValueIsNotNull(progressAsync, "setProgressAsync(data)");
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
            l lVar = new l(b.intercepted(continuation), 1);
            progressAsync.addListener(new CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$1(lVar, progressAsync), DirectExecutor.INSTANCE);
            objU = lVar.u();
            if (objU == c.getCOROUTINE_SUSPENDED()) {
                g.probeCoroutineSuspended(continuation);
            }
        }
        return objU == c.getCOROUTINE_SUSPENDED() ? objU : Unit.a;
    }

    @Override // androidx.work.ListenableWorker
    public final a<ListenableWorker$Result> startWork() {
        f.H0(f.c(getCoroutineContext().plus(this.job)), null, null, new CoroutineWorker$startWork$1(this, null), 3, null);
        return this.future;
    }
}
