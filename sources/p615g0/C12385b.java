package p615g0;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.b */
/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12385b extends C12408y {

    /* JADX INFO: renamed from: e */
    public static final long f26068e;

    /* JADX INFO: renamed from: f */
    public static final long f26069f;

    /* JADX INFO: renamed from: g */
    public static C12385b f26070g;

    /* JADX INFO: renamed from: h */
    public static final a f26071h = new a(null);

    /* JADX INFO: renamed from: i */
    public boolean f26072i;

    /* JADX INFO: renamed from: j */
    public C12385b f26073j;

    /* JADX INFO: renamed from: k */
    public long f26074k;

    /* JADX INFO: renamed from: g0.b$a */
    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final C12385b m10426a() throws InterruptedException {
            C12385b c12385b = C12385b.f26070g;
            if (c12385b == null) {
                C12238m.throwNpe();
            }
            C12385b c12385b2 = c12385b.f26073j;
            if (c12385b2 == null) {
                long jNanoTime = System.nanoTime();
                C12385b.class.wait(C12385b.f26068e);
                C12385b c12385b3 = C12385b.f26070g;
                if (c12385b3 == null) {
                    C12238m.throwNpe();
                }
                if (c12385b3.f26073j != null || System.nanoTime() - jNanoTime < C12385b.f26069f) {
                    return null;
                }
                return C12385b.f26070g;
            }
            long jNanoTime2 = c12385b2.f26074k - System.nanoTime();
            if (jNanoTime2 > 0) {
                long j = jNanoTime2 / 1000000;
                C12385b.class.wait(j, (int) (jNanoTime2 - (1000000 * j)));
                return null;
            }
            C12385b c12385b4 = C12385b.f26070g;
            if (c12385b4 == null) {
                C12238m.throwNpe();
            }
            c12385b4.f26073j = c12385b2.f26073j;
            c12385b2.f26073j = null;
            return c12385b2;
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
            C12385b c12385bM10426a;
            while (true) {
                try {
                    synchronized (C12385b.class) {
                        c12385bM10426a = C12385b.f26071h.m10426a();
                        if (c12385bM10426a == C12385b.f26070g) {
                            C12385b.f26070g = null;
                            return;
                        }
                    }
                    if (c12385bM10426a != null) {
                        c12385bM10426a.mo10191l();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f26068e = millis;
        f26069f = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: renamed from: i */
    public final void m10424i() {
        C12385b c12385b;
        if (!(!this.f26072i)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long j = this.f26136d;
        boolean z2 = this.f26134b;
        if (j != 0 || z2) {
            this.f26072i = true;
            synchronized (C12385b.class) {
                if (f26070g == null) {
                    f26070g = new C12385b();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z2) {
                    this.f26074k = Math.min(j, mo10480c() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    this.f26074k = j + jNanoTime;
                } else {
                    if (!z2) {
                        throw new AssertionError();
                    }
                    this.f26074k = mo10480c();
                }
                long j2 = this.f26074k - jNanoTime;
                C12385b c12385b2 = f26070g;
                if (c12385b2 == null) {
                    C12238m.throwNpe();
                }
                while (true) {
                    c12385b = c12385b2.f26073j;
                    if (c12385b == null || j2 < c12385b.f26074k - jNanoTime) {
                        break;
                        break;
                    }
                    c12385b2 = c12385b;
                }
                this.f26073j = c12385b;
                c12385b2.f26073j = this;
                if (c12385b2 == f26070g) {
                    C12385b.class.notify();
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final boolean m10425j() {
        boolean z2 = false;
        if (!this.f26072i) {
            return false;
        }
        this.f26072i = false;
        synchronized (C12385b.class) {
            C12385b c12385b = f26070g;
            while (c12385b != null) {
                C12385b c12385b2 = c12385b.f26073j;
                if (c12385b2 == this) {
                    c12385b.f26073j = this.f26073j;
                    this.f26073j = null;
                } else {
                    c12385b = c12385b2;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* JADX INFO: renamed from: k */
    public IOException mo10296k(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: renamed from: l */
    public void mo10191l() {
    }
}
