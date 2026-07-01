package b.i.a.f.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import b.d.b.a.outline;
import b.i.a.f.h.j.f1;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"StaticFieldLeak"})
public final class f {
    public static volatile f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1331b;
    public final a c;
    public volatile f1 d;
    public Thread.UncaughtExceptionHandler e;

    public class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new b(null));
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new h(this, runnable, t);
        }
    }

    public static class b implements ThreadFactory {
        public static final AtomicInteger j = new AtomicInteger();

        public b(g gVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new c(runnable, outline.g(23, "measurement-", j.incrementAndGet()));
        }
    }

    public static class c extends Thread {
        public c(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public f(Context context) {
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null reference");
        this.f1331b = applicationContext;
        this.c = new a();
        new CopyOnWriteArrayList();
        new d();
    }

    public static void b() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void a(Runnable runnable) {
        this.c.submit(runnable);
    }
}
