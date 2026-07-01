package s.a.e2;

import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Executors;
import s.a.DefaultExecutor;

/* JADX INFO: renamed from: s.a.e2.e, reason: use source file name */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Dispatcher5 extends Executors implements Tasks5, Executor {
    public static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(Dispatcher5.class, "inFlightTasks");
    public final Dispatcher4 l;
    public final int m;
    public final String n;
    public final int o;
    public final ConcurrentLinkedQueue<Runnable> k = new ConcurrentLinkedQueue<>();
    public volatile int inFlightTasks = 0;

    public Dispatcher5(Dispatcher4 dispatcher4, int i, String str, int i2) {
        this.l = dispatcher4;
        this.m = i;
        this.n = str;
        this.o = i2;
    }

    public final void I(Runnable runnable, boolean z2) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = j;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.m) {
                Dispatcher4 dispatcher4 = this.l;
                Objects.requireNonNull(dispatcher4);
                try {
                    dispatcher4.j.d(runnable, this, z2);
                    return;
                } catch (RejectedExecutionException unused) {
                    DefaultExecutor.q.T(dispatcher4.j.b(runnable, this));
                    return;
                }
            }
            this.k.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.m) {
                return;
            } else {
                runnable = this.k.poll();
            }
        } while (runnable != null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        I(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        I(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        I(runnable, false);
    }

    @Override // s.a.e2.Tasks5
    public void f() {
        Runnable runnablePoll = this.k.poll();
        if (runnablePoll != null) {
            Dispatcher4 dispatcher4 = this.l;
            Objects.requireNonNull(dispatcher4);
            try {
                dispatcher4.j.d(runnablePoll, this, true);
                return;
            } catch (RejectedExecutionException unused) {
                DefaultExecutor.q.T(dispatcher4.j.b(runnablePoll, this));
                return;
            }
        }
        j.decrementAndGet(this);
        Runnable runnablePoll2 = this.k.poll();
        if (runnablePoll2 != null) {
            I(runnablePoll2, true);
        }
    }

    @Override // s.a.e2.Tasks5
    public int t() {
        return this.o;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str = this.n;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.l + ']';
    }
}
