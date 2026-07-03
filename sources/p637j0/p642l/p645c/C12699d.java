package p637j0.p642l.p645c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.l.c.d */
/* JADX INFO: compiled from: GenericScheduledExecutorService.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12699d implements InterfaceC12706k {

    /* JADX INFO: renamed from: a */
    public static final ScheduledExecutorService[] f27215a = new ScheduledExecutorService[0];

    /* JADX INFO: renamed from: b */
    public static final ScheduledExecutorService f27216b;

    /* JADX INFO: renamed from: c */
    public static final C12699d f27217c;

    /* JADX INFO: renamed from: d */
    public static int f27218d;

    /* JADX INFO: renamed from: e */
    public final AtomicReference<ScheduledExecutorService[]> f27219e = new AtomicReference<>(f27215a);

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f27216b = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f27217c = new C12699d();
    }

    public C12699d() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        iAvailableProcessors = iAvailableProcessors > 4 ? iAvailableProcessors / 2 : iAvailableProcessors;
        iAvailableProcessors = iAvailableProcessors > 8 ? 8 : iAvailableProcessors;
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[iAvailableProcessors];
        int i = 0;
        for (int i2 = 0; i2 < iAvailableProcessors; i2++) {
            scheduledExecutorServiceArr[i2] = Executors.newScheduledThreadPool(1, EnumC12700e.f27220j);
        }
        if (!this.f27219e.compareAndSet(f27215a, scheduledExecutorServiceArr)) {
            while (i < iAvailableProcessors) {
                scheduledExecutorServiceArr[i].shutdownNow();
                i++;
            }
        } else {
            while (i < iAvailableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i];
                if (!C12702g.m10804g(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    C12702g.m10803e((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i++;
            }
        }
    }

    @Override // p637j0.p642l.p645c.InterfaceC12706k
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.f27219e.get();
            scheduledExecutorServiceArr2 = f27215a;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!this.f27219e.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            C12702g.f27225l.remove(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }
}
