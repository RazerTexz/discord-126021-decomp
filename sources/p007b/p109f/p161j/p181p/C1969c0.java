package p007b.p109f.p161j.p181p;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.c0 */
/* JADX INFO: compiled from: JobScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1969c0 {

    /* JADX INFO: renamed from: a */
    public final Executor f3999a;

    /* JADX INFO: renamed from: b */
    public final c f4000b;

    /* JADX INFO: renamed from: e */
    public final int f4003e;

    /* JADX INFO: renamed from: c */
    public final Runnable f4001c = new a();

    /* JADX INFO: renamed from: d */
    public final Runnable f4002d = new b();

    /* JADX INFO: renamed from: f */
    @VisibleForTesting
    public C1919e f4004f = null;

    /* JADX INFO: renamed from: g */
    @VisibleForTesting
    public int f4005g = 0;

    /* JADX INFO: renamed from: h */
    @VisibleForTesting
    public int f4006h = 1;

    /* JADX INFO: renamed from: i */
    @VisibleForTesting
    public long f4007i = 0;

    /* JADX INFO: renamed from: j */
    @VisibleForTesting
    public long f4008j = 0;

    /* JADX INFO: renamed from: b.f.j.p.c0$a */
    /* JADX INFO: compiled from: JobScheduler.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1919e c1919e;
            int i;
            C1969c0 c1969c0 = C1969c0.this;
            Objects.requireNonNull(c1969c0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            synchronized (c1969c0) {
                c1919e = c1969c0.f4004f;
                i = c1969c0.f4005g;
                c1969c0.f4004f = null;
                c1969c0.f4005g = 0;
                c1969c0.f4006h = 3;
                c1969c0.f4008j = jUptimeMillis;
            }
            try {
                if (C1969c0.m1430e(c1919e, i)) {
                    c1969c0.f4000b.mo1436a(c1919e, i);
                }
            } finally {
                if (c1919e != null) {
                    c1919e.close();
                }
                c1969c0.m1433c();
            }
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.c0$b */
    /* JADX INFO: compiled from: JobScheduler.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1969c0 c1969c0 = C1969c0.this;
            c1969c0.f3999a.execute(c1969c0.f4001c);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.c0$c */
    /* JADX INFO: compiled from: JobScheduler.java */
    public interface c {
        /* JADX INFO: renamed from: a */
        void mo1436a(C1919e c1919e, int i);
    }

    public C1969c0(Executor executor, c cVar, int i) {
        this.f3999a = executor;
        this.f4000b = cVar;
        this.f4003e = i;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m1430e(C1919e c1919e, int i) {
        return AbstractC1965b.m1419e(i) || AbstractC1965b.m1422m(i, 4) || C1919e.m1338u(c1919e);
    }

    /* JADX INFO: renamed from: a */
    public void m1431a() {
        C1919e c1919e;
        synchronized (this) {
            c1919e = this.f4004f;
            this.f4004f = null;
            this.f4005g = 0;
        }
        if (c1919e != null) {
            c1919e.close();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1432b(long j) {
        Runnable runnable = this.f4002d;
        if (j <= 0) {
            runnable.run();
            return;
        }
        if (C1460d.f2217b == null) {
            C1460d.f2217b = Executors.newSingleThreadScheduledExecutor();
        }
        C1460d.f2217b.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: c */
    public final void m1433c() {
        boolean z2;
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            z2 = true;
            if (this.f4006h == 4) {
                jMax = Math.max(this.f4008j + ((long) this.f4003e), jUptimeMillis);
                this.f4007i = jUptimeMillis;
                this.f4006h = 2;
            } else {
                this.f4006h = 1;
                jMax = 0;
                z2 = false;
            }
        }
        if (z2) {
            m1432b(jMax - jUptimeMillis);
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m1434d() {
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z2 = false;
            if (!m1430e(this.f4004f, this.f4005g)) {
                return false;
            }
            int iM758h = C1563b.m758h(this.f4006h);
            if (iM758h != 0) {
                if (iM758h == 2) {
                    this.f4006h = 4;
                }
                jMax = 0;
            } else {
                jMax = Math.max(this.f4008j + ((long) this.f4003e), jUptimeMillis);
                this.f4007i = jUptimeMillis;
                this.f4006h = 2;
                z2 = true;
            }
            if (z2) {
                m1432b(jMax - jUptimeMillis);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: f */
    public boolean m1435f(C1919e c1919e, int i) {
        C1919e c1919e2;
        if (!m1430e(c1919e, i)) {
            return false;
        }
        synchronized (this) {
            c1919e2 = this.f4004f;
            this.f4004f = C1919e.m1336a(c1919e);
            this.f4005g = i;
        }
        if (c1919e2 == null) {
            return true;
        }
        c1919e2.close();
        return true;
    }
}
