package b.i.a.f.i.b;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r4 extends r5 {
    public static final AtomicLong c = new AtomicLong(Long.MIN_VALUE);
    public v4 d;
    public v4 e;
    public final PriorityBlockingQueue<s4<?>> f;
    public final BlockingQueue<s4<?>> g;
    public final Thread$UncaughtExceptionHandler h;
    public final Thread$UncaughtExceptionHandler i;
    public final Object j;
    public final Semaphore k;

    public r4(u4 u4Var) {
        super(u4Var);
        this.j = new Object();
        this.k = new Semaphore(2);
        this.f = new PriorityBlockingQueue<>();
        this.g = new LinkedBlockingQueue();
        this.h = new t4(this, "Thread death: Uncaught exception on worker thread");
        this.i = new t4(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // b.i.a.f.i.b.s5
    public final void a() {
        if (Thread.currentThread() != this.e) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // b.i.a.f.i.b.s5
    public final void b() {
        if (Thread.currentThread() != this.d) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // b.i.a.f.i.b.r5
    public final boolean r() {
        return false;
    }

    public final <T> T s(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            f().v(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                g().i.a(str.length() != 0 ? "Interrupted waiting for ".concat(str) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            g().i.a(str.length() != 0 ? "Timed out waiting for ".concat(str) : new String("Timed out waiting for "));
        }
        return t;
    }

    public final <V> Future<V> t(Callable<V> callable) throws IllegalStateException {
        o();
        s4<?> s4Var = new s4<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.d) {
            if (!this.f.isEmpty()) {
                g().i.a("Callable skipped the worker queue.");
            }
            s4Var.run();
        } else {
            u(s4Var);
        }
        return s4Var;
    }

    public final void u(s4<?> s4Var) {
        synchronized (this.j) {
            this.f.add(s4Var);
            v4 v4Var = this.d;
            if (v4Var == null) {
                v4 v4Var2 = new v4(this, "Measurement Worker", this.f);
                this.d = v4Var2;
                v4Var2.setUncaughtExceptionHandler(this.h);
                this.d.start();
            } else {
                synchronized (v4Var.j) {
                    v4Var.j.notifyAll();
                }
            }
        }
    }

    public final void v(Runnable runnable) throws IllegalStateException {
        o();
        Objects.requireNonNull(runnable, "null reference");
        u(new s4<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final void w(Runnable runnable) throws IllegalStateException {
        o();
        u(new s4<>(this, runnable, true, "Task exception on worker thread"));
    }

    public final void x(Runnable runnable) throws IllegalStateException {
        o();
        s4<?> s4Var = new s4<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.j) {
            this.g.add(s4Var);
            v4 v4Var = this.e;
            if (v4Var == null) {
                v4 v4Var2 = new v4(this, "Measurement Network", this.g);
                this.e = v4Var2;
                v4Var2.setUncaughtExceptionHandler(this.i);
                this.e.start();
            } else {
                synchronized (v4Var.j) {
                    v4Var.j.notifyAll();
                }
            }
        }
    }

    public final boolean y() {
        return Thread.currentThread() == this.d;
    }
}
