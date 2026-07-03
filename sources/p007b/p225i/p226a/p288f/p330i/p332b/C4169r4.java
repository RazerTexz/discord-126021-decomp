package p007b.p225i.p226a.p288f.p330i.p332b;

import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.i.b.r4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4169r4 extends AbstractC4170r5 {

    /* JADX INFO: renamed from: c */
    public static final AtomicLong f11167c = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: d */
    public C4213v4 f11168d;

    /* JADX INFO: renamed from: e */
    public C4213v4 f11169e;

    /* JADX INFO: renamed from: f */
    public final PriorityBlockingQueue<C4180s4<?>> f11170f;

    /* JADX INFO: renamed from: g */
    public final BlockingQueue<C4180s4<?>> f11171g;

    /* JADX INFO: renamed from: h */
    public final Thread.UncaughtExceptionHandler f11172h;

    /* JADX INFO: renamed from: i */
    public final Thread.UncaughtExceptionHandler f11173i;

    /* JADX INFO: renamed from: j */
    public final Object f11174j;

    /* JADX INFO: renamed from: k */
    public final Semaphore f11175k;

    public C4169r4(C4202u4 c4202u4) {
        super(c4202u4);
        this.f11174j = new Object();
        this.f11175k = new Semaphore(2);
        this.f11170f = new PriorityBlockingQueue<>();
        this.f11171g = new LinkedBlockingQueue();
        this.f11172h = new C4191t4(this, "Thread death: Uncaught exception on worker thread");
        this.f11173i = new C4191t4(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.C4181s5
    /* JADX INFO: renamed from: a */
    public final void mo5847a() {
        if (Thread.currentThread() != this.f11169e) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.C4181s5
    /* JADX INFO: renamed from: b */
    public final void mo5848b() {
        if (Thread.currentThread() != this.f11168d) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4170r5
    /* JADX INFO: renamed from: r */
    public final boolean mo5574r() {
        return false;
    }

    /* JADX INFO: renamed from: s */
    public final <T> T m5849s(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            mo5725f().m5852v(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                mo5726g().f11144i.m5860a(str.length() != 0 ? "Interrupted waiting for ".concat(str) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            mo5726g().f11144i.m5860a(str.length() != 0 ? "Timed out waiting for ".concat(str) : new String("Timed out waiting for "));
        }
        return t;
    }

    /* JADX INFO: renamed from: t */
    public final <V> Future<V> m5850t(Callable<V> callable) throws IllegalStateException {
        m5857o();
        C4180s4<?> c4180s4 = new C4180s4<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f11168d) {
            if (!this.f11170f.isEmpty()) {
                mo5726g().f11144i.m5860a("Callable skipped the worker queue.");
            }
            c4180s4.run();
        } else {
            m5851u(c4180s4);
        }
        return c4180s4;
    }

    /* JADX INFO: renamed from: u */
    public final void m5851u(C4180s4<?> c4180s4) {
        synchronized (this.f11174j) {
            this.f11170f.add(c4180s4);
            C4213v4 c4213v4 = this.f11168d;
            if (c4213v4 == null) {
                C4213v4 c4213v5 = new C4213v4(this, "Measurement Worker", this.f11170f);
                this.f11168d = c4213v5;
                c4213v5.setUncaughtExceptionHandler(this.f11172h);
                this.f11168d.start();
            } else {
                synchronized (c4213v4.f11300j) {
                    c4213v4.f11300j.notifyAll();
                }
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public final void m5852v(Runnable runnable) throws IllegalStateException {
        m5857o();
        Objects.requireNonNull(runnable, "null reference");
        m5851u(new C4180s4<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* JADX INFO: renamed from: w */
    public final void m5853w(Runnable runnable) throws IllegalStateException {
        m5857o();
        m5851u(new C4180s4<>(this, runnable, true, "Task exception on worker thread"));
    }

    /* JADX INFO: renamed from: x */
    public final void m5854x(Runnable runnable) throws IllegalStateException {
        m5857o();
        C4180s4<?> c4180s4 = new C4180s4<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f11174j) {
            this.f11171g.add(c4180s4);
            C4213v4 c4213v4 = this.f11169e;
            if (c4213v4 == null) {
                C4213v4 c4213v5 = new C4213v4(this, "Measurement Network", this.f11171g);
                this.f11169e = c4213v5;
                c4213v5.setUncaughtExceptionHandler(this.f11173i);
                this.f11169e.start();
            } else {
                synchronized (c4213v4.f11300j) {
                    c4213v4.f11300j.notifyAll();
                }
            }
        }
    }

    /* JADX INFO: renamed from: y */
    public final boolean m5855y() {
        return Thread.currentThread() == this.f11168d;
    }
}
