package j0.l.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.l.c.d, reason: use source file name */
/* JADX INFO: compiled from: GenericScheduledExecutorService.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GenericScheduledExecutorService implements SchedulerLifecycle {
    public static final ScheduledExecutorService[] a = new ScheduledExecutorService[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ScheduledExecutorService f3789b;
    public static final GenericScheduledExecutorService c;
    public static int d;
    public final AtomicReference<ScheduledExecutorService[]> e = new AtomicReference<>(a);

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f3789b = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        c = new GenericScheduledExecutorService();
    }

    public GenericScheduledExecutorService() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        iAvailableProcessors = iAvailableProcessors > 4 ? iAvailableProcessors / 2 : iAvailableProcessors;
        iAvailableProcessors = iAvailableProcessors > 8 ? 8 : iAvailableProcessors;
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[iAvailableProcessors];
        int i = 0;
        for (int i2 = 0; i2 < iAvailableProcessors; i2++) {
            scheduledExecutorServiceArr[i2] = Executors.newScheduledThreadPool(1, GenericScheduledExecutorServiceFactory.j);
        }
        if (!this.e.compareAndSet(a, scheduledExecutorServiceArr)) {
            while (i < iAvailableProcessors) {
                scheduledExecutorServiceArr[i].shutdownNow();
                i++;
            }
        } else {
            while (i < iAvailableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i];
                if (!NewThreadWorker.g(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    NewThreadWorker.e((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i++;
            }
        }
    }

    @Override // j0.l.c.SchedulerLifecycle
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.e.get();
            scheduledExecutorServiceArr2 = a;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!this.e.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            NewThreadWorker.l.remove(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }
}
