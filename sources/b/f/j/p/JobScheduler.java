package b.f.j.p;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.j.j.EncodedImage2;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.f.j.p.c0, reason: use source file name */
/* JADX INFO: compiled from: JobScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class JobScheduler {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f606b;
    public final int e;
    public final Runnable c = new a();
    public final Runnable d = new b();

    @VisibleForTesting
    public EncodedImage2 f = null;

    @VisibleForTesting
    public int g = 0;

    @VisibleForTesting
    public int h = 1;

    @VisibleForTesting
    public long i = 0;

    @VisibleForTesting
    public long j = 0;

    /* JADX INFO: renamed from: b.f.j.p.c0$a */
    /* JADX INFO: compiled from: JobScheduler.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EncodedImage2 encodedImage2;
            int i;
            JobScheduler jobScheduler = JobScheduler.this;
            Objects.requireNonNull(jobScheduler);
            long jUptimeMillis = SystemClock.uptimeMillis();
            synchronized (jobScheduler) {
                encodedImage2 = jobScheduler.f;
                i = jobScheduler.g;
                jobScheduler.f = null;
                jobScheduler.g = 0;
                jobScheduler.h = 3;
                jobScheduler.j = jUptimeMillis;
            }
            try {
                if (JobScheduler.e(encodedImage2, i)) {
                    jobScheduler.f606b.a(encodedImage2, i);
                }
            } finally {
                if (encodedImage2 != null) {
                    encodedImage2.close();
                }
                jobScheduler.c();
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
            JobScheduler jobScheduler = JobScheduler.this;
            jobScheduler.a.execute(jobScheduler.c);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.c0$c */
    /* JADX INFO: compiled from: JobScheduler.java */
    public interface c {
        void a(EncodedImage2 encodedImage2, int i);
    }

    public JobScheduler(Executor executor, c cVar, int i) {
        this.a = executor;
        this.f606b = cVar;
        this.e = i;
    }

    public static boolean e(EncodedImage2 encodedImage2, int i) {
        return BaseConsumer.e(i) || BaseConsumer.m(i, 4) || EncodedImage2.u(encodedImage2);
    }

    public void a() {
        EncodedImage2 encodedImage2;
        synchronized (this) {
            encodedImage2 = this.f;
            this.f = null;
            this.g = 0;
        }
        if (encodedImage2 != null) {
            encodedImage2.close();
        }
    }

    public final void b(long j) {
        Runnable runnable = this.d;
        if (j <= 0) {
            runnable.run();
            return;
        }
        if (AnimatableValueParser.f329b == null) {
            AnimatableValueParser.f329b = Executors.newSingleThreadScheduledExecutor();
        }
        AnimatableValueParser.f329b.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public final void c() {
        boolean z2;
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            z2 = true;
            if (this.h == 4) {
                jMax = Math.max(this.j + ((long) this.e), jUptimeMillis);
                this.i = jUptimeMillis;
                this.h = 2;
            } else {
                this.h = 1;
                jMax = 0;
                z2 = false;
            }
        }
        if (z2) {
            b(jMax - jUptimeMillis);
        }
    }

    public boolean d() {
        long jMax;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z2 = false;
            if (!e(this.f, this.g)) {
                return false;
            }
            int iH = b.c.a.y.b.h(this.h);
            if (iH != 0) {
                if (iH == 2) {
                    this.h = 4;
                }
                jMax = 0;
            } else {
                jMax = Math.max(this.j + ((long) this.e), jUptimeMillis);
                this.i = jUptimeMillis;
                this.h = 2;
                z2 = true;
            }
            if (z2) {
                b(jMax - jUptimeMillis);
            }
            return true;
        }
    }

    public boolean f(EncodedImage2 encodedImage2, int i) {
        EncodedImage2 encodedImage3;
        if (!e(encodedImage2, i)) {
            return false;
        }
        synchronized (this) {
            encodedImage3 = this.f;
            this.f = EncodedImage2.a(encodedImage2);
            this.g = i;
        }
        if (encodedImage3 == null) {
            return true;
        }
        encodedImage3.close();
        return true;
    }
}
