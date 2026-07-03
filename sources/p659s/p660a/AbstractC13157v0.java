package p659s.p660a;

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
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: s.a.v0 */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13157v0 extends ExecutorCoroutineDispatcher implements InterfaceC13115h0 {

    /* JADX INFO: renamed from: j */
    public boolean f27911j;

    /* JADX INFO: renamed from: I */
    public final ScheduledFuture<?> m11350I(Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            Executor executorMo10908H = mo10908H();
            if (!(executorMo10908H instanceof ScheduledExecutorService)) {
                executorMo10908H = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executorMo10908H;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
            }
            return null;
        } catch (RejectedExecutionException e) {
            CancellationException cancellationExceptionM4267a = C3404f.m4267a("The task was rejected", e);
            Job job = (Job) coroutineContext.get(Job.INSTANCE);
            if (job == null) {
                return null;
            }
            job.mo10911b(cancellationExceptionM4267a);
            return null;
        }
    }

    @Override // p659s.p660a.InterfaceC13115h0
    /* JADX INFO: renamed from: c */
    public void mo11195c(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledFuture<?> scheduledFutureM11350I = this.f27911j ? m11350I(new RunnableC13149s1(this, cancellableContinuation), ((C13126l) cancellableContinuation).f27871o, j) : null;
        if (scheduledFutureM11350I != null) {
            ((C13126l) cancellableContinuation).mo10902f(new C13117i(scheduledFutureM11350I));
        } else {
            RunnableC13077d0.f27779q.mo11195c(j, cancellableContinuation);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorMo10908H = mo10908H();
        if (!(executorMo10908H instanceof ExecutorService)) {
            executorMo10908H = null;
        }
        ExecutorService executorService = (ExecutorService) executorMo10908H;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            mo10908H().execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationExceptionM4267a = C3404f.m4267a("The task was rejected", e);
            Job job = (Job) coroutineContext.get(Job.INSTANCE);
            if (job != null) {
                job.mo10911b(cancellationExceptionM4267a);
            }
            C13124k0.f27867b.dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractC13157v0) && ((AbstractC13157v0) obj).mo10908H() == mo10908H();
    }

    public int hashCode() {
        return System.identityHashCode(mo10908H());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return mo10908H().toString();
    }

    @Override // p659s.p660a.InterfaceC13115h0
    /* JADX INFO: renamed from: x */
    public InterfaceC13130m0 mo11196x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        ScheduledFuture<?> scheduledFutureM11350I = this.f27911j ? m11350I(runnable, coroutineContext, j) : null;
        return scheduledFutureM11350I != null ? new C13127l0(scheduledFutureM11350I) : RunnableC13077d0.f27779q.mo11196x(j, runnable, coroutineContext);
    }
}
