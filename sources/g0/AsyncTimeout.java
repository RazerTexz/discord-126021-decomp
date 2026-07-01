package g0;

import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: g0.b, reason: use source file name */
/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncTimeout extends Timeout2 {
    public static final long e;
    public static final long f;
    public static AsyncTimeout g;
    public static final a h = new a(null);
    public boolean i;
    public AsyncTimeout j;
    public long k;

    /* JADX INFO: renamed from: g0.b$a */
    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AsyncTimeout a() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.g;
            if (asyncTimeout == null) {
                Intrinsics3.throwNpe();
            }
            AsyncTimeout asyncTimeout2 = asyncTimeout.j;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.e);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.g;
                if (asyncTimeout3 == null) {
                    Intrinsics3.throwNpe();
                }
                if (asyncTimeout3.j != null || System.nanoTime() - jNanoTime < AsyncTimeout.f) {
                    return null;
                }
                return AsyncTimeout.g;
            }
            long jNanoTime2 = asyncTimeout2.k - System.nanoTime();
            if (jNanoTime2 > 0) {
                long j = jNanoTime2 / 1000000;
                AsyncTimeout.class.wait(j, (int) (jNanoTime2 - (1000000 * j)));
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.g;
            if (asyncTimeout4 == null) {
                Intrinsics3.throwNpe();
            }
            asyncTimeout4.j = asyncTimeout2.j;
            asyncTimeout2.j = null;
            return asyncTimeout2;
        }
    }

    /* JADX INFO: renamed from: g0.b$b */
    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout asyncTimeoutA;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        asyncTimeoutA = AsyncTimeout.h.a();
                        if (asyncTimeoutA == AsyncTimeout.g) {
                            AsyncTimeout.g = null;
                            return;
                        }
                    }
                    if (asyncTimeoutA != null) {
                        asyncTimeoutA.l();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        e = millis;
        f = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void i() {
        AsyncTimeout asyncTimeout;
        if (!(!this.i)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long j = this.d;
        boolean z2 = this.f3695b;
        if (j != 0 || z2) {
            this.i = true;
            synchronized (AsyncTimeout.class) {
                if (g == null) {
                    g = new AsyncTimeout();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z2) {
                    this.k = Math.min(j, c() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    this.k = j + jNanoTime;
                } else {
                    if (!z2) {
                        throw new AssertionError();
                    }
                    this.k = c();
                }
                long j2 = this.k - jNanoTime;
                AsyncTimeout asyncTimeout2 = g;
                if (asyncTimeout2 == null) {
                    Intrinsics3.throwNpe();
                }
                while (true) {
                    asyncTimeout = asyncTimeout2.j;
                    if (asyncTimeout == null || j2 < asyncTimeout.k - jNanoTime) {
                        break;
                        break;
                    }
                    asyncTimeout2 = asyncTimeout;
                }
                this.j = asyncTimeout;
                asyncTimeout2.j = this;
                if (asyncTimeout2 == g) {
                    AsyncTimeout.class.notify();
                }
            }
        }
    }

    public final boolean j() {
        boolean z2 = false;
        if (!this.i) {
            return false;
        }
        this.i = false;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout = g;
            while (asyncTimeout != null) {
                AsyncTimeout asyncTimeout2 = asyncTimeout.j;
                if (asyncTimeout2 == this) {
                    asyncTimeout.j = this.j;
                    this.j = null;
                } else {
                    asyncTimeout = asyncTimeout2;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public IOException k(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void l() {
    }
}
