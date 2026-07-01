package g0;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b extends y {
    public static final long e;
    public static final long f;
    public static b g;
    public static final b$a h = new b$a(null);
    public boolean i;
    public b j;
    public long k;

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        e = millis;
        f = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void i() {
        b bVar;
        if (!(!this.i)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long j = this.d;
        boolean z2 = this.f3695b;
        if (j != 0 || z2) {
            this.i = true;
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                    new b$b().start();
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
                b bVar2 = g;
                if (bVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                while (true) {
                    bVar = bVar2.j;
                    if (bVar == null || j2 < bVar.k - jNanoTime) {
                        break;
                        break;
                    }
                    bVar2 = bVar;
                }
                this.j = bVar;
                bVar2.j = this;
                if (bVar2 == g) {
                    b.class.notify();
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
        synchronized (b.class) {
            b bVar = g;
            while (bVar != null) {
                b bVar2 = bVar.j;
                if (bVar2 == this) {
                    bVar.j = this.j;
                    this.j = null;
                } else {
                    bVar = bVar2;
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
