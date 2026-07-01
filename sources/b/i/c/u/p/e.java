package b.i.c.u.p;

import androidx.annotation.GuardedBy;
import b.i.c.u.n;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: RequestLimiter.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final long a = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f1792b = TimeUnit.MINUTES.toMillis(30);
    public final n c = n.c();

    @GuardedBy("this")
    public long d;

    @GuardedBy("this")
    public int e;

    public synchronized boolean a() {
        return this.e == 0 || this.c.a() > this.d;
    }

    public synchronized void b(int i) {
        long jMin;
        boolean z2 = false;
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            synchronized (this) {
                this.e = 0;
            }
            return;
        }
        this.e++;
        synchronized (this) {
            if (i == 429 || (i >= 500 && i < 600)) {
                z2 = true;
            }
            try {
                if (z2) {
                    double dPow = Math.pow(2.0d, this.e);
                    Objects.requireNonNull(this.c);
                    jMin = (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), f1792b);
                } else {
                    jMin = a;
                }
                this.d = this.c.a() + jMin;
            } catch (Throwable th) {
                throw th;
            }
        }
        return;
        throw th;
    }
}
