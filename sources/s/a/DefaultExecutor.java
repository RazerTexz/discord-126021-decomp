package s.a;

import androidx.recyclerview.widget.RecyclerView;
import d0.d0._Ranges;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import s.a.r0;

/* JADX INFO: renamed from: s.a.d0, reason: use source file name */
/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultExecutor extends r0 implements Runnable {
    public static volatile Thread _thread;
    public static volatile int debugStatus;
    public static final long p;
    public static final DefaultExecutor q;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        q = defaultExecutor;
        defaultExecutor.L(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        p = timeUnit.toNanos(l.longValue());
    }

    @Override // s.a.EventLoop2
    public Thread S() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    public final synchronized void X() {
        if (b0()) {
            debugStatus = 3;
            this._queue = null;
            this._delayed = null;
            notifyAll();
        }
    }

    public final boolean b0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z2;
        w1 w1Var = w1.f3847b;
        w1.a.set(this);
        try {
            synchronized (this) {
                if (b0()) {
                    z2 = false;
                } else {
                    z2 = true;
                    debugStatus = 1;
                    notifyAll();
                }
            }
            if (!z2) {
                _thread = null;
                X();
                if (V()) {
                    return;
                }
                S();
                return;
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jO = O();
                if (jO == RecyclerView.FOREVER_NS) {
                    long jNanoTime = System.nanoTime();
                    if (j == RecyclerView.FOREVER_NS) {
                        j = p + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        X();
                        if (V()) {
                            return;
                        }
                        S();
                        return;
                    }
                    jO = _Ranges.coerceAtMost(jO, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jO > 0) {
                    if (b0()) {
                        _thread = null;
                        X();
                        if (V()) {
                            return;
                        }
                        S();
                        return;
                    }
                    LockSupport.parkNanos(this, jO);
                }
            }
        } catch (Throwable th) {
            _thread = null;
            X();
            if (!V()) {
                S();
            }
            throw th;
        }
    }

    @Override // s.a.r0, s.a.Delay
    public Job2 x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        long jA = t0.a(j);
        if (jA >= 4611686018427387903L) {
            return Job3.j;
        }
        long jNanoTime = System.nanoTime();
        r0.b bVar = new r0.b(jA + jNanoTime, runnable);
        W(jNanoTime, bVar);
        return bVar;
    }
}
