package z;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: z.b, reason: use source file name */
/* JADX INFO: compiled from: BoltsExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public final class BoltsExecutors {
    public static final BoltsExecutors a = new BoltsExecutors();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f3858b;
    public final Executor c;

    /* JADX INFO: renamed from: z.b$b */
    /* JADX INFO: compiled from: BoltsExecutors.java */
    public static class b implements Executor {
        public ThreadLocal<Integer> j = new ThreadLocal<>();

        public b(a aVar) {
        }

        public final int a() {
            Integer num = this.j.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                this.j.remove();
            } else {
                this.j.set(Integer.valueOf(iIntValue));
            }
            return iIntValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Integer num = this.j.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() + 1;
            this.j.set(Integer.valueOf(iIntValue));
            try {
                if (iIntValue <= 15) {
                    runnable.run();
                } else {
                    BoltsExecutors.a.f3858b.execute(runnable);
                }
                a();
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
    }

    public BoltsExecutors() {
        ExecutorService executorServiceNewCachedThreadPool;
        String property = System.getProperty("java.runtime.name");
        if (property == null ? false : property.toLowerCase(Locale.US).contains("android")) {
            AndroidExecutors androidExecutors = AndroidExecutors.a;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AndroidExecutors.c, AndroidExecutors.d, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            executorServiceNewCachedThreadPool = threadPoolExecutor;
        } else {
            executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        }
        this.f3858b = executorServiceNewCachedThreadPool;
        Executors.newSingleThreadScheduledExecutor();
        this.c = new b(null);
    }
}
