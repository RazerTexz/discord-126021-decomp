package p659s.p660a.p666e2;

import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import p659s.p660a.RunnableC13077d0;

/* JADX INFO: renamed from: s.a.e2.e */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutorC13099e extends ExecutorCoroutineDispatcher implements InterfaceC13103i, Executor {

    /* JADX INFO: renamed from: j */
    public static final AtomicIntegerFieldUpdater f27820j = AtomicIntegerFieldUpdater.newUpdater(ExecutorC13099e.class, "inFlightTasks");

    /* JADX INFO: renamed from: l */
    public final C13097c f27822l;

    /* JADX INFO: renamed from: m */
    public final int f27823m;

    /* JADX INFO: renamed from: n */
    public final String f27824n;

    /* JADX INFO: renamed from: o */
    public final int f27825o;

    /* JADX INFO: renamed from: k */
    public final ConcurrentLinkedQueue<Runnable> f27821k = new ConcurrentLinkedQueue<>();
    public volatile int inFlightTasks = 0;

    public ExecutorC13099e(C13097c c13097c, int i, String str, int i2) {
        this.f27822l = c13097c;
        this.f27823m = i;
        this.f27824n = str;
        this.f27825o = i2;
    }

    /* JADX INFO: renamed from: I */
    public final void m11267I(Runnable runnable, boolean z2) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f27820j;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f27823m) {
                C13097c c13097c = this.f27822l;
                Objects.requireNonNull(c13097c);
                try {
                    c13097c.f27815j.m11254d(runnable, this, z2);
                    return;
                } catch (RejectedExecutionException unused) {
                    RunnableC13077d0.f27779q.m11341T(c13097c.f27815j.m11252b(runnable, this));
                    return;
                }
            }
            this.f27821k.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f27823m) {
                return;
            } else {
                runnable = this.f27821k.poll();
            }
        } while (runnable != null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m11267I(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        m11267I(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m11267I(runnable, false);
    }

    @Override // p659s.p660a.p666e2.InterfaceC13103i
    /* JADX INFO: renamed from: f */
    public void mo11268f() {
        Runnable runnablePoll = this.f27821k.poll();
        if (runnablePoll != null) {
            C13097c c13097c = this.f27822l;
            Objects.requireNonNull(c13097c);
            try {
                c13097c.f27815j.m11254d(runnablePoll, this, true);
                return;
            } catch (RejectedExecutionException unused) {
                RunnableC13077d0.f27779q.m11341T(c13097c.f27815j.m11252b(runnablePoll, this));
                return;
            }
        }
        f27820j.decrementAndGet(this);
        Runnable runnablePoll2 = this.f27821k.poll();
        if (runnablePoll2 != null) {
            m11267I(runnablePoll2, true);
        }
    }

    @Override // p659s.p660a.p666e2.InterfaceC13103i
    /* JADX INFO: renamed from: t */
    public int mo11269t() {
        return this.f27825o;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str = this.f27824n;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f27822l + ']';
    }
}
