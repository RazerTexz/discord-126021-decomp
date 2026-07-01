package s.a;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Executors;
import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: s.a.v0, reason: use source file name */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Executors5 extends Executors implements Delay {
    public boolean j;

    public final ScheduledFuture<?> I(Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            Executor executorH = H();
            if (!(executorH instanceof ScheduledExecutorService)) {
                executorH = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executorH;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
            }
            return null;
        } catch (RejectedExecutionException e) {
            CancellationException cancellationExceptionA = b.i.a.f.e.o.f.a("The task was rejected", e);
            Job job = (Job) coroutineContext.get(Job.INSTANCE);
            if (job == null) {
                return null;
            }
            job.b(cancellationExceptionA);
            return null;
        }
    }

    @Override // s.a.Delay
    public void c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledFuture<?> scheduledFutureI = this.j ? I(new Executors3(this, cancellableContinuation), ((CancellableContinuationImpl5) cancellableContinuation).o, j) : null;
        if (scheduledFutureI != null) {
            ((CancellableContinuationImpl5) cancellableContinuation).f(new Future(scheduledFutureI));
        } else {
            DefaultExecutor.q.c(j, cancellableContinuation);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorH = H();
        if (!(executorH instanceof ExecutorService)) {
            executorH = null;
        }
        ExecutorService executorService = (ExecutorService) executorH;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            H().execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationExceptionA = b.i.a.f.e.o.f.a("The task was rejected", e);
            Job job = (Job) coroutineContext.get(Job.INSTANCE);
            if (job != null) {
                job.b(cancellationExceptionA);
            }
            Dispatchers.f3842b.dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Executors5) && ((Executors5) obj).H() == H();
    }

    public int hashCode() {
        return System.identityHashCode(H());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return H().toString();
    }

    @Override // s.a.Delay
    public Job2 x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        ScheduledFuture<?> scheduledFutureI = this.j ? I(runnable, coroutineContext, j) : null;
        return scheduledFutureI != null ? new Executors2(scheduledFutureI) : DefaultExecutor.q.x(j, runnable, coroutineContext);
    }
}
