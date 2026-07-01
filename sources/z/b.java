package z;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: BoltsExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f3858b;
    public final Executor c;

    public b() {
        ExecutorService executorServiceNewCachedThreadPool;
        String property = System.getProperty("java.runtime.name");
        if (property == null ? false : property.toLowerCase(Locale.US).contains("android")) {
            a aVar = a.a;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(a.c, a.d, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            executorServiceNewCachedThreadPool = threadPoolExecutor;
        } else {
            executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        }
        this.f3858b = executorServiceNewCachedThreadPool;
        Executors.newSingleThreadScheduledExecutor();
        this.c = new b$b(null);
    }
}
